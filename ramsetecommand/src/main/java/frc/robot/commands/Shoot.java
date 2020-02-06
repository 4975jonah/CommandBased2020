/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import frc.robot.Constants;

public class Shoot extends CommandBase {
    private final Shifter m_shifter;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;
    private final DriveSubsystem m_drive;
    
    public Drive(DriveSubsystem drive_subsystem, Shifter shifter_subsystem, DoubleSupplier forward, DoubleSupplier rotation) {
       m_forward = forward;
       m_rotation = rotation;
       m_drive = drive_subsystem;

       m_shifter = shifter_subsystem;
        addRequirements(drive_subsystem, shifter_subsystem);
    }
    
    public void initialize() {
    }

    public void execute() {
        Double rotation;
        DoubleSolenoid.Value shifter_state = m_shifter.getShifter();
        if (shifter_state == Value.kForward) {
            rotation = m_rotation.getAsDouble() * Constants.DriveConstants.kRotationMultiplier;
        } else {
            rotation = m_rotation.getAsDouble();
        }
        //System.out.println("shifter state is " + shifter_state + " forward is " + m_forward.getAsDouble());
        m_drive.arcadeDrive(m_forward.getAsDouble()*-1, rotation);
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {

    }
}