/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /*
   * Our left and right side of the drivetrain is only being controlled by two
   * motor controllers, while the other two are set to be followers. This is because
   * DifferentialDrive will only take two motor controllers
   */
  private CANSparkMax leftLead = new CANSparkMax(Constants.CANBusIDs.Drive.kLeftMotor1Port, MotorType.kBrushless);
  private CANSparkMax leftFollow = new CANSparkMax(Constants.CANBusIDs.Drive.kLeftMotor2Port, MotorType.kBrushless);
  private CANSparkMax rightLead = new CANSparkMax(Constants.CANBusIDs.Drive.kRightMotor2Port, MotorType.kBrushless);
  private CANSparkMax rightFollow = new CANSparkMax(Constants.CANBusIDs.Drive.kRightMotor1Port, MotorType.kBrushless);
  private final DifferentialDrive m_drive = new DifferentialDrive(leftLead, rightLead);

  private int m_inversion = 1;
  
  private final AHRS m_gyro = new AHRS(SPI.Port.kMXP);
  
  //private final Encoder m_leftEncoder =
  //new Encoder(Constants.CANBusIDs.Drive.kLeftEncoderPorts[0], DriveConstants.kLeftEncoderPorts[1],
  //DriveConstants.kLeftEncoderReversed);
  
  //private final Encoder m_rightEncoder =
  //new Encoder(DriveConstants.kRightEncoderPorts[0], DriveConstants.kRightEncoderPorts[1],
  //DriveConstants.kRightEncoderReversed);
  
  // private final DifferentialDriveOdometry m_odometry;

  public DriveSubsystem() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);

//    resetEncoders();
//    m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getHeading()));
  }

/*
  @Override
  public void periodic() {
    // Update the odometry in the periodic block
    m_odometry.update(Rotation2d.fromDegrees(getHeading()), m_leftEncoder.getDistance(),
    m_rightEncoder.getDistance());
  }
*/

  /**
  * Returns the currently-estimated pose of the robot.
  *
  * @return The pose.
  */
/*
  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }
*/
  
  /**
  * Returns the current wheel speeds of the robot.
  *
  * @return The current wheel speeds.
  */
/*
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(m_leftEncoder.getRate(), m_rightEncoder.getRate());
  }
*/
  /**
  * Resets the odometry to the specified pose.
  *
  * @param pose The pose to which to set the odometry.
  */
/*
  public void resetOdometry(Pose2d pose) {
    resetEncoders();
    m_odometry.resetPosition(pose, Rotation2d.fromDegrees(getHeading()));
  }
*/
  
  public void chaseBall(double leftSpeed, double rightSpeed) {
    /*
     * It might look funky but we use tankDrive so we can control the left
     * and right speeds independently of eachother much easier than we can
     * with arcadeDrive.
     */
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }
  
  public void arcadeDrive(double leftSpeed, double rightSpeed) {
    m_drive.arcadeDrive(leftSpeed*getInverted(), rightSpeed*getInverted());
  }

  public void Invert() {
    m_inversion *= -1;
  }

  public int getInverted() {
    return m_inversion;
  }
  
  /**
  * Controls the left and right sides of the drive directly with voltages.
  *
  * @param leftVolts  the commanded left output
  * @param rightVolts the commanded right output
  */
  public void tankDrivePercent(double leftPercent, double rightPercent) {
    leftLead.set(leftPercent);
    rightLead.setVoltage(-rightPercent);
  }
  
  /**
  * Resets the drive encoders to currently read a position of 0.
  */
/*
  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }
*/
  
  /**
  * Gets the average distance of the two encoders.
  *
  * @return the average of the two encoder readings
  */
/*
  public double getAverageEncoderDistance() {
    return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  }
*/

  /**
  * Gets the left drive encoder.
  *
  * @return the left drive encoder
  */
/*
  public Encoder getLeftEncoder() {
    return m_leftEncoder;
  }
*/
  /*
  * Gets the right drive encoder.
  *
  * @return the right drive encoder
  */
/*
  public Encoder getRightEncoder() {
    return m_rightEncoder;
  }
*/
  
  /**
  * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
  *
  * @param maxOutput the maximum output to which the drive will be constrained
  */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }
  
  /**
  * Zeroes the heading of the robot.
  */
/*
  public void zeroHeading() {
    m_gyro.reset();
  }
*/
  
  /**
  * Returns the heading of the robot.
  *
  * @return the robot's heading in degrees, from 180 to 180
  */
/*
  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
*/
  
  /**
  * Returns the turn rate of the robot/
/*
  public double getTurnRate() {
    return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
*/
}
