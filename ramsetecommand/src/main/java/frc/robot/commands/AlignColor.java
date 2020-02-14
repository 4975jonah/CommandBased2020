/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.ControlPanel;

public class AlignColor extends CommandBase {
    private final ControlPanel m_controlpanel;
    private final ColorSensor m_colorsensor;
    
    
    public AlignColor(ControlPanel controlpanel, ColorSensor ColorSensor) {
        m_controlpanel = controlpanel;
        m_colorsensor = ColorSensor;
         addRequirements(controlpanel, ColorSensor);
    }

    public void initialize() {
        //m_controlpanel.Spin();
    }

    public void execute() {
        m_colorsensor.checkColor();
    }
    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {

    }
}