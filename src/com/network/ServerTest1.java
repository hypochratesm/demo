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
	private ServerSocket ss = null;//�ʱ�ȭ
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
		setTitle("ä�� ����");
		setSize(300,400);
		setVisible(true);



	}







	public static void main(String[] args) {
		new ServerTest1().serverStart();


	}

	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ����.
		//���� �����͸� �����°�.

		String str = tf.getText();
		if(str.trim().equals(""))
			return;

		if(sc==null)
			return;//Ŭ���̾�Ʈ�� �������� ������ ������ �׻� ��Ȱ��ȭ �Ǿ��ִ�.

		try {

			OutputStream os = sc.getOutputStream();

			PrintWriter pw = new PrintWriter(os,true);//true�� �����͸� ������ ��������.
			
			pw.println("����]" + str);//ln���� ������ �����͸� �������� �ȴ�.


			ta.append("\r\n����]" + str);
			tf.setText("");
			tf.requestFocus();

		} catch (Exception e2) {

            ta.append("\r\nŬ���̾�Ʈ�� ���� ����...");
            sc=null;//�ʱ�ȭ ���� ������ �����Ⱚ�� ���Ƽ� ������ ������ �ȵ�
		}

	}

	@Override
	public void run() {
		//�����͸� ���� �� ����ϴ� �ڵ�//������ ���� ������
		
		
		String str;
		String ip;
		
		try {
			
			if(sc==null)
				return;
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			ip = sc.getInetAddress().getHostAddress();//IP�� ���� �ȴ�.
			ta.append("\r\n["+ip+"]����!!");
			
			while((str = br.readLine())!=null){
				ta.append("\r\n" + str);
				
			}
			
			
			
		} catch (Exception e) {
			
			ta.append("\r\nŬ���̾�Ʈ ����..");
			sc=null;
			ss=null;
			
		}
		
		
	}
	
	public void serverStart(){
		
		try {
			//���� ������ ����...
			ss= new ServerSocket(5555);
			ta.setText("��������!!");
			
			//Ŭ���̾�Ʈ�� ������ ��ٸ�
			sc=ss.accept();//����
			
			Thread th = new Thread(this);
			th.start();
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		
		
	}

}
