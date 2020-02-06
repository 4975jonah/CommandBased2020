/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Limelight;

public class Kuchota extends CommandBase {
    private final DriveSubsystem m_drive;
    private final Limelight m_limelight;
    private final Double left_speed;
    private final Double right_speed;

    public Kuchota(DriveSubsystem drive_subsystem, Limelight limelight) {
       m_drive = drive_subsystem;
       m_limelight = limelight;
       left_speed = m_limelight.getXCoord();
       right_speed = m_limelight.getXCoord()*-1;
        addRequirements(drive_subsystem, limelight);
    }

    public void initialize() {
        if (left_speed < -5 || right_speed > 5) {
            m_drive.chaseBall(left_speed, right_speed);
        } else {
            m_drive.chaseBall(.5, .5);
        }
        System.out.println("in initialize");
    }

    public void execute() {
        if (left_speed < -5 || right_speed > 5) {
            m_drive.chaseBall(left_speed, right_speed);
        } else {
            m_drive.chaseBall(.5, .5);
        }
        System.out.println("in execute");
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {

    }
}