/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import common.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class MotorSubsystem extends SubsystemBase {

  private WPI_TalonSRX motor;

  public MotorSubsystem() {
    motor = new WPI_TalonSRX(2);
  }

  /**
   * Set motor speed
   * @param speed Percentage of maximum speed
   */
  public void setMotorSpeed(double speed) {
    motor.set(speed);
  }

  @Override
  protected void initDefaultCommand() {

  }
}
