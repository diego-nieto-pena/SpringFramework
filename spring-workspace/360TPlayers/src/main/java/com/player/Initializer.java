package com.player;

import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * 
 * @author diego.nieto
 * Initializer class creates the Player instances
 * starts and join the threads.
 */
public class Initializer {
	
	private static final Logger logger = Logger.getLogger(Initializer.class);

	private final static Semaphore semp1 = new Semaphore(1);
    private final static Semaphore semp2 = new Semaphore(0);
    
    static Player initiator;
    static Player receptor;
    public static void initialize() {
    	initiator = new Player(semp1, semp2);
        receptor = new Player(semp2, semp1);
        
        try {
        	initiator.start();
        	initiator.setName("Initiator");
            receptor.start();
            receptor.setName("Receptor");
            initiator.join();
            receptor.join();	
        } catch(InterruptedException e) {
        	logger.error(e.getMessage(), e);
        }
    }
}
