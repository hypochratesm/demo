package com.jdbc;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		

		Connection conn = DBConn.getConnection(); //conn�ȿ� ���𰡰� ���Դ�.//hashcode�� ���´�.

		if(conn==null){

			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		System.out.println("�����ͺ��̽� ���� ����!!");
		DBConn.close();//db.conn�� ����ȴ�.
        System.out.println(conn);

	}

}
