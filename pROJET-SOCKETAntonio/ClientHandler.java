
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    Socket socket;
    static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    BufferedReader input;
    PrintWriter output;
    String userName;
    public ClientHandler(Socket socket){
        this.socket = socket;
        try {
            input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(),true); 
           
            clientHandlers.add(this);
        } catch (IOException e) {
       
            e.printStackTrace();
        }
    }   
    @Override
    public void run(){
        while(socket.isConnected()){
            try{
                String msg = input.readLine();
                retour(msg);
            }
            catch(Exception e){

            }
        }
    }
    public void retour(String msg){
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.equals(this)) {
                    clientHandler.output.println(msg);
                }
            } catch (Exception e) {
                
              
            }
        }
    }
}
