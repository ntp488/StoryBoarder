package org.storyboarder.gui.components;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * Created by ntp48 on 4/16/2017.
 */
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Color getBackgroundNonSelectionColor() {
        return null;
    }

    @Override
    public Color getBackgroundSelectionColor() {
        return Color.WHITE;
    }

    @Override
    public Color getBackground() {
        return null;
    }

    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value, final boolean sel,
    final boolean expanded, final boolean leaf, final int row, final boolean hasFocus) {
        Component ret = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = ((DefaultMutableTreeNode) (value));
        String nodeText = node.getUserObject().toString();

        if (leaf && nodeText.endsWith("blue")) {
            setForeground(new Color(13, 57, 115));
        }

        this.setText(value.toString());
        return ret;
    }

}