package Samolot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.LineNumberInputStream;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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
	private JLabel tlo = new JLabel("");
		
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
		
		tlo.setBounds(15, 200, 700, 300);
        add(tlo);	
		tlo.setIcon(new ImageIcon("src/Samolot/samolot.jpg"));
		
		table.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
		        if (e.isPopupTrigger())
		            doPop(e);
		    }

		    public void mouseReleased(MouseEvent e){
		        if (e.isPopupTrigger())
		            doPop(e);
		    }

		    private void doPop(MouseEvent e){
		        PopUpMenu menu = new PopUpMenu();
		        menu.show(e.getComponent(), e.getX(), e.getY());
		    }
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == odswiezListePrzylatujacychButton){		
			for(int n = model.getRowCount()-1;  n >= 0; n--){
				model.removeRow(n);
			}
			zarzadzanie.pobranieSamolotowWylatujacychZLodzi();
			zarzadzanie.pobieranieSamolotowPzylatujacych();
			for(String[] x : zarzadzanie.samolotyNaPlycieDoWyswietlenia()){
				model.addRow(x);
			}
		}
	}
	class PopUpMenu extends JPopupMenu implements ActionListener {
	    JMenu zmienStatus;
	    JMenuItem status1;
	    JMenuItem status2;
	    JMenuItem status3;
	    JMenuItem status4;
	    JMenuItem status5;
	    
	    public PopUpMenu(){
	        zmienStatus = new JMenu("Zmieñ status");
	        status1 = new JMenuItem("gotowy do lotu");
	        status2 = new JMenuItem("roz³adowany");
	        status3 = new JMenuItem("za³adowany");
	        status4 = new JMenuItem("gotowy do startu");
	        status5 = new JMenuItem("zaparkowany");

	        zmienStatus.add(status1);
	        zmienStatus.add(status2);
	        zmienStatus.add(status3);
	        zmienStatus.add(status4);
	        zmienStatus.add(status5);
	        
	        add(zmienStatus);
	        
	        zmienStatus.addActionListener(this);
	        status1.addActionListener(this);
	        status2.addActionListener(this);
	        status3.addActionListener(this);
	        status4.addActionListener(this);
	        status5.addActionListener(this);
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == status1){
				int i = table.getSelectedRow();
				zarzadzanie.miejsceParkingoweNieDotyczy(i);
				zarzadzanie.zmienStatus(i, Model.status.gotowyDoLotu);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showMessageDialog(this, "Samolot jest gotowy do lotu.");
			}
			else if(e.getSource() == status2){
				int i = table.getSelectedRow();
				zarzadzanie.miejsceParkingoweNieDotyczy(i);
				zarzadzanie.zmienStatus(i, Model.status.rozladowany);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showMessageDialog(this, "Samolot zosta³ roz³adowany.");
				
			}
			else if(e.getSource() == status3){
				int i = table.getSelectedRow();
				zarzadzanie.miejsceParkingoweNieDotyczy(i);
				zarzadzanie.zmienStatus(i, Model.status.zaladowany);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showMessageDialog(this, "Samolot zosta³ za³adowany.");			
			}
			else if(e.getSource() == status4){
				int i = table.getSelectedRow();
				zarzadzanie.miejsceParkingoweNieDotyczy(i);
				zarzadzanie.zmienStatus(table.getSelectedRow(), Model.status.gotowDoStartu);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showMessageDialog(this, "Samolot jest gotowy do startu.");			
			}
			else if(e.getSource() == status5){
				int row = table.getSelectedRow();
				zarzadzanie.ustalMiejsceParkingowe(row);
				zarzadzanie.zmienStatus(row, Model.status.zaparkowany);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JOptionPane.showMessageDialog(this, "Samolot zosta³ zaparkowany.");			
			}
			odswiezListePrzylatujacychButton.doClick();
		}
	}
}
