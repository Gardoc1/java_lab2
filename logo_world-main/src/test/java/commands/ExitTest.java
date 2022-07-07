package commands;

import env.Environment;
import env.utils.GameStatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitTest {

    @Test
    void execute() {
        Environment environment = new Environment();
        CommandsParser commandsParser = new CommandsParser(environment);

        String[] args1 = new String[]{"exit", "someArgument"};
        String[] args2 = new String[]{"exit"};

        // Args 1
        assertEquals(
                commandsParser.readCommand(args1).code,
                GameStatusCode.ERROR
        );
        // Args 2
        assertEquals(
                commandsParser.readCommand(args2).code,
                GameStatusCode.EXIT
        );
    }
}