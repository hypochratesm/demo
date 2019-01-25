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
import java.net.URL;
import java.net.URLConnection;

public class Test2 extends Frame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextArea ta;
	private TextField tf;

	private Test2(){

		ta = new TextArea();
		add(ta);

		tf = new TextField("http://");//텍스트 필드에 변수를 넣을 수 있다.
		tf.addActionListener(this);
		add(tf, BorderLayout.NORTH);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("HTML VIEWER");
		setSize(4000, 3000);
		setVisible(true);



	}

	public static void main(String[] args) {

		new Test2();

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		try {

			String str;
			URL url = new URL(tf.getText());
			ta.setText("");


			//방법1
			/*	InputStream is = url.openStream();//스트림으로 네이버가 보이게끔 코딩한것.

			BufferedReader br = new BufferedReader(new InputStreamReader(is));//내가 연결한 웹사이트의 내용을 담아 놓았다.
			 */			
			//방법2
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));//내가 연결한 웹사이트의 내용을 담아 놓았다
			
			String s = conn.getContentType();
			ta.setText("mime Type:" + s);//어떤 형식으로 이루어졌는지 어떤 입력언어를 썼는지 새로운 창에서 파악 할 수 있다.
             //utf, 텍스트 문서로 이루어져 있다.
			while((str=br.readLine())!=null){

				if(ta.getText().equals(""))
					ta.setText(str);
				else
					ta.setText(ta.getText() + "\r\n" + str);//str+=str//자기 자신에게 계속 누적시킨다.
			}

			is.close();









		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
