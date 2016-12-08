package WIndow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.ZarzadzanieSamolotami;

public class NoweOkno extends JFrame implements ActionListener{
	
	public NoweOkno(ZarzadzanieSamolotami zarzadzanie){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		Object[][] data1 = {
				{"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
				{"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
				{"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
				{"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"}
		};

		Object[][] data2 = {
				{"Boeing_737", "London","12"},
				{"Tupolew_240", "Moskwa","23"}};


		String[] columnNames1 = {"Plane Id",
				"Model",
				"Ilosc Miejsc Biznes",
				"Ilosc Miejsc Eko",
				"Calk. masa bagazu",
				"Calk. masa podreczna", "Status", "Miejsce park."};

		String[] columnNames2 = {
				"Model",
				"Sk¹d przylatuje",
		"Numer lotu"};

		JTable table1 = new JTable(zarzadzanie.toTab(), columnNames1);
	    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table1.setBorder(BorderFactory.createLineBorder(Color.blue));
	    
		JTable table2 = new JTable(zarzadzanie.toTab2(), columnNames2);
	    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table2.setBorder(BorderFactory.createLineBorder(Color.red));

		JButton enterPlaneButton = new JButton("Accept Plane");
		enterPlaneButton.setVisible(true);
		enterPlaneButton.setBounds(45, 205, 150, 40);
		enterPlaneButton.setFont(new Font("Arial Black", Font.PLAIN, 13));

		
		JScrollPane scrollPaneGora = new JScrollPane(table2);
	    scrollPaneGora.setBounds(45, 0, 600, 200);

		JScrollPane scrollPaneDol = new JScrollPane(table1);
	    scrollPaneDol.setBounds(45, 250, 600, 200);


		add(scrollPaneGora);
		add(scrollPaneDol);
		add(enterPlaneButton);
		setSize(700,500);
		setVisible(true);
		setTitle("NOWE");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
