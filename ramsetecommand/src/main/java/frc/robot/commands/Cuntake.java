/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sintake;

public class Cuntake extends CommandBase {
    private final Sintake m_sintake;
    
    public Cuntake(Sintake sintake) {
        m_sintake = sintake;
        addRequirements(m_sintake);
    }
    
    public void initialize() {
            m_sintake.Eject();
    }
    
    public void execute() {
            m_sintake.Eject();
    }
    
    public boolean isFinished() {
        return true;
    }
    
    public void end() {
    }
    
    public void interrupted() {
    }
}