package org.storyboarder.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JMenuBar {
    private JMenu fileMenu = new JMenu("File");
    private MainWindow window;

    public WindowControlPanel(MainWindow mainWindow) {
        window = mainWindow;
        this.setPreferredSize(new Dimension(100, 35));
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.add(fileMenu);
    }

    public MainWindow getMainWindow() {
        return window;
    }
}
