package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import java.util.Map;
import kotlin.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.strykeforce.console.Console.Switch;
import org.strykeforce.console.ConsoleSubsystem;
import org.strykeforce.console.Font;

public class ConsoleCommand extends InstantCommand {

  private static final Logger logger = LoggerFactory.getLogger(ConsoleCommand.class);

  private static final int FONT_WIDTH = Font.FONT_5X8.getOuterWidth();

  private static final Map<Switch, Pair<Integer, Integer>> positions = Map
      .of(Switch.CENTER, new Pair<>((128 - Switch.CENTER.name().length() * FONT_WIDTH) / 2, 16),
          Switch.NORTH, new Pair<>((128 - Switch.NORTH.name().length() * FONT_WIDTH) / 2, 0),
          Switch.SOUTH, new Pair<>((128 - Switch.SOUTH.name().length() * FONT_WIDTH) / 2, 32),
          Switch.EAST, new Pair<>(100, 16),
          Switch.WEST, new Pair<>(0, 16),
          Switch.ONE, new Pair<>(0, 48),
          Switch.TWO, new Pair<>((128 - Switch.TWO.name().length() * FONT_WIDTH ) / 2, 48),
          Switch.THREE, new Pair<>(92, 48));

  private final static int Y = 16;


  public ConsoleCommand(Switch consoleSwitch, boolean on, ConsoleSubsystem consoleSubsystem) {
    super(() -> {
      var position = positions.get(consoleSwitch);
      consoleSubsystem
          .writeString(consoleSwitch.name(), position.getFirst(), position.getSecond(), on);
      logger.debug("{} button pressed", consoleSwitch);
    }, consoleSubsystem);
  }

  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
}
