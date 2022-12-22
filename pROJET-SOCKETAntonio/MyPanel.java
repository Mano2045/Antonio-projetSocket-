import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class MyPanel extends JPanel {


	 Dimension SCREEN_SIZE= new Dimension(700,500);
   JTextField texte_input=new JTextField();
   JLabel titre=new JLabel("");
   JButton envoyer=new JButton("Envoyer");
   JPanel message_panel=new JPanel();
   Client client;
   int lastm=10;
    MyPanel(Client c){
      client=c;
      setLayout(null);
      add(message_panel);
      message_panel.setBounds(50,20,450,300);
      add(titre);
      titre.setBounds(550,60,100,20);
      add(texte_input);
      texte_input.setBounds(50,400, 300, 80);
      add(envoyer);
      envoyer.setBounds(400,400, 80, 30);

    	setPreferredSize(SCREEN_SIZE);
      setBackground(new Color(0,153,102));
      
    }

 
}