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



//UDP : TCP,IP�ʹ� ���ݴ�.. �����Ͱ� 100�ۼ�Ʈ �̵��� ���� ���� �� �� �ִ�. ��� �ӵ��� ������ ������ ������ ���� �������� UDP�� ����Ѵ�.
// 

//TCP/IP -> TCP�� �����ִ� ����, IP�� ������ �����͸� �����ϴ� ����
//->��Ʈ���� ���� ����� TCP�� �����͸� ������ IP�� Ȯ���Ѵ�.// ���������� ��Ȯ�� ���п� ���� ���Ǳ� �����ߴ�.
//�����͸� �ָ����� ���������� ���� �� �ִ�. ����� ���� �ڵ����� ����� ����.


//�̹� �ð����� UDP���������� �̿��ؼ� �׷�ä���� ����� ����.!!!!!!!!
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
	 DatagramSocket : UDP�� �����ͱ׷� ��Ŷ�� �����ϰų� ����
	 DatagramPacket : UDP�� �̿��Ͽ� ������ �� �մ� ������
	 MulticastSocket : �ټ��� Ŭ���̾�Ʈ�� ������ �׷��� ����

	 �׷���� : D Class(224.0.0.0~239.255.255.255)
	 */

	public ChartCS(){//�ؽ�Ʈ ���� ������ �� ���Բ� ��Ȱ��ȭ ��Ű�� ����

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

		setTitle("ä��");
		setSize(400, 400);
		setVisible(true);
		tf.requestFocus();


	}

	public void setup(){



		try {

			xGroup = InetAddress.getByName(host);

			ms = new MulticastSocket(port);

			//Ư���׷쿡 ����

			ms.joinGroup(xGroup);//���� �׷쳢�� �ۼ��� ����


			Thread th = new Thread(this);
			th.start();


		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void disConnect(){

		try {


			//Ư�� �׷쿡�� ��������

			ms.leaveGroup(xGroup);
			ms.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}
	public static void main(String[] args) {

		new ChartCS().setup();//�����带 ������������.....

	}

	@Override
	public void run() {//������


		try {

			while(true){

				byte[] buffer = new byte[512];

				//���۹��� ��Ŷ
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

				//���� �ޱ�

				ms.receive(dp);

				String str = new String(dp.getData()).trim();//dp.getData �����͸� ����Ʈ ������ �ް� �ȴ�.

				ta.append(str + "\r\n");
			}



		} catch (Exception e) {

			System.out.println(e.toString());
			disConnect();

		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {//������

		String str = tf.getText().trim();


		if(str.equals(""))
			return;

		byte[] buffer = (userName + "]" + str).getBytes();//�̷��� �޴� ���� ����Ʈ�� ������ ��Ʈ������ ����Ʈ�� ����ȯ �۾��� ���־�� �Ѵ�.

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
