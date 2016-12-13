/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.efm.papyrus.view.property.concretesyntax.ActivatorXLIAProperties;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;

public class UpdateTransitionTransactionalCommand extends AbstractTransactionalCommand implements Command {

	protected static final String EMPTY = ""; //$NON-NLS-1$
	protected final static String EVENTS = "events"; //$NON-NLS-1$

	protected static final String TGUARD = "tguard";


	protected static final String ANY = "any"; //$NON-NLS-1$

	protected static final String NATURAL_LANGUAGE = "Natural language"; //$NON-NLS-1$

	protected final Transition transition;

	protected List<Trigger> newTriggers = new ArrayList<Trigger>();

	protected Constraint newConstraint = null;


	public UpdateTransitionTransactionalCommand(TransactionalEditingDomain domain, Transition transition) {
		super(domain, "Transition Update", getWorkspaceFiles(transition));
		this.transition = transition;
	}

	@Override
	protected CommandResult doExecuteWithResult(
			IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		System.out.println("Begin doExecuteWithResult Transition !!!");

		// - Events associated with triggers of this transition
		for (Trigger t : transition.getTriggers()) {
			Event e = t.getEvent();
			t.setEvent(null);
			if (UML2Util.getNonNavigableInverseReferences(e).size() == 0) {
				// no trigger is referencing the event any more, delete call event
				e.destroy();
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
//		if (transitionRuleObject != null) {
//			if (transitionRuleObject.getTriggers() != null) {
//				for (EventRule eventRule : transitionRuleObject.getTriggers()) {
//					Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
//					this.newTriggers.add(newTrigger);
//					newTrigger.setEvent(createUMLEvent(eventRule));
//				}
//				transition.getTriggers().addAll(this.newTriggers);
//			}
//			// Create the new constraint
//			if (transitionRuleObject.getGuard() != null && transitionRuleObject.getGuard().getConstraint() != null) {
//				this.newConstraint = transition.createGuard(EMPTY);
//				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
//				guardSpecification.getLanguages().add(XLIA_LANGUAGE);
//				guardSpecification.getBodies().add(EMPTY + transitionRuleObject.getGuard().getConstraint());
//				this.newConstraint.setSpecification(guardSpecification);
//			}
//
//
//			// - Timed Guard associated with the transition stereotype
//			org.eclipse.diversity.Transition diversityTransition =
//					DiversityStereotype.getTransition(transition);
//			if( diversityTransition != null ) {
//				Constraint constraint = UMLFactory.eINSTANCE.createConstraint();
//				constraint.setName("tguardConstraint");
//
//				OpaqueExpression tguardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
//				tguardSpecification.getLanguages().add(XLIA_LANGUAGE);
//
////				tguardSpecification.getBodies().add(EMPTY + transitionRuleObject.getTguard().getConstraint());
//
//
//				/*Expression*/ String tguard = transitionRuleObject.getTguard().getConstraint();
//
//
////				Injector injector = Guice.createInjector(new  XLIARuntimeModule());
////				ISerializer serializer = injector.getInstance(ISerializer.class);
////
////				String s = serializer.serialize(tguard);
////				tguardSpecification.getBodies().add(EMPTY + s);
//
//				tguardSpecification.getBodies().add(EMPTY +
//						"\"" + tguard + "\"" );
//
////				tguardSpecification.getBodies().add(EMPTY +
////						"\"" + ((LiteralStringExpression)tguard.getLeftOperand()).getValue() + "\" < " +
////						"\"" + ((LiteralStringExpression)tguard.getRigthOperand()).getValue() + "\"" );
//
//
//				constraint.setSpecification(tguardSpecification);
//
//				diversityTransition.setTguard(constraint);
//			}
//
//
//
//			boolean hasEffect = transitionRuleObject.getEffect() != null && transitionRuleObject.getEffect().getKind() != null && transitionRuleObject.getEffect().getBehaviorName() != null;
//			BehaviorKind oldKind = getBehaviorKind(transition.getEffect());
//
//			if ((!hasEffect) || (transitionRuleObject.getEffect().getKind() != oldKind)) {
//				// delete owned effect behavior
//				Behavior effect = transition.getEffect();
//				transition.setEffect(null);
//				if (effect != null) {
//					effect.destroy();
//				}
//			}
//
//			// Create the new behavior
//			if (hasEffect) {
//				String behaviorName = transitionRuleObject.getEffect().getBehaviorName();
//				if (transition.getEffect() == null) {
//					// behavior does exist yet => create
//					Behavior newEffectBehavior = createUMLBehavior(transitionRuleObject.getEffect().getKind(), behaviorName);
//					transition.setEffect(newEffectBehavior);
//				} else {
//					transition.getEffect().setName(behaviorName);
//				}
//			}
//		}
//		else {
//			// no effect, remove it.
//			Behavior effect = transition.getEffect();
//			transition.setEffect(null);
//			if (effect != null) {
//				effect.destroy();
//			}
//		}

		System.out.println("End doExecuteWithResult Transition !!!");

		return CommandResult.newOKCommandResult(transition);
	}


	public static ICommand getCommand(Transition transition) {
		// Creates and executes the update command
		try {
			TransactionalEditingDomain dom = ServiceUtilsForEObject.
					getInstance().getTransactionalEditingDomain(transition);

			UpdateTransitionTransactionalCommand updateCommand =
					new UpdateTransitionTransactionalCommand(dom, transition);

			return updateCommand;
		}
		catch (ServiceException ex) {
			ActivatorXLIAProperties.log.error(ex);

			return null;
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAffectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command chain(Command command) {
		// TODO Auto-generated method stub
		return null;
	}



}
