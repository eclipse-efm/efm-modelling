/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.formalml.concretesyntax.m2t.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.formalml.Configuration;
import org.eclipse.efm.formalml.DirectedPort;
import org.eclipse.efm.formalml.concretesyntax.m2t.util.PrettyPrintWriter;
import org.eclipse.efm.formalml.util.StereotypeUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Vertex;

public class MainCodeGenerator extends AbstractCodeGenerator {

	private static final String STD_ENV_TYPE_NAME = "Env";

	/**
	 * Main System Serilization Flag
	 */
	public boolean isSystemSerilization = false;

	/**
	 * show Transition Section Flag
	 * section list: @trigger, @guard, @tguard, @effect
	 */
	public boolean showTransitionSection = false;

	/**
	 * Co-Codegenfactory for Class Element
	 */
	public ClassCodeGenerator fClassFactory;

	/**
	 * Co-Codegenfactory for DataType Element
	 */
	public DataTypeCodeGenerator fDataTypeFactory;

	/**
	 * Co-Codegenfactory for Statemachine Element
	 */
	public StatemachineCodeGenerator fStatemachineFactory;


	/**
	 * Constructor
	 */
	public MainCodeGenerator() {
		super();

		this.fClassFactory = new ClassCodeGenerator(this);

		this.fDataTypeFactory = new DataTypeCodeGenerator(this);

		this.fStatemachineFactory = new StatemachineCodeGenerator(this);
	}


	/**
	 * performTransform any element to a string
	 * @param element
	 * @return
	 */
	public String performTransform(EObject element) {
		isSystemSerilization = false;

		if( element instanceof Element ) {
			StringWriter buffer = new StringWriter();
			PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

			performTransform((Element)element, writer);

			return( buffer.toString() );
		}

		else if( element != null ) {
			return( element.toString() );
		}
		else {
			return null;
		}
	}

