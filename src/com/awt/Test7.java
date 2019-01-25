package com.awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.print.DocFlavor.STRING;

public class Test7 extends Frame {
	
	
	private static final long serialVersionUID = 1L;
	
	private int x,y;
	
	private Label lbl = new Label("",Label.CENTER);
	
	
	
	public Test7(){
		
		add(lbl,BorderLayout.SOUTH);
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		
		setBackground(new Color(150,150,150));
		setForeground(new Color(50,50,150));
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
		
		setTitle("ÁÂÇ¥Ãâ·Â");
		setSize(400,400);
		setVisible(true);
		
	}

	

	public static void main (String[] args){
		new Test7();

	}
	@Override
	public void paint(Graphics g) {
		
		String str;
		
		str = "(" + x + "," + y + ")";
		g.drawString(str, x, y);
	
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	class MouseHandler extends MouseAdapter{

		@Override
		public void mousePressed(MouseEvent evt) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {	
		}

	}
	
	class MouseMotionHandler extends MouseMotionAdapter{

		@Override
		public void mouseDragged(MouseEvent evt) {
			 x= evt.getX();
			 y= evt.getY();
			 repaint();
		}

		@Override
		public void mouseMoved(MouseEvent evt) {
			
			
			String str = 
		    String.format("(%d,%d)" ,evt.getX(),evt.getY());
		}
		
		
		
		
	}

}
