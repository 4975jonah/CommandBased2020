package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.BallHolder;

public class ReleaseBall extends CommandBase {
    private final BallHolder m_ballholder;
    private DoubleSolenoid.Value m_currentPosition;

    public ReleaseBall(BallHolder BallHolder_subsystem) {
        m_ballholder = BallHolder_subsystem;
        addRequirements(BallHolder_subsystem);


    }

    public void initialize() {
        m_currentPosition = m_ballholder.getPosition();


    }

    public void execute() {

        m_ballholder.Retract();
        /*
        if(m_currentPosition == Value.kReverse) {
            System.out.println("in releaseball");
            m_ballholder.Retract();

        }else{
            System.out.println("in releaseball");
            m_ballholder.Retract();

        }
      */

    }



    //System.out.println("shifter state is " + shifter_state + " forward is " + m_forward.getAsDouble());



    public boolean isFinished() {

        return true;
    }

    public void end() {

    }

    public void interrupted() {

    }
}