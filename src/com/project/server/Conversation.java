package com.project.server;

import java.net.*;
import javax.swing.JOptionPane;
import java.io.*;

public class Conversation extends Thread{

	private Socket soc;
	
	Conversation(Socket soc){
		this.soc = soc;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter nos = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									soc.getOutputStream()
									)
							), true
					);
			
			BufferedReader nis = new BufferedReader(
					new InputStreamReader(
							soc.getInputStream()
							)
					);
			
			String username = nis.readLine();
			User obj = new User(nos, username);
			
			int choice = Integer.parseInt(
					JOptionPane.showInputDialog(
							"**************Menu******************* \n"
							+ "1. To Join Room\n"
							+ "2. Peer to Peer Chat"
							)
					);
			
			if(choice == 1) {
				int grp = Integer.parseInt(JOptionPane.showInputDialog("Existing Groups ->"
						+ " "+Server.group.size()+"\n"
								+ "Enter Group No. U wanna Join.."));
				
				Group g = new Group(grp, nos, nis, obj);
				g.chat();
			}
					
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
}

class Group{
	private int grp;
	private PrintWriter nos;
	private BufferedReader nis;
	private Room r;
	private User obj;
	
	Group(int grp, PrintWriter nos, BufferedReader nis, User obj){
		this.grp = grp-1;
		this.nos = nos;
		this.nis = nis;
		this.r = Server.group.get(grp);
		this.obj = obj;
	}
	
	void chat() throws Exception {
		r.getNoslist().add(obj);
		
		String str = nis.readLine();
		while(!str.equals("End")) {
			String str1 = obj.getUsername()+" >>> "+str;
			r.getQ().enqueue(str1);
			System.out.println("Server Received :"
					+ " Group "+(grp+1)+" : "+str1);
			str = nis.readLine();
		}
		
		nos.println("End");
		System.out.println(obj.getUsername()+" exited Group "+(grp+1));
		r.getNoslist().remove(obj);
		
	}

}
