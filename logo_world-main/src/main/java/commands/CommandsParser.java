package commands;

import env.Environment;
import env.utils.CustomException;
import env.utils.GameStatus;
import env.utils.GameStatusCode;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.Scanner;

public class CommandsParser {

    private static final Logger LOGGER = Logger.getLogger(CommandsParser.class);
    private static final String CMD_SPLIT_REGEX = "\\s+";

    private final CommandsFactory commandsFactory;
    private final Map<String, Integer> commandsArgs;

    /**
     * Create CommandParser instance
     *
     * @param environment Environment instance - for modifying robot &
     *                    field in commands
     * */
    public CommandsParser(Environment environment) {
        this.commandsFactory = new CommandsFactory(environment);
        this.commandsArgs = commandsFactory.getCommandsArgsMap();
    }
    /**
     * Parse arguments string and executes command with instance from
     * CommandsFactory, then return execution status
     *
     * @param args List of args - for tests creation
     * */
    public GameStatus readCommand(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = scanner.nextLine().split(CMD_SPLIT_REGEX);
        }
        GameStatus status = new GameStatus(GameStatusCode.ERROR, "");

        LOGGER.debug("Parsing command string");

        if (args.length == 0) {
            status.message = "Command string is empty, please, try again";
        }
        else if (!commandsArgs.containsKey(args[0].toLowerCase())) {
            status.message = "Wrong command, please, try again";
        }
        else if (commandsArgs.get(args[0].toLowerCase()) != args.length - 1) {
            status.message = "Wrong arguments number, please, try again";
        }
        else {
            try {
                LOGGER.debug("Trying to get command instance");
                Command cmd = commandsFactory.getCommandInstance(args);
                LOGGER.debug("Executing command");
                status = cmd.execute();
            }
            catch (NumberFormatException | CustomException e) {
                System.out.println("Incorrect argument(s), please, try again");
            }
        }
        return status;
    }
}
