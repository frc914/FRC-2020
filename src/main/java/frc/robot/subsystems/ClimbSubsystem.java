package frc.robot.subsystems;

import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;



/**
 *
 */
public class ClimbSubsystem extends TSubsystem {
    public TCanSpeedController leftClimbMotor = new TCanSpeedController(
        RobotMap.LEFT_CLIMB_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.LEFT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.LEFT_CLIMB_CAN_MOTOR_ISINVERTED);

    public TCanSpeedController rightClimbMotor = new TCanSpeedController(
        RobotMap.RIGHT_CLIMB_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.RIGHT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.RIGHT_CLIMB_CAN_MOTOR_ISINVERTED);
  
    Solenoid climbLock =new Solenoid(RobotMap.CLIMB_LOCK);
    
    public void goUp(){
        unlockClimb();
        leftClimbMotor.set(1.0);
        rightClimbMotor.set(1.0);
    }

    public void goDown(){
        unlockClimb();
        leftClimbMotor.set(-1.0);
        rightClimbMotor.set(-1.0);
    }

    public void stopClimb(){
        lockClimb();
        leftClimbMotor.set(0.0);
        rightClimbMotor.set(0.0);
    }

    public void lockClimb(){
        climbLock.set(false);
    }

    public void unlockClimb(){
        climbLock.set(true);
    }

    @Override
    public void init() {
        

    }

    @Override
    public void updatePeriodic() {
        

    }

    @Override
    protected void initDefaultCommand() {
        

    }



}
