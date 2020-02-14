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

public class Pneu_Climber extends SubsystemBase {
    // The double solenoid that extends and retracts the cylinder.
    private final DoubleSolenoid m_climber = new DoubleSolenoid(DriveConstants.mod0,5,0);
    
    public DoubleSolenoid.Value Extend() {
        // Shifts Up
        m_climber.set(Value.kForward);
        return m_climber.get();
    }
    
    public DoubleSolenoid.Value Retract() {
        // Shifts Down
        m_climber.set(Value.kReverse);
        return m_climber.get();
    }
    
    public DoubleSolenoid.Value getShifter() {
        //returns the value of the double solenoid
        return m_climber.get();
    }
}