package com.score8;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO1 {//Data Access Object(sql���� �����ϴ� Ŭ����)

	//CallabelStatement(���ν����� ����� �� ���� statement)


	//1.�Է�
	public int insertData(ScoreDTO dto){//�Էµ� �����͸� getter�� Ǯ�� ���ľ� �Ѵ�.

		int result = 0;


		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//�غ�� ����
		String sql;



		try {

			sql="{call insertScore(?,?,?,?,?)}";
			
			


			cstmt = conn.prepareCall(sql);//�� ģ���� confirm�� insert���� pstmt���ٰ� �־��ش�. �̸� �غ��ϱ� ������ statement�ʹ� �ٸ���.
			cstmt.setString(1, dto.getHak());
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());

			result = cstmt.executeUpdate();//sql�� ���� pstmt���� �̹� ����ֱ� ������ ���⼱ ���� �ʾƵ� �ȴ�.

			cstmt.close();



		} catch (Exception e) {
			System.out.println(e.toString());
		}


		return result;

	}

	//2.����

	public int updateData(ScoreDTO dto){


		int result = 0;


		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//�غ�� ����
		String sql;

		try {


			sql = "{call updateScore(?,?,?,?)}";
			
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			

			result = cstmt.executeUpdate();//sql�� ���� pstmt���� �̹� ����ֱ� ������ ���⼱ ���� �ʾƵ� �ȴ�.
			//excuteUpdate�� ��ȯ���� �ʾƵ� �Ǵ� 

			cstmt.close();


		} catch (Exception e) {

			System.out.println(e.toString());
		}


		return result;


	}
	//3.����
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
	//��ü����
	public List<ScoreDTO> getLists(){

		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;


		try {

			sql = "{call selectAllScore(?)}";

			cstmt =conn.prepareCall(sql);
            
			//out �Ķ���� �ڷ��� ����
			//cstmt.registerOutParameter(1,OracleType.CURSOR);//�ڵ����� ����Ʈ ���� �ʱ� ������ �ݵ�� �������� ����Ʈ ����߸� �Ѵ�.
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out�Ķ������ ���� ��������
            rs= (ResultSet)cstmt.getObject(1);//resultset���·� �ٿ�ĳ��Ʈ
	
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
			
			cstmt.close();
			rs.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}
	//5.�й��˻�
	public ScoreDTO getList(String hak){
		
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto  = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			sql ="{call selectHakScore(?,?)}";//ù��° ����� Ŀ��,�ι�°�� hak
			
		
			
			cstmt=conn.prepareCall(sql);
			
			//out�Ķ���� �ڷ��� ����
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in�Ķ����
			cstmt.setString(2, hak);
			
			//���ν��� ����
			cstmt.executeQuery();
			
			//out�Ķ������ ���� ��������
			
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
		
		 return dto;//�� �ȿ��� if���� �ǳʶٸ� dto�� ������ �� ���� ������ �߻� �Ѵ�.

	}
  
}
