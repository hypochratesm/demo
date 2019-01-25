package com.score6;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class Score {

	String hak,name;
	int kor,eng,mat;

	Scanner sc = new Scanner(System.in);

	//1.�Է�
	public int insertData(){

		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;

		try {
			System.out.println("�й�?");
			hak = sc. next();

			System.out.println("�̸�?");
			name= sc.next();

			System.out.println("����?");
			kor = sc.nextInt();

			System.out.println("����?");
			eng = sc.nextInt();

			System.out.println("����?");
			mat = sc.nextInt();

			sql = "insert into score(hak,name,kor,eng,mat) values(";
			sql+= "'"+ hak + "',";
			sql+= "'"+ name + "',";
			sql+= kor + ",";
			sql+= eng + ",";
			sql+= mat + ")";

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);
			
			stmt.close();

			System.out.println("������ �Է� ����!!");



		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//2.����
	public int updateData(){
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
	    String sql;
		
		try {
			
			System.out.println("�й�?");
			hak = sc. next();

	
			System.out.println("����?");
			kor = sc.nextInt();

			System.out.println("����?");
			eng = sc.nextInt();

			System.out.println("����?");
			mat = sc.nextInt();
			
			sql = "update score set";
			sql+="kor=" + kor + ",";
			sql+="eng=" + eng + ",";
			sql+="mat=" + mat;
			sql+=" where hak='" + hak + "'";
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("�����Ϸ�!!");

			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//3.����
	public int deleteData(){
		
		int result=0;
		
		Connection conn =DBConn.getConnection();
		Statement stmt = null;
		String sql;
		
		try {
			
			System.out.println("������ �й�?");
			hak = sc.next();
			
			sql = " delete score where hak='" + hak + "'";
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);//�� �޼ҵ�� 0 �Ǵ� 1�� ��ȯ�Ѵ�.
			
			stmt.close();
			
			
			
		} catch (Exception e) {
		
			System.out.println(e.toString());
			
		}
		return result;
		
		
	}
	
	//��ü
	public void selectAll(){ // select���� �ڷ��� ������ �ʿ����.--> ��ȯ���� ���̺��̱� ������.
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
		ResultSet rs= null;
		String str;
		
		try {
			sql = "select hak,name,kor,eng,mat,";//*ǥ ������.
			sql+= "(kor+eng+mat) tot,";
			sql+="(kor+eng+mat)/3 ave ";
			sql+="from score order by hak";
			
			stmt = conn.createStatement();
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()){
				
				hak = rs.getString("hak"); //�й��� ù��° �÷��� �ִ�.//�Ϲ������� �̸��� ���� ����.���ھ��� �ȴ�
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				int ave = rs.getInt(7); 
				
				str =String.format("10%s 10%s %4d %4d %4d %4d %4d", hak,name,kor,eng,mat,tot,ave );
				
				System.out.println(str);
				//�ڵ��ҋ����� ������� ���� �� ��� ���־�� �Ѵ�.
				
			}
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
		System.out.println(e.toString());
		}
	
		
	}
	
	//5.�̸��˻�
	public void searchData(){
		
	Connection conn = DBConn.getConnection();
	Statement stmt =null;
	String sql;
	String name;
	ResultSet rs =null;
	String str;
	String searchName;
	
	
	try {
		
		System.out.println("ã�� �̸�?");
		searchName=sc.next();
		
		sql = "select hak,name,kor,eng,mat,";
		sql+= "(kor+eng+mat)tot,";
		sql+="(kor+eng+mat)/3 ave ";
		sql+="from score where name like'%";
		sql+= searchName +"%' order by hak";
		
		
		stmt = conn.createStatement();
		
		rs= stmt.executeQuery(sql);
		
		
		
		
		while(rs.next()){
			
			hak = rs.getString(1); //�й��� ù��° �÷��� �ִ�.
			name = rs.getString("name");
			kor = rs.getInt(3);
			eng = rs.getInt("eng");
			mat = rs.getInt(5);
			int tot = rs.getInt("tot");
			int ave = rs.getInt(7); 
			
			str =String.format("10%s 10%s %4d %4d %4d %4d %4d", hak,name,kor,eng,mat,tot,ave );
		
		}
		rs.close();
		stmt.close();
		
		
	} catch (Exception e) {
		System.out.println(e.toString());
	}
	
	 
		
		
		
	
	}
	
}
