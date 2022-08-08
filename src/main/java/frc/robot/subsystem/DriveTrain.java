// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class DriveTrain extends SubsystemBase {
    private final WPI_VictorSPX leftLeader = new WPI_VictorSPX(DriveConstants.LEFT_TALON_SRX_FRONT);
    private final WPI_VictorSPX rightLeader = new WPI_VictorSPX(DriveConstants.RIGHT_TALON_SRX_FRONT);
    private final WPI_VictorSPX leftFollower = new WPI_VictorSPX(DriveConstants.LEFT_TALON_SRX_BACK);
    private final WPI_VictorSPX rightFollower = new WPI_VictorSPX(DriveConstants.RIGHT_TALON_SRX_BACK);

    DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);

    public DriveTrain() {
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        rightLeader.setInverted(true);
        rightFollower.setInverted(true);
    }

    public void curvatureDrive(double xSpeed, double zRotation) {
        drive.curvatureDrive(xSpeed, zRotation, true);
    }
}
