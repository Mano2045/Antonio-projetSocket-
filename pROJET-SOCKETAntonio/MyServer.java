
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServer {

    private ServerSocket serverSocket;

    public MyServer(){
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrer port");   
        int port=sc.nextInt(); 
        this.serverSocket = new ServerSocket(port);
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }

    public void startServer(){
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("Error server: " + e.getStackTrace());
            closeServerSocket();
        }
    }

    public void closeServerSocket(){
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException{
        System.out.println("Demmarage du serveur");
        MyServer start = new MyServer();
        start.startServer();

    }
}
