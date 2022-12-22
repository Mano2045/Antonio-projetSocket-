
import java.net.Socket;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Client  {
    Socket socket;
    int port =1111;
    String ip="localhost";
    String userName;
    BufferedReader input;
    PrintWriter output;

     public Client() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        userName = scanner.nextLine();

        System.out.println("Enter port");
        port=scanner.nextInt();
        socket = new Socket(ip, port);
        output=new PrintWriter(socket.getOutputStream(),true); 
        input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
    }
   
    


	
    public void sendMessage(String m){
        System.out.println("Envoi en cours...");
        try{   
            output.println(m);
            System.out.println("Envoi reussi");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void receiveMessage(Client c){
        new Thread(new Runnable(){
            @Override
            public void run() {
                MyPanel panel=new MyPanel(c);
                panel.envoyer.addActionListener(new Listener(panel));
                panel.titre.setText("UserName :" +c.userName);
                MyFrame frame=new MyFrame(panel);
                
                while(true){
                    try {  
                     String response = input.readLine();
                     JLabel label = new JLabel(response);
                     label.setBounds(50,panel.lastm,600,25);
                     panel.message_panel.add(label);
                     panel.lastm=panel.lastm+25;
                     panel.repaint();      
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}