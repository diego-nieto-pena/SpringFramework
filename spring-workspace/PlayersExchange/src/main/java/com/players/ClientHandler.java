package com.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private String hostName = "127.0.0.1";
	private int portNumber = 6602;
	private Socket clientSocket = null;

	public ClientHandler(Socket client) {
		this.clientSocket = client;
	}

	public ClientHandler(int portNumber, String hostName) {
		this.portNumber = portNumber;
		this.hostName = hostName;
	}

	public void run() {
		String line;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;

		try {
			if (clientSocket == null)
				this.clientSocket = new Socket(this.hostName, this.portNumber);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			out.println("Test string from client");
		} catch (IOException e) {
			System.out.println("in or out failed");
		}

	}
}
