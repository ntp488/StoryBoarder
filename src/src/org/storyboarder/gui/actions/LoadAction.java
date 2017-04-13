package org.storyboarder.gui.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Nathan on 4/13/2017.
 */
public class LoadAction extends AbstractAction{
    public LoadAction() {
        //perform any setup
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Load Pressed");
    }
}
