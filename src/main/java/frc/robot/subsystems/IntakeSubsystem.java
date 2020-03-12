package frc.robot.subsystems;

import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import frc.robot.RobotMap;
import frc.robot.commands.intake.DefaultIntakeCommand;


/**
 *
 */
public class IntakeSubsystem extends TSubsystem {

    TCanSpeedController intakeRollerMotor = new TCanSpeedController(RobotMap.INTAKE_ROLLER_CAN_SPEED_CONTROLLER_TYPE, RobotMap.INTAKE_ROLLER_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.INTAKE_ROLLER_MOTOR_ISINVERTED);
    TCanSpeedController ballElevatorMotor = new TCanSpeedController(RobotMap.BALL_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE, RobotMap.BALL_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.BALL_ELEVATOR_CAN_MOTOR_ISINVERTED);
    TCanSpeedController chassisEdgeMotor = new TCanSpeedController(RobotMap.CHASSIS_EDGE_CAN_SPEED_CONTROLLER_TYPE, RobotMap.CHASSIS_EDGE_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.CHASSIS_EDGE_CAN_MOTOR_ISINVERTED);
    

    //     @Override
    //     public int get() {
    //         return 0;
    //     }

    //     @Override
    //     public double getRate() {
    //         return 0;
    //     }
    // };

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

    public void ballElevatorUp() {
        ballElevatorMotor.set(1);
    }

    public void ballElevatorDown() {
        ballElevatorMotor.set(-1);
    }

    public void ballElevatorStop() {
        ballElevatorMotor.set(0);
    }

    public void edgeIn() {
        chassisEdgeMotor.set(1);
    }

    public void edgeOut() {
        chassisEdgeMotor.set(-1);
    }

    public void edgeStop() {
        chassisEdgeMotor.set(0);
    }
}
