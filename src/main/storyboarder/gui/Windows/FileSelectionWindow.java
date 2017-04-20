package storyboarder.gui.Windows;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import storyboarder.Deck;
import storyboarder.gui.Panels.SidePanel;
import storyboarder.gui.components.SimpleMenuBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
    private SidePanel sidePanel;

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
                }
            }  else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                dispose();
            }
        }
    };

    public FileSelectionWindow(String buttonText, WindowType windowType, SidePanel currentSidePanel) {
        sidePanel = currentSidePanel;
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
        if (file.exists()) {
            ReadFile(file);
        } else {
            System.out.println("You chose a file that doesn't exist.");
            JOptionPane optionPane = new JOptionPane();
            optionPane.showConfirmDialog(this,
        "You have chosen a file that doesn't exist.", "Failed to Load",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        this.dispose();
    }

    private void ReadFile(File file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            Deck loadedDeck = mapper.readValue(file, Deck.class);
            System.out.println(loadedDeck.toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error Loading",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SaveDeck(File file) {
        if (file.getAbsolutePath().endsWith(".json")) {
        } else {
            File tempFile = file;
            file = new File(tempFile.getAbsolutePath() + ".json");
        }
        if (file.exists()) {
            JOptionPane optionPane = new JOptionPane();
            int option = optionPane.showConfirmDialog(this,
        "You have chosen a file that already exists. Continuing will overwrite the previous file. " +
                "Do you want to continue?", "Overwrite Save", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            switch (option) {
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.YES_OPTION:
                    WriteFile(file);
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
            }
        } else {
            WriteFile(file);
        }
        this.dispose();
    }

    private void WriteFile(File file) {
        try {
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(file, sidePanel.GetCurrentDeck());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error Saving",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
