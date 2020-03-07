package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

/**
 *
 */
public class WheelOfFortuneSubsystem extends TSubsystem {

    public WheelOfFortuneSubsystem() {

    }
    @Override
    public void init() {
    }

    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void spinWheel() {
 

    }
    public void findColour() {
        private final Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429);
        private final Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
        private final Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
        private final Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);
        final Color detectedColor = m_colorSensor.getColor();
        final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        final int prox = m_colorSensor.getProximity();
        if (match.color == kBlue && prox >= 175) {
         
        } else if (match.color == kRed && prox >= 175) {
            
        } else if (match.color == kGreen && prox >= 175) {
           
        } else if (match.color == kYellow && prox >= 175) {
           
        }
    }

}
