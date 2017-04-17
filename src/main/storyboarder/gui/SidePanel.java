package storyboarder.gui;

import storyboarder.Deck;
import storyboarder.cardCreation.CardCreationWindow;
import storyboarder.categoryCreation.CategoryCreationWindow;
import storyboarder.gui.components.Comp_DarkButton;
import storyboarder.gui.components.CustomTreeCellRenderer;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Nathan on 1/23/2017.
 */
public class SidePanel extends JPanel{
    private JButton createCharacterButton, createCategoryButton;
    private JScrollPane scrollPane;
    private JTree hierarchy;
    private Dimension buttonDimension = new Dimension(150, 30),
        separatorDimension = new Dimension(100, 5);
    private BoxLayout layout;
    private JFrame creationWindow;
    private Deck deck;

    public SidePanel(){
        CreatePanelItems();

        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());

        this.add(new JToolBar.Separator(separatorDimension));
        this.add(createCharacterButton);
        this.add(new JToolBar.Separator(separatorDimension));
        this.add(createCategoryButton);
        this.add(new JToolBar.Separator(separatorDimension));
        this.add(scrollPane);

        this.add(Box.createVerticalGlue());
    }

    private void CreatePanelItems() {
        createCharacterButton = new Comp_DarkButton(buttonDimension);
        createCharacterButton.setText("Create Card");
        createCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creationWindow == null) {
                    creationWindow = new CardCreationWindow();
                } else {
                    creationWindow.dispose();
                    creationWindow = new CardCreationWindow();
                }
            }
        });

        createCategoryButton = new Comp_DarkButton(buttonDimension);
        createCategoryButton.setText("Create Category");
        createCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        createCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creationWindow == null) {
                    creationWindow = new CategoryCreationWindow();
                } else {
                    creationWindow.dispose();
                    creationWindow = new CategoryCreationWindow();
                }
            }
        });

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        CreateEmptyDeckHierarchy();

        scrollPane.getViewport().add(hierarchy);
    }

    private void CreateEmptyDeckHierarchy() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("The Java Series");
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        DefaultTreeCellRenderer customCellRenderer;

        hierarchy = new JTree(treeModel);
        hierarchy.setBackground(Color.LIGHT_GRAY);
        hierarchy.setEditable(false);
        hierarchy.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        hierarchy.setShowsRootHandles(true);
        customCellRenderer = new CustomTreeCellRenderer();
        //TODO: create Tree Icons
        //TODO: experiment with color-coding leaf nodes via category
        customCellRenderer.setClosedIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        customCellRenderer.setOpenIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        customCellRenderer.setLeafIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        hierarchy.setCellRenderer(customCellRenderer);

        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        rootNode.add(category);

        book = new DefaultMutableTreeNode("tutorial.htmlblue");
        category.add(book);

        book = new DefaultMutableTreeNode("tutorialcont.html");
        category.add(book);

        book = new DefaultMutableTreeNode("swingtutorial.html");
        category.add(book);

        category = new DefaultMutableTreeNode("Books for Java Implementers");
        rootNode.add(category);

        book = new DefaultMutableTreeNode("vm.html");
        category.add(book);

        book = new DefaultMutableTreeNode("jls.html");
        category.add(book);
    }
    //TODO: on loading new deck via the load function, pass deck to sidepanel
    public void LoadDeckHierarchy(Deck loadedDeck) {
        deck = loadedDeck;
    }

}
