/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
* The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
* constants.  This class should not be used for any other purpose.  All constants should be
* declared globally (i.e. public static).  Do not put anything functional in this class.
*
* <p>It is advised to statically import this class (or one of its inner classes) wherever the
* constants are needed, to reduce verbosity.
*/
public final class Constants {
  public static final class CANBusIDs {
    public static final class Drive {
      public static final int kLeftMotor1Port = 1;
      public static final int kLeftMotor2Port = 3;
      public static final int kRightMotor1Port = 2;
      public static final int kRightMotor2Port = 4;

    }
    public static final class Climber {
      public static final int climb1 = 5;
      public static final int climb2 = 6;
    }
    public static final class Shooter {
      public static final int top = 9;
      public static final int bottom = 10;
    }
    public static final int intake = 7;
    public static final int extra = 8;
  }

  public static final class DriveConstants {
    public static final double kRotationMultiplier = 0.3;

    public static final int[] kLeftEncoderPorts = new int[]{0, 1};
    public static final int[] kRightEncoderPorts = new int[]{2, 3};
    public static final boolean kLeftEncoderReversed = false;
    public static final boolean kRightEncoderReversed = true;
    public static final double kP = 5;
    public static final double kI = 1;
    public static final double kD = 5;
    public static final double kDriveRateTolerance = 0.1;
    public static final double kDriveAccelerationTolerance = 0.1;

    public static final double kTrackwidthMeters = 0.69;
    public static final DifferentialDriveKinematics kDriveKinematics =
    new DifferentialDriveKinematics(kTrackwidthMeters);

    public static final int kEncoderCPR = 42;
    public static final double kWheelDiameterMeters = 0.152;
    public static final double kEncoderDistancePerPulse =
    // Assumes the encoders are directly mounted on the wheel shafts
    (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;

    public static final boolean kGyroReversed = true;

    /* These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    *These characterization values MUST be determined either experimentally or theoretically
    *for *your* robot's drive.
    * The Robot Characterization Toolsuite provides a convenient tool for obtaining these
    * values for your robot.
    */
    public static final double kPDriveVel = 8.5;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kHelperControllerPort = 1;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;

    // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;
  }
  public static final class Pneumatics {
    public static final class Mod0 {
      public static final int mod = 0;
      public static final int port0 = 0;
      public static final int port1 = 1;
      public static final int port2 = 2;
      public static final int port3 = 3;
      public static final int port4 = 4;
      public static final int port5 = 5;
      public static final int port6 = 6;
      public static final int port7 = 7;
    }
    public static final class Mod1 {
      public static final int mod = 1;
      public static final int port0 = 0;
      public static final int port1 = 1;
      public static final int port2 = 2;
      public static final int port3 = 3;
      public static final int port4 = 4;
      public static final int port5 = 5;
      public static final int port6 = 6;
      public static final int port7 = 7;
    }
  }
}
