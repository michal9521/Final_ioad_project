package Samolot;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopUpMenu extends JPopupMenu {
    JMenuItem anItem;
    public PopUpMenu(){
        anItem = new JMenuItem("Click Me!");
        add(anItem);
    }
}