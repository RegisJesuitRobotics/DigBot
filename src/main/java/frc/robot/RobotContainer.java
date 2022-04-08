// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Commands.ExtendArmCommand;
import frc.robot.Commands.RetractArmCommand;
import frc.robot.Commands.TiltBucketDownCommand;
import frc.robot.Commands.TiltBucketUpCommand;
import frc.robot.Commands.RetractArmCommand;
import frc.robot.Joysticks.PlaystationController;
import frc.robot.Subsystem.RobotArm;


public class RobotContainer {
    private final RobotArm robotArm = new RobotArm();
    private final PlaystationController playstationController = new PlaystationController(0);
    

    public RobotContainer(){
        mapButtons();
    }

    private void mapButtons(){
            playstationController.circle.whenHeld(new ExtendArmCommand(robotArm, playstationController));
            playstationController.square.whenHeld(new RetractArmCommand(robotArm, playstationController));
            playstationController.triangle.whenHeld(new TiltBucketUpCommand(playstationController, robotArm));
            playstationController.x.whenHeld(new TiltBucketDownCommand(playstationController, robotArm));
    }       


}