	/**
	 * performTransform any element to a file
	 * @param element
	 * @param filePath
	 * @return
	 */
	public boolean performTransform(EObject element, IPath filePath) {
		isSystemSerilization = false;

		if( element instanceof Element ) {
			FileWriter buffer;
			try {
				buffer = new FileWriter(filePath.toOSString());

				PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

				performTransform((Element)element, writer);

				writer.close();

				return( true );

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return( false );
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransform(Element element, PrettyPrintWriter writer) {

		// StatemachineFactory
		if( element instanceof StateMachine ) {
			fStatemachineFactory.transformStatemachine((StateMachine)element, writer);
		}

		else if( element instanceof Region ) {
			fStatemachineFactory.transformRegion((Region)element, writer);
		}

		else if( element instanceof Pseudostate ) {
			fStatemachineFactory.transformPseudostate((Pseudostate)element, writer);
		}
		else if( element instanceof FinalState ) {
			fStatemachineFactory.transformFinalState((FinalState)element, writer);
		}
		else if( element instanceof State ) {
			fStatemachineFactory.transformState((State)element, writer);
		}
		else if( element instanceof Vertex ) {
			fStatemachineFactory.transformVertexContent((Vertex)element, writer);
		}
		else if( element instanceof Transition ) {
			fStatemachineFactory.transformTransition((Transition)element, writer);
		}

		// This Factory
		else if( element instanceof OpaqueBehavior ) {
			transformOpaqueBehavior((OpaqueBehavior)element, writer);
		}

		// ClassFactory
		else if( element instanceof Class ) {
			fClassFactory.transformClassDefinition((Class)element, writer);
		}

		else if( element instanceof Model ) {
			fClassFactory.transformFormalModel((Model)element, writer);
		}

		// DataTypeFactory
		else if( element instanceof Enumeration ) {
			fDataTypeFactory.transformEnumeration((Enumeration)element, writer);
		}

		else if( element instanceof EnumerationLiteral ) {
			fDataTypeFactory.transformEnumerationLiteral(
					(EnumerationLiteral)element, writer);
		}

		else if( element instanceof DataType ) {
			fDataTypeFactory.transformDataType((DataType)element, writer);
		}

		// This Factory
		else if( element instanceof Package ) {
			transformPackageDefinition((Package)element, writer);
		}

		else if( element instanceof Port ) {
			transformPort((Port)element, writer);
		}
		else if( element instanceof Parameter ) {
			transformParameter((Parameter)element, writer);
		}
		else if( element instanceof Property ) {
			transformProperty((Property)element, writer);
		}

		else if( element instanceof Operation ) {
			transformOperation((Operation)element, writer);
		}

		else if( element instanceof Connector ) {
			transformConnector((Connector)element, writer);
		}
		else if( element instanceof Signal ) {
			transformSignal((Signal)element, writer);
		}

		else if( element instanceof NamedElement ) {
			writer.appendTab("named_element");
			if( ((NamedElement)element).getName() != null ) {
				writer.append(' ')
					.append(((NamedElement)element).getName());
			}
			writer.appendEol(" { /* TODO */ }");
		}
		else {
			writer.appendTab("element ")
				.append(element.toString())
				.appendEol(" { /* TODO */ }");
		}
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param behavior
	 * @param writer
	 */
	public void performTransformBehavior(Behavior behavior, PrettyPrintWriter writer) {
		if( behavior != null ) {
			if( behavior instanceof StateMachine ) {
				fStatemachineFactory.transformStatemachine(
						(StateMachine)behavior, writer);
			}
			else if( behavior instanceof OpaqueBehavior ) {
				writer.appendTabEol("/*");
				transformOpaqueBehavior((OpaqueBehavior)behavior, writer);
				writer.appendTabEol("*/");
			}
			else {
				writer.appendTab("behavior ")
					.append( (behavior.getName() != null)?
							behavior.getName() : "<unamed>" )
					.appendEol(" {");

				EList<Behavior> behaviors = behavior.getOwnedBehaviors();
				if( ! behaviors.isEmpty() ) {
					writer.appendEolTab_Eol("@behavior:");
					PrettyPrintWriter writer2 = writer.itab2();
					for( Behavior itBehavior : behaviors ) {
						performTransformBehavior(itBehavior, writer2);
					}
				}

				writer.appendTab2Eol(behavior.toString());
				writer.appendTabEol("}");
			}
		}
		else {
			writer.appendTabEol("behavior null { }");
		}
	}

	/**
	 * performTransform an Opaque Behavior element to a writer
	 * @param behavior
	 * @param writer
	 */
	public void transformBehaviorBody(
			Behavior behavior, PrettyPrintWriter writer) {
		if( behavior instanceof OpaqueBehavior ) {
			transformOpaqueBehaviorBody(
					(OpaqueBehavior)behavior, writer);
		}
		else if( behavior instanceof Activity ) {
			writer.appendTab2("// exec uml::activity ")
				.appendEol(behavior.getName());
		}
		else if( behavior instanceof Interaction ) {
			writer.appendTab2("// exec uml::interaction ")
				.appendEol(behavior.getName());
		}
		else if( behavior instanceof StateMachine ) {
			writer.appendTab2("// exec uml::statemachine ")
				.appendEol(behavior.getName());
		}
		else if( behavior != null ) {
//			writer.appendTab("// exec uml::behavior ")
			writer.appendTab2("// exec uml::")
				.append(behavior.getClass().getSimpleName())
				.append(" ")
				.appendEol(behavior.getName());
		}
	}


	/**
	 * performTransform an Opaque Behavior element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformOpaqueBehavior(
			OpaqueBehavior element, PrettyPrintWriter writer) {
		writer.appendTab("behavior< opaque > ")
		.append( (element.getName() != null)?
				element.getName() : "<unamed>" )
		.appendEol(" {");

		transformOpaqueBehaviorBody(element, writer.itab2());

		writer.appendTabEol("}");
	}

	/**
	 * performTransform an Opaque Behavior element to a writer
	 * @param behavior
	 * @param writer
	 */
	public void transformOpaqueBehaviorBody(
			OpaqueBehavior behavior, PrettyPrintWriter writer) {
		for( String body : behavior.getBodies() ) {
			if( body.startsWith(writer.iTAB) ) {
				body = body.trim().replaceAll(
						"\n" /*System.lineSeparator()*/ + writer.iTAB,
						writer.EOL + writer.TAB1);
				writer.appendTab2Eol(body);
			}
			else {
				body = body.replaceAll(
						"\n" /*System.lineSeparator()*/,
						writer.EOL + writer.TAB1);
				writer.appendTabEol(body);
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// Tools for Model transformation
	////////////////////////////////////////////////////////////////////////////

	/**
	 * performTransform a Package element to a writer
	 * @param classContainer
	 * @param element
	 * @param writer
	 */
	public void transformPackageDefinition(
			Package element, PrettyPrintWriter writer) {

		writer.appendTab("package ")
			.append(element.getName())
			.appendEol2(" {");

		for( PackageableElement it : element.getPackagedElements() ) {
			performTransform( it );
		}

		writer.appendTab("} // end package ")
		.appendEol2(element.getName());
	}


	/**
	 * performTransform a Property element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformProperty(Property element, PrettyPrintWriter writer) {
		if( element instanceof Port )
		{
			transformPort((Port)element, writer);
		}
		else if( fClassFactory.isPart(element) ) {
			if( element.eContainer() instanceof DataType ) {
				fClassFactory.transformPropertyDefinition(element, writer);
			}
			else {
				writer.appendTabEol( "/* Unexpected property typed by <class> HERE */" );

				fClassFactory.transformPropertyPart(element, writer);
			}
		}
		else if( (element.getType() != null)
				&& element.getType().getName().equals(STD_ENV_TYPE_NAME) ) {
			fClassFactory.transformPropertyEnvironment(element, writer);
		}
//		else if( StereotypeUtil.getClock(element) != null ) {
//			transformPropertyDefintion(element, writer, " var clock< ", " > ");
//
//			writer.appendEol(";");
//		}
		else {
			transformPropertyDefintion(element, writer,
					(element.isReadOnly()? " const var " : " var "), " ");


			writer.appendEol(";");
		}
	}


	public void transformPropertyDefintion(
			Property element, PrettyPrintWriter writer,
			String beforeTypename, String afterTypename) {
		writer.appendTab( element.getVisibility().toString() )
			.append( beforeTypename )
			.append( fDataTypeFactory.typeName(element) )
			.append( afterTypename)
			.append( element.getName() );

		ValueSpecification defaultValue = element.getDefaultValue();
		if(  defaultValue != null ) {
			writer.append(" = ");
			transformValueSpecification(defaultValue, writer);
		}
	}



	/**
	 * performTransform a Property as Variable element to a writer
	 * @param element
	 * @param writer
	 */
// TODO MIGRATION
//	public void transformVariable(Property element, PrettyPrintWriter writer) {
//		transformPropertyDefintion(element, writer,
//				(element.isFinal() ? " final " : "") + " var ", " ");
//
//		writer.appendEol(";");
//	}


	/**
	 * performTransform a Operation element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformOperation(Operation element, PrettyPrintWriter writer) {
		writer.appendTab("macro routine ");
		if( element.getName() != null ) {
			writer.append( element.getName() );
		}
		else  {
			writer.append( "null<name>" );
		}

		transformOperationParameters(element.getOwnedParameters(), writer);

		writer.appendEol(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		for( Behavior method : element.getMethods() ) {
			if( method instanceof OpaqueBehavior ) {
				writer.appendTab2("//xlia::behavior ")
					.appendEol( method.getName() );

				transformOpaqueBehaviorBody((OpaqueBehavior)method, writer2);
			}
			else if( method instanceof Activity ) {
				writer.appendTab2("uml::activity ")
					.appendEol(method.getName());
			}
			else if( method instanceof Interaction ) {
				writer.appendTab2("uml::interaction ")
					.appendEol(method.getName());
			}
			else if( method instanceof StateMachine ) {
				writer.appendTab2("uml::statemachine ")
					.appendEol(method.getName());
			}
			else if( method != null ) {
				writer.appendTab2("uml::")
					.append(method.getClass().getSimpleName())
					.append(" ")
					.appendEol(method.getName());
			}
		}

		writer.appendTabEol("}");
	}

	/**
	 * performTransform Operation Parameters element to a writer
	 * @param parameters
	 * @param writer
	 */
	public void transformOperationParameters(
			EList<Parameter> parameters, PrettyPrintWriter writer) {
		writer.append("(");
		boolean firstParam = true;
		for( Parameter itParameter : parameters ) {
			if( itParameter.getDirection() != ParameterDirectionKind.RETURN_LITERAL ) {
				if( firstParam ) {
					firstParam = false;
				}
				else {
					writer.append(", ");
				}

				if( itParameter.getDirection() != ParameterDirectionKind.IN_LITERAL ) {
					writer.append( itParameter.getDirection().toString() )
						.append(' ');
				}
				writer.append( fDataTypeFactory.typeName(itParameter) )
					.append(' ')
					.append(itParameter.getName());

				if( itParameter.getDefaultValue() != null ) {
					writer.append(" = ");
					transformValueSpecification( itParameter.getDefaultValue(), writer );
				}
			}
		}
		writer.append(")");

		firstParam = true;
		for( Parameter itParameter : parameters ) {
			if( itParameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL ) {
				if( firstParam ) {
					writer.append(" --> (");
					firstParam = false;
				}
				else {
					writer.append(", ");
				}
				writer.append( fDataTypeFactory.typeName(itParameter) )
					.append(' ')
					.append(itParameter.getName());

				if( itParameter.getDefaultValue() != null ) {
					writer.append(" = ");
					transformValueSpecification( itParameter.getDefaultValue(), writer );
				}
			}
		}
		if( ! firstParam ) {
			writer.append(")");
		}
	}

	/**
	 * performTransform a Parameter element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformParameter(Parameter element, PrettyPrintWriter writer) {
		writer.appendTab("parameter");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}
		writer.appendEol(" { /* TODO */ }");
	}


	/**
	 * performTransform a Port element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformPort(Port element, PrettyPrintWriter writer) {
		String direction = portDirection(element);

		// !!!!!!! A revoir : comment modéliser les paramètres des ports !
		// !!!!!!! Pour le moment on suppose un seul paramètre possible
		// !!!!!!! et on utilise itProp.getType().getName()
		// !!!!!!! pour avoir le type du paramètre
		//
//		if(  element.getType() instanceof PrimitiveType ) {
//			writer.appendTab(element.getVisibility().toString())
//				.append(" port ")
//				.append( direction )
//				.append(element.getName())
//				.append("( ")
//				.append( fDataTypeFactory.typeName(element) )
//				.appendEol(" );");
//			}
//		else {
//			writer.appendTab(element.getVisibility().toString())
//				.append(" port ")
//				.append( direction )
//				.append(element.getName())
//				.append("( ")
//				.append( fDataTypeFactory.typeName(element) )
//				.appendEol(" );");
//		}

		writer.appendTab(element.getVisibility().toString())
			.append(" port ")
			.append( direction )
			.append(element.getName());

		if(element.getType() == null) {
			writer.appendEol(" ; /* port without a typed argument */");
		} else {
			writer.append("( ")
				.append( fDataTypeFactory.typeName(element) )
				.appendEol(" );");
		}
	}


