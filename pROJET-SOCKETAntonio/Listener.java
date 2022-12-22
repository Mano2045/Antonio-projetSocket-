

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener{

       
    MyPanel panel;
    
    public  Listener(MyPanel pane) {
        panel=pane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.client.sendMessage(panel.client.userName+" a envoye : "+panel.texte_input.getText());
        panel.texte_input.setText("");

    }

    
}
