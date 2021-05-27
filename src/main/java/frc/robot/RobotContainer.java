package frc.robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.ConsoleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.strykeforce.console.Console.Switch;
import org.strykeforce.console.ConsoleSubsystem;


public class RobotContainer {

  private static final Logger logger = LoggerFactory.getLogger(RobotContainer.class);

  private final ConsoleSubsystem consoleSubsystem = new ConsoleSubsystem(true);

  public RobotContainer() {
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    consoleSubsystem.getButton(Switch.CENTER).whenPressed(new ConsoleCommand("CENTER", consoleSubsystem));
    consoleSubsystem.getButton(Switch.NORTH).whenPressed(new ConsoleCommand("NORTH", consoleSubsystem));
    consoleSubsystem.getButton(Switch.SOUTH).whenPressed(new ConsoleCommand("SOUTH", consoleSubsystem));
    consoleSubsystem.getButton(Switch.EAST).whenPressed(new ConsoleCommand("EAST", consoleSubsystem));
    consoleSubsystem.getButton(Switch.WEST).whenPressed(new ConsoleCommand("WEST", consoleSubsystem));

    new Button(RobotController::getUserButton)
        .whenPressed(new InstantCommand(consoleSubsystem::clear, consoleSubsystem) {
          @Override
          public boolean runsWhenDisabled() {
            return true;
          }
        });
  }


  public Command getAutonomousCommand() {
    return null;
  }
}
