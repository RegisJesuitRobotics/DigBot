package frc.robot.Utils;

public class MathUtils {
    


    private MathUtils() {}

    public static double deadZone(double value, double deadZone) {
        if (value <= -deadZone || value >= deadZone) {
            return value;
        }
        return 0;
    }
}
    

