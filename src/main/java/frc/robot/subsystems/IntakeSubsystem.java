package frc.robot.subsystems;

import com.torontocodingcollective.sensors.encoder.TEncoder;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.speedcontroller.TCanSpeedController.TCanSpeedControllerType;
import com.torontocodingcollective.subsystem.TSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.intake.DefaultIntakeCommand;


/**
 *
 */
public class IntakeSubsystem extends TSubsystem {

    TCanSpeedController intakeRollerMotor = new TCanSpeedController(RobotMap.INTAKE_ROLLER_CAN_SPEED_CONTROLLER_TYPE, RobotMap.INTAKE_ROLLER_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.INTAKE_ROLLER_MOTOR_ISINVERTED);
    TCanSpeedController wristMotor = new TCanSpeedController(RobotMap.WRIST_CAN_SPEED_CONTROLLER_TYPE, RobotMap.WRIST_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.WRIST_CAN_MOTOR_ISINVERTED);
    TCanSpeedController ballElevatorMotor = new TCanSpeedController(RobotMap.BALL_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE, RobotMap.BALL_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.BALL_ELEVATOR_CAN_MOTOR_ISINVERTED);

    TEncoder wristEncoder = new TEncoder(RobotMap.WRIST_CAN_ENCODER_ISINVERTED) {
    
        @Override
        public int get() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public double getRate() {
            // TODO Auto-generated method stub
            return 0;
        }
    };

    //3 motors - rollers, wrist, ball tower; 1 encoder - wrist; beam break - ball tower

    @Override
    public void init() {
    }

    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }

    public void fwdIntake() {
        intakeRollerMotor.set(1);
    }

    public void bkdIntake() {
        intakeRollerMotor.set(-1);
    }

    public void stopIntake() {
        intakeRollerMotor.set(0);
    }

    public void wristOut() {
        wristMotor.set(1);
    }

    public void wristIn() {
        wristMotor.set(-1);
    }

    public void stopWrist() {
        wristMotor.set(0);
    }

    public void ballElevatorUp() {
        ballElevatorMotor.set(1);
    }

    public void ballElevatorDown() {
        ballElevatorMotor.set(-1);
    }

    public void ballElevatorStop() {
        ballElevatorMotor.set(0);
    }
}
