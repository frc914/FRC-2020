/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.TUtil;
import com.torontocodingcollective.commands.TSafeCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DefaultIntakeCommand extends TSafeCommand {
  private static final String COMMAND_NAME = DefaultIntakeCommand.class.getSimpleName();

  public DefaultIntakeCommand() {
    super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);
    
    // Use requires() here to declare subsystem dependencies
    requires(Robot.intakeSubsystem);
  }

  @Override
  protected String getCommandName() {
    return COMMAND_NAME;
  }

  @Override
  protected String getParmDesc() {
    return super.getParmDesc();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (getCommandName().equals(COMMAND_NAME)) {
      logMessage(getParmDesc() + " starting");
    }
  }

  int intakePos = 0;

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //intake
    if (Robot.oi.intakeFwd()) 
      Robot.intakeSubsystem.fwdIntake();
    else if (Robot.oi.intakeBkd())
      Robot.intakeSubsystem.bkdIntake();
    else 
      Robot.intakeSubsystem.stopIntake();

    //ball elevator
    if (Robot.oi.elevatorUp()) {
      Robot.intakeSubsystem.ballElevatorUp();
      Robot.intakeSubsystem.edgeIn();
    }
    else if (Robot.oi.elevatorDown()) {
      Robot.intakeSubsystem.ballElevatorDown();
      Robot.intakeSubsystem.edgeOut();
    }
    else {
      Robot.intakeSubsystem.ballElevatorStop();
      Robot.intakeSubsystem.edgeStop();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
