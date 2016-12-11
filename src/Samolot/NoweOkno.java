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
import javax.swing.table.DefaultTableModel;

import Controller.MySQLAccess;
import Model.Airbus_A319;
import Model.Boeing_737;
import Model.Samolot;
import Model.SamolotDB;
import Model.Tupolew_204;
import Model.ZarzadzanieSamolotami;

public class NoweOkno extends JFrame implements ActionListener{
	
	private JButton odswiezListePrzylatujacychButton;
	private ZarzadzanieSamolotami zarzadzanie;
	private JTable table;
	private JScrollPane scrollPaneGora; 
	private String[] nazwyKolumn;
	private DefaultTableModel model;
	
	public NoweOkno(ZarzadzanieSamolotami zarzadzanie, MySQLAccess sql){
	
		this.zarzadzanie = zarzadzanie;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		
		nazwyKolumn = new String[] { "ID Samolotu", "Model", "Status", "Miejsce Park."};
	    
	   // JTable table = new JTable(new DefaultTableModel());
	    model = new DefaultTableModel();
	    model.addColumn(nazwyKolumn[0]);
	    model.addColumn(nazwyKolumn[1]);
	    model.addColumn(nazwyKolumn[2]);
	    model.addColumn(nazwyKolumn[3]);
	    
	    table = new JTable(model);
		model = (DefaultTableModel) table.getModel();
		for(String[] x : zarzadzanie.samolotyNaPlycieDoWyswietlenia()){
			model.addRow(x);
		}
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(BorderFactory.createLineBorder(Color.red));
		
		odswiezListePrzylatujacychButton = new JButton("Odswiez");
		odswiezListePrzylatujacychButton.setVisible(true);
		odswiezListePrzylatujacychButton.setBounds(45, 205, 150, 40);
		odswiezListePrzylatujacychButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		odswiezListePrzylatujacychButton.addActionListener(this);
		
		scrollPaneGora = new JScrollPane(table);
	    scrollPaneGora.setBounds(45, 0, 600, 200);

		add(scrollPaneGora);
		add(odswiezListePrzylatujacychButton);
		setSize(700,500);
		setVisible(true);
		setTitle("Zarzadzanie Samolotami");
		
		table.addMouseListener(new PopClickListener());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == odswiezListePrzylatujacychButton){		
			for(int n = model.getRowCount()-1;  n >= 0; n--){
				model.removeRow(n);
			}
			zarzadzanie.pobranieSamolotowWylatujacychZLodzi();
			for(String[] x : zarzadzanie.samolotyNaPlycieDoWyswietlenia()){
				model.addRow(x);
			}
		}
	}
}
