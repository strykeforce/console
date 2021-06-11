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
    consoleSubsystem.getButton(Switch.CENTER)
        .whenPressed(new ConsoleCommand(Switch.CENTER, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.CENTER)
        .whenReleased(new ConsoleCommand(Switch.CENTER, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.NORTH)
        .whenPressed(new ConsoleCommand(Switch.NORTH, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.NORTH)
        .whenReleased(new ConsoleCommand(Switch.NORTH, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.SOUTH)
        .whenPressed(new ConsoleCommand(Switch.SOUTH, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.SOUTH)
        .whenReleased(new ConsoleCommand(Switch.SOUTH, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.EAST)
        .whenPressed(new ConsoleCommand(Switch.EAST, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.EAST)
        .whenReleased(new ConsoleCommand(Switch.EAST, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.WEST)
        .whenPressed(new ConsoleCommand(Switch.WEST, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.WEST)
        .whenReleased(new ConsoleCommand(Switch.WEST, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.NORTH)
        .whenPressed(new ConsoleCommand(Switch.NORTH, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.NORTH)
        .whenReleased(new ConsoleCommand(Switch.NORTH, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.ONE)
        .whenPressed(new ConsoleCommand(Switch.ONE, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.ONE)
        .whenReleased(new ConsoleCommand(Switch.ONE, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.TWO)
        .whenPressed(new ConsoleCommand(Switch.TWO, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.TWO)
        .whenReleased(new ConsoleCommand(Switch.TWO, false, consoleSubsystem));

    consoleSubsystem.getButton(Switch.THREE)
        .whenPressed(new ConsoleCommand(Switch.THREE, true, consoleSubsystem));
    consoleSubsystem.getButton(Switch.THREE)
        .whenReleased(new ConsoleCommand(Switch.THREE, false, consoleSubsystem));

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
