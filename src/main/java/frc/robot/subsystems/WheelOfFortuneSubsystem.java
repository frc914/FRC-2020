package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import frc.robot.RobotMap;
import frc.robot.Robot;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class WheelOfFortuneSubsystem extends TSubsystem {
  public TCanSpeedController wheelMotor = new TCanSpeedController(
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.LEFT_SHOOTER_CAN_MOTOR_ISINVERTED);

        
        
      
        final Color detectedColor = Robot.m_colorSensor.getColor();
        final ColorMatchResult match = Robot.m_colorMatcher.matchClosestColor(detectedColor);
        final int prox = Robot.m_colorSensor.getProximity();
        private final Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429);
        private final Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
        private final Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
        private final Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public void init() {

    }

    public void spinWheel() {
        
    wheelMotor.set(0.5);

    }
    public void stopWheel() {
        wheelMotor.set(0.0);
    }
    public void findColour() {
        
        if (match.color == kBlue && prox >= 175) {
         // if colour is blue spin till red is reached
            do {
                wheelMotor.set(0.2);
            } while (detectedColor != kRed);
        } else if (match.color == kRed && prox >= 175) {
            // if colour is red spin till blue is reached
            do {
                wheelMotor.set(0.2);
            } while (detectedColor != kBlue);
        
        } else if (match.color == kGreen && prox >= 175) {
           // if colour is green spin till yellow is reached
           do {
            wheelMotor.set(0.2);
           } while (detectedColor != kYellow);
        } else if (match.color == kYellow && prox >= 175) {
           // if colour is yellow spin till green is reached
           do {
            wheelMotor.set(0.2);
            } while (detectedColor != kGreen);
        }
    }

    @Override
    public void updatePeriodic() {
    

    }

    @Override
    protected void initDefaultCommand() {
    

    }
}





   
//nice