package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; //https://www.javatpoint.com/operators-in-java
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class BallHolder extends SubsystemBase {
  // The double solenoid that extends and retracts the cylinder.
  private final DoubleSolenoid m_ballholder = new DoubleSolenoid(0,1,0);

  public DoubleSolenoid.Value Extend() {
    // Extends BallHolder
    m_ballholder.set(Value.kForward);
    return m_ballholder.get();

  }

  public DoubleSolenoid.Value Retract() {
    // Retracts BallHolder
        
        m_ballholder.set(Value.kReverse);
        return m_ballholder.get();
    }
    

    public DoubleSolenoid.Value getPosition() {
      // returns the value of the double solenoid
      return m_ballholder.get();
    }
}