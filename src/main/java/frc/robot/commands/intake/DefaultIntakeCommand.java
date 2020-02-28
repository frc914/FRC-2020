/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import javax.lang.model.util.ElementScanner6;

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

    //wrist
    //Position 1
    if (Robot.oi.wristUp())
      if (intakePos == 3) {
        Robot.intakeSubsystem.wristIn();
        Timer.delay(0.4);
        Robot.intakeSubsystem.stopWrist();
        intakePos = 1;
      } 
      else if (intakePos != 1) {
        Robot.intakeSubsystem.wristIn();
        Timer.delay(0.8);
        Robot.intakeSubsystem.stopWrist();
        intakePos = 1;
      }
    //Position 2
    else if (Robot.oi.wristDown()) {
      if (intakePos == 3) {
        Robot.intakeSubsystem.wristOut();
        Timer.delay(0.4);
        Robot.intakeSubsystem.stopWrist();
        intakePos = 2;
      }
      else if (intakePos != 2) {
        Robot.intakeSubsystem.wristOut();
        Timer.delay(0.8);
        Robot.intakeSubsystem.stopWrist();
        intakePos = 2;
      }
    }
    else {
      Robot.intakeSubsystem.stopWrist();  
    }

    //ball elevator
    if (Robot.oi.elevatorUp()) {
      Robot.intakeSubsystem.ballElevatorUp();
    }
    else if (Robot.oi.elevatorDown()) {
      Robot.intakeSubsystem.ballElevatorDown();
    }
    else {
      Robot.intakeSubsystem.ballElevatorStop();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
