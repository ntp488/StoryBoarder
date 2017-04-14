package org.storyboarder.gui;

import org.storyboarder.gui.components.Comp_DarkButton;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class SidePanel extends JPanel{
    private JButton createCharacterButton, createPlaceButton, createObjectButton, createCategoryButton;
    private Dimension buttonDimension = new Dimension(150, 30),
            separatorDimension = new Dimension(100, 5);
    private BoxLayout layout;

    public SidePanel(){
        createCharacterButton = new Comp_DarkButton(buttonDimension);
        createPlaceButton = new Comp_DarkButton(buttonDimension);
        createObjectButton = new Comp_DarkButton(buttonDimension);
        createCategoryButton = new Comp_DarkButton(buttonDimension);

        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());

        this.add(new JToolBar.Separator(separatorDimension));

        createCharacterButton.setText("Create Character");
        createCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createCharacterButton);

        this.add(new JToolBar.Separator(separatorDimension));

        createPlaceButton.setText("Create Place");
        createPlaceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createPlaceButton);

        this.add(new JToolBar.Separator(separatorDimension));

        createObjectButton.setText("Create Object");
        createObjectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createObjectButton);

        this.add(Box.createVerticalGlue());

        createCategoryButton.setText("Create Category");
        createCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createCategoryButton);
    }
}
