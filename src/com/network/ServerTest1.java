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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest1 extends Frame implements ActionListener,Runnable{



	private static final long serialVersionUID = 1L;


	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private ServerSocket ss = null;//초기화
	private Socket sc = null;

	public ServerTest1(){


		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		setTitle("채팅 서버");
		setSize(300,400);
		setVisible(true);



	}







	public static void main(String[] args) {
		new ServerTest1().serverStart();


	}

	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 감지.
		//내가 데이터를 보내는것.

		String str = tf.getText();
		if(str.trim().equals(""))
			return;

		if(sc==null)
			return;//클라이언트가 접속하지 않으면 서버는 항상 비활성화 되어있다.

		try {

			OutputStream os = sc.getOutputStream();

			PrintWriter pw = new PrintWriter(os,true);//true는 데이터를 무조건 내보내라.
			
			pw.println("서버]" + str);//ln으로 강제로 데이터를 내보내게 된다.


			ta.append("\r\n서버]" + str);
			tf.setText("");
			tf.requestFocus();

		} catch (Exception e2) {

            ta.append("\r\n클라이언트와 연결 종료...");
            sc=null;//초기화 하지 않으면 쓰레기값이 남아서 다음번 연결이 안됨
		}

	}

	@Override
	public void run() {
		//데이터를 받을 때 사용하는 코딩//상대방이 보낸 데이터
		
		
		String str;
		String ip;
		
		try {
			
			if(sc==null)
				return;
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			ip = sc.getInetAddress().getHostAddress();//IP가 들어가게 된다.
			ta.append("\r\n["+ip+"]접속!!");
			
			while((str = br.readLine())!=null){
				ta.append("\r\n" + str);
				
			}
			
			
			
		} catch (Exception e) {
			
			ta.append("\r\n클라이언트 종료..");
			sc=null;
			ss=null;
			
		}
		
		
	}
	
	public void serverStart(){
		
		try {
			//서버 소켓을 생성...
			ss= new ServerSocket(5555);
			ta.setText("서버시작!!");
			
			//클라이언트의 접속을 기다림
			sc=ss.accept();//접속
			
			Thread th = new Thread(this);
			th.start();
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		
		
	}

}
