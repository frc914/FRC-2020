package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;

// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.cscore.VideoMode.PixelFormat;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class CameraSubsystem extends TSubsystem {
    public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");    
    public double x = tx.getDouble(0.0);
    public double y = ty.getDouble(0.0);
    public double area = ta.getDouble(0.0);
   


    public static double OffsetHorizantal(){
       return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        
    }  

    public static double OffsetVertical(){
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    }

    public double LimeArea(){
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    }
    public CameraSubsystem() {

        //Uncomment this line to start a USB camera feed
        // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        // camera.setVideoMode(PixelFormat.kMJPEG, 120, 90, 50);
        // camera.setExposureManual(40);

        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

//read values periodically
double x = tx.getDouble(0.0);
double y = ty.getDouble(0.0);
double area = ta.getDouble(0.0);




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

}
