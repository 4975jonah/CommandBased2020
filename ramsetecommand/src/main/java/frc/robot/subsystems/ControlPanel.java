package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;

public class ControlPanel extends SubsystemBase {
    private final VictorSPX colorMotor = new VictorSPX(Constants.CANBusIDs.extra);

    public void Spin() {
        colorMotor.set(ControlMode.PercentOutput, 1.0);
    }

    public void stop() {
        colorMotor.set(ControlMode.PercentOutput, 0.0);
    }

}