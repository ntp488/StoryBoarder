package org.storyboarder.gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class Comp_DarkButton extends JButton {
    public Comp_DarkButton(Dimension dim) {
        ImageIcon icon = new ImageIcon("images/DarkButton.gif");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);

        ImageIcon iconRollover = new ImageIcon("images/DarkButtonRollover.gif");
        Image imgRollover = iconRollover.getImage();
        Image newimgRollover = imgRollover.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        iconRollover = new ImageIcon(newimgRollover);

        ImageIcon iconDown = new ImageIcon("images/DarkButtonDownWhite.gif");
        Image imgDown = iconDown.getImage();
        Image newimgDown = imgDown.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        iconDown = new ImageIcon(newimgDown);

        this.setIcon(icon);
        this.setRolloverIcon(iconRollover);
        this.setPressedIcon(iconDown);

        this.setPreferredSize(dim);
        //this.setMinimumSize(dim);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setForeground(Color.LIGHT_GRAY);
    }
}
