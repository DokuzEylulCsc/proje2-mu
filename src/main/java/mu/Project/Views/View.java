package mu.Project.Views;

import mu.Project.Controllers.Controller;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JFrame {
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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
