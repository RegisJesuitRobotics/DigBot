// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.joysticks.XBoxController;
import frc.robot.commands.ExtendArmCommand;
import frc.robot.commands.RetractArmCommand;
import frc.robot.commands.TiltBucketDownCommand;
import frc.robot.commands.TiltBucketUpCommand;
import frc.robot.commands.drive.CurvatureDrive;
import frc.robot.joysticks.PlaystationController;
import frc.robot.subsystem.DriveTrain;
import frc.robot.subsystem.RobotArm;

public class RobotContainer {
    private final DriveTrain driveTrain = new DriveTrain();
    private final RobotArm robotArm = new RobotArm();

    private final PlaystationController playstationController = new PlaystationController(0);
//    private final XBoxController xboxController = new XBoxController(1);


    public RobotContainer() {
        mapButtons();
    }

    private void mapButtons() {
        driveTrain.setDefaultCommand(new CurvatureDrive(
                () -> playstationController.rightTrigger.getAxis() - playstationController.leftTrigger.getAxis(),
                playstationController.leftThumb::getXAxis, driveTrain));

        playstationController.circle.whenHeld(new ExtendArmCommand(robotArm));
        playstationController.square.whenHeld(new RetractArmCommand(robotArm));
        playstationController.triangle.whenHeld(new TiltBucketUpCommand(robotArm));
        playstationController.x.whenHeld(new TiltBucketDownCommand(robotArm));

//        xboxController.x.whenHeld(new RetractArmCommand(robotArm));
//        xboxController.y.whenHeld(new TiltBucketUpCommand(robotArm));
//        xboxController.a.whenHeld(new TiltBucketDownCommand(robotArm));
//        xboxController.b.whenHeld(new ExtendArmCommand(robotArm));
    }
}
