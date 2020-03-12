package frc.robot.subsystems;

import com.torontocodingcollective.subsystem.TSubsystem;

// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.cscore.VideoMode.PixelFormat;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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

    public double OffsetVertical(){
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

        /*
         * Switchable camera feed
         
    	// The cameraFeed used in grip should be the switchable camera.
    	//
    	// The cameras are assigned IP addresses in order.  
    	// Add the switchable source first so that it is assigned the 
    	// IP address:
    	// http://roborio-team-frc.local:1181/?action=stream
    	//
    	// Use the above IP address to display the switching feed in the 
    	// SmartDashboard (not shuffleboard) by adding an MJPEG Stream viewer at that URL.
    	//
    	// In GRIP, the selected camera source can be used for vision tracking
    	// by using an IP camera at the above URL.
    	//
    	// NOTE: There is no way to display the switched view in the current
    	//       Shuffleboard because the "Selected Camera" does not appear
    	//       as a camera source in the Shuffleboard.
        cameraFeed = CameraServer.getInstance().addServer("Selected Camera");

        // Start the front camera.
        // The URL of the front camera will be 
    	// http://roborio-team-frc.local:1182/?action=stream
        //
        // NOTE:  If there are no listeners on the 1182 port, the Camera Server will
        //        shift the port number of the frontCamera to 1181 whenever it is selected
        //        as the source, and will return to port 1182 when the selection is set to 
        //        another camera.
        frontCamera = CameraServer.getInstance().startAutomaticCapture("Front Camera", 1);
        frontCamera.setVideoMode(PixelFormat.kMJPEG, 120, 90, 50);
        frontCamera.setExposureManual(40);
        
        // Start the Rear camera.
        // The URL of the front camera will be 
    	// http://roborio-team-frc.local:1183/?action=stream
        rearCamera  = CameraServer.getInstance().startAutomaticCapture("Rear Camera", 0);
        rearCamera.setVideoMode(PixelFormat.kMJPEG, 120, 90, 50);
        rearCamera.setExposureManual(40);

        // Set the starting feed to the front camera.
        cameraFeed.setSource(frontCamera);
		curCamera = Camera.FRONT;

		*/
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
