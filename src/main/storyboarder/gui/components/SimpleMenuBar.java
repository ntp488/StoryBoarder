package storyboarder.gui.components;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ntp48 on 4/14/2017.
 */
public class SimpleMenuBar extends JMenuBar{
    private JLabel logo, name;
    private JMenu exitButton, minimizeButton;
    private JFrame window;
    private BoxLayout layout;
    private Point previousWindowLocation = new Point(0, 0), offset;

    private MouseListener windowFunctionsListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getComponent().equals(exitButton)) {
                window.dispose();
            } else if (e.getComponent().equals(minimizeButton)) {
                window.setState(Frame.ICONIFIED);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getComponent().equals(minimizeButton)) {
                window.setState(Frame.ICONIFIED);
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
            SimpleMenuBar menuBar = (SimpleMenuBar) e.getComponent();
            JFrame window = menuBar.getParentWindow();
            window.setLocation(e.getXOnScreen() - offset.x, e.getYOnScreen() - offset.y);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    };

    public SimpleMenuBar(JFrame parentWindow) {
        window = parentWindow;
        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        this.add(logo);
        this.add(Box.createHorizontalGlue());
        this.add(minimizeButton);
        this.add(exitButton);

        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);
    }

    public SimpleMenuBar(JFrame parentWindow, String windowName) {
        window = parentWindow;
        name = new JLabel(windowName);
        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        this.add(logo);
        this.add(new JToolBar.Separator(new Dimension(5, 5)));
        name.setForeground(Color.WHITE);
        this.add(name);
        this.add(Box.createHorizontalGlue());
        this.add(minimizeButton);
        this.add(exitButton);

        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);
    }

    public JFrame getParentWindow() {
        return window;
    }

    private void CreatePanelItems() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("StoryboarderLogo.png"));
        Image newimg = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        logo = new JLabel(icon);

        //CREATING WINDOW FUNCTION BUTTONS -----------------------------------
        minimizeButton = new JMenu();
        SetMenuIcon(minimizeButton, "minimizebutton.png");
        DecorateMenu(minimizeButton);
        minimizeButton.addMouseListener(windowFunctionsListener);

        exitButton = new JMenu();
        SetMenuIcon(exitButton, "exitbutton.png");
        DecorateMenu(exitButton);
        exitButton.addMouseListener(windowFunctionsListener);
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
}
