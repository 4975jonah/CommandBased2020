package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
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


public class ReleaseShoot extends SequentialCommandGroup {
    public BallHolder m_ballholder;
    public Shooter m_shooter;
    public DoubleSolenoid.Value m_currentPosition;
    
    public ReleaseShoot(BallHolder BallHolder, Shooter shooter) {
     m_shooter = shooter;
     m_ballholder = BallHolder;
     addRequirements(BallHolder, shooter);

     addCommands(new Shoot(m_shooter),
     new Wait(0.50),
     new ReleaseBall(m_ballholder));
       
    }
}