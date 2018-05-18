package org.eclipse.efm.execution.core.workflow.inference;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.IWorkflowSpiderConfigurationUtils;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.common.CheckingScopeKind;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.execution.core.workflow.coverage.impl.BehaviorCoverageWorkerImpl;

public class InferenceContractWorkerCustomImpl extends BehaviorCoverageWorkerImpl//WorkerImpl
		implements IWorkflowConfigurationConstants , IWorkflowSpiderConfigurationUtils {

	protected static final String OUTPUT_CONTRACT_FILE_EDEFAULT = null;
	protected String outputFile = OUTPUT_CONTRACT_FILE_EDEFAULT;

	protected InferenceContractWorkerCustomImpl(Director director, String name) {
		super();

		setDirector(director);
		setName(name);
	}

	protected InferenceContractWorkerCustomImpl(
			Director director, String name, String description) {
		super();

		setDirector(director);
		setName(name);
		setDescription(description);
	}


	public String getOutputFile() {
		return outputFile;
	}



	public void setOutputFile(String newOutputFile) {
//		String oldOutputFile = outputFile;
		outputFile = newOutputFile;

	}

	public void setHeuristicConfiguration(
			ILaunchConfiguration configuration) {
		int intValue;

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_HEIGHT, 3);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 3;
		}
		setJumpHeight( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_TRIALS_LIMIT, -1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = -1;
		}
		setJumpTrialsLimit( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		setHitCount( intValue );

		try {
			intValue = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_COUNT, 1);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			intValue = 1;
		}
		setJumpCount( intValue );
	}

	public static InferenceContractWorkerCustomImpl create(
			Director director, ILaunchConfiguration configuration) {

		InferenceContractWorkerCustomImpl coverageWorker =
				new InferenceContractWorkerCustomImpl(
						director, "Functions_Contracts_Inference");

//		coverageWorker.setManifest( ManifestCustomImpl.create(true) );

		boolean isEnabled;

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_STOP, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setStopWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SLICE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setSliceWhenComplete(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HEURISTIC, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHeuristicEnabled(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SEARCH_SCOPE_LOCALLY, false);
		}
		catch( CoreException e1 ) {
			e1.printStackTrace();
			isEnabled = false;
		}
		coverageWorker.setCheckingScope( isEnabled ?
				CheckingScopeKind.LOCALLY : CheckingScopeKind.GLOBALLY );

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_SCHEDULER_ORDERED, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setOrderedTrace( isEnabled );

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_CONSECUTIVE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitConsecutive(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_FOLDING, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitFolding(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_LUCKY, false);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = false;
		}
		coverageWorker.setHitLucky(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_HIT_MAX, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setHitMax(isEnabled);

		try {
			isEnabled = configuration.getAttribute(
					ATTR_BEHAVIOR_SELECTION_HOJ_JUMP_SLICE, true);
		}
		catch( CoreException e ) {
			e.printStackTrace();
			isEnabled = true;
		}
		coverageWorker.setJumpSlice(isEnabled);


		coverageWorker.setHeuristicConfiguration(configuration);


		TraceSpecificationCustomImpl trace = TraceSpecificationCustomImpl.create(
				"trace", configuration, ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST,
				TraceElementKind.UNDEFINED);

		coverageWorker.setTrace( trace );

		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(
						DEFAULT_COVERAGE_FORMAT,
						DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT,
						DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT);


		coverageWorker.setConsole( console );


		String outputFile;
		try {
			outputFile = configuration.getAttribute(
					ATTR_INFERENCE_OUTPUT_FILE_NAME, "");
		}
		catch( CoreException e ) {
			e.printStackTrace();

			outputFile = null;
		}
		if( (outputFile != null) && (! outputFile.isEmpty()) ) {
			coverageWorker.setOutputFile(outputFile);
		}

		return( coverageWorker );
	}






		public void toWriter(PrettyPrintWriter writer) {
			writer.commentLine( getComment() );

			writer.appendTab( "Functions_Contracts_Inference" );

			String str = getName();
			if( str != null ) {
				writer.append( ' ' ).append( str );
			}
			str = getDescription();
			if( str != null ) {
				writer.append( " \'" ).append( str ).append( "\'" );
			}

			writer.appendEol( " {" );

			PrettyPrintWriter writer2 = writer.itab2();

			ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
			if( manifest != null ) {
				manifest.toWriter(writer2);
			}


			writer.appendTab2Eol( "type_c_mapping [" )
				.appendTab3Eol( "integer = \"uint32_t\"" )
				.appendTab3Eol( "uinteger = \"uint16_t\"" )
				//.appendTab3Eol( "ptr_uint8_t = \"uint8_t *\"" )
				//.appendTab3Eol( "ptr_uint32_t  = \"uint32_t *\"" )
				.appendTab3Eol( "bool = \"int\"" )
				.appendTab2Eol( "] // end type_c_mapping" );


			writer.appendTab2Eol( "table [" )
				//.appendTab3Eol( "typeparams = \"globalTypeParamCalls\"" )
				.appendTab3Eol( "signature  = \"AllSignatures\"" )
				.appendTab3Eol( "variable  = \"AllCallsStack\"" )
				.appendTab2Eol( "] // end table" );


			writer.appendTab2Eol( "vfs [" )
				.appendTab3Eol( "folder = \"Inferred constraints\"" );
//			writer.appendTab3Eol( "file#1   = \"acslSpec.h\"" );
//			.appendTab3Eol( "file#2   = \"acslSpec.c\"" )
//			.appendTab2Eol( "] // end vfs" );

			if( (str = getOutputFile()) != null ) {
				writer.appendTab3( "file#2 = \"" )
					.append( str ).appendEol("\"");
			}
			else {
				writer.appendTab3( "file#2 = \"acslSpec.c\"" );
			}

			writer.appendTab2Eol( "] // end vfs" );



//			ConsoleLogFormatCustomImpl console =
//					(ConsoleLogFormatCustomImpl) getConsole();
//			if( console != null ) {
//				console.toWriter( writer2 );
//			}

			writer.appendTabEol( "}" );


			// add coverage behavior worker
			writer.appendTab( "coverage#behavior" );

			writer.appendEol( " {" );



			writer.appendTab2Eol( "property [" );
			writer.appendTab3( "stop  = " ).appendEol( isStopWhenComplete() );

			writer.appendTab3( "slice = " ).appendEol( isSliceWhenComplete() );

			writer.appendTab3( "heuristic = " ).appendEol( isHeuristicEnabled() );

			writer.appendTab3( "scope = '" )
				.append( getCheckingScope().getLiteral() )
				.appendEol( "'" );

			writer.appendTab3( "scheduler = " )
				.appendEol( isOrderedTrace() ? "'|;|'" : "'|i|'" );

			writer.appendTab2Eol( "] // end property" );


			writer.appendTab2Eol( "heuristic [" );

			if( isOrderedTrace() ) {
				writer.appendTab3( "hit#consecutive = " )
					.appendEol( isHitConsecutive() );
			}

			writer.appendTab3( "hit#folding = " ).appendEol( isHitFolding() );

			writer.appendTab3( "hit#lucky   = " ).appendEol( isHitLucky() );

			writer.appendTab3( "hit#max     = " ).appendEol( isHitMax() );

			writer.appendTab3( "jump#slice  = " ).appendEol( isJumpSlice() );

			writer.appendTab3( "jump#height = " ).appendEol( getJumpHeight() );

			writer.appendTab3( "jump#trials#limit = " )
				.appendEol( getJumpTrialsLimit() );

			writer.appendTab3( "hit#count  = " ).appendEol( getHitCount() );

			writer.appendTab3( "jump#count = " ).appendEol( getJumpCount() );

			writer.appendTab2Eol( "] // end heuristic" );


			TraceSpecificationCustomImpl trace =
					(TraceSpecificationCustomImpl) getTrace();
			if( trace != null ) {
				trace.toWriter(writer2);
			}

			ConsoleLogFormatCustomImpl console =
					(ConsoleLogFormatCustomImpl) getConsole();
			if( console != null ) {
				console.toWriter( writer2 );
			}

			writer.appendTabEol( "}" );
		}




}
