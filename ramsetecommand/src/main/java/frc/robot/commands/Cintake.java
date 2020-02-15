/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sintake;

public class Cintake extends CommandBase {
    private final Sintake m_sintake;
    
    public Cintake(Sintake sintake) {
        m_sintake = sintake;
        addRequirements(m_sintake);
    }
    
    public void initialize() {
            m_sintake.Intake();
    }
    
    public void execute() {
            m_sintake.Intake();
    }
    
    public boolean isFinished() {
        return true;
    }
    
    public void end() {
    }
    
    public void interrupted() {
    }
}