package frc.robot.commands;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.drive.TDriveTimeCommand;
import com.torontocodingcollective.commands.gyroDrive.TDriveOnHeadingDistanceCommand;
import com.torontocodingcollective.commands.gyroDrive.TRotateToHeadingCommand;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.oi.AutoSelector;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;

/**
 * AutonomousCommand
 * <p>
 * This class extends the CommandGroup class which allows for a string of
 * commands to be chained together to create complex auto patterns.
 */
public class AutonomousCommand extends CommandBase{
        static TCanSpeedController leftDriveMotor = new TCanSpeedController(RobotMap.LEFT_DRIVE_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.LEFT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.LEFT_DRIVE_CAN_MOTOR_ISINVERTED);

        static TCanSpeedController rightDriveMotor = new TCanSpeedController(RobotMap.RIGHT_DRIVE_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.RIGHT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.RIGHT_DRIVE_CAN_MOTOR_ISINVERTED);

    public static final char LEFT   = 'L';
    public static final char RIGHT  = 'R';
    public static final char CENTER = 'C';
    Timer timer;

    /**
     * Autonomous Command
     * <p>
     * Construct an Autonomous Command to perform the auto portion of the robot
     * game. This command will be built when the constructor is called and each
     * element of the command will execute in order.
     * <p>
     * When a parallel command is started, it will act at the same time as all other
     * parallel commands and the next serial command. Parallel commands can end
     * before the serial command, however, when the serial command is complete, all
     * parallel commands will be interrupted at that time if they have not already
     * finished.
     * <p>
     * Since the commands are all constructed at the same instant (when this
     * constructor is called), the commands should not read sensor information in
     * the constructor. All commands should read any relevant sensor information
     * (speed, heading, position) in the init() method of the command. The init()
     * method will be run when the command starts and so can get the robot
     * information at the start of the command, the constructor will be run
     * immediately when the Auto CommandGroup is constructed, and will not have the
     * sensor information relevant to when the command is run.
     */
    public AutonomousCommand() {
            //TODO use getAngle(), reset() to find out where it is located and to reset it at begining
            
            
        // getting info

        timer = new Timer();
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        if(timer.advanceIfElapsed(4.0)){
                //drive forward
                // leftDriveMotor.set(-0.1);
                // rightDriveMotor.set(-0.1);
        } else{
                //shoot
                if(timer.advanceIfElapsed(1.0)){
                        ShooterSubsystem.wristDown();
                }
                else if(timer.advanceIfElapsed(2.0)){
                        IntakeSubsystem.ballElevatorUp();
                        ShooterSubsystem.shootFwd();
                }
        }
    }

    @Override
    public void end(boolean interrupted){
        //stp driving
        leftDriveMotor.set(0.0);
        rightDriveMotor.set(0.0);
    }

    @Override
    public boolean isFinished(){
        return timer.advanceIfElapsed(8.0);
    }
}
