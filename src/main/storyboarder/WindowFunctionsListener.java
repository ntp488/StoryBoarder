package storyboarder;

import storyboarder.gui.FileSelectionWindow;
import storyboarder.gui.WindowControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static storyboarder.gui.MainWindow.window;

/**
 * Created by Nathan on 4/18/2017.
 */
public class WindowFunctionsListener implements MouseListener {
    private JMenu exitButton, maximizeButton, minimizeButton;
    private JMenuItem saveProjectButton, loadProjectButton;
    private JFrame fileSelectionWindow;
    private WindowControlPanel controlPanel;

    public WindowFunctionsListener(WindowControlPanel panel) {
        controlPanel = panel;
        exitButton = panel.exitButton;
        maximizeButton = panel.maximizeButton;
        minimizeButton = panel.minimizeButton;
        saveProjectButton = panel.saveProjectButton;
        loadProjectButton = panel.loadProjectButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(exitButton)) {
            System.exit(0);
        } else if (e.getComponent().equals(maximizeButton)) {
            if (window.getSize().height != window.maximizedWindowSize.height ||
                    window.getSize().width != window.maximizedWindowSize.width) {
                controlPanel.MaximizeWindow();
            } else {
                window.setSize(controlPanel.previousWindowSize);
                window.setLocation(controlPanel.previousWindowLocation);
            }
        } else if (e.getComponent().equals(minimizeButton)) {
            window.setState(Frame.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent().equals(loadProjectButton)) {
            System.out.println("Load Project");
            if (fileSelectionWindow != null) {
                fileSelectionWindow.dispose();
                fileSelectionWindow = new FileSelectionWindow("Load",
                        FileSelectionWindow.WindowType.Load, window.GetSidePanel());
            } else {
                fileSelectionWindow = new FileSelectionWindow("Load",
                        FileSelectionWindow.WindowType.Load, window.GetSidePanel());
            }
        } else if (e.getComponent().equals(saveProjectButton)) {
            System.out.println("Save Project");
            if (fileSelectionWindow != null) {
                fileSelectionWindow.dispose();
                fileSelectionWindow = new FileSelectionWindow("Save",
                        FileSelectionWindow.WindowType.Save, window.GetSidePanel());
            } else {
                fileSelectionWindow = new FileSelectionWindow("Save",
                        FileSelectionWindow.WindowType.Save, window.GetSidePanel());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object obj = e.getComponent();
        if (obj instanceof JMenu) {
            JMenu menu = (JMenu) e.getComponent();
            menu.setSelected(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object obj = e.getComponent();
        if (obj instanceof JMenu) {
            JMenu menu = (JMenu) e.getComponent();
            menu.setSelected(false);
        }
    }
}
