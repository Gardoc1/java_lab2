package commands;

import env.Environment;
import env.utils.GameStatusCode;
import org.junit.jupiter.api.Test;
import env.utils.Coords;
import env.utils.CustomException;
import env.utils.Size;

import static org.junit.jupiter.api.Assertions.*;

class TeleportTest {

    @Test
    void execute() throws CustomException {
        Environment environment = new Environment();
        CommandsParser commandsParser = new CommandsParser(environment);
        environment.init(new Size(10, 10), new Coords(3, 3));

        String[] args1 = new String[]{"teleport", "1"};
        String[] args2 = new String[]{"teleport", "100", "100"};
        String[] args3 = new String[]{"teleport", "-3", "5"};

        // Args 1
        assertEquals(
                commandsParser.readCommand(args1).code,
                GameStatusCode.ERROR
        );
        // Args 2
        assertEquals(
                commandsParser.readCommand(args2).code,
                GameStatusCode.SUCCESS
        );
        assertEquals(
                environment.robot.getCoords(),
                new Coords(0, 0)
        );
        // Args 3
        assertEquals(
                commandsParser.readCommand(args3).code,
                GameStatusCode.SUCCESS
        );
        assertEquals(
                environment.robot.getCoords(),
                new Coords(7, 5)
        );
    }
}