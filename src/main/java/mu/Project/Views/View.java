package mu.Project.Views;

import mu.Project.Controllers.Controller;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JFrame {
    private final Controller controller;

    public View(String title, Controller controller) {
        super(title);
        this.controller = controller;
    }

    Controller getController() {
        return controller;
    }

    public abstract void close();

    void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = graphicsEnvironment.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
