package storyboarder.gui.Panels;

import storyboarder.gui.Windows.MainWindow;
import storyboarder.gui.components.WindowFunctionsListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JMenuBar {
    private JLabel logo;
    public JMenu fileMenu, editMenu, exitButton, maximizeButton, minimizeButton;
    public JMenuItem loadProjectButton, saveProjectButton;
    private MainWindow window;
    private BoxLayout layout;
    public Dimension previousWindowSize = new Dimension(900, 450),
            maximizedWindowSize;
    public Point previousWindowLocation = new Point(0, 0);
    private WindowFunctionsListener windowFunctionsListener = new WindowFunctionsListener(this);
    private Point offset;
    private MouseInputListener dragListener = new MouseInputListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            offset = new Point(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            WindowControlPanel menuBar = (WindowControlPanel) e.getComponent();
            MainWindow window = menuBar.getMainWindow();
            window.setLocation(e.getXOnScreen() - offset.x, e.getYOnScreen() - offset.y);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    };

    public WindowControlPanel(MainWindow mainWindow) {
        window = mainWindow;
        maximizedWindowSize = window.GetMaximumWindowSize();
        CreatePanelItems();
        windowFunctionsListener = new WindowFunctionsListener(this);
        AddWindowFunctionListeners();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        this.add(logo);
        this.add(new JToolBar.Separator(new Dimension(5, 5)));
        this.add(fileMenu);
        AddSeparator();
        this.add(editMenu);
        AddSeparator();
        this.add(Box.createHorizontalGlue());
        this.add(minimizeButton);
        this.add(maximizeButton);
        this.add(exitButton);
    }

    public MainWindow getMainWindow() {
        return window;
    }

    private void CreatePanelItems() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("StoryboarderLogo.png"));
        Image newimg = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        logo = new JLabel(icon);

        //CREATING FILE MENU -------------------------------------------------
        fileMenu = new JMenu("File");
        DecorateMenu(fileMenu);

        loadProjectButton = new JMenuItem("Load");
        loadProjectButton.addMouseListener(windowFunctionsListener);

        saveProjectButton = new JMenuItem("Save");
        saveProjectButton.addMouseListener(windowFunctionsListener);

        fileMenu.add(loadProjectButton);
        fileMenu.add(saveProjectButton);

        //CREATING EDIT MENU -------------------------------------------------
        editMenu = new JMenu("Edit");
        DecorateMenu(editMenu);
        //CREATING WINDOW FUNCTION BUTTONS -----------------------------------
        minimizeButton = new JMenu();
        SetMenuIcon(minimizeButton, "minimizebutton.png");
        DecorateMenu(minimizeButton);
        minimizeButton.addMouseListener(windowFunctionsListener);

        maximizeButton = new JMenu();
        SetMenuIcon(maximizeButton, "maximizebutton.png");
        DecorateMenu(maximizeButton);
        maximizeButton.addMouseListener(windowFunctionsListener);

        exitButton = new JMenu();
        SetMenuIcon(exitButton, "exitbutton.png");
        DecorateMenu(exitButton);
        exitButton.addMouseListener(windowFunctionsListener);
    }

    private void AddSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setMaximumSize(new Dimension(10, 25));
        separator.setForeground(Color.LIGHT_GRAY);
        separator.setBackground(Color.DARK_GRAY);
        this.add(separator);
    }

    private void SetMenuIcon(JMenu menu, String filename) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(filename));
        Image newimg = icon.getImage().getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        menu.setIcon(icon);
    }

    private void DecorateMenu(JMenu menu) {
        menu.setForeground(Color.white);
        menu.setBackground(Color.DARK_GRAY);
    }

    public void MaximizeWindow() {
        previousWindowSize = window.getSize();
        previousWindowLocation = window.getLocation();
        window.setSize(maximizedWindowSize);
        window.setLocation(new Point(0, 0));
    }

    private void AddWindowFunctionListeners() {
        saveProjectButton.addMouseListener(windowFunctionsListener);
        loadProjectButton.addMouseListener(windowFunctionsListener);
        minimizeButton.addMouseListener(windowFunctionsListener);
        maximizeButton.addMouseListener(windowFunctionsListener);
        exitButton.addMouseListener(windowFunctionsListener);
    }

}
