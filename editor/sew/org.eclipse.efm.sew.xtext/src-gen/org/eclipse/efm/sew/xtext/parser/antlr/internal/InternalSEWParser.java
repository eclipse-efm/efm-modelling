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
public class InternalSEWParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_XIDENDIFIER", "RULE_CHARACTER", "RULE_INT", "RULE_STRING", "RULE_AT_IDENTIFIER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'workflow'", "'symbex-workflow'", "'{'", "'}'", "'@sew'", "'@favm'", "'<'", "'sew'", "','", "'>:'", "'::'", "'.'", "':='", "'+:='", "'['", "']'", "':'", "'='", "';'", "'?'", "'||'", "'or'", "'&&'", "'and'", "'=='", "'!='", "'==='", "'=!='", "'=/='", "'<='", "'>'", "'>='", "'+'", "'*'", "'**'", "'/'", "'%'", "'-'", "'!'", "'not'", "'('", "')'", "'&'", "'null'", "'$time'", "'$delta'", "'$this'", "'$self'", "'$parent'", "'$super'", "'$system'", "'$env'", "'env'", "'true'", "'false'", "'form'", "'endform'", "'prototype'", "'endprototype'", "'section'", "'endsection'", "'as'", "'is'", "'${'", "'|;|'", "'|i|'"
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
    // InternalSEW.g:86:1: ruleWorkflow returns [EObject current=null] : ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) ) ) ;
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

        EObject lv_element_8_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:92:2: ( ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) ) ) )
            // InternalSEW.g:93:2: ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) ) )
            {
            // InternalSEW.g:93:2: ( () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) ) )
            // InternalSEW.g:94:3: () ( ruleProlog )? ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) )
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

            // InternalSEW.g:116:3: ( ( ( ( (lv_type_2_1= 'workflow' | lv_type_2_2= 'symbex-workflow' ) ) ) ( (lv_name_3_0= ruleUFI ) )? ( (lv_description_4_0= ruleEString ) )? otherlv_5= '{' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty ) ) )* otherlv_7= '}' ) | ( (lv_element_8_0= ruleDeprecatedObject ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=14 && LA7_0<=15)) ) {
                alt7=1;
            }
            else if ( (LA7_0==69||LA7_0==71) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
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

                    if ( (LA3_0==RULE_XIDENDIFIER||LA3_0==14||LA3_0==21||(LA3_0>=69 && LA3_0<=74)) ) {
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

                        if ( (LA6_0==RULE_XIDENDIFIER||LA6_0==14||LA6_0==21||(LA6_0>=69 && LA6_0<=74)) ) {
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
                    // InternalSEW.g:230:4: ( (lv_element_8_0= ruleDeprecatedObject ) )
                    {
                    // InternalSEW.g:230:4: ( (lv_element_8_0= ruleDeprecatedObject ) )
                    // InternalSEW.g:231:5: (lv_element_8_0= ruleDeprecatedObject )
                    {
                    // InternalSEW.g:231:5: (lv_element_8_0= ruleDeprecatedObject )
                    // InternalSEW.g:232:6: lv_element_8_0= ruleDeprecatedObject
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getWorkflowAccess().getElementDeprecatedObjectParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_8_0=ruleDeprecatedObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                      						}
                      						add(
                      							current,
                      							"element",
                      							lv_element_8_0,
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
    // InternalSEW.g:254:1: entryRuleProlog returns [String current=null] : iv_ruleProlog= ruleProlog EOF ;
    public final String entryRuleProlog() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleProlog = null;


        try {
            // InternalSEW.g:254:46: (iv_ruleProlog= ruleProlog EOF )
            // InternalSEW.g:255:2: iv_ruleProlog= ruleProlog EOF
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
    // InternalSEW.g:261:1: ruleProlog returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) (kw= ',' this_EDouble_6= ruleEDouble )? ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )? kw= '>:' ) ;
    public final AntlrDatatypeRuleToken ruleProlog() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EDouble_6 = null;

        AntlrDatatypeRuleToken this_UFI_8 = null;

        AntlrDatatypeRuleToken this_EString_9 = null;



        	enterRule();

        try {
            // InternalSEW.g:267:2: ( ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) (kw= ',' this_EDouble_6= ruleEDouble )? ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )? kw= '>:' ) )
            // InternalSEW.g:268:2: ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) (kw= ',' this_EDouble_6= ruleEDouble )? ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )? kw= '>:' )
            {
            // InternalSEW.g:268:2: ( (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) (kw= ',' this_EDouble_6= ruleEDouble )? ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )? kw= '>:' )
            // InternalSEW.g:269:3: (kw= '@sew' | kw= '@favm' ) kw= '<' (kw= 'workflow' | kw= 'sew' ) (kw= ',' this_EDouble_6= ruleEDouble )? ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )? kw= '>:'
            {
            // InternalSEW.g:269:3: (kw= '@sew' | kw= '@favm' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSEW.g:270:4: kw= '@sew'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:276:4: kw= '@favm'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getFavmKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getPrologAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalSEW.g:287:3: (kw= 'workflow' | kw= 'sew' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            else if ( (LA9_0==21) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSEW.g:288:4: kw= 'workflow'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getWorkflowKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:294:4: kw= 'sew'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getSewKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:300:3: (kw= ',' this_EDouble_6= ruleEDouble )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_INT||LA10_1==25||LA10_1==51) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalSEW.g:301:4: kw= ',' this_EDouble_6= ruleEDouble
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getPrologAccess().getCommaKeyword_3_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrologAccess().getEDoubleParserRuleCall_3_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    this_EDouble_6=ruleEDouble();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_EDouble_6);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:317:3: ( (kw= ',' this_UFI_8= ruleUFI ) | this_EString_9= ruleEString )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_STRING) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // InternalSEW.g:318:4: (kw= ',' this_UFI_8= ruleUFI )
                    {
                    // InternalSEW.g:318:4: (kw= ',' this_UFI_8= ruleUFI )
                    // InternalSEW.g:319:5: kw= ',' this_UFI_8= ruleUFI
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getPrologAccess().getCommaKeyword_4_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrologAccess().getUFIParserRuleCall_4_0_1());
                      				
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


                    }
                    break;
                case 2 :
                    // InternalSEW.g:336:4: this_EString_9= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrologAccess().getEStringParserRuleCall_4_1());
                      			
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

            kw=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getPrologAccess().getGreaterThanSignColonKeyword_5());
              		
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
    // InternalSEW.g:356:1: entryRuleReservedWord returns [String current=null] : iv_ruleReservedWord= ruleReservedWord EOF ;
    public final String entryRuleReservedWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReservedWord = null;


        try {
            // InternalSEW.g:356:52: (iv_ruleReservedWord= ruleReservedWord EOF )
            // InternalSEW.g:357:2: iv_ruleReservedWord= ruleReservedWord EOF
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
    // InternalSEW.g:363:1: ruleReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord ) ;
    public final AntlrDatatypeRuleToken ruleReservedWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DeprecatedReservedWord_2 = null;



        	enterRule();

        try {
            // InternalSEW.g:369:2: ( (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord ) )
            // InternalSEW.g:370:2: (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord )
            {
            // InternalSEW.g:370:2: (kw= 'workflow' | kw= 'sew' | this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt12=1;
                }
                break;
            case 21:
                {
                alt12=2;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalSEW.g:371:3: kw= 'workflow'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReservedWordAccess().getWorkflowKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:377:3: kw= 'sew'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReservedWordAccess().getSewKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:383:3: this_DeprecatedReservedWord_2= ruleDeprecatedReservedWord
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
    // InternalSEW.g:397:1: entryRuleXID returns [String current=null] : iv_ruleXID= ruleXID EOF ;
    public final String entryRuleXID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXID = null;


        try {
            // InternalSEW.g:397:43: (iv_ruleXID= ruleXID EOF )
            // InternalSEW.g:398:2: iv_ruleXID= ruleXID EOF
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
    // InternalSEW.g:404:1: ruleXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER ) ;
    public final AntlrDatatypeRuleToken ruleXID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_XIDENDIFIER_1=null;
        AntlrDatatypeRuleToken this_ReservedWord_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:410:2: ( (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER ) )
            // InternalSEW.g:411:2: (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER )
            {
            // InternalSEW.g:411:2: (this_ReservedWord_0= ruleReservedWord | this_XIDENDIFIER_1= RULE_XIDENDIFIER )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14||LA13_0==21||(LA13_0>=69 && LA13_0<=74)) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_XIDENDIFIER) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSEW.g:412:3: this_ReservedWord_0= ruleReservedWord
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
                    // InternalSEW.g:423:3: this_XIDENDIFIER_1= RULE_XIDENDIFIER
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
    // InternalSEW.g:434:1: entryRuleUFI returns [String current=null] : iv_ruleUFI= ruleUFI EOF ;
    public final String entryRuleUFI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUFI = null;


        try {
            // InternalSEW.g:434:43: (iv_ruleUFI= ruleUFI EOF )
            // InternalSEW.g:435:2: iv_ruleUFI= ruleUFI EOF
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
    // InternalSEW.g:441:1: ruleUFI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* ) ;
    public final AntlrDatatypeRuleToken ruleUFI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_XID_0 = null;

        AntlrDatatypeRuleToken this_XID_3 = null;



        	enterRule();

        try {
            // InternalSEW.g:447:2: ( (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* ) )
            // InternalSEW.g:448:2: (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* )
            {
            // InternalSEW.g:448:2: (this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )* )
            // InternalSEW.g:449:3: this_XID_0= ruleXID ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )*
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
            // InternalSEW.g:459:3: ( (kw= '::' | kw= '.' ) this_XID_3= ruleXID )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==25) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_XIDENDIFIER||LA15_2==14||LA15_2==21||(LA15_2>=69 && LA15_2<=74)) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSEW.g:460:4: (kw= '::' | kw= '.' ) this_XID_3= ruleXID
            	    {
            	    // InternalSEW.g:460:4: (kw= '::' | kw= '.' )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==24) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==25) ) {
            	        alt14=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalSEW.g:461:5: kw= '::'
            	            {
            	            kw=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					current.merge(kw);
            	              					newLeafNode(kw, grammarAccess.getUFIAccess().getColonColonKeyword_1_0_0());
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSEW.g:467:5: kw= '.'
            	            {
            	            kw=(Token)match(input,25,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	    break loop15;
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
    // InternalSEW.g:488:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalSEW.g:488:47: (iv_ruleObject= ruleObject EOF )
            // InternalSEW.g:489:2: iv_ruleObject= ruleObject EOF
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
    // InternalSEW.g:495:1: ruleObject returns [EObject current=null] : ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) ) ;
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
            // InternalSEW.g:501:2: ( ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) ) )
            // InternalSEW.g:502:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )
            {
            // InternalSEW.g:502:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalSEW.g:503:3: ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' )
                    {
                    // InternalSEW.g:503:3: ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' )
                    // InternalSEW.g:504:4: () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}'
                    {
                    // InternalSEW.g:504:4: ()
                    // InternalSEW.g:505:5: 
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

                    // InternalSEW.g:514:4: ( (lv_type_1_0= ruleUFI ) )
                    // InternalSEW.g:515:5: (lv_type_1_0= ruleUFI )
                    {
                    // InternalSEW.g:515:5: (lv_type_1_0= ruleUFI )
                    // InternalSEW.g:516:6: lv_type_1_0= ruleUFI
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

                    // InternalSEW.g:533:4: ( (lv_name_2_0= ruleUFI ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_XIDENDIFIER||LA16_0==14||LA16_0==21||(LA16_0>=69 && LA16_0<=74)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSEW.g:534:5: (lv_name_2_0= ruleUFI )
                            {
                            // InternalSEW.g:534:5: (lv_name_2_0= ruleUFI )
                            // InternalSEW.g:535:6: lv_name_2_0= ruleUFI
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

                    // InternalSEW.g:552:4: ( (lv_description_3_0= ruleEString ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_STRING) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalSEW.g:553:5: (lv_description_3_0= ruleEString )
                            {
                            // InternalSEW.g:553:5: (lv_description_3_0= ruleEString )
                            // InternalSEW.g:554:6: lv_description_3_0= ruleEString
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
                    // InternalSEW.g:575:4: ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_XIDENDIFIER||LA19_0==14||LA19_0==21||(LA19_0>=69 && LA19_0<=74)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalSEW.g:576:5: ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:576:5: ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) )
                    	    // InternalSEW.g:577:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:577:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )
                    	    int alt18=2;
                    	    alt18 = dfa18.predict(input);
                    	    switch (alt18) {
                    	        case 1 :
                    	            // InternalSEW.g:578:7: lv_element_5_1= ruleObject
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
                    	            // InternalSEW.g:594:7: lv_element_5_2= ruleProperty
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
                    	    break loop19;
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
                    // InternalSEW.g:618:3: ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' )
                    {
                    // InternalSEW.g:618:3: ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' )
                    // InternalSEW.g:619:4: () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}'
                    {
                    // InternalSEW.g:619:4: ()
                    // InternalSEW.g:620:5: 
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

                    // InternalSEW.g:629:4: ( (lv_name_8_0= ruleUFI ) )
                    // InternalSEW.g:630:5: (lv_name_8_0= ruleUFI )
                    {
                    // InternalSEW.g:630:5: (lv_name_8_0= ruleUFI )
                    // InternalSEW.g:631:6: lv_name_8_0= ruleUFI
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectAccess().getNameUFIParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
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

                    // InternalSEW.g:648:4: (otherlv_9= ':=' | otherlv_10= '+:=' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==26) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==27) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalSEW.g:649:5: otherlv_9= ':='
                            {
                            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getObjectAccess().getColonEqualsSignKeyword_1_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSEW.g:654:5: otherlv_10= '+:='
                            {
                            otherlv_10=(Token)match(input,27,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_10, grammarAccess.getObjectAccess().getPlusSignColonEqualsSignKeyword_1_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:659:4: ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==RULE_XIDENDIFIER||LA22_0==14||LA22_0==21||(LA22_0>=69 && LA22_0<=74)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSEW.g:660:5: ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )?
                            {
                            // InternalSEW.g:660:5: ( (lv_type_11_0= ruleUFI ) )
                            // InternalSEW.g:661:6: (lv_type_11_0= ruleUFI )
                            {
                            // InternalSEW.g:661:6: (lv_type_11_0= ruleUFI )
                            // InternalSEW.g:662:7: lv_type_11_0= ruleUFI
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

                            // InternalSEW.g:679:5: ( (lv_description_12_0= ruleEString ) )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==RULE_STRING) ) {
                                alt21=1;
                            }
                            switch (alt21) {
                                case 1 :
                                    // InternalSEW.g:680:6: (lv_description_12_0= ruleEString )
                                    {
                                    // InternalSEW.g:680:6: (lv_description_12_0= ruleEString )
                                    // InternalSEW.g:681:7: lv_description_12_0= ruleEString
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
                    // InternalSEW.g:703:4: ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_XIDENDIFIER||LA24_0==14||LA24_0==21||(LA24_0>=69 && LA24_0<=74)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalSEW.g:704:5: ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) )
                    	    {
                    	    // InternalSEW.g:704:5: ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) )
                    	    // InternalSEW.g:705:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )
                    	    {
                    	    // InternalSEW.g:705:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )
                    	    int alt23=2;
                    	    alt23 = dfa23.predict(input);
                    	    switch (alt23) {
                    	        case 1 :
                    	            // InternalSEW.g:706:7: lv_element_14_1= ruleObject
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
                    	            // InternalSEW.g:722:7: lv_element_14_2= ruleProperty
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
                    	    break loop24;
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
    // InternalSEW.g:749:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalSEW.g:749:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalSEW.g:750:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalSEW.g:756:1: ruleProperty returns [EObject current=null] : (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_Section_0 = null;

        EObject this_Attribute_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:762:2: ( (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute ) )
            // InternalSEW.g:763:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )
            {
            // InternalSEW.g:763:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalSEW.g:764:3: this_Section_0= ruleSection
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
                    // InternalSEW.g:776:3: this_Attribute_1= ruleAttribute
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
    // InternalSEW.g:791:1: entryRuleSection returns [EObject current=null] : iv_ruleSection= ruleSection EOF ;
    public final EObject entryRuleSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSection = null;


        try {
            // InternalSEW.g:791:48: (iv_ruleSection= ruleSection EOF )
            // InternalSEW.g:792:2: iv_ruleSection= ruleSection EOF
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
    // InternalSEW.g:798:1: ruleSection returns [EObject current=null] : ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) ) ;
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
            // InternalSEW.g:804:2: ( ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) ) )
            // InternalSEW.g:805:2: ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) )
            {
            // InternalSEW.g:805:2: ( ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) ) )
            // InternalSEW.g:806:3: ( (lv_name_0_0= ruleXID ) ) ( (lv_description_1_0= ruleEString ) )? ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) )
            {
            // InternalSEW.g:806:3: ( (lv_name_0_0= ruleXID ) )
            // InternalSEW.g:807:4: (lv_name_0_0= ruleXID )
            {
            // InternalSEW.g:807:4: (lv_name_0_0= ruleXID )
            // InternalSEW.g:808:5: lv_name_0_0= ruleXID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSectionAccess().getNameXIDParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_17);
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

            // InternalSEW.g:825:3: ( (lv_description_1_0= ruleEString ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSEW.g:826:4: (lv_description_1_0= ruleEString )
                    {
                    // InternalSEW.g:826:4: (lv_description_1_0= ruleEString )
                    // InternalSEW.g:827:5: lv_description_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSectionAccess().getDescriptionEStringParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
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

            // InternalSEW.g:844:3: ( (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' ) | (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==28) ) {
                alt32=1;
            }
            else if ( (LA32_0==30) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalSEW.g:845:4: (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' )
                    {
                    // InternalSEW.g:845:4: (otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']' )
                    // InternalSEW.g:846:5: otherlv_2= '[' ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )* otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSectionAccess().getLeftSquareBracketKeyword_2_0_0());
                      				
                    }
                    // InternalSEW.g:850:5: ( ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_XIDENDIFIER||LA29_0==14||LA29_0==21||(LA29_0>=69 && LA29_0<=74)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalSEW.g:851:6: ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) )
                    	    {
                    	    // InternalSEW.g:851:6: ( (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute ) )
                    	    // InternalSEW.g:852:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )
                    	    {
                    	    // InternalSEW.g:852:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )
                    	    int alt28=2;
                    	    alt28 = dfa28.predict(input);
                    	    switch (alt28) {
                    	        case 1 :
                    	            // InternalSEW.g:853:8: lv_element_3_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_0_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_19);
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
                    	            // InternalSEW.g:869:8: lv_element_3_2= ruleAttribute
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_0_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_19);
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSectionAccess().getRightSquareBracketKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:893:4: (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* )
                    {
                    // InternalSEW.g:893:4: (otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )* )
                    // InternalSEW.g:894:5: otherlv_5= ':' ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*
                    {
                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getSectionAccess().getColonKeyword_2_1_0());
                      				
                    }
                    // InternalSEW.g:898:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        alt31 = dfa31.predict(input);
                        switch (alt31) {
                    	case 1 :
                    	    // InternalSEW.g:899:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
                    	    {
                    	    // InternalSEW.g:899:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
                    	    // InternalSEW.g:900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
                    	    {
                    	    // InternalSEW.g:900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
                    	    int alt30=2;
                    	    alt30 = dfa30.predict(input);
                    	    switch (alt30) {
                    	        case 1 :
                    	            // InternalSEW.g:901:8: lv_element_6_1= ruleObject
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementObjectParserRuleCall_2_1_1_0_0());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_20);
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
                    	            // InternalSEW.g:917:8: lv_element_6_2= ruleAttribute
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getSectionAccess().getElementAttributeParserRuleCall_2_1_1_0_1());
                    	              							
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_20);
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
                    	    break loop31;
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
    // InternalSEW.g:941:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSEW.g:941:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSEW.g:942:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalSEW.g:948:1: ruleAttribute returns [EObject current=null] : ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:954:2: ( ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) )
            // InternalSEW.g:955:2: ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            {
            // InternalSEW.g:955:2: ( () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            // InternalSEW.g:956:3: () ( (lv_name_1_0= ruleXID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )?
            {
            // InternalSEW.g:956:3: ()
            // InternalSEW.g:957:4: 
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

            // InternalSEW.g:966:3: ( (lv_name_1_0= ruleXID ) )
            // InternalSEW.g:967:4: (lv_name_1_0= ruleXID )
            {
            // InternalSEW.g:967:4: (lv_name_1_0= ruleXID )
            // InternalSEW.g:968:5: lv_name_1_0= ruleXID
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

            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalSEW.g:989:3: ( (lv_value_3_0= ruleValueSpecification ) )
            // InternalSEW.g:990:4: (lv_value_3_0= ruleValueSpecification )
            {
            // InternalSEW.g:990:4: (lv_value_3_0= ruleValueSpecification )
            // InternalSEW.g:991:5: lv_value_3_0= ruleValueSpecification
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

            // InternalSEW.g:1008:3: (otherlv_4= ';' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalSEW.g:1009:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:1018:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // InternalSEW.g:1018:59: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // InternalSEW.g:1019:2: iv_ruleValueSpecification= ruleValueSpecification EOF
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
    // InternalSEW.g:1025:1: ruleValueSpecification returns [EObject current=null] : this_Expression_0= ruleExpression ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1031:2: (this_Expression_0= ruleExpression )
            // InternalSEW.g:1032:2: this_Expression_0= ruleExpression
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
    // InternalSEW.g:1046:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSEW.g:1046:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSEW.g:1047:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalSEW.g:1053:1: ruleExpression returns [EObject current=null] : (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_conditionalExpression_0 = null;

        EObject this_DeprecatedExpression_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:1059:2: ( (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression ) )
            // InternalSEW.g:1060:2: (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression )
            {
            // InternalSEW.g:1060:2: (this_conditionalExpression_0= ruleconditionalExpression | this_DeprecatedExpression_1= ruleDeprecatedExpression )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_XIDENDIFIER && LA34_0<=RULE_STRING)||LA34_0==14||LA34_0==21||LA34_0==25||LA34_0==28||LA34_0==46||(LA34_0>=51 && LA34_0<=54)||(LA34_0>=56 && LA34_0<=74)) ) {
                alt34=1;
            }
            else if ( (LA34_0==77) ) {
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
                    // InternalSEW.g:1061:3: this_conditionalExpression_0= ruleconditionalExpression
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
                    // InternalSEW.g:1073:3: this_DeprecatedExpression_1= ruleDeprecatedExpression
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
    // InternalSEW.g:1088:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // InternalSEW.g:1088:62: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // InternalSEW.g:1089:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
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
    // InternalSEW.g:1095:1: ruleconditionalExpression returns [EObject current=null] : (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject this_conditionalOrExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1101:2: ( (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? ) )
            // InternalSEW.g:1102:2: (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? )
            {
            // InternalSEW.g:1102:2: (this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )? )
            // InternalSEW.g:1103:3: this_conditionalOrExpression_0= ruleconditionalOrExpression ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )?
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
            // InternalSEW.g:1114:3: ( () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSEW.g:1115:4: () ( (lv_operator_2_0= '?' ) ) ( (lv_operand_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalSEW.g:1115:4: ()
                    // InternalSEW.g:1116:5: 
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

                    // InternalSEW.g:1125:4: ( (lv_operator_2_0= '?' ) )
                    // InternalSEW.g:1126:5: (lv_operator_2_0= '?' )
                    {
                    // InternalSEW.g:1126:5: (lv_operator_2_0= '?' )
                    // InternalSEW.g:1127:6: lv_operator_2_0= '?'
                    {
                    lv_operator_2_0=(Token)match(input,33,FollowSets000.FOLLOW_22); if (state.failed) return current;
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

                    // InternalSEW.g:1139:4: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalSEW.g:1140:5: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalSEW.g:1140:5: (lv_operand_3_0= ruleExpression )
                    // InternalSEW.g:1141:6: lv_operand_3_0= ruleExpression
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

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalSEW.g:1162:4: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalSEW.g:1163:5: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalSEW.g:1163:5: (lv_operand_5_0= ruleExpression )
                    // InternalSEW.g:1164:6: lv_operand_5_0= ruleExpression
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
    // InternalSEW.g:1186:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // InternalSEW.g:1186:64: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // InternalSEW.g:1187:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
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
    // InternalSEW.g:1193:1: ruleconditionalOrExpression returns [EObject current=null] : (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? ) ;
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
            // InternalSEW.g:1199:2: ( (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? ) )
            // InternalSEW.g:1200:2: (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? )
            {
            // InternalSEW.g:1200:2: (this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )? )
            // InternalSEW.g:1201:3: this_conditionalAndExpression_0= ruleconditionalAndExpression ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )?
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
            // InternalSEW.g:1212:3: ( () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=34 && LA39_0<=35)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalSEW.g:1213:4: () ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) ) ( (lv_operand_3_0= ruleconditionalAndExpression ) ) ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )*
                    {
                    // InternalSEW.g:1213:4: ()
                    // InternalSEW.g:1214:5: 
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

                    // InternalSEW.g:1223:4: ( ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) ) )
                    // InternalSEW.g:1224:5: ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) )
                    {
                    // InternalSEW.g:1224:5: ( (lv_operator_2_1= '||' | lv_operator_2_2= 'or' ) )
                    // InternalSEW.g:1225:6: (lv_operator_2_1= '||' | lv_operator_2_2= 'or' )
                    {
                    // InternalSEW.g:1225:6: (lv_operator_2_1= '||' | lv_operator_2_2= 'or' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==34) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==35) ) {
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
                            // InternalSEW.g:1226:7: lv_operator_2_1= '||'
                            {
                            lv_operator_2_1=(Token)match(input,34,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1237:7: lv_operator_2_2= 'or'
                            {
                            lv_operator_2_2=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1250:4: ( (lv_operand_3_0= ruleconditionalAndExpression ) )
                    // InternalSEW.g:1251:5: (lv_operand_3_0= ruleconditionalAndExpression )
                    {
                    // InternalSEW.g:1251:5: (lv_operand_3_0= ruleconditionalAndExpression )
                    // InternalSEW.g:1252:6: lv_operand_3_0= ruleconditionalAndExpression
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

                    // InternalSEW.g:1269:4: ( (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=34 && LA38_0<=35)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalSEW.g:1270:5: (otherlv_4= '||' | otherlv_5= 'or' ) ( (lv_operand_6_0= ruleconditionalAndExpression ) )
                    	    {
                    	    // InternalSEW.g:1270:5: (otherlv_4= '||' | otherlv_5= 'or' )
                    	    int alt37=2;
                    	    int LA37_0 = input.LA(1);

                    	    if ( (LA37_0==34) ) {
                    	        alt37=1;
                    	    }
                    	    else if ( (LA37_0==35) ) {
                    	        alt37=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 37, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt37) {
                    	        case 1 :
                    	            // InternalSEW.g:1271:6: otherlv_4= '||'
                    	            {
                    	            otherlv_4=(Token)match(input,34,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_4, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_3_0_0());
                    	              					
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:1276:6: otherlv_5= 'or'
                    	            {
                    	            otherlv_5=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_5, grammarAccess.getConditionalOrExpressionAccess().getOrKeyword_1_3_0_1());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalSEW.g:1281:5: ( (lv_operand_6_0= ruleconditionalAndExpression ) )
                    	    // InternalSEW.g:1282:6: (lv_operand_6_0= ruleconditionalAndExpression )
                    	    {
                    	    // InternalSEW.g:1282:6: (lv_operand_6_0= ruleconditionalAndExpression )
                    	    // InternalSEW.g:1283:7: lv_operand_6_0= ruleconditionalAndExpression
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
                    	    break loop38;
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
    // InternalSEW.g:1306:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // InternalSEW.g:1306:65: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // InternalSEW.g:1307:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
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
    // InternalSEW.g:1313:1: ruleconditionalAndExpression returns [EObject current=null] : (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? ) ;
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
            // InternalSEW.g:1319:2: ( (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? ) )
            // InternalSEW.g:1320:2: (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? )
            {
            // InternalSEW.g:1320:2: (this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )? )
            // InternalSEW.g:1321:3: this_equalityExpression_0= ruleequalityExpression ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )?
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
            // InternalSEW.g:1332:3: ( () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=36 && LA43_0<=37)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalSEW.g:1333:4: () ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) ) ( (lv_operand_3_0= ruleequalityExpression ) ) ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )*
                    {
                    // InternalSEW.g:1333:4: ()
                    // InternalSEW.g:1334:5: 
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

                    // InternalSEW.g:1343:4: ( ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) ) )
                    // InternalSEW.g:1344:5: ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) )
                    {
                    // InternalSEW.g:1344:5: ( (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' ) )
                    // InternalSEW.g:1345:6: (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' )
                    {
                    // InternalSEW.g:1345:6: (lv_operator_2_1= '&&' | lv_operator_2_2= 'and' )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==36) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==37) ) {
                        alt40=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalSEW.g:1346:7: lv_operator_2_1= '&&'
                            {
                            lv_operator_2_1=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1357:7: lv_operator_2_2= 'and'
                            {
                            lv_operator_2_2=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1370:4: ( (lv_operand_3_0= ruleequalityExpression ) )
                    // InternalSEW.g:1371:5: (lv_operand_3_0= ruleequalityExpression )
                    {
                    // InternalSEW.g:1371:5: (lv_operand_3_0= ruleequalityExpression )
                    // InternalSEW.g:1372:6: lv_operand_3_0= ruleequalityExpression
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

                    // InternalSEW.g:1389:4: ( (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=36 && LA42_0<=37)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalSEW.g:1390:5: (otherlv_4= '&&' | otherlv_5= 'and' ) ( (lv_operand_6_0= ruleequalityExpression ) )
                    	    {
                    	    // InternalSEW.g:1390:5: (otherlv_4= '&&' | otherlv_5= 'and' )
                    	    int alt41=2;
                    	    int LA41_0 = input.LA(1);

                    	    if ( (LA41_0==36) ) {
                    	        alt41=1;
                    	    }
                    	    else if ( (LA41_0==37) ) {
                    	        alt41=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 41, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt41) {
                    	        case 1 :
                    	            // InternalSEW.g:1391:6: otherlv_4= '&&'
                    	            {
                    	            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_4, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_3_0_0());
                    	              					
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalSEW.g:1396:6: otherlv_5= 'and'
                    	            {
                    	            otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_5, grammarAccess.getConditionalAndExpressionAccess().getAndKeyword_1_3_0_1());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalSEW.g:1401:5: ( (lv_operand_6_0= ruleequalityExpression ) )
                    	    // InternalSEW.g:1402:6: (lv_operand_6_0= ruleequalityExpression )
                    	    {
                    	    // InternalSEW.g:1402:6: (lv_operand_6_0= ruleequalityExpression )
                    	    // InternalSEW.g:1403:7: lv_operand_6_0= ruleequalityExpression
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
                    	    break loop42;
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
    // InternalSEW.g:1426:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // InternalSEW.g:1426:59: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // InternalSEW.g:1427:2: iv_ruleequalityExpression= ruleequalityExpression EOF
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
    // InternalSEW.g:1433:1: ruleequalityExpression returns [EObject current=null] : (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? ) ;
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
            // InternalSEW.g:1439:2: ( (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? ) )
            // InternalSEW.g:1440:2: (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? )
            {
            // InternalSEW.g:1440:2: (this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )? )
            // InternalSEW.g:1441:3: this_relationalExpression_0= rulerelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )?
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
            // InternalSEW.g:1452:3: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=38 && LA45_0<=42)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalSEW.g:1453:4: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) ) ( (lv_operand_3_0= rulerelationalExpression ) )
                    {
                    // InternalSEW.g:1453:4: ()
                    // InternalSEW.g:1454:5: 
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

                    // InternalSEW.g:1463:4: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) ) )
                    // InternalSEW.g:1464:5: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) )
                    {
                    // InternalSEW.g:1464:5: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' ) )
                    // InternalSEW.g:1465:6: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' )
                    {
                    // InternalSEW.g:1465:6: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '===' | lv_operator_2_4= '=!=' | lv_operator_2_5= '=/=' )
                    int alt44=5;
                    switch ( input.LA(1) ) {
                    case 38:
                        {
                        alt44=1;
                        }
                        break;
                    case 39:
                        {
                        alt44=2;
                        }
                        break;
                    case 40:
                        {
                        alt44=3;
                        }
                        break;
                    case 41:
                        {
                        alt44=4;
                        }
                        break;
                    case 42:
                        {
                        alt44=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }

                    switch (alt44) {
                        case 1 :
                            // InternalSEW.g:1466:7: lv_operator_2_1= '=='
                            {
                            lv_operator_2_1=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1477:7: lv_operator_2_2= '!='
                            {
                            lv_operator_2_2=(Token)match(input,39,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1488:7: lv_operator_2_3= '==='
                            {
                            lv_operator_2_3=(Token)match(input,40,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1499:7: lv_operator_2_4= '=!='
                            {
                            lv_operator_2_4=(Token)match(input,41,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1510:7: lv_operator_2_5= '=/='
                            {
                            lv_operator_2_5=(Token)match(input,42,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1523:4: ( (lv_operand_3_0= rulerelationalExpression ) )
                    // InternalSEW.g:1524:5: (lv_operand_3_0= rulerelationalExpression )
                    {
                    // InternalSEW.g:1524:5: (lv_operand_3_0= rulerelationalExpression )
                    // InternalSEW.g:1525:6: lv_operand_3_0= rulerelationalExpression
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
    // InternalSEW.g:1547:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // InternalSEW.g:1547:61: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // InternalSEW.g:1548:2: iv_rulerelationalExpression= rulerelationalExpression EOF
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
    // InternalSEW.g:1554:1: rulerelationalExpression returns [EObject current=null] : (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? ) ;
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
            // InternalSEW.g:1560:2: ( (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? ) )
            // InternalSEW.g:1561:2: (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? )
            {
            // InternalSEW.g:1561:2: (this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )? )
            // InternalSEW.g:1562:3: this_additiveExpression_0= ruleadditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )?
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
            // InternalSEW.g:1573:3: ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==20||(LA47_0>=43 && LA47_0<=45)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalSEW.g:1574:4: () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_operand_3_0= ruleadditiveExpression ) )
                    {
                    // InternalSEW.g:1574:4: ()
                    // InternalSEW.g:1575:5: 
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

                    // InternalSEW.g:1584:4: ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) )
                    // InternalSEW.g:1585:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
                    {
                    // InternalSEW.g:1585:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
                    // InternalSEW.g:1586:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
                    {
                    // InternalSEW.g:1586:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
                    int alt46=4;
                    switch ( input.LA(1) ) {
                    case 20:
                        {
                        alt46=1;
                        }
                        break;
                    case 43:
                        {
                        alt46=2;
                        }
                        break;
                    case 44:
                        {
                        alt46=3;
                        }
                        break;
                    case 45:
                        {
                        alt46=4;
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
                            // InternalSEW.g:1587:7: lv_operator_2_1= '<'
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
                            // InternalSEW.g:1598:7: lv_operator_2_2= '<='
                            {
                            lv_operator_2_2=(Token)match(input,43,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1609:7: lv_operator_2_3= '>'
                            {
                            lv_operator_2_3=(Token)match(input,44,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:1620:7: lv_operator_2_4= '>='
                            {
                            lv_operator_2_4=(Token)match(input,45,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1633:4: ( (lv_operand_3_0= ruleadditiveExpression ) )
                    // InternalSEW.g:1634:5: (lv_operand_3_0= ruleadditiveExpression )
                    {
                    // InternalSEW.g:1634:5: (lv_operand_3_0= ruleadditiveExpression )
                    // InternalSEW.g:1635:6: lv_operand_3_0= ruleadditiveExpression
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
    // InternalSEW.g:1657:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // InternalSEW.g:1657:59: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // InternalSEW.g:1658:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
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
    // InternalSEW.g:1664:1: ruleadditiveExpression returns [EObject current=null] : (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject this_multiplicativeExpression_0 = null;

        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:1670:2: ( (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? ) )
            // InternalSEW.g:1671:2: (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? )
            {
            // InternalSEW.g:1671:2: (this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )? )
            // InternalSEW.g:1672:3: this_multiplicativeExpression_0= rulemultiplicativeExpression ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?
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
            // InternalSEW.g:1683:3: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // InternalSEW.g:1684:4: () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
                    {
                    // InternalSEW.g:1684:4: ()
                    // InternalSEW.g:1685:5: 
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

                    // InternalSEW.g:1694:4: ( (lv_operator_2_0= '+' ) )
                    // InternalSEW.g:1695:5: (lv_operator_2_0= '+' )
                    {
                    // InternalSEW.g:1695:5: (lv_operator_2_0= '+' )
                    // InternalSEW.g:1696:6: lv_operator_2_0= '+'
                    {
                    lv_operator_2_0=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1708:4: ( (lv_operand_3_0= rulemultiplicativeExpression ) )
                    // InternalSEW.g:1709:5: (lv_operand_3_0= rulemultiplicativeExpression )
                    {
                    // InternalSEW.g:1709:5: (lv_operand_3_0= rulemultiplicativeExpression )
                    // InternalSEW.g:1710:6: lv_operand_3_0= rulemultiplicativeExpression
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

                    // InternalSEW.g:1727:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        alt48 = dfa48.predict(input);
                        switch (alt48) {
                    	case 1 :
                    	    // InternalSEW.g:1728:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalSEW.g:1732:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
                    	    // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
                    	    {
                    	    // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
                    	    // InternalSEW.g:1734:7: lv_operand_5_0= rulemultiplicativeExpression
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
                    	    break loop48;
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
    // InternalSEW.g:1757:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // InternalSEW.g:1757:65: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // InternalSEW.g:1758:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
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
    // InternalSEW.g:1764:1: rulemultiplicativeExpression returns [EObject current=null] : (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? ) ;
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
            // InternalSEW.g:1770:2: ( (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? ) )
            // InternalSEW.g:1771:2: (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? )
            {
            // InternalSEW.g:1771:2: (this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )? )
            // InternalSEW.g:1772:3: this_primaryExpression_0= ruleprimaryExpression ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )?
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
            // InternalSEW.g:1783:3: ( ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* ) | ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* ) )?
            int alt54=5;
            switch ( input.LA(1) ) {
                case 47:
                    {
                    alt54=1;
                    }
                    break;
                case 48:
                    {
                    alt54=2;
                    }
                    break;
                case 49:
                    {
                    alt54=3;
                    }
                    break;
                case 50:
                    {
                    alt54=4;
                    }
                    break;
            }

            switch (alt54) {
                case 1 :
                    // InternalSEW.g:1784:4: ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1784:4: ( () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1785:5: () ( (lv_operator_2_0= '*' ) ) ( (lv_operand_3_0= ruleprimaryExpression ) ) (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1785:5: ()
                    // InternalSEW.g:1786:6: 
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

                    // InternalSEW.g:1795:5: ( (lv_operator_2_0= '*' ) )
                    // InternalSEW.g:1796:6: (lv_operator_2_0= '*' )
                    {
                    // InternalSEW.g:1796:6: (lv_operator_2_0= '*' )
                    // InternalSEW.g:1797:7: lv_operator_2_0= '*'
                    {
                    lv_operator_2_0=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1809:5: ( (lv_operand_3_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1810:6: (lv_operand_3_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1810:6: (lv_operand_3_0= ruleprimaryExpression )
                    // InternalSEW.g:1811:7: lv_operand_3_0= ruleprimaryExpression
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

                    // InternalSEW.g:1828:5: (otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==47) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalSEW.g:1829:6: otherlv_4= '*' ( (lv_operand_5_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:1833:6: ( (lv_operand_5_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:1834:7: (lv_operand_5_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:1834:7: (lv_operand_5_0= ruleprimaryExpression )
                    	    // InternalSEW.g:1835:8: lv_operand_5_0= ruleprimaryExpression
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
                    	    break loop50;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:1855:4: ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1855:4: ( () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1856:5: () ( (lv_operator_7_0= '**' ) ) ( (lv_operand_8_0= ruleprimaryExpression ) ) (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1856:5: ()
                    // InternalSEW.g:1857:6: 
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

                    // InternalSEW.g:1866:5: ( (lv_operator_7_0= '**' ) )
                    // InternalSEW.g:1867:6: (lv_operator_7_0= '**' )
                    {
                    // InternalSEW.g:1867:6: (lv_operator_7_0= '**' )
                    // InternalSEW.g:1868:7: lv_operator_7_0= '**'
                    {
                    lv_operator_7_0=(Token)match(input,48,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1880:5: ( (lv_operand_8_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1881:6: (lv_operand_8_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1881:6: (lv_operand_8_0= ruleprimaryExpression )
                    // InternalSEW.g:1882:7: lv_operand_8_0= ruleprimaryExpression
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

                    // InternalSEW.g:1899:5: (otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==48) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalSEW.g:1900:6: otherlv_9= '**' ( (lv_operand_10_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,48,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskAsteriskKeyword_1_1_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:1904:6: ( (lv_operand_10_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:1905:7: (lv_operand_10_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:1905:7: (lv_operand_10_0= ruleprimaryExpression )
                    	    // InternalSEW.g:1906:8: lv_operand_10_0= ruleprimaryExpression
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
                    	    break loop51;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalSEW.g:1926:4: ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1926:4: ( () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1927:5: () ( (lv_operator_12_0= '/' ) ) ( (lv_operand_13_0= ruleprimaryExpression ) ) (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1927:5: ()
                    // InternalSEW.g:1928:6: 
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

                    // InternalSEW.g:1937:5: ( (lv_operator_12_0= '/' ) )
                    // InternalSEW.g:1938:6: (lv_operator_12_0= '/' )
                    {
                    // InternalSEW.g:1938:6: (lv_operator_12_0= '/' )
                    // InternalSEW.g:1939:7: lv_operator_12_0= '/'
                    {
                    lv_operator_12_0=(Token)match(input,49,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:1951:5: ( (lv_operand_13_0= ruleprimaryExpression ) )
                    // InternalSEW.g:1952:6: (lv_operand_13_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:1952:6: (lv_operand_13_0= ruleprimaryExpression )
                    // InternalSEW.g:1953:7: lv_operand_13_0= ruleprimaryExpression
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

                    // InternalSEW.g:1970:5: (otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==49) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalSEW.g:1971:6: otherlv_14= '/' ( (lv_operand_15_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_14=(Token)match(input,49,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_14, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_2_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:1975:6: ( (lv_operand_15_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:1976:7: (lv_operand_15_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:1976:7: (lv_operand_15_0= ruleprimaryExpression )
                    	    // InternalSEW.g:1977:8: lv_operand_15_0= ruleprimaryExpression
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
                    	    break loop52;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // InternalSEW.g:1997:4: ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* )
                    {
                    // InternalSEW.g:1997:4: ( () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )* )
                    // InternalSEW.g:1998:5: () ( (lv_operator_17_0= '%' ) ) ( (lv_operand_18_0= ruleprimaryExpression ) ) (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )*
                    {
                    // InternalSEW.g:1998:5: ()
                    // InternalSEW.g:1999:6: 
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

                    // InternalSEW.g:2008:5: ( (lv_operator_17_0= '%' ) )
                    // InternalSEW.g:2009:6: (lv_operator_17_0= '%' )
                    {
                    // InternalSEW.g:2009:6: (lv_operator_17_0= '%' )
                    // InternalSEW.g:2010:7: lv_operator_17_0= '%'
                    {
                    lv_operator_17_0=(Token)match(input,50,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:2022:5: ( (lv_operand_18_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2023:6: (lv_operand_18_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2023:6: (lv_operand_18_0= ruleprimaryExpression )
                    // InternalSEW.g:2024:7: lv_operand_18_0= ruleprimaryExpression
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

                    // InternalSEW.g:2041:5: (otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==50) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalSEW.g:2042:6: otherlv_19= '%' ( (lv_operand_20_0= ruleprimaryExpression ) )
                    	    {
                    	    otherlv_19=(Token)match(input,50,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_19, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_3_3_0());
                    	      					
                    	    }
                    	    // InternalSEW.g:2046:6: ( (lv_operand_20_0= ruleprimaryExpression ) )
                    	    // InternalSEW.g:2047:7: (lv_operand_20_0= ruleprimaryExpression )
                    	    {
                    	    // InternalSEW.g:2047:7: (lv_operand_20_0= ruleprimaryExpression )
                    	    // InternalSEW.g:2048:8: lv_operand_20_0= ruleprimaryExpression
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
                    	    break loop53;
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
    // InternalSEW.g:2072:1: entryRuleprimaryExpression returns [EObject current=null] : iv_ruleprimaryExpression= ruleprimaryExpression EOF ;
    public final EObject entryRuleprimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimaryExpression = null;


        try {
            // InternalSEW.g:2072:58: (iv_ruleprimaryExpression= ruleprimaryExpression EOF )
            // InternalSEW.g:2073:2: iv_ruleprimaryExpression= ruleprimaryExpression EOF
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
    // InternalSEW.g:2079:1: ruleprimaryExpression returns [EObject current=null] : ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression ) ;
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
            // InternalSEW.g:2085:2: ( ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression ) )
            // InternalSEW.g:2086:2: ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression )
            {
            // InternalSEW.g:2086:2: ( (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression ) | ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) | ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' ) | this_LiteralExpression_11= ruleLiteralExpression )
            int alt56=5;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt56=1;
                }
                break;
            case 51:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred66_InternalSEW()) ) {
                    alt56=2;
                }
                else if ( (true) ) {
                    alt56=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
            case 53:
                {
                alt56=3;
                }
                break;
            case 54:
                {
                alt56=4;
                }
                break;
            case RULE_XIDENDIFIER:
            case RULE_CHARACTER:
            case RULE_INT:
            case RULE_STRING:
            case 14:
            case 21:
            case 25:
            case 28:
            case 56:
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
                {
                alt56=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalSEW.g:2087:3: (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2087:3: (otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression )
                    // InternalSEW.g:2088:4: otherlv_0= '+' this_primaryExpression_1= ruleprimaryExpression
                    {
                    otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                    // InternalSEW.g:2105:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
                    {
                    // InternalSEW.g:2105:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
                    // InternalSEW.g:2106:4: () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
                    {
                    // InternalSEW.g:2106:4: ()
                    // InternalSEW.g:2107:5: 
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

                    // InternalSEW.g:2116:4: ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
                    // InternalSEW.g:2117:5: ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) )
                    {
                    // InternalSEW.g:2117:5: ( (lv_operator_3_0= '-' ) )
                    // InternalSEW.g:2118:6: (lv_operator_3_0= '-' )
                    {
                    // InternalSEW.g:2118:6: (lv_operator_3_0= '-' )
                    // InternalSEW.g:2119:7: lv_operator_3_0= '-'
                    {
                    lv_operator_3_0=(Token)match(input,51,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:2131:5: ( (lv_operand_4_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2132:6: (lv_operand_4_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2132:6: (lv_operand_4_0= ruleprimaryExpression )
                    // InternalSEW.g:2133:7: lv_operand_4_0= ruleprimaryExpression
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
                    // InternalSEW.g:2153:3: ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) )
                    {
                    // InternalSEW.g:2153:3: ( () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) ) )
                    // InternalSEW.g:2154:4: () ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) )
                    {
                    // InternalSEW.g:2154:4: ()
                    // InternalSEW.g:2155:5: 
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

                    // InternalSEW.g:2164:4: ( ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) ) )
                    // InternalSEW.g:2165:5: ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) ) ( (lv_operand_7_0= ruleprimaryExpression ) )
                    {
                    // InternalSEW.g:2165:5: ( ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) ) )
                    // InternalSEW.g:2166:6: ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) )
                    {
                    // InternalSEW.g:2166:6: ( (lv_operator_6_1= '!' | lv_operator_6_2= 'not' ) )
                    // InternalSEW.g:2167:7: (lv_operator_6_1= '!' | lv_operator_6_2= 'not' )
                    {
                    // InternalSEW.g:2167:7: (lv_operator_6_1= '!' | lv_operator_6_2= 'not' )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==52) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==53) ) {
                        alt55=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 0, input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalSEW.g:2168:8: lv_operator_6_1= '!'
                            {
                            lv_operator_6_1=(Token)match(input,52,FollowSets000.FOLLOW_27); if (state.failed) return current;
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
                            // InternalSEW.g:2179:8: lv_operator_6_2= 'not'
                            {
                            lv_operator_6_2=(Token)match(input,53,FollowSets000.FOLLOW_27); if (state.failed) return current;
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

                    // InternalSEW.g:2192:5: ( (lv_operand_7_0= ruleprimaryExpression ) )
                    // InternalSEW.g:2193:6: (lv_operand_7_0= ruleprimaryExpression )
                    {
                    // InternalSEW.g:2193:6: (lv_operand_7_0= ruleprimaryExpression )
                    // InternalSEW.g:2194:7: lv_operand_7_0= ruleprimaryExpression
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
                    // InternalSEW.g:2214:3: (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' )
                    {
                    // InternalSEW.g:2214:3: (otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')' )
                    // InternalSEW.g:2215:4: otherlv_8= '(' this_Expression_9= ruleExpression otherlv_10= ')'
                    {
                    otherlv_8=(Token)match(input,54,FollowSets000.FOLLOW_22); if (state.failed) return current;
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
                    otherlv_10=(Token)match(input,55,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSEW.g:2236:3: this_LiteralExpression_11= ruleLiteralExpression
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
    // InternalSEW.g:2251:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalSEW.g:2251:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalSEW.g:2252:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
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
    // InternalSEW.g:2258:1: ruleLiteralExpression returns [EObject current=null] : (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference ) ;
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
            // InternalSEW.g:2264:2: ( (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference ) )
            // InternalSEW.g:2265:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )
            {
            // InternalSEW.g:2265:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )
            int alt57=11;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // InternalSEW.g:2266:3: this_LiteralBooleanValue_0= ruleLiteralBooleanValue
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
                    // InternalSEW.g:2278:3: this_LiteralCharacterValue_1= ruleLiteralCharacterValue
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
                    // InternalSEW.g:2290:3: this_LiteralIntegerValue_2= ruleLiteralIntegerValue
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
                    // InternalSEW.g:2302:3: this_LiteralRationalValue_3= ruleLiteralRationalValue
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
                    // InternalSEW.g:2314:3: this_LiteralFloatValue_4= ruleLiteralFloatValue
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
                    // InternalSEW.g:2326:3: this_LiteralStringValue_5= ruleLiteralStringValue
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
                    // InternalSEW.g:2338:3: this_LiteralNullValue_6= ruleLiteralNullValue
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
                    // InternalSEW.g:2350:3: this_LiteralArrayValue_7= ruleLiteralArrayValue
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
                    // InternalSEW.g:2362:3: this_LiteralObjectReference_8= ruleLiteralObjectReference
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
                    // InternalSEW.g:2374:3: this_LiteralVariableReference_9= ruleLiteralVariableReference
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
                    // InternalSEW.g:2386:3: this_LiteralInstanceReference_10= ruleLiteralInstanceReference
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
    // InternalSEW.g:2401:1: entryRuleLiteralArrayValue returns [EObject current=null] : iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF ;
    public final EObject entryRuleLiteralArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralArrayValue = null;


        try {
            // InternalSEW.g:2401:58: (iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF )
            // InternalSEW.g:2402:2: iv_ruleLiteralArrayValue= ruleLiteralArrayValue EOF
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
    // InternalSEW.g:2408:1: ruleLiteralArrayValue returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleLiteralArrayValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2414:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' ) )
            // InternalSEW.g:2415:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' )
            {
            // InternalSEW.g:2415:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']' )
            // InternalSEW.g:2416:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )? otherlv_5= ']'
            {
            // InternalSEW.g:2416:3: ()
            // InternalSEW.g:2417:4: 
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

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralArrayValueAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalSEW.g:2430:3: ( ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_XIDENDIFIER && LA59_0<=RULE_STRING)||LA59_0==14||LA59_0==21||LA59_0==25||LA59_0==28||LA59_0==46||(LA59_0>=51 && LA59_0<=54)||(LA59_0>=56 && LA59_0<=74)||LA59_0==77) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalSEW.g:2431:4: ( (lv_values_2_0= ruleValueSpecification ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )*
                    {
                    // InternalSEW.g:2431:4: ( (lv_values_2_0= ruleValueSpecification ) )
                    // InternalSEW.g:2432:5: (lv_values_2_0= ruleValueSpecification )
                    {
                    // InternalSEW.g:2432:5: (lv_values_2_0= ruleValueSpecification )
                    // InternalSEW.g:2433:6: lv_values_2_0= ruleValueSpecification
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

                    // InternalSEW.g:2450:4: (otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==22) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalSEW.g:2451:5: otherlv_3= ',' ( (lv_values_4_0= ruleValueSpecification ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getLiteralArrayValueAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalSEW.g:2455:5: ( (lv_values_4_0= ruleValueSpecification ) )
                    	    // InternalSEW.g:2456:6: (lv_values_4_0= ruleValueSpecification )
                    	    {
                    	    // InternalSEW.g:2456:6: (lv_values_4_0= ruleValueSpecification )
                    	    // InternalSEW.g:2457:7: lv_values_4_0= ruleValueSpecification
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:2484:1: entryRuleLiteralObjectReference returns [EObject current=null] : iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF ;
    public final EObject entryRuleLiteralObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralObjectReference = null;


        try {
            // InternalSEW.g:2484:63: (iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF )
            // InternalSEW.g:2485:2: iv_ruleLiteralObjectReference= ruleLiteralObjectReference EOF
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
    // InternalSEW.g:2491:1: ruleLiteralObjectReference returns [EObject current=null] : ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) ) ;
    public final EObject ruleLiteralObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_symbol_2_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2497:2: ( ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) ) )
            // InternalSEW.g:2498:2: ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) )
            {
            // InternalSEW.g:2498:2: ( (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) ) )
            // InternalSEW.g:2499:3: (otherlv_0= '&' )? ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )
            {
            // InternalSEW.g:2499:3: (otherlv_0= '&' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalSEW.g:2500:4: otherlv_0= '&'
                    {
                    otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getLiteralObjectReferenceAccess().getAmpersandKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:2505:3: ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalSEW.g:2506:4: ( ( ruleUFI ) )
                    {
                    // InternalSEW.g:2506:4: ( ( ruleUFI ) )
                    // InternalSEW.g:2507:5: ( ruleUFI )
                    {
                    // InternalSEW.g:2507:5: ( ruleUFI )
                    // InternalSEW.g:2508:6: ruleUFI
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
                    // InternalSEW.g:2526:4: ( (lv_symbol_2_0= ruleUFI ) )
                    {
                    // InternalSEW.g:2526:4: ( (lv_symbol_2_0= ruleUFI ) )
                    // InternalSEW.g:2527:5: (lv_symbol_2_0= ruleUFI )
                    {
                    // InternalSEW.g:2527:5: (lv_symbol_2_0= ruleUFI )
                    // InternalSEW.g:2528:6: lv_symbol_2_0= ruleUFI
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
    // InternalSEW.g:2550:1: entryRuleLiteralBooleanValue returns [EObject current=null] : iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF ;
    public final EObject entryRuleLiteralBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBooleanValue = null;


        try {
            // InternalSEW.g:2550:60: (iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF )
            // InternalSEW.g:2551:2: iv_ruleLiteralBooleanValue= ruleLiteralBooleanValue EOF
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
    // InternalSEW.g:2557:1: ruleLiteralBooleanValue returns [EObject current=null] : ( (lv_value_0_0= ruleEBoolean ) ) ;
    public final EObject ruleLiteralBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2563:2: ( ( (lv_value_0_0= ruleEBoolean ) ) )
            // InternalSEW.g:2564:2: ( (lv_value_0_0= ruleEBoolean ) )
            {
            // InternalSEW.g:2564:2: ( (lv_value_0_0= ruleEBoolean ) )
            // InternalSEW.g:2565:3: (lv_value_0_0= ruleEBoolean )
            {
            // InternalSEW.g:2565:3: (lv_value_0_0= ruleEBoolean )
            // InternalSEW.g:2566:4: lv_value_0_0= ruleEBoolean
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
    // InternalSEW.g:2586:1: entryRuleLiteralCharacterValue returns [EObject current=null] : iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF ;
    public final EObject entryRuleLiteralCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralCharacterValue = null;


        try {
            // InternalSEW.g:2586:62: (iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF )
            // InternalSEW.g:2587:2: iv_ruleLiteralCharacterValue= ruleLiteralCharacterValue EOF
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
    // InternalSEW.g:2593:1: ruleLiteralCharacterValue returns [EObject current=null] : ( (lv_value_0_0= ruleEChar ) ) ;
    public final EObject ruleLiteralCharacterValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2599:2: ( ( (lv_value_0_0= ruleEChar ) ) )
            // InternalSEW.g:2600:2: ( (lv_value_0_0= ruleEChar ) )
            {
            // InternalSEW.g:2600:2: ( (lv_value_0_0= ruleEChar ) )
            // InternalSEW.g:2601:3: (lv_value_0_0= ruleEChar )
            {
            // InternalSEW.g:2601:3: (lv_value_0_0= ruleEChar )
            // InternalSEW.g:2602:4: lv_value_0_0= ruleEChar
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
    // InternalSEW.g:2622:1: entryRuleLiteralIntegerValue returns [EObject current=null] : iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF ;
    public final EObject entryRuleLiteralIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralIntegerValue = null;


        try {
            // InternalSEW.g:2622:60: (iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF )
            // InternalSEW.g:2623:2: iv_ruleLiteralIntegerValue= ruleLiteralIntegerValue EOF
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
    // InternalSEW.g:2629:1: ruleLiteralIntegerValue returns [EObject current=null] : ( (lv_value_0_0= ruleELong ) ) ;
    public final EObject ruleLiteralIntegerValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2635:2: ( ( (lv_value_0_0= ruleELong ) ) )
            // InternalSEW.g:2636:2: ( (lv_value_0_0= ruleELong ) )
            {
            // InternalSEW.g:2636:2: ( (lv_value_0_0= ruleELong ) )
            // InternalSEW.g:2637:3: (lv_value_0_0= ruleELong )
            {
            // InternalSEW.g:2637:3: (lv_value_0_0= ruleELong )
            // InternalSEW.g:2638:4: lv_value_0_0= ruleELong
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
    // InternalSEW.g:2658:1: entryRuleLiteralRationalValue returns [EObject current=null] : iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF ;
    public final EObject entryRuleLiteralRationalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRationalValue = null;


        try {
            // InternalSEW.g:2658:61: (iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF )
            // InternalSEW.g:2659:2: iv_ruleLiteralRationalValue= ruleLiteralRationalValue EOF
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
    // InternalSEW.g:2665:1: ruleLiteralRationalValue returns [EObject current=null] : ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) ) ;
    public final EObject ruleLiteralRationalValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_numerator_0_0 = null;

        AntlrDatatypeRuleToken lv_denominator_2_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2671:2: ( ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) ) )
            // InternalSEW.g:2672:2: ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) )
            {
            // InternalSEW.g:2672:2: ( ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) ) )
            // InternalSEW.g:2673:3: ( (lv_numerator_0_0= ruleELong ) ) otherlv_1= '/' ( (lv_denominator_2_0= ruleELong ) )
            {
            // InternalSEW.g:2673:3: ( (lv_numerator_0_0= ruleELong ) )
            // InternalSEW.g:2674:4: (lv_numerator_0_0= ruleELong )
            {
            // InternalSEW.g:2674:4: (lv_numerator_0_0= ruleELong )
            // InternalSEW.g:2675:5: lv_numerator_0_0= ruleELong
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

            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralRationalValueAccess().getSolidusKeyword_1());
              		
            }
            // InternalSEW.g:2696:3: ( (lv_denominator_2_0= ruleELong ) )
            // InternalSEW.g:2697:4: (lv_denominator_2_0= ruleELong )
            {
            // InternalSEW.g:2697:4: (lv_denominator_2_0= ruleELong )
            // InternalSEW.g:2698:5: lv_denominator_2_0= ruleELong
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
    // InternalSEW.g:2719:1: entryRuleLiteralFloatValue returns [EObject current=null] : iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF ;
    public final EObject entryRuleLiteralFloatValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFloatValue = null;


        try {
            // InternalSEW.g:2719:58: (iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF )
            // InternalSEW.g:2720:2: iv_ruleLiteralFloatValue= ruleLiteralFloatValue EOF
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
    // InternalSEW.g:2726:1: ruleLiteralFloatValue returns [EObject current=null] : ( (lv_value_0_0= ruleEDouble ) ) ;
    public final EObject ruleLiteralFloatValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2732:2: ( ( (lv_value_0_0= ruleEDouble ) ) )
            // InternalSEW.g:2733:2: ( (lv_value_0_0= ruleEDouble ) )
            {
            // InternalSEW.g:2733:2: ( (lv_value_0_0= ruleEDouble ) )
            // InternalSEW.g:2734:3: (lv_value_0_0= ruleEDouble )
            {
            // InternalSEW.g:2734:3: (lv_value_0_0= ruleEDouble )
            // InternalSEW.g:2735:4: lv_value_0_0= ruleEDouble
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
    // InternalSEW.g:2755:1: entryRuleLiteralStringValue returns [EObject current=null] : iv_ruleLiteralStringValue= ruleLiteralStringValue EOF ;
    public final EObject entryRuleLiteralStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralStringValue = null;


        try {
            // InternalSEW.g:2755:59: (iv_ruleLiteralStringValue= ruleLiteralStringValue EOF )
            // InternalSEW.g:2756:2: iv_ruleLiteralStringValue= ruleLiteralStringValue EOF
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
    // InternalSEW.g:2762:1: ruleLiteralStringValue returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleLiteralStringValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2768:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalSEW.g:2769:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalSEW.g:2769:2: ( (lv_value_0_0= ruleEString ) )
            // InternalSEW.g:2770:3: (lv_value_0_0= ruleEString )
            {
            // InternalSEW.g:2770:3: (lv_value_0_0= ruleEString )
            // InternalSEW.g:2771:4: lv_value_0_0= ruleEString
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
    // InternalSEW.g:2791:1: entryRuleLiteralNullValue returns [EObject current=null] : iv_ruleLiteralNullValue= ruleLiteralNullValue EOF ;
    public final EObject entryRuleLiteralNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNullValue = null;


        try {
            // InternalSEW.g:2791:57: (iv_ruleLiteralNullValue= ruleLiteralNullValue EOF )
            // InternalSEW.g:2792:2: iv_ruleLiteralNullValue= ruleLiteralNullValue EOF
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
    // InternalSEW.g:2798:1: ruleLiteralNullValue returns [EObject current=null] : ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? ) ;
    public final EObject ruleLiteralNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:2804:2: ( ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? ) )
            // InternalSEW.g:2805:2: ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? )
            {
            // InternalSEW.g:2805:2: ( () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )? )
            // InternalSEW.g:2806:3: () otherlv_1= 'null' (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?
            {
            // InternalSEW.g:2806:3: ()
            // InternalSEW.g:2807:4: 
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

            otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralNullValueAccess().getNullKeyword_1());
              		
            }
            // InternalSEW.g:2820:3: (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalSEW.g:2821:4: otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>'
                    {
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLiteralNullValueAccess().getLessThanSignKeyword_2_0());
                      			
                    }
                    // InternalSEW.g:2825:4: ( (lv_type_3_0= ruleXID ) )
                    // InternalSEW.g:2826:5: (lv_type_3_0= ruleXID )
                    {
                    // InternalSEW.g:2826:5: (lv_type_3_0= ruleXID )
                    // InternalSEW.g:2827:6: lv_type_3_0= ruleXID
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

                    otherlv_4=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:2853:1: entryRuleLiteralVariableReference returns [EObject current=null] : iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF ;
    public final EObject entryRuleLiteralVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralVariableReference = null;


        try {
            // InternalSEW.g:2853:65: (iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF )
            // InternalSEW.g:2854:2: iv_ruleLiteralVariableReference= ruleLiteralVariableReference EOF
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
    // InternalSEW.g:2860:1: ruleLiteralVariableReference returns [EObject current=null] : (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable ) ;
    public final EObject ruleLiteralVariableReference() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralTimeVariable_0 = null;

        EObject this_LiteralTimeDeltaVariable_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:2866:2: ( (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable ) )
            // InternalSEW.g:2867:2: (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable )
            {
            // InternalSEW.g:2867:2: (this_LiteralTimeVariable_0= ruleLiteralTimeVariable | this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==58) ) {
                alt63=1;
            }
            else if ( (LA63_0==59) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalSEW.g:2868:3: this_LiteralTimeVariable_0= ruleLiteralTimeVariable
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
                    // InternalSEW.g:2880:3: this_LiteralTimeDeltaVariable_1= ruleLiteralTimeDeltaVariable
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
    // InternalSEW.g:2895:1: entryRuleLiteralTimeVariable returns [EObject current=null] : iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF ;
    public final EObject entryRuleLiteralTimeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTimeVariable = null;


        try {
            // InternalSEW.g:2895:60: (iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF )
            // InternalSEW.g:2896:2: iv_ruleLiteralTimeVariable= ruleLiteralTimeVariable EOF
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
    // InternalSEW.g:2902:1: ruleLiteralTimeVariable returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$time' ) ) ) ;
    public final EObject ruleLiteralTimeVariable() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:2908:2: ( ( () ( (lv_symbol_1_0= '$time' ) ) ) )
            // InternalSEW.g:2909:2: ( () ( (lv_symbol_1_0= '$time' ) ) )
            {
            // InternalSEW.g:2909:2: ( () ( (lv_symbol_1_0= '$time' ) ) )
            // InternalSEW.g:2910:3: () ( (lv_symbol_1_0= '$time' ) )
            {
            // InternalSEW.g:2910:3: ()
            // InternalSEW.g:2911:4: 
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

            // InternalSEW.g:2920:3: ( (lv_symbol_1_0= '$time' ) )
            // InternalSEW.g:2921:4: (lv_symbol_1_0= '$time' )
            {
            // InternalSEW.g:2921:4: (lv_symbol_1_0= '$time' )
            // InternalSEW.g:2922:5: lv_symbol_1_0= '$time'
            {
            lv_symbol_1_0=(Token)match(input,58,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:2938:1: entryRuleLiteralTimeDeltaVariable returns [EObject current=null] : iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF ;
    public final EObject entryRuleLiteralTimeDeltaVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTimeDeltaVariable = null;


        try {
            // InternalSEW.g:2938:65: (iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF )
            // InternalSEW.g:2939:2: iv_ruleLiteralTimeDeltaVariable= ruleLiteralTimeDeltaVariable EOF
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
    // InternalSEW.g:2945:1: ruleLiteralTimeDeltaVariable returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$delta' ) ) ) ;
    public final EObject ruleLiteralTimeDeltaVariable() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:2951:2: ( ( () ( (lv_symbol_1_0= '$delta' ) ) ) )
            // InternalSEW.g:2952:2: ( () ( (lv_symbol_1_0= '$delta' ) ) )
            {
            // InternalSEW.g:2952:2: ( () ( (lv_symbol_1_0= '$delta' ) ) )
            // InternalSEW.g:2953:3: () ( (lv_symbol_1_0= '$delta' ) )
            {
            // InternalSEW.g:2953:3: ()
            // InternalSEW.g:2954:4: 
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

            // InternalSEW.g:2963:3: ( (lv_symbol_1_0= '$delta' ) )
            // InternalSEW.g:2964:4: (lv_symbol_1_0= '$delta' )
            {
            // InternalSEW.g:2964:4: (lv_symbol_1_0= '$delta' )
            // InternalSEW.g:2965:5: lv_symbol_1_0= '$delta'
            {
            lv_symbol_1_0=(Token)match(input,59,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:2981:1: entryRuleLiteralInstanceReference returns [EObject current=null] : iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF ;
    public final EObject entryRuleLiteralInstanceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralInstanceReference = null;


        try {
            // InternalSEW.g:2981:65: (iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF )
            // InternalSEW.g:2982:2: iv_ruleLiteralInstanceReference= ruleLiteralInstanceReference EOF
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
    // InternalSEW.g:2988:1: ruleLiteralInstanceReference returns [EObject current=null] : (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance ) ;
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
            // InternalSEW.g:2994:2: ( (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance ) )
            // InternalSEW.g:2995:2: (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance )
            {
            // InternalSEW.g:2995:2: (this_LiteralThisInstance_0= ruleLiteralThisInstance | this_LiteralSelfInstance_1= ruleLiteralSelfInstance | this_LiteralParentInstance_2= ruleLiteralParentInstance | this_LiteralSuperInstance_3= ruleLiteralSuperInstance | this_LiteralSystemInstance_4= ruleLiteralSystemInstance | this_LiteralEnvInstance_5= ruleLiteralEnvInstance )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt64=1;
                }
                break;
            case 61:
                {
                alt64=2;
                }
                break;
            case 62:
                {
                alt64=3;
                }
                break;
            case 63:
                {
                alt64=4;
                }
                break;
            case 64:
                {
                alt64=5;
                }
                break;
            case 65:
            case 66:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalSEW.g:2996:3: this_LiteralThisInstance_0= ruleLiteralThisInstance
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
                    // InternalSEW.g:3008:3: this_LiteralSelfInstance_1= ruleLiteralSelfInstance
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
                    // InternalSEW.g:3020:3: this_LiteralParentInstance_2= ruleLiteralParentInstance
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
                    // InternalSEW.g:3032:3: this_LiteralSuperInstance_3= ruleLiteralSuperInstance
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
                    // InternalSEW.g:3044:3: this_LiteralSystemInstance_4= ruleLiteralSystemInstance
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
                    // InternalSEW.g:3056:3: this_LiteralEnvInstance_5= ruleLiteralEnvInstance
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
    // InternalSEW.g:3071:1: entryRuleLiteralThisInstance returns [EObject current=null] : iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF ;
    public final EObject entryRuleLiteralThisInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralThisInstance = null;


        try {
            // InternalSEW.g:3071:60: (iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF )
            // InternalSEW.g:3072:2: iv_ruleLiteralThisInstance= ruleLiteralThisInstance EOF
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
    // InternalSEW.g:3078:1: ruleLiteralThisInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$this' ) ) ) ;
    public final EObject ruleLiteralThisInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3084:2: ( ( () ( (lv_symbol_1_0= '$this' ) ) ) )
            // InternalSEW.g:3085:2: ( () ( (lv_symbol_1_0= '$this' ) ) )
            {
            // InternalSEW.g:3085:2: ( () ( (lv_symbol_1_0= '$this' ) ) )
            // InternalSEW.g:3086:3: () ( (lv_symbol_1_0= '$this' ) )
            {
            // InternalSEW.g:3086:3: ()
            // InternalSEW.g:3087:4: 
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

            // InternalSEW.g:3096:3: ( (lv_symbol_1_0= '$this' ) )
            // InternalSEW.g:3097:4: (lv_symbol_1_0= '$this' )
            {
            // InternalSEW.g:3097:4: (lv_symbol_1_0= '$this' )
            // InternalSEW.g:3098:5: lv_symbol_1_0= '$this'
            {
            lv_symbol_1_0=(Token)match(input,60,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3114:1: entryRuleLiteralSelfInstance returns [EObject current=null] : iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF ;
    public final EObject entryRuleLiteralSelfInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSelfInstance = null;


        try {
            // InternalSEW.g:3114:60: (iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF )
            // InternalSEW.g:3115:2: iv_ruleLiteralSelfInstance= ruleLiteralSelfInstance EOF
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
    // InternalSEW.g:3121:1: ruleLiteralSelfInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$self' ) ) ) ;
    public final EObject ruleLiteralSelfInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3127:2: ( ( () ( (lv_symbol_1_0= '$self' ) ) ) )
            // InternalSEW.g:3128:2: ( () ( (lv_symbol_1_0= '$self' ) ) )
            {
            // InternalSEW.g:3128:2: ( () ( (lv_symbol_1_0= '$self' ) ) )
            // InternalSEW.g:3129:3: () ( (lv_symbol_1_0= '$self' ) )
            {
            // InternalSEW.g:3129:3: ()
            // InternalSEW.g:3130:4: 
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

            // InternalSEW.g:3139:3: ( (lv_symbol_1_0= '$self' ) )
            // InternalSEW.g:3140:4: (lv_symbol_1_0= '$self' )
            {
            // InternalSEW.g:3140:4: (lv_symbol_1_0= '$self' )
            // InternalSEW.g:3141:5: lv_symbol_1_0= '$self'
            {
            lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3157:1: entryRuleLiteralParentInstance returns [EObject current=null] : iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF ;
    public final EObject entryRuleLiteralParentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralParentInstance = null;


        try {
            // InternalSEW.g:3157:62: (iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF )
            // InternalSEW.g:3158:2: iv_ruleLiteralParentInstance= ruleLiteralParentInstance EOF
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
    // InternalSEW.g:3164:1: ruleLiteralParentInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$parent' ) ) ) ;
    public final EObject ruleLiteralParentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3170:2: ( ( () ( (lv_symbol_1_0= '$parent' ) ) ) )
            // InternalSEW.g:3171:2: ( () ( (lv_symbol_1_0= '$parent' ) ) )
            {
            // InternalSEW.g:3171:2: ( () ( (lv_symbol_1_0= '$parent' ) ) )
            // InternalSEW.g:3172:3: () ( (lv_symbol_1_0= '$parent' ) )
            {
            // InternalSEW.g:3172:3: ()
            // InternalSEW.g:3173:4: 
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

            // InternalSEW.g:3182:3: ( (lv_symbol_1_0= '$parent' ) )
            // InternalSEW.g:3183:4: (lv_symbol_1_0= '$parent' )
            {
            // InternalSEW.g:3183:4: (lv_symbol_1_0= '$parent' )
            // InternalSEW.g:3184:5: lv_symbol_1_0= '$parent'
            {
            lv_symbol_1_0=(Token)match(input,62,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3200:1: entryRuleLiteralSuperInstance returns [EObject current=null] : iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF ;
    public final EObject entryRuleLiteralSuperInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSuperInstance = null;


        try {
            // InternalSEW.g:3200:61: (iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF )
            // InternalSEW.g:3201:2: iv_ruleLiteralSuperInstance= ruleLiteralSuperInstance EOF
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
    // InternalSEW.g:3207:1: ruleLiteralSuperInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$super' ) ) ) ;
    public final EObject ruleLiteralSuperInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3213:2: ( ( () ( (lv_symbol_1_0= '$super' ) ) ) )
            // InternalSEW.g:3214:2: ( () ( (lv_symbol_1_0= '$super' ) ) )
            {
            // InternalSEW.g:3214:2: ( () ( (lv_symbol_1_0= '$super' ) ) )
            // InternalSEW.g:3215:3: () ( (lv_symbol_1_0= '$super' ) )
            {
            // InternalSEW.g:3215:3: ()
            // InternalSEW.g:3216:4: 
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

            // InternalSEW.g:3225:3: ( (lv_symbol_1_0= '$super' ) )
            // InternalSEW.g:3226:4: (lv_symbol_1_0= '$super' )
            {
            // InternalSEW.g:3226:4: (lv_symbol_1_0= '$super' )
            // InternalSEW.g:3227:5: lv_symbol_1_0= '$super'
            {
            lv_symbol_1_0=(Token)match(input,63,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3243:1: entryRuleLiteralSystemInstance returns [EObject current=null] : iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF ;
    public final EObject entryRuleLiteralSystemInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralSystemInstance = null;


        try {
            // InternalSEW.g:3243:62: (iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF )
            // InternalSEW.g:3244:2: iv_ruleLiteralSystemInstance= ruleLiteralSystemInstance EOF
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
    // InternalSEW.g:3250:1: ruleLiteralSystemInstance returns [EObject current=null] : ( () ( (lv_symbol_1_0= '$system' ) ) ) ;
    public final EObject ruleLiteralSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3256:2: ( ( () ( (lv_symbol_1_0= '$system' ) ) ) )
            // InternalSEW.g:3257:2: ( () ( (lv_symbol_1_0= '$system' ) ) )
            {
            // InternalSEW.g:3257:2: ( () ( (lv_symbol_1_0= '$system' ) ) )
            // InternalSEW.g:3258:3: () ( (lv_symbol_1_0= '$system' ) )
            {
            // InternalSEW.g:3258:3: ()
            // InternalSEW.g:3259:4: 
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

            // InternalSEW.g:3268:3: ( (lv_symbol_1_0= '$system' ) )
            // InternalSEW.g:3269:4: (lv_symbol_1_0= '$system' )
            {
            // InternalSEW.g:3269:4: (lv_symbol_1_0= '$system' )
            // InternalSEW.g:3270:5: lv_symbol_1_0= '$system'
            {
            lv_symbol_1_0=(Token)match(input,64,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3286:1: entryRuleLiteralEnvInstance returns [EObject current=null] : iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF ;
    public final EObject entryRuleLiteralEnvInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralEnvInstance = null;


        try {
            // InternalSEW.g:3286:59: (iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF )
            // InternalSEW.g:3287:2: iv_ruleLiteralEnvInstance= ruleLiteralEnvInstance EOF
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
    // InternalSEW.g:3293:1: ruleLiteralEnvInstance returns [EObject current=null] : ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) ) ;
    public final EObject ruleLiteralEnvInstance() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;


        	enterRule();

        try {
            // InternalSEW.g:3299:2: ( ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) ) )
            // InternalSEW.g:3300:2: ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) )
            {
            // InternalSEW.g:3300:2: ( () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) ) )
            // InternalSEW.g:3301:3: () ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) )
            {
            // InternalSEW.g:3301:3: ()
            // InternalSEW.g:3302:4: 
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

            // InternalSEW.g:3311:3: ( ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) ) )
            // InternalSEW.g:3312:4: ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) )
            {
            // InternalSEW.g:3312:4: ( (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' ) )
            // InternalSEW.g:3313:5: (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' )
            {
            // InternalSEW.g:3313:5: (lv_symbol_1_1= '$env' | lv_symbol_1_2= 'env' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==65) ) {
                alt65=1;
            }
            else if ( (LA65_0==66) ) {
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
                    // InternalSEW.g:3314:6: lv_symbol_1_1= '$env'
                    {
                    lv_symbol_1_1=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalSEW.g:3325:6: lv_symbol_1_2= 'env'
                    {
                    lv_symbol_1_2=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3342:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalSEW.g:3342:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalSEW.g:3343:2: iv_ruleEBoolean= ruleEBoolean EOF
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
    // InternalSEW.g:3349:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSEW.g:3355:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalSEW.g:3356:2: (kw= 'true' | kw= 'false' )
            {
            // InternalSEW.g:3356:2: (kw= 'true' | kw= 'false' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==67) ) {
                alt66=1;
            }
            else if ( (LA66_0==68) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalSEW.g:3357:3: kw= 'true'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3363:3: kw= 'false'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3372:1: entryRuleEChar returns [String current=null] : iv_ruleEChar= ruleEChar EOF ;
    public final String entryRuleEChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEChar = null;


        try {
            // InternalSEW.g:3372:45: (iv_ruleEChar= ruleEChar EOF )
            // InternalSEW.g:3373:2: iv_ruleEChar= ruleEChar EOF
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
    // InternalSEW.g:3379:1: ruleEChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CHARACTER_0= RULE_CHARACTER ;
    public final AntlrDatatypeRuleToken ruleEChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHARACTER_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3385:2: (this_CHARACTER_0= RULE_CHARACTER )
            // InternalSEW.g:3386:2: this_CHARACTER_0= RULE_CHARACTER
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
    // InternalSEW.g:3396:1: entryRuleELong returns [String current=null] : iv_ruleELong= ruleELong EOF ;
    public final String entryRuleELong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleELong = null;


        try {
            // InternalSEW.g:3396:45: (iv_ruleELong= ruleELong EOF )
            // InternalSEW.g:3397:2: iv_ruleELong= ruleELong EOF
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
    // InternalSEW.g:3403:1: ruleELong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleELong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalSEW.g:3409:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalSEW.g:3410:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalSEW.g:3410:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalSEW.g:3411:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalSEW.g:3411:3: (kw= '-' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==51) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalSEW.g:3412:4: kw= '-'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_44); if (state.failed) return current;
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
    // InternalSEW.g:3429:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalSEW.g:3429:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalSEW.g:3430:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalSEW.g:3436:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalSEW.g:3442:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ) )
            // InternalSEW.g:3443:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT )
            {
            // InternalSEW.g:3443:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT )
            // InternalSEW.g:3444:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT
            {
            // InternalSEW.g:3444:3: (kw= '-' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==51) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalSEW.g:3445:4: kw= '-'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalSEW.g:3451:3: (this_INT_1= RULE_INT )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_INT) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalSEW.g:3452:4: this_INT_1= RULE_INT
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

            kw=(Token)match(input,25,FollowSets000.FOLLOW_44); if (state.failed) return current;
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
    // InternalSEW.g:3476:1: entryRuleEBigDecimal returns [String current=null] : iv_ruleEBigDecimal= ruleEBigDecimal EOF ;
    public final String entryRuleEBigDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBigDecimal = null;


        try {
            // InternalSEW.g:3476:51: (iv_ruleEBigDecimal= ruleEBigDecimal EOF )
            // InternalSEW.g:3477:2: iv_ruleEBigDecimal= ruleEBigDecimal EOF
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
    // InternalSEW.g:3483:1: ruleEBigDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEBigDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSEW.g:3489:2: ( ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT ) )
            // InternalSEW.g:3490:2: ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT )
            {
            // InternalSEW.g:3490:2: ( (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT )
            // InternalSEW.g:3491:3: (this_INT_0= RULE_INT )? kw= '.' this_INT_2= RULE_INT
            {
            // InternalSEW.g:3491:3: (this_INT_0= RULE_INT )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_INT) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalSEW.g:3492:4: this_INT_0= RULE_INT
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

            kw=(Token)match(input,25,FollowSets000.FOLLOW_44); if (state.failed) return current;
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
    // InternalSEW.g:3516:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSEW.g:3516:47: (iv_ruleEString= ruleEString EOF )
            // InternalSEW.g:3517:2: iv_ruleEString= ruleEString EOF
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
    // InternalSEW.g:3523:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalSEW.g:3529:2: (this_STRING_0= RULE_STRING )
            // InternalSEW.g:3530:2: this_STRING_0= RULE_STRING
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
    // InternalSEW.g:3540:1: entryRuleDeprecatedReservedWord returns [String current=null] : iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF ;
    public final String entryRuleDeprecatedReservedWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeprecatedReservedWord = null;


        try {
            // InternalSEW.g:3540:62: (iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF )
            // InternalSEW.g:3541:2: iv_ruleDeprecatedReservedWord= ruleDeprecatedReservedWord EOF
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
    // InternalSEW.g:3547:1: ruleDeprecatedReservedWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' ) ;
    public final AntlrDatatypeRuleToken ruleDeprecatedReservedWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSEW.g:3553:2: ( (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' ) )
            // InternalSEW.g:3554:2: (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' )
            {
            // InternalSEW.g:3554:2: (kw= 'form' | kw= 'endform' | kw= 'prototype' | kw= 'endprototype' | kw= 'section' | kw= 'endsection' )
            int alt71=6;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt71=1;
                }
                break;
            case 70:
                {
                alt71=2;
                }
                break;
            case 71:
                {
                alt71=3;
                }
                break;
            case 72:
                {
                alt71=4;
                }
                break;
            case 73:
                {
                alt71=5;
                }
                break;
            case 74:
                {
                alt71=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalSEW.g:3555:3: kw= 'form'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getFormKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSEW.g:3561:3: kw= 'endform'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndformKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSEW.g:3567:3: kw= 'prototype'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getPrototypeKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSEW.g:3573:3: kw= 'endprototype'
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getEndprototypeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSEW.g:3579:3: kw= 'section'
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDeprecatedReservedWordAccess().getSectionKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSEW.g:3585:3: kw= 'endsection'
                    {
                    kw=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3594:1: entryRuleDeprecatedObject returns [EObject current=null] : iv_ruleDeprecatedObject= ruleDeprecatedObject EOF ;
    public final EObject entryRuleDeprecatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedObject = null;


        try {
            // InternalSEW.g:3594:57: (iv_ruleDeprecatedObject= ruleDeprecatedObject EOF )
            // InternalSEW.g:3595:2: iv_ruleDeprecatedObject= ruleDeprecatedObject EOF
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
    // InternalSEW.g:3601:1: ruleDeprecatedObject returns [EObject current=null] : ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) ) ;
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
            // InternalSEW.g:3607:2: ( ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) ) )
            // InternalSEW.g:3608:2: ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) )
            {
            // InternalSEW.g:3608:2: ( ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' ) | ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==69) ) {
                alt78=1;
            }
            else if ( (LA78_0==71) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalSEW.g:3609:3: ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' )
                    {
                    // InternalSEW.g:3609:3: ( () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform' )
                    // InternalSEW.g:3610:4: () otherlv_1= 'form' ( (lv_name_2_0= ruleUFI ) ) ( (lv_description_3_0= ruleEString ) )? otherlv_4= 'as' (otherlv_5= '&' )? ( (lv_type_6_0= ruleUFI ) ) otherlv_7= 'is' ( (lv_element_8_0= ruleDeprecatedProperty ) )* otherlv_9= 'endform'
                    {
                    // InternalSEW.g:3610:4: ()
                    // InternalSEW.g:3611:5: 
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

                    otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeprecatedObjectAccess().getFormKeyword_0_1());
                      			
                    }
                    // InternalSEW.g:3624:4: ( (lv_name_2_0= ruleUFI ) )
                    // InternalSEW.g:3625:5: (lv_name_2_0= ruleUFI )
                    {
                    // InternalSEW.g:3625:5: (lv_name_2_0= ruleUFI )
                    // InternalSEW.g:3626:6: lv_name_2_0= ruleUFI
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

                    // InternalSEW.g:3643:4: ( (lv_description_3_0= ruleEString ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==RULE_STRING) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalSEW.g:3644:5: (lv_description_3_0= ruleEString )
                            {
                            // InternalSEW.g:3644:5: (lv_description_3_0= ruleEString )
                            // InternalSEW.g:3645:6: lv_description_3_0= ruleEString
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

                    otherlv_4=(Token)match(input,75,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_0_4());
                      			
                    }
                    // InternalSEW.g:3666:4: (otherlv_5= '&' )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==56) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalSEW.g:3667:5: otherlv_5= '&'
                            {
                            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_0_5());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:3672:4: ( (lv_type_6_0= ruleUFI ) )
                    // InternalSEW.g:3673:5: (lv_type_6_0= ruleUFI )
                    {
                    // InternalSEW.g:3673:5: (lv_type_6_0= ruleUFI )
                    // InternalSEW.g:3674:6: lv_type_6_0= ruleUFI
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

                    otherlv_7=(Token)match(input,76,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_0_7());
                      			
                    }
                    // InternalSEW.g:3695:4: ( (lv_element_8_0= ruleDeprecatedProperty ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==70) ) {
                            int LA74_1 = input.LA(2);

                            if ( (LA74_1==RULE_STRING||LA74_1==28||(LA74_1>=30 && LA74_1<=31)) ) {
                                alt74=1;
                            }


                        }
                        else if ( (LA74_0==RULE_XIDENDIFIER||LA74_0==RULE_AT_IDENTIFIER||LA74_0==14||LA74_0==21||LA74_0==69||(LA74_0>=71 && LA74_0<=74)) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalSEW.g:3696:5: (lv_element_8_0= ruleDeprecatedProperty )
                    	    {
                    	    // InternalSEW.g:3696:5: (lv_element_8_0= ruleDeprecatedProperty )
                    	    // InternalSEW.g:3697:6: lv_element_8_0= ruleDeprecatedProperty
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
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getDeprecatedObjectAccess().getEndformKeyword_0_9());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSEW.g:3720:3: ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' )
                    {
                    // InternalSEW.g:3720:3: ( () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype' )
                    // InternalSEW.g:3721:4: () otherlv_11= 'prototype' ( (lv_name_12_0= ruleUFI ) ) ( (lv_description_13_0= ruleEString ) )? otherlv_14= 'as' (otherlv_15= '&' )? ( (lv_type_16_0= ruleUFI ) ) otherlv_17= 'is' ( (lv_element_18_0= ruleDeprecatedProperty ) )* otherlv_19= 'endprototype'
                    {
                    // InternalSEW.g:3721:4: ()
                    // InternalSEW.g:3722:5: 
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

                    otherlv_11=(Token)match(input,71,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getDeprecatedObjectAccess().getPrototypeKeyword_1_1());
                      			
                    }
                    // InternalSEW.g:3735:4: ( (lv_name_12_0= ruleUFI ) )
                    // InternalSEW.g:3736:5: (lv_name_12_0= ruleUFI )
                    {
                    // InternalSEW.g:3736:5: (lv_name_12_0= ruleUFI )
                    // InternalSEW.g:3737:6: lv_name_12_0= ruleUFI
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

                    // InternalSEW.g:3754:4: ( (lv_description_13_0= ruleEString ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_STRING) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalSEW.g:3755:5: (lv_description_13_0= ruleEString )
                            {
                            // InternalSEW.g:3755:5: (lv_description_13_0= ruleEString )
                            // InternalSEW.g:3756:6: lv_description_13_0= ruleEString
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

                    otherlv_14=(Token)match(input,75,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getDeprecatedObjectAccess().getAsKeyword_1_4());
                      			
                    }
                    // InternalSEW.g:3777:4: (otherlv_15= '&' )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==56) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalSEW.g:3778:5: otherlv_15= '&'
                            {
                            otherlv_15=(Token)match(input,56,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_15, grammarAccess.getDeprecatedObjectAccess().getAmpersandKeyword_1_5());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSEW.g:3783:4: ( (lv_type_16_0= ruleUFI ) )
                    // InternalSEW.g:3784:5: (lv_type_16_0= ruleUFI )
                    {
                    // InternalSEW.g:3784:5: (lv_type_16_0= ruleUFI )
                    // InternalSEW.g:3785:6: lv_type_16_0= ruleUFI
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

                    otherlv_17=(Token)match(input,76,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getDeprecatedObjectAccess().getIsKeyword_1_7());
                      			
                    }
                    // InternalSEW.g:3806:4: ( (lv_element_18_0= ruleDeprecatedProperty ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==72) ) {
                            int LA77_1 = input.LA(2);

                            if ( (LA77_1==RULE_STRING||LA77_1==28||(LA77_1>=30 && LA77_1<=31)) ) {
                                alt77=1;
                            }


                        }
                        else if ( (LA77_0==RULE_XIDENDIFIER||LA77_0==RULE_AT_IDENTIFIER||LA77_0==14||LA77_0==21||(LA77_0>=69 && LA77_0<=71)||(LA77_0>=73 && LA77_0<=74)) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalSEW.g:3807:5: (lv_element_18_0= ruleDeprecatedProperty )
                    	    {
                    	    // InternalSEW.g:3807:5: (lv_element_18_0= ruleDeprecatedProperty )
                    	    // InternalSEW.g:3808:6: lv_element_18_0= ruleDeprecatedProperty
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
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:3834:1: entryRuleDeprecatedProperty returns [EObject current=null] : iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF ;
    public final EObject entryRuleDeprecatedProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedProperty = null;


        try {
            // InternalSEW.g:3834:59: (iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF )
            // InternalSEW.g:3835:2: iv_ruleDeprecatedProperty= ruleDeprecatedProperty EOF
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
    // InternalSEW.g:3841:1: ruleDeprecatedProperty returns [EObject current=null] : (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute ) ;
    public final EObject ruleDeprecatedProperty() throws RecognitionException {
        EObject current = null;

        EObject this_DeprecatedSection_0 = null;

        EObject this_DeprecatedAttribute_1 = null;



        	enterRule();

        try {
            // InternalSEW.g:3847:2: ( (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute ) )
            // InternalSEW.g:3848:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )
            {
            // InternalSEW.g:3848:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )
            int alt79=2;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // InternalSEW.g:3849:3: this_DeprecatedSection_0= ruleDeprecatedSection
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
                    // InternalSEW.g:3861:3: this_DeprecatedAttribute_1= ruleDeprecatedAttribute
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
    // InternalSEW.g:3876:1: entryRuleDeprecatedSection returns [EObject current=null] : iv_ruleDeprecatedSection= ruleDeprecatedSection EOF ;
    public final EObject entryRuleDeprecatedSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedSection = null;


        try {
            // InternalSEW.g:3876:58: (iv_ruleDeprecatedSection= ruleDeprecatedSection EOF )
            // InternalSEW.g:3877:2: iv_ruleDeprecatedSection= ruleDeprecatedSection EOF
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
    // InternalSEW.g:3883:1: ruleDeprecatedSection returns [EObject current=null] : ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) ) ;
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
            // InternalSEW.g:3889:2: ( ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) ) )
            // InternalSEW.g:3890:2: ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) )
            {
            // InternalSEW.g:3890:2: ( ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? ) | ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==73) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==RULE_STRING||LA89_1==28||LA89_1==30) ) {
                    alt89=2;
                }
                else if ( (LA89_1==RULE_XIDENDIFIER||LA89_1==14||LA89_1==21||(LA89_1>=69 && LA89_1<=74)) ) {
                    alt89=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA89_0==RULE_XIDENDIFIER||LA89_0==14||LA89_0==21||(LA89_0>=69 && LA89_0<=72)||LA89_0==74) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalSEW.g:3891:3: ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? )
                    {
                    // InternalSEW.g:3891:3: ( () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )? )
                    // InternalSEW.g:3892:4: () otherlv_1= 'section' ( (lv_name_2_0= ruleXID ) ) ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )* otherlv_4= 'endsection' ( ruleXID )?
                    {
                    // InternalSEW.g:3892:4: ()
                    // InternalSEW.g:3893:5: 
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

                    otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeprecatedSectionAccess().getSectionKeyword_0_1());
                      			
                    }
                    // InternalSEW.g:3906:4: ( (lv_name_2_0= ruleXID ) )
                    // InternalSEW.g:3907:5: (lv_name_2_0= ruleXID )
                    {
                    // InternalSEW.g:3907:5: (lv_name_2_0= ruleXID )
                    // InternalSEW.g:3908:6: lv_name_2_0= ruleXID
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

                    // InternalSEW.g:3925:4: ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        alt81 = dfa81.predict(input);
                        switch (alt81) {
                    	case 1 :
                    	    // InternalSEW.g:3926:5: ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) )
                    	    {
                    	    // InternalSEW.g:3926:5: ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) )
                    	    // InternalSEW.g:3927:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )
                    	    {
                    	    // InternalSEW.g:3927:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )
                    	    int alt80=3;
                    	    alt80 = dfa80.predict(input);
                    	    switch (alt80) {
                    	        case 1 :
                    	            // InternalSEW.g:3928:7: lv_element_3_1= ruleDeprecatedAttribute
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
                    	            // InternalSEW.g:3944:7: lv_element_3_2= ruleDeprecatedObject
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
                    	            // InternalSEW.g:3960:7: lv_element_3_3= ruleObject
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
                    	    break loop81;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,74,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDeprecatedSectionAccess().getEndsectionKeyword_0_4());
                      			
                    }
                    // InternalSEW.g:3982:4: ( ruleXID )?
                    int alt82=2;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // InternalSEW.g:3983:5: ruleXID
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
                    // InternalSEW.g:3996:3: ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) )
                    {
                    // InternalSEW.g:3996:3: ( ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) ) )
                    // InternalSEW.g:3997:4: ( (lv_name_6_0= ruleXID ) ) ( (lv_description_7_0= ruleEString ) )? ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) )
                    {
                    // InternalSEW.g:3997:4: ( (lv_name_6_0= ruleXID ) )
                    // InternalSEW.g:3998:5: (lv_name_6_0= ruleXID )
                    {
                    // InternalSEW.g:3998:5: (lv_name_6_0= ruleXID )
                    // InternalSEW.g:3999:6: lv_name_6_0= ruleXID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getNameXIDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_17);
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

                    // InternalSEW.g:4016:4: ( (lv_description_7_0= ruleEString ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RULE_STRING) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalSEW.g:4017:5: (lv_description_7_0= ruleEString )
                            {
                            // InternalSEW.g:4017:5: (lv_description_7_0= ruleEString )
                            // InternalSEW.g:4018:6: lv_description_7_0= ruleEString
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDeprecatedSectionAccess().getDescriptionEStringParserRuleCall_1_1_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_18);
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

                    // InternalSEW.g:4035:4: ( (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' ) | (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* ) )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==28) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==30) ) {
                        alt88=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalSEW.g:4036:5: (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' )
                            {
                            // InternalSEW.g:4036:5: (otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']' )
                            // InternalSEW.g:4037:6: otherlv_8= '[' ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )* otherlv_10= ']'
                            {
                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_53); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_8, grammarAccess.getDeprecatedSectionAccess().getLeftSquareBracketKeyword_1_2_0_0());
                              					
                            }
                            // InternalSEW.g:4041:6: ( ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) ) )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( (LA85_0==RULE_XIDENDIFIER||LA85_0==RULE_AT_IDENTIFIER||LA85_0==14||LA85_0==21||(LA85_0>=69 && LA85_0<=74)) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // InternalSEW.g:4042:7: ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) )
                            	    {
                            	    // InternalSEW.g:4042:7: ( (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject ) )
                            	    // InternalSEW.g:4043:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )
                            	    {
                            	    // InternalSEW.g:4043:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )
                            	    int alt84=3;
                            	    alt84 = dfa84.predict(input);
                            	    switch (alt84) {
                            	        case 1 :
                            	            // InternalSEW.g:4044:9: lv_element_9_1= ruleDeprecatedAttribute
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
                            	            // InternalSEW.g:4060:9: lv_element_9_2= ruleDeprecatedObject
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
                            	            // InternalSEW.g:4076:9: lv_element_9_3= ruleObject
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
                            	    break loop85;
                                }
                            } while (true);

                            otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getDeprecatedSectionAccess().getRightSquareBracketKeyword_1_2_0_2());
                              					
                            }

                            }


                            }
                            break;
                        case 2 :
                            // InternalSEW.g:4100:5: (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* )
                            {
                            // InternalSEW.g:4100:5: (otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )* )
                            // InternalSEW.g:4101:6: otherlv_11= ':' ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*
                            {
                            otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_54); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_11, grammarAccess.getDeprecatedSectionAccess().getColonKeyword_1_2_1_0());
                              					
                            }
                            // InternalSEW.g:4105:6: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                alt87 = dfa87.predict(input);
                                switch (alt87) {
                            	case 1 :
                            	    // InternalSEW.g:4106:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
                            	    {
                            	    // InternalSEW.g:4106:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
                            	    // InternalSEW.g:4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
                            	    {
                            	    // InternalSEW.g:4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
                            	    int alt86=3;
                            	    alt86 = dfa86.predict(input);
                            	    switch (alt86) {
                            	        case 1 :
                            	            // InternalSEW.g:4108:9: lv_element_12_1= ruleDeprecatedAttribute
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
                            	            // InternalSEW.g:4124:9: lv_element_12_2= ruleDeprecatedObject
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
                            	            // InternalSEW.g:4140:9: lv_element_12_3= ruleObject
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
                            	    break loop87;
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
    // InternalSEW.g:4165:1: entryRuleDeprecatedAttribute returns [EObject current=null] : iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF ;
    public final EObject entryRuleDeprecatedAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedAttribute = null;


        try {
            // InternalSEW.g:4165:60: (iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF )
            // InternalSEW.g:4166:2: iv_ruleDeprecatedAttribute= ruleDeprecatedAttribute EOF
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
    // InternalSEW.g:4172:1: ruleDeprecatedAttribute returns [EObject current=null] : ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleDeprecatedAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4178:2: ( ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? ) )
            // InternalSEW.g:4179:2: ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            {
            // InternalSEW.g:4179:2: ( () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )? )
            // InternalSEW.g:4180:3: () ( (lv_name_1_0= ruleDeprecatedAttributeID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueSpecification ) ) (otherlv_4= ';' )?
            {
            // InternalSEW.g:4180:3: ()
            // InternalSEW.g:4181:4: 
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

            // InternalSEW.g:4190:3: ( (lv_name_1_0= ruleDeprecatedAttributeID ) )
            // InternalSEW.g:4191:4: (lv_name_1_0= ruleDeprecatedAttributeID )
            {
            // InternalSEW.g:4191:4: (lv_name_1_0= ruleDeprecatedAttributeID )
            // InternalSEW.g:4192:5: lv_name_1_0= ruleDeprecatedAttributeID
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

            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeprecatedAttributeAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalSEW.g:4213:3: ( (lv_value_3_0= ruleValueSpecification ) )
            // InternalSEW.g:4214:4: (lv_value_3_0= ruleValueSpecification )
            {
            // InternalSEW.g:4214:4: (lv_value_3_0= ruleValueSpecification )
            // InternalSEW.g:4215:5: lv_value_3_0= ruleValueSpecification
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

            // InternalSEW.g:4232:3: (otherlv_4= ';' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==32) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalSEW.g:4233:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalSEW.g:4242:1: entryRuleDeprecatedAttributeID returns [String current=null] : iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF ;
    public final String entryRuleDeprecatedAttributeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeprecatedAttributeID = null;


        try {
            // InternalSEW.g:4242:61: (iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF )
            // InternalSEW.g:4243:2: iv_ruleDeprecatedAttributeID= ruleDeprecatedAttributeID EOF
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
    // InternalSEW.g:4249:1: ruleDeprecatedAttributeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER ) ;
    public final AntlrDatatypeRuleToken ruleDeprecatedAttributeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_AT_IDENTIFIER_1=null;
        AntlrDatatypeRuleToken this_XID_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4255:2: ( (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER ) )
            // InternalSEW.g:4256:2: (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER )
            {
            // InternalSEW.g:4256:2: (this_XID_0= ruleXID | this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_XIDENDIFIER||LA91_0==14||LA91_0==21||(LA91_0>=69 && LA91_0<=74)) ) {
                alt91=1;
            }
            else if ( (LA91_0==RULE_AT_IDENTIFIER) ) {
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
                    // InternalSEW.g:4257:3: this_XID_0= ruleXID
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
                    // InternalSEW.g:4268:3: this_AT_IDENTIFIER_1= RULE_AT_IDENTIFIER
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
    // InternalSEW.g:4279:1: entryRuleDeprecatedExpression returns [EObject current=null] : iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF ;
    public final EObject entryRuleDeprecatedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeprecatedExpression = null;


        try {
            // InternalSEW.g:4279:61: (iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF )
            // InternalSEW.g:4280:2: iv_ruleDeprecatedExpression= ruleDeprecatedExpression EOF
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
    // InternalSEW.g:4286:1: ruleDeprecatedExpression returns [EObject current=null] : ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' ) ;
    public final EObject ruleDeprecatedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token otherlv_4=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSEW.g:4292:2: ( ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' ) )
            // InternalSEW.g:4293:2: ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' )
            {
            // InternalSEW.g:4293:2: ( () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}' )
            // InternalSEW.g:4294:3: () otherlv_1= '${' ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) ) ( (lv_operand_3_0= ruleValueSpecification ) )* otherlv_4= '}'
            {
            // InternalSEW.g:4294:3: ()
            // InternalSEW.g:4295:4: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDeprecatedExpressionAccess().getDollarSignLeftCurlyBracketKeyword_1());
              		
            }
            // InternalSEW.g:4308:3: ( ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) ) )
            // InternalSEW.g:4309:4: ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) )
            {
            // InternalSEW.g:4309:4: ( (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' ) )
            // InternalSEW.g:4310:5: (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' )
            {
            // InternalSEW.g:4310:5: (lv_operator_2_1= '|;|' | lv_operator_2_2= '|i|' )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==78) ) {
                alt92=1;
            }
            else if ( (LA92_0==79) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalSEW.g:4311:6: lv_operator_2_1= '|;|'
                    {
                    lv_operator_2_1=(Token)match(input,78,FollowSets000.FOLLOW_56); if (state.failed) return current;
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
                    // InternalSEW.g:4322:6: lv_operator_2_2= '|i|'
                    {
                    lv_operator_2_2=(Token)match(input,79,FollowSets000.FOLLOW_56); if (state.failed) return current;
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

            // InternalSEW.g:4335:3: ( (lv_operand_3_0= ruleValueSpecification ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( ((LA93_0>=RULE_XIDENDIFIER && LA93_0<=RULE_STRING)||LA93_0==14||LA93_0==21||LA93_0==25||LA93_0==28||LA93_0==46||(LA93_0>=51 && LA93_0<=54)||(LA93_0>=56 && LA93_0<=74)||LA93_0==77) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalSEW.g:4336:4: (lv_operand_3_0= ruleValueSpecification )
            	    {
            	    // InternalSEW.g:4336:4: (lv_operand_3_0= ruleValueSpecification )
            	    // InternalSEW.g:4337:5: lv_operand_3_0= ruleValueSpecification
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
            	    break loop93;
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

    // $ANTLR start synpred34_InternalSEW
    public final void synpred34_InternalSEW_fragment() throws RecognitionException {   
        EObject lv_element_6_1 = null;

        EObject lv_element_6_2 = null;


        // InternalSEW.g:899:6: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )
        // InternalSEW.g:899:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
        {
        // InternalSEW.g:899:6: ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) )
        // InternalSEW.g:900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
        {
        // InternalSEW.g:900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )
        int alt111=2;
        alt111 = dfa111.predict(input);
        switch (alt111) {
            case 1 :
                // InternalSEW.g:901:8: lv_element_6_1= ruleObject
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_6_1=ruleObject();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSEW.g:917:8: lv_element_6_2= ruleAttribute
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
    // $ANTLR end synpred34_InternalSEW

    // $ANTLR start synpred55_InternalSEW
    public final void synpred55_InternalSEW_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_operand_5_0 = null;


        // InternalSEW.g:1728:5: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )
        // InternalSEW.g:1728:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        {
        otherlv_4=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return ;
        // InternalSEW.g:1732:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
        {
        // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
        // InternalSEW.g:1734:7: lv_operand_5_0= rulemultiplicativeExpression
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
    // $ANTLR end synpred55_InternalSEW

    // $ANTLR start synpred56_InternalSEW
    public final void synpred56_InternalSEW_fragment() throws RecognitionException {   
        Token lv_operator_2_0=null;
        Token otherlv_4=null;
        EObject lv_operand_3_0 = null;

        EObject lv_operand_5_0 = null;


        // InternalSEW.g:1684:4: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )
        // InternalSEW.g:1684:4: () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
        {
        // InternalSEW.g:1684:4: ()
        // InternalSEW.g:1685:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSEW.g:1694:4: ( (lv_operator_2_0= '+' ) )
        // InternalSEW.g:1695:5: (lv_operator_2_0= '+' )
        {
        // InternalSEW.g:1695:5: (lv_operator_2_0= '+' )
        // InternalSEW.g:1696:6: lv_operator_2_0= '+'
        {
        lv_operator_2_0=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return ;

        }


        }

        // InternalSEW.g:1708:4: ( (lv_operand_3_0= rulemultiplicativeExpression ) )
        // InternalSEW.g:1709:5: (lv_operand_3_0= rulemultiplicativeExpression )
        {
        // InternalSEW.g:1709:5: (lv_operand_3_0= rulemultiplicativeExpression )
        // InternalSEW.g:1710:6: lv_operand_3_0= rulemultiplicativeExpression
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

        // InternalSEW.g:1727:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*
        loop122:
        do {
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==46) ) {
                alt122=1;
            }


            switch (alt122) {
        	case 1 :
        	    // InternalSEW.g:1728:5: otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        	    {
        	    otherlv_4=(Token)match(input,46,FollowSets000.FOLLOW_27); if (state.failed) return ;
        	    // InternalSEW.g:1732:5: ( (lv_operand_5_0= rulemultiplicativeExpression ) )
        	    // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
        	    {
        	    // InternalSEW.g:1733:6: (lv_operand_5_0= rulemultiplicativeExpression )
        	    // InternalSEW.g:1734:7: lv_operand_5_0= rulemultiplicativeExpression
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
        	    break loop122;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred56_InternalSEW

    // $ANTLR start synpred66_InternalSEW
    public final void synpred66_InternalSEW_fragment() throws RecognitionException {   
        Token lv_operator_3_0=null;
        EObject lv_operand_4_0 = null;


        // InternalSEW.g:2105:3: ( ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) ) )
        // InternalSEW.g:2105:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
        {
        // InternalSEW.g:2105:3: ( () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) ) )
        // InternalSEW.g:2106:4: () ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
        {
        // InternalSEW.g:2106:4: ()
        // InternalSEW.g:2107:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSEW.g:2116:4: ( ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) ) )
        // InternalSEW.g:2117:5: ( (lv_operator_3_0= '-' ) ) ( (lv_operand_4_0= ruleprimaryExpression ) )
        {
        // InternalSEW.g:2117:5: ( (lv_operator_3_0= '-' ) )
        // InternalSEW.g:2118:6: (lv_operator_3_0= '-' )
        {
        // InternalSEW.g:2118:6: (lv_operator_3_0= '-' )
        // InternalSEW.g:2119:7: lv_operator_3_0= '-'
        {
        lv_operator_3_0=(Token)match(input,51,FollowSets000.FOLLOW_27); if (state.failed) return ;

        }


        }

        // InternalSEW.g:2131:5: ( (lv_operand_4_0= ruleprimaryExpression ) )
        // InternalSEW.g:2132:6: (lv_operand_4_0= ruleprimaryExpression )
        {
        // InternalSEW.g:2132:6: (lv_operand_4_0= ruleprimaryExpression )
        // InternalSEW.g:2133:7: lv_operand_4_0= ruleprimaryExpression
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
    // $ANTLR end synpred66_InternalSEW

    // $ANTLR start synpred72_InternalSEW
    public final void synpred72_InternalSEW_fragment() throws RecognitionException {   
        EObject this_LiteralIntegerValue_2 = null;


        // InternalSEW.g:2290:3: (this_LiteralIntegerValue_2= ruleLiteralIntegerValue )
        // InternalSEW.g:2290:3: this_LiteralIntegerValue_2= ruleLiteralIntegerValue
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
    // $ANTLR end synpred72_InternalSEW

    // $ANTLR start synpred74_InternalSEW
    public final void synpred74_InternalSEW_fragment() throws RecognitionException {   
        EObject this_LiteralFloatValue_4 = null;


        // InternalSEW.g:2314:3: (this_LiteralFloatValue_4= ruleLiteralFloatValue )
        // InternalSEW.g:2314:3: this_LiteralFloatValue_4= ruleLiteralFloatValue
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
    // $ANTLR end synpred74_InternalSEW

    // $ANTLR start synpred83_InternalSEW
    public final void synpred83_InternalSEW_fragment() throws RecognitionException {   
        // InternalSEW.g:2506:4: ( ( ( ruleUFI ) ) )
        // InternalSEW.g:2506:4: ( ( ruleUFI ) )
        {
        // InternalSEW.g:2506:4: ( ( ruleUFI ) )
        // InternalSEW.g:2507:5: ( ruleUFI )
        {
        // InternalSEW.g:2507:5: ( ruleUFI )
        // InternalSEW.g:2508:6: ruleUFI
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
    // $ANTLR end synpred83_InternalSEW

    // $ANTLR start synpred113_InternalSEW
    public final void synpred113_InternalSEW_fragment() throws RecognitionException {   
        // InternalSEW.g:3983:5: ( ruleXID )
        // InternalSEW.g:3983:5: ruleXID
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
    // $ANTLR end synpred113_InternalSEW

    // $ANTLR start synpred122_InternalSEW
    public final void synpred122_InternalSEW_fragment() throws RecognitionException {   
        EObject lv_element_12_1 = null;

        EObject lv_element_12_2 = null;

        EObject lv_element_12_3 = null;


        // InternalSEW.g:4106:7: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )
        // InternalSEW.g:4106:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
        {
        // InternalSEW.g:4106:7: ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) )
        // InternalSEW.g:4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
        {
        // InternalSEW.g:4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )
        int alt139=3;
        alt139 = dfa139.predict(input);
        switch (alt139) {
            case 1 :
                // InternalSEW.g:4108:9: lv_element_12_1= ruleDeprecatedAttribute
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_12_1=ruleDeprecatedAttribute();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSEW.g:4124:9: lv_element_12_2= ruleDeprecatedObject
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_element_12_2=ruleDeprecatedObject();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalSEW.g:4140:9: lv_element_12_3= ruleObject
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
    // $ANTLR end synpred122_InternalSEW

    // Delegated rules

    public final boolean synpred122_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_InternalSEW() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalSEW_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA139 dfa139 = new DFA139(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\12\4\1\uffff\1\20\1\uffff";
    static final String dfa_3s = "\12\112\1\uffff\1\36\1\uffff";
    static final String dfa_4s = "\12\uffff\1\1\1\uffff\1\2";
    static final String dfa_5s = "\15\uffff}>";
    static final String[] dfa_6s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "\1\12\2\uffff\1\13\6\uffff\1\12\1\uffff\1\12\4\uffff\1\12\2\uffff\4\12\1\14\1\uffff\2\14\45\uffff\6\12",
            "",
            "\1\12\13\uffff\1\14\1\uffff\1\14",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "189:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleProperty )";
        }
    }
    static final String dfa_7s = "\27\uffff";
    static final String dfa_8s = "\14\4\2\uffff\11\4";
    static final String dfa_9s = "\14\112\2\uffff\11\112";
    static final String dfa_10s = "\14\uffff\1\2\1\1\11\uffff";
    static final String dfa_11s = "\27\uffff}>";
    static final String[] dfa_12s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\26\11\uffff\1\16\6\uffff\1\17\57\uffff\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\26\11\uffff\1\16\6\uffff\1\17\57\uffff\1\20\1\21\1\22\1\23\1\24\1\25",
            "",
            "",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15",
            "\1\15\2\uffff\1\15\6\uffff\1\15\1\uffff\1\15\4\uffff\1\15\2\uffff\1\12\1\13\2\14\51\uffff\6\15"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "502:2: ( ( () ( (lv_type_1_0= ruleUFI ) ) ( (lv_name_2_0= ruleUFI ) )? ( (lv_description_3_0= ruleEString ) )? otherlv_4= '{' ( ( (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty ) ) )* otherlv_6= '}' ) | ( () ( (lv_name_8_0= ruleUFI ) ) (otherlv_9= ':=' | otherlv_10= '+:=' ) ( ( (lv_type_11_0= ruleUFI ) ) ( (lv_description_12_0= ruleEString ) )? )? otherlv_13= '{' ( ( (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty ) ) )* otherlv_15= '}' ) )";
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "577:6: (lv_element_5_1= ruleObject | lv_element_5_2= ruleProperty )";
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "705:6: (lv_element_14_1= ruleObject | lv_element_14_2= ruleProperty )";
        }
    }
    static final String dfa_13s = "\14\uffff";
    static final String dfa_14s = "\1\4\11\7\2\uffff";
    static final String dfa_15s = "\1\112\11\37\2\uffff";
    static final String dfa_16s = "\12\uffff\1\2\1\1";
    static final String dfa_17s = "\14\uffff}>";
    static final String[] dfa_18s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "763:2: (this_Section_0= ruleSection | this_Attribute_1= ruleAttribute )";
        }
    }
    static final String dfa_19s = "\12\4\2\uffff";
    static final String dfa_20s = "\12\112\2\uffff";
    static final String[] dfa_21s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "",
            ""
    };
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "852:7: (lv_element_3_1= ruleObject | lv_element_3_2= ruleAttribute )";
        }
    }
    static final String dfa_22s = "\1\1\14\uffff";
    static final String dfa_23s = "\1\4\1\uffff\11\0\2\uffff";
    static final String dfa_24s = "\1\112\1\uffff\11\0\2\uffff";
    static final String dfa_25s = "\1\uffff\1\2\12\uffff\1\1";
    static final String dfa_26s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] dfa_27s = {
            "\1\12\11\uffff\1\2\2\uffff\1\1\3\uffff\1\3\57\uffff\1\4\1\5\1\6\1\7\1\10\1\11",
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
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "()* loopback of 898:5: ( ( (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_3 = input.LA(1);

                         
                        int index31_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_4 = input.LA(1);

                         
                        int index31_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_5 = input.LA(1);

                         
                        int index31_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_6 = input.LA(1);

                         
                        int index31_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA31_8 = input.LA(1);

                         
                        int index31_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA31_9 = input.LA(1);

                         
                        int index31_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA31_10 = input.LA(1);

                         
                        int index31_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index31_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )";
        }
    }
    static final String dfa_28s = "\71\uffff";
    static final String dfa_29s = "\1\2\70\uffff";
    static final String dfa_30s = "\1\4\1\0\67\uffff";
    static final String dfa_31s = "\1\115\1\0\67\uffff";
    static final String dfa_32s = "\2\uffff\1\2\65\uffff\1\1";
    static final String dfa_33s = "\1\uffff\1\0\67\uffff}>";
    static final String[] dfa_34s = {
            "\5\2\5\uffff\1\2\2\uffff\1\2\2\uffff\3\2\2\uffff\1\2\2\uffff\3\2\1\uffff\16\2\1\1\4\uffff\30\2\2\uffff\1\2",
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

    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_28;
            this.eof = dfa_29;
            this.min = dfa_30;
            this.max = dfa_31;
            this.accept = dfa_32;
            this.special = dfa_33;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "1683:3: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_operand_3_0= rulemultiplicativeExpression ) ) (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_1 = input.LA(1);

                         
                        int index49_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalSEW()) ) {s = 56;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index49_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_35s = "\1\1\70\uffff";
    static final String dfa_36s = "\1\4\35\uffff\1\0\32\uffff";
    static final String dfa_37s = "\1\115\35\uffff\1\0\32\uffff";
    static final String dfa_38s = "\1\uffff\1\2\66\uffff\1\1";
    static final String dfa_39s = "\36\uffff\1\0\32\uffff}>";
    static final String[] dfa_40s = {
            "\5\1\5\uffff\1\1\2\uffff\1\1\2\uffff\3\1\2\uffff\1\1\2\uffff\3\1\1\uffff\16\1\1\36\4\uffff\30\1\2\uffff\1\1",
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
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_28;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "()* loopback of 1727:4: (otherlv_4= '+' ( (lv_operand_5_0= rulemultiplicativeExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_30 = input.LA(1);

                         
                        int index48_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_InternalSEW()) ) {s = 56;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_30);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_41s = "\16\uffff";
    static final String dfa_42s = "\1\4\2\uffff\1\6\1\61\11\uffff";
    static final String dfa_43s = "\1\112\2\uffff\1\31\1\61\11\uffff";
    static final String dfa_44s = "\1\uffff\1\1\1\2\2\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\4\1\3";
    static final String dfa_45s = "\4\uffff\1\0\11\uffff}>";
    static final String[] dfa_46s = {
            "\1\11\1\2\1\4\1\6\6\uffff\1\11\6\uffff\1\11\3\uffff\1\5\2\uffff\1\10\26\uffff\1\3\4\uffff\1\11\1\7\2\12\7\13\2\1\6\11",
            "",
            "",
            "\1\4\22\uffff\1\5",
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

    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_41;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "2265:2: (this_LiteralBooleanValue_0= ruleLiteralBooleanValue | this_LiteralCharacterValue_1= ruleLiteralCharacterValue | this_LiteralIntegerValue_2= ruleLiteralIntegerValue | this_LiteralRationalValue_3= ruleLiteralRationalValue | this_LiteralFloatValue_4= ruleLiteralFloatValue | this_LiteralStringValue_5= ruleLiteralStringValue | this_LiteralNullValue_6= ruleLiteralNullValue | this_LiteralArrayValue_7= ruleLiteralArrayValue | this_LiteralObjectReference_8= ruleLiteralObjectReference | this_LiteralVariableReference_9= ruleLiteralVariableReference | this_LiteralInstanceReference_10= ruleLiteralInstanceReference )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_4 = input.LA(1);

                         
                        int index57_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA57_4==49) ) {s = 12;}

                        else if ( (synpred72_InternalSEW()) ) {s = 13;}

                        else if ( (synpred74_InternalSEW()) ) {s = 5;}

                         
                        input.seek(index57_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_47s = "\1\4\11\0\2\uffff";
    static final String dfa_48s = "\1\112\11\0\2\uffff";
    static final String dfa_49s = "\12\uffff\1\1\1\2";
    static final String dfa_50s = "\1\uffff\1\1\1\6\1\2\1\7\1\3\1\10\1\4\1\5\1\0\2\uffff}>";
    static final String[] dfa_51s = {
            "\1\11\11\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
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
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "2505:3: ( ( ( ruleUFI ) ) | ( (lv_symbol_2_0= ruleUFI ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_9 = input.LA(1);

                         
                        int index61_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_8 = input.LA(1);

                         
                        int index61_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalSEW()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\1\2\2\uffff\11\2\1\uffff";
    static final String dfa_53s = "\2\4\1\uffff\11\4\1\uffff";
    static final String dfa_54s = "\1\115\1\112\1\uffff\11\115\1\uffff";
    static final String dfa_55s = "\2\uffff\1\2\11\uffff\1\1";
    static final String[] dfa_56s = {
            "\5\2\5\uffff\1\2\2\uffff\1\2\2\uffff\1\1\2\2\2\uffff\1\2\2\uffff\3\2\1\uffff\53\2\2\uffff\1\2",
            "\1\13\3\2\6\uffff\1\3\6\uffff\1\4\3\uffff\1\2\2\uffff\1\2\21\uffff\1\2\4\uffff\4\2\1\uffff\15\2\1\5\1\6\1\7\1\10\1\11\1\12",
            "",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            "\5\2\5\uffff\1\2\2\uffff\1\2\3\uffff\2\2\1\uffff\2\2\2\uffff\3\2\1\uffff\13\2\1\uffff\1\14\1\uffff\35\2\2\uffff\1\2",
            ""
    };
    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_1;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_5;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "2820:3: (otherlv_2= '<' ( (lv_type_3_0= ruleXID ) ) otherlv_4= '>' )?";
        }
    }
    static final String dfa_57s = "\2\4\10\7\2\uffff";
    static final String dfa_58s = "\2\112\10\37\2\uffff";
    static final String[] dfa_59s = {
            "\1\11\3\uffff\1\12\5\uffff\1\2\6\uffff\1\3\57\uffff\1\4\1\5\1\6\1\7\1\1\1\10",
            "\1\13\2\uffff\1\13\6\uffff\1\13\6\uffff\1\13\6\uffff\1\13\1\uffff\1\13\1\12\45\uffff\6\13",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "\1\13\24\uffff\1\13\1\uffff\1\13\1\12",
            "",
            ""
    };
    static final char[] dfa_57 = DFA.unpackEncodedStringToUnsignedChars(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final short[][] dfa_59 = unpackEncodedStringArray(dfa_59s);

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_57;
            this.max = dfa_58;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_59;
        }
        public String getDescription() {
            return "3848:2: (this_DeprecatedSection_0= ruleDeprecatedSection | this_DeprecatedAttribute_1= ruleDeprecatedAttribute )";
        }
    }
    static final String dfa_60s = "\1\uffff\1\14\1\uffff\11\14\2\uffff";
    static final String dfa_61s = "\2\4\1\uffff\11\4\1\uffff\1\20";
    static final String dfa_62s = "\2\112\1\uffff\11\112\1\uffff\1\36";
    static final String dfa_63s = "\2\uffff\1\1\11\uffff\1\2\1\uffff";
    static final String dfa_64s = "\16\uffff}>";
    static final String[] dfa_65s = {
            "\1\2\3\uffff\1\2\5\uffff\1\2\6\uffff\1\2\57\uffff\5\2\1\1",
            "\1\13\2\uffff\1\2\1\14\5\uffff\1\3\1\uffff\1\2\4\uffff\1\4\2\uffff\4\2\3\uffff\1\2\45\uffff\1\5\1\6\1\7\1\10\1\11\1\12",
            "",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\4\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\4\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "\1\14\2\uffff\1\15\1\14\5\uffff\1\14\1\uffff\1\2\4\uffff\1\14\2\uffff\2\2\2\uffff\1\14\1\uffff\2\14\45\uffff\6\14",
            "",
            "\1\2\13\uffff\1\14\1\uffff\1\14"
    };
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final char[] dfa_62 = DFA.unpackEncodedStringToUnsignedChars(dfa_62s);
    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final short[] dfa_64 = DFA.unpackEncodedString(dfa_64s);
    static final short[][] dfa_65 = unpackEncodedStringArray(dfa_65s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_41;
            this.eof = dfa_60;
            this.min = dfa_61;
            this.max = dfa_62;
            this.accept = dfa_63;
            this.special = dfa_64;
            this.transition = dfa_65;
        }
        public String getDescription() {
            return "()* loopback of 3925:4: ( ( (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject ) ) )*";
        }
    }
    static final String dfa_66s = "\67\uffff";
    static final String dfa_67s = "\12\4\2\uffff\22\7\2\4\1\20\1\uffff\2\4\1\20\22\7";
    static final String dfa_68s = "\12\112\2\uffff\22\113\2\112\1\113\1\uffff\2\112\23\113";
    static final String dfa_69s = "\12\uffff\1\1\1\3\25\uffff\1\2\25\uffff";
    static final String dfa_70s = "\67\uffff}>";
    static final String[] dfa_71s = {
            "\1\11\3\uffff\1\12\5\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\24\2\uffff\1\13\6\uffff\1\14\1\uffff\1\13\4\uffff\1\15\2\uffff\4\13\3\uffff\1\12\45\uffff\1\16\1\17\1\20\1\21\1\22\1\23",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\35\2\uffff\1\13\6\uffff\1\25\1\uffff\1\13\4\uffff\1\26\2\uffff\4\13\3\uffff\1\12\45\uffff\1\27\1\30\1\31\1\32\1\33\1\34",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "\1\13\2\uffff\1\13\6\uffff\1\13\1\uffff\1\13\4\uffff\1\13\2\uffff\4\13\3\uffff\1\12\45\uffff\6\13",
            "",
            "",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\55\11\uffff\1\45\6\uffff\1\46\57\uffff\1\47\1\50\1\51\1\52\1\53\1\54",
            "\1\55\11\uffff\1\45\6\uffff\1\46\57\uffff\1\47\1\50\1\51\1\52\1\53\1\54",
            "\1\13\72\uffff\1\41",
            "",
            "\1\66\11\uffff\1\56\6\uffff\1\57\57\uffff\1\60\1\61\1\62\1\63\1\64\1\65",
            "\1\66\11\uffff\1\56\6\uffff\1\57\57\uffff\1\60\1\61\1\62\1\63\1\64\1\65",
            "\1\13\72\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\40\10\uffff\1\13\7\uffff\1\36\1\37\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41",
            "\1\44\10\uffff\1\13\7\uffff\1\42\1\43\61\uffff\1\41"
    };

    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "3927:6: (lv_element_3_1= ruleDeprecatedAttribute | lv_element_3_2= ruleDeprecatedObject | lv_element_3_3= ruleObject )";
        }
    }
    static final String dfa_72s = "\1\12\14\uffff";
    static final String dfa_73s = "\1\4\11\0\3\uffff";
    static final String dfa_74s = "\1\112\11\0\3\uffff";
    static final String dfa_75s = "\12\uffff\1\2\1\uffff\1\1";
    static final String dfa_76s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff}>";
    static final String[] dfa_77s = {
            "\1\11\3\uffff\1\12\5\uffff\1\1\6\uffff\1\2\57\uffff\1\3\1\4\1\5\1\6\1\7\1\10",
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
    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final char[] dfa_73 = DFA.unpackEncodedStringToUnsignedChars(dfa_73s);
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final short[] dfa_75 = DFA.unpackEncodedString(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[][] dfa_77 = unpackEncodedStringArray(dfa_77s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_1;
            this.eof = dfa_72;
            this.min = dfa_73;
            this.max = dfa_74;
            this.accept = dfa_75;
            this.special = dfa_76;
            this.transition = dfa_77;
        }
        public String getDescription() {
            return "3982:4: ( ruleXID )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA82_2 = input.LA(1);

                         
                        int index82_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA82_3 = input.LA(1);

                         
                        int index82_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA82_4 = input.LA(1);

                         
                        int index82_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA82_5 = input.LA(1);

                         
                        int index82_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA82_6 = input.LA(1);

                         
                        int index82_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA82_7 = input.LA(1);

                         
                        int index82_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA82_8 = input.LA(1);

                         
                        int index82_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA82_9 = input.LA(1);

                         
                        int index82_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index82_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "4043:8: (lv_element_9_1= ruleDeprecatedAttribute | lv_element_9_2= ruleDeprecatedObject | lv_element_9_3= ruleObject )";
        }
    }
    static final String dfa_78s = "\1\13\14\uffff";
    static final String dfa_79s = "\1\4\12\0\2\uffff";
    static final String dfa_80s = "\1\112\12\0\2\uffff";
    static final String dfa_81s = "\13\uffff\1\2\1\1";
    static final String dfa_82s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff}>";
    static final String[] dfa_83s = {
            "\1\11\3\uffff\1\12\5\uffff\1\3\6\uffff\1\4\57\uffff\1\5\1\1\1\6\1\7\1\2\1\10",
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
    static final short[] dfa_78 = DFA.unpackEncodedString(dfa_78s);
    static final char[] dfa_79 = DFA.unpackEncodedStringToUnsignedChars(dfa_79s);
    static final char[] dfa_80 = DFA.unpackEncodedStringToUnsignedChars(dfa_80s);
    static final short[] dfa_81 = DFA.unpackEncodedString(dfa_81s);
    static final short[] dfa_82 = DFA.unpackEncodedString(dfa_82s);
    static final short[][] dfa_83 = unpackEncodedStringArray(dfa_83s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_1;
            this.eof = dfa_78;
            this.min = dfa_79;
            this.max = dfa_80;
            this.accept = dfa_81;
            this.special = dfa_82;
            this.transition = dfa_83;
        }
        public String getDescription() {
            return "()* loopback of 4105:6: ( ( (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_2 = input.LA(1);

                         
                        int index87_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA87_3 = input.LA(1);

                         
                        int index87_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA87_4 = input.LA(1);

                         
                        int index87_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA87_5 = input.LA(1);

                         
                        int index87_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA87_6 = input.LA(1);

                         
                        int index87_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA87_7 = input.LA(1);

                         
                        int index87_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA87_8 = input.LA(1);

                         
                        int index87_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA87_9 = input.LA(1);

                         
                        int index87_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA87_10 = input.LA(1);

                         
                        int index87_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred122_InternalSEW()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index87_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )";
        }
    }

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "900:7: (lv_element_6_1= ruleObject | lv_element_6_2= ruleAttribute )";
        }
    }

    class DFA139 extends DFA {

        public DFA139(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 139;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "4107:8: (lv_element_12_1= ruleDeprecatedAttribute | lv_element_12_2= ruleDeprecatedObject | lv_element_12_3= ruleObject )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000C000L,0x00000000000000A0L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000214090L,0x00000000000007E0L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010080L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000224010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000204000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000C00080L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000002000040L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000204010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000214010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000050000080L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020204010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000204012L,0x00000000000007E0L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFF784000122040F0L,0x00000000000027FFL});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000C00000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xFF784000122040F0L,0x00000000000007FFL});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000003000000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000007C000000002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000380000100002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000400000000002L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0007800000000002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xFF784000322040F0L,0x00000000000027FFL});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000020400000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0008000000000040L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000002000040L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000800L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0100000000204010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000204110L,0x00000000000007E0L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000000000020C110L,0x00000000000007E0L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x000000002020C110L,0x00000000000007E0L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000000000020C112L,0x00000000000007E0L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xFF784000122240F0L,0x00000000000027FFL});
    }


}