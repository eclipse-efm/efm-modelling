/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia;

public class MoCC2XLIAUtils {


//	/**
//	 * Getter for current cyclostatic rate of a port
//	 * @param moccPort
//	 * @return
//	 */
//	protected Expression currentCycloRate(final MoccPort moccPort) {
//		assert( moccPort.hasCycloStaticRate()
//				&& (helper(moccPort).constTOKEN_RATE_CSDF != null) );
//
//		return XLIA_EXPRESSION.createArrayElement(
//				helper(moccPort).constTOKEN_RATE_CSDF,
//				XLIA_EXPRESSION.createExpression(XLIA_EXPRESSION.OP_MODULO,
//						helper(moccPort.actor).varActivationCount,
//						XLIA_EXPRESSION.createExpression(
//								moccPort.getCycloStaticRate().length)));
//	}
//
//
//	/**
//	 * Adding if-condition for non-zero cyclo-static rate
//	 * @param blockContainer
//	 * @param moccPort
//	 * @return
//	 */
//	protected BlockStatement testIfHasCycloRate(
//			final BlockStatement blockContainer, final MoccPort moccPort)
//	{
//		if( moccPort.hasCycloStaticRate() ) {
//			final IfStatement ifStatement = XLIA_STATEMENT.addIf(blockContainer,
//					XLIA_EXPRESSION.createRelational(XLIA_EXPRESSION.OP_GT,
//							currentCycloRate(moccPort), XLIA_EXPRESSION.zero()) );
//			// theBlock
//			return XLIA_STATEMENT.createBlockStatement(ifStatement);
//		}
//
//		return blockContainer;
//
//	}



}
