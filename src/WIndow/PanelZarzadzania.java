package WIndow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import Model.ZarzadzanieSamolotami;

public class PanelZarzadzania extends JFrame  implements ActionListener {

	private ZarzadzanieSamolotami zarzadzanie;
	
	private JPanel mainPanel;
	private JTable table1;
	private JTable table2;
	private JButton enterPlaneButton;
	
    Object[][] data1 = {
    	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
    	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
    	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
    	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"}
    	};
    
    Object[][] data2 = {
    	    {"Boeing_737", "London"},
    	    {"Tupolew_240", "Moskwa"}};
    
    String[] columnNames1 = {"Plane Id",
    		"Model",
            "Ilosc Miejsc Biznes",
            "Ilosc Miejsc Eko",
            "Calk. masa bagazu",
            "Calk. masa podreczna", "Status", "Miejsce park."};
    
    String[] columnNames2 = {
    		"Model",
            "Sk¹d przylatuje"};
    
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public PanelZarzadzania(ZarzadzanieSamolotami zarzadzanie) {
		
		this.zarzadzanie = zarzadzanie;
		
		this.setSize(700,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		//setContentPane(mainPanel);
		//setContentPane(panelNowyBagaz);
		getContentPane().setLayout(null);
		String[][] pom = zarzadzanie.toTab();
	    table1 = new JTable(pom, columnNames1) {
	        @Override
	        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            Component component = super.prepareRenderer(renderer, row, column);
	            int rendererWidth = component.getPreferredSize().width;
	            TableColumn tableColumn = getColumnModel().getColumn(column);
	            tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
	            return component;
	         }
	    };
	    table1.setVisible(true);
//	    table1.setAutoResizeMode(HEIGHT);
//	    table1.setAutoResizeMode(WIDTH);
//	    table1.setMinimumSize(getMinimumSize());
	    table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table1.setBorder(BorderFactory.createLineBorder(Color.blue));	    
	    
	    table2 = new JTable(data2, columnNames2) {
	        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            Component component = super.prepareRenderer(renderer, row, column);
	            int rendererWidth = component.getPreferredSize().width;
	            TableColumn tableColumn = getColumnModel().getColumn(column);
	            tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
	            return component;
	        }
	    };
	    table2.setVisible(true);
	    table2.setBorder(BorderFactory.createLineBorder(Color.red));
	    table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    this.enterPlaneButton = new JButton("Accept Plane");
	    this.enterPlaneButton.setVisible(true);
	    this.enterPlaneButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
	    this.enterPlaneButton.addActionListener(this);
	    
	    JScrollPane scrollpane1 = new JScrollPane(table1);
	    JScrollPane scrollpane2 = new JScrollPane(table2);
	    
	    this.add(enterPlaneButton);
	    this.enterPlaneButton.setBounds(45, 205, 150, 40);
	    this.add(scrollpane1);
	    this.add(scrollpane2);
	    	    
	    this.add(table1);
//	    scrollpane1.getViewport().add(table1);
	    table1.setBounds(45, 250, 600, 200);
	    
	    this.add(table2);
//	    scrollpane2.getViewport().add(table2);
	    table2.setBounds(45, 0, 600, 200);

	}

}
