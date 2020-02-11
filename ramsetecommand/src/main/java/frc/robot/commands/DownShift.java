/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shifter;

public class DownShift extends CommandBase {
    private final Shifter m_shifter;
    
    public DownShift(Shifter shifter) {
        m_shifter = shifter;
        addRequirements(m_shifter);
    }
    
    public void initialize() {
        m_shifter.DownShift();
    }
    
    public void execute() {
        //System.out.println("shifter state is " + shifter_state + " forward is " + m_forward.getAsDouble());
        m_shifter.DownShift();
    }
    
    public boolean isFinished() {
        m_shifter.UpShift();
        return true;
    }
    
    public void end() {
        m_shifter.UpShift();
    }
    
    public void interrupted() {
        m_shifter.UpShift();
    }
}