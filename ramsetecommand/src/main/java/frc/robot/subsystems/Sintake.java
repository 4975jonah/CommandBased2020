/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;

public class Sintake extends SubsystemBase {
    // The double solenoid that extends and retracts the cylinder.
    private final VictorSPX m_intake = new VictorSPX(Constants.CANBusIDs.intake);
    
    public void Intake() {
        // Shoots from _____
        m_intake.set(ControlMode.PercentOutput, 1.0);
    }

    public void Eject() {
        // Shoots from _____
        m_intake.set(ControlMode.PercentOutput, -1.0);
    }
    
    public void Stop() {
        // Shifts Down
        m_intake.set(ControlMode.PercentOutput, 0.0);
    }
    public double getSintake() {
        return m_intake.getMotorOutputPercent();
    }
    
}