package frc.robot;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.sensors.gyro.TAnalogGyro;
import com.torontocodingcollective.speedcontroller.TCanSpeedController.TCanSpeedControllerType;
import com.torontocodingcollective.speedcontroller.TPwmSpeedController.TPwmSpeedControllerType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * <p>
 * This map is intended to define the wiring only. Robot constants should be put
 * in {@link RobotConst}
 */
public class RobotMap {

    // ******************************************
    // Speed Controllers and encoders
    // CAN addresses
    // ******************************************
    public static final int                     LEFT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_DRIVE_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_DRIVE_CAN_MOTOR_ISINVERTED;

    public static final int                     RIGHT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_DRIVE_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_DRIVE_CAN_MOTOR_ISINVERTED;

    public static final boolean                 LEFT_DRIVE_CAN_ENCODER_ISINVERTED;
    public static final boolean                 RIGHT_DRIVE_CAN_ENCODER_ISINVERTED;

    public static final TCanSpeedControllerType INTAKE_ROLLER_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     INTAKE_ROLLER_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final boolean                 INTAKE_ROLLER_MOTOR_ISINVERTED;

    public static final TCanSpeedControllerType WRIST_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     WRIST_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final boolean                 WRIST_CAN_MOTOR_ISINVERTED;
    public static final boolean                 WRIST_CAN_ENCODER_ISINVERTED;

    public static final TCanSpeedControllerType BALL_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     BALL_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final boolean                 BALL_ELEVATOR_CAN_MOTOR_ISINVERTED;
    
    public static final int                     LEFT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_SHOOTER_CAN_MOTOR_ISINVERTED;

    public static final int                     RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_SHOOTER_CAN_MOTOR_ISINVERTED;
    
    public static final int                     WHEEL_FORTUNE_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType WHEEL_FORTUNE_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 WHEEL_FORTUNE_CAN_MOTOR_ISINVERTED;

    public static final int                     LEFT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_CLIMB_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_CLIMB_CAN_MOTOR_ISINVERTED;

    public static final int                     RIGHT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_CLIMB_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_CLIMB_CAN_MOTOR_ISINVERTED;

    public static final boolean                 LEFT_SHOOTER_CAN_ENCODER_ISINVERTED;
    public static final boolean                 RIGHT_SHOOTER_CAN_ENCODER_ISINVERTED;
    public static final boolean                 WHEEL_FORTUNE_CAN_ENCODER_ISINVERTED;
    public static final boolean                 LEFT_CLIMB_CAN_ENCODER_ISINVERTED;
    public static final boolean                 RIGHT_CLIMB_CAN_ENCODER_ISINVERTED;



    // ******************************************
    // PWM addresses
    // ******************************************

    // ******************************************
    // Gyro Ports
    // ******************************************
    public static final int                     ANALOG_PORT;
    public static final boolean                 ANALOG_ISINVERTED;

    // ******************************************
    // Pneumatics Ports
    // ******************************************
    public static final int                     SHIFTER_PNEUMATIC_PORT = 0;

    // Initializers if this code will be deployed to more than one
    // robot with different mappings
    static {

        switch (RobotConst.robot) {

        case RobotConst.TEST_ROBOT:
        default:
            // CAN Constants
            // Talons, Victors and Sparks connected through the CAN Bus
            LEFT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS           = 1;
            LEFT_DRIVE_CAN_SPEED_CONTROLLER_TYPE              = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS  = 4;
            LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE     = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_DRIVE_CAN_MOTOR_ISINVERTED                   = TConst.INVERTED;
            LEFT_DRIVE_CAN_ENCODER_ISINVERTED                 = TConst.INVERTED;

            RIGHT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS          = 2;
            RIGHT_DRIVE_CAN_SPEED_CONTROLLER_TYPE             = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS = 3;
            RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE    = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_DRIVE_CAN_MOTOR_ISINVERTED                  = TConst.NOT_INVERTED;
            RIGHT_DRIVE_CAN_ENCODER_ISINVERTED                = TConst.NOT_INVERTED;

            INTAKE_ROLLER_CAN_SPEED_CONTROLLER_ADDRESS        = 7; // TODO: check/change
            INTAKE_ROLLER_CAN_SPEED_CONTROLLER_TYPE           = TCanSpeedControllerType.VICTOR_SPX;
            INTAKE_ROLLER_MOTOR_ISINVERTED                    = TConst.NOT_INVERTED;
            
            WRIST_CAN_SPEED_CONTROLLER_ADDRESS                = 8; // TODO: check/change
            WRIST_CAN_SPEED_CONTROLLER_TYPE                   = TCanSpeedControllerType.TALON_SRX;
            WRIST_CAN_MOTOR_ISINVERTED                        = TConst.NOT_INVERTED;
            WRIST_CAN_ENCODER_ISINVERTED                      = TConst.NOT_INVERTED;

            BALL_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS        = 9; // TODO: check/change
            BALL_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE           = TCanSpeedControllerType.VICTOR_SPX;
            BALL_ELEVATOR_CAN_MOTOR_ISINVERTED                = TConst.NOT_INVERTED;
            
            LEFT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS           = 5;
            LEFT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE              = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_SHOOTER_CAN_MOTOR_ISINVERTED                   = TConst.INVERTED;
            LEFT_SHOOTER_CAN_ENCODER_ISINVERTED                 = TConst.INVERTED;

            RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_ADDRESS          = 6;
            RIGHT_SHOOTER_CAN_SPEED_CONTROLLER_TYPE             = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_SHOOTER_CAN_MOTOR_ISINVERTED                  = TConst.NOT_INVERTED;
            RIGHT_SHOOTER_CAN_ENCODER_ISINVERTED                = TConst.NOT_INVERTED;

            WHEEL_FORTUNE_CAN_SPEED_CONTROLLER_ADDRESS          = 10;
            WHEEL_FORTUNE_CAN_SPEED_CONTROLLER_TYPE;            = TCanSpeedControllerType.TALON_SRX;
            WHEEL_FORTUNE_CAN_MOTOR_ISINVERTED;                 = TConst.NOT_INVERTED;
            WHEEL_FORTUNE_CAN_ENCODER_ISINVERTED;               = TConst.NOT_INVERTED;

            LEFT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS             = 11;
            LEFT_CLIMB_CAN_SPEED_CONTROLLER_TYPE;               = TCanSpeedControllerType.TALON_SRX;
            LEFT_CLIMB_CAN_MOTOR_ISINVERTED;                    = TConst.NOT_INVERTED;
            LEFT_CLIMB_CAN_ENCODER_ISINVERTED;                  = TConst.NOT_INVERTED;

            RIGHT_CLIMB_CAN_SPEED_CONTROLLER_ADDRESS             = 12;
            RIGHT_CLIMB_CAN_SPEED_CONTROLLER_TYPE;               = TCanSpeedControllerType.TALON_SRX;
            RIGHT_CLIMB_CAN_MOTOR_ISINVERTED;                    = TConst.NOT_INVERTED;
            RIGHT_CLIMB_CAN_ENCODER_ISINVERTED;                  = TConst.NOT_INVERTED;

            // PWM Constants
            // Talons, Victors and Sparks connected through Pwm

            ANALOG_PORT       = 0;
            ANALOG_ISINVERTED = TConst.NOT_INVERTED;
        }
    }
}