	/**
	 * @param Port
	 * @return direction as string
	 */
	public String portDirection(Port element) {
		DirectedPort flowPort = StereotypeUtil.getDirectedPort(element);
		if( flowPort != null ) {
			switch( flowPort.getDirection() ) {
				case IN: {
					return "input ";
				}
				case OUT: {
					return "output ";
				}
				case INOUT:
				default: {
					return "inout ";
				}
			}
		}

		return "inout ";
	}


	/**
	 * performTransform a Signal element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformSignal(Signal element, PrettyPrintWriter writer) {
		writer.appendTab(element.getVisibility().toString())
			.append(" signal");
		if( element.getName() != null ) {
			writer.append(' ')
				.append(element.getName());
		}

		writer.append("(");
		boolean firstParam = true;
		for( Property itProp : element.getAllAttributes() ) {
			if( firstParam ) {
				firstParam = false;
			}
			else {
				writer.append(", ");
			}

			writer.append( fDataTypeFactory.typeName(itProp) );
			}
		writer.appendEol(");");
	}

	/**
	 * performTransform an environmental Connector element to a writer
	 * @param element
	 * @param port_connectorEnd i.e. prt of the Part that isn't the environment
	 * @param writer
	 */
	private void transformEnvironmentConnector(Connector element, ConnectorEnd port_connectorEnd, PrettyPrintWriter writer) {
		writer.appendTab("connect< env >");
		if( element.getName() != null ) {
			writer.append(" ")
				.append(element.getName());
		}
		writer.appendEol(" {");
		Property itProperty = port_connectorEnd.getPartWithPort();
		ConnectableElement itRole = port_connectorEnd.getRole();
		if( itRole instanceof Port ) {
			writer.appendTab2Eol(
					portDirection((Port)itRole) + " " +
					itProperty.getName() +
					"->" + itRole.getName() + ";");
			writer.appendTabEol("}");
		}
		else {
			writer.appendEol(" ERROR : end is not a Port ");
			return;
		}
	}

