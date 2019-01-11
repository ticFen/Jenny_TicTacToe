package TTTClient;

import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.scene.control.Button;

public class ClientModel extends Thread {
	private BufferedReader serverOutput;
	private OutputStreamWriter stringOutput;
	private Scanner in = new Scanner(System.in);
	private Socket socket;
	

	public Button[] btnInterFaces;
	
	
	public ClientModel()
	{
		super();
	}
	
	public void startConnection(int port) //Main method, connect to server
	{
		try {
			Socket socket = new Socket("127.0.0.1", port);
			stringOutput = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));		//what is read from server
			this.start();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override //Monitor what comes from the Server
	//Used help from this link https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
	public void run(){
		System.out.println("Client is listening on server messages...");
		try {
			while(true)
			{
			String response = serverOutput.readLine();
			if(response != null)			//what the client reads from server.broadcast, server.broadcast sends X or O
				{
				System.out.println(response);
				if(response.equals("X")) {
				System.out.println("Server sent X");
				socket.close();
				}
				if(response.equals("O")) {
				System.out.println("Server sent O");
				socket.close();
				}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendInputToServer(String s)
	{
		try {
		stringOutput.write(s);
		stringOutput.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void disconnect()
	{
		try {
		socket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPlayerChar(String playerChar)
	{
		
	}
}
