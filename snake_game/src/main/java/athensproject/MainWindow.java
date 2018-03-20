package athensproject;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static int WINDOW_WIDTH;
    public static int WINDOW_HEIGHT;

    public MainWindow(int x, int y) {
        WINDOW_WIDTH = x;
        WINDOW_HEIGHT = y;
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(x, y));
        this.putWindowOnCentralPosition();
    }


    private void putWindowOnCentralPosition() {
        final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int left = (screenWidth - WINDOW_WIDTH) / 2;
        int top = (screenHeight - WINDOW_HEIGHT) / 2;
        setLocation(left, top);
    }
}
