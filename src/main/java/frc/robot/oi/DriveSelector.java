package frc.robot.oi;

import com.torontocodingcollective.oi.TStick;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSelector {

    public SendableChooser<String> driveControlType;
    public SendableChooser<String> singleStickSide;

    public static final String     DRIVE_CONTROL_TYPE_ARCADE       = "Arcade";
    public static final String     DRIVE_CONTROL_TYPE_TANK         = "Tank";
    public static final String     DRIVE_CONTROL_TYPE_SINGLE_STICK = "Single Stick";

    public static final String     SINGLE_STICK_LEFT               = "Left";
    public static final String     SINGLE_STICK_RIGHT              = "Right";

    {
        // Drive Type
    }

    /**
     * Get the Drive Type
     */
    public DriveControlType getDriveControlType() {
            return DriveControlType.ARCADE;
        }


    public void updatePeriodic() {
    }
}
