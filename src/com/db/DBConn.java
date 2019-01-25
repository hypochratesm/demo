package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	private static Connection dbConn;//�������̽��� Ŭ������ �ʱⰪ�� �׻� null�̴�.

	public static Connection getConnection(){

		if(dbConn==null){//�ڹٿ����� null�� ����ִٶ�� �� . �����Ͱ� ���� ��¶�
			             //dbConn��  �����Ͱ� ������ ä���־�� �Ѵ�. 
			            

			try {//����ó���� �Ҷ� ���� try-catch��.

				String url ="jdbc:oracle:thin:@192.168.16.20:1521:TestDB";
				//���Ͻĺ��� �ؼ� jdbc�� �����ϱ����� ����Ŭ ���� thin����̹��� ����� @���� �����ǿ� ��ġ�� TestDB���� �����͸� �����´�.
				//URL -���Ͻĺ��ڴ� ��Ʈ��ũ �󿡼� �ڿ��� ��� �ִ����� �˷��ֱ� ���� �Ծ�.
			    //(UNIFORM RESOURCE LOCATOR)



				//���̷�Ʈ�� db�� �����ϸ鼭 ���� ����Ʈ�ϰ� ���δ�.
				//�������� LOOPBACK(127.0.0.1)�ּҿ� XE�� �Է����ָ� ������ �� �� �ִ�.

				String user = "suzi";
				String pwd = "a123";
				
				//������ ������ ���̵�� �н�����.

				Class.forName("oracle.jdbc.driver.OracleDriver"); //����Ŭ ����̹� ����ŬŬ������ �о� �Ͷ�.
				//Class Ŭ������ Ŭ���� ������ ��ġ�� �̸��� ������ �ش� Ŭ������ ������ ���� ��ü�� �����ϴ°� ���� �����ϰ� �Ѵ�.
				
				
				//syntax =Class.forName("��Ű�� ��ü ���") �Ǵ� Ŭ�����̸�.class;
                

				dbConn = DriverManager.getConnection(url, user, pwd);
				//�� 3���� ������ ����Ŭ�� �о�´�.
				
				//dbConn= DriverManager.getConnection("oracle.jdbc.driver.OracleDriver" , user, pwd); --> �̳༮�� ����


			} catch (Exception e) {

				System.out.println(e.toString());

			}
		}

		return dbConn;

	}
	
	//db�� �ϳ� �� ���� �� �ִ�.
	public static void close(){

		if(dbConn!=null){

			try {


				if(!dbConn.isClosed())//dbConn�� �������� ������ �ݾƶ�.
					dbConn.close();


			} catch (Exception e) {

				System.out.println(e.toString());
			}

		}
		dbConn = null;//db�� �����ϰ� stream�� ������ ���� ���� �� �ֱ� ������ ġ����� �Ѵ�.
	}




}
