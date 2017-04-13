package org.storyboarder.gui;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import org.storyboarder.gui.components.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class MainWindow extends JFrame {
    private GridLayout layout;
    private ComponentResizer compResizer;
    private SidePanel sidePanel;
    private WindowControlPanel controlPanel;

    private Point offset;
    private MouseInputListener dragListener = new MouseInputListener() {
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
    };

    public MainWindow() {
        layout = new GridLayout();
        compResizer = new ComponentResizer();
        sidePanel = new SidePanel();
        controlPanel = new WindowControlPanel(this);

        this.setLayout(layout);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        BorderFactory.createLineBorder(Color.black);
        compResizer.registerComponent(this);

        this.setMinimumSize(
                new Dimension(sidePanel.getWidth() + controlPanel.getWidth()
                        , sidePanel.getHeight() + controlPanel.getHeight()
                )
        );

        this.setPreferredSize(
                new Dimension(sidePanel.getWidth() + controlPanel.getWidth()
                        , sidePanel.getHeight() + controlPanel.getHeight()
                )
        );

        layout.setColumns(3);
        layout.addLayoutComponent("Sidepanel", sidePanel);
        this.add(sidePanel);

        controlPanel.addMouseListener(dragListener);
        controlPanel.addMouseMotionListener(dragListener);
        this.setJMenuBar(controlPanel);

        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args) {
    }
}
