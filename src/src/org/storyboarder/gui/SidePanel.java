package org.storyboarder.gui;

import org.storyboarder.cardCreation.CardCreationWindow;
import org.storyboarder.gui.components.Comp_DarkButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nathan on 1/23/2017.
 */
public class SidePanel extends JPanel{
    private JButton createCharacterButton, createPlaceButton, createObjectButton, createCategoryButton;
    private Dimension buttonDimension = new Dimension(150, 30),
            separatorDimension = new Dimension(100, 5);
    private BoxLayout layout;
    private CardCreationWindow cardCreationWindow;

    public SidePanel(){
        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());

        this.add(new JToolBar.Separator(separatorDimension));
        this.add(createCharacterButton);
        this.add(new JToolBar.Separator(separatorDimension));
        this.add(createCategoryButton);
        //this.add(createPlaceButton);
        //this.add(new JToolBar.Separator(separatorDimension));
        //this.add(createObjectButton);

        this.add(Box.createVerticalGlue());

        //this.add(createCategoryButton);
    }

    private void CreatePanelItems() {
        createCharacterButton = new Comp_DarkButton(buttonDimension);
        createCharacterButton.setText("Create Card");
        createCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cardCreationWindow == null) {
                    cardCreationWindow = new CardCreationWindow();
                } else {
                    cardCreationWindow.dispose();
                    cardCreationWindow = new CardCreationWindow();
                }
            }
        });

        /*createPlaceButton = new Comp_DarkButton(buttonDimension);
        createPlaceButton.setText("Create Place");
        createPlaceButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createObjectButton = new Comp_DarkButton(buttonDimension);
        createObjectButton.setText("Create Object");
        createObjectButton.setAlignmentX(Component.CENTER_ALIGNMENT);*/

        createCategoryButton = new Comp_DarkButton(buttonDimension);
        createCategoryButton.setText("Create Category");
        createCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


}
