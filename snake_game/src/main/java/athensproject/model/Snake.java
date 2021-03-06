package athensproject.model;

import athensproject.GameSettings;
import athensproject.controller.GameOver;
import athensproject.controller.Restart;

import java.util.ArrayList;
import java.util.List;


public class Snake implements Restart{

    private static SnakeState state;
    private static List<Field> body = new ArrayList<Field>();
    private static Field lastRemovedField;

    public Snake() {
        state = new SnakeGoingDown(this);
        lastRemovedField = new Field(10, 9);

        body.add(new Field(10, 10));
        body.add(new Field(10,11));
        GameOver.addRestartable(this);
    }

    /**
     * Return snake's head.
     * @return Snake's head.
     */
    public static Field getHead() {
        return body.get(0);
    }

    /**
     * Check whether snake is bitting it's own body or the wall.
     * @return Whether the snake is dead.
     */
    public static boolean isDead() {
        // Get coordinates of snake's head
        Field head = getHead();
        int headX = head.getX();
        int headY = head.getY();

        return body.lastIndexOf(head) != 0 // Check for snake bitting itself
                || headX < 0 || headX > GameSettings.GRID_WIDTH_NUMBER_OF_FIELDS // Check for snake bitting the wall
                || headY < 0 || headY > GameSettings.GRID_HEIGHT_NUMBER_OF_FIELDS;
    }

    public void restart() {
        body = new ArrayList<Field>();
        lastRemovedField = new Field(10, 9);
        body.add(new Field(10, 10));
        body.add(new Field(10,11));

    }

    public static List<Field> getSnakeFields() {
        return body;
    }

    public static SnakeState getCurrentState() {
        return state;
    }

    public static Field getLastRemovedField() {
        return lastRemovedField;
    }

    public static void setLastRemovedField(Field lastRemovedField) {
        Snake.lastRemovedField = lastRemovedField;
    }

    public static void setCurrentState(SnakeState state) {
        Snake.state = state;
    }
}
