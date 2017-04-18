package storyboarder.gui.components;

import storyboarder.gui.Panels.WindowControlPanel;
import storyboarder.gui.Windows.MainWindow;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Nathan on 4/18/2017.
 */
public class WindowDragAndResizeListener implements MouseInputListener{
    private Point offset;
    public WindowDragAndResizeListener(WindowControlPanel panel) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        offset = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        WindowControlPanel menuBar = (WindowControlPanel) e.getComponent();
        MainWindow window = menuBar.getMainWindow();
        window.setLocation(e.getXOnScreen() - offset.x, e.getYOnScreen() - offset.y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
