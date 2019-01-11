package TTTServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sun.istack.internal.logging.Logger;

import TTTClient.ClientThread;

public class ServerModel extends Thread{
	
	private ServerSocket listener;
	//private final Logger logger = Logger.getLogger("Logger");
	private static Socket[] playerSockets = new Socket[2];
	private int connectedClients = 0;
	private int serverPort;
	
	public ServerModel()
	{
		super();
	}
	
	public void broadcast(String str)	//Send message to all connected clients
	{
		System.out.println("Starting broadcast...");
		for (Socket s : playerSockets) {
			try {
			if(s != null)
				{
					OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
					out.write(str);
					out.flush();
				}
			} catch (IOException e) {
			
			}
		}
	}
	@Override
	public void run() {
		try
		{
		listener = new ServerSocket(serverPort);
		while(true) { //server waits for an answer in a loop
			System.out.println("Waiting for a connection....");
			
				Socket sc = listener.accept();
				connectedClients++;
				if(connectedClients <= 2)
				{
					if(connectedClients == 1)
					{
						playerSockets[0] = sc;
						ClientThread client1 = new ClientThread(this, connectedClients, playerSockets[0].getInputStream(), playerSockets[0].getOutputStream());
						client1.start(); //Start a new thread for client 1
					}
					else
					{
						playerSockets[1] = sc;
						ClientThread client2 = new ClientThread(this, connectedClients, playerSockets[1].getInputStream(), playerSockets[0].getOutputStream());
						client2.start(); //Start a new thread for client 2
					}
				}
				else
				{
					throw new IndexOutOfBoundsException("Maximum player limit reached");
				}
		}
		} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (IndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
	}
	
	public void openServer(int port)
	{
		this.serverPort = port;
		listener = null;
		try {
			this.start();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void closeServer()
	{
		try {
			listener.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public int getPort() {
		return listener.getLocalPort();
	}
}
