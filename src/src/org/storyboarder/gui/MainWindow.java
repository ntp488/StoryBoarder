package org.storyboarder.gui;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.storyboarder.gui.components.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class MainWindow extends JFrame {
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private ComponentResizer compResizer;
    private SidePanel sidePanel;
    private MainPanel mainPanel;
    private WindowControlPanel controlPanel;

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

    public MainWindow() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        compResizer = new ComponentResizer();
        sidePanel = new SidePanel();
        mainPanel = new MainPanel();
        controlPanel = new WindowControlPanel(this);

        this.setLayout(layout);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        BorderFactory.createLineBorder(Color.black);
        compResizer.registerComponent(this);
        this.setMinimumSize(new Dimension(900, 450));

        this.setPreferredSize(
                new Dimension(sidePanel.getWidth() + controlPanel.getWidth()
                        , sidePanel.getHeight() + controlPanel.getHeight()
                )
        );

        constraints.weightx = .05;
        constraints.weighty = 1;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(sidePanel, constraints);
        layout.addLayoutComponent("Sidepanel", sidePanel);
        this.add(sidePanel);

        constraints.weightx = 1.0;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.WEST;
        layout.setConstraints(mainPanel, constraints);
        layout.addLayoutComponent("Mainpanel", mainPanel);
        this.add(mainPanel);

        controlPanel.addMouseListener(dragListener);
        controlPanel.addMouseMotionListener(dragListener);
        this.setJMenuBar(controlPanel);

        ArrayList<Image> imageIcons = new ArrayList<>();
        ImageIcon icon = new ImageIcon("images/StoryboarderLogo.png");
        imageIcons.add(icon.getImage());
        imageIcons.add(icon.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
        this.setIconImages(imageIcons);

        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
