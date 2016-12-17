package Samolot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.ZarzadzanieSamolotami;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class DodajSamolotWindow extends JFrame {

  private JPanel contentPane;
  private DefaultTableModel defTblModel = new DefaultTableModel();


  /**
   * Create the frame.
   */
  public DodajSamolotWindow(ZarzadzanieSamolotami zarzadzanie) {
  
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 603, 487);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
	setTitle("Dodawanie samolów");
    
     defTblModel = new DefaultTableModel();
    defTblModel.addColumn("Nazwa");
    defTblModel.addColumn("Calkowita masa podreczna");
    defTblModel.addColumn("Calkowita masa baga¿u");
    defTblModel.addColumn("Iloœæ miejsc");
    
    for(String[] x : zarzadzanie.pobierzZBazyListeModeliSamolotowDoWyswietlenia()){
    	defTblModel.addRow(x);
	}
    
    JTable tblModeleSamolotow = new JTable(defTblModel){
    	private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
    defTblModel = (DefaultTableModel) tblModeleSamolotow.getModel();
    tblModeleSamolotow.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tblModeleSamolotow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
    tblModeleSamolotow.setBorder(BorderFactory.createLineBorder(Color.blue));
    tblModeleSamolotow.getTableHeader().setReorderingAllowed(false);
    
    JScrollPane scrlPane = new JScrollPane(tblModeleSamolotow);
    scrlPane.setBounds(5, 50, 575, 200);
    contentPane.add(scrlPane);
    
    JLabel lblInfo = new JLabel("Lista dostêpnych modeli samolotów");
    lblInfo.setBounds(20,5, 500, 26);
    lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
    contentPane.add(lblInfo);
    
    JLabel lblError = new JLabel("Musisz wybraæ samolot!");
    lblError.setForeground(Color.RED);
    lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblError.setBounds(192, 246, 236, 26);
    contentPane.add(lblError);
    lblError.setVisible(false);
    JButton btnDodaj = new JButton("Dodaj");
    btnDodaj.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {        
    		int wybor = tblModeleSamolotow.getSelectedRow(); 
    		if(wybor == -1){
    			lblError.setVisible(true);
    			return;
    		}
    		else {
    			lblError.setVisible(false);
    			showMsgDialog();
    			zarzadzanie.dodajSamolotDoBazyDanych(wybor);
    		}
    	}
    });
    btnDodaj.setBounds(41, 360, 141, 35);
    contentPane.add(btnDodaj);
    
    JButton btnWyjcie = new JButton("Wyj\u015Bcie");
    btnWyjcie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnWyjcie.setBounds(280, 360, 141, 35);
    contentPane.add(btnWyjcie);
    
    
  }
  
  private void showMsgDialog(){
		JOptionPane.showMessageDialog(this, "Samolot zosta³ dodany do bazy danych.");

  }
}
