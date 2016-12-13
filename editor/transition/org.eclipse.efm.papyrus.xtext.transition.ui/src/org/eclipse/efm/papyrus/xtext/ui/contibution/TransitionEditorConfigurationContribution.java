/**
 * ****************************************************************************
 * * Copyright (c) 2016 CEA LIST.
 * *
 * * All rights reserved. This program and the accompanying materials
 * * are made available under the terms of the Eclipse Public License v1.0
 * * which accompanies this distribution, and is available at
 * * http://www.eclipse.org/legal/epl-v10.html
 * *
 * * Contributors:
 * *  Xavier ZEITOUN (CEA LIST) xavier.zeitoun@cea.fr
 * *  - Initial API and implementation
 * ****************************************************************************/

package org.eclipse.efm.papyrus.xtext.ui.contibution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.efm.formalml.util.PrintingUtil;
import org.eclipse.efm.papyrus.xtext.transition.TransitionRule;
import org.eclipse.efm.papyrus.xtext.transition.TriggerRule;
import org.eclipse.efm.papyrus.xtext.transition.ui.internal.TransitionActivator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;

import com.google.inject.Injector;

public class TransitionEditorConfigurationContribution
		extends DefaultXtextDirectEditorConfiguration
		implements ICustomDirectEditorConfiguration {
	private static final String EMPTY = ""; //$NON-NLS-1$
	private final static String EVENTS = "events"; //$NON-NLS-1$

	/**
	 * Override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.MULTI | SWT.WRAP;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Transition) {

			return PrintingUtil.printTransition((Transition)editedObject);
		}

		return "not a valid DTransition";
	}


	/**
	 * @author CEA LIST
	 *
	 *         A command for updating the context UML model
	 */
	public class UpdateUMLTransitionCommand extends AbstractTransactionalCommand {

		private static final String ANY = "any"; //$NON-NLS-1$

		private static final String NATURAL_LANGUAGE = "Natural language"; //$NON-NLS-1$

		private final Transition transition;

		private final TransitionRule transitionRuleObject;

		private List<Trigger> newTriggers = new ArrayList<Trigger>();

		private Constraint newConstraint = null;

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			String oldBody = null;
			// - Events associated with triggers of this transition
			for (Trigger t : transition.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				if(e!=null){
					Collection<Setting> set = UML2Util.getNonNavigableInverseReferences(e);
					if (UML2Util.getNonNavigableInverseReferences(e).size() <= 1) {
						// no trigger is referencing the event any more, delete call event
						e.destroy();
					}
				}
			}
			// - Triggers owned by this transition
			transition.getTriggers().removeAll(transition.getTriggers());
			// - Guard associated with the transition
			Constraint guard = transition.getGuard();
			transition.setGuard(null);
			if (guard != null) {
				guard.destroy();
			}

			// ////////////////////////////////////////////////////////////////////////////////////////////////
			// Then extract any relevant information from the TransitionRuleObject, and update the Transition
			// ////////////////////////////////////////////////////////////////////////////////////////////////

			// Create the new triggers
			if (transitionRuleObject != null) {
				if (transitionRuleObject.getTriggers() != null) {
//					int i=1;
					for (TriggerRule triggerRule : transitionRuleObject.getTriggers()) {
						Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
						NamedElement element = triggerRule.getPort();
						if( element instanceof Port ) {
							newTrigger.getPorts().add((Port)(triggerRule.getPort()));
							this.newTriggers.add(newTrigger);

//							EventRule eventRule = triggerRule.getEvent();
//							Event newEvent = createDiversityEvent(eventRule);
//							newTrigger.setEvent(newEvent);
//							newTrigger.setName("Trigger"+i);
						}
						else if( element instanceof Signal ) {
							// TODO by BB
						}

//						i++;
					}
					transition.getTriggers().addAll(this.newTriggers);
				}
				// Create the new constraint
				if (transitionRuleObject.getGuard() != null && transitionRuleObject.getGuard().getConstraint() != null) {
					this.newConstraint = transition.createGuard(EMPTY);
					OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
					guardSpecification.getLanguages().add(NATURAL_LANGUAGE);
					guardSpecification.getBodies().add(EMPTY + transitionRuleObject.getGuard().getConstraint());
					this.newConstraint.setSpecification(guardSpecification);
					this.newConstraint.setName("guard");
				}

				boolean hasEffectBody= transitionRuleObject.getEffectBody()!=null;
				if(transition.getEffect() instanceof OpaqueBehavior)
					oldBody = ((OpaqueBehavior)transition.getEffect()).getBodies().get(0);

				if ((!hasEffectBody) || !(transitionRuleObject.getEffectBody().equals(oldBody))) {
					// delete owned effect behavior
					Behavior effect = transition.getEffect();
					transition.setEffect(null);
					if (effect != null) {
						effect.destroy();
					}
				}

				// Create the new behavior
				if (hasEffectBody) {
					if (transition.getEffect() == null) {
						// behavior does exist yet => create
						Behavior newEffectBehavior = createXLIAOpaqueBehavior(transitionRuleObject.getEffectBody());
						transition.setEffect(newEffectBehavior);

					}
				}
			} else {
				// no effect, remove it.
				Behavior effect = transition.getEffect();
				transition.setEffect(null);
				if (effect != null) {
					effect.destroy();
				}
			}

			return CommandResult.newOKCommandResult(transition);
		}

//		private Event createDiversityEvent(EventRule eventRule) {
//			AnyReceiveEvent anyEvent = UMLFactory.eINSTANCE.createAnyReceiveEvent();
//			getEventPackage().getPackagedElements().add(anyEvent);
//			int dEventCount = getDEventCount();
//			anyEvent.setName("DivEvent"+dEventCount);
//			StereotypeApplicationHelper stereotypeApplicationHelper = StereotypeApplicationHelper.getInstance(null);
//			ReceiveAnyEvent e = (ReceiveAnyEvent) stereotypeApplicationHelper.applyStereotype(anyEvent, DiversityPackage.eINSTANCE.getReceiveEvent());
//			e.getParameters().addAll(((ReceiveSignalEventRule)eventRule).getParameters());
//			return anyEvent;
//		}
//
//		private int getDEventCount() {
//			Package eventPackage = getEventPackage();
//			int count = 0;
//			for(PackageableElement e : eventPackage.getPackagedElements()){
//				if(DiversityStereotype.getReceiveEvent(e)!=null) {
//					count++;
//				}
//			}
//			return count;
//		}

		private Behavior createXLIAOpaqueBehavior(String effectBody) {
			OpaqueBehavior b = UMLFactory.eINSTANCE.createOpaqueBehavior();
			b.getLanguages().add("XLIA");
			b.getBodies().add(effectBody);
			b.setName("effect");
			return b;
		}

		/**
		 * put events in a sub-directory of the nearest package
		 *
		 * @return the resulting package
		 */
		protected Package getEventPackage() {
			Package np = transition.getNearestPackage();
			for (int i = 0;; i++) {
				String name = EVENTS;
				if (i > 0) {
					name += i;
				}
				PackageableElement ep = np.getPackagedElement(name);
				if (ep instanceof Package) {
					return (Package) ep;
				} else if (ep == null) {
					// does not exist, create
					return np.createNestedPackage(name);
				}
				// exists, but is not a package, try again with different name ...
			}
		}


		public UpdateUMLTransitionCommand(TransactionalEditingDomain domain, Transition transition, TransitionRule transitionRule) {
			super(domain, "Transition Update", getWorkspaceFiles(transition)); //$NON-NLS-1$
			this.transition = transition;
			this.transitionRuleObject = transitionRule;
		}
	}

	@Override
	public Injector getInjector() {
		return TransitionActivator.getInstance().getInjector(TransitionActivator.ORG_ECLIPSE_EFM_PAPYRUS_XTEXT_TRANSITION);
	}

	@Override
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {

		if (!(modelObject instanceof Transition)) {
			return null;
		}

		Transition transition = (Transition) modelObject;

		TransitionRule transitionRuleObject = (TransitionRule) xtextObject;
		// transitionRuleObject may be null, if we have no input left

		// Creates and executes the update command
		try {
			TransactionalEditingDomain dom = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(transition);
			UpdateUMLTransitionCommand updateCommand = new UpdateUMLTransitionCommand(dom, transition, transitionRuleObject);
			return updateCommand;
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
