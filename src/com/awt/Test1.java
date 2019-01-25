package com.awt;

import java.awt.Color;
import java.awt.Frame;

//AWT(Abstract Window Toolkit)
//Swing(awt를 보완해서 만들었다.)
//윈도우즈 프로그램을 만든다.



public class Test1 extends Frame {

	private static final long serialVersionUID = 1L;
	//무조건 생성자에다가 코딩을 해준다.
	
	public Test1(){
		
		this.setTitle("자바 윈도우");//타이틀을 생성해준다.
		setSize(200, 300);
		
		setBackground(new Color(255, 255, 0));//rgb color//255,255,255 -> 흰색
	    setVisible(true);//visible & hide(false)
	
	}
	
	public static void main(String[] args) {
		
		new Test1();
		

	}

}
