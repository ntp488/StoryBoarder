package org.storyboarder.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JMenuBar {
    private JMenu fileMenu, exitButton, maximizeButton, minimizeButton;
    private MainWindow window;
    private BoxLayout layout;
    private Dimension previousWindowSize = new Dimension(500, 500),
            maximizedWindowSize;
    private Point previousWindowLocation = new Point(0, 0);
    private MouseListener windowFunctionsListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getComponent().equals(exitButton)) {
                System.exit(0);
            } else if (e.getComponent().equals(maximizeButton)) {
                if (maximizedWindowSize == null) {
                    maximizedWindowSize = window.getSize();
                    System.out.println("Was null");
                    System.out.println(window.getSize() + "Check 1");
                    System.out.println(maximizedWindowSize + "Check 1");
                }

                if (window.getSize().height != maximizedWindowSize.height ||
                        window.getSize().width != maximizedWindowSize.width) {
                    previousWindowSize = window.getSize();
                    System.out.println(window.getSize() + "Check 2");
                    System.out.println(maximizedWindowSize + "Check 2");
                    previousWindowLocation = window.getLocation();

                    window.setSize(maximizedWindowSize);
                    window.setLocation(new Point(0, 0));
                } else {
                    System.out.println(window.getSize() + "Check 3");// should be the same
                    System.out.println(maximizedWindowSize + "Check 3");
                    window.setSize(previousWindowSize);
                    window.setLocation(previousWindowLocation);
                    System.out.println(window.getSize() + "Check 4");// should be different
                    System.out.println(maximizedWindowSize + "Check 4");
                }
                System.out.println(window.getSize() + "Result");
                System.out.println(maximizedWindowSize + "Result");
            } else if (e.getComponent().equals(minimizeButton)) {
                window.setState(Frame.ICONIFIED);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

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
    };

    public WindowControlPanel(MainWindow mainWindow) {
        fileMenu = new JMenu("File");
        window = mainWindow;

        //TODO: replace minimize button image
        minimizeButton = new JMenu();
        ImageIcon icon = new ImageIcon("images/exitbutton.png");
        Image newimg = icon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        minimizeButton.setIcon(icon);

        //TODO: replace maximize button image
        maximizeButton = new JMenu();
        icon = new ImageIcon("images/exitbutton.png");
        newimg = icon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        maximizeButton.setIcon(icon);

        exitButton = new JMenu();
        icon = new ImageIcon("images/exitbutton.png");
        newimg = icon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        exitButton.setIcon(icon);

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        fileMenu.setForeground(Color.white);
        this.add(fileMenu);

        this.add(Box.createHorizontalGlue());

        minimizeButton.setForeground(Color.white);
        minimizeButton.setBackground(Color.DARK_GRAY);
        minimizeButton.addMouseListener(windowFunctionsListener);
        this.add(minimizeButton);

        maximizeButton.setForeground(Color.white);
        maximizeButton.setBackground(Color.DARK_GRAY);
        maximizeButton.addMouseListener(windowFunctionsListener);
        this.add(maximizeButton);

        exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.addMouseListener(windowFunctionsListener);
        this.add(exitButton);
    }

    public MainWindow getMainWindow() {
        return window;
    }
}
