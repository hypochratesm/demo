package com.prj2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RentDAO {//Data Access Object(SQL)-DB를 Access하는 파트

	private static final String code = "BK";


	//RESCAR 테이블에서 예약날짜(STARTDAY,ENDDAY),차번호(CARNUM)을 불러와 daysLists에 넣음.
	//daysList를 리턴함
	public List<CustomDTO> searchResDate(){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 	//PreparedStatement 
		ResultSet rs = null;

		List<CustomDTO> daysLists = new ArrayList<CustomDTO>();
		String sql;


		try {

			sql = "SELECT CARNUM,TO_CHAR(STARTDAY,'YYYY-MM-DD') sday,TO_CHAR(ENDDAY,'YYYY-MM-DD') eday FROM RESCAR";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();


			while(rs.next()){

				CustomDTO cusDTO2 = new CustomDTO();
				cusDTO2.setCarNum(rs.getString("carNum"));
				cusDTO2.setStartday(rs.getString("sday"));
				cusDTO2.setEndday(rs.getString("eday"));

				daysLists.add(cusDTO2);				
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return daysLists;

	}

	//예약이 불가능한 차량 리스트를 매개변수로 받음
	//예약이 가능한 차량 정보를 DB에서 검색해서 printLists에 넣음.
	//printList 리턴함
	public List<CarDTO> getPrintList(List<CustomDTO> cusDTO){

		List<CustomDTO> okRes = new ArrayList<CustomDTO>();	
		Connection conn = JejuConn.getConnection();
		Statement stmt = null;
		//PreparedStatement pstmt = null; 	//PreparedStatement 
		ResultSet rs = null;
		String sql;
		String str = "";

		okRes = cusDTO;
		System.out.println(okRes.size());


		if(okRes.size()==0) {

			return null;
		}

		List<String> confirmRes = new ArrayList<String>();
		List<CarDTO> printLists = new ArrayList<CarDTO>();

		try {


			Iterator<CustomDTO> tempIt = okRes.iterator();

			while(tempIt.hasNext()) {

				CustomDTO tempDTO = tempIt.next();

				String tempCarNum = tempDTO.getCarNum();

				if(!confirmRes.contains(tempCarNum)) {

					confirmRes.add(tempCarNum);
				}

			}


			Iterator<String> strIt = confirmRes.iterator();

			while(strIt.hasNext()) {
				str += "'"+strIt.next()+"',";

			}

			if(str.equals("'',")){

				return null;

			}

			String que = str.substring(0,str.lastIndexOf(","));

			sql = "SELECT CARNUM,MANU,MODEL,TYPE,COLOR,SEAT,FUEL,PRICE FROM CARINFO WHERE CARNUM NOT IN("+que;
			sql+=") ORDER BY MODEL";				

			stmt = conn.prepareStatement(sql);
			//pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1,str.substring(0,str.lastIndexOf(",")));

			rs = stmt.executeQuery(sql);
			while(rs.next()){

				CarDTO carDTO = new CarDTO();
				carDTO.setCarNum(rs.getString("carnum"));
				carDTO.setManu(rs.getString("manu"));
				carDTO.setModel(rs.getString("model"));
				carDTO.setType(rs.getString("type"));
				carDTO.setColor(rs.getString("color"));
				carDTO.setSeat(rs.getString("seat"));
				carDTO.setFuel(rs.getString("fuel"));
				carDTO.setPrice(rs.getInt("price"));

				printLists.add(carDTO);
			}			


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return printLists;

	}
	//차량정보 전체출력
	public List<CarDTO> carPrint() {



		List<CarDTO> lst = new ArrayList<CarDTO>();

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select carnum,manu,model,type,color,seat,fuel,price from carinfo order by model";


			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){


				CarDTO carDTO = new CarDTO();

				carDTO.setCarNum(rs.getString("carnum"));
				carDTO.setManu(rs.getString("manu"));
				carDTO.setModel(rs.getString("model"));
				carDTO.setType(rs.getString("type"));
				carDTO.setColor(rs.getString("color"));
				carDTO.setSeat(rs.getString("seat"));
				carDTO.setFuel(rs.getString("fuel"));
				carDTO.setPrice(rs.getInt("price"));


				lst.add(carDTO);

			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}	
		
		return lst;

	}

	//차번호(CARNUM)을 매개변수로 받아 해당 차량의 모델 반환
	public String getCarModel(String num){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 	//PreparedStatement 
		ResultSet rs = null;
		String sql; 
		String model = null;

		try {
			sql = "SELECT MODEL FROM CARINFO WHERE CARNUM=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,num);

			rs = pstmt.executeQuery();

			while(rs.next()){
				model = rs.getString("model");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	

		return model;

	}

	//대여 기간(일)을 매개변수로 받아 총 대여비용(TOTPRICE) 반환
	//대여금액 조회는 차번호를 조건으로 사용함
	public int getTotPrice(String carNum, int dif){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;  
		ResultSet rs = null;
		String sql; 
		int totPrice = 0;

		try {

			sql = "SELECT (PRICE*?) TOTPRICE FROM CARINFO WHERE CARNUM=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dif);
			pstmt.setString(2, carNum);

			rs = pstmt.executeQuery();

			while(rs.next()){

				totPrice = rs.getInt("TOTPRICE");

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return totPrice;

	}
	
	//전화번호 중복 체크
	public boolean checkTel(String tel){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 	
		ResultSet rs = null;
		String sql; 
		boolean flag = false;

		try {

			sql = "SELECT RESNO,TEL FROM CUSTOMER WHERE TEL=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tel);

			rs = pstmt.executeQuery();

			while(rs.next()){

				String checktel = rs.getString("tel");

				if(tel.equals(checktel)){
					flag = true;
					break;
				}
				else if(checktel==null) {
					flag = false;
					break;
				}
			}	

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return flag;

	}

	//차번호를 매개변수로 받아 차량의 정보 반환
	public String printSelectCar(String carNum){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 	
		ResultSet rs = null;

		CarDTO carDTO = new CarDTO();
		String sql;

		try {

			sql = "SELECT CARNUM,MANU,MODEL,TYPE,COLOR,SEAT,FUEL FROM CARINFO WHERE CARNUM=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, carNum);

			rs = pstmt.executeQuery();

			while(rs.next()){

				carDTO.setCarNum(rs.getString("carnum"));
				carDTO.setManu(rs.getString("manu"));
				carDTO.setModel(rs.getString("model"));
				carDTO.setType(rs.getString("type"));
				carDTO.setColor(rs.getString("color"));
				carDTO.setSeat(rs.getString("seat"));
				carDTO.setFuel(rs.getString("fuel"));

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return String.format("%7s %8s %10s %5s %4s %6s %6s",carDTO.getCarNum(),carDTO.getManu(),carDTO.getModel(),carDTO.getType(),carDTO.getColor(),carDTO.getSeat(),carDTO.getFuel());


	}

	//예약자 정보를 Rescar에 insert
	public int insertRescar(CustomDTO cus, String bk){

		CustomDTO cusDTO = new CustomDTO();
		cusDTO = cus;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		int result = 0;
		String bkNum = bk;

		try {


			sql = "INSERT INTO RESCAR(RESNO,CARNUM,STARTDAY,ENDDAY,INSURE,TOTPRICE,STATUS) VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bkNum);
			pstmt.setString(2,cusDTO.getCarNum());
			pstmt.setString(3,cusDTO.getStartday());
			pstmt.setString(4,cusDTO.getEndday());
			pstmt.setString(5,cusDTO.getInsure());
			pstmt.setInt(6,cusDTO.getTotprice());
			pstmt.setString(7, "예약중");

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	
	//예약하기
	//Customer테이블 insert 
	public int insertCustomer(CustomDTO cus, String bk) {

		CustomDTO cusDTO = new CustomDTO();
		cusDTO = cus;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		int result = 0;
		String bkNum = bk;

		try {



			sql = "INSERT INTO CUSTOMER(RESNO,NAME,TEL,BIRTH,EMAIL) VALUES(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bkNum);
			pstmt.setString(2, cusDTO.getName());
			pstmt.setString(3, cusDTO.getTel());
			pstmt.setString(4, cusDTO.getBirth());
			pstmt.setString(5, cusDTO.getEmail());

			result = pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	//예약번호 생성하기
	public String createBookingNo(){

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql;
		int num = 0;

		try {

			sql = "SELECT MAX(RESNO) NUM FROM (SELECT TO_NUMBER(SUBSTR(RESNO,3,6)) RESNO FROM RESCAR UNION SELECT TO_NUMBER(SUBSTR(RESNO,3,6)) RESNO FROM RECORD)";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				num = rs.getInt("NUM");

				if(num==0){
					num = 1111;
				}
				else
					num = num+1;
			}


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return code + Integer.toString(num);
	}
	
	//모든 예약정보 조회
	public List<AllDTO> searchAllRes(){
		
		List<AllDTO> allList = new ArrayList<AllDTO>();
		
		Connection conn = JejuConn.getConnection();	
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			sql = "SELECT A.RESNO RESNO,CARNUM,MANU,MODEL,NAME,TEL,STARTDAY,ENDDAY,INSURE,TOTPRICE,STATUS ";
			sql += "FROM CUSTOMER A, (SELECT RESNO,A.CARNUM,TO_CHAR(STARTDAY,'YYYY-MM-DD') STARTDAY,TO_CHAR(ENDDAY,'YYYY-MM-DD') ENDDAY ,INSURE,TOTPRICE,MANU,MODEL,STATUS FROM RESCAR A, CARINFO B WHERE A.CARNUM=B.CARNUM) B ";
			sql += "WHERE A.RESNO=B.RESNO";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				AllDTO dto = new AllDTO();
				
				dto.setResno(rs.getString("RESNO"));
				dto.setCarNum(rs.getString("CARNUM"));
				dto.setManu(rs.getString("MANU"));
				dto.setModel(rs.getString("MODEL"));
				dto.setName(rs.getString("NAME"));
				dto.setTel(rs.getString("TEL"));
				dto.setStartDay(rs.getString("STARTDAY"));
				dto.setEndDay(rs.getString("ENDDAY"));
				dto.setInsure(rs.getString("INSURE"));
				dto.setTotPrice(rs.getInt("TOTPRICE"));
				dto.setStatus(rs.getString("STATUS"));	
				
				allList.add(dto);
				
			}

			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return allList;
		
	}
	
	//반납할 때 Record테이블에 insert하기 위한 데이터 가져오기
	public AllDTO getList(String resno){

		AllDTO allDTO = new AllDTO();	

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql;

		try {

			sql = "select a.resno resno,b.name name,b.tel tel,to_char(b.birth,'YY-MM-DD') birth,b.email email,";
			sql+= "carnum,to_char(startday,'YY-MM-DD') startday,to_char(endday,'YY-MM-DD') endday,insure,totprice,status ";
			sql+= "from rescar a,(select * from customer where resno=?) b where a.resno=b.resno and a.resno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resno);
			pstmt.setString(2, resno);
			rs=pstmt.executeQuery();

			while(rs.next()){
				allDTO.setResno(rs.getString("resno"));
				allDTO.setName(rs.getString("name"));
				allDTO.setTel(rs.getString("tel"));
				allDTO.setBirth(rs.getString("birth"));
				allDTO.setEmail(rs.getString("email"));
				allDTO.setCarNum(rs.getString("carnum"));
				allDTO.setStartDay(rs.getString("startday"));
				allDTO.setEndDay(rs.getString("endday"));
				allDTO.setInsure(rs.getString("insure"));
				allDTO.setTotPrice(rs.getInt("totprice"));
			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return allDTO;


	}
	
	//Record테이블에 데이터 insert
	public int insertData(AllDTO allDTO){

		int result = 0;
		
		AllDTO allDTO2 = new AllDTO();
		
		allDTO2=allDTO;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into record (resno,name,tel,birth,email,carnum,startday,endday,insure,totprice,status) ";
			sql+= "values (?,?,?,?,?,?,?,?,?,?,'반납')";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, allDTO2.getResno());
			pstmt.setString(2, allDTO2.getName());
			pstmt.setString(3, allDTO2.getTel());
			pstmt.setString(4, allDTO2.getBirth());
			pstmt.setString(5, allDTO2.getEmail());
			pstmt.setString(6, allDTO2.getCarNum());
			pstmt.setString(7, allDTO2.getStartDay());
			pstmt.setString(8, allDTO2.getEndDay());
			pstmt.setString(9, allDTO2.getInsure());
			pstmt.setInt(10, allDTO2.getTotPrice());


			result = pstmt.executeUpdate();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;	

	}

	public int chkRes(String resno){//예약번호 존재여부 확인

		int result = 0;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "select resno from rescar where resno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resno);
			result = pstmt.executeUpdate();

			pstmt.close();		

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;	

	}
	


	public void statRent(String resno){//예약중>대여중으로 전환

		int result = 0;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update rescar set status='대여중' where resno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, resno);

			result = pstmt.executeUpdate();

			if(result!=0){
				System.out.println("대여중 전환 완료!");

			}else{
				System.out.println("전환 실패!");
			}

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	//반납처리 할때
	//rescar와 customer에 있는 데이터 삭제
	public int deleteData(String resno){

		int result = 0;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete rescar where resno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resno);
			result = pstmt.executeUpdate();

			pstmt.close();
			
	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;


	}
	
	//예약정보조회
	//고객정보 불러오기
	public CustomDTO selCus(String tel){


		CustomDTO cusDTO = null;
		CarDTO carDTO = null;
		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;


		try {

			sql = "select resno,name,tel,to_char(birth,'YYYY-MM-DD') birth,email from customer where tel=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tel);

			rs = pstmt.executeQuery();

			while(rs.next()){

				cusDTO = new CustomDTO();

				cusDTO.setResno(rs.getString("resno"));
				cusDTO.setName(rs.getString("name"));
				cusDTO.setTel(rs.getString("tel"));
				cusDTO.setBirth(rs.getString("birth"));
				cusDTO.setEmail(rs.getString("email"));

			}	
			rs.close();
			pstmt.close();

		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return cusDTO;

	}

	//예약정보조회
	//rescar테이블에 있는 데이터 가져오기
	public AllDTO selAllDTO(String resno){


		AllDTO alldto = null;
		CarDTO carDTO = null;
		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;



		try {
			sql = "select carnum,to_char(startday,'YY-MM-DD') startday,to_char(endday,'YY-MM-DD') endday,";
			sql+= "insure,totprice,status from rescar where ";
			sql+= "resno=?";


			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, resno);
			rs = pstmt.executeQuery();

			while(rs.next()){

				alldto = new AllDTO();

				alldto.setCarNum(rs.getString("carnum"));
				alldto.setStartDay(rs.getString("startday"));
				alldto.setEndDay(rs.getString("endday"));
				alldto.setInsure(rs.getString("insure"));
				alldto.setTotPrice(rs.getInt("totprice"));
				alldto.setStatus(rs.getString("status"));

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return alldto;

	}
	//예약정보조회
	//carinfo에 있는 데이터 가져오기
	public CarDTO selCar(String carnum ){

		CarDTO cardto = null;
		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select carnum,manu,model,type,color,seat,fuel from carinfo where carnum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, carnum);
			rs = pstmt.executeQuery();

			while(rs.next()){

				cardto = new CarDTO();

				cardto.setCarNum(rs.getString("carnum"));
				cardto.setManu(rs.getString("manu"));
				cardto.setModel(rs.getString("model"));
				cardto.setType(rs.getString("type"));
				cardto.setColor(rs.getString("color"));
				cardto.setSeat(rs.getString("seat"));
				cardto.setFuel(rs.getString("fuel"));

			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return cardto;

	}
	
	//예약취소
	//rescar에서 데이터 지우기
	public int delres(String resno){


		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		int result=0;


		try {
			sql = "delete rescar where resno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resno);
			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	
	

	//제조사기준 차량 검색
	public List<CarDTO> seeManu(String manu){

		List<CarDTO> lists =new ArrayList<CarDTO>();

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs =null;



		try {

			sql = "select carnum, manu, model, type, color, seat, fuel, price ";
			sql+="from carinfo where manu=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manu);

			rs = pstmt.executeQuery();

			while(rs.next()){

				CarDTO dto =new CarDTO();

				dto.setCarNum(rs.getString("carnum"));
				dto.setManu(rs.getString("manu"));
				dto.setModel(rs.getString("model"));
				dto.setType(rs.getString("type"));
				dto.setColor(rs.getString("color"));
				dto.setSeat(rs.getString("seat"));
				dto.setFuel(rs.getString("fuel"));
				dto.setPrice(rs.getInt("price"));
				
				lists.add(dto);
			}
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	//색깔기준 차량 검색
	public List<CarDTO> seeColor(String color){

	

		List<CarDTO> lists =new ArrayList<CarDTO>();

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs= null;


		try {

			sql = "select carnum, manu, model, type, color, seat, fuel, price ";
			sql+="from carinfo where color=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, color);
			
			rs = pstmt.executeQuery();

			while(rs.next()){	

				CarDTO dto = new CarDTO();

				dto.setCarNum(rs.getString("carnum"));
				dto.setManu(rs.getString("manu"));
				dto.setModel(rs.getString("model"));
				dto.setType(rs.getString("type"));
				dto.setColor(rs.getString("color"));
				dto.setSeat(rs.getString("seat"));
				dto.setFuel(rs.getString("fuel"));
				dto.setPrice(rs.getInt("price"));

				lists.add(dto);

			}
			
			pstmt.close();
			
		} catch (Exception e) {

		}
		
		return lists;
	}
	
	//인승기준 차량 검색
	public List<CarDTO> seeSeat(String seat){
		
		String selectSeat = seat;

		List<CarDTO> lists =new ArrayList<CarDTO>();

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;

		try {
			
			sql = "select carnum,manu,model,type,color,seat,fuel,price ";
			sql+="from carinfo where seat=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, selectSeat);
	
			rs=pstmt.executeQuery();

			while(rs.next()){	

				CarDTO dto = new CarDTO();

				dto.setCarNum(rs.getString("carnum"));
				dto.setManu(rs.getString("manu"));
				dto.setModel(rs.getString("model"));
				dto.setType(rs.getString("type"));
				dto.setColor(rs.getString("color"));
				dto.setSeat(rs.getString("seat"));
				dto.setFuel(rs.getString("fuel"));
				dto.setPrice(rs.getInt("price"));

				lists.add(dto);

	
			}
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());

		}
		return lists;
	}
	
	//연료기준 차량 검색
		public List<CarDTO> seeFuel(String fuel){
			
			String selectFuel = fuel;

			List<CarDTO> lists =new ArrayList<CarDTO>();

			Connection conn = JejuConn.getConnection();
			PreparedStatement pstmt = null;
			String sql;
			ResultSet rs = null;

			try {
				
				sql = "select carnum,manu,model,type,color,seat,fuel,price from carinfo where fuel=?";

				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, selectFuel);
		
				rs=pstmt.executeQuery();

				while(rs.next()){	

					CarDTO dto = new CarDTO();

					dto.setCarNum(rs.getString("carnum"));
					dto.setManu(rs.getString("manu"));
					dto.setModel(rs.getString("model"));
					dto.setType(rs.getString("type"));
					dto.setColor(rs.getString("color"));
					dto.setSeat(rs.getString("seat"));
					dto.setFuel(rs.getString("fuel"));
					dto.setPrice(rs.getInt("price"));

					lists.add(dto);

		
				}
				
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.toString());

			}
			return lists;
		}
		
		//차량정보 입력
		public int carInfo(CarDTO dto) {

			int result=0;

			//입력하는 데이터의 갯수는 8개.
			//carnum :차량번호
			//manu:제조사
			//model:차량 이름
			//type :차량 종류
			//color: 차량 컬러
			//seat : 차량에 탑승 가능한 인원
			//fuel : 연료
			//price : 하루 대여료

			Connection conn = JejuConn.getConnection();
			PreparedStatement pstmt = null;
			String sql;


			try {

				sql = "insert into carinfo (carnum,manu,model,type,color,seat,fuel,price)";
				sql+="values(?,?,?,?,?,?,?,?)";

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getCarNum());
				pstmt.setString(2, dto.getManu());
				pstmt.setString(3, dto.getModel());
				pstmt.setString(4, dto.getType());
				pstmt.setString(5, dto.getColor());
				pstmt.setString(6, dto.getSeat());
				pstmt.setString(7, dto.getFuel());
				pstmt.setInt(8, dto.getPrice());

				result= pstmt.executeUpdate();

				pstmt.close();


			} catch (Exception e) {
				System.out.println(e.toString());

			}
			return result;

		}
	
	
	//차량삭제
	public int carDel(String carNum){

		int result = 0;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {


			sql = "delete carinfo where carnum=?";


			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carNum);
			result = pstmt.executeUpdate();


		} catch (Exception e) {
		}
		return result;
	}


	public int carUpdt(CustomDTO cusdto){

		int result = 0;

		Connection conn = JejuConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs=null;

		try {

			sql= "update customer set resno=?,name=?,birth=?,email=? ";
			sql+="where resno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusdto.getResno());
			pstmt.setString(2, cusdto.getName());
			pstmt.setString(3, cusdto.getBirth());
			pstmt.setString(4, cusdto.getEmail());
			pstmt.setString(5, cusdto.getResno());

			result= pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;		
	}
	
	
	
}







