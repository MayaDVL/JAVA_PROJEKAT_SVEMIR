package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	int x, y;
	private Color boja;
	
	public Objekat(int xx, int yy, Color c) {
		x=xx; y=yy; boja=c;
	}
	
	public int dohvX() {return x;}
	public int dohvY() {return y;}
	public Color dohvBoju() {return boja;}
	
	public void promeniKoor(int pomeraj) {
		x+=pomeraj;
		y+=pomeraj;
	}
	
	public abstract void crtaj(Graphics g);
}
