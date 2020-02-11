package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.Aimer;

public class Aim extends CommandBase {
    private final Aimer m_aimer;
    private DoubleSolenoid.Value m_aimPosition;
    
    public Aim (Aimer aimer) {
        m_aimer = aimer;
        addRequirements(aimer);
    }
    public void initialize() {
        m_aimPosition = m_aimer.getAimer();
    }
    public void execute() {
        
        if (m_aimPosition == Value.kForward){
            System.out.print("Aiming Down in Aim.execute");
            m_aimer.AimDown();
        }
        else {
            System.out.print("Aiming Up in Aim.execute");
            m_aimer.AimUp();
        }
    }
    
    public boolean isFinished() {
        
        return true;
    }
    
    public void end() {
        
    }
    
    public void interrupted() {
        
    }
}
