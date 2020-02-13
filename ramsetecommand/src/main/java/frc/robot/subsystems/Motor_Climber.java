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

public class Motor_Climber extends SubsystemBase {
    // The double solenoid that extends and retracts the cylinder.
    private final CANSparkMax m_leader = new CANSparkMax(8, MotorType.kBrushless);
    private final CANSparkMax m_follower = new CANSparkMax(9, MotorType.kBrushless);

    public void climbUp() {
        // Shoots from _____
        m_leader.set(0.5);
        m_follower.set(0.5);
    }
    
    public void climbDown() {
        // Shifts Down
        m_leader.set(-0.5);
        m_follower.set(-0.5);
    }
    
    public void Stop() {
        m_leader.set(0.0);
        m_follower.set(0.0);
    }
    
}