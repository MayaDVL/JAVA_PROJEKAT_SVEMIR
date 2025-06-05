package svemir;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Kometa extends NebeskoTelo{

	private double[]nizX=new double[5];
	private double[]nizY=new double[5];
	private double ugao;
	
	public Kometa(int xx, int yy, int rr) {
		super(xx, yy, Color.GRAY, rr);
		ugao=Math.floor(Math.random()*90);
		popuniTemena(ugao);
	}
	
	private void popuniTemena(double u) {
		for(int i = 0; i < 5; i++) {
			nizX[i] = (int) (Math.cos(Math.toRadians(i * 360/5 + ugao)) * dohvR())+x;
			nizY[i] = (int) (Math.sin(Math.toRadians(i * 360/5 + ugao)) * dohvR())+y;
		}
	}
	
	
	@Override
	public void crtaj(Graphics g) {
		Color prethodnaBoja = g.getColor();
		Polygon p=new Polygon();
		for(int i=0; i<5; i++) {
			p.addPoint((int)nizX[i], (int)(nizY[i]+=5));
		}
		g.setColor(Color.GRAY);
		g.fillPolygon(p);
		g.setColor(prethodnaBoja);
		
	}
	

}
