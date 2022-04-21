// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class DriveTrain extends SubsystemBase {
    private final WPI_TalonSRX leftLeader = new WPI_TalonSRX(DriveConstants.LEFT_TALON_SRX_ONE);
    private final WPI_TalonSRX rightLeader = new WPI_TalonSRX(DriveConstants.RIGHT_TALON_SRX_ONE);
    private final WPI_TalonSRX leftFollow = new WPI_TalonSRX(DriveConstants.LEFT_TALON_SRX_TWO);
    private final WPI_TalonSRX rightFollow = new WPI_TalonSRX(DriveConstants.RIGHT_TALON_SRX_TWO);

    DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);


    public DriveTrain() {
        leftFollow.follow(leftLeader);
        rightFollow.follow(rightLeader);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        
    }

    public void curvatureDrive(double xSpeed, double zRotation) {
      drive.curvatureDrive(xSpeed, zRotation, false);
    }


}
