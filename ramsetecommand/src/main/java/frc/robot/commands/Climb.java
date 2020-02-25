/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.Motor_Climber;

public class Climb extends CommandBase {
    private final Motor_Climber m_climber;
    private final DoubleSupplier m_speed;

    public Climb(Motor_Climber climber,DoubleSupplier speed) {
        m_speed = speed;
        m_climber = climber;
        addRequirements(m_climber);
    }

    public void initialize() {
        Double speed;
        speed = m_speed.getAsDouble();
        m_climber.climbUp(speed);
    }

    public void execute() {
        Double speed;
        speed = m_speed.getAsDouble();
        m_climber.climbUp(speed);
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {

    }
}