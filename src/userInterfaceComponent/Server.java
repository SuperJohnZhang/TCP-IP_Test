package userInterfaceComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	public Server(){
		
	}
	
	public void getServer(){
		try{
			server = new ServerSocket(8998);
			System.out.println("created the serversocket");
			System.out.println("waiting for connection");
			while(true){
				socket =  server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			}
				
		}catch(Exception e){
				e.printStackTrace();
		}
			
	}
	
	private void getClientMessage(){
		try{
			while(true){
				System.out.println(reader.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader != null){
				reader.close();
			}
			if (socket != null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
