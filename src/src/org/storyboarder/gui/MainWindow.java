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
    //ComponentResizer compResizer = new ComponentResizer();

    SidePanel sidePanel = new SidePanel();
    WindowControlPanel controlPanel = new WindowControlPanel();

    public MainWindow() {
        this.setLayout(layout);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //this.setUndecorated(false);
        BorderFactory.createLineBorder(Color.black);
        //compResizer.registerComponent(this);

        this.setMinimumSize(
                new Dimension(sidePanel.getWidth() + controlPanel.getWidth()
                    ,sidePanel.getHeight() + controlPanel.getHeight()
                )
        );

        this.setPreferredSize(
                new Dimension(sidePanel.getWidth() + controlPanel.getWidth()
                        ,sidePanel.getHeight() + controlPanel.getHeight()
                )
        );

        constraints.anchor = GridBagConstraints.WEST;
        //constraints.fill = GridBagConstraints.NONE;
        layout.setConstraints(sidePanel, constraints);
        this.add(sidePanel);

        constraints.anchor = GridBagConstraints.NORTHEAST;
        //constraints.fill = GridBagConstraints.NONE;
        layout.setConstraints(controlPanel, constraints);
        this.add(controlPanel);
        
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
