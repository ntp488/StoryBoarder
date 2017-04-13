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
    JButton button = new Comp_DarkButton(new Dimension(150, 30));

    public SidePanel(){
        this.setPreferredSize(new Dimension(200, 500));
        //this.setMinimumSize(new Dimension(200, 500));
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());

        button.setText("Bloop");
        this.add(button);
    }
}
