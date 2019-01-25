package com.network;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;



//UDP : TCP,IP와는 정반대.. 데이터가 100퍼센트 이동을 하지 않을 수 도 있다. 대신 속도가 굉장히 빠르기 때문에 지역 랜에서는 UDP를 사용한다.
// 

//TCP/IP -> TCP는 보내주는 역할, IP는 보내진 데이터를 검증하는 역할
//->스트림을 먼저 만들고 TCP로 데이터를 보내고 IP로 확인한다.// 정보전달의 정확성 덕분에 많이 사용되기 시작했다.
//데이터를 멀리까지 안정적으로 보낼 수 있다. 만들어 질때 코딩양이 상당히 많다.


//이번 시간에는 UDP프로토콜을 이용해서 그룹채팅을 만들어 보자.!!!!!!!!
public class ChartCS  extends Frame implements ActionListener,Runnable{


	private static final long serialVersionUID = 1L;

	private MulticastSocket ms = null;
	private InetAddress xGroup = null;

	private String host = "230.0.0.0";
	private int port = 7777;
	private String userName = "19";

	private TextArea ta = new TextArea();
	private TextField tf = new TextField();

	/*
	 DatagramSocket : UDP로 데이터그램 패킷을 전송하거나 수신
	 DatagramPacket : UDP를 이용하여 전송할 수 잇는 데이터
	 MulticastSocket : 다수의 클라이언트에 데이터 그램을 전송

	 그룹범위 : D Class(224.0.0.0~239.255.255.255)
	 */

	public ChartCS(){//텍스트 에어리어를 편집할 수 없게끔 비활성화 시키는 역할

		ta.setEditable(false);
		add(ta,BorderLayout.CENTER);

		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);


		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setTitle("채팅");
		setSize(400, 400);
		setVisible(true);
		tf.requestFocus();


	}

	public void setup(){



		try {

			xGroup = InetAddress.getByName(host);

			ms = new MulticastSocket(port);

			//특정그룹에 포함

			ms.joinGroup(xGroup);//같은 그룹끼리 송수신 가능


			Thread th = new Thread(this);
			th.start();


		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void disConnect(){

		try {


			//특정 그룹에서 빠져나옴

			ms.leaveGroup(xGroup);
			ms.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}
	public static void main(String[] args) {

		new ChartCS().setup();//스레드를 실행시켜줘야함.....

	}

	@Override
	public void run() {//받을때


		try {

			while(true){

				byte[] buffer = new byte[512];

				//전송받을 패킷
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

				//전송 받기

				ms.receive(dp);

				String str = new String(dp.getData()).trim();//dp.getData 데이터를 바이트 단위로 받게 된다.

				ta.append(str + "\r\n");
			}



		} catch (Exception e) {

			System.out.println(e.toString());
			disConnect();

		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {//보낼때

		String str = tf.getText().trim();


		if(str.equals(""))
			return;

		byte[] buffer = (userName + "]" + str).getBytes();//이렇게 받는 것은 바이트기 때문에 스트링에서 바이트로 형변환 작업을 해주어야 한다.

		try {

			DatagramPacket dp =new DatagramPacket(buffer, buffer.length,xGroup,port);


			ms.send(dp);
			tf.setText("");
			tf.requestFocus();



		} catch (Exception e2) {

			System.out.println(e.toString());

		}

	}

}
