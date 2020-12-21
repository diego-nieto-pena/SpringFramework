package com.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Thread {

	//private final Logger logger = Logger.getLogger(Player.class);
	
	 private String msg;
     private Semaphore semp1;
     private Semaphore semp2;
     AtomicInteger sent = new AtomicInteger(0);
     AtomicInteger received = new AtomicInteger(0);

     private int exchangeCounter;
     //private PropertiesLoader props = new PropertiesLoader();
  // getting localhost ip 
     private String hostName = "127.0.0.1";
     private int portNumber = 6602;
 	 private Socket clientSocket = null;

     public Player(Semaphore mine, Semaphore other, Socket client) {
    	 
    	 this.clientSocket = client;
    	 
    	 msg = "Greetings, I'am %s and I've sent %d messages";//props.getProperty("exchange.msg");
    	 //exchangeCounter = Integer.parseInt(props.getProperty("exchange.counter"));
    	 exchangeCounter = 10;
         this.semp1 = mine;
         this.semp2 = other;
     }

     public void run() {
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
			
			while (exchangeCounter > 0) {
	             semp1.acquireUninterruptibly();
	             //logger.info(String.format(String.format(msg, getName(), sent.incrementAndGet())));
	             out.println(String.format(String.format(msg, getName(), sent.incrementAndGet())));
	             semp2.release();
	             exchangeCounter--;
	         }
			
 		}catch(IOException e) {
 			System.out.println("in or out failed");
 		}
 		
         
     }
}
