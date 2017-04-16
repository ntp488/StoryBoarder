package org.storyboarder.gui;

import com.sun.xml.internal.ws.api.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Nathan on 1/24/2017.
 */
public class WindowControlPanel extends JMenuBar {
    private JLabel logo;
    private JMenu fileMenu, editMenu, exitButton, maximizeButton, minimizeButton;
    private JMenuItem loadProjectButton, saveProjectButton;
    private MainWindow window;
    private BoxLayout layout;
    private JFrame fileSelectionWindow;

    private Dimension previousWindowSize = new Dimension(900, 450),
            maximizedWindowSize;
    private Point previousWindowLocation = new Point(0, 0);
    private MouseListener windowFunctionsListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getComponent().equals(exitButton)) {
                System.exit(0);
            } else if (e.getComponent().equals(maximizeButton)) {
                if (window.getSize().height != maximizedWindowSize.height ||
                window.getSize().width != maximizedWindowSize.width) {
                    MaximizeWindow();
                } else {
                    window.setSize(previousWindowSize);
                    window.setLocation(previousWindowLocation);
                }
            } else if (e.getComponent().equals(minimizeButton)) {
                window.setState(Frame.ICONIFIED);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getComponent().equals(loadProjectButton)) {
                System.out.println("Load Project");
                if (fileSelectionWindow != null) {
                    fileSelectionWindow.dispose();
                    fileSelectionWindow = new FileSelectionWindow("Load");
                } else {
                    fileSelectionWindow = new FileSelectionWindow("Load");
                }
            } else if (e.getComponent().equals(saveProjectButton)) {
                System.out.println("Save Project");
                if (fileSelectionWindow != null) {
                    fileSelectionWindow.dispose();
                    fileSelectionWindow = new FileSelectionWindow("Save");
                } else {
                    fileSelectionWindow = new FileSelectionWindow("Save");
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Object obj = e.getComponent();
            if (obj instanceof JMenu) {
                JMenu menu = (JMenu) e.getComponent();
                menu.setSelected(true);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Object obj = e.getComponent();
            if (obj instanceof JMenu) {
                JMenu menu = (JMenu) e.getComponent();
                menu.setSelected(false);
            }
        }
    };

    public WindowControlPanel(MainWindow mainWindow) {
        window = mainWindow;
        maximizedWindowSize = window.GetMaximumWindowSize();

        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

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

    private void MaximizeWindow() {
        previousWindowSize = window.getSize();
        previousWindowLocation = window.getLocation();
        window.setSize(maximizedWindowSize);
        window.setLocation(new Point(0, 0));
    }

}
