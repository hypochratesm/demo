package com.prj2;

import java.util.List;
import java.util.Scanner;

public class Test1 {
	RentDAO rentDAO = new RentDAO();
	Scanner sc = new Scanner(System.in);

	public void seeManu(){

		String manu;
		

		

		System.out.println("���� ���忡���� ����(HYU),���(KIA),�����ٰ�(VWK),������(SHV),�ֿ�(SSY)������ �غ�Ǿ� �ֽ��ϴ�.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� ");
		System.out.println("================================================================");
		
		System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
		System.out.print("�� ");
		manu=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(manu);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	public void seeColor(){

		String color;
		

		

		System.out.println("���� ���忡�� ����, ���, �Ķ� ,��� ,���� ,��� ,���� ,���� ,�챸 , ������ ������ �غ�Ǿ� �ֽ��ϴ�.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� ");
		System.out.println("================================================================");
		
		System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
		System.out.print("�� ");
		color=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(color);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	
	
	
	public void seeSeat(){

		String seat;
		
		

		System.out.println("���� ���忡���� 2�ν�, 4�ν�, 5�ν�, 6�ν�, 7�ν�, 9�ν��� ������ �غ�Ǿ� �ֽ��ϴ�.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� ");
		System.out.println("================================================================");
		
		System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
		System.out.print("�� ");
		seat=sc.next();
		
		List<CarDTO> lists = rentDAO.seeManu(seat);
		
		for(CarDTO car : lists){
			System.out.println(car.toStringCar());
		}
	}
	
	public void seeFuel(){

		String fuel;
		;

		

		System.out.println("���� ���忡���� ����,����,����,����(�긮��),�ֹ�,������ ������ �غ�Ǿ� �ֽ��ϴ�.");
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println(" ������ȣ | ������ |   �𵨸�   | ���� | ���� | ž���ο� | ���� ");
		System.out.println("================================================================");
		
		System.out.println("ã���ô� �����縦 �����ڷ� �Է����ּ���");
		System.out.print("�� ");
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