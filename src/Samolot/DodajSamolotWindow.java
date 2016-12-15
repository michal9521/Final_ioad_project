package Samolot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.ZarzadzanieSamolotami;

import javax.swing.JLabel;
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
    
    DefaultTableModel defTblModel = new DefaultTableModel();
    defTblModel.addColumn("Nazwa");
    defTblModel.addColumn("Calkowita masa podreczna");
    defTblModel.addColumn("Calkowita masa baga¿u");
    defTblModel.addColumn("Iloœæ miejsc");
    
    JTable tblModeleSamolotow = new JTable(defTblModel);
    defTblModel = (DefaultTableModel) tblModeleSamolotow.getModel();
    tblModeleSamolotow.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
    tblModeleSamolotow.setBorder(BorderFactory.createLineBorder(Color.blue));
    
    JScrollPane scrlPane = new JScrollPane(tblModeleSamolotow);
    scrlPane.setBounds(5, 5, 575, 200);
    contentPane.add(scrlPane);
    
    JLabel lblError = new JLabel("Musisz wybraæ samolot!");
    lblError.setForeground(Color.RED);
    lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblError.setBounds(192, 246, 236, 26);
    contentPane.add(lblError);
    lblError.setVisible(false);
    
    JButton btnDodaj = new JButton("Dodaj");
    btnDodaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {        
        if(tblModeleSamolotow.getSelectedRow() == -1){
        	lblError.setVisible(true);
        	return;
        }
        else {
        	lblError.setVisible(false);
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
}
