package org.storyboarder.cardCreation;

import org.storyboarder.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ntp48 on 4/14/2017.
 */
public class CardCreationControlPanel extends JMenuBar{
    private JLabel logo;
    private JMenu exitButton, minimizeButton;
    private CardCreationWindow window;
    private BoxLayout layout;
    private Point previousWindowLocation = new Point(0, 0);
    private MouseListener windowFunctionsListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //TODO: Fix bug where window will maximize incorrectly when window is resized before clicking maximize the first time
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

    public CardCreationControlPanel(CardCreationWindow cardCreationWindow) {
        window = cardCreationWindow;

        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.X_AXIS);

        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(layout);

        this.add(logo);

        this.add(Box.createHorizontalGlue());

        this.add(minimizeButton);
        this.add(exitButton);
    }

    public CardCreationWindow getCardCreationWindow() {
        return window;
    }

    private void CreatePanelItems() {
        ImageIcon icon = new ImageIcon("images/StoryboarderLogo.png");
        Image newimg = icon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        logo = new JLabel(icon);

        //CREATING WINDOW FUNCTION BUTTONS -----------------------------------
        minimizeButton = new JMenu();
        SetMenuIcon(minimizeButton, "images/minimizebutton.png");
        DecorateMenu(minimizeButton);
        minimizeButton.addMouseListener(windowFunctionsListener);

        exitButton = new JMenu();
        SetMenuIcon(exitButton, "images/exitbutton.png");
        DecorateMenu(exitButton);
        exitButton.addMouseListener(windowFunctionsListener);
    }

    private void SetMenuIcon(JMenu menu, String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image newimg = icon.getImage().getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        menu.setIcon(icon);
    }

    private void DecorateMenu(JMenu menu) {
        menu.setForeground(Color.white);
        menu.setBackground(Color.DARK_GRAY);
    }
}
