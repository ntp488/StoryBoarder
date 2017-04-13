package org.storyboarder.gui.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Nathan on 4/13/2017.
 */
public class SaveAction extends AbstractAction {
    public SaveAction() {
        //perform any setup
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Save Pressed");
    }
}
