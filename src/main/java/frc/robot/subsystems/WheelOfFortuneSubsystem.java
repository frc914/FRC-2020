package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import frc.robot.RobotMap;
import frc.robot.RobotMap.*;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class WheelOfFortuneSubsystem extends TSubsystem {
  public TCanSpeedController wheelMotor = new TCanSpeedController(
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE,
        RobotMap.LEFT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS,
        RobotMap.LEFT_SHOOTER_CAN_MOTOR_ISINVERTED);



        private final Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429);
        private final Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
        private final Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
        private final Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);
        final Color detectedColor = m_colorSensor.getColor();
        final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        final int prox = m_colorSensor.getProximity();
    public WheelOfFortuneSubsystem() {

    }

    public void init() {

    }

    public void spinWheel() {
        
    wheelMotor.set(0.1);

    }
    public void findColour() {
        
        if (match.color == kBlue && prox >= 175) {
         // if colour is blue spin till red is reached
            do {
                wheelMotor.set(0.2 );
            } while (detectedColour != kRed);
        } else if (match.color == kRed && prox >= 175) {
            // if colour is red spin till blue is reached
            do {
                wheelMotor.set(0.2);
            } while (detectedColour != kBlue);
        
        } else if (match.color == kGreen && prox >= 175) {
           // if colour is green spin till yellow is reached
           do {
            wheelMotor.set(0.2);
           } while (detectedColour != kYellow);
        } else if (match.color == kYellow && prox >= 175) {
           // if colour is yellow spin till green is reached
           do {
            wheelMotor.set(0.2);
            } while (detectedColour != kGreen);
        }
    }
}





   
//nice