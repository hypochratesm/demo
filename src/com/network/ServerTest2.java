package com.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTest2 {


	private ArrayList<Socket> clients = new ArrayList<Socket>();

	public void serverStart(){
		try {

			ServerSocket ss = new ServerSocket(5555);
			System.out.println("��������");

			while(true){

				Socket sc = ss.accept();//������� ������ ����Ʈ�� �����ϰ� �̸� �����忡�� ������.


				WorkThread wt = new WorkThread(sc);
				wt.start();

			}


		} catch (Exception e) {

			System.out.println(e.toString());

		}


	}

	class WorkThread extends Thread{

		private Socket sc;

		public WorkThread(Socket sc){
			this.sc=sc;

		}

		@Override
		public void run() {


			String ip = null;
			String msg =null;

			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));//�ѹ��� �ѹ��� �Է�

				ip = sc.getInetAddress().getHostAddress();

				//������ Ŭ���̾�Ʈ�� sc�� ����Ʈ�� ����
				clients.add(sc); 

				//�ٸ� Ŭ���̾�Ʈ���� ���� ����� �˸�

				msg = ip +"]�� ���� �߽��ϴ�.!";

				for(Socket s: clients){

					if(s==sc)//s�� ��,sc�� ������ ������
						continue;//�̹��� �н�,�Ʒ��ʿ� ��� �ڵ��� �����ϰ� �Ʒ��� �������� �ٽ� �����϶�.

					PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);

					pw.println(msg);				
				}

				System.out.println(msg);

				//����

				while((msg=br.readLine())!=null){//���� ������ ����鿡�� ������...

					for(Socket s: clients){

						if(s==sc)
							continue;//�̹��� �н�,�Ʒ��ʿ� ��� �ڵ��� �����ϰ� �Ʒ��� �������� �ٽ� �����϶�.

						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

						pw.println(msg);				
					}

					System.out.println(msg);

				}


			} catch (Exception e) {


				msg = ip + "]�� ���� �߽��ϴ�!";

				try {//���� ������ ����鿡�� �� ������...
					for(Socket s: clients){

						if(s==sc)
							continue;//�̹��� �н�,�Ʒ��ʿ� ��� �ڵ��� �����ϰ� �Ʒ��� �������� �ٽ� �����϶�.

						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

						pw.println(msg);				
					}

					System.out.println(msg);
				} catch (Exception e2) {
					
				}
			}
		}

	}
	public static void main(String[] args) {
		
		ServerTest2 ob = new ServerTest2();
		ob.serverStart();

	}

}
