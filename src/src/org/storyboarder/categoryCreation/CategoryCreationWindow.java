package org.storyboarder.categoryCreation;

import org.storyboarder.gui.components.SimpleMenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 4/15/2017.
 */
public class CategoryCreationWindow extends JFrame {
        private SimpleMenuBar simpleMenuBar;
        private GridBagLayout layout;
        private GridBagConstraints constraints;

        public CategoryCreationWindow() {
            CreateWindowItems();

            this.setLayout(layout);
            this.setJMenuBar(simpleMenuBar);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setUndecorated(true);
            BorderFactory.createLineBorder(Color.black);
            this.setMinimumSize(new Dimension(500, 450));

            Point middleOfScreen = new Point(
                    Toolkit.getDefaultToolkit().getScreenSize().width/2 - 250,
                    Toolkit.getDefaultToolkit().getScreenSize().height/2 - 225
            );
            this.setLocation(middleOfScreen);

            this.pack();
            this.setResizable(true);
            this.setVisible(true);
        }

        private void CreateWindowItems() {
            layout = new GridBagLayout();
            constraints = new GridBagConstraints();
            simpleMenuBar = new SimpleMenuBar(this, "Category Creator");
        }
}