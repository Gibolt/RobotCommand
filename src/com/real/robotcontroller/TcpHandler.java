package com.real.robotcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpHandler {
	private String ipAddress;
	private final static int PORT = 50000;
	private Socket socket;
	private PrintWriter print = null;
	private boolean socketOK = true;
	
	public TcpHandler(String ipAddress) {
		this.ipAddress = ipAddress;
		new Thread(new Client()).start();
// TODO : finish writing function
//		print = new PrintWriter();
	}

	public void sendCommandTcp(String command) {
		
	}
	
	public void close() {
		socketOK = false;
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isOK() {
		return socketOK;
	}
	
	class Client implements Runnable {
		@Override
		public void run() {
			try {
				socket = new Socket(ipAddress, PORT);
			} catch (UnknownHostException e) {
				socketOK = false;
			} catch (IOException e) {
				socketOK = false;
			}
		}
	}
}
