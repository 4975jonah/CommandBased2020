/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneu_Climber;;

public class Extend_Climber extends CommandBase {
    private final Pneu_Climber m_climber;
    
    public Extend_Climber(Pneu_Climber pneu_climber) {
       m_climber = pneu_climber;
        addRequirements(m_climber);
    }
    
    public void initialize() {
        m_climber.Extend();
    }

    public void execute() {
        //System.out.println("shifter state is " + shifter_state + " forward is " + m_forward.getAsDouble());
        m_climber.Extend();
    }

    public boolean isFinished() {
        m_climber.Retract();
        return true;
    }

    public void end() {
        m_climber.Retract();
    }

    public void interrupted() {
        m_climber.Retract();
    }
}