package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	
	ArrayList<NebeskoTelo> lista;
	private Color pozadina = Color.BLACK;
	Thread thread;
	private int sleepTime = 70;
	boolean radi = false;
	
	public Svemir() {
		lista = new ArrayList<>();
		setBackground(pozadina);
	}
	
	public synchronized void dodajNT(NebeskoTelo n) {
		lista.add(n);
	}
	
	public synchronized void kreni() {
		radi = true;
		notify();
	}
	 
	public synchronized void zavrsi() {
		radi = false;
	}
	
	public void prekini() {
		thread.interrupt();
	}
	
	@Override
	public void paint(Graphics g) {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		try{
			while(!thread.interrupted()) {
				synchronized(this) {
					while(!radi)wait();
				}
				
				getGraphics().fillRect(0, 0, 200, 400); 
				
				for(int i = 0; i < lista.size(); i++) {
					lista.get(i).crtaj(getGraphics()); // new
				}
				
				Thread.sleep(sleepTime);
				
			}
		}catch(InterruptedException e) {}
		
	}


}
