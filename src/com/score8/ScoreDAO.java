package com.score8;



import java.sql.Connection;
import java.sql.PreparedStatement;




import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO {//Data Access Object(sql���� �����ϴ� Ŭ����)

	//scorDTO�� ��ü�� �����ؼ� �� DTO�� �ִ� SETTER���ٰ� �����͸� �Է� ���־�� �Ѵ�.


	//1.�Է�
	public int insertData(ScoreDTO dto){//�Էµ� �����͸� getter�� Ǯ�� ���ľ� �Ѵ�.

		int result = 0;


		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//�غ�� ����
		String sql;



		try {

			sql="insert into score (hak,name,kor,eng,mat)";
			sql+="values(?,?,?,?,?)";//�����Ͱ� �� �ڸ��� ����ǥ�θ� ǥ���Ѵ�.


			pstmt = conn.prepareStatement(sql);//�� ģ���� confirm�� insert���� pstmt���ٰ� �־��ش�. �̸� �غ��ϱ� ������ statement�ʹ� �ٸ���.
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());

			result = pstmt.executeUpdate();//sql�� ���� pstmt���� �̹� ����ֱ� ������ ���⼱ ���� �ʾƵ� �ȴ�.

			pstmt.close();



		} catch (Exception e) {
			System.out.println(e.toString());
		}


		return result;

	}

	//2.����

	public int updateData(ScoreDTO dto){


		int result = 0;


		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//�غ�� ����
		String sql;

		try {


			sql="update score set kor=?,eng=?,mat=? ";
			sql+="where hak=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());

			result = pstmt.executeUpdate();//sql�� ���� pstmt���� �̹� ����ֱ� ������ ���⼱ ���� �ʾƵ� �ȴ�.
			//excuteUpdate�� ��ȯ���� �ʾƵ� �Ǵ� 

			pstmt.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}


		return result;


	}
	//3.����
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
	//��ü����
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

				lists.add(dto);//while���� ���� dto�� ����Ʈ�� �����ǰ� �ȴ�.

			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}
	//5.�й��˻�
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
		
		 return dto;//�� �ȿ��� if���� �ǳʶٸ� dto�� ������ �� ���� ������ �߻� �Ѵ�.

	}
  
}
