
package frc.robot;

import java.util.ArrayList;
import java.util.List;

import com.torontocodingcollective.subsystem.TSubsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;




import frc.robot.commands.AutonomousCommand;
import frc.robot.oi.AutoSelector;
import frc.robot.oi.OI;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.CanDriveSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.PowerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.WheelOfFortuneSubsystem;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

    public static final List<TSubsystem>    subsystemLs         = new ArrayList<TSubsystem>();

    public static final CanDriveSubsystem   driveSubsystem      = new CanDriveSubsystem();
    public static final PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
    public static final PowerSubsystem      powerSubsystem      = new PowerSubsystem();
    public static final CameraSubsystem     cameraSubsystem     = new CameraSubsystem();
    public final        ADXRS450_Gyro       gyro                = new ADXRS450_Gyro(Port.kOnboardCS0);
  
    public static final IntakeSubsystem             intakeSubsystem             = new IntakeSubsystem();
    public static final ShooterSubsystem            shooterSubsystem            = new ShooterSubsystem();
    public static final WheelOfFortuneSubsystem     wheeloffortunateSubsystem   = new WheelOfFortuneSubsystem();

    public static OI                        oi;

    private Command                         autoCommand;

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();

    private final Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public String colorString;

    // Add all of the subsystems to the subsystem list
    static {
        subsystemLs.add(driveSubsystem);
        subsystemLs.add(pneumaticsSubsystem);
        subsystemLs.add(powerSubsystem);
        subsystemLs.add(cameraSubsystem);
        subsystemLs.add(intakeSubsystem);
        subsystemLs.add(shooterSubsystem);
        subsystemLs.add(wheeloffortunateSubsystem);
    }

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
    
        oi = new OI();
        oi.init();

        for (final TSubsystem subsystem : subsystemLs) {
            subsystem.init();
        }
        
        AutoSelector.init();

        m_colorMatcher.addColorMatch(kBlue);
        m_colorMatcher.addColorMatch(kGreen);
        m_colorMatcher.addColorMatch(kRed);
        m_colorMatcher.addColorMatch(kYellow);
        
        gyro.calibrate();
    }

    

    @Override
    public void robotPeriodic() {
        final Color detectedColor = m_colorSensor.getColor();
        final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        final int prox = m_colorSensor.getProximity();
        boolean inRange = false;

        // Colour Checking (Printed to Shuffleboard)
        if (match.color == kBlue && prox >= 175) {
            colorString = "Blue"; 
        } else if (match.color == kRed && prox >= 175) {
            colorString = "Red";
        } else if (match.color == kGreen && prox >= 175) {
            colorString = "Green";
        } else if (match.color == kYellow && prox >= 175) {
            colorString = "Yellow";
        } else {
            colorString = "idk man";
        }
        
        // Range Checking (Printed to Shuffleboard)
        if(prox >= 175){
            inRange = true;
        }else{
            inRange = false;
        }
        //gyro b r o k e
         double currAng = gyro.getAngle();
         currAng=currAng - 0.155;
        //TODO Tune the range to an accurate distance for WheelOfFortune
        SmartDashboard.putBoolean("Range", inRange);
        SmartDashboard.putNumber("Rng", prox);
        SmartDashboard.putString("Color", colorString);
        
        SmartDashboard.putNumber("Gyro", (int)currAng);

    }
 
    /**
     * This function is called once each time the robot enters Disabled mode. You
     * can use it to reset any subsystem information you want to clear when the
     * robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

        oi.updatePeriodic();

        Scheduler.getInstance().run();
        updatePeriodic();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString code to get the
     * auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons to
     * the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {

        // Turn on the drive pids for auto
        Robot.oi.setSpeedPidEnabled(true);
        driveSubsystem.enableSpeedPids();

        // Reset the gyro and the encoders
        Robot.driveSubsystem.setGyroAngle(0);
        Robot.driveSubsystem.resetEncoders();

        // Initialize the robot command after initializing the game data
        // because the game data will be used in the auto command.
        autoCommand = new AutonomousCommand();
        autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {

        // Update the OI before running the commands
        oi.updatePeriodic();

        Scheduler.getInstance().run();

        // Update all subsystems after running commands
        updatePeriodic();
    }

    @Override
    public void teleopInit() {

        if (autoCommand != null) {
            autoCommand.cancel();
        }

        // Turn off the drive PIDs
        // Save the battery in teleop by using the
        // SpeedController built in braking.
        Robot.oi.setSpeedPidEnabled(false);
        driveSubsystem.disableSpeedPids();

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {

        // Update the OI before running the commands
        oi.updatePeriodic();

        Scheduler.getInstance().run();

        // Update all subsystems after running commands
        updatePeriodic();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    }

    /**
     * Update periodic
     */
    private void updatePeriodic() {

        // Update all subsystems
        for (final TSubsystem subsystem : subsystemLs) {
            subsystem.updatePeriodic();
        }
    }
}
