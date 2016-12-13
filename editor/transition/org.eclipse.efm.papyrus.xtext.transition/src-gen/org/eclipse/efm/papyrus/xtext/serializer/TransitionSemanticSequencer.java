/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
package org.eclipse.efm.papyrus.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.efm.papyrus.xtext.services.TransitionGrammarAccess;
import org.eclipse.efm.papyrus.xtext.transition.GuardRule;
import org.eclipse.efm.papyrus.xtext.transition.ReceiveSignalEventRule;
import org.eclipse.efm.papyrus.xtext.transition.TGuardRule;
import org.eclipse.efm.papyrus.xtext.transition.TransitionPackage;
import org.eclipse.efm.papyrus.xtext.transition.TransitionRule;
import org.eclipse.efm.papyrus.xtext.transition.TriggerRule;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TransitionSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TransitionGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TransitionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TransitionPackage.GUARD_RULE:
				sequence_GuardRule(context, (GuardRule) semanticObject); 
				return; 
			case TransitionPackage.RECEIVE_SIGNAL_EVENT_RULE:
				sequence_ReceiveSignalEventRule(context, (ReceiveSignalEventRule) semanticObject); 
				return; 
			case TransitionPackage.TGUARD_RULE:
				sequence_TGuardRule(context, (TGuardRule) semanticObject); 
				return; 
			case TransitionPackage.TRANSITION_RULE:
				sequence_TransitionRule(context, (TransitionRule) semanticObject); 
				return; 
			case TransitionPackage.TRIGGER_RULE:
				sequence_TriggerRule(context, (TriggerRule) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     GuardRule returns GuardRule
	 *
	 * Constraint:
	 *     constraint=STRING
	 */
	protected void sequence_GuardRule(ISerializationContext context, GuardRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransitionPackage.Literals.GUARD_RULE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransitionPackage.Literals.GUARD_RULE__CONSTRAINT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0(), semanticObject.getConstraint());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     EventRule returns ReceiveSignalEventRule
	 *     ReceiveSignalEventRule returns ReceiveSignalEventRule
	 *
	 * Constraint:
	 *     (parameters+=[Property|FQN] parameters+=[Property|FQN]*)?
	 */
	protected void sequence_ReceiveSignalEventRule(ISerializationContext context, ReceiveSignalEventRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TGuardRule returns TGuardRule
	 *
	 * Constraint:
	 *     constraint=STRING
	 */
	protected void sequence_TGuardRule(ISerializationContext context, TGuardRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransitionPackage.Literals.TGUARD_RULE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransitionPackage.Literals.TGUARD_RULE__CONSTRAINT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0(), semanticObject.getConstraint());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransitionRule returns TransitionRule
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             triggers+=TriggerRule 
	 *             triggers+=TriggerRule* 
	 *             ((guard=GuardRule? tguard=TGuardRule effectBody=STRING) | (guard=GuardRule? effectBody=STRING) | effectBody=STRING)
	 *         ) | 
	 *         (guard=GuardRule? tguard=TGuardRule effectBody=STRING) | 
	 *         (guard=GuardRule? effectBody=STRING) | 
	 *         effectBody=STRING
	 *     )?
	 */
	protected void sequence_TransitionRule(ISerializationContext context, TransitionRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TriggerRule returns TriggerRule
	 *
	 * Constraint:
	 *     (port=[NamedElement|FQN] event=EventRule?)
	 */
	protected void sequence_TriggerRule(ISerializationContext context, TriggerRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
