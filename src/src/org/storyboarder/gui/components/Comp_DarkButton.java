package org.storyboarder.gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class Comp_DarkButton extends JButton {
    private ImageIcon icon, iconRollover, iconDown;
    private Image img, newimg, imgRollover, newimgRollover, imgDown, newImgDown;

    public Comp_DarkButton(Dimension dim) {
        icon = new ImageIcon(ClassLoader.getSystemResource("DarkButton.gif"));
        img = icon.getImage();
        newimg = img.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);

        iconRollover = new ImageIcon(ClassLoader.getSystemResource("DarkButtonRollover.gif"));
        imgRollover = iconRollover.getImage();
        newimgRollover = imgRollover.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        iconRollover = new ImageIcon(newimgRollover);

        iconDown = new ImageIcon(ClassLoader.getSystemResource("DarkButtonDownWhite.gif"));
        imgDown = iconDown.getImage();
        newImgDown = imgDown.getScaledInstance( dim.width, dim.height,  java.awt.Image.SCALE_SMOOTH ) ;
        iconDown = new ImageIcon(newImgDown);

        this.setIcon(icon);
        this.setRolloverIcon(iconRollover);
        this.setPressedIcon(iconDown);

        this.setPreferredSize(dim);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setForeground(Color.LIGHT_GRAY);
    }
}
