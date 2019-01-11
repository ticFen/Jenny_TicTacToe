package TTTClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import TTTServer.ServerModel;

public class ClientThread extends Thread {
		private final Logger logger = Logger.getLogger("");
		private ServerModel server;
		private OutputStreamWriter out;
		private String symbol;
		private BufferedReader in;

		public ClientThread(ServerModel server, int connectedClients, InputStream in, OutputStream out) throws IOException {
			super("Client thread " + connectedClients + " started.");
			this.in = new BufferedReader(new InputStreamReader(in));
			this.out = new OutputStreamWriter(out, "UTF-8");
			this.server = server;
			assignSymbol(connectedClients);
		}

		@Override
		public void run() {
			logger.info("Request from client... success!");	//FHNW slides
			
			try {
				while (true) {
					String clientMessage = "X";
					if(clientMessage != null)
					{
						if(clientMessage.equals("X"))
						{
							server.broadcast("X");
						}
						if(clientMessage.equals("O"))
						{
							server.broadcast("O");
						}
					}
				}
			} catch (Exception e) {
	            logger.severe(e.toString());
	        }
			
		}
		
	public String assignSymbol(int clientNumber) {
		
		if(clientNumber == 1)
		{
			symbol = "X";
		}
		
		if(clientNumber == 2)
		{
			symbol = "O";
		}
		return symbol;
	}
	
	public String getSymbol()
	{
		return this.symbol;
	}
}

