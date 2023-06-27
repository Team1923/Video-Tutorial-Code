// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private WPI_TalonFX intakeMotor = new WPI_TalonFX(7);

  public ShuffleboardTab driverDashboard = Shuffleboard.getTab("Driver Dashboard");

  private GenericEntry intakeRunningBoolean = driverDashboard.add("INTAKE RUNNING", false).withSize(1, 1).withPosition(0, 0).withProperties(Map.of("Color when false", "#000000", "Color when true", "#17FC03")).getEntry();

  private boolean isIntakeRunning = false;

  private Solenoid pneumatic = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  public IntakeSubsystem() {
    intakeMotor.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run


    intakeRunningBoolean.setBoolean(isIntakeRunning);
  }

  public void setIntakeSpeed(double percent) {
    intakeMotor.set(ControlMode.PercentOutput, percent);
  }

  public void setIsIntakeRunning(boolean value) {
    isIntakeRunning = value;
  }

  public void setPneumatic(boolean value) {
    pneumatic.set(value);
  }
}
