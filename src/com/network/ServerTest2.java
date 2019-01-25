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
			System.out.println("서버시작");

			while(true){

				Socket sc = ss.accept();//만들어진 소켓을 리스트에 보관하고 이를 스레드에게 보낸다.


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

				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));//한번에 한번에 입력

				ip = sc.getInetAddress().getHostAddress();

				//접속한 클라이언트의 sc를 리스트에 저장
				clients.add(sc); 

				//다른 클라이언트에게 접속 사실을 알림

				msg = ip +"]가 입장 했습니다.!";

				for(Socket s: clients){

					if(s==sc)//s가 나,sc가 현재의 스레드
						continue;//이번만 패스,아래쪽에 모든 코딩을 생략하고 아래로 빠져나가 다시 실행하라.

					PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);

					pw.println(msg);				
				}

				System.out.println(msg);

				//본문

				while((msg=br.readLine())!=null){//나를 제외한 사람들에게 보내라...

					for(Socket s: clients){

						if(s==sc)
							continue;//이번만 패스,아래쪽에 모든 코딩을 생략하고 아래로 빠져나가 다시 실행하라.

						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

						pw.println(msg);				
					}

					System.out.println(msg);

				}


			} catch (Exception e) {


				msg = ip + "]가 퇴장 했습니다!";

				try {//나를 제외한 사람들에게 또 보낸다...
					for(Socket s: clients){

						if(s==sc)
							continue;//이번만 패스,아래쪽에 모든 코딩을 생략하고 아래로 빠져나가 다시 실행하라.

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
