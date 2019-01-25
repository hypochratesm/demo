package com.awt;


import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test2 extends Frame implements WindowListener{//Listener는 감시자


	private static final long serialVersionUID = 1L;

	public Test2(){

		this.setTitle("자바 윈도우");//타이틀을 생성해준다.
		setSize(200, 300);
		
		
		addWindowListener(this);//나를 감시하는 감시자.
		//자바 윈도우 창에 센스를 달고 나를 감시하게 하는거야,,,
		
		
		
		setVisible(true);

	}

	public static void main(String[] args) {
		
		
		Test2 ob = new Test2();

	}

	@Override
	public void windowActivated(WindowEvent e) {//창이 앞으로 나옴
	}

	@Override
	public void windowClosed(WindowEvent e) {//창이 종료
	}

	@Override
	public void windowClosing(WindowEvent e) {//종료될때 행동
		
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//창이 작은것
	}

	@Override
	public void windowIconified(WindowEvent e) {//창이 커지는것
	}

	@Override
	public void windowOpened(WindowEvent e) {//창이 열릴때 커서를 가져다 놓는것.
	}

}
