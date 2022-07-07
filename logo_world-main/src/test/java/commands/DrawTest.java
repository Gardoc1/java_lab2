package commands;

import env.Environment;
import env.utils.GameStatusCode;
import org.junit.jupiter.api.Test;
import env.utils.Coords;
import env.utils.CustomException;
import env.utils.Size;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    void execute() throws CustomException {
        Environment environment = new Environment();
        CommandsParser commandsParser = new CommandsParser(environment);
        environment.init(new Size(10, 10), new Coords(1, 1));

        String[] args1 = new String[]{"draw", "1", "2"};
        String[] args2 = new String[]{"draw"};

        // Args 1
        assertEquals(
                commandsParser.readCommand(args1).code,
                GameStatusCode.ERROR
        );
        assertFalse(environment.robot.getMode());
        // Args 2
        assertEquals(
                commandsParser.readCommand(args2).code,
                GameStatusCode.SUCCESS
        );
        assertTrue(environment.robot.getMode());
    }
}