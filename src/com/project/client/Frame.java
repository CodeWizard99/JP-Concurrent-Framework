package com.project.client;

import javax.swing.*;

import java.awt.BorderLayout;
import java.io.*;

public class Frame {

	private PrintWriter nos;
	private String username;
	
	Frame(PrintWriter nos, String username){
		init();
		this.username = username;
		this.nos = nos;
	}
	
	private JFrame f1 = new JFrame(username);
	private JButton b1 = new JButton("Send");
	private JTextArea ta = new JTextArea(20, 20);
	private JTextField tf = new JTextField(20);
	private JPanel p1 = new JPanel();
	
	
	void init() {
		ta.setEditable(false);
		p1.add(tf);
		p1.add(b1);
		f1.add(ta);
		f1.add(BorderLayout.SOUTH, p1);
		
		b1.addActionListener(e -> {
			String str = tf.getText();
			nos.println(str);
			tf.setText("");
		});
		
		tf.addActionListener(e->{
			String str = tf.getText();
			nos.println(str);
			tf.setText("");
		});
		
		f1.setSize(400, 400);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void show() {
		f1.setVisible(true);
	}
	
	JTextArea getTextArea() {
		return ta;
	}
	
	
}
