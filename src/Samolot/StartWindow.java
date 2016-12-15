package Samolot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MySQLAccess;
import Model.ZarzadzanieSamolotami;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow extends JFrame {

  private JPanel contentPane;
  private JLabel lblTlo;
  private ZarzadzanieSamolotami zarzadzanie;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          StartWindow frame = new StartWindow();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public StartWindow() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 543, 430);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    zarzadzanie = new ZarzadzanieSamolotami();
    
    JButton btnDodaj = new JButton("Dodaj Samolot");
    btnDodaj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DodajSamolotWindow dodajSamolotWindow = new DodajSamolotWindow(zarzadzanie);
        dodajSamolotWindow.setVisible(true);
      }
    });
    btnDodaj.setBounds(169, 135, 200, 35);
    contentPane.add(btnDodaj);
    
    JButton btnZarz�dzajSamolotami = new JButton("Zarz�dzaj Samolotami");
    btnZarz�dzajSamolotami.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  Zarz�dzanieSamolotamiWindow zarz�dzajSamolotamiWindow = new Zarz�dzanieSamolotamiWindow(zarzadzanie);
    	  zarz�dzajSamolotamiWindow.setVisible(true);
      }
    });
    btnZarz�dzajSamolotami.setBounds(169, 213, 200, 35);
    contentPane.add(btnZarz�dzajSamolotami);
        
    JButton btnWyjdz = new JButton("Wyjd\u017A");
    btnWyjdz.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
      	  System.exit(0);
        }
      });
    btnWyjdz.setBounds(169, 286, 200, 35);
    contentPane.add(btnWyjdz);
    
    lblTlo = new JLabel();
    lblTlo.setIcon(new ImageIcon("src/Samolot/samolot.jpg"));
    lblTlo.setBounds(0,0, 527, 391);
    contentPane.add(lblTlo);
    
	setTitle("Modu� Samoloty");
  }
}
