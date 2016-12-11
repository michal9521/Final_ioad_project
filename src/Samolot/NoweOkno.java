package Samolot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.MySQLAccess;
import Model.Airbus_A319;
import Model.Boeing_737;
import Model.Samolot;
import Model.SamolotDB;
import Model.Tupolew_204;
import Model.ZarzadzanieSamolotami;

public class NoweOkno extends JFrame implements ActionListener{
	
	private JButton odswiezListePrzylatujacychButton;
	private JButton enterPlaneButton;
	private MySQLAccess sqlAccess;
	private ZarzadzanieSamolotami zarzadzanie;
	private JTable table1;
	private JTable table2;
	private String[] columnNames2;
	
	public NoweOkno(ZarzadzanieSamolotami zarzadzanie, MySQLAccess sql){
	
		sqlAccess = sql;
		this.zarzadzanie = zarzadzanie;
		
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

		columnNames2 = new String[]{
				"Model",
				"Sk�d przylatuje",
		"Numer lotu"};

		table1 = new JTable(zarzadzanie.toTab(), columnNames1);
	    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table1.setBorder(BorderFactory.createLineBorder(Color.blue));
	    
		table2 = new JTable(zarzadzanie.toTab2(), columnNames2);
	    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table2.setBorder(BorderFactory.createLineBorder(Color.red));

		enterPlaneButton = new JButton("Accept Plane");
		enterPlaneButton.setVisible(true);
		enterPlaneButton.setBounds(205, 205, 150, 40);
		enterPlaneButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		odswiezListePrzylatujacychButton = new JButton("Odswiez");
		odswiezListePrzylatujacychButton.setVisible(true);
		odswiezListePrzylatujacychButton.setBounds(45, 205, 150, 40);
		odswiezListePrzylatujacychButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		odswiezListePrzylatujacychButton.addActionListener(this);
		
		JScrollPane scrollPaneGora = new JScrollPane(table2);
	    scrollPaneGora.setBounds(45, 0, 600, 200);

		JScrollPane scrollPaneDol = new JScrollPane(table1);
	    scrollPaneDol.setBounds(45, 250, 600, 200);


		add(scrollPaneGora);
		add(scrollPaneDol);
		add(enterPlaneButton);
		add(odswiezListePrzylatujacychButton);
		setSize(700,500);
		setVisible(true);
		setTitle("NOWE");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == odswiezListePrzylatujacychButton){
			List<SamolotDB> listaPrzylatujacych = sqlAccess.getSamolotyListFromDatabase();
			for (SamolotDB samolotDB : listaPrzylatujacych){
				String model = samolotDB.getModelSamolotu().getNazwa();
				Samolot samolot = null;
				if(model.equals("Tupolew")){
					samolot = new Tupolew_204(Integer.toString(samolotDB.getIdSamolotu()), "Lodz", 1);
				}
				else if(model.equals("Boeing 737")){
					samolot = new Boeing_737(Integer.toString(samolotDB.getIdSamolotu()), "Lodz", 1);
				}
				else if(model.equals("MiniSamolot")){
					samolot = new Airbus_A319(Integer.toString(samolotDB.getIdSamolotu()), "Lodz", 1);
				}
				zarzadzanie.Przylot(samolot);
			}
			table2 = new JTable(zarzadzanie.toTab2(), columnNames2);
		}
		if(e.getSource() == enterPlaneButton){
			
		}
		
	}

}
