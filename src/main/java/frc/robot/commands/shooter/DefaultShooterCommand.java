package frc.robot.commands.shooter;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.TUtil;
import com.torontocodingcollective.commands.TSafeCommand;
import com.torontocodingcollective.oi.TOi;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DefaultShooterCommand extends TSafeCommand {

    private static final String COMMAND_NAME =
            DefaultShooterCommand.class.getSimpleName();

    public DefaultShooterCommand() {

        super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);

        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooterSubsystem);
    }

    @Override
    protected String getCommandName() { return COMMAND_NAME; }

    @Override
    protected String getParmDesc() {
        return super.getParmDesc();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        // Print the command parameters if this is the current
        // called command (it was not sub-classed)
        if (getCommandName().equals(COMMAND_NAME)) {
            logMessage(getParmDesc() + " starting");
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        if (Robot.oi.wristUp()) {
            Robot.shooterSubsystem.wristUp();
          }
          else if (Robot.oi.wristDown()) {
            Robot.shooterSubsystem.wristDown();
          }
          else {
            Robot.shooterSubsystem.wristStop();
          }
        

        //Shooter
        if (Robot.oi.shoot()) {
            Robot.shooterSubsystem.shootFwd();
          }
          else if (Robot.oi.shootBack()) {
            Robot.shooterSubsystem.shootBkd();
          }
          else {
            Robot.shooterSubsystem.shootStop();
          }
        }  

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }
  }

