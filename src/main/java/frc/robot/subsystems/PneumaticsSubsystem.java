package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.pneumatics.DefaultPneumaticsCommand;

/**
 *
 */
public class PneumaticsSubsystem extends TSubsystem {

    // uncomment the compressor to enable pneumatics control
    Compressor compressor = new Compressor();

    @Override
    public void init() {
        if (compressor != null) {
            compressor.setClosedLoopControl(true);
        }
    };

    public void disableCompressor() {
        if (compressor != null) {
            compressor.setClosedLoopControl(false);
        }
    }

    public void enableCompressor() {
        if (compressor != null) {
            compressor.setClosedLoopControl(true);
        }
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultPneumaticsCommand());
    }

    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {

    }

}
