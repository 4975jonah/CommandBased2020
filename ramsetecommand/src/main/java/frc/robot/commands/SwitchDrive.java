/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Shifter;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class SwitchDrive extends CommandBase {
    private SwitchDrive m_switchdrive;
    private int m_direction = 1;
    
    
    public SwitchDrive(int direction) {
        m_direction = direction = -1;
    }
    
    public void initialize() {
    }
    
    public void execute() {
        
    }
    
    public boolean isFinished() {
        return false;
    }
    
    public void end() {
        
    }
    
    public void interrupted() {
        
    }
}
