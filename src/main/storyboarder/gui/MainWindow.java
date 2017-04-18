package storyboarder.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import storyboarder.Deck;
import storyboarder.gui.components.ComponentResizer;

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
    private int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height
        - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    private Dimension maximizedWindowSize
        = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
        Toolkit.getDefaultToolkit().getScreenSize().height - taskbarheight);
    public static MainWindow window;

    public MainWindow() {
        window = this;
        InitializeWindowItems();

        this.setLayout(layout);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        BorderFactory.createLineBorder(Color.black);
        compResizer.registerComponent(this);
        this.setMinimumSize(new Dimension(900, 450));
        this.setSize(maximizedWindowSize);
        this.setPreferredSize(maximizedWindowSize);

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

        this.setJMenuBar(controlPanel);

        this.setIconImages(GenerateWindowIcons());

        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args) {

    }

    public Dimension GetMaximumWindowSize() {
        return maximizedWindowSize;
    }

    private ArrayList<Image> GenerateWindowIcons() {
        ArrayList<Image> imageIcons = new ArrayList<>();
        ImageIcon icon = new ImageIcon("images/StoryboarderLogo.png");
        imageIcons.add(icon.getImage());
        imageIcons.add(icon.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH));
        imageIcons.add(icon.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
        return imageIcons;
    }

    private void InitializeWindowItems() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        compResizer = new ComponentResizer();
        sidePanel = new SidePanel();
        mainPanel = new MainPanel();
        controlPanel = new WindowControlPanel(this);
    }

    public SidePanel GetSidePanel() {
        return sidePanel;
    }
}
