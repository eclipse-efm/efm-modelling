/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command;

import org.eclipse.efm.modeling.formalml.TimedTransition;
import org.eclipse.efm.modeling.formalml.helpers.StereotypeUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;

public class UpdateTransitionCommand extends AbstractUpdateCommand {

	private static final String CONSTRAINT_XLIA_GUARD = "xLIA guard";


	protected Transition fTransitionContext;

	public UpdateTransitionCommand(Transition transitionContext,
			String newTransitionText, String oldTransitionText) {
		super(transitionContext, newTransitionText, oldTransitionText);

		fTransitionContext = transitionContext;
	}


	protected boolean compile() {
		if( this.fNewEditedText != null ) {
//			Model root = fTransitionContext.getModel();
//			if( root != null ) {
//				return true;
//			}

			return true;
		}

		return false ;
	}

	protected boolean merge() {
		System.out.println("Begin doExecuteWithResult Transition !!!");

		// TRIGGER
		String xliaTrigger = extractTrigger(this.fNewEditedText);
		String oldTrigger  = extractTrigger(this.fOldEditedText);
		if( (oldTrigger != xliaTrigger) && ( (oldTrigger == null) ||
				(! oldTrigger.equals(xliaTrigger))) ) {
			// remove/destroy old effect.
			// - Events associated with triggers of this fTransitionContext
			for (Trigger t : fTransitionContext.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				if (UML2Util.getNonNavigableInverseReferences(e).size() == 0) {
					// no trigger is referencing the event any more, delete call event
					e.destroy();
				}
			}
			// - Triggers owned by this fTransitionContext
			fTransitionContext.getTriggers()
					.removeAll(fTransitionContext.getTriggers());

			// Create the new triggers
//			if (transitionRuleObject.getTriggers() != null) {
//				List<Trigger> newTriggers = new ArrayList<Trigger>();
//				for (EventRule eventRule : transitionRuleObject.getTriggers()) {
//					Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
//					newTriggers.add(newTrigger);
//					newTrigger.setEvent(createUMLEvent(eventRule));
//				}
//				fTransitionContext.getTriggers().addAll(newTriggers);
//			}
		}

		// GUARD
		// - Guard associated with the fTransitionContext
		String xliaConstraint = extractGuard(this.fNewEditedText);
		String oldConstraint  = extractGuard(this.fOldEditedText);
		if( (oldConstraint != xliaConstraint) && ( (oldConstraint == null) ||
			(! oldConstraint.equals(xliaConstraint))) ) {
			// remove/destroy old guard.
			Constraint guard = fTransitionContext.getGuard();
			fTransitionContext.setGuard(null);
			if (guard != null) {
				guard.destroy();
			}

			// Create the new constraint
//			if( (transitionRuleObject.getGuard() != null) &&
//				(transitionRuleObject.getGuard().getConstraint() != null) ) {
			if( xliaConstraint != null ) {
				Constraint newConstraint =
						fTransitionContext.createGuard(CONSTRAINT_XLIA_GUARD);
				OpaqueExpression guardSpecification =
						UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().add(
						StereotypeUtil.XLIA_LANGUAGE);

				guardSpecification.getBodies().add( xliaConstraint );

				newConstraint.setSpecification(guardSpecification);
			}
		}

		// TGUARD
		// - Timed Guard associated with the fTransitionContext stereotype
		xliaConstraint = extractTimedGuard(this.fNewEditedText);
		oldConstraint  = extractTimedGuard(this.fOldEditedText);
		if( (oldConstraint != xliaConstraint) && ( (oldConstraint == null) ||
			(! oldConstraint.equals(xliaConstraint))) ) {
			// remove/destroy old tguard.
			TimedTransition timedTransition =
					StereotypeUtil.getTimedTransition(fTransitionContext);
			if( timedTransition != null ) {
				timedTransition.setTguard(null);

				xliaConstraint = extractTimedGuard(this.fNewEditedText);
				if( xliaConstraint != null ) {
					Constraint constraint =
							UMLFactory.eINSTANCE.createConstraint();
					constraint.setName("xLIA tguard");

					OpaqueExpression tguardSpecification =
							UMLFactory.eINSTANCE.createOpaqueExpression();
					tguardSpecification.getLanguages().add(
							StereotypeUtil.XLIA_LANGUAGE);

					tguardSpecification.getBodies().add( xliaConstraint );

					constraint.setSpecification(tguardSpecification);

					timedTransition.setTguard(constraint);
				}
			}
		}

		// EFFECT
		String xliaBehavior = extractEffect(this.fNewEditedText);
		String oldBehavior  = extractEffect(this.fOldEditedText);
		if( (oldBehavior != xliaBehavior) && ( (oldBehavior == null) ||
				(! oldBehavior.equals(xliaBehavior))) ) {
			// remove/destroy old effect.
			Behavior effect = fTransitionContext.getEffect();
			fTransitionContext.setEffect(null);
			if (effect != null) {
				effect.destroy();
			}

			// Create the new behavior ?
			if( xliaBehavior != null ) {
				// behavior does exist yet => create
				OpaqueBehavior newEffectBehavior =
						UMLFactory.eINSTANCE.createOpaqueBehavior();
				newEffectBehavior.setName("xLIA effect");

				newEffectBehavior.getLanguages().add(
						StereotypeUtil.XLIA_LANGUAGE);

				newEffectBehavior.getBodies().add( xliaBehavior );

				fTransitionContext.setEffect(newEffectBehavior);
			}
		}

		System.out.println("End Commit Transition !!!");

		return true;
	}


