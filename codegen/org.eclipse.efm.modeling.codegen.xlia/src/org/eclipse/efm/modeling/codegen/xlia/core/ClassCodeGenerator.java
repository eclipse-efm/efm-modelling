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
package org.eclipse.efm.modeling.codegen.xlia.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.modeling.codegen.xlia.util.PrettyPrintWriter;
import org.eclipse.efm.modeling.formalml.Configuration;
import org.eclipse.efm.modeling.formalml.FormalBlock;
import org.eclipse.efm.modeling.formalml.Part;
import org.eclipse.efm.modeling.formalml.helpers.StereotypeUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.ValueSpecification;

public class ClassCodeGenerator extends AbstractCodeGenerator {

	/**
	 * Constructor
	 */
	public ClassCodeGenerator(MainCodeGenerator supervisor) {
		super(supervisor);
	}


	/**
	 * performTransform dispatcher for any element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransformImpl(Element element, PrettyPrintWriter writer) {
		if( element instanceof Class ) {
			transformClassDefinition((Class)element, writer);
		}

		else if( element instanceof Model ) {
			transformFormalModel((Model)element, writer);
		}

		else {
			performTransformError(this, element);
		}
	}


	////////////////////////////////////////////////////////////////////////////
	// Tools for Model transformation
	////////////////////////////////////////////////////////////////////////////

	public boolean isPart(Property element) {
		if( StereotypeUtil.getPart(element) != null ) {
			return( true );
		}
		else {
			return( isUmlPart(element) );
		}
	}

	public boolean isUmlPart(Property element) {
		if( !(element instanceof Port)
			&& (element.getType() instanceof Class) ) {

			EObject container = element.eContainer();

			if( container instanceof StructuredClassifier ) {
				StructuredClassifier stClass = (StructuredClassifier) container;
				return( stClass.getParts().contains(element) );
				}
			}

		return( false );
	}

	public boolean isBlockConfigurationDefinition(Class element) {
		if( (StereotypeUtil.getConfiguration(element) != null) ) {
			return( true );
		}
		else {
			return( false );
		}
	}


	public boolean isBlock(Class element) {
		if( (StereotypeUtil.getBlock(element) != null) ) {
			return( true );
		}
		else {
			for( Behavior itBehavior : element.getOwnedBehaviors() ) {
				if( itBehavior instanceof StateMachine ) {
					return( true );
				}
			}

			return( false );
		}
	}


	public void collectElement(Package packageElement,
			List<NamedElement> properties, List<Class> machinesAsBlock,
			List<Property> blockInstances,
			ArrayList<Class> machinesAsConfiguration) {
		for( PackageableElement itPE : packageElement.getPackagedElements() ) {
			if( itPE instanceof Property ) {
				Property itProperty = (Property)itPE;

				if( isPart(itProperty) ) {
					blockInstances.add( itProperty );
				}
				else{
					properties.add( itProperty );
				}
			}
			else if( itPE instanceof DataType ) {
				properties.add( itPE );
			}
			else if( itPE instanceof Signal ) {
				properties.add( itPE );
			}

			else if( itPE instanceof Class ) {
				Class itClass = (Class) itPE;

				if( isBlockConfigurationDefinition(itClass) ) {
					if( machinesAsConfiguration != null ) {
						machinesAsConfiguration.add( itClass );
					}
					else {
						System.out.println(
								"Unexpected a null< machinesAsConfiguration > !");
					}
				}
				else if( isBlock(itClass) ) {
					machinesAsBlock.add( itClass );
				}
				else {
				}
			}
			else if( itPE instanceof Package ) {
				collectElement((Package)itPE, properties, machinesAsBlock,
						blockInstances, machinesAsConfiguration);
			}
			else {
			}
		}
	}


	public void collectElement(Class pack,
			List<NamedElement> properties, List<Class> machinesAsBlock,
			List<Property> blockInstances,
			List<Behavior> blockBehaviors,
			ArrayList<Class> machinesAsConfiguration) {
		for( Property itAttribute : pack.getOwnedAttributes() ) {
			if( isPart(itAttribute) ) {
				blockInstances.add( itAttribute );
			}
			else{
				properties.add( itAttribute );
			}
		}

		for( Behavior itBehavior : pack.getOwnedBehaviors() ) {
			if( itBehavior instanceof StateMachine ) {
				blockBehaviors.add(itBehavior);

				collectElement(itBehavior, properties, machinesAsBlock,
						blockInstances, machinesAsConfiguration);
			}
		}
	}


	public void collectElement(PackageableElement pack,
			List<NamedElement> properties, List<Class> machinesAsBlock,
			List<Property> blockInstances,
			ArrayList<Class> machinesAsConfiguration) {
		if( pack instanceof Package ) {
			collectElement(pack, properties, machinesAsBlock,
					blockInstances, machinesAsConfiguration);
		}
		else if( pack instanceof Property ) {
			Property itProperty = (Property) pack;

			if( isPart(itProperty) ) {
				blockInstances.add( itProperty );
			}
			else{
				properties.add( itProperty );
			}
		}
		else if( pack instanceof DataType ) {
			properties.add( pack );
		}
		else if( pack instanceof Signal ) {
			properties.add( pack );
		}

		else if( pack instanceof Class ) {
			Class itClass = (Class) pack;

			if( isBlockConfigurationDefinition(itClass) ) {
				if( machinesAsConfiguration != null ) {
					machinesAsConfiguration.add( itClass );
				}
				else {
					System.out.println(
							"Unexpected a null< machinesAsConfiguration > !");
				}
			}
			else if( isBlock(itClass) ) {
				machinesAsBlock.add( itClass );
			}
			else {
				for( Property itProperty : itClass.getOwnedAttributes() ) {
					if( StereotypeUtil.getPart(itProperty) != null ) {

						blockInstances.add( (Property)itProperty );
					}
				}
			}
		}
	}


	/**
	 * performTransform a Model element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformFormalModel(
			Model element, PrettyPrintWriter writer) {
		fSupervisor.isSystemSerilization = true;

		ArrayList<NamedElement> properties = new ArrayList<NamedElement>();
		ArrayList<Class> machinesAsBlock = new ArrayList<Class>();
		ArrayList<Property> blockInstances = new ArrayList<Property>();

		ArrayList<Class> machinesAsConfiguration = new ArrayList<Class>();

		collectElement(element, properties, machinesAsBlock,
				blockInstances, machinesAsConfiguration);

		writer.appendTabEol2("@xlia< system , 1.0 >:");


		writer.appendTabEol("//!!FML:gen< FormalModel >");

		writer.appendTab("system ")
			.append(element.getName())
			.appendEol2(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		// Section property
		//
		writer.appendTabEol("@property:");
		for( Element property : properties ) {
			fSupervisor.performTransform(property, writer2);
		}

		// Section machine
		//
		if( ! machinesAsBlock.isEmpty() ) {
			writer.appendEolTab_Eol("@machine:");
			for( Class clazz : machinesAsBlock ) {
//				transformClassBlock(clazz, writer2);
				transformClassDefinition(clazz, writer2);
			}

			for( Class clazz : machinesAsConfiguration ) {
				transformClassConfiguration(clazz, writer2);
			}
		}
		// Section instance statemachine
		// ERROR
		if( ! blockInstances.isEmpty() ) {
			writer.appendEolTab_Eol("@instance:");
			for( Property instance : blockInstances ) {
				transformPropertyPart(instance, writer2);
			}
		}


		int instancesConfigurationCount = machinesAsConfiguration.size();
		if( instancesConfigurationCount > 0 ) {
			// Section moe
			//
			writer.appendEolTab_Eol("@moe:");

			// Section init
			//
			writer.appendTab2Eol("@init{" +
					((instancesConfigurationCount > 1) ? " |and|" : "") );
			for( Class ctxClass : machinesAsConfiguration ) {
				writer.appendTab3("init ")
					.append(ctxClass.getName())
					.appendEol(";");
			}
			writer.appendTab2Eol2("}");

			// Section schedule
			//
			writer.appendTab2Eol("@schedule{" +
					((instancesConfigurationCount > 1) ? " |i|" : "") );
			for( Class ctxClass : machinesAsConfiguration ) {
				writer.appendTab3("run ")
					.append(ctxClass.getName())
					.appendEol(";");
			}
			writer.appendTab2Eol2("}");
		}

		writer.append("} // end system from Mode")
			.appendEol(element.getName());

		fSupervisor.isSystemSerilization = false;
	}

	/**
	 * performTransform a Class as System element (a Configuration Class to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassSystemDefinition(
			Class element, PrettyPrintWriter writer) {
		fSupervisor.isSystemSerilization = true;

		// Pour retrouver le modèle de plus haut niveau à partir de element
		Model modelSystem = element.getModel();

		ArrayList<NamedElement> properties = new ArrayList<NamedElement>();
		ArrayList<Class> machinesAsBlock = new ArrayList<Class>();
		ArrayList<Property> blockInstances = new ArrayList<Property>();
		ArrayList<Behavior> behaviors = new ArrayList<Behavior>();

		collectElement(modelSystem, properties,
				machinesAsBlock, blockInstances, null);

		collectElement(element, properties,
				machinesAsBlock, blockInstances, behaviors, null);

		writer.appendTabEol2("@xlia< system , 1.0 >:");

		Configuration elementConfiguration =
				StereotypeUtil.getConfiguration(element);

		writer.appendTab();
		if( elementConfiguration.isTimed() ) {
			writer.append("timed ");
		}
		if( elementConfiguration.isInputEnabled() ) {
			writer.append("input_enabled ");
		}
		writer.append("system< and > ")
			.append(element.getName())
			.appendEol2(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		// Section property
		//
		writer.appendTabEol("@property:");
		for( Element property : properties ) {
			fSupervisor.performTransform(property, writer2);
		}

		// Section machine
		//
		if( ! machinesAsBlock.isEmpty() ) {
			writer.appendEolTab_Eol("@machine:");
			for( Class clazz : machinesAsBlock ) {
//				transformClassBlock(clazz, writer2);
				transformClassDefinition(clazz, writer2);
			}
		}

		// Section instance statemachine
		//
		writer.appendEolTab_Eol("@instance:");
		for( Property instance : blockInstances ) {
			transformPropertyPart(instance, writer2);
		}

		// Section moe
		//
		writer.appendEolTab_Eol("@moe:");

		transformClassMoeDefinition(
				StereotypeUtil.getBlock(element),
				behaviors, blockInstances, writer2);

		// Connect
		//
		writer.appendTabEol("@com:");
		for( Connector itConnector : element.getOwnedConnectors() ) {
			fSupervisor.transformConnector(itConnector, writer2);
		}
		writer.append("} // end system ")
			.appendEol(element.getName());

		fSupervisor.isSystemSerilization = false;
	}


	/**
	 * performTransform a Class element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassDefinition(
			Class element, PrettyPrintWriter writer) {
		if( StereotypeUtil.getConfiguration(element) != null ) {
			transformClassSystemDefinition(element, writer);
		}
		else if( StereotypeUtil.getBlock(element) != null ) {
			transformClassBlock((Class)element, writer);
		}
		else {
			transformClassUnspecifyDefinition(element, writer);
		}
	}

	/**
	 * performTransform a Class as Block Definition element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassBlock(
			Class element, PrettyPrintWriter writer) {
		ArrayList<NamedElement> properties = new ArrayList<NamedElement>();
		ArrayList<Class> machinesAsBlock = new ArrayList<Class>();
		ArrayList<Property> blockInstances = new ArrayList<Property>();
		ArrayList<Behavior> behaviors = new ArrayList<Behavior>();

		collectElement(element, properties,
				machinesAsBlock, blockInstances, behaviors, null);


		writer.appendTabEol("//!!FML:gen< Block >");

		writer.appendTab("model machine ")
			.append(element.getName())
			.appendEol2(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		// Section property
		//
		writer.appendTabEol("@property:");

		writer.appendTab2("public buffer fifo<*> buffer_")
				.append(element.getName())
				.appendEol2(";");

		transformClassContentDefinition(element, writer,
				properties, machinesAsBlock, blockInstances, behaviors);

		// Section moe
		//
		writer.appendEolTab_Eol("@moe:");

		transformClassMoeDefinition(
				StereotypeUtil.getBlock(element),
				behaviors, blockInstances, writer2);

		writer.appendTab("} // end model machine ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a Class as Test Context element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassConfiguration(
			Class element, PrettyPrintWriter writer) {
		ArrayList<NamedElement> properties = new ArrayList<NamedElement>();
		ArrayList<Class> machinesAsBlock = new ArrayList<Class>();
		ArrayList<Property> blockInstances = new ArrayList<Property>();
		ArrayList<Behavior> behaviors = new ArrayList<Behavior>();

		collectElement(element, properties,
				machinesAsBlock, blockInstances, behaviors, null);

		Configuration elementConfiguration =
				StereotypeUtil.getConfiguration(element);

		writer.appendTabEol("//!!FML:gen< Configuration >");

		writer.appendTab();
		if( elementConfiguration.isTimed() ) {
			writer.append("timed ");
		}
		if( elementConfiguration.isInputEnabled() ) {
			writer.append("input_enabled ");
		}
		writer.append("machine< and > ")
			.append(element.getName())
			.appendEol2(" {");

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		// Section property
		//
		writer.appendTabEol("@property:");

		writer.appendTab2("public buffer fifo<*> buffer_")
				.append(element.getName())
				.appendEol2(";");

		transformClassContentDefinition(element, writer,
				properties, machinesAsBlock, blockInstances, behaviors);

		// Section moe
		//
		writer.appendEolTab_Eol("@moe:");

		transformClassMoeDefinition(
				elementConfiguration, behaviors, blockInstances, writer2);

		writer.appendTab("} // end machine ")
			.appendEol2(element.getName());
	}

	/**
	 * performTransform the Content of a Class Block Definition element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassContentDefinition(
			Class element, PrettyPrintWriter writer,
			ArrayList<NamedElement> properties,
			ArrayList<Class> machinesAsBlock,
			ArrayList<Property> blockInstances,
			ArrayList<Behavior> behaviors) {

		// A writer indenting with TAB + iTAB -> TAB2
		PrettyPrintWriter writer2 = writer.itab2();

		// Section property
		//
		for( Element property : properties ) {
			fSupervisor.performTransform(property, writer2);
		}

		// Section routine
		//
		if( ! element.getOperations().isEmpty() ) {
			writer.appendEolTab("@routine:");
			for( Operation itOp : element.getOperations() ) {
				writer.appendEol();
				fSupervisor.transformOperation(itOp, writer2);
			}
		}

		// Section machine
		//
		if( ! machinesAsBlock.isEmpty() ) {
			writer.appendEolTab_Eol("@machine:");
			for( Class clazz : machinesAsBlock ) {
//				transformClassBlock(clazz, writer2);
				transformClassDefinition(clazz, writer2);
			}
		}

		// Section instance
		//
		if( ! blockInstances.isEmpty() ) {
			writer.appendEolTab_Eol("@instance:");
			for( Property instance : blockInstances ) {
				transformPropertyPart(instance, writer2);
			}
		}

		// Section behavior / statemachine region
		//
		if( ! behaviors.isEmpty() ) {
			writer.appendEolTab_Eol("@behavior:");
			for( Behavior itBehavior : behaviors ) {
				fSupervisor.performTransformBehavior(itBehavior, writer2);
			}
		}

		// Connect
		//
		EList<Connector> connectors = element.getOwnedConnectors();
		if( ! connectors.isEmpty() ) {
			writer.appendEolTab_Eol("@com:");
			for( Connector itConnector : connectors ) {
				fSupervisor.transformConnector(itConnector, writer2);
			}
		}
	}

	/**
	 * performTransform the MOE of a Class Block Definition element to a writer
	 * @param block
	 * @param blockInstances
	 * @param writer
	 */
	public void transformClassMoeDefinition(
			FormalBlock formalBlock, ArrayList<Behavior> behaviors,
			List<Property> blockInstances, PrettyPrintWriter writer) {
		int blockInstancesCount = blockInstances.size();
		int behaviorCount = behaviors.size();

		Part Part;

		if( behaviorCount > 0 ) {
			if( formalBlock.getBaseClass().getClassifierBehavior() == null ) {
				LOGGER.error( ( new StringBuffer(this.getClass().getSimpleName()) )
					.append( ":> unexpected Block Class " )
					.append( formalBlock.getBaseClass().getQualifiedName() )
					.append( " with ownedBehavior, without classifierBehavior" )
					.toString() );
			}
		}


		// Section init
		//
		writer.appendTab("@init{");

// TODO MIGRATION
//		Behavior initBehavior = block.getInitBehavior();

		Behavior initBehavior = null;

		if( initBehavior == null ) {
			if( blockInstancesCount > 0 ) {
				writer.appendEol( ((blockInstancesCount > 1) ? " |and|" : "") );

				for( Property inst : blockInstances ) {
					Part = StereotypeUtil.getPart(inst);
					if( Part != null ) {
						for( InstanceSpecification instance : Part.getInstance() ) {
							writer.appendTab3("init ")
								.append(instance.getName())
								.appendEol(";");
						}
					}
					else if( StereotypeUtil.getPart(inst) != null ) {
						writer.appendTab2("init ")
							.append(inst.getName())
							.appendEol(";");
					}
					else {
						writer.appendTab2("init ")
						.append(inst.getName())
						.appendEol(";");
					}
				}
			}
			else if( behaviorCount > 0 ) {
				writer.appendEol( ((behaviorCount > 1) ? " |and|" : "") );
				for( Behavior behavior : behaviors ) {
					writer.appendTab2("init ")
						.append(behavior.getName())
						.appendEol(";");
				}
			}
		}

// TODO MIGRATION
//		else if( initBehavior instanceof OpaqueBehavior ) {
//			writer.appendEol();
//			fSupervisor.transformOpaqueBehaviorBody(
//					(OpaqueBehavior)initBehavior, writer.itab2());
//		}
//		else {
//			writer.appendEol();
//			fSupervisor.performTransform(initBehavior, writer.itab2());
//		}
		writer.appendTabEol2("}");

		// Section schedule
		//
		writer.appendTab("@schedule{");

		Class block_base_Class = formalBlock.getBaseClass();
		if (block_base_Class !=null){
			Behavior scheduleBehavior = block_base_Class.getClassifierBehavior();

			if( scheduleBehavior != null && scheduleBehavior instanceof StateMachine ) {
				writer.appendEolTab2("run ")
					.append(scheduleBehavior.getName())
					.appendEol(";");
			}
		}

		else {
			boolean isLibrarybehavior = true;

//			if( scheduleBehavior instanceof InterleavingScheduler ) {
//				writer.appendEol("|i|");
//			}
//			else if( scheduleBehavior instanceof SequenceScheduler ) {
//				writer.appendEol("|;;|");
//			}
//			else
			{
//				isLibrarybehavior = false;
				writer.appendEol("|i|");
			}

			if( isLibrarybehavior ) {
				if( blockInstancesCount > 0 ) {
					for( Property inst : blockInstances ) {
						Part = StereotypeUtil.getPart(inst);
						if( Part != null ) {
							for( InstanceSpecification instance : Part.getInstance() ) {
								writer.appendTab3("run ")
									.append(instance.getName())
									.appendEol(";");
							}
						}
						else if( StereotypeUtil.getPart(inst) != null ) {
							writer.appendTab2("run ")
								.append(inst.getName())
								.appendEol(";");
						}
						else {
							writer.appendTab2("run ")
							.append(inst.getName())
							.appendEol(";");
						}
					}
				}
				else if( behaviorCount > 0 ) {
					for( Behavior behavior : behaviors ) {
						writer.appendTab2("run ")
							.append(behavior.getName())
							.appendEol(";");
					}
				}
			}
			//FIXME: scheduleBehavior is not in scope here !
//			else if( scheduleBehavior instanceof OpaqueBehavior ) {
//				writer.appendEol();
//				fSupervisor.transformOpaqueBehaviorBody(
//						(OpaqueBehavior)scheduleBehavior, writer.itab2());
//			}
//			else {
//				writer.appendEol();
//				fSupervisor.performTransform(scheduleBehavior, writer.itab2());
//			}
		}
		writer.appendTabEol2("}");
	}


