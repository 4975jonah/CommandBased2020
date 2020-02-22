package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.Aimer;

public class Aim extends CommandBase {
    private final Aimer m_aimer;

    public Aim(Aimer aimer) {
        m_aimer = aimer;
        addRequirements(aimer);
    }

    public void initialize() {
        m_aimer.getAimer();
    }
    public void execute() {
        DoubleSolenoid.Value shifter_state = m_aimer.getAimer();
        if (shifter_state == Value.kForward) {
            m_aimer.AimDown();
        } else {
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
