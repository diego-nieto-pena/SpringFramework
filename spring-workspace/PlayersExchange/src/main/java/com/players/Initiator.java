package com.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Exchanger;

public class Initiator extends Thread{
	private Exchanger<Integer> payload;

	private static final String MSG = "Greetings I've sent messages %s - %d";

    private String hostName = "127.0.0.1";
    private int portNumber = 6602;
	private Socket clientSocket = null;
	 
	public Initiator(Exchanger<Integer> arg) {
		payload = arg;
	}

	public void run() {
		Integer counter = null;
		
    	String line;
 		PrintWriter out = null;
 		BufferedReader in = null;
 		BufferedReader stdIn = null;
 		
		try {
			
 			if (clientSocket == null) {
 				System.out.println("client socket is null");
 				this.clientSocket = new Socket(this.hostName, this.portNumber);
 			}
			
 			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			for(int i=0; i<10; i++) {
				counter = payload.exchange(i+1);
				out.println(String.format(String.format(MSG, getName(), counter)));
				//System.out.println(getName() + " i: " + i + " counter: " + counter);
			}
				
			
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
