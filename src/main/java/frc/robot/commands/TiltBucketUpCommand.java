// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.joysticks.XBoxController;
import frc.robot.subsystem.RobotArm;

public class TiltBucketUpCommand extends CommandBase {
    private final double TILT_SPEED = 0.5;

    private final RobotArm robotArm;

    public TiltBucketUpCommand(RobotArm robotArm) {
        this.robotArm = robotArm;

        addRequirements(robotArm);
    }

    public TiltBucketUpCommand(XBoxController xBoxController, RobotArm robotArm) {
        this.robotArm = robotArm;

        addRequirements(robotArm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        robotArm.tiltBucket(TILT_SPEED);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        robotArm.tiltBucket(0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
