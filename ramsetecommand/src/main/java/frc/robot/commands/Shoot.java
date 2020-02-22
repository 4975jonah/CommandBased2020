/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    private final Shooter m_shooter;
    
    public Shoot(Shooter shooter) {
        m_shooter = shooter;
        addRequirements(shooter);
    }
    
    public void initialize() {
        m_shooter.Shoot();
    }
    
    public void execute() {
        System.out.println("in shoot");
        m_shooter.Shoot();
    }
    
    public boolean isFinished() {
        return true;
    }
    
    public void end() {
    }
    
    public void interrupted() {
    }
}