// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.simulation.PWMSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RobotArm extends SubsystemBase {
  private final int EXTEND_ARM_PORT = Constants.ArmConstants.EXTEND_ARM_PORT;
  private final int TILT_BUCKET_PORT = Constants.ArmConstants.TILT_BUCKET_PORT;
  private final PWMSim extendArm = new PWMSim(EXTEND_ARM_PORT);
  private final PWMSim tiltArm = new PWMSim(TILT_BUCKET_PORT);
  public RobotArm() {
// for SparkMaxes
// extendArm.restoreFactoryDefaults();
// extendArm.setInverted(false);
// extendArm.setIdleMode(IdleMode.kBrake);
// extendArm.burnFlash();

// tiltArm.restoreFactoryDefaults();
// tiltArm.setInverted(false);
// tiltArm.setIdleMode(IdleMode.kBrake);
// tiltArm.burnFlash();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extendArm(double extendSpeed){
      extendArm.setSpeed(extendSpeed);
  }
  public void tiltBucket(double tiltSpeed){
    tiltArm.setSpeed(tiltSpeed);
  }
}
