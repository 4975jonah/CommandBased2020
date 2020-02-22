package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.BallHolder;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


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
