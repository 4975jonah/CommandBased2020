/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                    /*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
  
    public Double getXCoord() {
      // Returns the X coordinate of the target
        double x = tx.getDouble(0.0);
        System.out.println("x is " + tx.getDouble(0.0));
          return x;
    }

    public Double getYCoord() {
      // Returns the Y coordinate of the target
        double y = ty.getDouble(0.0);
        System.out.println("y is " + ty.getDouble(0.0));
          return y;
    }

    public Double getArea() {
        // Returns the Y coordinate of the target
          double area = ta.getDouble(0.0);
          System.out.println("a is " + ta.getDouble(0.0));
            return area;
    }
}