// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Joysticks.XBoxController;
import frc.robot.Commands.ExtendArmCommand;
import frc.robot.Commands.RetractArmCommand;
import frc.robot.Commands.TiltBucketDownCommand;
import frc.robot.Commands.TiltBucketUpCommand;
import frc.robot.Commands.Drive.CurvatureDrive;
import frc.robot.Commands.RetractArmCommand;
import frc.robot.Joysticks.PlaystationController;
import frc.robot.Subsystem.DriveTrain;
import frc.robot.Subsystem.RobotArm;


public class RobotContainer {
    private final RobotArm robotArm = new RobotArm();
    private final PlaystationController playstationController = new PlaystationController(0);
    private final XBoxController xboxController = new XBoxController(1);
    private final DriveTrain driveTrain = new DriveTrain();


    public RobotContainer() {
        mapButtons();
    }

    private void mapButtons() {
        playstationController.circle.whenHeld(new ExtendArmCommand(playstationController, robotArm));
        playstationController.square.whenHeld(new RetractArmCommand(playstationController, robotArm));
        playstationController.triangle.whenHeld(new TiltBucketUpCommand(playstationController, robotArm));
        playstationController.x.whenHeld(new TiltBucketDownCommand(playstationController, robotArm));
        
        driveTrain.setDefaultCommand(new CurvatureDrive(() ->  playstationController.rightTrigger.getAxis() - playstationController.leftTrigger.getAxis(), 
        () -> playstationController.leftThumb.getXAxis()));

        xboxController.x.whenHeld(new RetractArmCommand(xboxController, robotArm));
        xboxController.y.whenHeld(new TiltBucketUpCommand(xboxController, robotArm));
        xboxController.a.whenHeld(new TiltBucketDownCommand(xboxController, robotArm));
        xboxController.b.whileHeld(new ExtendArmCommand(xboxController, robotArm));
    }


}
