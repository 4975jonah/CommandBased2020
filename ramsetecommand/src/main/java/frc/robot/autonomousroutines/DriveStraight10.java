/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomousroutines;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.BallHolder;
import frc.robot.commands.HoldBall;
import frc.robot.commands.ReleaseBall;
import frc.robot.commands.Wait;

public class DriveStraight10 extends CommandBase {
    public BallHolder m_ballholder;

    public DriveStraight10(BallHolder ballholder) {
        m_ballholder = ballholder;
        addRequirements(ballholder);
    }

    public void initialize() {
    }

    public void execute() {
        new SequentialCommandGroup(
            new HoldBall(m_ballholder),
            new Wait(1),
            new ReleaseBall(m_ballholder));
    }

    public boolean isFinished() {
        return true;
    }

    public void end() {
    }

    public void interruped() {
    }
}