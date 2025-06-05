package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat{
	private int r;

	public NebeskoTelo(int xx, int yy, Color c, int rr) {
		super(xx, yy, c);
		r=rr;
	}
	
	public int dohvR() {return r;}
	
	public abstract void crtaj(Graphics g);
}
