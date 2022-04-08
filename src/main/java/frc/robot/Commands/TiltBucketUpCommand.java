// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Joysticks.PlaystationController;
import frc.robot.Subsystem.RobotArm;

public class TiltBucketUpCommand extends CommandBase {
  private final RobotArm robotArm;
  private final PlaystationController controller;
  private final double EXTEND_SPEED = 0.5;
  public TiltBucketUpCommand(PlaystationController controller, RobotArm robotArm) {
    this.robotArm = robotArm;
    this.controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    robotArm.tiltBucket(EXTEND_SPEED);
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
