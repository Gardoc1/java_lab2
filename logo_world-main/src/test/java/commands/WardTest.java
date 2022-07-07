package commands;

import env.Environment;
import env.utils.GameStatusCode;
import org.junit.jupiter.api.Test;
import env.utils.Coords;
import env.utils.CustomException;
import env.utils.Size;

import static org.junit.jupiter.api.Assertions.*;

class WardTest {

    @Test
    void execute() throws CustomException {
        Environment environment = new Environment();
        CommandsParser commandsParser = new CommandsParser(environment);
        environment.init(new Size(10, 10), new Coords(1, 1));

        String[] args1 = new String[]{"ward", "1"};
        String[] args2 = new String[]{"ward"};

        // Args 1
        assertEquals(
                commandsParser.readCommand(args1).code,
                GameStatusCode.ERROR
        );
        assertFalse(environment.robot.getMode());
        // Args 2
        environment.robot.setMode(true);
        assertEquals(
                commandsParser.readCommand(args2).code,
                GameStatusCode.SUCCESS
        );
        assertFalse(environment.robot.getMode());

    }
}