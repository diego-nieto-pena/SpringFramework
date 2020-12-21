package com.player;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.player.util.PropertiesLoader;

/**
 * 
 * @author diego.nieto
 * Player class handles the semaphore exchange (acquire/release)
 * also increments the number of sent messages for each thread.
 */
public class Player extends Thread {

	private final Logger logger = Logger.getLogger(Player.class);
	
	 private String msg;
     private Semaphore semp1;
     private Semaphore semp2;
     AtomicInteger sent = new AtomicInteger(0);

     private int exchangeCounter;
     private PropertiesLoader props = new PropertiesLoader();

     public Player(Semaphore mine, Semaphore other) {
    	 msg = props.getProperty("exchange.msg");
    	 exchangeCounter = Integer.parseInt(props.getProperty("exchange.counter"));	
         this.semp1 = mine;
         this.semp2 = other;
     }

     public void run() {
         while (exchangeCounter > 0) {
             semp1.acquireUninterruptibly();
             logger.info(String.format(msg, getName(), sent.incrementAndGet()));
             semp2.release();
             exchangeCounter--;
         }
     }
}
