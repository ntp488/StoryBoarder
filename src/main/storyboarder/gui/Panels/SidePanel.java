package storyboarder.gui.Panels;

import storyboarder.Card;
import storyboarder.Category;
import storyboarder.Deck;
import storyboarder.cardCreation.CardCreationWindow;
import storyboarder.categoryCreation.CategoryCreationWindow;
import storyboarder.gui.components.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

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
        deck = new Deck();
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
        createCharacterButton = new SimpleDarkButton(buttonDimension);
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

        createCategoryButton = new SimpleDarkButton(buttonDimension);
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

        InitializeDeckHierarchy();
    }

    private void InitializeDeckHierarchy() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(deck.GetName());
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        DefaultTreeCellRenderer customCellRenderer = new CustomTreeCellRenderer();

        hierarchy = new JTree(treeModel);
        hierarchy.setBackground(Color.LIGHT_GRAY);
        hierarchy.setEditable(false);
        hierarchy.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        hierarchy.setShowsRootHandles(true);
        //TODO: create Tree Icons
        //TODO: experiment with color-coding leaf nodes via category
        customCellRenderer.setClosedIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        customCellRenderer.setOpenIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        customCellRenderer.setLeafIcon(new ImageIcon(ClassLoader.getSystemResource("maximizebutton.png")));
        hierarchy.setCellRenderer(customCellRenderer);

        DefaultMutableTreeNode categoryNode = null;
        DefaultMutableTreeNode cardNode = null;

        for (Category category : deck.GetCategories()) {
            categoryNode = new DefaultMutableTreeNode(category.GetName());
            rootNode.add(categoryNode);
            for (Card card : category.GetCards()) {
                cardNode = new DefaultMutableTreeNode(card.GetName());
                categoryNode.add(cardNode);
            }
        }

        scrollPane.getViewport().add(hierarchy);
    }

    public void LoadDeckHierarchy(Deck loadedDeck) {
        deck = loadedDeck;
        InitializeDeckHierarchy();
    }

    public Deck GetCurrentDeck() {
        return deck;
    }
}
