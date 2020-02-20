/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  // The double solenoid that extends and retracts the cylinder.
  private final CANSparkMax m_top = new CANSparkMax(Constants.CANBusIDs.Shooter.top, MotorType.kBrushless);
  private final CANSparkMax m_bottom = new CANSparkMax(Constants.CANBusIDs.Shooter.bottom, MotorType.kBrushless);
  
  public void Shoot() {
    // Shoots from _____
    m_top.set(0.40);
    m_bottom.set(1.0);
  }
  
  public void Stop() {
    // Shifts Down
    m_top.set(0.0);
    m_bottom.set(0.0);
  }
  
}