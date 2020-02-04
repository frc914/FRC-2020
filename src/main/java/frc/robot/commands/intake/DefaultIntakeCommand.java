/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

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

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
