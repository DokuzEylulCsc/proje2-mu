package mu.Project.Views;

import mu.Project.Controllers.Controller;

import javax.swing.*;
import java.awt.*;

public abstract class Frame extends JFrame {
    Controller controller;

    public abstract void close();

    void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = graphicsEnvironment.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    void makeFullScreen() {
        Dimension windowSize = getSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();
        setSize(maximumWindowBounds.width, maximumWindowBounds.height);
        centerFrame();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
