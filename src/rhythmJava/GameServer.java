package rhythmJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class GameServer {
	
	ServerSocket server;
	int port = 8002;
	Vector<ClientThread> vc ;
	
	public GameServer() {
		try {
			server = new ServerSocket(port);
			vc = new Vector<ClientThread>();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);
		}		
		System.out.println("**** Game Server **** Client Á¢¼ÓÀ» ±â´Ù¸®´Â Áß ****");
		
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread ct = new ClientThread(sock);
				ct.start();
				vc.addElement(ct);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in sock");
		}
	}
	
	public void removeClient(ClientThread ct) {
		vc.remove(ct);
	}
	
	
	class ClientThread extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		
		public ClientThread(Socket sock) {
			
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + "Á¢¼ÓµÊ...");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				
				
				
				in.close();
				out.close();
				sock.close();
				removeClient(this);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(sock + "²÷¾îÁü...");
			}
		}
		
	}
}
