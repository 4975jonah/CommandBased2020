package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ControlPanel extends SubsystemBase {
    private final CANSparkMax colorMotor = new CANSparkMax(12, MotorType.kBrushless);

    public void Spin() {
        colorMotor.set(1);
    }

    public void stop() {
        colorMotor.set(0);
    }

}