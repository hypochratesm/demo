package com.insurance;

import java.util.Random;
import java.util.Scanner;

//사용자가 입력한 조건에 맞는 보험 상품 검색
public class Test1 {

	public void calulator() {
		// 기간 - fixed
		// 금액(월 납입금) - 금액은 변함
		// 보험료 만기시 얼마씩 주는지
		// 월 납입금에 붙은 이자를 계산해서 총 금액 구하기
		// 다시 연금형식으로 한달에 얼마나 지불할지 알아야함
		Scanner sc = new Scanner(System.in);

		double totprice;

		StringBuffer sb = new StringBuffer();

		System.out.println("나이를 입력해주세요");
		sb.append(sc.next());

		long age = 0;

		if (sb.length() < 3) {
			age = Long.parseLong(sb.substring(0, 2));
			System.out.println(age);

		} else {
			age = Long.parseLong(sb.substring(0, 3));
			System.out.println(age);
		}
		System.out.println();
		System.out.println();

		Scanner coin = new Scanner(System.in);

		System.out.println("납입 하실수 있는 보험료를 입력해주세요(월 기준)");
		sb.append(coin.nextLong());

		long price = 0;

		if (sb.length() < 3) {
			price = Long.parseLong(sb.substring(2));
			System.out.println(price);

		} else {
			price = Long.parseLong(sb.substring(3));
			System.out.println(price);
		}
		System.out.println("월 납입료는" + price + "원 입니다.");
		System.out.println();
		System.out.println();
		System.out.println("가입하시고 싶으신 기간을 입력해주세요(년수)");

		int year = sc.nextInt();

		int month = year * 12;

		totprice = (long) (price + price * 0.02) * month;

		if (totprice <= 0) {
			return;
		} else if (totprice > 1000000 && totprice < 2000000) {
			System.out.println("무배당 모바일 바로건강보험");
			System.out.println("보험료는" + totprice + "입니다");
		} else if (totprice > 2000000 && totprice < 3000000) {
			System.out.println("방금만든 보험 1형");
			System.out.println("보험료는" + totprice + "입니다");
		} else if (totprice > 3000000 && totprice < 4000000) {
			System.out.println("방금만든 보험 2형");
			System.out.println("보험료는" + totprice + "입니다");
		} else if (totprice > 4000000) {
			System.out.println("특약보험가입이 가능합니다.");
			System.out.println("보험료는" + totprice + "입니다");
			System.out.println("경품추천을 시작합니다.");
			
			
			Test1 ts = new Test1();
			ts.goods();
		}

	}

	public void goods() {

		System.out.println("해택으로 매월 자동으로 경품추천을 진행합니다.");

		
		int rd = new Random().nextInt(1000000);

		System.out.println("경품번호는" + rd + "입니다");
		
		

	}

	public static void main(String[] args) {

		Test1 ts = new Test1();

		ts.calulator();
	}
}
