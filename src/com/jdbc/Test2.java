package com.jdbc;


import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test2 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();//com.db.DBConn�� ����ִ� ������ ������ conn�̶� ��ü�� ��´�.
		
		if(conn==null){//conn�̶� ��ü�� �����Ͱ� ����� �ʾƼ� null�� �ȴٸ�
			System.out.println("�����ͺ��̽� ���� ����!!");//������ ������ �����ߴ�.
		    System.exit(0);	//
		}
		
         //DB����
		//1.DriverManager�� Connection�� ����
		//2.Connection�� statement�� ����
		//3.statement�� query�� ����
		
		try {
			
			//2.Connection�� Statement�� ����
			//SQL������ �����ϴ� �������̽�
			
		   Statement stmt = conn.createStatement();//connection conn�� ���ο� Statement�� ����� �� ������
		                                           //stmt�� ����ȴ�.
		   String sql;
		   
		   
		   //����Ǵ� ��������.
//		   sql ="insert into score (hak,name,kor,eng,mat) "; //�ݵ�� ����ǥ �տ� ��ĭ�� ����־�� �Ѵ�.
//		   sql+="values('222','�����',90,50,60)";
		   
//		   sql = "update score set kor=99,eng=99,mat=99 ";
//		   sql+="where hak=111";
//		   
		   
		   sql = "delete score where hak=111";
		   
	
		   
		   int result = stmt.executeUpdate(sql);//���� �Էµ� ������ �����ϰ� �� ���� ����Ʈ�� ��ƶ� 
		
		   if(result==1)
			   System.out.println("�߰� ����!!"); //result =1�̸� ���̰� sql���� �����ϴµ� �����ߴ�.
		                                          //result =0�̸� �����̰� sql���� �����ϴµ� �����ߴ�.
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		DBConn.close();//db�� �������ָ� �ݵ�� �ݾ��־�� �Ѵ�.
		
	}

}
