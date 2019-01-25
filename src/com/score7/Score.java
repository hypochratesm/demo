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

	//1.회원가입
	public int insertData(){

		int result =0;
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
        boolean flag;
		
		
		try {
		
			do{
				
				flag=false;
				
				System.out.println("아이디?");
				id = sc.next();
				
				sql = "select id ";
				sql+= "from member where id= '" + id +"'";
				
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
				
				if(result==1){
					
					System.out.println("떙");
					
				}else{
					
					flag = true;
				}
				
				
			}while(flag==false);
			
			

			
		
			
			System.out.println("비밀번호?");
			pwd = sc.next();

			System.out.println("이름?");
			name =sc.next();

			System.out.println("생일?");
			birth =sc.next();

			System.out.println("메모?");
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

			System.out.println("아이디?");
			id = sc. next();

			System.out.println("비밀번호?");
			pwd = sc.next();

			System.out.println("이름?");
			name =sc.next();

			System.out.println("생일?");
			birth =sc.next();

			System.out.println("메모?");
			memo = sc.next();

			sql ="update member set ";
			sql+="pwd='" + pwd + "',";
			sql+="birth='" + birth + "',";
			sql+="memo='" + memo+"'";
			sql+=" where id='" + id + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("수정완료!!");
			
			stmt.close();


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

			System.out.println("탈퇴할 아이디?");
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

	//전체
	public void selectAll(){ // select문은 자료형 선언이 필요없다.--> 반환값이 테이블이기 때문에.

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

				id = rs.getString("id"); //학번은 첫번째 컬럼에 있다.
				pwd = rs.getString("pwd");
				name = rs.getString("name");
				birth = rs.getString("birth");
				memo= rs.getString("memo");

				str =String.format("10%s 10%s 5%s 5%s 5%s", id,pwd,name,birth,memo );

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
		String searchId;


		try {

			System.out.println("찾을 아이디?");
			searchId=sc.next();

			sql = "select *";
			sql+="from member where id like'%";
			sql+= searchId +"%' order by id";


			stmt = conn.createStatement();

			rs= stmt.executeQuery(sql);




			while(rs.next()){

				id = rs.getString(1); //학번은 첫번째 컬럼에 있다.
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
