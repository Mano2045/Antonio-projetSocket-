import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class MyFrame extends JFrame{

	MyPanel panel;

	MyFrame(MyPanel panel){
		panel=panel;
		add(panel);
		setTitle("MyChat");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
	}


}