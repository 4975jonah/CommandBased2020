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

public class Aimer extends SubsystemBase {
  // The double solenoid that extends and retracts the cylinder.
  private final DoubleSolenoid m_aimer = 
  new DoubleSolenoid(Constants.Pneumatics.Mod0.mod, Constants.Pneumatics.Mod0.port4 , Constants.Pneumatics.Mod0.port5);

  public DoubleSolenoid.Value AimUp() {
    // Aims Up
        m_aimer.set(Value.kForward);
        return m_aimer.get();
  }

  public DoubleSolenoid.Value AimDown() {
       // Aims Down
      m_aimer.set(Value.kReverse);
      return m_aimer.get();
    }

  public DoubleSolenoid.Value getAimer() {
    //returns the value of the double solenoid
    return m_aimer.get();
    }
}