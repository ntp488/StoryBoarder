package storyboarder.gui.Panels;

import storyboarder.gui.Windows.MainWindow;
import storyboarder.gui.components.*;

import javax.swing.*;
import java.awt.*;

public class WindowControlPanel extends JMenuBar {
    private JLabel logo;
    public JMenu fileMenu, editMenu, exitButton, maximizeButton, minimizeButton;
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

        this.add(logo);
        this.add(new JToolBar.Separator(new Dimension(5, 5)));
        this.add(fileMenu);
        addSeparator();
        this.add(editMenu);
        addSeparator();
        this.add(Box.createHorizontalGlue());
        this.add(minimizeButton);
        this.add(maximizeButton);
        this.add(exitButton);
    }

    public MainWindow getMainWindow() {
        return window;
    }

    private void createPanelItems() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("StoryboarderLogo.png"));
        Image newimg = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        logo = new JLabel(icon);

        //CREATING FILE MENU -------------------------------------------------
        fileMenu = new JMenu("File");
        decorateMenu(fileMenu);

        loadProjectButton = new JMenuItem("Load");

        saveProjectButton = new JMenuItem("Save");

        fileMenu.add(loadProjectButton);
        fileMenu.add(saveProjectButton);

        //CREATING EDIT MENU -------------------------------------------------
        editMenu = new JMenu("Edit");
        decorateMenu(editMenu);

        //CREATING WINDOW FUNCTION BUTTONS -----------------------------------
        minimizeButton = new JMenu();
        setMenuIcon(minimizeButton, "minimizebutton.png");
        decorateMenu(minimizeButton);

        maximizeButton = new JMenu();
        setMenuIcon(maximizeButton, "maximizebutton.png");
        decorateMenu(maximizeButton);

        exitButton = new JMenu();
        setMenuIcon(exitButton, "exitbutton.png");
        decorateMenu(exitButton);
    }

    private void addSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setMaximumSize(new Dimension(10, 25));
        separator.setForeground(Color.LIGHT_GRAY);
        separator.setBackground(Color.DARK_GRAY);
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
        minimizeButton.addMouseListener(windowFunctionsListener);
        maximizeButton.addMouseListener(windowFunctionsListener);
        exitButton.addMouseListener(windowFunctionsListener);
    }

}
