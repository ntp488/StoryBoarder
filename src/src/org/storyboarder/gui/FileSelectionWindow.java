package org.storyboarder.gui;

import org.storyboarder.gui.components.SimpleMenuBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Nathan on 4/15/2017.
 */
public class FileSelectionWindow extends JFrame{
    private SimpleMenuBar simpleMenuBar;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JFileChooser fileChooser;
    private int returnVal;
    private ActionListener fileChooserListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser theFileChooser = (JFileChooser)e.getSource();
            String command = e.getActionCommand();
            if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                File selectedFile = theFileChooser.getSelectedFile();
                System.out.println("You chose the file " + selectedFile.getName());
                //TODO: Perform saving or loading
                //TODO: Create handling for when a file already exists with the chosen name when saving
                //TODO: Create handling for when no file exists with the chosen name when loading
            }  else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                dispose();
            }
        }
    };

    public FileSelectionWindow(String buttonText) {
        CreateWindowItems();
        this.setLayout(layout);
        this.setJMenuBar(simpleMenuBar);
        fileChooser.setApproveButtonText(buttonText);
        //TODO: Decide on a file extension to use and set the filter appropriately
        fileChooser.addActionListener(fileChooserListener);
        this.add(fileChooser);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        BorderFactory.createLineBorder(Color.black);
        this.setMinimumSize(new Dimension(500, 450));
        Point middleOfScreen = new Point(
                Toolkit.getDefaultToolkit().getScreenSize().width/2 - 250,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - 225
        );
        this.setLocation(middleOfScreen);

        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    private void CreateWindowItems() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        simpleMenuBar = new SimpleMenuBar(this);
        fileChooser = new JFileChooser();
    }

}
