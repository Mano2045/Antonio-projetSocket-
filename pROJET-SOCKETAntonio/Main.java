public class Main {
	public static void main(String[] args) throws Exception {
	     Client client =new Client();
	     client.sendMessage(client.userName+" a rejoint la discussion");
	     client.receiveMessage(client);
	}
}