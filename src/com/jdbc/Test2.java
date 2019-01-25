package com.jdbc;


import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test2 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();//com.db.DBConn에 들어있는 계정의 정보를 conn이란 객체에 담는다.
		
		if(conn==null){//conn이란 객체에 데이터가 담기지 않아서 null이 된다면
			System.out.println("데이터베이스 연결 실패!!");//데이터 연결은 실패했다.
		    System.exit(0);	//
		}
		
         //DB연결
		//1.DriverManager가 Connection을 생성
		//2.Connection이 statement를 생성
		//3.statement가 query를 실행
		
		try {
			
			//2.Connection이 Statement를 생성
			//SQL구문을 실행하는 인터페이스
			
		   Statement stmt = conn.createStatement();//connection conn이 새로운 Statement를 만들고 이 정보는
		                                           //stmt에 저장된다.
		   String sql;
		   
		   
		   //실행되는 쿼리문들.
//		   sql ="insert into score (hak,name,kor,eng,mat) "; //반드시 따옴표 앞에 한칸을 띄어주어야 한다.
//		   sql+="values('222','김수지',90,50,60)";
		   
//		   sql = "update score set kor=99,eng=99,mat=99 ";
//		   sql+="where hak=111";
//		   
		   
		   sql = "delete score where hak=111";
		   
	
		   
		   int result = stmt.executeUpdate(sql);//위에 입력된 쿼리를 실행하고 그 값을 리설트에 담아라 
		
		   if(result==1)
			   System.out.println("추가 성공!!"); //result =1이면 참이고 sql문을 실행하는데 성공했다.
		                                          //result =0이면 거짓이고 sql문을 실행하는데 실패했다.
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		DBConn.close();//db는 실행해주면 반드시 닫아주어야 한다.
		
	}

}
