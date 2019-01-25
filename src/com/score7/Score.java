package com.score7;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;
import com.naver.NaverVO;

public class Score {

	String id,pwd;
	String name,birth,memo;
	
	Scanner sc = new Scanner(System.in);

	//1.ȸ������
	public int insertData(){

		int result =0;
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
        boolean flag;
		
		
		try {
		
			do{
				
				flag=false;
				
				System.out.println("���̵�?");
				id = sc.next();
				
				sql = "select id ";
				sql+= "from member where id= '" + id +"'";
				
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
				
				if(result==1){
					
					System.out.println("��");
					
				}else{
					
					flag = true;
				}
				
				
			}while(flag==false);
			
			

			
		
			
			System.out.println("��й�ȣ?");
			pwd = sc.next();

			System.out.println("�̸�?");
			name =sc.next();

			System.out.println("����?");
			birth =sc.next();

			System.out.println("�޸�?");
			memo = sc.next();

			sql = "insert into member(id,pwd,name,birth,memo) values(";
			sql+= "'"+ id + "',";
			sql+= "'"+ pwd + "',";
			sql+= "'"+ name + "',";
			sql+= "'"+ birth + "',";
			sql+= "'"+ memo +"'"+")";
            
			System.out.println(sql);
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

			System.out.println("���̵�?");
			id = sc. next();

			System.out.println("��й�ȣ?");
			pwd = sc.next();

			System.out.println("�̸�?");
			name =sc.next();

			System.out.println("����?");
			birth =sc.next();

			System.out.println("�޸�?");
			memo = sc.next();

			sql ="update member set ";
			sql+="pwd='" + pwd + "',";
			sql+="birth='" + birth + "',";
			sql+="memo='" + memo+"'";
			sql+=" where id='" + id + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("�����Ϸ�!!");
			
			stmt.close();


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

			System.out.println("Ż���� ���̵�?");
			id = sc.next();

			sql = " delete member where id='" + id + "'";

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

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
			sql = "select id,pwd,name,to_char(birth,'YYYY-MM-DD') birth ,memo ";
			sql+="from member order by id";

			stmt = conn.createStatement();

			rs= stmt.executeQuery(sql);

			while(rs.next()){

				id = rs.getString("id"); //�й��� ù��° �÷��� �ִ�.
				pwd = rs.getString("pwd");
				name = rs.getString("name");
				birth = rs.getString("birth");
				memo= rs.getString("memo");

				str =String.format("10%s 10%s 5%s 5%s 5%s", id,pwd,name,birth,memo );

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
		String searchId;


		try {

			System.out.println("ã�� ���̵�?");
			searchId=sc.next();

			sql = "select *";
			sql+="from member where id like'%";
			sql+= searchId +"%' order by id";


			stmt = conn.createStatement();

			rs= stmt.executeQuery(sql);




			while(rs.next()){

				id = rs.getString(1); //�й��� ù��° �÷��� �ִ�.
				pwd = rs.getString("pwd");
				name = rs.getString(3);
				birth = rs.getString(4);
				memo = rs.getString(5);


				str =String.format("10%s 10%s 10%s 10%s 10%s", id,pwd,name,birth,memo);

			}
			rs.close();
			stmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}






	}

}
