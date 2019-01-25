package com.jdbc;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		

		Connection conn = DBConn.getConnection(); //conn안에 무언가가 들어왔다.//hashcode가 나온다.

		if(conn==null){

			System.out.println("데이터베이스 연결 실패!!");
			System.exit(0);
		}
		System.out.println("데이터베이스 연결 성공!!");
		DBConn.close();//db.conn이 종료된다.
        System.out.println(conn);

	}

}
