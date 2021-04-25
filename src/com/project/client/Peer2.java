package com.project.client;

import java.net.*;

import javax.swing.JTextArea;

import java.io.*;

public class Peer2 extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("Server Signing On");
			ServerSocket ss = new ServerSocket(9081);
			Socket soc = ss.accept();
			Conversation c = new Conversation(soc);
			c.start();
			ss.close();
		}catch(Exception ex) {
			
		}
	}
}


class Conversation extends Thread{
	
	Socket soc;
	
	public Conversation(Socket soc) {
		this.soc = soc;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader nis = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			PrintWriter nos = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
			
			Frame f = new Frame(nos, "Raju");
			f.show();
			
			JTextArea ta = f.getTextArea();
			ta.append("\t\tRaju\n");
			String str = nis.readLine();
			while(!str.equals("End")) {
				ta.append("\n"+str);
				str = nis.readLine();
			}
			ta.append("Client Signing Off");
			Thread.sleep(1000);
			System.exit(0);
			
		}catch(Exception ex) {
			
		}
	}
	
}
