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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.formalml.ecore.factory.XLIAGenerator;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccMode;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia.MoCC2XLIA;

public class MoccCodeGeneratorTest {

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
		moccSystem.addChannel(camera, 1, fusion, 1);

		moccSystem.addChannel(radar, 1, 4, fusion, 1);
//		moccSystem.addChannel(3, 4,/*initial token*/ radar, 1, 4, fusion, 1);

		moccSystem.addChannel(lidar, 1, fusion, 1, 3);

		moccSystem.addChannel(fusion, 4, 3, display, 1);

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
		moccSystem.addChannel(camera, 1, fusion, 1);

		moccSystem.addChannel(3, 4,/*initial token*/ radar, 1, 4, fusion, 1);

		moccSystem.addChannel(lidar, 1, fusion, 1, 3);

		moccSystem.addChannel(fusion, 4, 3, display, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_basic_1()
	{
		final MoccSystem moccSystem = new MoccSystem("Basic_A_B");

		// Actors
		final MoccActor B = new MoccActor(moccSystem, "B");

		final MoccActor A = new MoccActor(moccSystem, "A");

		// Channels
		moccSystem.addChannel(A, 2, B, 3);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_cyclic_1()
	{
		final MoccSystem moccSystem = new MoccSystem("Cyclic");

		// Actors
		final MoccActor B = new MoccActor(moccSystem, "B");

		final MoccActor A = new MoccActor(moccSystem, "A");

		// Channels
		moccSystem.addChannel(A, 3, B, 2);

		moccSystem.addChannel(4,/*initial token*/ B, 2, A, 3);

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
		moccSystem.addChannel(A, 1, B, 1);

		moccSystem.addChannel(A, 2, C, 1);

		moccSystem.addChannel(B, 2, C, 1);

		return moccSystem;
	}


	protected static MoccSystem mocc_model_adas_noninit() {
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
		moccSystem.addChannel(LeftCamera, 1, LeftCameraDuplicate, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(Odometer, 1, OdometerDuplicate, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, InformationDisplay, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, Speed, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, SpeedControl, 1);


		moccSystem.addChannel(RightCamera, 1, 5, DepthMap, 1);


		moccSystem.addChannel(Lidar, 1, ObstacleDetection, 1);


		moccSystem.addChannel(ObstacleDetection, 1, 3, SpeedControl, 1);


		moccSystem.addChannel(SpeedControl, 1, InformationDisplay, 1);


		moccSystem.addChannel(Speed, 1, SpeedDuplicate, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, RightCamera, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, Lidar, 1, 3);

		moccSystem.addChannel(SpeedDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(LaneDetection, 1, InformationDisplay, 1);


		moccSystem.addChannel(
				TrafficSignDetection, 1, TrafficSignDetectionDuplicate, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, SpeedControl, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(PedestrianDetection, 1, Fusion, 1);

		moccSystem.addChannel(RoadDetection, 1, Fusion, 1, 2);

		moccSystem.addChannel(DepthMap, 1, Fusion, 1, 5);


		moccSystem.addChannel(Fusion, 1, InformationDisplay, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_adas_init() {
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
		moccSystem.addChannel(LeftCamera, 1, LeftCameraDuplicate, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, LeftCameraDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, LeftCameraDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(Odometer, 1, OdometerDuplicate, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, InformationDisplay, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, Speed, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, SpeedControl, 1);


		moccSystem.addChannel(4, 5, RightCamera, 1, 5, DepthMap, 1);


		moccSystem.addChannel(Lidar, 1, ObstacleDetection, 1);


		moccSystem.addChannel(2, 3, ObstacleDetection, 1, 3, SpeedControl, 1);


		moccSystem.addChannel(SpeedControl, 1, InformationDisplay, 1);


		moccSystem.addChannel(Speed, 1, SpeedDuplicate, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, RightCamera, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, Lidar, 1, 3);

		moccSystem.addChannel(SpeedDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, SpeedDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, SpeedDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(LaneDetection, 1, InformationDisplay, 1);


		moccSystem.addChannel(
				TrafficSignDetection, 1, TrafficSignDetectionDuplicate, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, SpeedControl, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(PedestrianDetection, 1, Fusion, 1);

		moccSystem.addChannel(RoadDetection, 1, Fusion, 1, 2);

		moccSystem.addChannel(DepthMap, 1, Fusion, 1, 5);


		moccSystem.addChannel(Fusion, 1, InformationDisplay, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_adas() {
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
		moccSystem.addChannel(LeftCamera, 1, LeftCameraDuplicate, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, LeftCameraDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, LeftCameraDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(Odometer, 1, OdometerDuplicate, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, InformationDisplay, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, Speed, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, SpeedControl, 1);


		moccSystem.addChannel(4, 5, RightCamera, 1, 5, DepthMap, 1);


		moccSystem.addChannel(Lidar, 1, ObstacleDetection, 1);


		moccSystem.addChannel(2, 3, ObstacleDetection, 1, 3, SpeedControl, 1);


		moccSystem.addChannel(SpeedControl, 1, InformationDisplay, 1);


		moccSystem.addChannel(Speed, 1, SpeedDuplicate, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, RightCamera, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, Lidar, 1, 3);

		moccSystem.addChannel(SpeedDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, SpeedDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, SpeedDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(LaneDetection, 1, InformationDisplay, 1);


		moccSystem.addChannel(
				TrafficSignDetection, 1, TrafficSignDetectionDuplicate, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, SpeedControl, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(PedestrianDetection, 1, Fusion, 1);

		moccSystem.addChannel(RoadDetection, 1, Fusion, 1, 2);

		moccSystem.addChannel(DepthMap, 1, Fusion, 1, 5);


		moccSystem.addChannel(Fusion, 1, InformationDisplay, 1);

		return moccSystem;
	}

	protected static MoccSystem mocc_model_adas_mode() {
		final MoccSystem moccSystem = new MoccSystem("ADAS_FULL",
				"UndefinedMode", "UndefinedMode", "NominalMode", "NominalMode");

		// Actors
		final MoccActor Odometer =
				new MoccActor(moccSystem, "Odometer", 10);
		final MoccActor OdometerDuplicate =
				new MoccActor(moccSystem, "OdometerDuplicate");

		final MoccActor LeftCamera =
				new MoccActor(moccSystem, "LeftCamera", 10);
		final MoccActor LeftCameraDuplicate =
				new MoccActor(moccSystem, "LeftCameraDuplicate");

		final MoccMode mode_low_speed =
				moccSystem.newMode("s <= 30 km/h", "Low_Speed");//"LOW_SPEED");
		final MoccMode mode_medium_speed =
				moccSystem.newMode("30 < s <= 50 km/h", "Medium_Speed");//"MEDIUM_SPEED");
		final MoccMode mode_high_speed =
				moccSystem.newMode("s > 50 km/h", "High_Speed");//"HIGH_SPEED");

		final MoccMode[] selectionSet = new MoccMode[] {
//				MoccMode.UNDEFINED , MoccMode.NOMINAL,
				mode_low_speed , mode_medium_speed , mode_high_speed };

		final MoccMode[] processingSet_0_1_2 = new MoccMode[] {
				mode_low_speed , mode_medium_speed , mode_high_speed };

		final MoccMode[] processingSet_0_1 =
				new MoccMode[] { mode_low_speed , mode_medium_speed };

		final MoccMode[] processingSet_1_2 =
				new MoccMode[] { mode_medium_speed , mode_high_speed };

		final MoccMode[] processingSet_2 = new MoccMode[] { mode_high_speed };

		final MoccActor Speed = new MoccActor(moccSystem, "Speed", selectionSet);


		final MoccActor RightCamera =
				new MoccActor(moccSystem, "RightCamera", 10,
						Speed, processingSet_0_1);

		final MoccActor Lidar =
				new MoccActor(moccSystem, "Lidar", 30,
						Speed, processingSet_0_1);


		final MoccActor SpeedDuplicate =
				new MoccActor(moccSystem, "SpeedDuplicate",
						Speed, processingSet_0_1_2);

		final MoccActor LaneDetection =
				new MoccActor(moccSystem, "LaneDetection",
						Speed, processingSet_2);
		final MoccActor PedestrianDetection =
				new MoccActor(moccSystem, "PedestrianDetection",
						Speed, processingSet_0_1);
		final MoccActor RoadDetection =
				new MoccActor(moccSystem, "RoadDetection", 5,
						Speed, processingSet_0_1);
		final MoccActor TrafficSignDetection =
				new MoccActor(moccSystem, "TrafficSignDetection",
						Speed, processingSet_1_2);
		final MoccActor TrafficSignDetectionDuplicate =
				new MoccActor(moccSystem, "TrafficSignDetectionDuplicate",
						Speed, processingSet_1_2);
		final MoccActor DepthMap =
				new MoccActor(moccSystem, "DepthMap", 2,
						Speed, processingSet_0_1);

		final MoccActor ObstacleDetection =
				new MoccActor(moccSystem, "ObstacleDetection",
						Speed, processingSet_0_1);

		final MoccActor SpeedControl =
				new MoccActor(moccSystem, "SpeedControl");

		final MoccActor Fusion =
				new MoccActor(moccSystem, "Fusion",
						Speed, processingSet_0_1);

		final MoccActor InformationDisplay =
				new MoccActor(moccSystem, "InformationDisplay", 10);

		// Channels
		moccSystem.addChannel(LeftCamera, 1, LeftCameraDuplicate, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, LeftCameraDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, LeftCameraDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(LeftCameraDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(Odometer, 1, OdometerDuplicate, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, InformationDisplay, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, Speed, 1);

		moccSystem.addChannel(OdometerDuplicate, 1, SpeedControl, 1);


		moccSystem.addChannel(4, 5, RightCamera, 1, 5, DepthMap, 1);


		moccSystem.addChannel(Lidar, 1, ObstacleDetection, 1);


		moccSystem.addChannel(2, 3, ObstacleDetection, 1, 3, SpeedControl, 1);


		moccSystem.addChannel(SpeedControl, 1, InformationDisplay, 1);


		moccSystem.addChannel(Speed, 1, SpeedDuplicate, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, RightCamera, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, Lidar, 1, 3);

		moccSystem.addChannel(SpeedDuplicate, 1, LaneDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, PedestrianDetection, 1);

		moccSystem.addChannel(1, 2, SpeedDuplicate, 1, 2, RoadDetection, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, TrafficSignDetection, 1);

		moccSystem.addChannel(4, 5, SpeedDuplicate, 1, 5, DepthMap, 1);

		moccSystem.addChannel(SpeedDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(LaneDetection, 1, InformationDisplay, 1);


		moccSystem.addChannel(
				TrafficSignDetection, 1, TrafficSignDetectionDuplicate, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, SpeedControl, 1);

		moccSystem.addChannel(
				TrafficSignDetectionDuplicate, 1, InformationDisplay, 1);


		moccSystem.addChannel(PedestrianDetection, 1, Fusion, 1);

		moccSystem.addChannel(RoadDetection, 1, Fusion, 1, 2);

		moccSystem.addChannel(DepthMap, 1, Fusion, 1, 5);


		moccSystem.addChannel(Fusion, 1, InformationDisplay, 1);

		return moccSystem;
	}


	protected static MoccSystem mocc_model_basic_mode() {
		final MoccSystem moccSystem = new MoccSystem("BasicMode");

		// Actors
		final MoccActor Acquisition =
				new MoccActor(moccSystem, "Acquisition", 50);

		final MoccActor AcquisitionDuplicate =
				new MoccActor(moccSystem, "AcquisitionDuplicate");

		final MoccMode mode_lowQ =
				moccSystem.newMode("Low Qualitity", "LOW_QUALITITY");
		final MoccMode mode_highQ =
				moccSystem.newMode("High Qualitity", "HIGH_QUALITITY");

		final MoccMode[] selectionSet =
				new MoccMode[] {
//						MoccMode.UNDEFINED , MoccMode.NOMINAL,
						mode_lowQ , mode_highQ };

		final MoccMode[] processingSet_lowQ = new MoccMode[] { mode_lowQ };

		final MoccMode[] processingSet_highQ = new MoccMode[] { mode_highQ };

		final MoccActor QualityMode =
				new MoccActor(moccSystem, "QualityMode", 50, selectionSet);

		final MoccActor FastProcess = new MoccActor(moccSystem,
				"FastProcess", QualityMode, processingSet_lowQ );

		final MoccActor HighQualitityProcess = new MoccActor(moccSystem,
				"HighQualitityProcess", QualityMode, processingSet_highQ );

		final MoccActor Command = new MoccActor(moccSystem, "Command", 25, 1);

		// Channels
		moccSystem.addChannel(Acquisition, 1, AcquisitionDuplicate, 1);

		moccSystem.addChannel(AcquisitionDuplicate, 1, FastProcess, 2);
		moccSystem.addChannel(AcquisitionDuplicate, 1, HighQualitityProcess, 2);

		moccSystem.addChannel(QualityMode, 1, FastProcess, 2);
		moccSystem.addChannel(QualityMode, 1, HighQualitityProcess, 2);

		moccSystem.addChannel(FastProcess, 1, Command, 1);
		moccSystem.addChannel(HighQualitityProcess, 1, Command, 1);
		moccSystem.addChannel(2, Command, 2, Acquisition, 1);

		return moccSystem;
	}


	protected static MoccSystem mocc_model_automotive() {
		final MoccSystem moccSystem = new MoccSystem("Automotive");

		// Actors
		final MoccMode mode_allSensors =
				moccSystem.newMode("All sensors", "ALL_SENSORS");
		final MoccMode mode_sensor_1_2 =
				moccSystem.newMode("Sensor 1 & 2 ", "SENSOR_1_2");
		final MoccMode mode_sensor_3 =
				moccSystem.newMode("Sensor 3 ", "SENSOR_3");
		final MoccMode mode_noSensor =
				moccSystem.newMode("No sensor", "NO_SENSOR");

		final MoccMode[] selectionSet =
				new MoccMode[] {
//						MoccMode.UNDEFINED , MoccMode.NOMINAL,
						mode_allSensors , mode_sensor_1_2,
						mode_sensor_3, mode_noSensor };

		final MoccMode[] processingSet_allSensor_1_2 =
				new MoccMode[] { mode_allSensors , mode_sensor_1_2 };

		final MoccMode[] processingSet_allSensor_3 =
				new MoccMode[] { mode_allSensors , mode_sensor_3 };

		final MoccMode[] processingSet_allSensor_1_2_3 = new MoccMode[] {
				mode_allSensors , mode_sensor_1_2, mode_sensor_3 };


		final MoccActor Monitor =
				new MoccActor(moccSystem, "Monitor", 3, selectionSet);

		final MoccActor Sensor_1 = new MoccActor(moccSystem,
				"Sensor_1", 6, Monitor, processingSet_allSensor_1_2);

		final MoccActor Sensor_2 = new MoccActor(moccSystem,
				"Sensor_2", 3, Monitor, processingSet_allSensor_1_2);

		final MoccActor Sensor_3 = new MoccActor(moccSystem,
				"Sensor_3", 1, 4, Monitor, processingSet_allSensor_3);

		final MoccActor Fusion = new MoccActor(moccSystem,
				"Fusion", 3, 1, Monitor, processingSet_allSensor_1_2_3);

		final MoccActor Display = new MoccActor(moccSystem, "Display", 3, 1);

		// Channels
		moccSystem.addChannel(Monitor, 1, Sensor_1, 1, 2);
		moccSystem.addChannel(Monitor, 1, Sensor_2, 1);
		moccSystem.addChannel(Monitor, 1, 3, Sensor_3, 1);

		moccSystem.addChannel(Sensor_1, 1, 2, Fusion, 1);
		moccSystem.addChannel(Sensor_2, 1, Fusion, 1);
		moccSystem.addChannel(2, 3, Sensor_3, 1, Fusion, 1, 3);

		moccSystem.addChannel(Fusion, 1, Display, 1);

		return moccSystem;
	}


	protected static MoccSystem mocc_model_sdfg_1() {
		final MoccSystem moccSystem = new MoccSystem("SDFG");

		// Actors
		final MoccActor A = new MoccActor(moccSystem, "A");
		final MoccActor B = new MoccActor(moccSystem, "B");
		final MoccActor C = new MoccActor(moccSystem, "C");
		final MoccActor D = new MoccActor(moccSystem, "D");

		// Channels
		moccSystem.addChannel(A, 1, B, 1);
		moccSystem.addChannel(B, 3, C, 2);
		moccSystem.addChannel(C, 1, D, 1);

		moccSystem.addChannel(1, D, 1, C, 1);
		moccSystem.addChannel(5, C, 2, B, 3);
		moccSystem.addChannel(1, B, 1, A, 1);

		return moccSystem;
	}



	public static void testTransformations(
			IPath path, final MoccSystem moccSystem)
	{
		final String message = "MoCC --> xLIA : " + moccSystem.getName();
		System.out.println(message + "...");

		final MoCC2XLIA moccGenerator = new MoCC2XLIA(moccSystem, true);

		moccGenerator.transform();

		final XliaModel xliaModel = moccGenerator.xliaModel;

		System.out.println(message + " OK transformation");

		path = path.append("gen_mocc-" + moccSystem.getName())
					.addFileExtension("xlia");

		if( xliaModel != null ) {
			generation(path, moccSystem, xliaModel);
		}
		else {
			generation(path, moccSystem);
		}

		System.out.println(message + " OK generation");
	}


	public static void generation(final IPath path,
			final MoccSystem moccSystem, final XliaModel xliaModel)
	{
		try {
			final FileWriter buffer = new FileWriter( path.toOSString() );
			final PrintWriter writer = new PrintWriter(buffer);

			final CharSequence strXLIA =
					XLIAGenerator.generateModel(xliaModel);

			writer.write(strXLIA.toString());

			writer.write("\n/*\n");

			writer.write(moccSystem.toString());
			writer.write("\n*/\n");

			writer.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static void generation(final IPath path, final MoccSystem moccSystem)
	{
		try {
			final FileWriter buffer = new FileWriter( path.toOSString() );
			final PrintWriter writer = new PrintWriter(buffer);

			final StringBuilder sout = new StringBuilder();
			sout.append("\n/*\n")
				.append("==> INCONSISTENT MoccSystem <==\n");

			sout.append("system ").append(moccSystem.getName())
				.append(" {").append('\n')
				.append('\t').append("frequencies = " )
				.append(Arrays.toString(
						moccSystem.FEATURE.frequencies)).append('\n')
				.append('\t').append("time = +")
					.append(moccSystem.FEATURE.time_interval)
					.append('\n')
				.append('\t').append("period = ")
					.append(moccSystem.FEATURE.time_period)
					.append('\n')
				.append('\t').append("repetition = ")
					.append(Arrays.toString(moccSystem.FEATURE.repetitions))
					.append('\n')
				.append('}').append('\n');

			for( final MoccActor actor : moccSystem.getActor() ) {
				if( ! actor.FEATURE.consistency ) {
					sout.append("Inconsistent actor ")
						.append(actor.getName()).append(" {").append('\n')
						.append('\t').append("frequency = ")
							.append(actor.getFrequency()).append('\n')
						.append('\t').append("phase = ")
							.append(actor.getPhase()).append('\n')
						.append('\t').append("repetition = ")
							.append(actor.FEATURE.repetition).append('\n')
						.append('}').append('\n');
				}
			}
			sout.append('\n');

			writer.write(sout.toString());

			writer.write(moccSystem.toString());
			writer.write("\n*/\n");

			writer.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}


	public static void testTransformations(final IPath path)
	{
		testTransformations(path, mocc_model_basic_mode());
		testTransformations(path, mocc_model_automotive());

		testTransformations(path, mocc_model_adas());
		testTransformations(path, mocc_model_adas_mode());

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

//	public static void mutation(final IPath path) {
//		System.out.println("MoCC --> ADAS -- MUTATION --> xLIA ...");
//
//		final int mutationCount = 10;
//
//		int mutationActorCount = 0;
//		int mutationActorConsistentCount = 0;
//		int mutationChannelCount = 0;
//		int mutationChannelConsistentCount = 0;
//
//		int mutationConsistentCount = 0;
//
//		final Random random = new Random();
//
//		MoccSystem moccSystem;
//
//		boolean isActorMutation;
//
//		for (int index = 0; index < mutationCount; index++) {
//			if( isActorMutation = random.nextBoolean() ) {
//				++mutationActorCount;
//
//				moccSystem = mutationActor(random);
//			}
//			else {
//				++mutationChannelCount;
//
//				moccSystem = mutationChannel(random);
//			}
//
//			final MoCC2XLIA moccGenerator = new MoCC2XLIA(moccSystem);
//
//			moccGenerator.transform();
//
//			final XliaModel xliaModel = moccGenerator.xliaModel;
//
//			if( xliaModel != null ) {
//				++mutationConsistentCount;
//
//				if( isActorMutation ) {
//					++mutationActorConsistentCount;
//				}
//				else {
//					++mutationChannelConsistentCount;
//				}
//
//				final String filename = "gen_mocc-" + moccSystem.getName()
//						+ "_" + (isActorMutation ? "a" : "c")
//						+ mutationConsistentCount;
//				final IPath filePath =
//						path.append(filename).addFileExtension("xlia");
//
//				generation(filePath, moccSystem, xliaModel);
//			}
//			else {
//
//			}
//		}
//		System.out.println("MoCC --> ADAS -- MUTATION --> xLIA : report");
//		System.out.println("mutation : "
//				+ mutationConsistentCount + " / " + mutationCount);
//		System.out.println("Actor    : "
//				+ mutationActorConsistentCount + " / " + mutationActorCount);
//		System.out.println("Channel  : "
//				+ mutationChannelConsistentCount + " / " + mutationChannelCount);
//		System.out.println("==========================================");
//	}
//
//
//	public static MoccSystem mutationActor(final Random random) {
//		final MoccSystem moccSystem = mocc_model_adas();
//
//		final int actorCount = moccSystem.getActor().size();
//
//		while( true ) {
//			final MoccActor actor =
//					moccSystem.getActor().get( random.nextInt(actorCount - 1) );
//
//			if( actor.isTimed() ) {
//				if( random.nextBoolean() ) {
//					mutationActorFrequency(random, actor);
//				}
//				else {
//					mutationActorPhase(random, actor);
//				}
//				return moccSystem;
//			}
//		}
//	}
//
//	private static void mutationActorFrequency(
//			final Random random, final MoccActor actor) {
//		int randValue = 0;
//		do {
//			randValue = 1 + random.nextInt(100);
//			if( randValue != actor.frequency ) {
//				actor.frequency = randValue;
//				break;
//			}
//		}
//		while( true );
//	}
//
//	private static void mutationActorPhase(
//			final Random random, final MoccActor actor) {
//		int randValue = 0;
//		do {
//			randValue = 1 + random.nextInt(10);
//				//actor.getSystem().FEATURE.tick_period / actor.getFrequency());
//			if( randValue != actor.phase ) {
//				actor.phase = randValue;
//				break;
//			}
//		}
//		while( true );
//	}
//
//
//	public static MoccSystem mutationChannel(final Random random) {
//		final MoccSystem moccSystem = mocc_model_adas();
//
//		final int channelCount = moccSystem.getChannel().size();
//		final MoccChannel channel =
//				moccSystem.getChannel().get(random.nextInt(channelCount - 1));
//		switch( random.nextInt(3) ) {
//		case 0:
//			mutationChannelInput(random, channel);
//			break;
//		case 1:
//			mutationChannelInitial(random, channel);
//			break;
//		case 2:
//			mutationChannelOutput(random, channel);
//			break;
//
//		default:
//			break;
//		}
//		return moccSystem;
//	}
//
//	private static void mutationChannelInput(
//			final Random random, final MoccChannel channel)
//	{
//		int randValue = 0;
//		do {
//			randValue = 1 + random.nextInt(10);
//			if( randValue != channel.getInputPort().rate ) {
//				channel.getInputPort().rate = randValue;
//				break;
//			}
//		}
//		while( true );
//	}
//
//	private static void mutationChannelInitial(
//			final Random random, final MoccChannel channel)
//	{
//		int randValue = 0;
//		do {
//			randValue = 1 + random.nextInt(10);
//			if( randValue != channel.initialRate ) {
//				channel.initialRate = randValue;
//				break;
//			}
//		}
//		while( true );
//	}
//
//	private static void mutationChannelOutput(
//			final Random random, final MoccChannel channel)
//	{
//		int randValue = 0;
//		do {
//			randValue = 1 + random.nextInt(10);
//			if( randValue != channel.getOutputPort().rate ) {
//				channel.getOutputPort().rate = randValue;
//				break;
//			}
//		}
//		while( true );
//	}


}
