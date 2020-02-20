/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.BallHolder;
import frc.robot.commands.HoldBall;
import frc.robot.commands.ReleaseBall;
import frc.robot.commands.Extend_Climber;
import frc.robot.commands.Retract_Climber;
import frc.robot.subsystems.Pneu_Climber;
import frc.robot.subsystems.Motor_Climber;
import frc.robot.commands.Climb;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Shifter;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ColorSensor;
import frc.robot.commands.AlignColor;
import frc.robot.commands.Drive;
import frc.robot.commands.UpShift;
import frc.robot.commands.DownShift;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.Shoot;
import frc.robot.commands.Cintake;
import frc.robot.commands.Cop_Cintake;
import frc.robot.subsystems.Sintake;
import frc.robot.commands.Kuchota;
import frc.robot.commands.StopShooter;
import frc.robot.subsystems.ControlPanel;
import frc.robot.commands.Aim;
import frc.robot.subsystems.Aimer;
import frc.robot.commands.ReleaseShoot;
import frc.robot.commands.HoldShoot;
import frc.robot.commands.Cuntake;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.XboxController.Button;


import frc.robot.autonomousroutines.DriveStraight10;

/**
* This class is where the bulk of the robot should be declared.  Since Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
* periodic methods (other than the scheduler calls).  Instead, the structure of the robot
* (including subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
  // The robot's subsystems
  private final BallHolder m_ballholder = new BallHolder();
  private final Shifter m_shifter = new Shifter();
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final Shooter m_shooter = new Shooter();
  private final Limelight m_limelight = new Limelight();
  private final ControlPanel m_controlpanel = new ControlPanel();
  private final ColorSensor m_colorsensor = new ColorSensor();
  private final Motor_Climber m_motorclimber = new Motor_Climber();

  private final Pneu_Climber m_pclimber = new Pneu_Climber();
  private final Sintake m_sintake = new Sintake();
  private final Aimer m_aimer = new Aimer();
  // The driver's controller
  private final XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  private final XboxController m_helperController = new XboxController(OIConstants.kHelperControllerPort);
  
  DoubleSolenoid.Value foo = m_shifter.getShifter();
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    // Configure defaramseteCommand.ramseteCommandult commands
    // Set the default drive command to split-stick arcade drive
      m_robotDrive.setDefaultCommand(
          new Drive(
            m_robotDrive,
            m_shifter,
            () -> m_driverController.getY(GenericHID.Hand.kLeft),
            () -> m_driverController.getX(GenericHID.Hand.kLeft)));
      
      m_colorsensor.setDefaultCommand(
          new AlignColor(
            m_controlpanel, 
            m_colorsensor
      ));

      m_motorclimber.setDefaultCommand(
          new Climb(
          m_motorclimber,
          () -> m_helperController.getTriggerAxis(GenericHID.Hand.kRight)));
  }
  
  /**
  * Use this method to define your button->command mappings.  Buttons can be created by
  * instantiating a {@link GenericHID} or one of its subclasses ({@link
    * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling passing it to a
    * {@link JoystickButton}.
    */
    private void configureButtonBindings() {
      // Drive at half speed when the right bumper is held
      /*new JoystickButton(m_driverController, Button.kStart.value)
      .whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
      .whenReleased(() -> m_robotDrive.setMaxOutput(1));*/
      
      new JoystickButton(m_driverController, Button.kB.value).whenPressed(() -> m_robotDrive.Invert());
      new JoystickButton(m_driverController, Button.kBumperRight.value).whenPressed(new UpShift(m_shifter));
      new JoystickButton(m_driverController, Button.kBumperLeft.value).whenPressed(new DownShift(m_shifter));
      new JoystickButton(m_driverController, Button.kA.value).whileHeld(new ReleaseShoot(m_ballholder, m_shooter));
      new JoystickButton(m_driverController, Button.kA.value).whenReleased(new HoldShoot(m_ballholder, m_shooter));
      new JoystickButton(m_driverController, Button.kY.value).whenPressed(new Aim(m_aimer));
      new JoystickButton(m_driverController, Button.kX.value).whileHeld(new Cintake(m_sintake));
      new JoystickButton(m_driverController, Button.kX.value).whenReleased(new Cop_Cintake(m_sintake));
      new JoystickButton(m_driverController, Button.kBack.value).whileHeld(new Cuntake(m_sintake));
      new JoystickButton(m_driverController, Button.kBack.value).whenReleased(new Cop_Cintake(m_sintake));
      //new JoystickButton(m_driverController, Button.kY.value).whileHeld(new Kuchota(m_robotDrive, m_limelight));

      new JoystickButton(m_helperController, Button.kBumperLeft.value).whenPressed(new Retract_Climber(m_pclimber));
      new JoystickButton(m_helperController, Button.kBumperRight.value).whenReleased(new Extend_Climber(m_pclimber));

    }
    
    
    
    
    /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
    
    public Command getAutonomousCommand() {
      new DriveStraight10(m_ballholder);
      
      /*
      // Create a voltage constraint to ensure we don't accelerate too fast
      var autoVoltageConstraint =
      new DifferentialDriveVoltageConstraint(
      new SimpleMotorFeedforward(DriveConstants.ksVolts,
      DriveConstants.kvVoltSecondsPerMeter,
      DriveConstants.kaVoltSecondsSquaredPerMeter),
      DriveConstants.kDriveKinematics,
      10);
      
      // Create config for trajectory
      TrajectoryConfig config =
      new TrajectoryConfig(AutoConstants.kMaxSpeedMetersPerSecond,
      AutoConstants.kMaxAccelerationMetersPerSecondSquared)
      // Add kinematics to ensure max speed is actually obeyed
      .setKinematics(DriveConstants.kDriveKinematics)ramseteCommand.ramseteCommand
      // An example trajectory to follow.  All units in meters.
      Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
      // Start at the origin facing the +X direction
      new Pose2d(0, 0, new Rotation2d(0)),
      // Pass through these two interior waypoints, making an 's' curve path
      List.of(
      new Translation2d(1, 1),
      new Translation2d(2, -1)
      ),
      // End 3 meters straight ahead of where we started, facing forward
      new Pose2d(3, 0, new Rotation2d(0)),
      // Pass config
      config
      );
      
      RamseteCommand ramseteCommand = new RamseteCommand(
      exampleTrajectory,
      m_robotDrive::getPoseramseteCommand.ramseteCommandrward(DriveConstants.ksVolts,
      DriveConstants.kvVoltSecondsPerMeter,
      DriveConstants.kaVoltSecondsSquaredPerMeter),
      DriveConstants.kDriveKinematics,
      m_robotDrive::getWheelSpeeds,
      new PIDController(DriveConstants.kPDriveVel, 0, 0),
      new PIDController(DriveConstants.kPDriveVel, 0, 0),
      // RamseteCommand passes volts to the callback
      m_robotDrive::tankDriveVolts,
      m_robotDrive
      );
      
      // Run path following command, then stop at the end.
      return ramseteCommand.andThen(() -> m_robotDrive.tankDriveVolts(0, 0));
      */
      return new DriveStraight10(m_ballholder);
    }
  }
  
