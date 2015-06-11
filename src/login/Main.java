package login;
import userInterfaceComponent.*;

import java.awt.Dimension;
import java.net.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* this part is used to check the identification of the host 
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			String localName = ip.getHostName();
			String localId = ip.getHostAddress();
			System.out.println("The Host Name is: "+localName);
			System.out.println("The Host IP is: "+ localId);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		*/
		Client myClient = new Client("sending message");
		myClient.setSize(new Dimension(400, 200));
		Server myServer = new Server();
		myServer.getServer();
	}

}