	/**
	 * performTransform an environmental Connector element to a writer
	 * @param element
	 * @param port_connectorEnd i.e. prt of the Part that isn't the environment
	 * @param writer
	 */
	private void transformRelationshipConnector(Connector element, PrettyPrintWriter writer) {
		Behavior connectorContract = (element.getContracts().isEmpty()
				? null : element.getContracts().get(0) );

		writer.appendTab("connect");

		if( connectorContract != null ) {
			writer.append("< ");
			transformBehaviorBody(connectorContract,
					new PrettyPrintWriter(writer, "", "", ""));
			writer.append(" >");
		}

		if( element.getName() != null ) {
			writer.append(" ")
				.append(element.getName());
		}
		writer.appendEol(" {");

		Configuration parent_context = StereotypeUtil.getConfiguration(element);

		EList<Property> environmental_properties;
		if (parent_context != null && parent_context.getEnv() != null) {
			environmental_properties = parent_context.getEnv();
		} else {
			environmental_properties = new BasicEList.UnmodifiableEList<Property>(0, null);
		}

		for( ConnectorEnd itConnectorEnd : element.getEnds() ) {
			Property itProperty = itConnectorEnd.getPartWithPort();
			String comment_on_part = "";
			if (environmental_properties.contains(itProperty)) {
				comment_on_part = " /* in formal context 'environment' */";
			}
			ConnectableElement itRole = itConnectorEnd.getRole();
			writer.appendTab2Eol(
					portDirection((Port)itRole) + " " +
					itProperty.getName() +
					"->" + itRole.getName() + ";" + comment_on_part);
		}
	}

