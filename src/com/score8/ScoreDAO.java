package com.score8;



import java.sql.Connection;
import java.sql.PreparedStatement;




import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO {//Data Access Object(sql문을 실행하는 클래스)

	//scorDTO의 객체를 생성해서 이 DTO에 있는 SETTER에다가 데이터를 입력 해주어야 한다.


	//1.입력
	public int insertData(ScoreDTO dto){//입력된 데이터를 getter로 풀어 헤쳐야 한다.

		int result = 0;


		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//준비된 문장
		String sql;



		try {

			sql="insert into score (hak,name,kor,eng,mat)";
			sql+="values(?,?,?,?,?)";//데이터가 들어갈 자리를 물음표로만 표시한다.


			pstmt = conn.prepareStatement(sql);//이 친구는 confirm한 insert문을 pstmt에다가 넣어준다. 미리 준비하기 때문에 statement와는 다르다.
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());

			result = pstmt.executeUpdate();//sql은 위의 pstmt에서 이미 담겨있기 떄문에 여기선 담지 않아도 된다.

			pstmt.close();



		} catch (Exception e) {
			System.out.println(e.toString());
		}


		return result;

	}

	//2.수정

	public int updateData(ScoreDTO dto){


		int result = 0;


		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//준비된 문장
		String sql;

		try {


			sql="update score set kor=?,eng=?,mat=? ";
			sql+="where hak=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());

			result = pstmt.executeUpdate();//sql은 위의 pstmt에서 이미 담겨있기 떄문에 여기선 담지 않아도 된다.
			//excuteUpdate는 반환되지 않아도 되는 

			pstmt.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}


		return result;


	}
	//3.삭제
	public int deleteData(String hak){

		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt =null; 
		String sql;

		try {

			sql= "delete score where hak=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hak);
			result = pstmt.executeUpdate();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	//전체선택
	public List<ScoreDTO> getLists(){

		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;


		try {

			sql = "select hak,name,kor,eng,mat,";
			sql+= "(kor+eng+mat) tot, (kor+eng+mat)/3 ave,";
			sql+= "rank() over(order by (kor+eng+mat) desc) rank ";
			sql+= "from score ";

			pstmt =conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

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
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}
	//5.학번검색
	public ScoreDTO getList(String hak){
		
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			sql ="select,hak,name,kor,eng,mat,";
			sql+="(kor+eng+mat) tot,(kor+eng+mat)/3 ave ";
			sql+="from score where hak=?";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, hak);
			
			rs=pstmt.executeQuery();
			
			
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
			pstmt.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 return dto;//이 안에서 if문을 건너뛰면 dto를 정의할 수 없는 문제가 발생 한다.

	}
  
}
