package com.project.client;

import java.net.*;

import javax.swing.JTextArea;

import java.io.*;

public class Peer1 extends Thread{
	
	@Override
	public void run() {
		try {
			Socket soc = new Socket("127.0.0.1", 9081);
			
			BufferedReader nis = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			PrintWriter nos = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
			
			Frame f = new Frame(nos, "Umang");
			f.show();
			
			JTextArea ta = f.getTextArea();
			ta.append("\t\tUmang\n");
			String str = nis.readLine();
			while(!str.equals("End")) {
				ta.append("\n"+str);
				str = nis.readLine();
			}
			ta.append("Client Signing Off");
			soc.close();
			Thread.sleep(1000);
			System.exit(0);
			
		}catch(Exception ex) {
			
		}
	}
}

