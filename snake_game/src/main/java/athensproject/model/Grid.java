package athensproject.model;

import athensproject.GameSettings;

import java.util.Random;

public class Grid {

    private static Grid instance = new Grid();

    private static Field fruitPosition;
    private static Snake snake;

    private Grid(){
        snake = new Snake();
        spawnFruit();
    }

    public static Grid getInstance() {
        return instance;
    }

    public static Field getFruitPosition() {
        return fruitPosition;
    }

    public static boolean isFruitEaten(){
        return snake.getHead().equals(fruitPosition);
    }

    public static void spawnFruit(){
        fruitPosition = new Field(new Random().nextInt(GameSettings.GRID_WIDTH_NUMBER_OF_FIELDS -10),
                new Random().nextInt(GameSettings.GRID_HEIGHT_NUMBER_OF_FIELDS -10));
    }

    public static Snake getSnake() {
        return snake;
    }


}
