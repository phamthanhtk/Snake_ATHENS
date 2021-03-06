package athensproject.model;

import athensproject.GameSettings;
import athensproject.controller.GameOver;
import athensproject.controller.Restart;

import java.util.Random;

public class Grid implements Restart{

    private static Grid instance = new Grid();

    private static Field fruitPosition;
    private static Apple apple;
    private static Snake snake;

    private Grid(){
        snake = new Snake();
        apple = Apple.CLASSIC;
        spawnFruit();
        GameOver.addRestartable(this);
    }

    public static Grid getInstance() {
        return instance;
    }

    public static Field getFruitPosition() {
        return fruitPosition;
    }

    public static Apple getApple(){
        return apple;
    }

    public static void reGenerateApple(){
      apple = apple.generateNewApple();
    }

    public static boolean isFruitEaten(){
        return snake.getHead().equals(fruitPosition);
    }

    public static void spawnFruit(){

        fruitPosition = new Field(new Random().nextInt(GameSettings.GRID_WIDTH_NUMBER_OF_FIELDS - 10),
                new Random().nextInt(GameSettings.GRID_HEIGHT_NUMBER_OF_FIELDS - 10));

        while ( Snake.getSnakeFields().contains(fruitPosition) ) {
            fruitPosition = new Field(new Random().nextInt(GameSettings.GRID_WIDTH_NUMBER_OF_FIELDS - 10),
                    new Random().nextInt(GameSettings.GRID_HEIGHT_NUMBER_OF_FIELDS - 10));
        }

        reGenerateApple();
    }

    public void restart() {
        spawnFruit();
    }

    public static Snake getSnake() {
        return snake;
    }


}
