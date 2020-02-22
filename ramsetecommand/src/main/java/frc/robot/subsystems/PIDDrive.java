/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class PIDDrive extends PIDSubsystem {
  private CANSparkMax leftLead = new CANSparkMax(Constants.CANBusIDs.Drive.kLeftMotor1Port, MotorType.kBrushless);
  private CANSparkMax leftFollow = new CANSparkMax(Constants.CANBusIDs.Drive.kLeftMotor2Port, MotorType.kBrushless);
  private CANSparkMax rightLead = new CANSparkMax(Constants.CANBusIDs.Drive.kRightMotor2Port, MotorType.kBrushless);
  private CANSparkMax rightFollow = new CANSparkMax(Constants.CANBusIDs.Drive.kRightMotor1Port, MotorType.kBrushless);
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private CANEncoder left_encoder = leftLead.getEncoder();
  private CANEncoder right_encoder = rightLead.getEncoder();
  private SimpleMotorFeedforward m_driveFeedForward = new SimpleMotorFeedforward(1, 3);
  /*
   * The PID based drive subsystem for the robot.
   */
  public PIDDrive(double target_distance, double tolerated_distance) {
    super(new PIDController(Constants.DriveConstants.kP, Constants.DriveConstants.kI, Constants.DriveConstants.kD));
    getController().setTolerance(tolerated_distance);
    setSetpoint(target_distance);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    System.out.println("PIDDrive:useOutput: output is " + output);
    m_drive.tankDrivePercent(output, output);
  }

  @Override
  public double getMeasurement() {
    return left_encoder.getPosition();
  }

 /*
  *public boolean atSetpoint() {
  *  return m_controller.atSetpoint();
  *}
  *
  *public void runFeeder() {
  *  m_drive.set(ShooterConstants.kFeederSpeed);
  *}
  *
  *public void stopFeeder() {
  *  m_drive.set(0);
  }
  */
}