	/**
	 * performTransform a Connector element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformConnector(Connector element, PrettyPrintWriter writer) {

		int number_ends = element.getEnds().size();

		if(number_ends > 2) {
			writer.appendEol(" ERROR : connector has more than 2 ends ");
			return;
		}

		if(number_ends <= 1) {
			writer.appendEol(" ERROR : connector has less than 2 ends ");
			return;
		}

		if(number_ends == 2) {
			ConnectorEnd zero_connectorEnd = element.getEnds().get(0);
			ConnectorEnd one_connectorEnd = element.getEnds().get(1);
			ConnectableElement zero_Role = zero_connectorEnd.getRole();
			ConnectableElement one_Role = one_connectorEnd.getRole();

			if( zero_Role instanceof Port && one_Role instanceof Port) {
				transformRelationshipConnector(element, writer);
				return;
			} else if(zero_Role instanceof Port && !(one_Role instanceof Port)) {
				transformEnvironmentConnector(element, zero_connectorEnd, writer);
				return;
			} else if(one_Role instanceof Port && !(zero_Role instanceof Port)) {
				transformEnvironmentConnector(element, one_connectorEnd, writer);
				return;
			} else {
				return;
			}
		}

	}



	/**
	 * performTransform a Value Specification element to a writer
	 * @param value
	 * @param writer
	 */
	public boolean isExpressionSymbol(ValueSpecification value, String aSymbol) {
		if( value instanceof Expression ) {
			return( aSymbol.equals( ((Expression) value).getSymbol() ) );
		}

		return( false );
	}

	public boolean isConstraintSymbol(Constraint constraint, String aSymbol) {
		if( constraint != null ) {
			return( isExpressionSymbol(constraint.getSpecification(), aSymbol) );
		}

		return( false );
	}

	public void transformValueSpecification(
			ValueSpecification value, PrettyPrintWriter writer) {
		if( value instanceof LiteralBoolean ) {
			writer.append(value.booleanValue());
		}
		else if( value instanceof LiteralInteger ) {
			writer.append(value.integerValue());
		}
		else if( value instanceof LiteralReal ) {
			writer.append(value.realValue());
		}
		else if( value instanceof LiteralString ) {
			writer.append(value.stringValue());
		}
		else if( value instanceof LiteralUnlimitedNatural ) {
			writer.append(value.unlimitedValue());
		}
		else if( value instanceof Expression ) {
			writer.append("(");

			Expression expr = (Expression) value;

			writer.append( (expr.getSymbol() != null) ?
					expr.getSymbol() : "<symbol:null>" );

			for(ValueSpecification vs : expr.getOperands() ) {
				writer.append(" ");
				transformValueSpecification(vs, writer);
			}

			writer.append(")");
		}
		else if(  value != null ) {
			final String name = value.getName();
			if( name != null ) {
				writer.append("ValueSpecification< ")
					.append(name)
					.append(" > ");
			}
			writer.append(value.toString());
		}
	}

}
