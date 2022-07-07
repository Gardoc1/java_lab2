package commands;

import env.Environment;
import env.utils.GameStatus;
import env.utils.GameStatusCode;

public class Exit extends Command {
    public Exit(Environment environment) {
        super(environment);
    }
    @Override
    public GameStatus execute() {
        LOGGER.debug("Exiting...");
        return new GameStatus(GameStatusCode.EXIT, "Bye Bye!");
    }
}
