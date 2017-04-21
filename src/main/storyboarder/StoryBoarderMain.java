package storyboarder;

import storyboarder.gui.Windows.MainWindow;
import javax.swing.*;

public class StoryBoarderMain {
    public static void main(String[] Args) {
        MainWindow mainWindow = new MainWindow();
        if (mainWindow.getSidePanel().checkForDeckChange()) {
            mainWindow.getSidePanel().reloadDeckHierarchy();
        }
    }
}
