package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PIDDrive;
import frc.robot.Constants;

 public class DriveWithPID extends PIDCommand {
 /**
   * Creates a new PIDCommand, which controls the given output with a PIDController.
   *
   * @param controller        the controller that controls the output.
   * @param measurementSource the measurement of the process variable
   * @param setpointSource    the controller's setpoint
   * @param useOutput         the controller's output
   * @param requirements      the subsystems required by this command
   */
  public DriveWithPID(double targetDistance , DriveSubsystem drive, PIDDrive piddrive) {
   super(
      new PIDController(Constants.DriveConstants.kP, Constants.DriveConstants.kI, Constants.DriveConstants.kD),
      drive::getHeading,
      targetDistance,
      output -> drive.tankDrivePercent(PIDController.calculate(piddrive.getAvgDistance(), targetDistance),
      drive));

    getController().enableContinuousInput(-1.0, 1.0);
    getController().setTolerance(Constants.DriveConstants.kDriveRateTolerance,
                                Constants.DriveConstants.kDriveAccelerationTolerance);
  }
}