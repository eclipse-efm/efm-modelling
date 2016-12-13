package org.eclipse.efm.papyrus.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.efm.papyrus.xtext.services.TransitionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
@SuppressWarnings("all")
public class InternalTransitionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'/'", "'.'", "'::'", "'input'", "'('", "')'", "'['", "']'", "'{'", "'}'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTransitionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTransitionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTransitionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTransition.g"; }



     	private TransitionGrammarAccess grammarAccess;

        public InternalTransitionParser(TokenStream input, TransitionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TransitionRule";
       	}

       	@Override
       	protected TransitionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTransitionRule"
    // InternalTransition.g:73:1: entryRuleTransitionRule returns [EObject current=null] : iv_ruleTransitionRule= ruleTransitionRule EOF ;
    public final EObject entryRuleTransitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionRule = null;


        try {
            // InternalTransition.g:73:55: (iv_ruleTransitionRule= ruleTransitionRule EOF )
            // InternalTransition.g:74:2: iv_ruleTransitionRule= ruleTransitionRule EOF
            {
             newCompositeNode(grammarAccess.getTransitionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionRule=ruleTransitionRule();

            state._fsp--;

             current =iv_ruleTransitionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionRule"


    // $ANTLR start "ruleTransitionRule"
    // InternalTransition.g:80:1: ruleTransitionRule returns [EObject current=null] : ( ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_tguard_4_0= ruleTGuardRule ) )? (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleTransitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        Token lv_effectBody_6_0=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;

        EObject lv_guard_3_0 = null;

        EObject lv_tguard_4_0 = null;



        	enterRule();

        try {
            // InternalTransition.g:86:2: ( ( ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_tguard_4_0= ruleTGuardRule ) )? (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )? ) )
            // InternalTransition.g:87:2: ( ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_tguard_4_0= ruleTGuardRule ) )? (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )? )
            {
            // InternalTransition.g:87:2: ( ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_tguard_4_0= ruleTGuardRule ) )? (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )? )
            // InternalTransition.g:88:3: ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_tguard_4_0= ruleTGuardRule ) )? (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )?
            {
            // InternalTransition.g:88:3: ( ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTransition.g:89:4: ( (lv_triggers_0_0= ruleTriggerRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )*
                    {
                    // InternalTransition.g:89:4: ( (lv_triggers_0_0= ruleTriggerRule ) )
                    // InternalTransition.g:90:5: (lv_triggers_0_0= ruleTriggerRule )
                    {
                    // InternalTransition.g:90:5: (lv_triggers_0_0= ruleTriggerRule )
                    // InternalTransition.g:91:6: lv_triggers_0_0= ruleTriggerRule
                    {

                    						newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_triggers_0_0=ruleTriggerRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    						}
                    						add(
                    							current,
                    							"triggers",
                    							lv_triggers_0_0,
                    							"org.eclipse.efm.papyrus.xtext.Transition.TriggerRule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTransition.g:108:4: (otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalTransition.g:109:5: otherlv_1= ',' ( (lv_triggers_2_0= ruleTriggerRule ) )
                    	    {
                    	    otherlv_1=(Token)match(input,11,FOLLOW_4); 

                    	    					newLeafNode(otherlv_1, grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());
                    	    				
                    	    // InternalTransition.g:113:5: ( (lv_triggers_2_0= ruleTriggerRule ) )
                    	    // InternalTransition.g:114:6: (lv_triggers_2_0= ruleTriggerRule )
                    	    {
                    	    // InternalTransition.g:114:6: (lv_triggers_2_0= ruleTriggerRule )
                    	    // InternalTransition.g:115:7: lv_triggers_2_0= ruleTriggerRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersTriggerRuleParserRuleCall_0_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_3);
                    	    lv_triggers_2_0=ruleTriggerRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"triggers",
                    	    								lv_triggers_2_0,
                    	    								"org.eclipse.efm.papyrus.xtext.Transition.TriggerRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTransition.g:134:3: ( (lv_guard_3_0= ruleGuardRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTransition.g:135:4: (lv_guard_3_0= ruleGuardRule )
                    {
                    // InternalTransition.g:135:4: (lv_guard_3_0= ruleGuardRule )
                    // InternalTransition.g:136:5: lv_guard_3_0= ruleGuardRule
                    {

                    					newCompositeNode(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_guard_3_0=ruleGuardRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    					}
                    					set(
                    						current,
                    						"guard",
                    						lv_guard_3_0,
                    						"org.eclipse.efm.papyrus.xtext.Transition.GuardRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTransition.g:153:3: ( (lv_tguard_4_0= ruleTGuardRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTransition.g:154:4: (lv_tguard_4_0= ruleTGuardRule )
                    {
                    // InternalTransition.g:154:4: (lv_tguard_4_0= ruleTGuardRule )
                    // InternalTransition.g:155:5: lv_tguard_4_0= ruleTGuardRule
                    {

                    					newCompositeNode(grammarAccess.getTransitionRuleAccess().getTguardTGuardRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_6);
                    lv_tguard_4_0=ruleTGuardRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    					}
                    					set(
                    						current,
                    						"tguard",
                    						lv_tguard_4_0,
                    						"org.eclipse.efm.papyrus.xtext.Transition.TGuardRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTransition.g:172:3: (otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTransition.g:173:4: otherlv_5= '/' ( (lv_effectBody_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,12,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getTransitionRuleAccess().getSolidusKeyword_3_0());
                    			
                    // InternalTransition.g:177:4: ( (lv_effectBody_6_0= RULE_STRING ) )
                    // InternalTransition.g:178:5: (lv_effectBody_6_0= RULE_STRING )
                    {
                    // InternalTransition.g:178:5: (lv_effectBody_6_0= RULE_STRING )
                    // InternalTransition.g:179:6: lv_effectBody_6_0= RULE_STRING
                    {
                    lv_effectBody_6_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_effectBody_6_0, grammarAccess.getTransitionRuleAccess().getEffectBodySTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransitionRuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"effectBody",
                    							lv_effectBody_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionRule"


    // $ANTLR start "entryRuleFQN"
    // InternalTransition.g:200:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalTransition.g:200:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalTransition.g:201:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalTransition.g:207:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalTransition.g:213:2: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )* ) )
            // InternalTransition.g:214:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )* )
            {
            // InternalTransition.g:214:2: (this_ID_0= RULE_ID ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )* )
            // InternalTransition.g:215:3: this_ID_0= RULE_ID ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalTransition.g:222:3: ( (kw= '.' | kw= '::' ) this_ID_3= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=13 && LA7_0<=14)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTransition.g:223:4: (kw= '.' | kw= '::' ) this_ID_3= RULE_ID
            	    {
            	    // InternalTransition.g:223:4: (kw= '.' | kw= '::' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==13) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==14) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalTransition.g:224:5: kw= '.'
            	            {
            	            kw=(Token)match(input,13,FOLLOW_9); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalTransition.g:230:5: kw= '::'
            	            {
            	            kw=(Token)match(input,14,FOLLOW_9); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getFQNAccess().getColonColonKeyword_1_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    				current.merge(this_ID_3);
            	    			

            	    				newLeafNode(this_ID_3, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleTriggerRule"
    // InternalTransition.g:248:1: entryRuleTriggerRule returns [EObject current=null] : iv_ruleTriggerRule= ruleTriggerRule EOF ;
    public final EObject entryRuleTriggerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerRule = null;


        try {
            // InternalTransition.g:248:52: (iv_ruleTriggerRule= ruleTriggerRule EOF )
            // InternalTransition.g:249:2: iv_ruleTriggerRule= ruleTriggerRule EOF
            {
             newCompositeNode(grammarAccess.getTriggerRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggerRule=ruleTriggerRule();

            state._fsp--;

             current =iv_ruleTriggerRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggerRule"


    // $ANTLR start "ruleTriggerRule"
    // InternalTransition.g:255:1: ruleTriggerRule returns [EObject current=null] : (otherlv_0= 'input' ( ( ruleFQN ) ) ( (lv_event_2_0= ruleEventRule ) )? ) ;
    public final EObject ruleTriggerRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_event_2_0 = null;



        	enterRule();

        try {
            // InternalTransition.g:261:2: ( (otherlv_0= 'input' ( ( ruleFQN ) ) ( (lv_event_2_0= ruleEventRule ) )? ) )
            // InternalTransition.g:262:2: (otherlv_0= 'input' ( ( ruleFQN ) ) ( (lv_event_2_0= ruleEventRule ) )? )
            {
            // InternalTransition.g:262:2: (otherlv_0= 'input' ( ( ruleFQN ) ) ( (lv_event_2_0= ruleEventRule ) )? )
            // InternalTransition.g:263:3: otherlv_0= 'input' ( ( ruleFQN ) ) ( (lv_event_2_0= ruleEventRule ) )?
            {
            otherlv_0=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggerRuleAccess().getInputKeyword_0());
            		
            // InternalTransition.g:267:3: ( ( ruleFQN ) )
            // InternalTransition.g:268:4: ( ruleFQN )
            {
            // InternalTransition.g:268:4: ( ruleFQN )
            // InternalTransition.g:269:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTriggerRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTriggerRuleAccess().getPortNamedElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_10);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTransition.g:283:3: ( (lv_event_2_0= ruleEventRule ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTransition.g:284:4: (lv_event_2_0= ruleEventRule )
                    {
                    // InternalTransition.g:284:4: (lv_event_2_0= ruleEventRule )
                    // InternalTransition.g:285:5: lv_event_2_0= ruleEventRule
                    {

                    					newCompositeNode(grammarAccess.getTriggerRuleAccess().getEventEventRuleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_event_2_0=ruleEventRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTriggerRuleRule());
                    					}
                    					set(
                    						current,
                    						"event",
                    						lv_event_2_0,
                    						"org.eclipse.efm.papyrus.xtext.Transition.EventRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggerRule"


    // $ANTLR start "entryRuleEventRule"
    // InternalTransition.g:306:1: entryRuleEventRule returns [EObject current=null] : iv_ruleEventRule= ruleEventRule EOF ;
    public final EObject entryRuleEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRule = null;


        try {
            // InternalTransition.g:306:50: (iv_ruleEventRule= ruleEventRule EOF )
            // InternalTransition.g:307:2: iv_ruleEventRule= ruleEventRule EOF
            {
             newCompositeNode(grammarAccess.getEventRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventRule=ruleEventRule();

            state._fsp--;

             current =iv_ruleEventRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventRule"


    // $ANTLR start "ruleEventRule"
    // InternalTransition.g:313:1: ruleEventRule returns [EObject current=null] : this_ReceiveSignalEventRule_0= ruleReceiveSignalEventRule ;
    public final EObject ruleEventRule() throws RecognitionException {
        EObject current = null;

        EObject this_ReceiveSignalEventRule_0 = null;



        	enterRule();

        try {
            // InternalTransition.g:319:2: (this_ReceiveSignalEventRule_0= ruleReceiveSignalEventRule )
            // InternalTransition.g:320:2: this_ReceiveSignalEventRule_0= ruleReceiveSignalEventRule
            {

            		newCompositeNode(grammarAccess.getEventRuleAccess().getReceiveSignalEventRuleParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ReceiveSignalEventRule_0=ruleReceiveSignalEventRule();

            state._fsp--;


            		current = this_ReceiveSignalEventRule_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventRule"


    // $ANTLR start "entryRuleReceiveSignalEventRule"
    // InternalTransition.g:331:1: entryRuleReceiveSignalEventRule returns [EObject current=null] : iv_ruleReceiveSignalEventRule= ruleReceiveSignalEventRule EOF ;
    public final EObject entryRuleReceiveSignalEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReceiveSignalEventRule = null;


        try {
            // InternalTransition.g:331:63: (iv_ruleReceiveSignalEventRule= ruleReceiveSignalEventRule EOF )
            // InternalTransition.g:332:2: iv_ruleReceiveSignalEventRule= ruleReceiveSignalEventRule EOF
            {
             newCompositeNode(grammarAccess.getReceiveSignalEventRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReceiveSignalEventRule=ruleReceiveSignalEventRule();

            state._fsp--;

             current =iv_ruleReceiveSignalEventRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReceiveSignalEventRule"


    // $ANTLR start "ruleReceiveSignalEventRule"
    // InternalTransition.g:338:1: ruleReceiveSignalEventRule returns [EObject current=null] : ( () otherlv_1= '(' ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleReceiveSignalEventRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalTransition.g:344:2: ( ( () otherlv_1= '(' ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )? otherlv_5= ')' ) )
            // InternalTransition.g:345:2: ( () otherlv_1= '(' ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )? otherlv_5= ')' )
            {
            // InternalTransition.g:345:2: ( () otherlv_1= '(' ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )? otherlv_5= ')' )
            // InternalTransition.g:346:3: () otherlv_1= '(' ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )? otherlv_5= ')'
            {
            // InternalTransition.g:346:3: ()
            // InternalTransition.g:347:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getReceiveSignalEventRuleAccess().getReceiveSignalEventRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getReceiveSignalEventRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTransition.g:357:3: ( ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTransition.g:358:4: ( ( ruleFQN ) ) (otherlv_3= ',' ( ( ruleFQN ) ) )*
                    {
                    // InternalTransition.g:358:4: ( ( ruleFQN ) )
                    // InternalTransition.g:359:5: ( ruleFQN )
                    {
                    // InternalTransition.g:359:5: ( ruleFQN )
                    // InternalTransition.g:360:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReceiveSignalEventRuleRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_0_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTransition.g:374:4: (otherlv_3= ',' ( ( ruleFQN ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==11) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalTransition.g:375:5: otherlv_3= ',' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_3=(Token)match(input,11,FOLLOW_9); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getReceiveSignalEventRuleAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalTransition.g:379:5: ( ( ruleFQN ) )
                    	    // InternalTransition.g:380:6: ( ruleFQN )
                    	    {
                    	    // InternalTransition.g:380:6: ( ruleFQN )
                    	    // InternalTransition.g:381:7: ruleFQN
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getReceiveSignalEventRuleRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getReceiveSignalEventRuleAccess().getParametersPropertyCrossReference_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    ruleFQN();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getReceiveSignalEventRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReceiveSignalEventRule"


    // $ANTLR start "entryRuleGuardRule"
    // InternalTransition.g:405:1: entryRuleGuardRule returns [EObject current=null] : iv_ruleGuardRule= ruleGuardRule EOF ;
    public final EObject entryRuleGuardRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardRule = null;


        try {
            // InternalTransition.g:405:50: (iv_ruleGuardRule= ruleGuardRule EOF )
            // InternalTransition.g:406:2: iv_ruleGuardRule= ruleGuardRule EOF
            {
             newCompositeNode(grammarAccess.getGuardRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuardRule=ruleGuardRule();

            state._fsp--;

             current =iv_ruleGuardRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardRule"


    // $ANTLR start "ruleGuardRule"
    // InternalTransition.g:412:1: ruleGuardRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' ) ;
    public final EObject ruleGuardRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constraint_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTransition.g:418:2: ( (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' ) )
            // InternalTransition.g:419:2: (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' )
            {
            // InternalTransition.g:419:2: (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' )
            // InternalTransition.g:420:3: otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalTransition.g:424:3: ( (lv_constraint_1_0= RULE_STRING ) )
            // InternalTransition.g:425:4: (lv_constraint_1_0= RULE_STRING )
            {
            // InternalTransition.g:425:4: (lv_constraint_1_0= RULE_STRING )
            // InternalTransition.g:426:5: lv_constraint_1_0= RULE_STRING
            {
            lv_constraint_1_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            					newLeafNode(lv_constraint_1_0, grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGuardRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"constraint",
            						lv_constraint_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuardRule"


    // $ANTLR start "entryRuleTGuardRule"
    // InternalTransition.g:450:1: entryRuleTGuardRule returns [EObject current=null] : iv_ruleTGuardRule= ruleTGuardRule EOF ;
    public final EObject entryRuleTGuardRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTGuardRule = null;


        try {
            // InternalTransition.g:450:51: (iv_ruleTGuardRule= ruleTGuardRule EOF )
            // InternalTransition.g:451:2: iv_ruleTGuardRule= ruleTGuardRule EOF
            {
             newCompositeNode(grammarAccess.getTGuardRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTGuardRule=ruleTGuardRule();

            state._fsp--;

             current =iv_ruleTGuardRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTGuardRule"


    // $ANTLR start "ruleTGuardRule"
    // InternalTransition.g:457:1: ruleTGuardRule returns [EObject current=null] : (otherlv_0= '{' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= '}' ) ;
    public final EObject ruleTGuardRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constraint_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTransition.g:463:2: ( (otherlv_0= '{' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= '}' ) )
            // InternalTransition.g:464:2: (otherlv_0= '{' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= '}' )
            {
            // InternalTransition.g:464:2: (otherlv_0= '{' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= '}' )
            // InternalTransition.g:465:3: otherlv_0= '{' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getTGuardRuleAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalTransition.g:469:3: ( (lv_constraint_1_0= RULE_STRING ) )
            // InternalTransition.g:470:4: (lv_constraint_1_0= RULE_STRING )
            {
            // InternalTransition.g:470:4: (lv_constraint_1_0= RULE_STRING )
            // InternalTransition.g:471:5: lv_constraint_1_0= RULE_STRING
            {
            lv_constraint_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_constraint_1_0, grammarAccess.getTGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTGuardRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"constraint",
            						lv_constraint_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getTGuardRuleAccess().getRightCurlyBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTGuardRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000141802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000101002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});

}