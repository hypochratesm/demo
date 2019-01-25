package com.network;


import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {


	class WorkThread extends Thread{

		private Socket sc = null;


		public WorkThread(Socket sc){
			this.sc = sc;

		}


		@Override
		public void run() {

			try {

				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());

				System.out.println(sc.getInetAddress().getAddress() + "접속...");


				FileOutputStream fos = null;//파일을 저장하기 위함
				Object ob = null;

				while((ob = ois.readObject())!=null){

					if(ob instanceof FileInfo){

						FileInfo info = (FileInfo)ob;//다운캐스트


						//파일전송시작
						if(info.getCode() == 100){


							String str = new String(info.getData());

							fos = new FileOutputStream(str);//파일명

							System.out.println("파일 전송 시작...");




							//파일전송
						}else if(info.getCode()==110){

							if(fos==null)
								break;

							fos.write(info.getData(),0,info.getSize());

							System.out.println(info.getSize() + "byte 받는 중");

							//파일 전송 끝
						}else if(info.getCode()==200){

							if(fos==null)
								break;

							String str = new String(info.getData());

							fos.close();

							System.out.println(str + "파일 전송 끝");

							break;


						}


					}
				}

			} catch (Exception e) {

				System.out.println(e.toString());

			}
		}

	}

	public void serverStart(){

		try {

			ServerSocket ss = new ServerSocket(5555);

			System.out.println("클라이언트 접속 대기중...");

			Socket sc = ss.accept();

			WorkThread wt = new WorkThread(sc);
			wt.start();
			//스레드를 하나 만들었기 때문에 데이터를 하나 밖에 전송하지 못한다.

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

	public static void main(String[] args) {
		new FileServer().serverStart();

	}

}
