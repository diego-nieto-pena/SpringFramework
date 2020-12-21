package com.player;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.player.util.PropertiesLoader;

/**
 * 
 * @author diego.nieto
 * Main class responsible for running the app
 * on the selected port, also avoiding multiple 
 * processes to be started at the same time.
 */
public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);
	
	private static ServerSocket socket;
	private static PropertiesLoader props = new PropertiesLoader();
	
	public static void main(String[] args) {
		int port;
		
		if(args.length < 1) {
			port = Integer.parseInt(props.getProperty("application.port"));
		} else {
			port = Integer.parseInt(args[0]);
		}
		
		try {
			
			InetAddress localhost = InetAddress.getByAddress(new byte[] {127,0,0,1});
			socket = new ServerSocket(port, 0, localhost);
			Initializer.initialize();
			
		} catch(BindException e) {
			logger.error("The application is already running");
			System.exit(1);
		} catch (UnknownHostException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
