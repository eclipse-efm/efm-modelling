/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.test;

import java.util.Random;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccChannel;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia.Generator;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia.MoCC2XLIA;

public class Mocc2XliaTest {

	/*
	 * TESTS
	 */
	protected static MoccSystem mocc_model_1()
	{
		final MoccSystem moccSystem = new MoccSystem("test_mocc_1");

		return moccSystem;
	}

	protected static MoccSystem mocc_model_fusion_1()
	{
		final MoccSystem moccSystem = new MoccSystem("FusionSampleDeadlock");

		// Actors
		final MoccActor display = new MoccActor(moccSystem, "Display", 40);

		final MoccActor fusion = new MoccActor(moccSystem, "Fusion");

		final MoccActor radar = new MoccActor(moccSystem, "Radar", 120);

		final MoccActor camera = new MoccActor(moccSystem, "Camera", 30);

		final MoccActor lidar = new MoccActor(moccSystem, "Lidar", 10);

		// Channels
		moccSystem.addChannel(false, camera, 1, fusion, 1);

		moccSystem.addChannel(false, radar, 1, 4, fusion, 1);
//		moccSystem.addChannel(false, 3, 4,/*initial token*/ radar, 1, 4, fusion, 1);

		moccSystem.addChannel(false, lidar, 1, fusion, 1, 3);

		moccSystem.addChannel(false, fusion, 4, 3, display, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_fusion_2()
	{
		final MoccSystem moccSystem = new MoccSystem("FusionSampleLiveness");

		// Actors
		final MoccActor display = new MoccActor(moccSystem, "Display", 40, 2);

		final MoccActor fusion = new MoccActor(moccSystem, "Fusion");

		final MoccActor radar = new MoccActor(moccSystem, "Radar", 120);

		final MoccActor camera = new MoccActor(moccSystem, "Camera", 30);

		final MoccActor lidar = new MoccActor(moccSystem, "Lidar", 10);

		// Channels
		moccSystem.addChannel(false, camera, 1, fusion, 1);

		moccSystem.addChannel(false, 3, 4,/*initial token*/ radar, 1, 4, fusion, 1);

		moccSystem.addChannel(false, lidar, 1, fusion, 1, 3);

		moccSystem.addChannel(false, fusion, 4, 3, display, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_basic_1()
	{
		final MoccSystem moccSystem = new MoccSystem("Basic_A_B");

		// Actors
		final MoccActor B = new MoccActor(moccSystem, "B");

		final MoccActor A = new MoccActor(moccSystem, "A");

		// Channels
		moccSystem.addChannel(false, A, 2, B, 3);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_cyclic_1()
	{
		final MoccSystem moccSystem = new MoccSystem("Cyclic");

		// Actors
		final MoccActor B = new MoccActor(moccSystem, "B");

		final MoccActor A = new MoccActor(moccSystem, "A");

		// Channels
		moccSystem.addChannel(false, A, 3, B, 2);

		moccSystem.addChannel(false, 4,/*initial token*/ B, 2, A, 3);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_basic_2()
	{
		final MoccSystem moccSystem = new MoccSystem("Basic_A_B_C");

		// Actors
		final MoccActor A = new MoccActor(moccSystem, "A");

		final MoccActor B = new MoccActor(moccSystem, "B");

		final MoccActor C = new MoccActor(moccSystem, "C");

		// Channels
		moccSystem.addChannel(false, A, 1, B, 1);

		moccSystem.addChannel(false, A, 2, C, 1);

		moccSystem.addChannel(false, B, 2, C, 1);

		return moccSystem;
	}


	public static MoccSystem mocc_model_adas() {
		final MoccSystem moccSystem = new MoccSystem("ADAS");

		// Actors
		final MoccActor Odometer =
				new MoccActor(moccSystem, "Odometer", 10);
		final MoccActor OdometerDuplicate =
				new MoccActor(moccSystem, "OdometerDuplicate");

		final MoccActor LeftCamera =
				new MoccActor(moccSystem, "LeftCamera", 10);
		final MoccActor LeftCameraDuplicate =
				new MoccActor(moccSystem, "LeftCameraDuplicate");

		final MoccActor RightCamera =
				new MoccActor(moccSystem, "RightCamera", 10);

		final MoccActor Lidar =
				new MoccActor(moccSystem, "Lidar", 30);

		final MoccActor Speed =
				new MoccActor(moccSystem, "Speed");

		final MoccActor SpeedDuplicate =
				new MoccActor(moccSystem, "SpeedDuplicate");

		final MoccActor LaneDetection =
				new MoccActor(moccSystem, "LaneDetection");
		final MoccActor PedestrianDetection =
				new MoccActor(moccSystem, "PedestrianDetection");
		final MoccActor RoadDetection =
				new MoccActor(moccSystem, "RoadDetection", 5);
		final MoccActor TrafficSignDetection =
				new MoccActor(moccSystem, "TrafficSignDetection");
		final MoccActor TrafficSignDetectionDuplicate =
				new MoccActor(moccSystem, "TrafficSignDetectionDuplicate");
		final MoccActor DepthMap =
				new MoccActor(moccSystem, "DepthMap", 2);

		final MoccActor ObstacleDetection =
				new MoccActor(moccSystem, "ObstacleDetection");

		final MoccActor SpeedControl =
				new MoccActor(moccSystem, "SpeedControl");

		final MoccActor Fusion =
				new MoccActor(moccSystem, "Fusion");

		final MoccActor InformationDisplay =
				new MoccActor(moccSystem, "InformationDisplay", 10);

		// Channels
		moccSystem.addChannel(false, LeftCamera, 1, LeftCameraDuplicate, 1);

		moccSystem.addChannel(false, LeftCameraDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(false, LeftCameraDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(false, 1, 2, LeftCameraDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(false, LeftCameraDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(false, 4, 5, LeftCameraDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(false, LeftCameraDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(false, Odometer, 1, OdometerDuplicate, 1);

		moccSystem.addChannel(false, OdometerDuplicate, 1, InformationDisplay, 1);

		moccSystem.addChannel(false, OdometerDuplicate, 1, Speed, 1);

		moccSystem.addChannel(false, OdometerDuplicate, 1, SpeedControl, 1);


		moccSystem.addChannel(false, 4, 5, RightCamera, 1, 5, DepthMap, 1);


		moccSystem.addChannel(false, Lidar, 1, ObstacleDetection, 1);


		moccSystem.addChannel(false, 2, 3, ObstacleDetection, 1, 3, SpeedControl, 1);


		moccSystem.addChannel(false, SpeedControl, 1, InformationDisplay, 1);


		moccSystem.addChannel(false, Speed, 1, SpeedDuplicate, 1);

		moccSystem.addChannel(false, SpeedDuplicate, 1, RightCamera, 1);

		moccSystem.addChannel(false, SpeedDuplicate, 1, Lidar, 1, 3);

		moccSystem.addChannel(false, SpeedDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(false, SpeedDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(false, 1, 2, SpeedDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(false, SpeedDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(false, 4, 5, SpeedDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(false, SpeedDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(false, LaneDetection, 1, InformationDisplay, 1);


		moccSystem.addChannel(false,
				TrafficSignDetection, 1, TrafficSignDetectionDuplicate, 1);

		moccSystem.addChannel(false,
				TrafficSignDetectionDuplicate, 1, SpeedControl, 1);

		moccSystem.addChannel(false,
				TrafficSignDetectionDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(false, PedestrianDetection, 1, Fusion, 1);

		moccSystem.addChannel(false, RoadDetection, 1, Fusion, 1, 2);

		moccSystem.addChannel(false, DepthMap, 1, Fusion, 1, 5);


		moccSystem.addChannel(false, Fusion, 1, InformationDisplay, 1);

		return moccSystem;
	}


	public static void testTransformations(
			IPath path, final MoccSystem moccSystem)
	{
		final String message = "MoCC --> xLIA : " + moccSystem.getName();
		System.out.println(message + "...");

		final MoCC2XLIA moccGenerator = new MoCC2XLIA(true, false);

		final XliaModel xliaModel = moccGenerator.transformSystem(moccSystem);

		System.out.println(message + " OK transformation");

		path = path.append("gen_mocc-" + moccSystem.getName())
					.addFileExtension("xlia");

		if( xliaModel != null ) {
			Generator.write(path, moccSystem, xliaModel);
		}
		else {
			Generator.write(path, moccSystem);
		}

		System.out.println(message + " OK generation");
	}


	public static void testTransformations(final IPath path)
	{
//		testTransformations(path, mocc_model_basic_mode());
//		testTransformations(path, mocc_model_automotive());

		testTransformations(path, mocc_model_adas());
//		testTransformations(path, mocc_model_adas_mode());

//		testTransformations(path, mocc_model_fusion_1());
//		testTransformations(path, mocc_model_fusion_2());
//
//		testTransformations(path, mocc_model_basic_1());
//		testTransformations(path, mocc_model_basic_2());
//
//		testTransformations(path, mocc_model_cyclic_1());
//
//		testTransformations(path, mocc_model_sdfg_1());

		// MUTATION
//		mutation(path);
	}



	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	// MUTATION

	public static void mutation(final IPath path) {
		System.out.println("MoCC --> ADAS -- MUTATION --> xLIA ...");

		final int mutationCount = 10;

		int mutationActorCount = 0;
		int mutationActorConsistentCount = 0;
		int mutationChannelCount = 0;
		int mutationChannelConsistentCount = 0;

		int mutationConsistentCount = 0;

		final Random random = new Random();

		MoccSystem moccSystem;

		boolean isActorMutation;

		for (int index = 0; index < mutationCount; index++) {
			if( isActorMutation = random.nextBoolean() ) {
				++mutationActorCount;

				moccSystem = mutationActor(random);
			}
			else {
				++mutationChannelCount;

				moccSystem = mutationChannel(random);
			}

			final MoCC2XLIA moccGenerator = new MoCC2XLIA(true, false);

			final XliaModel xliaModel = moccGenerator.transformSystem(moccSystem);

			if( xliaModel != null ) {
				++mutationConsistentCount;

				if( isActorMutation ) {
					++mutationActorConsistentCount;
				}
				else {
					++mutationChannelConsistentCount;
				}

				final String filename = "gen_mocc-" + moccSystem.getName()
						+ "_" + (isActorMutation ? "a" : "c")
						+ mutationConsistentCount;
				final IPath filePath =
						path.append(filename).addFileExtension("xlia");

				Generator.write(filePath, moccSystem, xliaModel);
			}
			else {

			}
		}
		System.out.println("MoCC --> ADAS -- MUTATION --> xLIA : report");
		System.out.println("mutation : "
				+ mutationConsistentCount + " / " + mutationCount);
		System.out.println("Actor    : "
				+ mutationActorConsistentCount + " / " + mutationActorCount);
		System.out.println("Channel  : "
				+ mutationChannelConsistentCount + " / " + mutationChannelCount);
		System.out.println("==========================================");
	}


	public static MoccSystem mutationActor(final Random random) {
		final MoccSystem moccSystem = mocc_model_adas();

		final int actorCount = moccSystem.getActor().size();

		while( true ) {
			final MoccActor actor =
					moccSystem.getActor().get( random.nextInt(actorCount - 1) );

			if( actor.isTimed() ) {
				if( random.nextBoolean() ) {
					mutationActorFrequency(random, actor);
				}
				else {
					mutationActorPhase(random, actor);
				}
				return moccSystem;
			}
		}
	}

	private static void mutationActorFrequency(
			final Random random, final MoccActor actor) {
		int randValue = 0;
		do {
			randValue = 1 + random.nextInt(100);
			if( randValue != actor.frequency ) {
				actor.frequency = randValue;
				break;
			}
		}
		while( true );
	}

	private static void mutationActorPhase(
			final Random random, final MoccActor actor) {
		int randValue = 0;
		do {
			randValue = 1 + random.nextInt(10);
				//actor.getSystem().FEATURE.tick_period / actor.getFrequency());
			if( randValue != actor.phase ) {
				actor.phase = randValue;
				break;
			}
		}
		while( true );
	}


	public static MoccSystem mutationChannel(final Random random) {
		final MoccSystem moccSystem = mocc_model_adas();

		final int channelCount = moccSystem.getChannel().size();
		final MoccChannel channel =
				moccSystem.getChannel().get(random.nextInt(channelCount - 1));
		switch( random.nextInt(3) ) {
		case 0:
			mutationChannelInput(random, channel);
			break;
		case 1:
			mutationChannelInitial(random, channel);
			break;
		case 2:
			mutationChannelOutput(random, channel);
			break;

		default:
			break;
		}
		return moccSystem;
	}

	private static void mutationChannelInput(
			final Random random, final MoccChannel channel)
	{
		int randValue = 0;
		do {
			randValue = 1 + random.nextInt(10);
			if( randValue != channel.getInputPort().rate ) {
				channel.getInputPort().rate = randValue;
				break;
			}
		}
		while( true );
	}

	private static void mutationChannelInitial(
			final Random random, final MoccChannel channel)
	{
		int randValue = 0;
		do {
			randValue = 1 + random.nextInt(10);
			if( randValue != channel.initialRate ) {
				channel.initialRate = randValue;
				break;
			}
		}
		while( true );
	}

	private static void mutationChannelOutput(
			final Random random, final MoccChannel channel)
	{
		int randValue = 0;
		do {
			randValue = 1 + random.nextInt(10);
			if( randValue != channel.getOutputPort().rate ) {
				channel.getOutputPort().rate = randValue;
				break;
			}
		}
		while( true );
	}


}
