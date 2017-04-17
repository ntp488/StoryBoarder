package storyboarder.gui;

import storyboarder.gui.components.SimpleMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nathan on 4/15/2017.
 */
public class FileSelectionWindow extends JFrame{
    private SimpleMenuBar simpleMenuBar;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JFileChooser fileChooser;
    public enum WindowType{
        Save, Load
    }
    private WindowType type;

    private ActionListener fileChooserListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser theFileChooser = (JFileChooser)e.getSource();
            String command = e.getActionCommand();
            if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                File selectedFile = theFileChooser.getSelectedFile();
                System.out.println("You chose the file " + selectedFile.getName());
                switch (type) {
                    case Save:
                        SaveDeck(selectedFile);
                        break;
                    case Load:
                        LoadDeck(selectedFile);
                        break;
                    default:
                        //TODO: throw new custom exception
                        System.out.println("No set type for file selection window");
                        break;
                }
            }  else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                dispose();
            }
        }
    };

    public FileSelectionWindow(String buttonText, WindowType windowType) {
        CreateWindowItems();
        type = windowType;
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

    private void LoadDeck(File file){
        if (file.exists() && file.isDirectory()) {
            System.out.println("I should perform loading here.");
        } else {
            //TODO: Create handling for when no file exists with the chosen name
            System.out.println("You chose a file that doesn't exist.");
        }
    }

    private void SaveDeck(File file) {
        if (file.exists()) {
            //TODO: Create handling for when a file already exists with the chosen name
            System.out.println("You chose a file that already exists.");
        } else {
            System.out.println("I should perform saving here if the chosen filename formatted correctly.");
            if (file.getAbsolutePath().endsWith(".json")) {
                System.out.println(file.getAbsolutePath() + " was formatted correctly");
            } else {
                File tempFile = file;
                System.out.println(file.getAbsolutePath() + " was not formatted correctly");
                file = new File(tempFile.getAbsolutePath() + ".json");
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(file.getAbsolutePath());
        }
        this.dispose();
    }

}
