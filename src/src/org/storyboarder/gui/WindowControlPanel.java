package org.storyboarder.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JMenuBar {
    private JMenu fileMenu, exitButton;
    private MainWindow window;
    private BoxLayout layout;

    public WindowControlPanel(MainWindow mainWindow) {
        fileMenu = new JMenu("File");
        exitButton = new JMenu();
        ImageIcon icon = new ImageIcon("images/exitbutton.png");
        Image newimg = icon.getImage().getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);
        exitButton.setIcon(icon);
        window = mainWindow;
        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        fileMenu.setForeground(Color.white);
        this.add(fileMenu);

        this.add(Box.createHorizontalGlue());

        exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.DARK_GRAY);
        this.add(exitButton);
    }

    public MainWindow getMainWindow() {
        return window;
    }
}
