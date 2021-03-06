package env;

import env.utils.Coords;
import env.utils.CustomException;
import env.utils.Size;

public class Robot {

    private Coords coords;
    private boolean drawingMode;
    private final Size fieldSize;

    public Robot(Coords coords, Size fieldSize) {
        this.coords = coords;
        this.drawingMode = false;
        this.fieldSize = fieldSize;
    }
    public void setCoords(Coords coords) throws CustomException {
        coords.validate(fieldSize);
        this.coords = coords;
    }
    public void setMode(boolean drawingMode) {
        this.drawingMode = drawingMode;
    }
    public Coords getCoords() {
        return coords;
    }
    public boolean getMode() {
        return drawingMode;
    }
}
