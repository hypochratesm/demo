package com.awt;


import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test2 extends Frame implements WindowListener{//Listener�� ������


	private static final long serialVersionUID = 1L;

	public Test2(){

		this.setTitle("�ڹ� ������");//Ÿ��Ʋ�� �������ش�.
		setSize(200, 300);
		
		
		addWindowListener(this);//���� �����ϴ� ������.
		//�ڹ� ������ â�� ������ �ް� ���� �����ϰ� �ϴ°ž�,,,
		
		
		
		setVisible(true);

	}

	public static void main(String[] args) {
		
		
		Test2 ob = new Test2();

	}

	@Override
	public void windowActivated(WindowEvent e) {//â�� ������ ����
	}

	@Override
	public void windowClosed(WindowEvent e) {//â�� ����
	}

	@Override
	public void windowClosing(WindowEvent e) {//����ɶ� �ൿ
		
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//â�� ������
	}

	@Override
	public void windowIconified(WindowEvent e) {//â�� Ŀ���°�
	}

	@Override
	public void windowOpened(WindowEvent e) {//â�� ������ Ŀ���� ������ ���°�.
	}

}
