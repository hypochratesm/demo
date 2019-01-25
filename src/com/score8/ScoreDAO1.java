package com.score8;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO1 {//Data Access Object(sql문을 실행하는 클래스)

	//CallabelStatement(프로시져를 사용할 때 쓰는 statement)


	//1.입력
	public int insertData(ScoreDTO dto){//입력된 데이터를 getter로 풀어 헤쳐야 한다.

		int result = 0;


		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//준비된 문장
		String sql;



		try {

			sql="{call insertScore(?,?,?,?,?)}";
			
			


			cstmt = conn.prepareCall(sql);//이 친구는 confirm한 insert문을 pstmt에다가 넣어준다. 미리 준비하기 때문에 statement와는 다르다.
			cstmt.setString(1, dto.getHak());
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());

			result = cstmt.executeUpdate();//sql은 위의 pstmt에서 이미 담겨있기 떄문에 여기선 담지 않아도 된다.

			cstmt.close();



		} catch (Exception e) {
			System.out.println(e.toString());
		}


		return result;

	}

	//2.수정

	public int updateData(ScoreDTO dto){


		int result = 0;


		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//준비된 문장
		String sql;

		try {


			sql = "{call updateScore(?,?,?,?)}";
			
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			

			result = cstmt.executeUpdate();//sql은 위의 pstmt에서 이미 담겨있기 떄문에 여기선 담지 않아도 된다.
			//excuteUpdate는 반환되지 않아도 되는 

			cstmt.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}


		return result;


	}
	//3.삭제
	public int deleteData(String hak){

		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt =null;
		String sql;

		try {

			sql= "delete score where hak=?";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, hak);
			result = cstmt.executeUpdate();
			cstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	//전체선택
	public List<ScoreDTO> getLists(){

		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;


		try {

			sql = "{call selectAllScore(?)}";

			cstmt =conn.prepareCall(sql);
            
			//out 파라미터 자료형 설정
			//cstmt.registerOutParameter(1,OracleType.CURSOR);//자동으로 임포트 되지 않기 때문에 반드시 수동으로 임포트 해줘야만 한다.
			
			//프로시져 실행
			cstmt.executeUpdate();
			
			//out파라미터의 값을 돌려받음
            rs= (ResultSet)cstmt.getObject(1);//resultset형태로 다운캐스트
	
			while(rs.next()){

				ScoreDTO dto = new ScoreDTO();

				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				dto.setRank(rs.getInt("rank"));

				lists.add(dto);//while문이 돌면 dto가 리스트에 축적되게 된다.

			}
			
			cstmt.close();
			rs.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}
	//5.학번검색
	public ScoreDTO getList(String hak){
		
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto  = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			sql ="{call selectHakScore(?,?)}";//첫번째 물어보는 커서,두번째는 hak
			
		
			
			cstmt=conn.prepareCall(sql);
			
			//out파라미터 자료형 설정
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in파라미터
			cstmt.setString(2, hak);
			
			//프로시져 실행
			cstmt.executeQuery();
			
			//out파라미터의 값을 돌려받음
			
			rs=(ResultSet)cstmt.getObject(1);
			
			
			if(rs.next()){
				
				dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
			
			}
			rs.close();
			cstmt.close();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		 return dto;//이 안에서 if문을 건너뛰면 dto를 정의할 수 없는 문제가 발생 한다.

	}
  
}
