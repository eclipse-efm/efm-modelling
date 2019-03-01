package org.eclipse.efm.sew.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.efm.sew.xtext.services.SEWGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*****************************************************************************
* Copyright (c) 2018 CEA LIST.
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
public class InternalSEWParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_XIDENDIFIER", "RULE_CHARACTER", "RULE_INT", "RULE_STRING", "RULE_AT_IDENTIFIER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'workflow'", "'symbex-workflow'", "'{'", "'}'", "'@sew'", "'@favm'", "'<'", "'sew'", "','", "'version:'", "'>:'", "'::'", "'.'", "':='", "'+:='", "'['", "']'", "':'", "'='", "';'", "'?'", "'||'", "'or'", "'&&'", "'and'", "'=='", "'!='", "'==='", "'=!='", "'=/='", "'<='", "'>'", "'>='", "'+'", "'*'", "'**'", "'/'", "'%'", "'-'", "'!'", "'not'", "'('", "')'", "'&'", "'null'", "'$time'", "'$delta'", "'$this'", "'$self'", "'$parent'", "'$super'", "'$system'", "'$env'", "'env'", "'true'", "'false'", "'form'", "'endform'", "'prototype'", "'endprototype'", "'section'", "'endsection'", "'as'", "'is'", "'${'", "'|;|'", "'|i|'"
    };
    public static final int T__50=50;
    public static final int RULE_CHARACTER=5;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_XIDENDIFIER=4;
    public static final int RULE_ID=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_AT_IDENTIFIER=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSEWParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSEWParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSEWParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSEW.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private SEWGrammarAccess grammarAccess;

        public InternalSEWParser(TokenStream input, SEWGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Workflow";
       	}

       	@Override
       	protected SEWGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflow"
    // InternalSEW.g:79:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalSEW.g:79:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalSEW.g:80:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWorkflowRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWorkflow=ruleWorkflow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWorkflow; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalSEW.g:86:1: ruleWorkflow returns [EObject current=null] : ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) ) ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_element_6_1 = null;

        EObject lv_element_6_2 = null;

        EObject lv_element_8_1 = null;

        EObject lv_element_8_2 = null;

        EObject lv_element_9_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:92:2: ( ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) ) ) )
            // InternalSEW.g:93:2: ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) ) )
            {
            // InternalSEW.g:93:2: ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) ) )
            // InternalSEW.g:94:3: () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) )
            {
            // InternalSEW.g:94:3: ()
            // InternalSEW.g:95:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getWorkflowAccess().getSEWorkflowAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:104:3: ( ruleProlog )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=18 && LA1_0<=19)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSEW.g:105:4: ruleProlog
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getWorkflowAccess().getPrologParserRuleCall_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleProlog();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:116:3: ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalSEW.g:117:4: ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' )
                    {
                    // InternalSEW.g:117:4: ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' )
                    // InternalSEW.g:118:5: ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}'
                    {
                    // InternalSEW.g:118:5: ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) )
                    // InternalSEW.g:119:6: ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) )
                    {
                    // InternalSEW.g:119:6: ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) )
                    // InternalSEW.g:120:7: (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' )
                    {
                    // InternalSEW.g:120:7: (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==14) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==15) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalSEW.g:121:8: lv_type_2_1= 'workflow'
                            {
                            lv_type_2_1=(Token)match(input,14,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_type_2_1, grammarAccess.getWorkflowAccess().getTypeWorkflowKeyword_2_0_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getWorkflowRule());
                              								}
                              								setWithLastConsumed(current, "type", lv_type_2_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:132:8: lv_type_2_2= 'symbex-workflow'
                            {
                            lv_type_2_2=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_type_2_2, grammarAccess.getWorkflowAccess().getTypeSymbexWorkflowKeyword_2_0_0_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getWorkflowRule());
                              								}
                              								setWithLastConsumed(current, "type", lv_type_2_2, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:145:5: ( (lv_name_3_0= ruleUFI ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_XIDENDIFIER||LA3_0==14||LA3_0==21||(LA3_0>=70 && LA3_0<=75)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalSEW.g:146:6: (lv_name_3_0= ruleUFI )
                            {
                            // InternalSEW.g:146:6: (lv_name_3_0= ruleUFI )
                            // InternalSEW.g:147:7: lv_name_3_0= ruleUFI
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getWorkflowAccess().getNameUFIParserRuleCall_2_0_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_name_3_0=ruleUFI();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                              							}
                              							set(
                              								current,
                              								"name",
                              								lv_name_3_0,
                              								"org.eclipse.efm.sew.xtext.SEW.UFI");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalSEW.g:164:5: ( (lv_description_4_0= ruleEString ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_STRING) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalSEW.g:165:6: (lv_description_4_0= ruleEString )
                            {
                            // InternalSEW.g:165:6: (lv_description_4_0= ruleEString )
                            // InternalSEW.g:166:7: lv_description_4_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getWorkflowAccess().getDescriptionEStringParserRuleCall_2_0_2_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_6);
                            lv_description_4_0=ruleEString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                              							}
                              							set(
                              								current,
                              								"description",
                              								lv_description_4_0,
                              								"org.eclipse.efm.sew.xtext.SEW.EString");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2_0_3());
                      				
                    }
                    // InternalSEW.g:187:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_XIDENDIFIER||LA6_0==14||LA6_0==21||(LA6_0>=70 && LA6_0<=75)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSEW.g:188:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:188:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) )
                    	    // InternalSEW.g:189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )
                    	    int alt5=2;
                    	    alt5 = dfa5.predict(input);
                    	    switch (alt5) {
                    	        case 1 :
                    	            // InternalSEW.g:190:8: lv_element_6_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_0_4_0_0());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_6_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_6_1,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:206:8: lv_element_6_2= ruleProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_0_4_0_1());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_6_2=ruleProperty();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_6_2,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Property");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_2_0_5());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:230:4: ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )*
                    {
                    // InternalSEW.g:230:4: ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_XIDENDIFIER||LA8_0==14||LA8_0==21||(LA8_0>=70 && LA8_0<=75)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSEW.g:231:5: ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:231:5: ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) )
                    	    // InternalSEW.g:232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )
                    	    int alt7=2;
                    	    alt7 = dfa7.predict(input);
                    	    switch (alt7) {
                    	        case 1 :
                    	            // InternalSEW.g:233:7: lv_element_8_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getWorkflowAccess().getElementObjectParserRuleCall_2_1_0_0());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_8);
                    	            lv_element_8_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_8_1,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:249:7: lv_element_8_2= ruleProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_1_0_1());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_8);
                    	            lv_element_8_2=ruleProperty();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_8_2,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Property");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalSEW.g:268:4: ( (lv_element_9_0= ruleDeprecatedObject ) )
                    {
                    // InternalSEW.g:268:4: ( (lv_element_9_0= ruleDeprecatedObject ) )
                    // InternalSEW.g:269:5: (lv_element_9_0= ruleDeprecatedObject )
                    {
                    // InternalSEW.g:269:5: (lv_element_9_0= ruleDeprecatedObject )
                    // InternalSEW.g:270:6: lv_element_9_0= ruleDeprecatedObject
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getWorkflowAccess().getElementDeprecatedObjectParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_9_0=ruleDeprecatedObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                      						}
                      						add(
                      							current,
                      							"element",
                      							lv_element_9_0,
                      							"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleProlog"
    // InternalSEW.g:292:1: entryRuleProlog returns [String current=null] : iv_ruleProlog= ruleProlog EOF ;
    public final String entryRuleProlog() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleProlog = null;


        try {
            // InternalSEW.g:292:46: (iv_ruleProlog= ruleProlog EOF )
            // InternalSEW.g:293:2: iv_ruleProlog= ruleProlog EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrologRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProlog=ruleProlog();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProlog.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProlog"


    // $ANTLR start "ruleProlog"
    // InternalSEW.g:299:1: ruleProlog returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )? kw= '>:' ) ;
    public final AntlrDatatypeRuleToken ruleProlog() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EDouble_7 = null;

        AntlrDatatypeRuleToken this_UFI_8 = null;

        AntlrDatatypeRuleToken this_EString_9 = null;



        	enterRule();

        try {
            // InternalSEW.g:305:2: ( ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )? kw= '>:' ) )
            // InternalSEW.g:306:2: ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )? kw= '>:' )
            {
            // InternalSEW.g:306:2: ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )? kw= '>:' )
            // InternalSEW.g:307:3: (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )? kw= '>:'
            {
            // InternalSEW.g:307:3: (kw= '@sew' | kw= '@favm' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalSEW.g:308:4: kw= '@sew'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:314:4: kw= '@favm'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getFavmKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,20,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getPrologAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalSEW.g:325:3: (kw= 'workflow' | kw= 'sew' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==14) ) {
                alt11=1;
            }
            else if ( (LA11_0==21) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSEW.g:326:4: kw= 'workflow'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getWorkflowKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:332:4: kw= 'sew'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:338:3: ( (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble ) | this_UFI_8= ruleUFI | this_EString_9= ruleEString )?
            int alt13=4;
            switch ( input.LA(1) ) {
                case 22:
                    {
                    alt13=1;
                    }
                    break;
                case RULE_XIDENDIFIER:
                case 14:
                case 21:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    {
                    alt13=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt13=3;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // InternalSEW.g:339:4: (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble )
                    {
                    // InternalSEW.g:339:4: (kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble )
                    // InternalSEW.g:340:5: kw= ',' (kw= 'version:' )? this_EDouble_7= ruleEDouble
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getPrologAccess().getCommaKeyword_3_0_0());
                      				
                    }
                    // InternalSEW.g:345:5: (kw= 'version:' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==23) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalSEW.g:346:6: kw= 'version:'
                            {
                            kw=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						current.merge(kw);
                              						newLeafNode(kw, grammarAccess.getPrologAccess().getVersionKeyword_3_0_1());
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrologAccess().getEDoubleParserRuleCall_3_0_2());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    this_EDouble_7=ruleEDouble();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_EDouble_7);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:364:4: this_UFI_8= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrologAccess().getUFIParserRuleCall_3_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    this_UFI_8=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_UFI_8);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:375:4: this_EString_9= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrologAccess().getEStringParserRuleCall_3_2());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    this_EString_9=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_EString_9);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getPrologAccess().getGreaterThanSignColonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleProlog"


    // $ANTLR start "entryRuleReservedWord"
    // InternalSEW.g:395:1: entryRuleReservedWord returns [String current=null] : iv_ruleReservedWord= ruleReservedWord EOF ;
    public final String entryRuleReservedWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReservedWord = null;


        try {
            // InternalSEW.g:395:52: (iv_ruleReservedWord= ruleReservedWord EOF )
            // InternalSEW.g:396:2: iv_ruleReservedWord= ruleReservedWord EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReservedWordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReservedWord=ruleReservedWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReservedWord.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReservedWord"


    // $ANTLR start "ruleReservedWord"
    // InternalSEW.g:402:1: ruleReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord ) ;
    public final AntlrDatatypeRuleToken ruleReservedWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DeprecatedReservedWord_2 = null;



        	enterRule();

        try {
            // InternalSEW.g:408:2: ( (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord ) )
            // InternalSEW.g:409:2: (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord )
            {
            // InternalSEW.g:409:2: (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt14=1;
                }
                break;
            case 21:
                {
                alt14=2;
                }
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalSEW.g:410:3: kw= 'workflow'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReservedWordAccess().getWorkflowKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:416:3: kw= 'sew'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReservedWordAccess().getSewKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:422:3: this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReservedWordAccess().getDeprecatedReservedWordParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DeprecatedReservedWord_2=ruleDeprecatedReservedWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DeprecatedReservedWord_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleReservedWord"


    // $ANTLR start "entryRuleXID"
    // InternalSEW.g:436:1: entryRuleXID returns [String current=null] : iv_ruleXID= ruleXID EOF ;
    public final String entryRuleXID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXID = null;


        try {
            // InternalSEW.g:436:43: (iv_ruleXID= ruleXID EOF )
            // InternalSEW.g:437:2: iv_ruleXID= ruleXID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXID=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXID"


    // $ANTLR start "ruleXID"
    // InternalSEW.g:443:1: ruleXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER ) ;
    public final AntlrDatatypeRuleToken ruleXID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_XIDENDIFIER_1=null;
        AntlrDatatypeRuleToken this_ReservedWord_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:449:2: ( (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER ) )
            // InternalSEW.g:450:2: (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER )
            {
            // InternalSEW.g:450:2: (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14||LA15_0==21||(LA15_0>=70 && LA15_0<=75)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_XIDENDIFIER) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSEW.g:451:3: this_ReservedWord_0= ruleReservedWord
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXIDAccess().getReservedWordParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReservedWord_0=ruleReservedWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ReservedWord_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:462:3: this_XIDENDIFIER_1= RULE_XIDENDIFIER
                    {
                    this_XIDENDIFIER_1=(Token)match(input,RULE_XIDENDIFIER,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_XIDENDIFIER_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_XIDENDIFIER_1, grammarAccess.getXIDAccess().getXIDENDIFIERTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXID"


    // $ANTLR start "entryRuleUFI"
    // InternalSEW.g:473:1: entryRuleUFI returns [String current=null] : iv_ruleUFI= ruleUFI EOF ;
    public final String entryRuleUFI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUFI = null;


        try {
            // InternalSEW.g:473:43: (iv_ruleUFI= ruleUFI EOF )
            // InternalSEW.g:474:2: iv_ruleUFI= ruleUFI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUFIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUFI=ruleUFI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUFI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleUFI"


    // $ANTLR start "ruleUFI"
    // InternalSEW.g:480:1: ruleUFI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* ) ;
    public final AntlrDatatypeRuleToken ruleUFI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XID_0 = null;

        AntlrDatatypeRuleToken this_XID_3 = null;



        	enterRule();

        try {
            // InternalSEW.g:486:2: ( (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* ) )
            // InternalSEW.g:487:2: (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* )
            {
            // InternalSEW.g:487:2: (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* )
            // InternalSEW.g:488:3: this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getUFIAccess().getXIDParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_14);
            this_XID_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_XID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:498:3: ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==RULE_XIDENDIFIER||LA17_2==14||LA17_2==21||(LA17_2>=70 && LA17_2<=75)) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSEW.g:499:4: (kw= '::' | kw= '.' ) this_XID_3= ruleXID
            	    {
            	    // InternalSEW.g:499:4: (kw= '::' | kw= '.' )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==25) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==26) ) {
            	        alt16=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalSEW.g:500:5: kw= '::'
            	            {
            	            kw=(Token)match(input,25,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					current.merge(kw);
            	              					newLeafNode(kw, grammarAccess.getUFIAccess().getColonColonKeyword_1_0_0());
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSEW.g:506:5: kw= '.'
            	            {
            	            kw=(Token)match(input,26,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					current.merge(kw);
            	              					newLeafNode(kw, grammarAccess.getUFIAccess().getFullStopKeyword_1_0_1());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getUFIAccess().getXIDParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    this_XID_3=ruleXID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_XID_3);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleUFI"


    // $ANTLR start "entryRuleObject"
    // InternalSEW.g:527:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalSEW.g:527:47: (iv_ruleObject= ruleObject EOF )
            // InternalSEW.g:528:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalSEW.g:534:1: ruleObject returns [EObject current=null] : ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_3_0 = null;

        EObject lv_element_5_1 = null;

        EObject lv_element_5_2 = null;

        AntlrDatatypeRuleToken lv_name_8_0 = null;

        AntlrDatatypeRuleToken lv_type_11_0 = null;

        AntlrDatatypeRuleToken lv_description_12_0 = null;

        EObject lv_element_14_1 = null;

        EObject lv_element_14_2 = null;



        	enterRule();

        try {
            // InternalSEW.g:540:2: ( ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) ) )
            // InternalSEW.g:541:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )
            {
            // InternalSEW.g:541:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalSEW.g:542:3: ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' )
                    {
                    // InternalSEW.g:542:3: ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' )
                    // InternalSEW.g:543:4: () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}'
                    {
                    // InternalSEW.g:543:4: ()
                    // InternalSEW.g:544:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectAccess().getWObjectAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:553:4: ( (lv_type_1_0= ruleUFI ) )
                    // InternalSEW.g:554:5: (lv_type_1_0= ruleUFI )
                    {
                    // InternalSEW.g:554:5: (lv_type_1_0= ruleUFI )
                    // InternalSEW.g:555:6: lv_type_1_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_type_1_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_1_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:572:4: ( (lv_name_2_0= ruleUFI ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_XIDENDIFIER||LA18_0==14||LA18_0==21||(LA18_0>=70 && LA18_0<=75)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalSEW.g:573:5: (lv_name_2_0= ruleUFI )
                            {
                            // InternalSEW.g:573:5: (lv_name_2_0= ruleUFI )
                            // InternalSEW.g:574:6: lv_name_2_0= ruleUFI
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_name_2_0=ruleUFI();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getObjectRule());
                              						}
                              						set(
                              							current,
                              							"name",
                              							lv_name_2_0,
                              							"org.eclipse.efm.sew.xtext.SEW.UFI");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalSEW.g:591:4: ( (lv_description_3_0= ruleEString ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_STRING) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalSEW.g:592:5: (lv_description_3_0= ruleEString )
                            {
                            // InternalSEW.g:592:5: (lv_description_3_0= ruleEString )
                            // InternalSEW.g:593:6: lv_description_3_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_0_3_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_6);
                            lv_description_3_0=ruleEString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getObjectRule());
                              						}
                              						set(
                              							current,
                              							"description",
                              							lv_description_3_0,
                              							"org.eclipse.efm.sew.xtext.SEW.EString");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_0_4());
                      			
                    }
                    // InternalSEW.g:614:4: ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_XIDENDIFIER||LA21_0==14||LA21_0==21||(LA21_0>=70 && LA21_0<=75)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalSEW.g:615:5: ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:615:5: ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) )
                    	    // InternalSEW.g:616:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:616:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )
                    	    int alt20=2;
                    	    alt20 = dfa20.predict(input);
                    	    switch (alt20) {
                    	        case 1 :
                    	            // InternalSEW.g:617:7: lv_element_5_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_0_5_0_0());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_5_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getObjectRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_5_1,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:633:7: lv_element_5_2= ruleProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_0_5_0_1());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_5_2=ruleProperty();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getObjectRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_5_2,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Property");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_0_6());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:657:3: ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' )
                    {
                    // InternalSEW.g:657:3: ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' )
                    // InternalSEW.g:658:4: () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}'
                    {
                    // InternalSEW.g:658:4: ()
                    // InternalSEW.g:659:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectAccess().getWObjectAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:668:4: ( (lv_name_8_0= ruleUFI ) )
                    // InternalSEW.g:669:5: (lv_name_8_0= ruleUFI )
                    {
                    // InternalSEW.g:669:5: (lv_name_8_0= ruleUFI )
                    // InternalSEW.g:670:6: lv_name_8_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_name_8_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_8_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:687:4: (otherlv_9= ':=' | otherlv_10= '+:=' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==27) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==28) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSEW.g:688:5: otherlv_9= ':='
                            {
                            otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:693:5: otherlv_10= '+:='
                            {
                            otherlv_10=(Token)match(input,28,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_10, grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:698:4: ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==RULE_XIDENDIFIER||LA24_0==14||LA24_0==21||(LA24_0>=70 && LA24_0<=75)) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalSEW.g:699:5: ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )?
                            {
                            // InternalSEW.g:699:5: ( (lv_type_11_0= ruleUFI ) )
                            // InternalSEW.g:700:6: (lv_type_11_0= ruleUFI )
                            {
                            // InternalSEW.g:700:6: (lv_type_11_0= ruleUFI )
                            // InternalSEW.g:701:7: lv_type_11_0= ruleUFI
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectAccess().getTypeUFIParserRuleCall_1_3_0_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_type_11_0=ruleUFI();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectRule());
                              							}
                              							set(
                              								current,
                              								"type",
                              								lv_type_11_0,
                              								"org.eclipse.efm.sew.xtext.SEW.UFI");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalSEW.g:718:5: ( (lv_description_12_0= ruleEString ) )?
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==RULE_STRING) ) {
                                alt23=1;
                            }
                            switch (alt23) {
                                case 1 :
                                    // InternalSEW.g:719:6: (lv_description_12_0= ruleEString )
                                    {
                                    // InternalSEW.g:719:6: (lv_description_12_0= ruleEString )
                                    // InternalSEW.g:720:7: lv_description_12_0= ruleEString
                                    {
                                    if ( state.backtracking==0 ) {

                                      							newCompositeNode(grammarAccess.getObjectAccess().getDescriptionEStringParserRuleCall_1_3_1_0());
                                      						
                                    }
                                    pushFollow(FollowSets000.FOLLOW_6);
                                    lv_description_12_0=ruleEString();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElementForParent(grammarAccess.getObjectRule());
                                      							}
                                      							set(
                                      								current,
                                      								"description",
                                      								lv_description_12_0,
                                      								"org.eclipse.efm.sew.xtext.SEW.EString");
                                      							afterParserOrEnumRuleCall();
                                      						
                                    }

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_1_4());
                      			
                    }
                    // InternalSEW.g:742:4: ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_XIDENDIFIER||LA26_0==14||LA26_0==21||(LA26_0>=70 && LA26_0<=75)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalSEW.g:743:5: ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:743:5: ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) )
                    	    // InternalSEW.g:744:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:744:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )
                    	    int alt25=2;
                    	    alt25 = dfa25.predict(input);
                    	    switch (alt25) {
                    	        case 1 :
                    	            // InternalSEW.g:745:7: lv_element_14_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getObjectAccess().getElementObjectParserRuleCall_1_5_0_0());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_14_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getObjectRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_14_1,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:761:7: lv_element_14_2= ruleProperty
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getObjectAccess().getElementPropertyParserRuleCall_1_5_0_1());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_7);
                    	            lv_element_14_2=ruleProperty();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getObjectRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_14_2,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Property");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_1_6());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleProperty"
    // InternalSEW.g:788:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalSEW.g:788:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalSEW.g:789:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalSEW.g:795:1: ruleProperty returns [EObject current=null] : (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_Section_0 = null;

        EObject this_Attribute_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:801:2: ( (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute ) )
            // InternalSEW.g:802:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )
            {
            // InternalSEW.g:802:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalSEW.g:803:3: this_Section_0= ruleSection
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyAccess().getSectionParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Section_0=ruleSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Section_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:815:3: this_Attribute_1= ruleAttribute
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Attribute_1=ruleAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Attribute_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleSection"
    // InternalSEW.g:830:1: entryRuleSection returns [EObject current=null] : iv_ruleSection= ruleSection EOF ;
    public final EObject entryRuleSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSection = null;


        try {
            // InternalSEW.g:830:48: (iv_ruleSection= ruleSection EOF )
            // InternalSEW.g:831:2: iv_ruleSection= ruleSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSectionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSection=ruleSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSection; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSection"


    // $ANTLR start "ruleSection"
    // InternalSEW.g:837:1: ruleSection returns [EObject current=null] : ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) ) ;
    public final EObject ruleSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_description_1_0 = null;

        EObject lv_element_3_1 = null;

        EObject lv_element_3_2 = null;

        EObject lv_element_6_1 = null;

        EObject lv_element_6_2 = null;



        	enterRule();

        try {
            // InternalSEW.g:843:2: ( ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) ) )
            // InternalSEW.g:844:2: ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) )
            {
            // InternalSEW.g:844:2: ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) )
            // InternalSEW.g:845:3: ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) )
            {
            // InternalSEW.g:845:3: ( (lv_name_0_0= ruleXID ) )
            // InternalSEW.g:846:4: (lv_name_0_0= ruleXID )
            {
            // InternalSEW.g:846:4: (lv_name_0_0= ruleXID )
            // InternalSEW.g:847:5: lv_name_0_0= ruleXID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSectionAccess().getNameXIDParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_18);
            lv_name_0_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSectionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.efm.sew.xtext.SEW.XID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSEW.g:864:3: ( (lv_description_1_0= ruleEString ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_STRING) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSEW.g:865:4: (lv_description_1_0= ruleEString )
                    {
                    // InternalSEW.g:865:4: (lv_description_1_0= ruleEString )
                    // InternalSEW.g:866:5: lv_description_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSectionAccess().getDescriptionEStringParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    lv_description_1_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSectionRule());
                      					}
                      					set(
                      						current,
                      						"description",
                      						lv_description_1_0,
                      						"org.eclipse.efm.sew.xtext.SEW.EString");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSEW.g:883:3: ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            else if ( (LA34_0==31) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalSEW.g:884:4: (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' )
                    {
                    // InternalSEW.g:884:4: (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' )
                    // InternalSEW.g:885:5: otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0());
                      				
                    }
                    // InternalSEW.g:889:5: ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_XIDENDIFIER||LA31_0==14||LA31_0==21||(LA31_0>=70 && LA31_0<=75)) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalSEW.g:890:6: ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) )
                    	    {
                    	    // InternalSEW.g:890:6: ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) )
                    	    // InternalSEW.g:891:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )
                    	    {
                    	    // InternalSEW.g:891:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )
                    	    int alt30=2;
                    	    alt30 = dfa30.predict(input);
                    	    switch (alt30) {
                    	        case 1 :
                    	            // InternalSEW.g:892:8: lv_element_3_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_0_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_20);
                    	            lv_element_3_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSectionRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_3_1,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:908:8: lv_element_3_2= ruleAttribute
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_0_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_20);
                    	            lv_element_3_2=ruleAttribute();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSectionRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_3_2,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Attribute");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:932:4: (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* )
                    {
                    // InternalSEW.g:932:4: (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* )
                    // InternalSEW.g:933:5: otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*
                    {
                    otherlv_5=(Token)match(input,31,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getSectionAccess().getColonKeyword_2_1_0());
                      				
                    }
                    // InternalSEW.g:937:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        alt33 = dfa33.predict(input);
                        switch (alt33) {
                    	case 1 :
                    	    // InternalSEW.g:938:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
                    	    {
                    	    // InternalSEW.g:938:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
                    	    // InternalSEW.g:939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
                    	    {
                    	    // InternalSEW.g:939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
                    	    int alt32=2;
                    	    alt32 = dfa32.predict(input);
                    	    switch (alt32) {
                    	        case 1 :
                    	            // InternalSEW.g:940:8: lv_element_6_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_1_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_8);
                    	            lv_element_6_1=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSectionRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_6_1,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:956:8: lv_element_6_2= ruleAttribute
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_8);
                    	            lv_element_6_2=ruleAttribute();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getSectionRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"element",
                    	              									lv_element_6_2,
                    	              									"org.eclipse.efm.sew.xtext.SEW.Attribute");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleSection"


    // $ANTLR start "entryRuleAttribute"
    // InternalSEW.g:980:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSEW.g:980:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSEW.g:981:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSEW.g:987:1: ruleAttribute returns [EObject current=null] : ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:993:2: ( ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) )
            // InternalSEW.g:994:2: ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            {
            // InternalSEW.g:994:2: ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            // InternalSEW.g:995:3: () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )?
            {
            // InternalSEW.g:995:3: ()
            // InternalSEW.g:996:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAttributeAccess().getWAttributeAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:1005:3: ( (lv_name_1_0= ruleXID ) )
            // InternalSEW.g:1006:4: (lv_name_1_0= ruleXID )
            {
            // InternalSEW.g:1006:4: (lv_name_1_0= ruleXID )
            // InternalSEW.g:1007:5: lv_name_1_0= ruleXID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getNameXIDParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_21);
            lv_name_1_0=ruleXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.efm.sew.xtext.SEW.XID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalSEW.g:1028:3: ( (lv_value_3_0= ruleValueSpecification ) )
            // InternalSEW.g:1029:4: (lv_value_3_0= ruleValueSpecification )
            {
            // InternalSEW.g:1029:4: (lv_value_3_0= ruleValueSpecification )
            // InternalSEW.g:1030:5: lv_value_3_0= ruleValueSpecification
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getValueValueSpecificationParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_value_3_0=ruleValueSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
              						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSEW.g:1047:3: (otherlv_4= ';' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSEW.g:1048:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getSemicolonKeyword_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleValueSpecification"
    // InternalSEW.g:1057:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // InternalSEW.g:1057:59: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // InternalSEW.g:1058:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueSpecificationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueSpecification=ruleValueSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueSpecification; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValueSpecification"


    // $ANTLR start "ruleValueSpecification"
    // InternalSEW.g:1064:1: ruleValueSpecification returns [EObject current=null] : this_Expression_0= ruleExpression ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1070:2: (this_Expression_0= ruleExpression )
            // InternalSEW.g:1071:2: this_Expression_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Expression_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Expression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleValueSpecification"


    // $ANTLR start "entryRuleExpression"
    // InternalSEW.g:1085:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSEW.g:1085:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSEW.g:1086:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSEW.g:1092:1: ruleExpression returns [EObject current=null] : (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_conditionalExpression_0 = null;

        EObject this_DeprecatedExpression_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:1098:2: ( (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression ) )
            // InternalSEW.g:1099:2: (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression )
            {
            // InternalSEW.g:1099:2: (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_XIDENDIFIER && LA36_0<=RULE_STRING)||LA36_0==14||LA36_0==21||LA36_0==26||LA36_0==29||LA36_0==47||(LA36_0>=52 && LA36_0<=55)||(LA36_0>=57 && LA36_0<=75)) ) {
                alt36=1;
            }
            else if ( (LA36_0==78) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalSEW.g:1100:3: this_conditionalExpression_0= ruleconditionalExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_conditionalExpression_0=ruleconditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_conditionalExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:1112:3: this_DeprecatedExpression_1= ruleDeprecatedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getDeprecatedExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DeprecatedExpression_1=ruleDeprecatedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeprecatedExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleconditionalExpression"
    // InternalSEW.g:1127:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // InternalSEW.g:1127:62: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // InternalSEW.g:1128:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleconditionalExpression=ruleconditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleconditionalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleconditionalExpression"


    // $ANTLR start "ruleconditionalExpression"
    // InternalSEW.g:1134:1: ruleconditionalExpression returns [EObject current=null] : (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject this_conditionalOrExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1140:2: ( (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? ) )
            // InternalSEW.g:1141:2: (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? )
            {
            // InternalSEW.g:1141:2: (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? )
            // InternalSEW.g:1142:3: this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_24);
            this_conditionalOrExpression_0=ruleconditionalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_conditionalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1153:3: ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSEW.g:1154:4: () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalSEW.g:1154:4: ()
                    // InternalSEW.g:1155:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getConditionalExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1164:4: ( (lv_operator_2_0= '?' ) )
                    // InternalSEW.g:1165:5: (lv_operator_2_0= '?' )
                    {
                    // InternalSEW.g:1165:5: (lv_operator_2_0= '?' )
                    // InternalSEW.g:1166:6: lv_operator_2_0= '?'
                    {
                    lv_operator_2_0=(Token)match(input,34,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_0, grammarAccess.getConditionalExpressionAccess().getOperatorQuestionMarkKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConditionalExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_0, "?");
                      					
                    }

                    }


                    }

                    // InternalSEW.g:1178:4: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalSEW.g:1179:5: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalSEW.g:1179:5: (lv_operand_3_0= ruleExpression )
                    // InternalSEW.g:1180:6: lv_operand_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_operand_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalSEW.g:1201:4: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalSEW.g:1202:5: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalSEW.g:1202:5: (lv_operand_5_0= ruleExpression )
                    // InternalSEW.g:1203:6: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperandExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_5_0,
                      							"org.eclipse.efm.sew.xtext.SEW.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleconditionalExpression"


    // $ANTLR start "entryRuleconditionalOrExpression"
    // InternalSEW.g:1225:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // InternalSEW.g:1225:64: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // InternalSEW.g:1226:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleconditionalOrExpression=ruleconditionalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleconditionalOrExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleconditionalOrExpression"


    // $ANTLR start "ruleconditionalOrExpression"
    // InternalSEW.g:1232:1: ruleconditionalOrExpression returns [EObject current=null] : (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? ) ;
    public final EObject ruleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_conditionalAndExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_6_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1238:2: ( (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? ) )
            // InternalSEW.g:1239:2: (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? )
            {
            // InternalSEW.g:1239:2: (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? )
            // InternalSEW.g:1240:3: this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getConditionalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_26);
            this_conditionalAndExpression_0=ruleconditionalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_conditionalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1251:3: ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=35 && LA41_0<=36)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSEW.g:1252:4: () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )*
                    {
                    // InternalSEW.g:1252:4: ()
                    // InternalSEW.g:1253:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getConditionalOrExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1262:4: ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) )
                    // InternalSEW.g:1263:5: ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) )
                    {
                    // InternalSEW.g:1263:5: ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) )
                    // InternalSEW.g:1264:6: (lv_operator_2_1= '||' | lv_operator_2_2= 'or' )
                    {
                    // InternalSEW.g:1264:6: (lv_operator_2_1= '||' | lv_operator_2_2= 'or' )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==35) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==36) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalSEW.g:1265:7: lv_operator_2_1= '||'
                            {
                            lv_operator_2_1=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_1, grammarAccess.getConditionalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getConditionalOrExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:1276:7: lv_operator_2_2= 'or'
                            {
                            lv_operator_2_2=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_2, grammarAccess.getConditionalOrExpressionAccess().getOperatorOrKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getConditionalOrExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:1289:4: ( (lv_operand_3_0= ruleconditionalAndExpression ) )
                    // InternalSEW.g:1290:5: (lv_operand_3_0= ruleconditionalAndExpression )
                    {
                    // InternalSEW.g:1290:5: (lv_operand_3_0= ruleconditionalAndExpression )
                    // InternalSEW.g:1291:6: lv_operand_3_0= ruleconditionalAndExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_26);
                    lv_operand_3_0=ruleconditionalAndExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.conditionalAndExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:1308:4: ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=35 && LA40_0<=36)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalSEW.g:1309:5: (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) )
                    	    {
                    	    // InternalSEW.g:1309:5: (otherlv_4= '||' | otherlv_5= 'or' )
                    	    int alt39=2;
                    	    int LA39_0 = input.LA(1);

                    	    if ( (LA39_0==35) ) {
                    	        alt39=1;
                    	    }
                    	    else if ( (LA39_0==36) ) {
                    	        alt39=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 39, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt39) {
                    	        case 1 :
                    	            // InternalSEW.g:1310:6: otherlv_4= '||'
                    	            {
                    	            otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_4, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0());
                    	              					
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:1315:6: otherlv_5= 'or'
                    	            {
                    	            otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_5, grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalSEW.g:1320:5: ( (lv_operand_6_0= ruleconditionalAndExpression ) )
                    	    // InternalSEW.g:1321:6: (lv_operand_6_0= ruleconditionalAndExpression )
                    	    {
                    	    // InternalSEW.g:1321:6: (lv_operand_6_0= ruleconditionalAndExpression )
                    	    // InternalSEW.g:1322:7: lv_operand_6_0= ruleconditionalAndExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getOperandConditionalAndExpressionParserRuleCall_1_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_26);
                    	    lv_operand_6_0=ruleconditionalAndExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"operand",
                    	      								lv_operand_6_0,
                    	      								"org.eclipse.efm.sew.xtext.SEW.conditionalAndExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleconditionalOrExpression"


    // $ANTLR start "entryRuleconditionalAndExpression"
    // InternalSEW.g:1345:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // InternalSEW.g:1345:65: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // InternalSEW.g:1346:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleconditionalAndExpression=ruleconditionalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleconditionalAndExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleconditionalAndExpression"


    // $ANTLR start "ruleconditionalAndExpression"
    // InternalSEW.g:1352:1: ruleconditionalAndExpression returns [EObject current=null] : (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? ) ;
    public final EObject ruleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_equalityExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_6_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1358:2: ( (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? ) )
            // InternalSEW.g:1359:2: (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? )
            {
            // InternalSEW.g:1359:2: (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? )
            // InternalSEW.g:1360:3: this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_28);
            this_equalityExpression_0=ruleequalityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_equalityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1371:3: ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=37 && LA45_0<=38)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalSEW.g:1372:4: () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )*
                    {
                    // InternalSEW.g:1372:4: ()
                    // InternalSEW.g:1373:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getConditionalAndExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1382:4: ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) )
                    // InternalSEW.g:1383:5: ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) )
                    {
                    // InternalSEW.g:1383:5: ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) )
                    // InternalSEW.g:1384:6: (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' )
                    {
                    // InternalSEW.g:1384:6: (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==37) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==38) ) {
                        alt42=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalSEW.g:1385:7: lv_operator_2_1= '&&'
                            {
                            lv_operator_2_1=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_1, grammarAccess.getConditionalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getConditionalAndExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:1396:7: lv_operator_2_2= 'and'
                            {
                            lv_operator_2_2=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_2, grammarAccess.getConditionalAndExpressionAccess().getOperatorAndKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getConditionalAndExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:1409:4: ( (lv_operand_3_0= ruleequalityExpression ) )
                    // InternalSEW.g:1410:5: (lv_operand_3_0= ruleequalityExpression )
                    {
                    // InternalSEW.g:1410:5: (lv_operand_3_0= ruleequalityExpression )
                    // InternalSEW.g:1411:6: lv_operand_3_0= ruleequalityExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_28);
                    lv_operand_3_0=ruleequalityExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.equalityExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:1428:4: ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( ((LA44_0>=37 && LA44_0<=38)) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalSEW.g:1429:5: (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) )
                    	    {
                    	    // InternalSEW.g:1429:5: (otherlv_4= '&&' | otherlv_5= 'and' )
                    	    int alt43=2;
                    	    int LA43_0 = input.LA(1);

                    	    if ( (LA43_0==37) ) {
                    	        alt43=1;
                    	    }
                    	    else if ( (LA43_0==38) ) {
                    	        alt43=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 43, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt43) {
                    	        case 1 :
                    	            // InternalSEW.g:1430:6: otherlv_4= '&&'
                    	            {
                    	            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_4, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0());
                    	              					
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:1435:6: otherlv_5= 'and'
                    	            {
                    	            otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_5, grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalSEW.g:1440:5: ( (lv_operand_6_0= ruleequalityExpression ) )
                    	    // InternalSEW.g:1441:6: (lv_operand_6_0= ruleequalityExpression )
                    	    {
                    	    // InternalSEW.g:1441:6: (lv_operand_6_0= ruleequalityExpression )
                    	    // InternalSEW.g:1442:7: lv_operand_6_0= ruleequalityExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getOperandEqualityExpressionParserRuleCall_1_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_28);
                    	    lv_operand_6_0=ruleequalityExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"operand",
                    	      								lv_operand_6_0,
                    	      								"org.eclipse.efm.sew.xtext.SEW.equalityExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleconditionalAndExpression"


    // $ANTLR start "entryRuleequalityExpression"
    // InternalSEW.g:1465:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // InternalSEW.g:1465:59: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // InternalSEW.g:1466:2: iv_ruleequalityExpression= ruleequalityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleequalityExpression=ruleequalityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleequalityExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleequalityExpression"


    // $ANTLR start "ruleequalityExpression"
    // InternalSEW.g:1472:1: ruleequalityExpression returns [EObject current=null] : (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? ) ;
    public final EObject ruleequalityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        EObject this_relationalExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1478:2: ( (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? ) )
            // InternalSEW.g:1479:2: (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? )
            {
            // InternalSEW.g:1479:2: (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? )
            // InternalSEW.g:1480:3: this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_29);
            this_relationalExpression_0=rulerelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_relationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1491:3: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=39 && LA47_0<=43)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalSEW.g:1492:4: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) )
                    {
                    // InternalSEW.g:1492:4: ()
                    // InternalSEW.g:1493:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getEqualityExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1502:4: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) )
                    // InternalSEW.g:1503:5: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) )
                    {
                    // InternalSEW.g:1503:5: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) )
                    // InternalSEW.g:1504:6: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' )
                    {
                    // InternalSEW.g:1504:6: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' )
                    int alt46=5;
                    switch ( input.LA(1) ) {
                    case 39:
                        {
                        alt46=1;
                        }
                        break;
                    case 40:
                        {
                        alt46=2;
                        }
                        break;
                    case 41:
                        {
                        alt46=3;
                        }
                        break;
                    case 42:
                        {
                        alt46=4;
                        }
                        break;
                    case 43:
                        {
                        alt46=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // InternalSEW.g:1505:7: lv_operator_2_1= '=='
                            {
                            lv_operator_2_1=(Token)match(input,39,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_1, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:1516:7: lv_operator_2_2= '!='
                            {
                            lv_operator_2_2=(Token)match(input,40,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_2, grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalSEW.g:1527:7: lv_operator_2_3= '==='
                            {
                            lv_operator_2_3=(Token)match(input,41,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_3, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignEqualsSignKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalSEW.g:1538:7: lv_operator_2_4= '=!='
                            {
                            lv_operator_2_4=(Token)match(input,42,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_4, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignExclamationMarkEqualsSignKeyword_1_1_0_3());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
                              						
                            }

                            }
                            break;
                        case 5 :
                            // InternalSEW.g:1549:7: lv_operator_2_5= '=/='
                            {
                            lv_operator_2_5=(Token)match(input,43,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_5, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignSolidusEqualsSignKeyword_1_1_0_4());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_5, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:1562:4: ( (lv_operand_3_0= rulerelationalExpression ) )
                    // InternalSEW.g:1563:5: (lv_operand_3_0= rulerelationalExpression )
                    {
                    // InternalSEW.g:1563:5: (lv_operand_3_0= rulerelationalExpression )
                    // InternalSEW.g:1564:6: lv_operand_3_0= rulerelationalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_3_0=rulerelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.relationalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleequalityExpression"


    // $ANTLR start "entryRulerelationalExpression"
    // InternalSEW.g:1586:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // InternalSEW.g:1586:61: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // InternalSEW.g:1587:2: iv_rulerelationalExpression= rulerelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulerelationalExpression=rulerelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerelationalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulerelationalExpression"


    // $ANTLR start "rulerelationalExpression"
    // InternalSEW.g:1593:1: rulerelationalExpression returns [EObject current=null] : (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? ) ;
    public final EObject rulerelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        EObject this_additiveExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1599:2: ( (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? ) )
            // InternalSEW.g:1600:2: (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? )
            {
            // InternalSEW.g:1600:2: (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? )
            // InternalSEW.g:1601:3: this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_30);
            this_additiveExpression_0=ruleadditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_additiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1612:3: ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==20||(LA49_0>=44 && LA49_0<=46)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalSEW.g:1613:4: () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) )
                    {
                    // InternalSEW.g:1613:4: ()
                    // InternalSEW.g:1614:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getRelationalExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1623:4: ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) )
                    // InternalSEW.g:1624:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
                    {
                    // InternalSEW.g:1624:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
                    // InternalSEW.g:1625:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
                    {
                    // InternalSEW.g:1625:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
                    int alt48=4;
                    switch ( input.LA(1) ) {
                    case 20:
                        {
                        alt48=1;
                        }
                        break;
                    case 44:
                        {
                        alt48=2;
                        }
                        break;
                    case 45:
                        {
                        alt48=3;
                        }
                        break;
                    case 46:
                        {
                        alt48=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }

                    switch (alt48) {
                        case 1 :
                            // InternalSEW.g:1626:7: lv_operator_2_1= '<'
                            {
                            lv_operator_2_1=(Token)match(input,20,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_1, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:1637:7: lv_operator_2_2= '<='
                            {
                            lv_operator_2_2=(Token)match(input,44,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_2, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalSEW.g:1648:7: lv_operator_2_3= '>'
                            {
                            lv_operator_2_3=(Token)match(input,45,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_3, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalSEW.g:1659:7: lv_operator_2_4= '>='
                            {
                            lv_operator_2_4=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_4, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRelationalExpressionRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:1672:4: ( (lv_operand_3_0= ruleadditiveExpression ) )
                    // InternalSEW.g:1673:5: (lv_operand_3_0= ruleadditiveExpression )
                    {
                    // InternalSEW.g:1673:5: (lv_operand_3_0= ruleadditiveExpression )
                    // InternalSEW.g:1674:6: lv_operand_3_0= ruleadditiveExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperandAdditiveExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_3_0=ruleadditiveExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.additiveExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulerelationalExpression"


    // $ANTLR start "entryRuleadditiveExpression"
    // InternalSEW.g:1696:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // InternalSEW.g:1696:59: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // InternalSEW.g:1697:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleadditiveExpression=ruleadditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleadditiveExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleadditiveExpression"


    // $ANTLR start "ruleadditiveExpression"
    // InternalSEW.g:1703:1: ruleadditiveExpression returns [EObject current=null] : (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject this_multiplicativeExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1709:2: ( (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? ) )
            // InternalSEW.g:1710:2: (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? )
            {
            // InternalSEW.g:1710:2: (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? )
            // InternalSEW.g:1711:3: this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_31);
            this_multiplicativeExpression_0=rulemultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_multiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1722:3: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalSEW.g:1723:4: () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
                    {
                    // InternalSEW.g:1723:4: ()
                    // InternalSEW.g:1724:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getAdditiveExpressionAccess().getExpressionOperandAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:1733:4: ( (lv_operator_2_0= '+' ) )
                    // InternalSEW.g:1734:5: (lv_operator_2_0= '+' )
                    {
                    // InternalSEW.g:1734:5: (lv_operator_2_0= '+' )
                    // InternalSEW.g:1735:6: lv_operator_2_0= '+'
                    {
                    lv_operator_2_0=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_0, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_0, "+");
                      					
                    }

                    }


                    }

                    // InternalSEW.g:1747:4: ( (lv_operand_3_0= rulemultiplicativeExpression ) )
                    // InternalSEW.g:1748:5: (lv_operand_3_0= rulemultiplicativeExpression )
                    {
                    // InternalSEW.g:1748:5: (lv_operand_3_0= rulemultiplicativeExpression )
                    // InternalSEW.g:1749:6: lv_operand_3_0= rulemultiplicativeExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_31);
                    lv_operand_3_0=rulemultiplicativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
                      						}
                      						add(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.multiplicativeExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:1766:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        alt50 = dfa50.predict(input);
                        switch (alt50) {
                    	case 1 :
                    	    // InternalSEW.g:1767:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalSEW.g:1771:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
                    	    // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
                    	    {
                    	    // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
                    	    // InternalSEW.g:1773:7: lv_operand_5_0= rulemultiplicativeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_31);
                    	    lv_operand_5_0=rulemultiplicativeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"operand",
                    	      								lv_operand_5_0,
                    	      								"org.eclipse.efm.sew.xtext.SEW.multiplicativeExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleadditiveExpression"


    // $ANTLR start "entryRulemultiplicativeExpression"
    // InternalSEW.g:1796:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // InternalSEW.g:1796:65: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // InternalSEW.g:1797:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulemultiplicativeExpression=rulemultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiplicativeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulemultiplicativeExpression"


    // $ANTLR start "rulemultiplicativeExpression"
    // InternalSEW.g:1803:1: rulemultiplicativeExpression returns [EObject current=null] : (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? ) ;
    public final EObject rulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        Token lv_operator_7_0=null;
        Token otherlv_9=null;
        Token lv_operator_12_0=null;
        Token otherlv_14=null;
        Token lv_operator_17_0=null;
        Token otherlv_19=null;
        EObject this_primaryExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;

        EObject lv_operand_8_0 = null;

        EObject lv_operand_10_0 = null;

        EObject lv_operand_13_0 = null;

        EObject lv_operand_15_0 = null;

        EObject lv_operand_18_0 = null;

        EObject lv_operand_20_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1809:2: ( (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? ) )
            // InternalSEW.g:1810:2: (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? )
            {
            // InternalSEW.g:1810:2: (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? )
            // InternalSEW.g:1811:3: this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_32);
            this_primaryExpression_0=ruleprimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_primaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSEW.g:1822:3: ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )?
            int alt56=5;
            switch ( input.LA(1) ) {
                case 48:
                    {
                    alt56=1;
                    }
                    break;
                case 49:
                    {
                    alt56=2;
                    }
                    break;
                case 50:
                    {
                    alt56=3;
                    }
                    break;
                case 51:
                    {
                    alt56=4;
                    }
                    break;
            }

            switch (alt56) {
                case 1 :
                    // InternalSEW.g:1823:4: ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1823:4: ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1824:5: () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1824:5: ()
                    // InternalSEW.g:1825:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalSEW.g:1834:5: ( (lv_operator_2_0= '*' ) )
                    // InternalSEW.g:1835:6: (lv_operator_2_0= '*' )
                    {
                    // InternalSEW.g:1835:6: (lv_operator_2_0= '*' )
                    // InternalSEW.g:1836:7: lv_operator_2_0= '*'
                    {
                    lv_operator_2_0=(Token)match(input,48,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operator_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operator", lv_operator_2_0, "*");
                      						
                    }

                    }


                    }

                    // InternalSEW.g:1848:5: ( (lv_operand_3_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1849:6: (lv_operand_3_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1849:6: (lv_operand_3_0= ruleprimaryExpression )
                    // InternalSEW.g:1850:7: lv_operand_3_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_33);
                    lv_operand_3_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_3_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSEW.g:1867:5: (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==48) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalSEW.g:1868:6: otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:1872:6: ( (lv_operand_5_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:1873:7: (lv_operand_5_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:1873:7: (lv_operand_5_0= ruleprimaryExpression )
                    	    // InternalSEW.g:1874:8: lv_operand_5_0= ruleprimaryExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_33);
                    	    lv_operand_5_0=ruleprimaryExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"operand",
                    	      									lv_operand_5_0,
                    	      									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:1894:4: ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1894:4: ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1895:5: () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1895:5: ()
                    // InternalSEW.g:1896:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_1_0(),
                      							current);
                      					
                    }

                    }

                    // InternalSEW.g:1905:5: ( (lv_operator_7_0= '**' ) )
                    // InternalSEW.g:1906:6: (lv_operator_7_0= '**' )
                    {
                    // InternalSEW.g:1906:6: (lv_operator_7_0= '**' )
                    // InternalSEW.g:1907:7: lv_operator_7_0= '**'
                    {
                    lv_operator_7_0=(Token)match(input,49,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operator_7_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operator", lv_operator_7_0, "**");
                      						
                    }

                    }


                    }

                    // InternalSEW.g:1919:5: ( (lv_operand_8_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1920:6: (lv_operand_8_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1920:6: (lv_operand_8_0= ruleprimaryExpression )
                    // InternalSEW.g:1921:7: lv_operand_8_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_operand_8_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_8_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSEW.g:1938:5: (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==49) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalSEW.g:1939:6: otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,49,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskAsteriskKeyword_1_1_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:1943:6: ( (lv_operand_10_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:1944:7: (lv_operand_10_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:1944:7: (lv_operand_10_0= ruleprimaryExpression )
                    	    // InternalSEW.g:1945:8: lv_operand_10_0= ruleprimaryExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    lv_operand_10_0=ruleprimaryExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"operand",
                    	      									lv_operand_10_0,
                    	      									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalSEW.g:1965:4: ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1965:4: ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1966:5: () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1966:5: ()
                    // InternalSEW.g:1967:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_2_0(),
                      							current);
                      					
                    }

                    }

                    // InternalSEW.g:1976:5: ( (lv_operator_12_0= '/' ) )
                    // InternalSEW.g:1977:6: (lv_operator_12_0= '/' )
                    {
                    // InternalSEW.g:1977:6: (lv_operator_12_0= '/' )
                    // InternalSEW.g:1978:7: lv_operator_12_0= '/'
                    {
                    lv_operator_12_0=(Token)match(input,50,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operator_12_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_2_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operator", lv_operator_12_0, "/");
                      						
                    }

                    }


                    }

                    // InternalSEW.g:1990:5: ( (lv_operand_13_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1991:6: (lv_operand_13_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1991:6: (lv_operand_13_0= ruleprimaryExpression )
                    // InternalSEW.g:1992:7: lv_operand_13_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    lv_operand_13_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_13_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSEW.g:2009:5: (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==50) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalSEW.g:2010:6: otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_14=(Token)match(input,50,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_2_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:2014:6: ( (lv_operand_15_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:2015:7: (lv_operand_15_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:2015:7: (lv_operand_15_0= ruleprimaryExpression )
                    	    // InternalSEW.g:2016:8: lv_operand_15_0= ruleprimaryExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_35);
                    	    lv_operand_15_0=ruleprimaryExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"operand",
                    	      									lv_operand_15_0,
                    	      									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // InternalSEW.g:2036:4: ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:2036:4: ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:2037:5: () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:2037:5: ()
                    // InternalSEW.g:2038:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getMultiplicativeExpressionAccess().getExpressionOperandAction_1_3_0(),
                      							current);
                      					
                    }

                    }

                    // InternalSEW.g:2047:5: ( (lv_operator_17_0= '%' ) )
                    // InternalSEW.g:2048:6: (lv_operator_17_0= '%' )
                    {
                    // InternalSEW.g:2048:6: (lv_operator_17_0= '%' )
                    // InternalSEW.g:2049:7: lv_operator_17_0= '%'
                    {
                    lv_operator_17_0=(Token)match(input,51,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operator_17_0, grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_3_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operator", lv_operator_17_0, "%");
                      						
                    }

                    }


                    }

                    // InternalSEW.g:2061:5: ( (lv_operand_18_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2062:6: (lv_operand_18_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2062:6: (lv_operand_18_0= ruleprimaryExpression )
                    // InternalSEW.g:2063:7: lv_operand_18_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_36);
                    lv_operand_18_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_18_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSEW.g:2080:5: (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==51) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalSEW.g:2081:6: otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_19=(Token)match(input,51,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_3_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:2085:6: ( (lv_operand_20_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:2086:7: (lv_operand_20_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:2086:7: (lv_operand_20_0= ruleprimaryExpression )
                    	    // InternalSEW.g:2087:8: lv_operand_20_0= ruleprimaryExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_3_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_36);
                    	    lv_operand_20_0=ruleprimaryExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"operand",
                    	      									lv_operand_20_0,
                    	      									"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulemultiplicativeExpression"


    // $ANTLR start "entryRuleprimaryExpression"
    // InternalSEW.g:2111:1: entryRuleprimaryExpression returns [EObject current=null] : iv_ruleprimaryExpression= ruleprimaryExpression EOF ;
    public final EObject entryRuleprimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimaryExpression = null;


        try {
            // InternalSEW.g:2111:58: (iv_ruleprimaryExpression= ruleprimaryExpression EOF )
            // InternalSEW.g:2112:2: iv_ruleprimaryExpression= ruleprimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleprimaryExpression=ruleprimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleprimaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleprimaryExpression"


    // $ANTLR start "ruleprimaryExpression"
    // InternalSEW.g:2118:1: ruleprimaryExpression returns [EObject current=null] : ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression ) ;
    public final EObject ruleprimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_operator_3_0=null;
        Token lv_operator_6_1=null;
        Token lv_operator_6_2=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject this_primaryExpression_1 = null;

        EObject lv_operand_4_0 = null;

        EObject lv_operand_7_0 = null;

        EObject this_Expression_9 = null;

        EObject this_LiteralExpression_11 = null;



        	enterRule();

        try {
            // InternalSEW.g:2124:2: ( ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression ) )
            // InternalSEW.g:2125:2: ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression )
            {
            // InternalSEW.g:2125:2: ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression )
            int alt58=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt58=1;
                }
                break;
            case 52:
                {
                int LA58_2 = input.LA(2);

                if ( (synpred70_InternalSEW()) ) {
                    alt58=2;
                }
                else if ( (true) ) {
                    alt58=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;
                }
                }
                break;
            case 53:
            case 54:
                {
                alt58=3;
                }
                break;
            case 55:
                {
                alt58=4;
                }
                break;
            case RULE_XIDENDIFIER:
            case RULE_CHARACTER:
            case RULE_INT:
            case RULE_STRING:
            case 14:
            case 21:
            case 26:
            case 29:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                {
                alt58=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalSEW.g:2126:3: (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2126:3: (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression )
                    // InternalSEW.g:2127:4: otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression
                    {
                    otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getPlusSignKeyword_0_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_primaryExpression_1=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_primaryExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:2144:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
                    {
                    // InternalSEW.g:2144:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
                    // InternalSEW.g:2145:4: () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
                    {
                    // InternalSEW.g:2145:4: ()
                    // InternalSEW.g:2146:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:2155:4: ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
                    // InternalSEW.g:2156:5: ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) )
                    {
                    // InternalSEW.g:2156:5: ( (lv_operator_3_0= '-' ) )
                    // InternalSEW.g:2157:6: (lv_operator_3_0= '-' )
                    {
                    // InternalSEW.g:2157:6: (lv_operator_3_0= '-' )
                    // InternalSEW.g:2158:7: lv_operator_3_0= '-'
                    {
                    lv_operator_3_0=(Token)match(input,52,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operator_3_0, grammarAccess.getPrimaryExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operator", lv_operator_3_0, "-");
                      						
                    }

                    }


                    }

                    // InternalSEW.g:2170:5: ( (lv_operand_4_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2171:6: (lv_operand_4_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2171:6: (lv_operand_4_0= ruleprimaryExpression )
                    // InternalSEW.g:2172:7: lv_operand_4_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_4_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_4_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSEW.g:2192:3: ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) )
                    {
                    // InternalSEW.g:2192:3: ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) )
                    // InternalSEW.g:2193:4: () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) )
                    {
                    // InternalSEW.g:2193:4: ()
                    // InternalSEW.g:2194:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSEW.g:2203:4: ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) )
                    // InternalSEW.g:2204:5: ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) )
                    {
                    // InternalSEW.g:2204:5: ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) )
                    // InternalSEW.g:2205:6: ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) )
                    {
                    // InternalSEW.g:2205:6: ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) )
                    // InternalSEW.g:2206:7: (lv_operator_6_1= '!' | lv_operator_6_2= 'not' )
                    {
                    // InternalSEW.g:2206:7: (lv_operator_6_1= '!' | lv_operator_6_2= 'not' )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==53) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==54) ) {
                        alt57=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 57, 0, input);

                        throw nvae;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalSEW.g:2207:8: lv_operator_6_1= '!'
                            {
                            lv_operator_6_1=(Token)match(input,53,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_operator_6_1, grammarAccess.getPrimaryExpressionAccess().getOperatorExclamationMarkKeyword_2_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                              								}
                              								setWithLastConsumed(current, "operator", lv_operator_6_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:2218:8: lv_operator_6_2= 'not'
                            {
                            lv_operator_6_2=(Token)match(input,54,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_operator_6_2, grammarAccess.getPrimaryExpressionAccess().getOperatorNotKeyword_2_1_0_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                              								}
                              								setWithLastConsumed(current, "operator", lv_operator_6_2, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSEW.g:2231:5: ( (lv_operand_7_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2232:6: (lv_operand_7_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2232:6: (lv_operand_7_0= ruleprimaryExpression )
                    // InternalSEW.g:2233:7: lv_operand_7_0= ruleprimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_7_0=ruleprimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      							}
                      							add(
                      								current,
                      								"operand",
                      								lv_operand_7_0,
                      								"org.eclipse.efm.sew.xtext.SEW.primaryExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSEW.g:2253:3: (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' )
                    {
                    // InternalSEW.g:2253:3: (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' )
                    // InternalSEW.g:2254:4: otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')'
                    {
                    otherlv_8=(Token)match(input,55,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    this_Expression_9=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_9;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_10=(Token)match(input,56,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSEW.g:2275:3: this_LiteralExpression_11= ruleLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralExpression_11=ruleLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralExpression_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleprimaryExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalSEW.g:2290:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalSEW.g:2290:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalSEW.g:2291:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalSEW.g:2297:1: ruleLiteralExpression returns [EObject current=null] : (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralBooleanValue_0 = null;

        EObject this_LiteralCharacterValue_1 = null;

        EObject this_LiteralIntegerValue_2 = null;

        EObject this_LiteralRationalValue_3 = null;

        EObject this_LiteralFloatValue_4 = null;

        EObject this_LiteralStringValue_5 = null;

        EObject this_LiteralNullValue_6 = null;

        EObject this_LiteralArrayValue_7 = null;

        EObject this_LiteralObjectReference_8 = null;

        EObject this_LiteralVariableReference_9 = null;

        EObject this_LiteralInstanceReference_10 = null;



        	enterRule();

        try {
            // InternalSEW.g:2303:2: ( (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference ) )
            // InternalSEW.g:2304:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )
            {
            // InternalSEW.g:2304:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )
            int alt59=11;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // InternalSEW.g:2305:3: this_LiteralBooleanValue_0= ruleLiteralBooleanValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralBooleanValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralBooleanValue_0=ruleLiteralBooleanValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralBooleanValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:2317:3: this_LiteralCharacterValue_1= ruleLiteralCharacterValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralCharacterValueParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralCharacterValue_1=ruleLiteralCharacterValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralCharacterValue_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:2329:3: this_LiteralIntegerValue_2= ruleLiteralIntegerValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralIntegerValueParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralIntegerValue_2=ruleLiteralIntegerValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralIntegerValue_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSEW.g:2341:3: this_LiteralRationalValue_3= ruleLiteralRationalValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralRationalValueParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralRationalValue_3=ruleLiteralRationalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRationalValue_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSEW.g:2353:3: this_LiteralFloatValue_4= ruleLiteralFloatValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralFloatValueParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralFloatValue_4=ruleLiteralFloatValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralFloatValue_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSEW.g:2365:3: this_LiteralStringValue_5= ruleLiteralStringValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralStringValueParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralStringValue_5=ruleLiteralStringValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralStringValue_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalSEW.g:2377:3: this_LiteralNullValue_6= ruleLiteralNullValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralNullValueParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralNullValue_6=ruleLiteralNullValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralNullValue_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalSEW.g:2389:3: this_LiteralArrayValue_7= ruleLiteralArrayValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralArrayValueParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralArrayValue_7=ruleLiteralArrayValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralArrayValue_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalSEW.g:2401:3: this_LiteralObjectReference_8= ruleLiteralObjectReference
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralObjectReferenceParserRuleCall_8());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralObjectReference_8=ruleLiteralObjectReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralObjectReference_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalSEW.g:2413:3: this_LiteralVariableReference_9= ruleLiteralVariableReference
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralVariableReferenceParserRuleCall_9());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralVariableReference_9=ruleLiteralVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralVariableReference_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalSEW.g:2425:3: this_LiteralInstanceReference_10= ruleLiteralInstanceReference
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getLiteralInstanceReferenceParserRuleCall_10());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralInstanceReference_10=ruleLiteralInstanceReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralInstanceReference_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleLiteralArrayValue"
    // InternalSEW.g:2440:1: entryRuleLiteralArrayValue returns [EObject current=null] : iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF ;
    public final EObject entryRuleLiteralArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralArrayValue = null;


        try {
            // InternalSEW.g:2440:58: (iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF )
            // InternalSEW.g:2441:2: iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralArrayValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralArrayValue=ruleLiteralArrayValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralArrayValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralArrayValue"


    // $ANTLR start "ruleLiteralArrayValue"
    // InternalSEW.g:2447:1: ruleLiteralArrayValue returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleLiteralArrayValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2453:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' ) )
            // InternalSEW.g:2454:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' )
            {
            // InternalSEW.g:2454:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' )
            // InternalSEW.g:2455:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']'
            {
            // InternalSEW.g:2455:3: ()
            // InternalSEW.g:2456:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralArrayValueAccess().getLiteralArrayValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralArrayValueAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalSEW.g:2469:3: ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=RULE_XIDENDIFIER && LA61_0<=RULE_STRING)||LA61_0==14||LA61_0==21||LA61_0==26||LA61_0==29||LA61_0==47||(LA61_0>=52 && LA61_0<=55)||(LA61_0>=57 && LA61_0<=75)||LA61_0==78) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalSEW.g:2470:4: ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )*
                    {
                    // InternalSEW.g:2470:4: ( (lv_values_2_0= ruleValueSpecification ) )
                    // InternalSEW.g:2471:5: (lv_values_2_0= ruleValueSpecification )
                    {
                    // InternalSEW.g:2471:5: (lv_values_2_0= ruleValueSpecification )
                    // InternalSEW.g:2472:6: lv_values_2_0= ruleValueSpecification
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_values_2_0=ruleValueSpecification();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLiteralArrayValueRule());
                      						}
                      						add(
                      							current,
                      							"values",
                      							lv_values_2_0,
                      							"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:2489:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==22) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalSEW.g:2490:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getLiteralArrayValueAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalSEW.g:2494:5: ( (lv_values_4_0= ruleValueSpecification ) )
                    	    // InternalSEW.g:2495:6: (lv_values_4_0= ruleValueSpecification )
                    	    {
                    	    // InternalSEW.g:2495:6: (lv_values_4_0= ruleValueSpecification )
                    	    // InternalSEW.g:2496:7: lv_values_4_0= ruleValueSpecification
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getLiteralArrayValueAccess().getValuesValueSpecificationParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_39);
                    	    lv_values_4_0=ruleValueSpecification();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getLiteralArrayValueRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_4_0,
                    	      								"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLiteralArrayValueAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralArrayValue"


    // $ANTLR start "entryRuleLiteralObjectReference"
    // InternalSEW.g:2523:1: entryRuleLiteralObjectReference returns [EObject current=null] : iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF ;
    public final EObject entryRuleLiteralObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralObjectReference = null;


        try {
            // InternalSEW.g:2523:63: (iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF )
            // InternalSEW.g:2524:2: iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralObjectReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralObjectReference=ruleLiteralObjectReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralObjectReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralObjectReference"


    // $ANTLR start "ruleLiteralObjectReference"
    // InternalSEW.g:2530:1: ruleLiteralObjectReference returns [EObject current=null] : ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) ) ;
    public final EObject ruleLiteralObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_symbol_2_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2536:2: ( ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) ) )
            // InternalSEW.g:2537:2: ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) )
            {
            // InternalSEW.g:2537:2: ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) )
            // InternalSEW.g:2538:3: (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )
            {
            // InternalSEW.g:2538:3: (otherlv_0= '&' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==57) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalSEW.g:2539:4: otherlv_0= '&'
                    {
                    otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:2544:3: ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // InternalSEW.g:2545:4: ( ( ruleUFI ) )
                    {
                    // InternalSEW.g:2545:4: ( ( ruleUFI ) )
                    // InternalSEW.g:2546:5: ( ruleUFI )
                    {
                    // InternalSEW.g:2546:5: ( ruleUFI )
                    // InternalSEW.g:2547:6: ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralObjectReferenceRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLiteralObjectReferenceAccess().getObjectWObjectCrossReference_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:2565:4: ( (lv_symbol_2_0= ruleUFI ) )
                    {
                    // InternalSEW.g:2565:4: ( (lv_symbol_2_0= ruleUFI ) )
                    // InternalSEW.g:2566:5: (lv_symbol_2_0= ruleUFI )
                    {
                    // InternalSEW.g:2566:5: (lv_symbol_2_0= ruleUFI )
                    // InternalSEW.g:2567:6: lv_symbol_2_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLiteralObjectReferenceAccess().getSymbolUFIParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_symbol_2_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLiteralObjectReferenceRule());
                      						}
                      						set(
                      							current,
                      							"symbol",
                      							lv_symbol_2_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralObjectReference"


    // $ANTLR start "entryRuleLiteralBooleanValue"
    // InternalSEW.g:2589:1: entryRuleLiteralBooleanValue returns [EObject current=null] : iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF ;
    public final EObject entryRuleLiteralBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBooleanValue = null;


        try {
            // InternalSEW.g:2589:60: (iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF )
            // InternalSEW.g:2590:2: iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralBooleanValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralBooleanValue=ruleLiteralBooleanValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralBooleanValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralBooleanValue"


    // $ANTLR start "ruleLiteralBooleanValue"
    // InternalSEW.g:2596:1: ruleLiteralBooleanValue returns [EObject current=null] : ( (lv_value_0_0= ruleEBoolean ) ) ;
    public final EObject ruleLiteralBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2602:2: ( ( (lv_value_0_0= ruleEBoolean ) ) )
            // InternalSEW.g:2603:2: ( (lv_value_0_0= ruleEBoolean ) )
            {
            // InternalSEW.g:2603:2: ( (lv_value_0_0= ruleEBoolean ) )
            // InternalSEW.g:2604:3: (lv_value_0_0= ruleEBoolean )
            {
            // InternalSEW.g:2604:3: (lv_value_0_0= ruleEBoolean )
            // InternalSEW.g:2605:4: lv_value_0_0= ruleEBoolean
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralBooleanValueAccess().getValueEBooleanParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleEBoolean();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLiteralBooleanValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.efm.sew.xtext.SEW.EBoolean");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralBooleanValue"


    // $ANTLR start "entryRuleLiteralCharacterValue"
    // InternalSEW.g:2625:1: entryRuleLiteralCharacterValue returns [EObject current=null] : iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF ;
    public final EObject entryRuleLiteralCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralCharacterValue = null;


        try {
            // InternalSEW.g:2625:62: (iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF )
            // InternalSEW.g:2626:2: iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralCharacterValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralCharacterValue=ruleLiteralCharacterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralCharacterValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralCharacterValue"


    // $ANTLR start "ruleLiteralCharacterValue"
    // InternalSEW.g:2632:1: ruleLiteralCharacterValue returns [EObject current=null] : ( (lv_value_0_0= ruleEChar ) ) ;
    public final EObject ruleLiteralCharacterValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2638:2: ( ( (lv_value_0_0= ruleEChar ) ) )
            // InternalSEW.g:2639:2: ( (lv_value_0_0= ruleEChar ) )
            {
            // InternalSEW.g:2639:2: ( (lv_value_0_0= ruleEChar ) )
            // InternalSEW.g:2640:3: (lv_value_0_0= ruleEChar )
            {
            // InternalSEW.g:2640:3: (lv_value_0_0= ruleEChar )
            // InternalSEW.g:2641:4: lv_value_0_0= ruleEChar
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralCharacterValueAccess().getValueECharParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleEChar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLiteralCharacterValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.efm.sew.xtext.SEW.EChar");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralCharacterValue"


    // $ANTLR start "entryRuleLiteralIntegerValue"
    // InternalSEW.g:2661:1: entryRuleLiteralIntegerValue returns [EObject current=null] : iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF ;
    public final EObject entryRuleLiteralIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralIntegerValue = null;


        try {
            // InternalSEW.g:2661:60: (iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF )
            // InternalSEW.g:2662:2: iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralIntegerValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralIntegerValue=ruleLiteralIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralIntegerValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralIntegerValue"


    // $ANTLR start "ruleLiteralIntegerValue"
    // InternalSEW.g:2668:1: ruleLiteralIntegerValue returns [EObject current=null] : ( (lv_value_0_0= ruleELong ) ) ;
    public final EObject ruleLiteralIntegerValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2674:2: ( ( (lv_value_0_0= ruleELong ) ) )
            // InternalSEW.g:2675:2: ( (lv_value_0_0= ruleELong ) )
            {
            // InternalSEW.g:2675:2: ( (lv_value_0_0= ruleELong ) )
            // InternalSEW.g:2676:3: (lv_value_0_0= ruleELong )
            {
            // InternalSEW.g:2676:3: (lv_value_0_0= ruleELong )
            // InternalSEW.g:2677:4: lv_value_0_0= ruleELong
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralIntegerValueAccess().getValueELongParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleELong();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLiteralIntegerValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.efm.sew.xtext.SEW.ELong");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralIntegerValue"


    // $ANTLR start "entryRuleLiteralRationalValue"
    // InternalSEW.g:2697:1: entryRuleLiteralRationalValue returns [EObject current=null] : iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF ;
    public final EObject entryRuleLiteralRationalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRationalValue = null;


        try {
            // InternalSEW.g:2697:61: (iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF )
            // InternalSEW.g:2698:2: iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRationalValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralRationalValue=ruleLiteralRationalValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralRationalValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralRationalValue"


    // $ANTLR start "ruleLiteralRationalValue"
    // InternalSEW.g:2704:1: ruleLiteralRationalValue returns [EObject current=null] : ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) ) ;
    public final EObject ruleLiteralRationalValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_numerator_0_0 = null;

        AntlrDatatypeRuleToken lv_denominator_2_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2710:2: ( ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) ) )
            // InternalSEW.g:2711:2: ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) )
            {
            // InternalSEW.g:2711:2: ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) )
            // InternalSEW.g:2712:3: ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) )
            {
            // InternalSEW.g:2712:3: ( (lv_numerator_0_0= ruleELong ) )
            // InternalSEW.g:2713:4: (lv_numerator_0_0= ruleELong )
            {
            // InternalSEW.g:2713:4: (lv_numerator_0_0= ruleELong )
            // InternalSEW.g:2714:5: lv_numerator_0_0= ruleELong
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralRationalValueAccess().getNumeratorELongParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_40);
            lv_numerator_0_0=ruleELong();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLiteralRationalValueRule());
              					}
              					set(
              						current,
              						"numerator",
              						lv_numerator_0_0,
              						"org.eclipse.efm.sew.xtext.SEW.ELong");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralRationalValueAccess().getSolidusKeyword_1());
              		
            }
            // InternalSEW.g:2735:3: ( (lv_denominator_2_0= ruleELong ) )
            // InternalSEW.g:2736:4: (lv_denominator_2_0= ruleELong )
            {
            // InternalSEW.g:2736:4: (lv_denominator_2_0= ruleELong )
            // InternalSEW.g:2737:5: lv_denominator_2_0= ruleELong
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralRationalValueAccess().getDenominatorELongParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_denominator_2_0=ruleELong();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLiteralRationalValueRule());
              					}
              					set(
              						current,
              						"denominator",
              						lv_denominator_2_0,
              						"org.eclipse.efm.sew.xtext.SEW.ELong");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralRationalValue"


    // $ANTLR start "entryRuleLiteralFloatValue"
    // InternalSEW.g:2758:1: entryRuleLiteralFloatValue returns [EObject current=null] : iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF ;
    public final EObject entryRuleLiteralFloatValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFloatValue = null;


        try {
            // InternalSEW.g:2758:58: (iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF )
            // InternalSEW.g:2759:2: iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralFloatValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralFloatValue=ruleLiteralFloatValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralFloatValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralFloatValue"


    // $ANTLR start "ruleLiteralFloatValue"
    // InternalSEW.g:2765:1: ruleLiteralFloatValue returns [EObject current=null] : ( (lv_value_0_0= ruleEDouble ) ) ;
    public final EObject ruleLiteralFloatValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2771:2: ( ( (lv_value_0_0= ruleEDouble ) ) )
            // InternalSEW.g:2772:2: ( (lv_value_0_0= ruleEDouble ) )
            {
            // InternalSEW.g:2772:2: ( (lv_value_0_0= ruleEDouble ) )
            // InternalSEW.g:2773:3: (lv_value_0_0= ruleEDouble )
            {
            // InternalSEW.g:2773:3: (lv_value_0_0= ruleEDouble )
            // InternalSEW.g:2774:4: lv_value_0_0= ruleEDouble
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralFloatValueAccess().getValueEDoubleParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLiteralFloatValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.efm.sew.xtext.SEW.EDouble");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralFloatValue"


    // $ANTLR start "entryRuleLiteralStringValue"
    // InternalSEW.g:2794:1: entryRuleLiteralStringValue returns [EObject current=null] : iv_ruleLiteralStringValue= ruleLiteralStringValue EOF ;
    public final EObject entryRuleLiteralStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralStringValue = null;


        try {
            // InternalSEW.g:2794:59: (iv_ruleLiteralStringValue= ruleLiteralStringValue EOF )
            // InternalSEW.g:2795:2: iv_ruleLiteralStringValue= ruleLiteralStringValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralStringValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralStringValue=ruleLiteralStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralStringValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralStringValue"


    // $ANTLR start "ruleLiteralStringValue"
    // InternalSEW.g:2801:1: ruleLiteralStringValue returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleLiteralStringValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2807:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalSEW.g:2808:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalSEW.g:2808:2: ( (lv_value_0_0= ruleEString ) )
            // InternalSEW.g:2809:3: (lv_value_0_0= ruleEString )
            {
            // InternalSEW.g:2809:3: (lv_value_0_0= ruleEString )
            // InternalSEW.g:2810:4: lv_value_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralStringValueAccess().getValueEStringParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLiteralStringValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.efm.sew.xtext.SEW.EString");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralStringValue"


    // $ANTLR start "entryRuleLiteralNullValue"
    // InternalSEW.g:2830:1: entryRuleLiteralNullValue returns [EObject current=null] : iv_ruleLiteralNullValue= ruleLiteralNullValue EOF ;
    public final EObject entryRuleLiteralNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNullValue = null;


        try {
            // InternalSEW.g:2830:57: (iv_ruleLiteralNullValue= ruleLiteralNullValue EOF )
            // InternalSEW.g:2831:2: iv_ruleLiteralNullValue= ruleLiteralNullValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralNullValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralNullValue=ruleLiteralNullValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralNullValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralNullValue"


    // $ANTLR start "ruleLiteralNullValue"
    // InternalSEW.g:2837:1: ruleLiteralNullValue returns [EObject current=null] : ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? ) ;
    public final EObject ruleLiteralNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2843:2: ( ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? ) )
            // InternalSEW.g:2844:2: ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? )
            {
            // InternalSEW.g:2844:2: ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? )
            // InternalSEW.g:2845:3: () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?
            {
            // InternalSEW.g:2845:3: ()
            // InternalSEW.g:2846:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralNullValueAccess().getLiteralNullValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,58,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralNullValueAccess().getNullKeyword_1());
              		
            }
            // InternalSEW.g:2859:3: (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?
            int alt64=2;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalSEW.g:2860:4: otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLiteralNullValueAccess().getLessThanSignKeyword_2_0());
                      			
                    }
                    // InternalSEW.g:2864:4: ( (lv_type_3_0= ruleXID ) )
                    // InternalSEW.g:2865:5: (lv_type_3_0= ruleXID )
                    {
                    // InternalSEW.g:2865:5: (lv_type_3_0= ruleXID )
                    // InternalSEW.g:2866:6: lv_type_3_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLiteralNullValueAccess().getTypeXIDParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_43);
                    lv_type_3_0=ruleXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLiteralNullValueRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_0,
                      							"org.eclipse.efm.sew.xtext.SEW.XID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLiteralNullValueAccess().getGreaterThanSignKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralNullValue"


    // $ANTLR start "entryRuleLiteralVariableReference"
    // InternalSEW.g:2892:1: entryRuleLiteralVariableReference returns [EObject current=null] : iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF ;
    public final EObject entryRuleLiteralVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralVariableReference = null;


        try {
            // InternalSEW.g:2892:65: (iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF )
            // InternalSEW.g:2893:2: iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralVariableReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralVariableReference=ruleLiteralVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralVariableReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralVariableReference"


    // $ANTLR start "ruleLiteralVariableReference"
    // InternalSEW.g:2899:1: ruleLiteralVariableReference returns [EObject current=null] : (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable ) ;
    public final EObject ruleLiteralVariableReference() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralTimeVariable_0 = null;

        EObject this_LiteralTimeDeltaVariable_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:2905:2: ( (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable ) )
            // InternalSEW.g:2906:2: (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable )
            {
            // InternalSEW.g:2906:2: (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==59) ) {
                alt65=1;
            }
            else if ( (LA65_0==60) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalSEW.g:2907:3: this_LiteralTimeVariable_0= ruleLiteralTimeVariable
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeVariableParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralTimeVariable_0=ruleLiteralTimeVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTimeVariable_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:2919:3: this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralVariableReferenceAccess().getLiteralTimeDeltaVariableParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralTimeDeltaVariable_1=ruleLiteralTimeDeltaVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTimeDeltaVariable_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralVariableReference"


    // $ANTLR start "entryRuleLiteralTimeVariable"
    // InternalSEW.g:2934:1: entryRuleLiteralTimeVariable returns [EObject current=null] : iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF ;
    public final EObject entryRuleLiteralTimeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTimeVariable = null;


        try {
            // InternalSEW.g:2934:60: (iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF )
            // InternalSEW.g:2935:2: iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralTimeVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralTimeVariable=ruleLiteralTimeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralTimeVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralTimeVariable"


    // $ANTLR start "ruleLiteralTimeVariable"
    // InternalSEW.g:2941:1: ruleLiteralTimeVariable returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$time' ) ) ) ;
    public final EObject ruleLiteralTimeVariable() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:2947:2: ( ( () ( (lv_symbol_1_0= '$time' ) ) ) )
            // InternalSEW.g:2948:2: ( () ( (lv_symbol_1_0= '$time' ) ) )
            {
            // InternalSEW.g:2948:2: ( () ( (lv_symbol_1_0= '$time' ) ) )
            // InternalSEW.g:2949:3: () ( (lv_symbol_1_0= '$time' ) )
            {
            // InternalSEW.g:2949:3: ()
            // InternalSEW.g:2950:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralTimeVariableAccess().getLiteralTimeVariableAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:2959:3: ( (lv_symbol_1_0= '$time' ) )
            // InternalSEW.g:2960:4: (lv_symbol_1_0= '$time' )
            {
            // InternalSEW.g:2960:4: (lv_symbol_1_0= '$time' )
            // InternalSEW.g:2961:5: lv_symbol_1_0= '$time'
            {
            lv_symbol_1_0=(Token)match(input,59,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralTimeVariableAccess().getSymbolTimeKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralTimeVariableRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$time");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralTimeVariable"


    // $ANTLR start "entryRuleLiteralTimeDeltaVariable"
    // InternalSEW.g:2977:1: entryRuleLiteralTimeDeltaVariable returns [EObject current=null] : iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF ;
    public final EObject entryRuleLiteralTimeDeltaVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTimeDeltaVariable = null;


        try {
            // InternalSEW.g:2977:65: (iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF )
            // InternalSEW.g:2978:2: iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralTimeDeltaVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralTimeDeltaVariable=ruleLiteralTimeDeltaVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralTimeDeltaVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralTimeDeltaVariable"


    // $ANTLR start "ruleLiteralTimeDeltaVariable"
    // InternalSEW.g:2984:1: ruleLiteralTimeDeltaVariable returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$delta' ) ) ) ;
    public final EObject ruleLiteralTimeDeltaVariable() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:2990:2: ( ( () ( (lv_symbol_1_0= '$delta' ) ) ) )
            // InternalSEW.g:2991:2: ( () ( (lv_symbol_1_0= '$delta' ) ) )
            {
            // InternalSEW.g:2991:2: ( () ( (lv_symbol_1_0= '$delta' ) ) )
            // InternalSEW.g:2992:3: () ( (lv_symbol_1_0= '$delta' ) )
            {
            // InternalSEW.g:2992:3: ()
            // InternalSEW.g:2993:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralTimeDeltaVariableAccess().getLiteralTimeDeltaVariableAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3002:3: ( (lv_symbol_1_0= '$delta' ) )
            // InternalSEW.g:3003:4: (lv_symbol_1_0= '$delta' )
            {
            // InternalSEW.g:3003:4: (lv_symbol_1_0= '$delta' )
            // InternalSEW.g:3004:5: lv_symbol_1_0= '$delta'
            {
            lv_symbol_1_0=(Token)match(input,60,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralTimeDeltaVariableAccess().getSymbolDeltaKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralTimeDeltaVariableRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$delta");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralTimeDeltaVariable"


    // $ANTLR start "entryRuleLiteralInstanceReference"
    // InternalSEW.g:3020:1: entryRuleLiteralInstanceReference returns [EObject current=null] : iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF ;
    public final EObject entryRuleLiteralInstanceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralInstanceReference = null;


        try {
            // InternalSEW.g:3020:65: (iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF )
            // InternalSEW.g:3021:2: iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralInstanceReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralInstanceReference=ruleLiteralInstanceReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralInstanceReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralInstanceReference"


    // $ANTLR start "ruleLiteralInstanceReference"
    // InternalSEW.g:3027:1: ruleLiteralInstanceReference returns [EObject current=null] : (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance ) ;
    public final EObject ruleLiteralInstanceReference() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralThisInstance_0 = null;

        EObject this_LiteralSelfInstance_1 = null;

        EObject this_LiteralParentInstance_2 = null;

        EObject this_LiteralSuperInstance_3 = null;

        EObject this_LiteralSystemInstance_4 = null;

        EObject this_LiteralEnvInstance_5 = null;



        	enterRule();

        try {
            // InternalSEW.g:3033:2: ( (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance ) )
            // InternalSEW.g:3034:2: (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance )
            {
            // InternalSEW.g:3034:2: (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance )
            int alt66=6;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt66=1;
                }
                break;
            case 62:
                {
                alt66=2;
                }
                break;
            case 63:
                {
                alt66=3;
                }
                break;
            case 64:
                {
                alt66=4;
                }
                break;
            case 65:
                {
                alt66=5;
                }
                break;
            case 66:
            case 67:
                {
                alt66=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalSEW.g:3035:3: this_LiteralThisInstance_0= ruleLiteralThisInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralThisInstanceParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralThisInstance_0=ruleLiteralThisInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralThisInstance_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3047:3: this_LiteralSelfInstance_1= ruleLiteralSelfInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSelfInstanceParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralSelfInstance_1=ruleLiteralSelfInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralSelfInstance_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:3059:3: this_LiteralParentInstance_2= ruleLiteralParentInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralParentInstanceParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralParentInstance_2=ruleLiteralParentInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralParentInstance_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSEW.g:3071:3: this_LiteralSuperInstance_3= ruleLiteralSuperInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSuperInstanceParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralSuperInstance_3=ruleLiteralSuperInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralSuperInstance_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSEW.g:3083:3: this_LiteralSystemInstance_4= ruleLiteralSystemInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralSystemInstanceParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralSystemInstance_4=ruleLiteralSystemInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralSystemInstance_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSEW.g:3095:3: this_LiteralEnvInstance_5= ruleLiteralEnvInstance
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralInstanceReferenceAccess().getLiteralEnvInstanceParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralEnvInstance_5=ruleLiteralEnvInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralEnvInstance_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralInstanceReference"


    // $ANTLR start "entryRuleLiteralThisInstance"
    // InternalSEW.g:3110:1: entryRuleLiteralThisInstance returns [EObject current=null] : iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF ;
    public final EObject entryRuleLiteralThisInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralThisInstance = null;


        try {
            // InternalSEW.g:3110:60: (iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF )
            // InternalSEW.g:3111:2: iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralThisInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralThisInstance=ruleLiteralThisInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralThisInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralThisInstance"


    // $ANTLR start "ruleLiteralThisInstance"
    // InternalSEW.g:3117:1: ruleLiteralThisInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$this' ) ) ) ;
    public final EObject ruleLiteralThisInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3123:2: ( ( () ( (lv_symbol_1_0= '$this' ) ) ) )
            // InternalSEW.g:3124:2: ( () ( (lv_symbol_1_0= '$this' ) ) )
            {
            // InternalSEW.g:3124:2: ( () ( (lv_symbol_1_0= '$this' ) ) )
            // InternalSEW.g:3125:3: () ( (lv_symbol_1_0= '$this' ) )
            {
            // InternalSEW.g:3125:3: ()
            // InternalSEW.g:3126:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralThisInstanceAccess().getLiteralThisInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3135:3: ( (lv_symbol_1_0= '$this' ) )
            // InternalSEW.g:3136:4: (lv_symbol_1_0= '$this' )
            {
            // InternalSEW.g:3136:4: (lv_symbol_1_0= '$this' )
            // InternalSEW.g:3137:5: lv_symbol_1_0= '$this'
            {
            lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralThisInstanceAccess().getSymbolThisKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralThisInstanceRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$this");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralThisInstance"


    // $ANTLR start "entryRuleLiteralSelfInstance"
    // InternalSEW.g:3153:1: entryRuleLiteralSelfInstance returns [EObject current=null] : iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF ;
    public final EObject entryRuleLiteralSelfInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSelfInstance = null;


        try {
            // InternalSEW.g:3153:60: (iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF )
            // InternalSEW.g:3154:2: iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralSelfInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralSelfInstance=ruleLiteralSelfInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralSelfInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralSelfInstance"


    // $ANTLR start "ruleLiteralSelfInstance"
    // InternalSEW.g:3160:1: ruleLiteralSelfInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$self' ) ) ) ;
    public final EObject ruleLiteralSelfInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3166:2: ( ( () ( (lv_symbol_1_0= '$self' ) ) ) )
            // InternalSEW.g:3167:2: ( () ( (lv_symbol_1_0= '$self' ) ) )
            {
            // InternalSEW.g:3167:2: ( () ( (lv_symbol_1_0= '$self' ) ) )
            // InternalSEW.g:3168:3: () ( (lv_symbol_1_0= '$self' ) )
            {
            // InternalSEW.g:3168:3: ()
            // InternalSEW.g:3169:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralSelfInstanceAccess().getLiteralSelfInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3178:3: ( (lv_symbol_1_0= '$self' ) )
            // InternalSEW.g:3179:4: (lv_symbol_1_0= '$self' )
            {
            // InternalSEW.g:3179:4: (lv_symbol_1_0= '$self' )
            // InternalSEW.g:3180:5: lv_symbol_1_0= '$self'
            {
            lv_symbol_1_0=(Token)match(input,62,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSelfInstanceAccess().getSymbolSelfKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralSelfInstanceRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$self");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralSelfInstance"


    // $ANTLR start "entryRuleLiteralParentInstance"
    // InternalSEW.g:3196:1: entryRuleLiteralParentInstance returns [EObject current=null] : iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF ;
    public final EObject entryRuleLiteralParentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralParentInstance = null;


        try {
            // InternalSEW.g:3196:62: (iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF )
            // InternalSEW.g:3197:2: iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralParentInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralParentInstance=ruleLiteralParentInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralParentInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralParentInstance"


    // $ANTLR start "ruleLiteralParentInstance"
    // InternalSEW.g:3203:1: ruleLiteralParentInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$parent' ) ) ) ;
    public final EObject ruleLiteralParentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3209:2: ( ( () ( (lv_symbol_1_0= '$parent' ) ) ) )
            // InternalSEW.g:3210:2: ( () ( (lv_symbol_1_0= '$parent' ) ) )
            {
            // InternalSEW.g:3210:2: ( () ( (lv_symbol_1_0= '$parent' ) ) )
            // InternalSEW.g:3211:3: () ( (lv_symbol_1_0= '$parent' ) )
            {
            // InternalSEW.g:3211:3: ()
            // InternalSEW.g:3212:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralParentInstanceAccess().getLiteralParentInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3221:3: ( (lv_symbol_1_0= '$parent' ) )
            // InternalSEW.g:3222:4: (lv_symbol_1_0= '$parent' )
            {
            // InternalSEW.g:3222:4: (lv_symbol_1_0= '$parent' )
            // InternalSEW.g:3223:5: lv_symbol_1_0= '$parent'
            {
            lv_symbol_1_0=(Token)match(input,63,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralParentInstanceAccess().getSymbolParentKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralParentInstanceRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$parent");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralParentInstance"


    // $ANTLR start "entryRuleLiteralSuperInstance"
    // InternalSEW.g:3239:1: entryRuleLiteralSuperInstance returns [EObject current=null] : iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF ;
    public final EObject entryRuleLiteralSuperInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSuperInstance = null;


        try {
            // InternalSEW.g:3239:61: (iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF )
            // InternalSEW.g:3240:2: iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralSuperInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralSuperInstance=ruleLiteralSuperInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralSuperInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralSuperInstance"


    // $ANTLR start "ruleLiteralSuperInstance"
    // InternalSEW.g:3246:1: ruleLiteralSuperInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$super' ) ) ) ;
    public final EObject ruleLiteralSuperInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3252:2: ( ( () ( (lv_symbol_1_0= '$super' ) ) ) )
            // InternalSEW.g:3253:2: ( () ( (lv_symbol_1_0= '$super' ) ) )
            {
            // InternalSEW.g:3253:2: ( () ( (lv_symbol_1_0= '$super' ) ) )
            // InternalSEW.g:3254:3: () ( (lv_symbol_1_0= '$super' ) )
            {
            // InternalSEW.g:3254:3: ()
            // InternalSEW.g:3255:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralSuperInstanceAccess().getLiteralSuperInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3264:3: ( (lv_symbol_1_0= '$super' ) )
            // InternalSEW.g:3265:4: (lv_symbol_1_0= '$super' )
            {
            // InternalSEW.g:3265:4: (lv_symbol_1_0= '$super' )
            // InternalSEW.g:3266:5: lv_symbol_1_0= '$super'
            {
            lv_symbol_1_0=(Token)match(input,64,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSuperInstanceAccess().getSymbolSuperKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralSuperInstanceRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$super");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralSuperInstance"


    // $ANTLR start "entryRuleLiteralSystemInstance"
    // InternalSEW.g:3282:1: entryRuleLiteralSystemInstance returns [EObject current=null] : iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF ;
    public final EObject entryRuleLiteralSystemInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSystemInstance = null;


        try {
            // InternalSEW.g:3282:62: (iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF )
            // InternalSEW.g:3283:2: iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralSystemInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralSystemInstance=ruleLiteralSystemInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralSystemInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralSystemInstance"


    // $ANTLR start "ruleLiteralSystemInstance"
    // InternalSEW.g:3289:1: ruleLiteralSystemInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$system' ) ) ) ;
    public final EObject ruleLiteralSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3295:2: ( ( () ( (lv_symbol_1_0= '$system' ) ) ) )
            // InternalSEW.g:3296:2: ( () ( (lv_symbol_1_0= '$system' ) ) )
            {
            // InternalSEW.g:3296:2: ( () ( (lv_symbol_1_0= '$system' ) ) )
            // InternalSEW.g:3297:3: () ( (lv_symbol_1_0= '$system' ) )
            {
            // InternalSEW.g:3297:3: ()
            // InternalSEW.g:3298:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralSystemInstanceAccess().getLiteralSystemInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3307:3: ( (lv_symbol_1_0= '$system' ) )
            // InternalSEW.g:3308:4: (lv_symbol_1_0= '$system' )
            {
            // InternalSEW.g:3308:4: (lv_symbol_1_0= '$system' )
            // InternalSEW.g:3309:5: lv_symbol_1_0= '$system'
            {
            lv_symbol_1_0=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_symbol_1_0, grammarAccess.getLiteralSystemInstanceAccess().getSymbolSystemKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLiteralSystemInstanceRule());
              					}
              					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "$system");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralSystemInstance"


    // $ANTLR start "entryRuleLiteralEnvInstance"
    // InternalSEW.g:3325:1: entryRuleLiteralEnvInstance returns [EObject current=null] : iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF ;
    public final EObject entryRuleLiteralEnvInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralEnvInstance = null;


        try {
            // InternalSEW.g:3325:59: (iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF )
            // InternalSEW.g:3326:2: iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralEnvInstanceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralEnvInstance=ruleLiteralEnvInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralEnvInstance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralEnvInstance"


    // $ANTLR start "ruleLiteralEnvInstance"
    // InternalSEW.g:3332:1: ruleLiteralEnvInstance returns [EObject current=null] : ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) ) ;
    public final EObject ruleLiteralEnvInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;


        	enterRule();

        try {
            // InternalSEW.g:3338:2: ( ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) ) )
            // InternalSEW.g:3339:2: ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) )
            {
            // InternalSEW.g:3339:2: ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) )
            // InternalSEW.g:3340:3: () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) )
            {
            // InternalSEW.g:3340:3: ()
            // InternalSEW.g:3341:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralEnvInstanceAccess().getLiteralEnvInstanceAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:3350:3: ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) )
            // InternalSEW.g:3351:4: ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) )
            {
            // InternalSEW.g:3351:4: ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) )
            // InternalSEW.g:3352:5: (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' )
            {
            // InternalSEW.g:3352:5: (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==66) ) {
                alt67=1;
            }
            else if ( (LA67_0==67) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalSEW.g:3353:6: lv_symbol_1_1= '$env'
                    {
                    lv_symbol_1_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_symbol_1_1, grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralEnvInstanceRule());
                      						}
                      						setWithLastConsumed(current, "symbol", lv_symbol_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3364:6: lv_symbol_1_2= 'env'
                    {
                    lv_symbol_1_2=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_symbol_1_2, grammarAccess.getLiteralEnvInstanceAccess().getSymbolEnvKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralEnvInstanceRule());
                      						}
                      						setWithLastConsumed(current, "symbol", lv_symbol_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralEnvInstance"


    // $ANTLR start "entryRuleEBoolean"
    // InternalSEW.g:3381:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalSEW.g:3381:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalSEW.g:3382:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBooleanRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBoolean.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalSEW.g:3388:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSEW.g:3394:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalSEW.g:3395:2: (kw= 'true' | kw= 'false' )
            {
            // InternalSEW.g:3395:2: (kw= 'true' | kw= 'false' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==68) ) {
                alt68=1;
            }
            else if ( (LA68_0==69) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalSEW.g:3396:3: kw= 'true'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3402:3: kw= 'false'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEChar"
    // InternalSEW.g:3411:1: entryRuleEChar returns [String current=null] : iv_ruleEChar= ruleEChar EOF ;
    public final String entryRuleEChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEChar = null;


        try {
            // InternalSEW.g:3411:45: (iv_ruleEChar= ruleEChar EOF )
            // InternalSEW.g:3412:2: iv_ruleEChar= ruleEChar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getECharRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEChar=ruleEChar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEChar.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEChar"


    // $ANTLR start "ruleEChar"
    // InternalSEW.g:3418:1: ruleEChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CHARACTER_0= RULE_CHARACTER ;
    public final AntlrDatatypeRuleToken ruleEChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHARACTER_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3424:2: (this_CHARACTER_0= RULE_CHARACTER )
            // InternalSEW.g:3425:2: this_CHARACTER_0= RULE_CHARACTER
            {
            this_CHARACTER_0=(Token)match(input,RULE_CHARACTER,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_CHARACTER_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_CHARACTER_0, grammarAccess.getECharAccess().getCHARACTERTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEChar"


    // $ANTLR start "entryRuleELong"
    // InternalSEW.g:3435:1: entryRuleELong returns [String current=null] : iv_ruleELong= ruleELong EOF ;
    public final String entryRuleELong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleELong = null;


        try {
            // InternalSEW.g:3435:45: (iv_ruleELong= ruleELong EOF )
            // InternalSEW.g:3436:2: iv_ruleELong= ruleELong EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getELongRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleELong=ruleELong();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleELong.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleELong"


    // $ANTLR start "ruleELong"
    // InternalSEW.g:3442:1: ruleELong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleELong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalSEW.g:3448:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalSEW.g:3449:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalSEW.g:3449:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalSEW.g:3450:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalSEW.g:3450:3: (kw= '-' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==52) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalSEW.g:3451:4: kw= '-'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getELongAccess().getHyphenMinusKeyword_0());
                      			
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_1, grammarAccess.getELongAccess().getINTTerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleELong"


    // $ANTLR start "entryRuleEDouble"
    // InternalSEW.g:3468:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalSEW.g:3468:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalSEW.g:3469:2: iv_ruleEDouble= ruleEDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEDoubleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEDouble.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalSEW.g:3475:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalSEW.g:3481:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ) )
            // InternalSEW.g:3482:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT )
            {
            // InternalSEW.g:3482:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT )
            // InternalSEW.g:3483:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT
            {
            // InternalSEW.g:3483:3: (kw= '-' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==52) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalSEW.g:3484:4: kw= '-'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:3490:3: (this_INT_1= RULE_INT )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_INT) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalSEW.g:3491:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,26,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
              		
            }
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_3);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEBigDecimal"
    // InternalSEW.g:3515:1: entryRuleEBigDecimal returns [String current=null] : iv_ruleEBigDecimal= ruleEBigDecimal EOF ;
    public final String entryRuleEBigDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBigDecimal = null;


        try {
            // InternalSEW.g:3515:51: (iv_ruleEBigDecimal= ruleEBigDecimal EOF )
            // InternalSEW.g:3516:2: iv_ruleEBigDecimal= ruleEBigDecimal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBigDecimalRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEBigDecimal=ruleEBigDecimal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBigDecimal.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEBigDecimal"


    // $ANTLR start "ruleEBigDecimal"
    // InternalSEW.g:3522:1: ruleEBigDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEBigDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSEW.g:3528:2: ( ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT ) )
            // InternalSEW.g:3529:2: ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT )
            {
            // InternalSEW.g:3529:2: ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT )
            // InternalSEW.g:3530:3: (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT
            {
            // InternalSEW.g:3530:3: (this_INT_0= RULE_INT )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_INT) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalSEW.g:3531:4: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_0, grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_0());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,26,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getEBigDecimalAccess().getFullStopKeyword_1());
              		
            }
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_2, grammarAccess.getEBigDecimalAccess().getINTTerminalRuleCall_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEBigDecimal"


    // $ANTLR start "entryRuleEString"
    // InternalSEW.g:3555:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSEW.g:3555:47: (iv_ruleEString= ruleEString EOF )
            // InternalSEW.g:3556:2: iv_ruleEString= ruleEString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalSEW.g:3562:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3568:2: (this_STRING_0= RULE_STRING )
            // InternalSEW.g:3569:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleDeprecatedReservedWord"
    // InternalSEW.g:3579:1: entryRuleDeprecatedReservedWord returns [String current=null] : iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF ;
    public final String entryRuleDeprecatedReservedWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeprecatedReservedWord = null;


        try {
            // InternalSEW.g:3579:62: (iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF )
            // InternalSEW.g:3580:2: iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedReservedWordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedReservedWord=ruleDeprecatedReservedWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedReservedWord.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedReservedWord"


    // $ANTLR start "ruleDeprecatedReservedWord"
    // InternalSEW.g:3586:1: ruleDeprecatedReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' ) ;
    public final AntlrDatatypeRuleToken ruleDeprecatedReservedWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSEW.g:3592:2: ( (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' ) )
            // InternalSEW.g:3593:2: (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' )
            {
            // InternalSEW.g:3593:2: (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' )
            int alt73=6;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt73=1;
                }
                break;
            case 71:
                {
                alt73=2;
                }
                break;
            case 72:
                {
                alt73=3;
                }
                break;
            case 73:
                {
                alt73=4;
                }
                break;
            case 74:
                {
                alt73=5;
                }
                break;
            case 75:
                {
                alt73=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalSEW.g:3594:3: kw= 'form'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getFormKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3600:3: kw= 'endform'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndformKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:3606:3: kw= 'prototype'
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getPrototypeKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSEW.g:3612:3: kw= 'endprototype'
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndprototypeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSEW.g:3618:3: kw= 'section'
                    {
                    kw=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getSectionKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSEW.g:3624:3: kw= 'endsection'
                    {
                    kw=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndsectionKeyword_5());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedReservedWord"


    // $ANTLR start "entryRuleDeprecatedObject"
    // InternalSEW.g:3633:1: entryRuleDeprecatedObject returns [EObject current=null] : iv_ruleDeprecatedObject= ruleDeprecatedObject EOF ;
    public final EObject entryRuleDeprecatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedObject = null;


        try {
            // InternalSEW.g:3633:57: (iv_ruleDeprecatedObject= ruleDeprecatedObject EOF )
            // InternalSEW.g:3634:2: iv_ruleDeprecatedObject= ruleDeprecatedObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedObject=ruleDeprecatedObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedObject"


    // $ANTLR start "ruleDeprecatedObject"
    // InternalSEW.g:3640:1: ruleDeprecatedObject returns [EObject current=null] : ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) ) ;
    public final EObject ruleDeprecatedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_3_0 = null;

        AntlrDatatypeRuleToken lv_type_6_0 = null;

        EObject lv_element_8_0 = null;

        AntlrDatatypeRuleToken lv_name_12_0 = null;

        AntlrDatatypeRuleToken lv_description_13_0 = null;

        AntlrDatatypeRuleToken lv_type_16_0 = null;

        EObject lv_element_18_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:3646:2: ( ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) ) )
            // InternalSEW.g:3647:2: ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) )
            {
            // InternalSEW.g:3647:2: ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==70) ) {
                alt80=1;
            }
            else if ( (LA80_0==72) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalSEW.g:3648:3: ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' )
                    {
                    // InternalSEW.g:3648:3: ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' )
                    // InternalSEW.g:3649:4: () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform'
                    {
                    // InternalSEW.g:3649:4: ()
                    // InternalSEW.g:3650:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDeprecatedObjectAccess().getWObjectAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,70,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeprecatedObjectAccess().getFormKeyword_0_1());
                      			
                    }
                    // InternalSEW.g:3663:4: ( (lv_name_2_0= ruleUFI ) )
                    // InternalSEW.g:3664:5: (lv_name_2_0= ruleUFI )
                    {
                    // InternalSEW.g:3664:5: (lv_name_2_0= ruleUFI )
                    // InternalSEW.g:3665:6: lv_name_2_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_47);
                    lv_name_2_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:3682:4: ( (lv_description_3_0= ruleEString ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==RULE_STRING) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalSEW.g:3683:5: (lv_description_3_0= ruleEString )
                            {
                            // InternalSEW.g:3683:5: (lv_description_3_0= ruleEString )
                            // InternalSEW.g:3684:6: lv_description_3_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_0_3_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_48);
                            lv_description_3_0=ruleEString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                              						}
                              						set(
                              							current,
                              							"description",
                              							lv_description_3_0,
                              							"org.eclipse.efm.sew.xtext.SEW.EString");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,76,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_0_4());
                      			
                    }
                    // InternalSEW.g:3705:4: (otherlv_5= '&' )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==57) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalSEW.g:3706:5: otherlv_5= '&'
                            {
                            otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:3711:4: ( (lv_type_6_0= ruleUFI ) )
                    // InternalSEW.g:3712:5: (lv_type_6_0= ruleUFI )
                    {
                    // InternalSEW.g:3712:5: (lv_type_6_0= ruleUFI )
                    // InternalSEW.g:3713:6: lv_type_6_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_0_6_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_type_6_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_6_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,77,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_0_7());
                      			
                    }
                    // InternalSEW.g:3734:4: ( (lv_element_8_0= ruleDeprecatedProperty ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==71) ) {
                            int LA76_1 = input.LA(2);

                            if ( (LA76_1==RULE_STRING||LA76_1==29||(LA76_1>=31 && LA76_1<=32)) ) {
                                alt76=1;
                            }


                        }
                        else if ( (LA76_0==RULE_XIDENDIFIER||LA76_0==RULE_AT_IDENTIFIER||LA76_0==14||LA76_0==21||LA76_0==70||(LA76_0>=72 && LA76_0<=75)) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalSEW.g:3735:5: (lv_element_8_0= ruleDeprecatedProperty )
                    	    {
                    	    // InternalSEW.g:3735:5: (lv_element_8_0= ruleDeprecatedProperty )
                    	    // InternalSEW.g:3736:6: lv_element_8_0= ruleDeprecatedProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_0_8_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_51);
                    	    lv_element_8_0=ruleDeprecatedProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"element",
                    	      							lv_element_8_0,
                    	      							"org.eclipse.efm.sew.xtext.SEW.DeprecatedProperty");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getDeprecatedObjectAccess().getEndformKeyword_0_9());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:3759:3: ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' )
                    {
                    // InternalSEW.g:3759:3: ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' )
                    // InternalSEW.g:3760:4: () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype'
                    {
                    // InternalSEW.g:3760:4: ()
                    // InternalSEW.g:3761:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDeprecatedObjectAccess().getWObjectAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,72,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getDeprecatedObjectAccess().getPrototypeKeyword_1_1());
                      			
                    }
                    // InternalSEW.g:3774:4: ( (lv_name_12_0= ruleUFI ) )
                    // InternalSEW.g:3775:5: (lv_name_12_0= ruleUFI )
                    {
                    // InternalSEW.g:3775:5: (lv_name_12_0= ruleUFI )
                    // InternalSEW.g:3776:6: lv_name_12_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getNameUFIParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_47);
                    lv_name_12_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_12_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:3793:4: ( (lv_description_13_0= ruleEString ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_STRING) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalSEW.g:3794:5: (lv_description_13_0= ruleEString )
                            {
                            // InternalSEW.g:3794:5: (lv_description_13_0= ruleEString )
                            // InternalSEW.g:3795:6: lv_description_13_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getDescriptionEStringParserRuleCall_1_3_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_48);
                            lv_description_13_0=ruleEString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                              						}
                              						set(
                              							current,
                              							"description",
                              							lv_description_13_0,
                              							"org.eclipse.efm.sew.xtext.SEW.EString");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,76,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_1_4());
                      			
                    }
                    // InternalSEW.g:3816:4: (otherlv_15= '&' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==57) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalSEW.g:3817:5: otherlv_15= '&'
                            {
                            otherlv_15=(Token)match(input,57,FollowSets000.FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_15, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:3822:4: ( (lv_type_16_0= ruleUFI ) )
                    // InternalSEW.g:3823:5: (lv_type_16_0= ruleUFI )
                    {
                    // InternalSEW.g:3823:5: (lv_type_16_0= ruleUFI )
                    // InternalSEW.g:3824:6: lv_type_16_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getTypeUFIParserRuleCall_1_6_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_type_16_0=ruleUFI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_16_0,
                      							"org.eclipse.efm.sew.xtext.SEW.UFI");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_17=(Token)match(input,77,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_1_7());
                      			
                    }
                    // InternalSEW.g:3845:4: ( (lv_element_18_0= ruleDeprecatedProperty ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==73) ) {
                            int LA79_1 = input.LA(2);

                            if ( (LA79_1==RULE_STRING||LA79_1==29||(LA79_1>=31 && LA79_1<=32)) ) {
                                alt79=1;
                            }


                        }
                        else if ( (LA79_0==RULE_XIDENDIFIER||LA79_0==RULE_AT_IDENTIFIER||LA79_0==14||LA79_0==21||(LA79_0>=70 && LA79_0<=72)||(LA79_0>=74 && LA79_0<=75)) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalSEW.g:3846:5: (lv_element_18_0= ruleDeprecatedProperty )
                    	    {
                    	    // InternalSEW.g:3846:5: (lv_element_18_0= ruleDeprecatedProperty )
                    	    // InternalSEW.g:3847:6: lv_element_18_0= ruleDeprecatedProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDeprecatedObjectAccess().getElementDeprecatedPropertyParserRuleCall_1_8_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_51);
                    	    lv_element_18_0=ruleDeprecatedProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getDeprecatedObjectRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"element",
                    	      							lv_element_18_0,
                    	      							"org.eclipse.efm.sew.xtext.SEW.DeprecatedProperty");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getDeprecatedObjectAccess().getEndprototypeKeyword_1_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedObject"


    // $ANTLR start "entryRuleDeprecatedProperty"
    // InternalSEW.g:3873:1: entryRuleDeprecatedProperty returns [EObject current=null] : iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF ;
    public final EObject entryRuleDeprecatedProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedProperty = null;


        try {
            // InternalSEW.g:3873:59: (iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF )
            // InternalSEW.g:3874:2: iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedPropertyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedProperty=ruleDeprecatedProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedProperty"


    // $ANTLR start "ruleDeprecatedProperty"
    // InternalSEW.g:3880:1: ruleDeprecatedProperty returns [EObject current=null] : (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute ) ;
    public final EObject ruleDeprecatedProperty() throws RecognitionException {
        EObject current = null;

        EObject this_DeprecatedSection_0 = null;

        EObject this_DeprecatedAttribute_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:3886:2: ( (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute ) )
            // InternalSEW.g:3887:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )
            {
            // InternalSEW.g:3887:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalSEW.g:3888:3: this_DeprecatedSection_0= ruleDeprecatedSection
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedSectionParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DeprecatedSection_0=ruleDeprecatedSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeprecatedSection_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3900:3: this_DeprecatedAttribute_1= ruleDeprecatedAttribute
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeprecatedPropertyAccess().getDeprecatedAttributeParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DeprecatedAttribute_1=ruleDeprecatedAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeprecatedAttribute_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedProperty"


    // $ANTLR start "entryRuleDeprecatedSection"
    // InternalSEW.g:3915:1: entryRuleDeprecatedSection returns [EObject current=null] : iv_ruleDeprecatedSection= ruleDeprecatedSection EOF ;
    public final EObject entryRuleDeprecatedSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedSection = null;


        try {
            // InternalSEW.g:3915:58: (iv_ruleDeprecatedSection= ruleDeprecatedSection EOF )
            // InternalSEW.g:3916:2: iv_ruleDeprecatedSection= ruleDeprecatedSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedSectionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedSection=ruleDeprecatedSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedSection; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedSection"


    // $ANTLR start "ruleDeprecatedSection"
    // InternalSEW.g:3922:1: ruleDeprecatedSection returns [EObject current=null] : ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) ) ;
    public final EObject ruleDeprecatedSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_element_3_1 = null;

        EObject lv_element_3_2 = null;

        EObject lv_element_3_3 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        AntlrDatatypeRuleToken lv_description_7_0 = null;

        EObject lv_element_9_1 = null;

        EObject lv_element_9_2 = null;

        EObject lv_element_9_3 = null;

        EObject lv_element_12_1 = null;

        EObject lv_element_12_2 = null;

        EObject lv_element_12_3 = null;



        	enterRule();

        try {
            // InternalSEW.g:3928:2: ( ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) ) )
            // InternalSEW.g:3929:2: ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) )
            {
            // InternalSEW.g:3929:2: ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==74) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==RULE_XIDENDIFIER||LA91_1==14||LA91_1==21||(LA91_1>=70 && LA91_1<=75)) ) {
                    alt91=1;
                }
                else if ( (LA91_1==RULE_STRING||LA91_1==29||LA91_1==31) ) {
                    alt91=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA91_0==RULE_XIDENDIFIER||LA91_0==14||LA91_0==21||(LA91_0>=70 && LA91_0<=73)||LA91_0==75) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalSEW.g:3930:3: ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? )
                    {
                    // InternalSEW.g:3930:3: ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? )
                    // InternalSEW.g:3931:4: () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )?
                    {
                    // InternalSEW.g:3931:4: ()
                    // InternalSEW.g:3932:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDeprecatedSectionAccess().getWSectionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeprecatedSectionAccess().getSectionKeyword_0_1());
                      			
                    }
                    // InternalSEW.g:3945:4: ( (lv_name_2_0= ruleXID ) )
                    // InternalSEW.g:3946:5: (lv_name_2_0= ruleXID )
                    {
                    // InternalSEW.g:3946:5: (lv_name_2_0= ruleXID )
                    // InternalSEW.g:3947:6: lv_name_2_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_52);
                    lv_name_2_0=ruleXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.eclipse.efm.sew.xtext.SEW.XID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:3964:4: ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        alt83 = dfa83.predict(input);
                        switch (alt83) {
                    	case 1 :
                    	    // InternalSEW.g:3965:5: ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) )
                    	    {
                    	    // InternalSEW.g:3965:5: ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) )
                    	    // InternalSEW.g:3966:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )
                    	    {
                    	    // InternalSEW.g:3966:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )
                    	    int alt82=3;
                    	    alt82 = dfa82.predict(input);
                    	    switch (alt82) {
                    	        case 1 :
                    	            // InternalSEW.g:3967:7: lv_element_3_1= ruleDeprecatedAttribute
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_0_3_0_0());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_52);
                    	            lv_element_3_1=ruleDeprecatedAttribute();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_3_1,
                    	              								"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:3983:7: lv_element_3_2= ruleDeprecatedObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_0_3_0_1());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_52);
                    	            lv_element_3_2=ruleDeprecatedObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_3_2,
                    	              								"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalSEW.g:3999:7: lv_element_3_3= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_0_3_0_2());
                    	              						
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_52);
                    	            lv_element_3_3=ruleObject();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							if (current==null) {
                    	              								current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                    	              							}
                    	              							add(
                    	              								current,
                    	              								"element",
                    	              								lv_element_3_3,
                    	              								"org.eclipse.efm.sew.xtext.SEW.Object");
                    	              							afterParserOrEnumRuleCall();
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,75,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeprecatedSectionAccess().getEndsectionKeyword_0_4());
                      			
                    }
                    // InternalSEW.g:4021:4: ( ruleXID )?
                    int alt84=2;
                    alt84 = dfa84.predict(input);
                    switch (alt84) {
                        case 1 :
                            // InternalSEW.g:4022:5: ruleXID
                            {
                            if ( state.backtracking==0 ) {

                              					/* */
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getXIDParserRuleCall_0_5());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleXID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:4035:3: ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) )
                    {
                    // InternalSEW.g:4035:3: ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) )
                    // InternalSEW.g:4036:4: ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) )
                    {
                    // InternalSEW.g:4036:4: ( (lv_name_6_0= ruleXID ) )
                    // InternalSEW.g:4037:5: (lv_name_6_0= ruleXID )
                    {
                    // InternalSEW.g:4037:5: (lv_name_6_0= ruleXID )
                    // InternalSEW.g:4038:6: lv_name_6_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_name_6_0=ruleXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_6_0,
                      							"org.eclipse.efm.sew.xtext.SEW.XID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSEW.g:4055:4: ( (lv_description_7_0= ruleEString ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==RULE_STRING) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalSEW.g:4056:5: (lv_description_7_0= ruleEString )
                            {
                            // InternalSEW.g:4056:5: (lv_description_7_0= ruleEString )
                            // InternalSEW.g:4057:6: lv_description_7_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getDescriptionEStringParserRuleCall_1_1_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_19);
                            lv_description_7_0=ruleEString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                              						}
                              						set(
                              							current,
                              							"description",
                              							lv_description_7_0,
                              							"org.eclipse.efm.sew.xtext.SEW.EString");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalSEW.g:4074:4: ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) )
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==29) ) {
                        alt90=1;
                    }
                    else if ( (LA90_0==31) ) {
                        alt90=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalSEW.g:4075:5: (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' )
                            {
                            // InternalSEW.g:4075:5: (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' )
                            // InternalSEW.g:4076:6: otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']'
                            {
                            otherlv_8=(Token)match(input,29,FollowSets000.FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_8, grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0());
                              					
                            }
                            // InternalSEW.g:4080:6: ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==RULE_XIDENDIFIER||LA87_0==RULE_AT_IDENTIFIER||LA87_0==14||LA87_0==21||(LA87_0>=70 && LA87_0<=75)) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // InternalSEW.g:4081:7: ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) )
                            	    {
                            	    // InternalSEW.g:4081:7: ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) )
                            	    // InternalSEW.g:4082:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )
                            	    {
                            	    // InternalSEW.g:4082:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )
                            	    int alt86=3;
                            	    alt86 = dfa86.predict(input);
                            	    switch (alt86) {
                            	        case 1 :
                            	            // InternalSEW.g:4083:9: lv_element_9_1= ruleDeprecatedAttribute
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_0_1_0_0());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_53);
                            	            lv_element_9_1=ruleDeprecatedAttribute();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_9_1,
                            	              										"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;
                            	        case 2 :
                            	            // InternalSEW.g:4099:9: lv_element_9_2= ruleDeprecatedObject
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_0_1_0_1());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_53);
                            	            lv_element_9_2=ruleDeprecatedObject();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_9_2,
                            	              										"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;
                            	        case 3 :
                            	            // InternalSEW.g:4115:9: lv_element_9_3= ruleObject
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_0_1_0_2());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_53);
                            	            lv_element_9_3=ruleObject();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_9_3,
                            	              										"org.eclipse.efm.sew.xtext.SEW.Object");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop87;
                                }
                            } while (true);

                            otherlv_10=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2());
                              					
                            }

                            }


                            }
                            break;
                        case 2 :
                            // InternalSEW.g:4139:5: (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* )
                            {
                            // InternalSEW.g:4139:5: (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* )
                            // InternalSEW.g:4140:6: otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*
                            {
                            otherlv_11=(Token)match(input,31,FollowSets000.FOLLOW_52); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_11, grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0());
                              					
                            }
                            // InternalSEW.g:4144:6: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*
                            loop89:
                            do {
                                int alt89=2;
                                alt89 = dfa89.predict(input);
                                switch (alt89) {
                            	case 1 :
                            	    // InternalSEW.g:4145:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
                            	    {
                            	    // InternalSEW.g:4145:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
                            	    // InternalSEW.g:4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
                            	    {
                            	    // InternalSEW.g:4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
                            	    int alt88=3;
                            	    alt88 = dfa88.predict(input);
                            	    switch (alt88) {
                            	        case 1 :
                            	            // InternalSEW.g:4147:9: lv_element_12_1= ruleDeprecatedAttribute
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedAttributeParserRuleCall_1_2_1_1_0_0());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_54);
                            	            lv_element_12_1=ruleDeprecatedAttribute();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_12_1,
                            	              										"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttribute");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;
                            	        case 2 :
                            	            // InternalSEW.g:4163:9: lv_element_12_2= ruleDeprecatedObject
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementDeprecatedObjectParserRuleCall_1_2_1_1_0_1());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_54);
                            	            lv_element_12_2=ruleDeprecatedObject();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_12_2,
                            	              										"org.eclipse.efm.sew.xtext.SEW.DeprecatedObject");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;
                            	        case 3 :
                            	            // InternalSEW.g:4179:9: lv_element_12_3= ruleObject
                            	            {
                            	            if ( state.backtracking==0 ) {

                            	              									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_1_1_0_2());
                            	              								
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_54);
                            	            lv_element_12_3=ruleObject();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              									if (current==null) {
                            	              										current = createModelElementForParent(grammarAccess.getDeprecatedSectionRule());
                            	              									}
                            	              									add(
                            	              										current,
                            	              										"element",
                            	              										lv_element_12_3,
                            	              										"org.eclipse.efm.sew.xtext.SEW.Object");
                            	              									afterParserOrEnumRuleCall();
                            	              								
                            	            }

                            	            }
                            	            break;

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop89;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedSection"


    // $ANTLR start "entryRuleDeprecatedAttribute"
    // InternalSEW.g:4204:1: entryRuleDeprecatedAttribute returns [EObject current=null] : iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF ;
    public final EObject entryRuleDeprecatedAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedAttribute = null;


        try {
            // InternalSEW.g:4204:60: (iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF )
            // InternalSEW.g:4205:2: iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedAttribute=ruleDeprecatedAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedAttribute"


    // $ANTLR start "ruleDeprecatedAttribute"
    // InternalSEW.g:4211:1: ruleDeprecatedAttribute returns [EObject current=null] : ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleDeprecatedAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4217:2: ( ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) )
            // InternalSEW.g:4218:2: ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            {
            // InternalSEW.g:4218:2: ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            // InternalSEW.g:4219:3: () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )?
            {
            // InternalSEW.g:4219:3: ()
            // InternalSEW.g:4220:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeprecatedAttributeAccess().getWAttributeAction_0(),
              					current);
              			
            }

            }

            // InternalSEW.g:4229:3: ( (lv_name_1_0= ruleDeprecatedAttributeID ) )
            // InternalSEW.g:4230:4: (lv_name_1_0= ruleDeprecatedAttributeID )
            {
            // InternalSEW.g:4230:4: (lv_name_1_0= ruleDeprecatedAttributeID )
            // InternalSEW.g:4231:5: lv_name_1_0= ruleDeprecatedAttributeID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeprecatedAttributeAccess().getNameDeprecatedAttributeIDParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_21);
            lv_name_1_0=ruleDeprecatedAttributeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeprecatedAttributeRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.efm.sew.xtext.SEW.DeprecatedAttributeID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeprecatedAttributeAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalSEW.g:4252:3: ( (lv_value_3_0= ruleValueSpecification ) )
            // InternalSEW.g:4253:4: (lv_value_3_0= ruleValueSpecification )
            {
            // InternalSEW.g:4253:4: (lv_value_3_0= ruleValueSpecification )
            // InternalSEW.g:4254:5: lv_value_3_0= ruleValueSpecification
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeprecatedAttributeAccess().getValueValueSpecificationParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_value_3_0=ruleValueSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeprecatedAttributeRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
              						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSEW.g:4271:3: (otherlv_4= ';' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==33) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalSEW.g:4272:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeprecatedAttributeAccess().getSemicolonKeyword_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedAttribute"


    // $ANTLR start "entryRuleDeprecatedAttributeID"
    // InternalSEW.g:4281:1: entryRuleDeprecatedAttributeID returns [String current=null] : iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF ;
    public final String entryRuleDeprecatedAttributeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeprecatedAttributeID = null;


        try {
            // InternalSEW.g:4281:61: (iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF )
            // InternalSEW.g:4282:2: iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedAttributeIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedAttributeID=ruleDeprecatedAttributeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedAttributeID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedAttributeID"


    // $ANTLR start "ruleDeprecatedAttributeID"
    // InternalSEW.g:4288:1: ruleDeprecatedAttributeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER ) ;
    public final AntlrDatatypeRuleToken ruleDeprecatedAttributeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_AT_IDENTIFIER_1=null;
        AntlrDatatypeRuleToken this_XID_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4294:2: ( (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER ) )
            // InternalSEW.g:4295:2: (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER )
            {
            // InternalSEW.g:4295:2: (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_XIDENDIFIER||LA93_0==14||LA93_0==21||(LA93_0>=70 && LA93_0<=75)) ) {
                alt93=1;
            }
            else if ( (LA93_0==RULE_AT_IDENTIFIER) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalSEW.g:4296:3: this_XID_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeprecatedAttributeIDAccess().getXIDParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_XID_0=ruleXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_XID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:4307:3: this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER
                    {
                    this_AT_IDENTIFIER_1=(Token)match(input,RULE_AT_IDENTIFIER,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_AT_IDENTIFIER_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_AT_IDENTIFIER_1, grammarAccess.getDeprecatedAttributeIDAccess().getAT_IDENTIFIERTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedAttributeID"


    // $ANTLR start "entryRuleDeprecatedExpression"
    // InternalSEW.g:4318:1: entryRuleDeprecatedExpression returns [EObject current=null] : iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF ;
    public final EObject entryRuleDeprecatedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedExpression = null;


        try {
            // InternalSEW.g:4318:61: (iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF )
            // InternalSEW.g:4319:2: iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeprecatedExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDeprecatedExpression=ruleDeprecatedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeprecatedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeprecatedExpression"


    // $ANTLR start "ruleDeprecatedExpression"
    // InternalSEW.g:4325:1: ruleDeprecatedExpression returns [EObject current=null] : ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' ) ;
    public final EObject ruleDeprecatedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token otherlv_4=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4331:2: ( ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' ) )
            // InternalSEW.g:4332:2: ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' )
            {
            // InternalSEW.g:4332:2: ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' )
            // InternalSEW.g:4333:3: () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}'
            {
            // InternalSEW.g:4333:3: ()
            // InternalSEW.g:4334:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeprecatedExpressionAccess().getExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDeprecatedExpressionAccess().getDollarSignLeftCurlyBracketKeyword_1());
              		
            }
            // InternalSEW.g:4347:3: ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) )
            // InternalSEW.g:4348:4: ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) )
            {
            // InternalSEW.g:4348:4: ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) )
            // InternalSEW.g:4349:5: (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' )
            {
            // InternalSEW.g:4349:5: (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==79) ) {
                alt94=1;
            }
            else if ( (LA94_0==80) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalSEW.g:4350:6: lv_operator_2_1= '|;|'
                    {
                    lv_operator_2_1=(Token)match(input,79,FollowSets000.FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_1, grammarAccess.getDeprecatedExpressionAccess().getOperatorVerticalLineSemicolonVerticalLineKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDeprecatedExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:4361:6: lv_operator_2_2= '|i|'
                    {
                    lv_operator_2_2=(Token)match(input,80,FollowSets000.FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_2, grammarAccess.getDeprecatedExpressionAccess().getOperatorIKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDeprecatedExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalSEW.g:4374:3: ( (lv_operand_3_0= ruleValueSpecification ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( ((LA95_0>=RULE_XIDENDIFIER && LA95_0<=RULE_STRING)||LA95_0==14||LA95_0==21||LA95_0==26||LA95_0==29||LA95_0==47||(LA95_0>=52 && LA95_0<=55)||(LA95_0>=57 && LA95_0<=75)||LA95_0==78) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalSEW.g:4375:4: (lv_operand_3_0= ruleValueSpecification )
            	    {
            	    // InternalSEW.g:4375:4: (lv_operand_3_0= ruleValueSpecification )
            	    // InternalSEW.g:4376:5: lv_operand_3_0= ruleValueSpecification
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDeprecatedExpressionAccess().getOperandValueSpecificationParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_56);
            	    lv_operand_3_0=ruleValueSpecification();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDeprecatedExpressionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operand",
            	      						lv_operand_3_0,
            	      						"org.eclipse.efm.sew.xtext.SEW.ValueSpecification");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDeprecatedExpressionAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeprecatedExpression"

    // $ANTLR start synpred7_InternalSEW
    public final void synpred7_InternalSEW_fragment() throws RecognitionException {   
        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_element_6_1 = null;

        EObject lv_element_6_2 = null;


        // InternalSEW.g:117:4: ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) )
        // InternalSEW.g:117:4: ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' )
        {
        // InternalSEW.g:117:4: ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' )
        // InternalSEW.g:118:5: ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}'
        {
        // InternalSEW.g:118:5: ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) )
        // InternalSEW.g:119:6: ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) )
        {
        // InternalSEW.g:119:6: ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) )
        // InternalSEW.g:120:7: (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' )
        {
        // InternalSEW.g:120:7: (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' )
        int alt97=2;
        int LA97_0 = input.LA(1);

        if ( (LA97_0==14) ) {
            alt97=1;
        }
        else if ( (LA97_0==15) ) {
            alt97=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 97, 0, input);

            throw nvae;
        }
        switch (alt97) {
            case 1 :
                // InternalSEW.g:121:8: lv_type_2_1= 'workflow'
                {
                lv_type_2_1=(Token)match(input,14,FollowSets000.FOLLOW_4); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSEW.g:132:8: lv_type_2_2= 'symbex-workflow'
                {
                lv_type_2_2=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalSEW.g:145:5: ( (lv_name_3_0= ruleUFI ) )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==RULE_XIDENDIFIER||LA98_0==14||LA98_0==21||(LA98_0>=70 && LA98_0<=75)) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // InternalSEW.g:146:6: (lv_name_3_0= ruleUFI )
                {
                // InternalSEW.g:146:6: (lv_name_3_0= ruleUFI )
                // InternalSEW.g:147:7: lv_name_3_0= ruleUFI
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getWorkflowAccess().getNameUFIParserRuleCall_2_0_1_0());
                  						
                }
                pushFollow(FollowSets000.FOLLOW_5);
                lv_name_3_0=ruleUFI();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalSEW.g:164:5: ( (lv_description_4_0= ruleEString ) )?
        int alt99=2;
        int LA99_0 = input.LA(1);

        if ( (LA99_0==RULE_STRING) ) {
            alt99=1;
        }
        switch (alt99) {
            case 1 :
                // InternalSEW.g:165:6: (lv_description_4_0= ruleEString )
                {
                // InternalSEW.g:165:6: (lv_description_4_0= ruleEString )
                // InternalSEW.g:166:7: lv_description_4_0= ruleEString
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getWorkflowAccess().getDescriptionEStringParserRuleCall_2_0_2_0());
                  						
                }
                pushFollow(FollowSets000.FOLLOW_6);
                lv_description_4_0=ruleEString();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_7); if (state.failed) return ;
        // InternalSEW.g:187:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )*
        loop101:
        do {
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_XIDENDIFIER||LA101_0==14||LA101_0==21||(LA101_0>=70 && LA101_0<=75)) ) {
                alt101=1;
            }


            switch (alt101) {
        	case 1 :
        	    // InternalSEW.g:188:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) )
        	    {
        	    // InternalSEW.g:188:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) )
        	    // InternalSEW.g:189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )
        	    {
        	    // InternalSEW.g:189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )
        	    int alt100=2;
        	    alt100 = dfa100.predict(input);
        	    switch (alt100) {
        	        case 1 :
        	            // InternalSEW.g:190:8: lv_element_6_1= ruleObject
        	            {
        	            pushFollow(FollowSets000.FOLLOW_7);
        	            lv_element_6_1=ruleObject();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;
        	        case 2 :
        	            // InternalSEW.g:206:8: lv_element_6_2= ruleProperty
        	            {
        	            if ( state.backtracking==0 ) {

        	              								newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_0_4_0_1());
        	              							
        	            }
        	            pushFollow(FollowSets000.FOLLOW_7);
        	            lv_element_6_2=ruleProperty();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop101;
            }
        } while (true);

        otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalSEW

    // $ANTLR start synpred10_InternalSEW
    public final void synpred10_InternalSEW_fragment() throws RecognitionException {   
        EObject lv_element_8_1 = null;

        EObject lv_element_8_2 = null;


        // InternalSEW.g:230:4: ( ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* )
        // InternalSEW.g:230:4: ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )*
        {
        // InternalSEW.g:230:4: ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )*
        loop104:
        do {
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_XIDENDIFIER||LA104_0==14||LA104_0==21||(LA104_0>=70 && LA104_0<=75)) ) {
                alt104=1;
            }


            switch (alt104) {
        	case 1 :
        	    // InternalSEW.g:231:5: ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) )
        	    {
        	    // InternalSEW.g:231:5: ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) )
        	    // InternalSEW.g:232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )
        	    {
        	    // InternalSEW.g:232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )
        	    int alt103=2;
        	    alt103 = dfa103.predict(input);
        	    switch (alt103) {
        	        case 1 :
        	            // InternalSEW.g:233:7: lv_element_8_1= ruleObject
        	            {
        	            pushFollow(FollowSets000.FOLLOW_8);
        	            lv_element_8_1=ruleObject();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;
        	        case 2 :
        	            // InternalSEW.g:249:7: lv_element_8_2= ruleProperty
        	            {
        	            if ( state.backtracking==0 ) {

        	              							newCompositeNode(grammarAccess.getWorkflowAccess().getElementPropertyParserRuleCall_2_1_0_1());
        	              						
        	            }
        	            pushFollow(FollowSets000.FOLLOW_8);
        	            lv_element_8_2=ruleProperty();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop104;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred10_InternalSEW

    // $ANTLR start synpred38_InternalSEW
    public final void synpred38_InternalSEW_fragment() throws RecognitionException {   
        EObject lv_element_6_1 = null;

        EObject lv_element_6_2 = null;


        // InternalSEW.g:938:6: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )
        // InternalSEW.g:938:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
        {
        // InternalSEW.g:938:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
        // InternalSEW.g:939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
        {
        // InternalSEW.g:939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
        int alt117=2;
        alt117 = dfa117.predict(input);
        switch (alt117) {
            case 1 :
                // InternalSEW.g:940:8: lv_element_6_1= ruleObject
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_6_1=ruleObject();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSEW.g:956:8: lv_element_6_2= ruleAttribute
                {
                if ( state.backtracking==0 ) {

                  								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1());
                  							
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_6_2=ruleAttribute();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred38_InternalSEW

    // $ANTLR start synpred59_InternalSEW
    public final void synpred59_InternalSEW_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_operand_5_0 = null;


        // InternalSEW.g:1767:5: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )
        // InternalSEW.g:1767:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        {
        otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return ;
        // InternalSEW.g:1771:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
        {
        // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
        // InternalSEW.g:1773:7: lv_operand_5_0= rulemultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0());
          						
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_operand_5_0=rulemultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred59_InternalSEW

    // $ANTLR start synpred60_InternalSEW
    public final void synpred60_InternalSEW_fragment() throws RecognitionException {   
        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;


        // InternalSEW.g:1723:4: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )
        // InternalSEW.g:1723:4: () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
        {
        // InternalSEW.g:1723:4: ()
        // InternalSEW.g:1724:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSEW.g:1733:4: ( (lv_operator_2_0= '+' ) )
        // InternalSEW.g:1734:5: (lv_operator_2_0= '+' )
        {
        // InternalSEW.g:1734:5: (lv_operator_2_0= '+' )
        // InternalSEW.g:1735:6: lv_operator_2_0= '+'
        {
        lv_operator_2_0=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return ;

        }


        }

        // InternalSEW.g:1747:4: ( (lv_operand_3_0= rulemultiplicativeExpression ) )
        // InternalSEW.g:1748:5: (lv_operand_3_0= rulemultiplicativeExpression )
        {
        // InternalSEW.g:1748:5: (lv_operand_3_0= rulemultiplicativeExpression )
        // InternalSEW.g:1749:6: lv_operand_3_0= rulemultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_31);
        lv_operand_3_0=rulemultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSEW.g:1766:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
        loop128:
        do {
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==47) ) {
                alt128=1;
            }


            switch (alt128) {
        	case 1 :
        	    // InternalSEW.g:1767:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        	    {
        	    otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return ;
        	    // InternalSEW.g:1771:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        	    // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
        	    {
        	    // InternalSEW.g:1772:6: (lv_operand_5_0= rulemultiplicativeExpression )
        	    // InternalSEW.g:1773:7: lv_operand_5_0= rulemultiplicativeExpression
        	    {
        	    if ( state.backtracking==0 ) {

        	      							newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandMultiplicativeExpressionParserRuleCall_1_3_1_0());
        	      						
        	    }
        	    pushFollow(FollowSets000.FOLLOW_31);
        	    lv_operand_5_0=rulemultiplicativeExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop128;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred60_InternalSEW

    // $ANTLR start synpred70_InternalSEW
    public final void synpred70_InternalSEW_fragment() throws RecognitionException {   
        Token lv_operator_3_0=null;
        EObject lv_operand_4_0 = null;


        // InternalSEW.g:2144:3: ( ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) )
        // InternalSEW.g:2144:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
        {
        // InternalSEW.g:2144:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
        // InternalSEW.g:2145:4: () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
        {
        // InternalSEW.g:2145:4: ()
        // InternalSEW.g:2146:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSEW.g:2155:4: ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
        // InternalSEW.g:2156:5: ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) )
        {
        // InternalSEW.g:2156:5: ( (lv_operator_3_0= '-' ) )
        // InternalSEW.g:2157:6: (lv_operator_3_0= '-' )
        {
        // InternalSEW.g:2157:6: (lv_operator_3_0= '-' )
        // InternalSEW.g:2158:7: lv_operator_3_0= '-'
        {
        lv_operator_3_0=(Token)match(input,52,FollowSets000.FOLLOW_27); if (state.failed) return ;

        }


        }

        // InternalSEW.g:2170:5: ( (lv_operand_4_0= ruleprimaryExpression ) )
        // InternalSEW.g:2171:6: (lv_operand_4_0= ruleprimaryExpression )
        {
        // InternalSEW.g:2171:6: (lv_operand_4_0= ruleprimaryExpression )
        // InternalSEW.g:2172:7: lv_operand_4_0= ruleprimaryExpression
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_1_1_0());
          						
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_operand_4_0=ruleprimaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred70_InternalSEW

    // $ANTLR start synpred76_InternalSEW
    public final void synpred76_InternalSEW_fragment() throws RecognitionException {   
        EObject this_LiteralIntegerValue_2 = null;


        // InternalSEW.g:2329:3: (this_LiteralIntegerValue_2= ruleLiteralIntegerValue )
        // InternalSEW.g:2329:3: this_LiteralIntegerValue_2= ruleLiteralIntegerValue
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_LiteralIntegerValue_2=ruleLiteralIntegerValue();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_InternalSEW

    // $ANTLR start synpred78_InternalSEW
    public final void synpred78_InternalSEW_fragment() throws RecognitionException {   
        EObject this_LiteralFloatValue_4 = null;


        // InternalSEW.g:2353:3: (this_LiteralFloatValue_4= ruleLiteralFloatValue )
        // InternalSEW.g:2353:3: this_LiteralFloatValue_4= ruleLiteralFloatValue
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_LiteralFloatValue_4=ruleLiteralFloatValue();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_InternalSEW

    // $ANTLR start synpred87_InternalSEW
    public final void synpred87_InternalSEW_fragment() throws RecognitionException {   
        // InternalSEW.g:2545:4: ( ( ( ruleUFI ) ) )
        // InternalSEW.g:2545:4: ( ( ruleUFI ) )
        {
        // InternalSEW.g:2545:4: ( ( ruleUFI ) )
        // InternalSEW.g:2546:5: ( ruleUFI )
        {
        // InternalSEW.g:2546:5: ( ruleUFI )
        // InternalSEW.g:2547:6: ruleUFI
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleUFI();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_InternalSEW

    // $ANTLR start synpred117_InternalSEW
    public final void synpred117_InternalSEW_fragment() throws RecognitionException {   
        // InternalSEW.g:4022:5: ( ruleXID )
        // InternalSEW.g:4022:5: ruleXID
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleXID();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_InternalSEW

    // $ANTLR start synpred126_InternalSEW
    public final void synpred126_InternalSEW_fragment() throws RecognitionException {   
        EObject lv_element_12_1 = null;

        EObject lv_element_12_2 = null;

        EObject lv_element_12_3 = null;


        // InternalSEW.g:4145:7: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )
        // InternalSEW.g:4145:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
        {
        // InternalSEW.g:4145:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
        // InternalSEW.g:4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
        {
        // InternalSEW.g:4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
        int alt145=3;
        alt145 = dfa145.predict(input);
        switch (alt145) {
            case 1 :
                // InternalSEW.g:4147:9: lv_element_12_1= ruleDeprecatedAttribute
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_12_1=ruleDeprecatedAttribute();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSEW.g:4163:9: lv_element_12_2= ruleDeprecatedObject
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_12_2=ruleDeprecatedObject();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalSEW.g:4179:9: lv_element_12_3= ruleObject
                {
                if ( state.backtracking==0 ) {

                  									newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getElementObjectParserRuleCall_1_2_1_1_0_2());
                  								
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_12_3=ruleObject();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred126_InternalSEW

    // Delegated rules

    public final boolean synpred70_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA117 dfa117 = new DFA117(this);
    protected DFA145 dfa145 = new DFA145(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\3\14\uffff";
    static final String dfa_3s = "\1\4\1\0\2\uffff\1\0\1\uffff\1\0\6\uffff";
    static final String dfa_4s = "\1\113\1\0\2\uffff\1\0\1\uffff\1\0\6\uffff";
    static final String dfa_5s = "\2\uffff\1\1\1\2\10\uffff\1\3";
    static final String dfa_6s = "\1\uffff\1\0\2\uffff\1\1\1\uffff\1\2\6\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\11\uffff\1\1\1\2\5\uffff\1\3\60\uffff\1\4\1\3\1\6\3\3",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "116:3: ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( ( (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty ) ) )* | ( (lv_element_9_0= ruleDeprecatedObject ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_1 = input.LA(1);

                         
                        int index9_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalSEW()) ) {s = 2;}

                        else if ( (synpred10_InternalSEW()) ) {s = 3;}

                         
                        input.seek(index9_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_4 = input.LA(1);

                         
                        int index9_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalSEW()) ) {s = 3;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index9_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalSEW()) ) {s = 3;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\12\4\2\uffff\1\20";
    static final String dfa_9s = "\12\113\2\uffff\1\37";
    static final String dfa_10s = "\12\uffff\1\2\1\1\1\uffff";
    static final String dfa_11s = "\15\uffff}>";
    static final String[] dfa_12s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "\1\13\2\uffff\1\14\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\1\12\1\uffff\2\12\45\uffff\6\13",
            "",
            "",
            "\1\13\14\uffff\1\12\1\uffff\1\12"
    };
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )";
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )";
        }
    }
    static final String dfa_13s = "\27\uffff";
    static final String dfa_14s = "\14\4\2\uffff\11\4";
    static final String dfa_15s = "\14\113\2\uffff\11\113";
    static final String dfa_16s = "\14\uffff\1\2\1\1\11\uffff";
    static final String dfa_17s = "\27\uffff}>";
    static final String[] dfa_18s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\26\11\uffff\1\16\6\uffff\1\17\60\uffff\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\26\11\uffff\1\16\6\uffff\1\17\60\uffff\1\20\1\21\1\22\1\23\1\24\1\25",
            "",
            "",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\3\uffff\1\12\1\13\2\14\51\uffff\6\15"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "541:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )";
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "616:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )";
        }
    }
    static final String dfa_19s = "\12\4\1\uffff\1\20\1\uffff";
    static final String dfa_20s = "\12\113\1\uffff\1\37\1\uffff";
    static final String dfa_21s = "\12\uffff\1\1\1\uffff\1\2";
    static final String[] dfa_22s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "",
            "\1\12\14\uffff\1\14\1\uffff\1\14",
            ""
    };
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_21;
            this.special = dfa_11;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "744:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )";
        }
    }
    static final String dfa_23s = "\14\uffff";
    static final String dfa_24s = "\1\4\11\7\2\uffff";
    static final String dfa_25s = "\1\113\11\40\2\uffff";
    static final String dfa_26s = "\12\uffff\1\2\1\1";
    static final String dfa_27s = "\14\uffff}>";
    static final String[] dfa_28s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "",
            ""
    };

    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "802:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )";
        }
    }
    static final String dfa_29s = "\12\4\2\uffff";
    static final String dfa_30s = "\12\113\2\uffff";
    static final String dfa_31s = "\12\uffff\1\1\1\2";
    static final String[] dfa_32s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "\1\12\2\uffff\1\12\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\3\uffff\4\12\3\uffff\1\13\45\uffff\6\12",
            "",
            ""
    };
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_27;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "891:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )";
        }
    }
    static final String dfa_33s = "\1\1\14\uffff";
    static final String dfa_34s = "\1\4\1\uffff\11\0\2\uffff";
    static final String dfa_35s = "\1\113\1\uffff\11\0\2\uffff";
    static final String dfa_36s = "\1\uffff\1\2\12\uffff\1\1";
    static final String dfa_37s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] dfa_38s = {
            "\1\12\11\uffff\1\2\2\uffff\1\1\3\uffff\1\3\60\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_1;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "()* loopback of 937:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA33_10 = input.LA(1);

                         
                        int index33_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index33_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_27;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )";
        }
    }
    static final String dfa_39s = "\71\uffff";
    static final String dfa_40s = "\1\2\70\uffff";
    static final String dfa_41s = "\1\4\1\0\67\uffff";
    static final String dfa_42s = "\1\116\1\0\67\uffff";
    static final String dfa_43s = "\2\uffff\1\2\65\uffff\1\1";
    static final String dfa_44s = "\1\uffff\1\0\67\uffff}>";
    static final String[] dfa_45s = {
            "\5\2\5\uffff\1\2\2\uffff\1\2\2\uffff\3\2\3\uffff\1\2\2\uffff\3\2\1\uffff\16\2\1\1\4\uffff\30\2\2\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_39;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "1722:3: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalSEW()) ) {s = 56;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\1\1\70\uffff";
    static final String dfa_47s = "\1\4\35\uffff\1\0\32\uffff";
    static final String dfa_48s = "\1\116\35\uffff\1\0\32\uffff";
    static final String dfa_49s = "\1\uffff\1\2\66\uffff\1\1";
    static final String dfa_50s = "\36\uffff\1\0\32\uffff}>";
    static final String[] dfa_51s = {
            "\5\1\5\uffff\1\1\2\uffff\1\1\2\uffff\3\1\3\uffff\1\1\2\uffff\3\1\1\uffff\16\1\1\36\4\uffff\30\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = dfa_39;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "()* loopback of 1766:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_30 = input.LA(1);

                         
                        int index50_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_InternalSEW()) ) {s = 56;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index50_30);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\16\uffff";
    static final String dfa_53s = "\1\4\2\uffff\1\6\1\62\11\uffff";
    static final String dfa_54s = "\1\113\2\uffff\1\32\1\62\11\uffff";
    static final String dfa_55s = "\1\uffff\1\1\1\2\2\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\4\1\3";
    static final String dfa_56s = "\4\uffff\1\0\11\uffff}>";
    static final String[] dfa_57s = {
            "\1\11\1\2\1\4\1\6\6\uffff\1\11\6\uffff\1\11\4\uffff\1\5\2\uffff\1\10\26\uffff\1\3\4\uffff\1\11\1\7\2\12\7\13\2\1\6\11",
            "",
            "",
            "\1\4\23\uffff\1\5",
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "2304:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_4 = input.LA(1);

                         
                        int index59_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA59_4==50) ) {s = 12;}

                        else if ( (synpred76_InternalSEW()) ) {s = 13;}

                        else if ( (synpred78_InternalSEW()) ) {s = 5;}

                         
                        input.seek(index59_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_58s = "\1\4\11\0\2\uffff";
    static final String dfa_59s = "\1\113\11\0\2\uffff";
    static final String dfa_60s = "\1\uffff\1\0\1\5\1\1\1\6\1\2\1\7\1\3\1\4\1\10\2\uffff}>";
    static final String[] dfa_61s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[][] dfa_61 = unpackEncodedStringArray(dfa_61s);

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_58;
            this.max = dfa_59;
            this.accept = dfa_31;
            this.special = dfa_60;
            this.transition = dfa_61;
        }
        public String getDescription() {
            return "2544:3: ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_7 = input.LA(1);

                         
                        int index63_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_8 = input.LA(1);

                         
                        int index63_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_2 = input.LA(1);

                         
                        int index63_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA63_6 = input.LA(1);

                         
                        int index63_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_6);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA63_9 = input.LA(1);

                         
                        int index63_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index63_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_62s = "\1\2\2\uffff\11\2\1\uffff";
    static final String dfa_63s = "\2\4\1\uffff\11\4\1\uffff";
    static final String dfa_64s = "\1\116\1\113\1\uffff\11\116\1\uffff";
    static final String dfa_65s = "\2\uffff\1\2\11\uffff\1\1";
    static final String[] dfa_66s = {
            "\5\2\5\uffff\1\2\2\uffff\1\2\2\uffff\1\1\2\2\3\uffff\1\2\2\uffff\3\2\1\uffff\53\2\2\uffff\1\2",
            "\1\13\3\2\6\uffff\1\3\6\uffff\1\4\4\uffff\1\2\2\uffff\1\2\21\uffff\1\2\4\uffff\4\2\1\uffff\15\2\1\5\1\6\1\7\1\10\1\11\1\12",
            "",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            ""
    };
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[][] dfa_66 = unpackEncodedStringArray(dfa_66s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_1;
            this.eof = dfa_62;
            this.min = dfa_63;
            this.max = dfa_64;
            this.accept = dfa_65;
            this.special = dfa_11;
            this.transition = dfa_66;
        }
        public String getDescription() {
            return "2859:3: (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?";
        }
    }
    static final String dfa_67s = "\2\4\10\7\2\uffff";
    static final String dfa_68s = "\2\113\10\40\2\uffff";
    static final String[] dfa_69s = {
            "\1\11\3\uffff\1\12\5\uffff\1\2\6\uffff\1\3\60\uffff\1\4\1\5\1\6\1\7\1\1\1\10",
            "\1\13\2\uffff\1\13\6\uffff\1\13\6\uffff\1\13\7\uffff\1\13\1\uffff\1\13\1\12\45\uffff\6\13",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\25\uffff\1\13\1\uffff\1\13\1\12",
            "",
            ""
    };
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[][] dfa_69 = unpackEncodedStringArray(dfa_69s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "3887:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )";
        }
    }
    static final String dfa_70s = "\1\uffff\1\14\1\uffff\11\14\2\uffff";
    static final String dfa_71s = "\2\4\1\uffff\11\4\1\uffff\1\20";
    static final String dfa_72s = "\2\113\1\uffff\11\113\1\uffff\1\37";
    static final String dfa_73s = "\2\uffff\1\1\11\uffff\1\2\1\uffff";
    static final String dfa_74s = "\16\uffff}>";
    static final String[] dfa_75s = {
            "\1\2\3\uffff\1\2\5\uffff\1\2\6\uffff\1\2\60\uffff\5\2\1\1",
            "\1\13\2\uffff\1\2\1\14\5\uffff\1\3\1\uffff\1\2\4\uffff\1\4\3\uffff\4\2\3\uffff\1\2\45\uffff\1\5\1\6\1\7\1\10\1\11\1\12",
            "",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\4\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\4\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\3\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "",
            "\1\2\14\uffff\1\14\1\uffff\1\14"
    };
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final char[] dfa_71 = DFA.unpackEncodedStringToUnsignedChars(dfa_71s);
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final short[] dfa_74 = DFA.unpackEncodedString(dfa_74s);
    static final short[][] dfa_75 = unpackEncodedStringArray(dfa_75s);

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_52;
            this.eof = dfa_70;
            this.min = dfa_71;
            this.max = dfa_72;
            this.accept = dfa_73;
            this.special = dfa_74;
            this.transition = dfa_75;
        }
        public String getDescription() {
            return "()* loopback of 3964:4: ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )*";
        }
    }
    static final String dfa_76s = "\67\uffff";
    static final String dfa_77s = "\12\4\2\uffff\22\7\2\4\1\20\1\uffff\2\4\1\20\22\7";
    static final String dfa_78s = "\12\113\2\uffff\22\114\2\113\1\114\1\uffff\2\113\23\114";
    static final String dfa_79s = "\12\uffff\1\1\1\3\25\uffff\1\2\25\uffff";
    static final String dfa_80s = "\67\uffff}>";
    static final String[] dfa_81s = {
            "\1\11\3\uffff\1\12\5\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\24\2\uffff\1\13\6\uffff\1\14\1\uffff\1\13\4\uffff\1\15\3\uffff\4\13\3\uffff\1\12\45\uffff\1\16\1\17\1\20\1\21\1\22\1\23",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\35\2\uffff\1\13\6\uffff\1\25\1\uffff\1\13\4\uffff\1\26\3\uffff\4\13\3\uffff\1\12\45\uffff\1\27\1\30\1\31\1\32\1\33\1\34",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\3\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "",
            "",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\55\11\uffff\1\45\6\uffff\1\46\60\uffff\1\47\1\50\1\51\1\52\1\53\1\54",
            "\1\55\11\uffff\1\45\6\uffff\1\46\60\uffff\1\47\1\50\1\51\1\52\1\53\1\54",
            "\1\13\73\uffff\1\41",
            "",
            "\1\66\11\uffff\1\56\6\uffff\1\57\60\uffff\1\60\1\61\1\62\1\63\1\64\1\65",
            "\1\66\11\uffff\1\56\6\uffff\1\57\60\uffff\1\60\1\61\1\62\1\63\1\64\1\65",
            "\1\13\73\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\10\uffff\1\36\1\37\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\10\uffff\1\42\1\43\61\uffff\1\41"
    };

    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final char[] dfa_77 = DFA.unpackEncodedStringToUnsignedChars(dfa_77s);
    static final char[] dfa_78 = DFA.unpackEncodedStringToUnsignedChars(dfa_78s);
    static final short[] dfa_79 = DFA.unpackEncodedString(dfa_79s);
    static final short[] dfa_80 = DFA.unpackEncodedString(dfa_80s);
    static final short[][] dfa_81 = unpackEncodedStringArray(dfa_81s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_76;
            this.eof = dfa_76;
            this.min = dfa_77;
            this.max = dfa_78;
            this.accept = dfa_79;
            this.special = dfa_80;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "3966:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )";
        }
    }
    static final String dfa_82s = "\1\12\14\uffff";
    static final String dfa_83s = "\1\4\11\0\3\uffff";
    static final String dfa_84s = "\1\113\11\0\3\uffff";
    static final String dfa_85s = "\12\uffff\1\2\1\uffff\1\1";
    static final String dfa_86s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff}>";
    static final String[] dfa_87s = {
            "\1\11\3\uffff\1\12\5\uffff\1\1\6\uffff\1\2\60\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };
    static final short[] dfa_82 = DFA.unpackEncodedString(dfa_82s);
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final char[] dfa_84 = DFA.unpackEncodedStringToUnsignedChars(dfa_84s);
    static final short[] dfa_85 = DFA.unpackEncodedString(dfa_85s);
    static final short[] dfa_86 = DFA.unpackEncodedString(dfa_86s);
    static final short[][] dfa_87 = unpackEncodedStringArray(dfa_87s);

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = dfa_1;
            this.eof = dfa_82;
            this.min = dfa_83;
            this.max = dfa_84;
            this.accept = dfa_85;
            this.special = dfa_86;
            this.transition = dfa_87;
        }
        public String getDescription() {
            return "4021:4: ( ruleXID )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA84_2 = input.LA(1);

                         
                        int index84_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA84_3 = input.LA(1);

                         
                        int index84_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA84_4 = input.LA(1);

                         
                        int index84_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA84_5 = input.LA(1);

                         
                        int index84_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA84_6 = input.LA(1);

                         
                        int index84_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA84_7 = input.LA(1);

                         
                        int index84_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA84_8 = input.LA(1);

                         
                        int index84_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA84_9 = input.LA(1);

                         
                        int index84_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred117_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index84_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_76;
            this.eof = dfa_76;
            this.min = dfa_77;
            this.max = dfa_78;
            this.accept = dfa_79;
            this.special = dfa_80;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "4082:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )";
        }
    }
    static final String dfa_88s = "\1\13\14\uffff";
    static final String dfa_89s = "\1\4\12\0\2\uffff";
    static final String dfa_90s = "\1\113\12\0\2\uffff";
    static final String dfa_91s = "\13\uffff\1\2\1\1";
    static final String dfa_92s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff}>";
    static final String[] dfa_93s = {
            "\1\11\3\uffff\1\12\5\uffff\1\3\6\uffff\1\4\60\uffff\1\5\1\1\1\6\1\7\1\2\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };
    static final short[] dfa_88 = DFA.unpackEncodedString(dfa_88s);
    static final char[] dfa_89 = DFA.unpackEncodedStringToUnsignedChars(dfa_89s);
    static final char[] dfa_90 = DFA.unpackEncodedStringToUnsignedChars(dfa_90s);
    static final short[] dfa_91 = DFA.unpackEncodedString(dfa_91s);
    static final short[] dfa_92 = DFA.unpackEncodedString(dfa_92s);
    static final short[][] dfa_93 = unpackEncodedStringArray(dfa_93s);

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = dfa_1;
            this.eof = dfa_88;
            this.min = dfa_89;
            this.max = dfa_90;
            this.accept = dfa_91;
            this.special = dfa_92;
            this.transition = dfa_93;
        }
        public String getDescription() {
            return "()* loopback of 4144:6: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_1 = input.LA(1);

                         
                        int index89_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA89_2 = input.LA(1);

                         
                        int index89_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA89_3 = input.LA(1);

                         
                        int index89_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA89_4 = input.LA(1);

                         
                        int index89_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA89_5 = input.LA(1);

                         
                        int index89_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA89_6 = input.LA(1);

                         
                        int index89_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA89_7 = input.LA(1);

                         
                        int index89_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA89_8 = input.LA(1);

                         
                        int index89_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA89_9 = input.LA(1);

                         
                        int index89_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA89_10 = input.LA(1);

                         
                        int index89_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index89_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 89, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_76;
            this.eof = dfa_76;
            this.min = dfa_77;
            this.max = dfa_78;
            this.accept = dfa_79;
            this.special = dfa_80;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )";
        }
    }

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_21;
            this.special = dfa_11;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )";
        }
    }

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_21;
            this.special = dfa_11;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "232:6: (lv_element_8_1= ruleObject | lv_element_8_2= ruleProperty )";
        }
    }

    class DFA117 extends DFA {

        public DFA117(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 117;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_27;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "939:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )";
        }
    }

    class DFA145 extends DFA {

        public DFA145(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 145;
            this.eot = dfa_76;
            this.eof = dfa_76;
            this.min = dfa_77;
            this.max = dfa_78;
            this.accept = dfa_79;
            this.special = dfa_80;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "4146:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000020C012L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000214090L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010080L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000224010L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000204012L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000204000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001604090L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0010000004800040L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000006000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000204010L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000214010L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000A0000080L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040204010L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFEF0800024A040F0L,0x0000000000004FFFL});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xFEF0800024A040F0L,0x0000000000000FFFL});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000F8000000002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000700000100002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000F000000000002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xFEF0800064A040F0L,0x0000000000004FFFL});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000040400000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0010000000000040L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000004000040L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000080L,0x0000000000001000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0200000000204010L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000204110L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000000000020C110L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x000000004020C110L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000000000020C112L,0x0000000000000FC0L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000018000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xFEF0800024A240F0L,0x0000000000004FFFL});
    }


}