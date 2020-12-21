package com.players;

import java.util.concurrent.Semaphore;

public class Main {

	private static int port = 6602;
	private final static Semaphore semp1 = new Semaphore(1);
    private final static Semaphore semp2 = new Semaphore(0);
    
	public static void main(String[] args) {
		try {
			int port = 6602;
			ExchangeServer srv = new ExchangeServer();
			

		    Thread s = new Thread(srv);
		    s.start();
		    
			Player initiator = new Player(semp1, semp2, null);
	        Player receptor = new Player(semp2, semp1, null);
	        initiator.start();
	        receptor.start();
	        initiator.join();
	        receptor.join();
			
			/*Player clt = new Player(port, "127.0.0.1");



		    Thread c = new Thread(clt);
		    c.start();*/
	        
	        /*Exchanger<Integer> ex = new Exchanger<>();
			new Initiator(ex).start();
			new Initiator(ex).start();*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
