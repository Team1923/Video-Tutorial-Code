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

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */

  private WPI_TalonFX elevatorMotor = new WPI_TalonFX(9);


  public ElevatorSubsystem() {
    elevatorMotor.configFactoryDefault();
    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    elevatorMotor.config_kP(0, 0.1);
    elevatorMotor.config_kI(0, 0);
    elevatorMotor.config_kD(0, 0);
    elevatorMotor.config_kF(0, 0.01);

    elevatorMotor.configMotionCruiseVelocity(10000);
    elevatorMotor.configMotionAcceleration(5000);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Current Elevator Postion", getElevatorPosition());
  } 

  public void setElevatorPosition(double stpt) {
    elevatorMotor.set(ControlMode.MotionMagic, stpt);
  }

  public double getElevatorPosition() {
    return elevatorMotor.getSelectedSensorPosition();
  }

}



