// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.simulation.PWMSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RobotArm extends SubsystemBase {
  private final int EXTEND_ARM_PORT = Constants.ArmConstants.EXTEND_ARM_PORT;
  private final int TILT_BUCKET_PORT = Constants.ArmConstants.TILT_BUCKET_PORT;
  private final CANSparkMax extendArm = new CANSparkMax(EXTEND_ARM_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
  private final CANSparkMax tiltArm = new CANSparkMax(TILT_BUCKET_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
  public RobotArm() {


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extendArm(double extendSpeed){
      extendArm.set(extendSpeed);
  }
  public void tiltBucket(double tiltSpeed){
    tiltArm.set(tiltSpeed);
  }
}
