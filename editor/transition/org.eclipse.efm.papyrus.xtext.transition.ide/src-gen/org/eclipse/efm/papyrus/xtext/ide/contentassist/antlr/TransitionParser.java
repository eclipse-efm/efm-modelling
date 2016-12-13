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
package org.eclipse.efm.papyrus.xtext.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.efm.papyrus.xtext.ide.contentassist.antlr.internal.InternalTransitionParser;
import org.eclipse.efm.papyrus.xtext.services.TransitionGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class TransitionParser extends AbstractContentAssistParser {

	@Inject
	private TransitionGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalTransitionParser createParser() {
		InternalTransitionParser result = new InternalTransitionParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getFQNAccess().getAlternatives_1_0(), "rule__FQN__Alternatives_1_0");
					put(grammarAccess.getTransitionRuleAccess().getGroup(), "rule__TransitionRule__Group__0");
					put(grammarAccess.getTransitionRuleAccess().getGroup_0(), "rule__TransitionRule__Group_0__0");
					put(grammarAccess.getTransitionRuleAccess().getGroup_0_1(), "rule__TransitionRule__Group_0_1__0");
					put(grammarAccess.getTransitionRuleAccess().getGroup_3(), "rule__TransitionRule__Group_3__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getTriggerRuleAccess().getGroup(), "rule__TriggerRule__Group__0");
					put(grammarAccess.getReceiveSignalEventRuleAccess().getGroup(), "rule__ReceiveSignalEventRule__Group__0");
					put(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2(), "rule__ReceiveSignalEventRule__Group_2__0");
					put(grammarAccess.getReceiveSignalEventRuleAccess().getGroup_2_1(), "rule__ReceiveSignalEventRule__Group_2_1__0");
					put(grammarAccess.getGuardRuleAccess().getGroup(), "rule__GuardRule__Group__0");
					put(grammarAccess.getTGuardRuleAccess().getGroup(), "rule__TGuardRule__Group__0");
					put(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_0(), "rule__TransitionRule__TriggersAssignment_0_0");
					put(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_0_1_1(), "rule__TransitionRule__TriggersAssignment_0_1_1");
					put(grammarAccess.getTransitionRuleAccess().getGuardAssignment_1(), "rule__TransitionRule__GuardAssignment_1");
					put(grammarAccess.getTransitionRuleAccess().getTguardAssignment_2(), "rule__TransitionRule__TguardAssignment_2");
					put(grammarAccess.getTransitionRuleAccess().getEffectBodyAssignment_3_1(), "rule__TransitionRule__EffectBodyAssignment_3_1");
					put(grammarAccess.getTriggerRuleAccess().getPortAssignment_1(), "rule__TriggerRule__PortAssignment_1");
					put(grammarAccess.getTriggerRuleAccess().getEventAssignment_2(), "rule__TriggerRule__EventAssignment_2");
					put(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_0(), "rule__ReceiveSignalEventRule__ParametersAssignment_2_0");
					put(grammarAccess.getReceiveSignalEventRuleAccess().getParametersAssignment_2_1_1(), "rule__ReceiveSignalEventRule__ParametersAssignment_2_1_1");
					put(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1(), "rule__GuardRule__ConstraintAssignment_1");
					put(grammarAccess.getTGuardRuleAccess().getConstraintAssignment_1(), "rule__TGuardRule__ConstraintAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalTransitionParser typedParser = (InternalTransitionParser) parser;
			typedParser.entryRuleTransitionRule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TransitionGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TransitionGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
