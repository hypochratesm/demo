package com.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test3 extends Frame{


	
	private static final long serialVersionUID = 1L;
	
	public Test3(){
		
		
	
	setTitle("À©µµ¿ì");
	setSize(200 , 300);
	
	addWindowListener(new MyWindowAdapter());
	
	setVisible(true);
	
	}
	
	
	//nested class
	class MyWindowAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		
		
	}
	public static void main(String[] args) {
		
		new Test4();

	}

}
