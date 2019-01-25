package com.network;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.Socket;

public class ClientTest1 extends Frame implements ActionListener,Runnable{



	private static final long serialVersionUID = 1L;


	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private Socket sc = null;
	private int port = 5555;
	private String host ="192.168.16.21";//127.0.0.1 =>루프백 주소..

	public ClientTest1(){


		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		setTitle("채팅 클라이언트");
		setSize(300,400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ClientTest1().connect();


	}

	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 감지.
		//내가 데이터를 보내는것.

		String str = tf.getText();
		
		if(str.trim().equals(""))
			return;

		if(sc==null)
			return;

		try {

			OutputStream os = sc.getOutputStream();

			PrintWriter pw = new PrintWriter(os,true);//true는 데이터를 무조건 내보내라.
			pw.println("클라이언트]" + str);


			ta.append("\r\n클라이언트0]" + str);
			tf.setText("");
			tf.requestFocus();

		} catch (Exception e2) {

            ta.append("\r\n서버와 연결 종료...");
            sc=null;//초기화 하지 않으면 쓰레기값이 남아서 다음번 연결이 안됨
		}

	}

	@Override
	public void run() {
		//데이터를 받을 때 사용하는 코딩//상대방이 보낸 데이터
		
		
		String str;
		
		try {
			
			if(sc==null)
				return;
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while((str = br.readLine())!=null){
				ta.append("\r\n" + str);
				
			}
			
			
			
		} catch (Exception e) {
			
			ta.append("\r\n서버 연결 종료..");
			sc=null;
			
			
		}
		
		
	}
	
	public void connect(){
		
		try {
		
			
		    sc = new Socket(host, port);
			
			
			Thread th = new Thread(this);
			th.start();
			
			
		} catch (Exception e) {
			
			System.out.println("서버가 죽어있다.");
			
		}
		
		
		
	}

}
