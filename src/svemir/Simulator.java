package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	
	private Button pokreni=new Button("Pokreni!");
	private Svemir svemir=new Svemir();
	private Generator generator;
	private int pocetak=0;
	
	public Simulator() {
		setBounds(700, 200, 200, 400);
		setTitle("Svemir");
		populateWindow();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(generator!=null) {
					generator.prekini();
				}
				svemir.prekini();
				dispose();
			}
		});
		setResizable(false);
		setVisible(true);
		
	}
	private void populateWindow() {
		
		Panel panel=new Panel();
		panel.add(pokreni);
		add(panel, BorderLayout.SOUTH);
		add(svemir, BorderLayout.CENTER);
		
		pokreni.addActionListener((ae)->{
			pocetak=1;
			svemir.repaint();
			svemir.kreni();
			generator=new Generator(svemir);
			generator.kreni();
			pokreni.disable();
		});
		
	}
	
	public static void main(String args[]) {
		new Simulator();
	}

}
