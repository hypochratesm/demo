package com.prj2;

public interface Rent {
	
	public void input();//예약날짜,차량선택, 면책제도 선택
	
	
	public void searchRes();//예약자 조회 
	public void allSearch();//전체 예약자 조회
	
	
	public void carInfo();//차량 정보 입력(차량번호,차종,모델명,제조사,가격 등..)
	public void carDel();//차량 정보 삭제
	public void carPrint();//차량정보 출력
	
	
	public void posiCar();//예약가능 차량 조회
	public void admin();//관리자 페이지
	
	public void carUpdt();//차량정보수정
	public void carSearch();//예약가능 차량의 정보조회
	

}
