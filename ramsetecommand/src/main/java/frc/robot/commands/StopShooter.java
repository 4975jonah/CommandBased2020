/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class StopShooter extends CommandBase {
    private final Shooter m_shooter;
    
    public StopShooter(Shooter shooter) {
        m_shooter = shooter;
        addRequirements(shooter);
    }
    
    public void initialize() {
        m_shooter.Stop();
    }
    
    public void execute() {
        m_shooter.Stop();
    }
    
    public boolean isFinished() {
        return true;
    }
    
    public void end() {
    }
    
    public void interrupted() {
    }
}