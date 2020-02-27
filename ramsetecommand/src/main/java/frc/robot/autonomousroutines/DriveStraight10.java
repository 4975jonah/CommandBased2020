/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomousroutines;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.PIDDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveWithPID;

public class DriveStraight10 extends SequentialCommandGroup {
  public DriveSubsystem m_regdrive;
  public PIDDrive m_piddrive;

  public DriveStraight10(DriveSubsystem drivesubsystem, PIDDrive piddrive) {
    m_regdrive = drivesubsystem;
    m_piddrive = piddrive;
    addRequirements(m_regdrive, m_piddrive);

    addCommands(
      new DriveWithPID(2, m_regdrive);
  }
}