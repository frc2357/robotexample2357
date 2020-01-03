/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  /**
   * CAN IDS 1-10
   * Core Components of the Robot
   */
  public static final int PDP = 1;
  public static final int PCM_1 = 2;
  public static final int PCM_2 = 3;

  /**
   * CAN IDS 11-20
   * Drive Base Devices
   */
  public static final int DRIVE_MOTOR_LEFT_1 = 11;
  public static final int DRIVE_MOTOR_RIGHT_1 = 12;
  public static final int DRIVE_MOTOR_LEFT_2 = 13;
  public static final int DRIVE_MOTOR_RIGHT_2 = 14;
  public static final int DRIVE_MOTOR_LEFT_3 = 15;
  public static final int DRIVE_MOTOR_RIGHT_3 = 16;
  public static final int DRIVE_MOTOR_LEFT_4 = 17;
  public static final int DRIVE_MOTOR_RIGHT_4 = 18;

  public static final int[] DRIVE_MOTOR_LEFT_SLAVES = {
    CanIdMap.DRIVE_MOTOR_LEFT_2, CanIdMap.DRIVE_MOTOR_LEFT_3, CanIdMap.DRIVE_MOTOR_LEFT_4};

  public static final int[] DRIVE_MOTOR_RIGHT_SLAVES = {
    CanIdMap.DRIVE_MOTOR_RIGHT_2, CanIdMap.DRIVE_MOTOR_RIGHT_3, CanIdMap.DRIVE_MOTOR_RIGHT_4};

  /**
   * CAN IDS 21-60
   * Mechanisms and other devices (robot specific)
   */
}