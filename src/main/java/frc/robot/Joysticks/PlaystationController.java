// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Joysticks;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS4Controller.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class PlaystationController extends GenericController{
  /** Creates a new PlaystationController. */
 
    public final JoystickButton square = new JoystickButton(this, Button.kSquare.value);
    public final JoystickButton x = new JoystickButton(this, Button.kCross.value);
    public final JoystickButton circle = new JoystickButton(this, Button.kCircle.value);
    public final JoystickButton triangle = new JoystickButton(this, Button.kTriangle.value);

    public final JoystickButton leftButton = new JoystickButton(this, Button.kL1.value);
    public final JoystickButton rightButton = new JoystickButton(this, Button.kR1.value);

    public final Trigger leftTrigger = new Trigger(this, Axis.kL2.value);
    public final Trigger rightTrigger = new Trigger(this, Axis.kR2.value);

    public final JoystickButton share = new JoystickButton(this, Button.kShare.value);
    public final JoystickButton options = new JoystickButton(this, Button.kOptions.value);

    public final ThumbStick leftThumb = new ThumbStick(this, Button.kL3.value, Axis.kLeftX.value, Axis.kLeftY.value);
    public final ThumbStick rightThumb = new ThumbStick(this, Button.kR3.value, Axis.kRightX.value, Axis.kRightY.value);

    public final JoystickButton playstationButton = new JoystickButton(this, Button.kPS.value);
    public final JoystickButton touchpad = new JoystickButton(this, Button.kTouchpad.value);

    public final DPad dPad = new DPad(this);

  

  public PlaystationController(int port){
    super(port);
  }
}
