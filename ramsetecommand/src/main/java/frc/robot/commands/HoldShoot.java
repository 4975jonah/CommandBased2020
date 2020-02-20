package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.ReleaseBall;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.BallHolder;
import frc.robot.commands.Wait;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;


public class HoldShoot extends SequentialCommandGroup {
    public BallHolder m_ballholder;
    public Shooter m_shooter;
    public DoubleSolenoid.Value m_currentPosition;
    
    public HoldShoot(BallHolder BallHolder, Shooter shooter) {
        m_shooter = shooter;
        m_ballholder = BallHolder;
        addRequirements(BallHolder, shooter);

        addCommands(
     new StopShooter(shooter),
     new HoldBall(m_ballholder));
    }
}
    