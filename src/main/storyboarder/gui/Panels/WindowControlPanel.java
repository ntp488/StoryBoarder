package storyboarder.gui.Panels;

import storyboarder.gui.Windows.MainWindow;
import storyboarder.gui.components.*;
import javax.swing.*;
import java.awt.*;

public class WindowControlPanel extends JMenuBar {
    public JMenu fileMenu, editMenu;
    public JMenuItem loadProjectButton, saveProjectButton;
    public MainWindow window;
    private BoxLayout layout;
    private WindowFunctionsListener windowFunctionsListener;
    private WindowDragAndResizeListener dragListener;

    public WindowControlPanel(MainWindow mainWindow) {
        window = mainWindow;

        createPanelItems();
        windowFunctionsListener = new WindowFunctionsListener(this);
        dragListener = new WindowDragAndResizeListener(this);
        addWindowFunctionListeners();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(Box.createHorizontalGlue());
    }

    public MainWindow getMainWindow() {
        return window;
    }

    private void createPanelItems() {
        //CREATING FILE MENU -------------------------------------------------------------------------------------------
        fileMenu = new JMenu("File");
        decorateMenu(fileMenu);

        loadProjectButton = new JMenuItem("Load");

        saveProjectButton = new JMenuItem("Save");

        fileMenu.add(loadProjectButton);
        fileMenu.add(saveProjectButton);

        //CREATING EDIT MENU -------------------------------------------------------------------------------------------
        editMenu = new JMenu("Edit");
        decorateMenu(editMenu);
    }

    private void addSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setMaximumSize(new Dimension(1, 50));
        separator.setMinimumSize(new Dimension(1, 50));
        separator.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.add(separator);
    }

    private void setMenuIcon(JMenu menu, String filename) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(filename));
        Image newimg = icon.getImage().getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        menu.setIcon(icon);
    }

    private void decorateMenu(JMenu menu) {
        menu.setForeground(Color.white);
        menu.setBackground(Color.DARK_GRAY);
    }

    private void addWindowFunctionListeners() {
        saveProjectButton.addMouseListener(windowFunctionsListener);
        loadProjectButton.addMouseListener(windowFunctionsListener);
    }

}
