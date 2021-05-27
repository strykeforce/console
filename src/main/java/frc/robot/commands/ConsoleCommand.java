package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import org.strykeforce.console.ConsoleSubsystem;

public class ConsoleCommand extends InstantCommand {

  private final static int Y = 16;

  public ConsoleCommand(String string, ConsoleSubsystem consoleSubsystem) {
    super(() -> {
      consoleSubsystem.clear();
      consoleSubsystem.writeStringCentered(string, Y);
    }, consoleSubsystem);
  }

  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
}
