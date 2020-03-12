package frc.robot.subsystems;

import com.torontocodingcollective.sensors.encoder.TEncoder;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import frc.robot.RobotConst;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;
import frc.robot.commands.shooter.DefaultShooterCommand;


/**
 *
 */
public class ShooterSubsystem extends TSubsystem {

    // When these error ignore it, its dumb and does that. Thank you VS Code!
    TCanSpeedController leftMotor = new TCanSpeedController(
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.LEFT_SHOOTER_CAN_MOTOR_ISINVERTED);

    TCanSpeedController rightMotor = new TCanSpeedController(
        RobotMap.RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.RIGHT_SHOOTER_CAN_MOTOR_ISINVERTED);

    TCanSpeedController wristMotor = new TCanSpeedController(
        RobotMap.WRIST_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.WRIST_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.WRIST_CAN_MOTOR_ISINVERTED);
    
    TEncoder leftEncoder = leftMotor.getEncoder();
    TEncoder rightEncoder = rightMotor.getEncoder();
    TEncoder wristEncoder = wristMotor.getEncoder();

    public void init() {
        
    }

    public void shootFwd() {
        leftMotor.set(1.0);
        rightMotor.set(1.0);
    }

    public void shootBkd() {
        leftMotor.set(-1.0);
        rightMotor.set(-1.0);
    }

    public void shootStop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public void bankLeft() {
        leftMotor.set(0.9);
        rightMotor.set(1.0);
    }

    public void bankRight() {
        leftMotor.set(1.0);
        rightMotor.set(0.9);
    }

    public void wristUp() {
        wristMotor.set(-0.25);
        wristMotor.set(-0.25);
    }

    public void wristDown() {
        wristMotor.set(0.25);
        wristMotor.set(0.25);
    }

    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultShooterCommand());
    }

	public void wristStop() {
        wristMotor.set(0);
        wristMotor.set(0);
	}

}
