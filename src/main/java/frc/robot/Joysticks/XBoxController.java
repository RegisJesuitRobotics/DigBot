// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Joysticks;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class XBoxController extends GenericController{
    public final JoystickButton x = new JoystickButton(this, Button.kX.value);
    public final JoystickButton y = new JoystickButton(this, Button.kY.value);
    public final JoystickButton b = new JoystickButton(this, Button.kB.value);
    public final JoystickButton a = new JoystickButton(this, Button.kA.value);
    public XBoxController(int port){
        super(port);
    }
}
