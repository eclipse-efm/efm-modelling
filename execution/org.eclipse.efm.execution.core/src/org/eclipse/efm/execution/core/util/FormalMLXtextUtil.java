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
package org.eclipse.efm.execution.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer;
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Signal;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;
import org.eclipse.efm.ecore.formalml.statemachine.Region;
import org.eclipse.efm.ecore.formalml.statemachine.State;
import org.eclipse.efm.ecore.formalml.statemachine.Statemachine;
import org.eclipse.efm.ecore.formalml.statemachine.Transition;
import org.eclipse.efm.ecore.formalml.statemachine.Vertex;
import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.formalml.xtext.FormalMLRuntimeModule;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class FormalMLXtextUtil {

	private String fModelFileLocation;

	private String fModelFileUriLocation;

	private XliaModel fModel;

	private BasicEList<Machine> fAllMachines;
	private BasicEList<InstanceMachine> fAllInstanceMachines;
	private BasicEList<Statemachine> fAllStatemachines;
	private BasicEList<Vertex> fAllStates;
	private BasicEList<Transition> fAllTransitions;

	private BasicEList<Port> fAllPorts;
	private BasicEList<Signal> fAllSignals;

	private BasicEList<Buffer> fAllBuffers;
	private BasicEList<Variable> fAllVariables;
	private BasicEList<Parameter> fAllParameters;


	private boolean USING_IPARSER = true;

	public FormalMLXtextUtil(String fileLocation) {
		super();
		this.fModelFileLocation    = fileLocation;
		this.fModelFileUriLocation = WorkflowFileUtils.makeURI(fileLocation);

		this.fModel = null;

		fAllMachines = null;
		fAllInstanceMachines = null;
		fAllStatemachines = null;
		fAllStates = null;
		fAllTransitions = null;

		fAllPorts = null;
		fAllSignals = null;

		fAllBuffers = null;
		fAllVariables = null;
		fAllParameters = null;

		if( USING_IPARSER ) {
			// Injecting an IParser instance
			setupParser();
		}
		else {
			// Using an XtextResourceSet
			setupParserUsingResourceSet();
		}
	}


	private void createCollectors() {
		fAllMachines = new BasicEList<Machine>();
		fAllInstanceMachines = new BasicEList<InstanceMachine>();
		fAllStatemachines = new BasicEList<Statemachine>();
		fAllStates = new BasicEList<Vertex>();
		fAllTransitions = new BasicEList<Transition>();

		fAllPorts = new BasicEList<Port>();
		fAllSignals = new BasicEList<Signal>();

		fAllBuffers = new BasicEList<Buffer>();
		fAllVariables = new BasicEList<Variable>();
		fAllParameters = new BasicEList<Parameter>();
	}


	public boolean parser() {
		try {
			EObject astModel = null;

			if( USING_IPARSER ) {
				// Injecting an IParser instance
				astModel = parse( new FileReader(fModelFileLocation) );
			}
			else {
				// Using an XtextResourceSet
//				astModel = parse( URI.createURI(fModelFileUriLocation) );
				astModel = parse( new FileInputStream(fModelFileLocation) );
			}

			if( astModel instanceof XliaModel ) {
				fModel = (XliaModel) astModel;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();

			return false;
		}
		catch (Exception e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}



	@Inject
	private IQualifiedNameProvider fQualifiedNameProvider;

	///////////////////////////////////////////////////////////////////////////
	// Injecting an IParser instance
	///////////////////////////////////////////////////////////////////////////

	@Inject
	private IParser fFMLParser;

	private void setupParser() {
		Injector injector = Guice.createInjector(new FormalMLRuntimeModule());
//				new FormalMLStandaloneSetup().createInjectorAndDoEMFRegistration();

		injector.injectMembers(this);
	}

	/**
	 * Parses data provided by an input reader using Xtext and returns the root node of the resulting object tree.
	 * @param reader Input reader
	 * @return root object node
	 * @throws IOException when errors occur during the parsing process
	 */
	public EObject parse(Reader reader) throws IOException
	{
		IParseResult result = fFMLParser.parse(reader);
		if(result.hasSyntaxErrors())
		{
			throw new ParseException("Provided input contains syntax errors.");
		}
		return result.getRootASTElement();
	}


	///////////////////////////////////////////////////////////////////////////
	// Using an XtextResourceSet
	///////////////////////////////////////////////////////////////////////////

	@Inject
	private XtextResourceSet fResourceSet;

	private void setupParserUsingResourceSet() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(
				WorkflowFileUtils.PLATFORM_URI);

		Injector injector = Guice.createInjector(new FormalMLRuntimeModule());

		injector.injectMembers(this);

		fResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}

	/**
	 * Parses an input stream and returns the resulting object tree root element.
	 * @param input Input Stream
	 * @return Root model object
	 * @throws IOException When and I/O related parser error occurs
	 */
	public EObject parse(InputStream input) throws IOException
	{
		Resource resource = fResourceSet.createResource(
				URI.createURI("dummy:/inmemory.ext"));

		resource.load(input, fResourceSet.getLoadOptions());

		return resource.getContents().get(0);
	}

	/**
	 * Parses a resource specified by an URI and returns the resulting object tree root element.
	 * @param uri URI of resource to be parsed
	 * @return Root model object
	 */
	public EObject parse(URI uri) {
		Resource resource = fResourceSet.getResource(uri, true);

		return resource.getContents().get(0);
	}

	///////////////////////////////////////////////////////////////////////////
	// Old issue
	///////////////////////////////////////////////////////////////////////////


	public boolean parserOld() {
		try {
			new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(
					WorkflowFileUtils.PLATFORM_URI);

			Injector injector = Guice.createInjector(new FormalMLRuntimeModule());
//					new FormalMLStandaloneSetup().createInjectorAndDoEMFRegistration();

			XtextResourceSet resourceSet =
					injector.getInstance(XtextResourceSet.class);

			resourceSet.addLoadOption(
					XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

			final URI fileURI = URI.createURI(fModelFileUriLocation);
			Resource resource = resourceSet.getResource(fileURI, true);

			EObject model = resource.getContents().get(0);

			if( model instanceof XliaModel ) {
				fModel = (XliaModel) model;
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}


	///////////////////////////////////////////////////////////////////////////
	// Collector for FormalML Elements
	///////////////////////////////////////////////////////////////////////////

	public List<TraceElement> getAllTransitionCoverageElements() {
		List<TraceElement> allTransitionCoverageElement = new ArrayList<TraceElement>();

		collectAllElements(fModel.getSystem());

		for (Transition transition : fAllTransitions) {
			final QualifiedName qualifiedName =
					fQualifiedNameProvider.getFullyQualifiedName(transition);

			final String fqName = qualifiedName.toString();

			allTransitionCoverageElement.add(new TraceElementCustomImpl(
					true, TraceElementKind.TRANSITION, fqName));

//			System.out.println(fqName);
		}

		for (Machine machine : fAllMachines) {
			final QualifiedName qualifiedName =
					fQualifiedNameProvider.getFullyQualifiedName(machine);

			final String fqName = qualifiedName.toString();

			TraceElementKind nature = TraceElementKind.MODEL_MACHINE;
			switch( machine.getDesign() ) {
			case MODEL:
				nature = TraceElementKind.MODEL_MACHINE;
				break;
			case PROTOTYPE:
				nature = TraceElementKind.PROTOTYPE_MACHINE;
				break;
			case INSTANCE:
				nature = TraceElementKind.INSTANCE_MACHINE;
				break;
			default:
				break;
			}
			allTransitionCoverageElement.add(
					new TraceElementCustomImpl(true, nature, fqName));

//			System.out.println(fqName);
		}

		for (Vertex vertex : fAllStates) {
			final QualifiedName qualifiedName =
					fQualifiedNameProvider.getFullyQualifiedName(vertex);

			final String fqName = qualifiedName.toString();

			allTransitionCoverageElement.add(new TraceElementCustomImpl(
					true, TraceElementKind.STATE, fqName));

//			System.out.println(fqName);
		}

		for (InstanceMachine instance : fAllInstanceMachines) {
			final QualifiedName qualifiedName =
					fQualifiedNameProvider.getFullyQualifiedName(instance);

			final String fqName = qualifiedName.toString();

			allTransitionCoverageElement.add(new TraceElementCustomImpl(
					true, TraceElementKind.INSTANCE_MACHINE, fqName));

//			System.out.println(fqName);
		}

		return allTransitionCoverageElement;
	}

	private void collectAllElements(
			org.eclipse.efm.ecore.formalml.infrastructure.System system)
	{
		if( (this.fModel == null) || (fAllMachines == null) )
		{
			createCollectors();

			collectAllElements((Machine) system);
		}
	}

	private void collectAllElements(Machine machine) {
		if( (machine == null) )
//			|| (machine.getDesign() == DesignKind.MODEL) )
		{
			return;
		}
		if( machine instanceof Statemachine ) {
			final Statemachine statemachine = (Statemachine) machine;

//			collectAllElements(statemachine);

			fAllStatemachines.add(statemachine);
			fAllParameters.addAll(statemachine.getParameter());

			for (Region region : ((Statemachine) machine).getRegion()) {
				collectAllElements(region);
			}
		}

		fAllMachines.addAll(machine.getMachine());
		fAllInstanceMachines.addAll(machine.getInstance());

		fAllPorts.addAll(machine.getPort());
		fAllSignals.addAll(machine.getSignal());
		fAllBuffers.addAll(machine.getBuffer());

		fAllVariables.addAll(machine.getVariable());

		for( Machine itMachine : machine.getMachine() ) {
			collectAllElements(itMachine);
		}

//		for( InstanceMachine instance : machine.getInstance() ) {
//			collectAllElements(instance.getModel());
//		}

		for( Behavior behavior : machine.getBehavior() ) {
			collectAllElements(behavior);
		}

		collectAllElements(machine.getMain());
	}


//	private void collectAllElements(Statemachine statemachine) {
////		collectAllElements((Machine) statemachine, allTransitions);
//
//		for (Region region : statemachine.getRegion()) {
//			collectAllElements(region, allTransitions);
//		}
//	}


	private void collectAllElements(Region region) {
		fAllStates.addAll(region.getVertex());

		for (Vertex vertex : region.getVertex()) {
			collectAllElements(vertex);
		}
	}

	private void collectAllElements(Vertex vertex) {
		fAllTransitions.addAll(vertex.getTransition());

		if( vertex instanceof State ) {
			//			collectAllElements((State) vertex);

			for (Region region : ((State) vertex).getRegion()) {
				collectAllElements(region);
			}
		}
	}

//	private void collectAllElements(State state) {
////		collectAllElements((Vertex) state);
//
//		for (Region region : state.getRegion()) {
//			collectAllElements(region);
//		}
//	}

}
