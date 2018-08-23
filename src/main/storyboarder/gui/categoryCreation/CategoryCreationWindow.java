package storyboarder.gui.categoryCreation;

import storyboarder.gui.components.SimpleMenuBar;

import javax.swing.*;
import java.awt.*;

public class CategoryCreationWindow extends JFrame {
    private SimpleMenuBar simpleMenuBar;
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public CategoryCreationWindow() {
        createWindowItems();

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

    private void createWindowItems() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        simpleMenuBar = new SimpleMenuBar(this, "Category Creator");
    }
}
