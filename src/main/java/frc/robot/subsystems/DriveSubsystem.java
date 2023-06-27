// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private WPI_TalonFX leftSidePrimary = new WPI_TalonFX(1);
  private WPI_TalonFX leftSide1 = new WPI_TalonFX(2);
  private WPI_TalonFX leftSide2 = new WPI_TalonFX(3);

  private WPI_TalonFX rightSidePrimary = new WPI_TalonFX(4);
  private WPI_TalonFX rightSide1 = new WPI_TalonFX(5);
  private WPI_TalonFX rightSide2 = new WPI_TalonFX(6);

  public DifferentialDrive kDrive;

  private LimelightInterface limelightInterface = new LimelightInterface();

  

  public DriveSubsystem() {
    leftSidePrimary.configFactoryDefault();
    leftSide1.configFactoryDefault();
    leftSide2.configFactoryDefault();

    rightSidePrimary.configFactoryDefault();
    rightSide1.configFactoryDefault();
    rightSide2.configFactoryDefault();

    leftSide1.follow(leftSidePrimary);
    leftSide2.follow(leftSidePrimary);

    rightSide1.follow(rightSidePrimary);
    rightSide2.follow(rightSidePrimary);

    rightSidePrimary.setInverted(InvertType.InvertMotorOutput);
    rightSide1.setInverted(InvertType.FollowMaster);
    rightSide2.setInverted(InvertType.FollowMaster);

    kDrive = new DifferentialDrive(leftSidePrimary, rightSidePrimary);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("APRIL TAG ID", limelightInterface.getID());
  }

  public void drive(double leftPercentOut, double rightPercentOut) {
    leftSidePrimary.set(ControlMode.PercentOutput, leftPercentOut);
    rightSidePrimary.set(ControlMode.PercentOutput, rightPercentOut);
  }

}
