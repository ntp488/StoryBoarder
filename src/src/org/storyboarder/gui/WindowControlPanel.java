package org.storyboarder.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JPanel {
    public WindowControlPanel(Point point) {
        this.setLocation(point);
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}
