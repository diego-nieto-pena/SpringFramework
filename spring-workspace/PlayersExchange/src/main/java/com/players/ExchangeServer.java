package com.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ExchangeServer implements Runnable {

	private static int port = 6602;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public void run() {

		String line = "";
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;
		
		try {
			this.serverSocket = new ServerSocket(port);
			
			while (true) {

				clientSocket = serverSocket.accept();	
				
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				line = in.readLine();

				System.out.println("line: " + line);
			}
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
