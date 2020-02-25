/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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

  public DriveSubsystem() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
  }

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

  public void tankDrivePercent(double leftPercent, double rightPercent) {
    System.out.println("DriveSubsystem:tankDrivePercent: left: " + leftPercent +
      ", right: " + rightPercent);
    leftLead.set(leftPercent);
    rightLead.set(-rightPercent);
  }

  /**
  * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
  *
  * @param maxOutput the maximum output to which the drive will be constrained
  */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

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

  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360) * (Constants.DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }

  
  /**
  * Returns the turn rate of the robot/
/*
  public double getTurnRate() {
    return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
*/
}
