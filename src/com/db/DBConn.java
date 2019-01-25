package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	private static Connection dbConn;//인터페이스와 클래스의 초기값은 항상 null이다.

	public static Connection getConnection(){

		if(dbConn==null){//자바에서의 null은 비어있다라는 뜻 . 데이터가 없다 라는뜻
			             //dbConn에  데이터가 없으니 채워주어야 한다. 
			            

			try {//예외처리를 할때 쓰는 try-catch문.

				String url ="jdbc:oracle:thin:@192.168.16.20:1521:TestDB";
				//파일식별을 해서 jdbc를 진행하기위해 오라클 내의 thin드라이버를 사용해 @이하 아이피에 위치한 TestDB에서 데이터를 가져온다.
				//URL -파일식별자는 네트워크 상에서 자원이 어디 있는지를 알려주기 위한 규약.
			    //(UNIFORM RESOURCE LOCATOR)



				//다이렉트로 db를 연결하면서 가장 라이트하게 쓰인다.
				//집에서는 LOOPBACK(127.0.0.1)주소와 XE를 입력해주면 연결해 줄 수 있다.

				String user = "suzi";
				String pwd = "a123";
				
				//연결할 계정의 아이디와 패스워드.

				Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 오라클클래스를 읽어 와라.
				//Class 클래스는 클래스 파일의 위치나 이름만 있으면 해당 클래스의 정보를 얻어내고 객체를 생성하는것 또한 가능하게 한다.
				
				
				//syntax =Class.forName("패키지 전체 경로") 또는 클래스이름.class;
                

				dbConn = DriverManager.getConnection(url, user, pwd);
				//이 3가지 정보로 오라클을 읽어온다.
				
				//dbConn= DriverManager.getConnection("oracle.jdbc.driver.OracleDriver" , user, pwd); --> 이녀석도 가능


			} catch (Exception e) {

				System.out.println(e.toString());

			}
		}

		return dbConn;

	}
	
	//db를 하나 더 만들 수 있다.
	public static void close(){

		if(dbConn!=null){

			try {


				if(!dbConn.isClosed())//dbConn이 닫혀있지 않으면 닫아라.
					dbConn.close();


			} catch (Exception e) {

				System.out.println(e.toString());
			}

		}
		dbConn = null;//db를 연결하고 stream에 쓰레기 값이 남을 수 있기 때문에 치워줘야 한다.
	}




}
