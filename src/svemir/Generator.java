package svemir;

public class Generator extends Thread{
	private Svemir svemir;
	boolean radi=false;
	
	public Generator(Svemir s) {
		svemir=s;
		this.start();
	}
	
	public synchronized void kreni() {
		radi=true;
		notify();
	}
	
	public synchronized void zavrsi() {
		radi=false;
	}
	
	public void prekini() {
		this.interrupt();
	}
	
	@Override
	public void run() {
		try{
			while(!interrupted()) {
				synchronized(this) {
					if(!radi)
						wait();
				}
				svemir.dodajNT(new Kometa((int)(Math.floor(Math.random()*(200))),0,(int)Math.floor(Math.random()*(30-10+1)+10)));
				sleep(900);
			}
		}catch(InterruptedException e) {}
	}
}
