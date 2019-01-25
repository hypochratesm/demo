package com.prj2;

import java.util.List;
import java.util.Scanner;

public class Test1 {
	RentDAO rentDAO = new RentDAO();
	Scanner sc = new Scanner(System.in);

	public void seeManu(){

		String manu;
		

		

		System.out.println("저희 매장에서는 현대(HYU),기아(KIA),폭스바겐(VWK),쉐보레(SHV),쌍용(SSY)차량이 준비되어 있습니다.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 ");
		System.out.println("================================================================");
		
		System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
		System.out.print("▷ ");
		manu=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(manu);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	public void seeColor(){

		String color;
		

		

		System.out.println("저희 매장에는 검정, 흰색, 파랑 ,흰색 ,남색 ,노랑 ,은색 ,빨강 ,살구 , 갈색의 차량이 준비되어 있습니다.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 ");
		System.out.println("================================================================");
		
		System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
		System.out.print("▷ ");
		color=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(color);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	
	
	
	public void seeSeat(){

		String seat;
		
		

		System.out.println("저희 매장에서는 2인승, 4인승, 5인승, 6인승, 7인승, 9인승의 차량이 준비되어 있습니다.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 ");
		System.out.println("================================================================");
		
		System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
		System.out.print("▷ ");
		seat=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(seat);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	
	public void seeFuel(){

		String fuel;
		;

		

		System.out.println("저희 매장에서는 디젤,경유,가스,하이(브리드),휘발,가솔의 차량이 준비되어 있습니다.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" 차량번호 | 제조사 |   모델명   | 차종 | 색상 | 탑승인원 | 연료 ");
		System.out.println("================================================================");
		
		System.out.println("찾으시는 제조사를 영문자로 입력해주세요");
		System.out.print("▷ ");
		fuel=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(fuel);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	
	
	
	public static void main(String[] args) {
//		Connection conn = JejuConn.getConnection();
//		PreparedStatement pstmt = null;
//		String sql;
		
		Test1 t1 = new Test1();
		t1.seeManu();
	}
}