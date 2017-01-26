package org.storyboarder.gui;

import org.storyboarder.gui.components.Comp_DarkButton;
import org.storyboarder.gui.components.ComponentResizer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class MainWindow extends JFrame {
    Dimension dim = new Dimension(500, 500);
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    ComponentResizer compResizer = new ComponentResizer();

    SidePanel sidePanel = new SidePanel();
    WindowControlPanel controlPanel = new WindowControlPanel(new Point(dim.width, dim.height));

    public MainWindow() {
        this.setPreferredSize(dim);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        BorderFactory.createLineBorder(Color.black);
        compResizer.registerComponent(this);

        //layout.addLayoutComponent(sidePanel, constraints.NORTHEAST);
        constraints.anchor =
        this.add(sidePanel);

        //layout.addLayoutComponent(controlPanel, constraints.WEST);
        this.add(controlPanel);

        this.setLayout(layout);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
