package com.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 implements Runnable {
	
	private String hostName = "127.0.0.1";
	private int portNumber;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public Server1(int port) {
		this.portNumber = port;
	}

	public void run() {
		String line = "";
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;

		try {
			this.serverSocket = new ServerSocket(this.portNumber);

			clientSocket = serverSocket.accept();
			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			
		} catch (IOException e) {
			System.out.println("Accept failed");
		}

		while (true) {

			try {
				line = in.readLine();

			} catch (IOException e) {
				System.out.println("Read failed");
			}

			System.out.println("line: " + line);
		}

	}

	protected void finalize() {
//Objects created in run method are finalized when
//program terminates and thread exits
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Could not close socket");
		}
	}
}
