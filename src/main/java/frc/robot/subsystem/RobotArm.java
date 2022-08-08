package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RobotArm extends SubsystemBase {
    private enum Direction {
        NONE,
        FORWARD,
        BACKWARD
    }
    private final int EXTEND_ARM_PORT = Constants.ArmConstants.EXTEND_ARM_PORT;
    private final int TILT_BUCKET_PORT = Constants.ArmConstants.TILT_BUCKET_PORT;
    private final CANSparkMax extendArm = new CANSparkMax(EXTEND_ARM_PORT, MotorType.kBrushed);
    private final CANSparkMax tiltArm = new CANSparkMax(TILT_BUCKET_PORT, MotorType.kBrushed);

    private double tiltSpeed = 0.0;
    private Direction blockedDirection = Direction.NONE;

    public RobotArm() {

    }

    @Override
    public void periodic() {
        if (blockedDirection != Direction.NONE) {
            if (blockedDirection == Direction.FORWARD)
                if (tiltSpeed > 0) {
                    tiltSpeed = 0;
                } else if (tiltSpeed < 0) {
                    blockedDirection = Direction.NONE;
                }
            if (blockedDirection == Direction.BACKWARD)
                if (tiltSpeed < 0) {
                    tiltSpeed = 0;
                } else if (tiltSpeed > 0) {
                    blockedDirection = Direction.NONE;
                }
        }
        if (tiltArm.getOutputCurrent() >= 19) {
            if (tiltSpeed > 0) {
                blockedDirection = Direction.FORWARD;
            } else if (tiltSpeed < 0) {
                blockedDirection = Direction.BACKWARD;
            }
        }

        tiltArm.set(tiltSpeed);
    }

    public void extendArm(double extendSpeed) {
        extendArm.set(extendSpeed);
    }

    public void tiltBucket(double tiltSpeed) {
        this.tiltSpeed = tiltSpeed;
    }
}
