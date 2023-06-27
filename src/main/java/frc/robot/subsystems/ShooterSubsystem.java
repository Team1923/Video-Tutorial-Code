// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.UnitConversion;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  private WPI_TalonFX shooterMotor = new WPI_TalonFX(8, "rio");

  


  public ShooterSubsystem() {
    shooterMotor.configFactoryDefault();
    shooterMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    shooterMotor.config_kP(0, 0.1);
    shooterMotor.config_kI(0, 0);
    shooterMotor.config_kD(0, 0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter RPM", getMotorVelocity());
  }

  public void setMotorVelocity(double stpt) {
    shooterMotor.set(ControlMode.Velocity, UnitConversion.RPMtoNativeUnits(stpt));
  }

  public double getMotorVelocity() {
    return UnitConversion.nativeUnitstoRPM(shooterMotor.getSelectedSensorVelocity());
  }

}
