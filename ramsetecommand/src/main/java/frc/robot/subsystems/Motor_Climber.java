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

public class Motor_Climber extends SubsystemBase {
    // The double solenoid that extends and retracts the cylinder.
    private final VictorSPX m_leader = new VictorSPX(Constants.CANBusIDs.Climber.climb1);
    private final VictorSPX m_follower = new VictorSPX(Constants.CANBusIDs.Climber.climb2);

    public void climbUp(double speed) {
        m_leader.set(ControlMode.PercentOutput, speed);
        m_follower.set(ControlMode.Follower, 5);
    }
    
    public void climbDown() {
        m_leader.set(ControlMode.PercentOutput, -0.5);
        m_follower.set(ControlMode.Follower, 5);
    }
    
    public void Stop() {
        m_leader.set(ControlMode.PercentOutput, 0.0);
        m_follower.set(ControlMode.Follower, 5);
    }
    
}