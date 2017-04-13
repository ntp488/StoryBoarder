package org.storyboarder.gui;

import org.storyboarder.gui.components.Comp_DarkButton;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class SidePanel extends JPanel{
    /*
     /==========================================\
    /                   Buttons                  \
    \                                            /
     \==========================================/
    */
    private JButton button = new Comp_DarkButton(new Dimension(150, 30));

    public SidePanel(){
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());

        button.setText("Bloop");
        this.add(button);
    }
}
