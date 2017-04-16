package org.storyboarder.gui;

import org.storyboarder.cardCreation.CardCreationWindow;
import org.storyboarder.categoryCreation.CategoryCreationWindow;
import org.storyboarder.gui.components.Comp_DarkButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nathan on 1/23/2017.
 */
public class SidePanel extends JPanel{
    private JButton createCharacterButton, createCategoryButton;
    private Dimension buttonDimension = new Dimension(150, 30),
            separatorDimension = new Dimension(100, 5);
    private BoxLayout layout;
    private JFrame creationWindow;

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

        this.add(Box.createVerticalGlue());
    }

    private void CreatePanelItems() {
        createCharacterButton = new Comp_DarkButton(buttonDimension);
        createCharacterButton.setText("Create Card");
        createCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creationWindow == null) {
                    creationWindow = new CardCreationWindow();
                } else {
                    creationWindow.dispose();
                    creationWindow = new CardCreationWindow();
                }
            }
        });

        createCategoryButton = new Comp_DarkButton(buttonDimension);
        createCategoryButton.setText("Create Category");
        createCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creationWindow == null) {
                    creationWindow = new CategoryCreationWindow();
                } else {
                    creationWindow.dispose();
                    creationWindow = new CategoryCreationWindow();
                }
            }
        });
    }


}
