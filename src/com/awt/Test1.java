package com.awt;

import java.awt.Color;
import java.awt.Frame;

//AWT(Abstract Window Toolkit)
//Swing(awt�� �����ؼ� �������.)
//�������� ���α׷��� �����.



public class Test1 extends Frame {

	private static final long serialVersionUID = 1L;
	//������ �����ڿ��ٰ� �ڵ��� ���ش�.
	
	public Test1(){
		
		this.setTitle("�ڹ� ������");//Ÿ��Ʋ�� �������ش�.
		setSize(200, 300);
		
		setBackground(new Color(255, 255, 0));//rgb color//255,255,255 -> ���
	    setVisible(true);//visible & hide(false)
	
	}
	
	public static void main(String[] args) {
		
		new Test1();
		

	}

}
