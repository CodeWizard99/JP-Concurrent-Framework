package com.project.server;

import com.project.client.*;

public class PeerManager extends Thread{

	@Override
	public void run() {
		Peer1 p1 = new Peer1();
		Peer2 p2 = new Peer2();
		p2.start();
		p1.start();
	}
}
