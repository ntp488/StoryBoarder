package org.storyboarder.cardCreation;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by ntp48 on 4/14/2017.
 */
public class CardCreationWindow extends JFrame {
    private CardCreationControlPanel cardCreationControlPanel;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
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
            CardCreationControlPanel menuBar = (CardCreationControlPanel) e.getComponent();
            CardCreationWindow window = menuBar.getCardCreationWindow();
            window.setLocation(e.getXOnScreen() - offset.x, e.getYOnScreen() - offset.y);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    };

    public CardCreationWindow() {
        CreateWindowItems();

        this.setLayout(layout);
        this.setJMenuBar(cardCreationControlPanel);
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
        cardCreationControlPanel = new CardCreationControlPanel(this);
        cardCreationControlPanel.addMouseListener(dragListener);
        cardCreationControlPanel.addMouseMotionListener(dragListener);
    }
}