	////////////////////////////////////////////////////////////////////////////
	// xLIA TEXT EXTRACTION UTILS
	////////////////////////////////////////////////////////////////////////////

	protected final String[] TRIGGER_BEGIN_MARK = { "@trigger:" };
	protected final String[] TRIGGER_END_MARKS  =
			{ "@guard:" , "@tguard:" , "@effect:" ,
					"} -->" , "} // end transition" };

	protected String extractTrigger(String editedText) {
		String xliaConstraint = "commit< guard xLIA textual constraint >";

		xliaConstraint = extractXliaCode(
				editedText, 0, TRIGGER_BEGIN_MARK, TRIGGER_END_MARKS);

		return( xliaConstraint );
	}

	protected final String[] GUARD_BEGIN_MARK = { "@guard:" };
	protected final String[] GUARD_END_MARKS  =
			{ "@tguard:" , "@effect:" , "} -->" , "} // end transition" };

	protected String extractGuard(String editedText) {
		String xliaConstraint = "commit< guard xLIA textual constraint >";

		xliaConstraint = extractXliaCode(
				editedText, 0, GUARD_BEGIN_MARK, GUARD_END_MARKS);

		return( xliaConstraint );
	}


	protected final String[] TGUARD_BEGIN_MARK = { "@tguard:" };
	protected final String[] TGUARD_END_MARKS  =
			{ "@effect:" , "} -->" , "} // end transition" };

	protected String extractTimedGuard(String editedText) {
		String xliaConstraint = "commit< tguard xLIA textual constraint >";

		xliaConstraint = extractXliaCode(
				editedText, 0, TGUARD_BEGIN_MARK, TGUARD_END_MARKS);

		return( xliaConstraint );
	}


	protected final String[] EFFECT_BEGIN_MARK = { "@effect:" };
	protected final String[] EFFECT_END_MARKS  = { "} -->" , "} // end transition" };

	protected String extractEffect(String editedText) {
		String xliaBehavior = "commit< effect xLIA textual behavior >";

		xliaBehavior = extractXliaCode(
				editedText, 0, EFFECT_BEGIN_MARK, EFFECT_END_MARKS);

		return( xliaBehavior );
	}


}
