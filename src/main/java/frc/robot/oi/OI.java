package frc.robot.oi;

import com.torontocodingcollective.oi.TButton;
import com.torontocodingcollective.oi.TGameController;
import com.torontocodingcollective.oi.TGameController_Logitech;
import com.torontocodingcollective.oi.TGameController_Xbox;
import com.torontocodingcollective.oi.TOi;
import com.torontocodingcollective.oi.TRumbleManager;
import com.torontocodingcollective.oi.TStick;
import com.torontocodingcollective.oi.TStickPosition;
import com.torontocodingcollective.oi.TToggle;
import com.torontocodingcollective.oi.TTrigger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

/**
 * Driver Controller (inherited from TOi)
 *
 * Sticks: Right Stick = Drive Stick Left Stick = Drive Stick Right Stick Press
 * = Toggle PIDs Left Stick Press = Toggle Compressor
 *
 * Buttons: Start Button = Reset Encoders and Gyro Back Button = Cancel any
 * Command
 *
 * Bumpers/Triggers: Left Bumper = Turbo shift
 *
 * POV: Any Angle = Rotate to the Pressed Angle
 *
 */
public class OI extends TOi {

    private TGameController driverController = new TGameController_Xbox(0);
    private TRumbleManager  driverRumble     = new TRumbleManager("Driver", driverController);
    private TGameController opController     = new TGameController_Xbox(1); //TODO change if necessary, i just needed it to exist

    private TToggle         compressorToggle = new TToggle(driverController, TStick.LEFT);
    private TToggle         speedPidToggle   = new TToggle(driverController, TStick.RIGHT);

    private DriveSelector   driveSelector    = new DriveSelector();

    @Override
    public boolean getCancelCommand() {
        return driverController.getButton(TButton.BACK);
    }

    public boolean getCompressorEnabled() {
        return compressorToggle.get();
    }

    @Override
    public TStickPosition getDriveStickPosition(TStick stick) {
        return driverController.getStickPosition(stick);
    }

    @Override
    public boolean getReset() {
        return driverController.getButton(TButton.START);
    }

    @Override
    public int getRotateToHeading() {
        return driverController.getPOV();
    }

    /**
     * Get the selected drive type
     *
     * @return {@link DriveControlType} selected on the SmartDashboard. The default
     *         drive type is {@link DriveControlType#ARCADE}
     */
    public DriveControlType getSelectedDriveType() {
        return driveSelector.getDriveControlType();
    }

    /**
     * Get the selected single stick side
     *
     * @return {@link TStick} selected on the SmartDashboard. The default single
     *         stick drive is {@link TStick#RIGHT}
     */

    @Override
    public boolean getSpeedPidEnabled() {
        return speedPidToggle.get();
    }

    public boolean getTurboOn() {
        return driverController.getButton(TButton.LEFT_BUMPER);
    }

    public void init() {
        compressorToggle.set(true);
        speedPidToggle.set(false);
    }

    public void setSpeedPidEnabled(boolean state) {
        speedPidToggle.set(state);
    }

    /************************
    *       Driver        *
    *************************/
    //TODO also change, also needed their existence
    public boolean shoot() {
        return driverController.getButton(TTrigger.LEFT);
    }

    public boolean shootBack() {
        return driverController.getButton(TTrigger.RIGHT);
    }

    /************************
    *       OPERATOR        *
    *************************/
    //TODO also change, also needed their existence
    public boolean intakeFwd() {
        return opController.getButton(TTrigger.LEFT);
    }

    public boolean intakeBkd() {
        return opController.getButton(TTrigger.RIGHT);
    }

    public boolean elevatorUp() {
        return opController.getButton(TButton.A);
    }

    public boolean elevatorDown() {
        return opController.getButton(TButton.B);
    }

    public boolean wristUp() {
        return opController.getButton(TButton.Y);
    }

    public boolean wristDown() {
        return opController.getButton(TButton.X);
    }

    @Override
    public void updatePeriodic() {

        // Update all Toggles
        compressorToggle.updatePeriodic();
        speedPidToggle.updatePeriodic();
        driverRumble.updatePeriodic();

        // Update all SmartDashboard values
 }
}