	/**
	 * performTransform an Unspecify Class element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformClassUnspecifyDefinition(
			Class element, PrettyPrintWriter writer) {
		ArrayList<NamedElement> properties = new ArrayList<NamedElement>();
		ArrayList<Class> machinesAsBlock = new ArrayList<Class>();
		ArrayList<Property> blockInstances = new ArrayList<Property>();
		ArrayList<Behavior> behaviors = new ArrayList<Behavior>();

		collectElement(element, properties,
				machinesAsBlock, blockInstances, behaviors, null);

		writer.appendTab("machine ")
			.append(element.getName())
			.appendEol2(" {");

		// Section property
		//
		writer.appendTabEol("@property:");

		writer.appendTab2("public buffer fifo<*> buffer_")
				.append(element.getName())
				.appendEol2(";");


		transformClassContentDefinition(element, writer,
				properties, machinesAsBlock, blockInstances, behaviors);


		// Section moe
		//
		int blockInstancesCount = blockInstances.size();
		int behaviorCount = behaviors.size();

		if( (blockInstancesCount + behaviorCount) > 0 ) {
			// Section moe
			//
			writer.appendEolTab_Eol("@moe:");

			Part Part;

			// Section init
			//
			writer.appendTab2("@init{");
			if( blockInstancesCount > 0 ) {
				writer.appendEol( ((blockInstancesCount > 1) ? " |and|" : "") );
				for( Property inst : blockInstances ) {
					Part = StereotypeUtil.getPart(inst);
					if( Part != null ) {
						for( InstanceSpecification instance : Part.getInstance() ) {
							writer.appendTab3("init ")
								.append(instance.getName())
								.appendEol(";");
						}
					}
					else if( StereotypeUtil.getPart(inst) != null ) {
						writer.appendTab3("init ")
							.append(inst.getName())
							.appendEol(";");
					}
					else {
						writer.appendTab3("init ")
						.append(inst.getName())
						.appendEol(";");
					}
				}
			}
			else if( behaviorCount > 0 ) {
				writer.appendEol( ((behaviorCount > 1) ? " |and|" : "") );
				for( Behavior behavior : behaviors ) {
					writer.appendTab3("init ")
						.append(behavior.getName())
						.appendEol(";");
				}
			}
			writer.appendTab2Eol2("}");

			// Section schedule
			//
			writer.appendTab2("@schedule{");
			if( blockInstancesCount > 0 ) {
				writer.appendEol( ((blockInstancesCount > 1) ? " |i|" : "") );
				for( Property inst : blockInstances ) {
					Part = StereotypeUtil.getPart(inst);
					if( Part != null ) {
						for( InstanceSpecification instance : Part.getInstance() ) {
							writer.appendTab3("run ")
								.append(instance.getName())
								.appendEol(";");
						}
					}
					else if( StereotypeUtil.getPart(inst) != null ) {
						writer.appendTab3("run ")
							.append(inst.getName())
							.appendEol(";");
					}
					else {
						writer.appendTab3("run ")
						.append(inst.getName())
						.appendEol(";");
					}
				}
			}
			else if( behaviorCount > 0 ) {
				writer.appendEol( ((behaviorCount > 1) ? " |i|" : "") );
				for( Behavior behavior : behaviors ) {
					writer.appendTab3("run ")
						.append(behavior.getName())
						.appendEol(";");
				}
			}
			writer.appendTab2Eol2("}");
		}

		writer.appendTab("} // end machine ")
			.appendEol2(element.getName());
	}


	/**
	 * performTransform a Property as Class Block Instance element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformPropertyPart(
			Property element, PrettyPrintWriter writer) {

		writer.appendTabEol("//!!FML:gen< Part >");

		Part Part = StereotypeUtil.getPart(element);

		if( Part != null ) {

			Configuration parent_context = StereotypeUtil.getConfiguration(element);

			EList<Property> environmental_properties;
			if (parent_context != null && parent_context.getEnv() != null) {
				environmental_properties = parent_context.getEnv();
			} else {
				environmental_properties = new BasicEList.UnmodifiableEList<Property>(0, null);
			}

			String comment_on_part = "";
			if (environmental_properties.contains(Part.getBaseProperty())) {
				comment_on_part = " /* in formal context 'environment' */";
			}

			if( Part.getInstance().isEmpty() ) {
				writer.appendTab( element.getVisibility().toString() )
					.append(" instance machine< ")
					.append(element.getType().getName());

				ValueSpecification lowerMultiplicity = element.getLowerValue();
				ValueSpecification upperMultiplicity = element.getUpperValue();
				if( (lowerMultiplicity != null) || (upperMultiplicity != null) ) {
					writer.append(" , multiplicity:( init:");
					if( lowerMultiplicity != null ) {
						fSupervisor.transformValueSpecification(lowerMultiplicity, writer);
					}
					else {
						writer.append("1");

					}
					if( (upperMultiplicity != null) &&
						( upperMultiplicity.unlimitedValue() > 0 ) ) {
						writer.append(" , max:");
						fSupervisor.transformValueSpecification(upperMultiplicity, writer);
					}
					writer.append(")");
				}

				writer.append(" > ")
					.append(element.getName())
					.append(";")
					.appendEol(comment_on_part);
			}
			else {
				for( InstanceSpecification instance : Part.getInstance() ) {
					writer.appendTab( element.getVisibility().toString() )
						.append(" instance machine< ")
						.append(element.getType().getName())
						.append(" > ")
						.append(instance.getName())
						.append(";")
						.appendEol(comment_on_part);
				}
			}
		}
		else {
			writer.appendTab("/* UNSPECIFY INSTANCE */ instance machine< ")
				.append(element.getVisibility().toString())
				.append(" ")
				.append(element.getType().getName())
				.append(" > ")
				.append(element.getName())
				.appendEol("; */ formal part is null */");
		}
	}

	public void transformPropertyDefinition(
			Property element, PrettyPrintWriter writer) {

		writer.appendTab( element.getVisibility().toString() )
			.append(" var machine /*< ") 	// it lacked "var" keyword when declaring "machine"
										// type properties for a "struct" data type
			//.append(" machine< ")
			.append(element.getType().getName())
			.append(" >*/ ")
			.append(element.getName())
			.appendEol(";");
	}


	/**
	 * performTransform a Property as Environment element to a writer
	 * @param element
	 * @param writer
	 */
	public void transformPropertyEnvironment(
			Property element, PrettyPrintWriter writer) {
		if( fSupervisor.isSystemSerilization ) {
			//BUFFERIZATION
		}
		else  {
			writer.appendTab("instance environment ")
//				.append(element.getType().getName())
				.append(element.getName())
				.appendEol(";");
		}
	}

}
