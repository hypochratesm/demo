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

	//1.입력
	public int insertData(){

		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;

		try {
			System.out.println("학번?");
			hak = sc. next();

			System.out.println("이름?");
			name= sc.next();

			System.out.println("국어?");
			kor = sc.nextInt();

			System.out.println("영어?");
			eng = sc.nextInt();

			System.out.println("수학?");
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

			System.out.println("데이터 입력 성공!!");



		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//2.수정
	public int updateData(){
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
	    String sql;
		
		try {
			
			System.out.println("학번?");
			hak = sc. next();

	
			System.out.println("국어?");
			kor = sc.nextInt();

			System.out.println("영어?");
			eng = sc.nextInt();

			System.out.println("수학?");
			mat = sc.nextInt();
			
			sql = "update score set";
			sql+="kor=" + kor + ",";
			sql+="eng=" + eng + ",";
			sql+="mat=" + mat;
			sql+=" where hak='" + hak + "'";
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("수정완료!!");

			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//3.삭제
	public int deleteData(){
		
		int result=0;
		
		Connection conn =DBConn.getConnection();
		Statement stmt = null;
		String sql;
		
		try {
			
			System.out.println("삭제할 학번?");
			hak = sc.next();
			
			sql = " delete score where hak='" + hak + "'";
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);//이 메소드는 0 또는 1을 반환한다.
			
			stmt.close();
			
			
			
		} catch (Exception e) {
		
			System.out.println(e.toString());
			
		}
		return result;
		
		
	}
	
	//전체
	public void selectAll(){ // select문은 자료형 선언이 필요없다.--> 반환값이 테이블이기 때문에.
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
		ResultSet rs= null;
		String str;
		
		try {
			sql = "select hak,name,kor,eng,mat,";//*표 사용금지.
			sql+= "(kor+eng+mat) tot,";
			sql+="(kor+eng+mat)/3 ave ";
			sql+="from score order by hak";
			
			stmt = conn.createStatement();
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()){
				
				hak = rs.getString("hak"); //학번은 첫번째 컬럼에 있다.//일반적으론 이름을 많이 쓴다.숫자쓰면 안댐
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				int ave = rs.getInt(7); 
				
				str =String.format("10%s 10%s %4d %4d %4d %4d %4d", hak,name,kor,eng,mat,tot,ave );
				
				System.out.println(str);
				//코딩할떄에는 명시해줄 것을 다 명시 해주어야 한다.
				
			}
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
		System.out.println(e.toString());
		}
	
		
	}
	
	//5.이름검색
	public void searchData(){
		
	Connection conn = DBConn.getConnection();
	Statement stmt =null;
	String sql;
	String name;
	ResultSet rs =null;
	String str;
	String searchName;
	
	
	try {
		
		System.out.println("찾을 이름?");
		searchName=sc.next();
		
		sql = "select hak,name,kor,eng,mat,";
		sql+= "(kor+eng+mat)tot,";
		sql+="(kor+eng+mat)/3 ave ";
		sql+="from score where name like'%";
		sql+= searchName +"%' order by hak";
		
		
		stmt = conn.createStatement();
		
		rs= stmt.executeQuery(sql);
		
		
		
		
		while(rs.next()){
			
			hak = rs.getString(1); //학번은 첫번째 컬럼에 있다.
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
