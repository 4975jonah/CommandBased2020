/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class Shifter extends SubsystemBase {
  // The double solenoid that extends and retracts the cylinder.
  private final DoubleSolenoid m_shifter = 
  new DoubleSolenoid(Constants.Pneumatics.Mod0.mod,Constants.Pneumatics.Mod0.port2 ,Constants.Pneumatics.Mod0.port3);
  
  public DoubleSolenoid.Value UpShift() {
    // Shifts Up
    m_shifter.set(Value.kForward);
    return m_shifter.get();
  }
  
  public DoubleSolenoid.Value DownShift() {
    // Shifts Down
    m_shifter.set(Value.kReverse);
    return m_shifter.get();
  }
  
  public DoubleSolenoid.Value getShifter() {
    //returns the value of the double solenoid
    return m_shifter.get();
  }
}