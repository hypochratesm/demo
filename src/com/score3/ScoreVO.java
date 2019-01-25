package com.score3; //Record와 똑같은 아이//입력

public class ScoreVO {//Value Object(****기술면접****) -> 값을 저장하는 저장소 -> DTO(DATA TRANSFER OBJECT)
	//DAO...
	
	//접근지정자를 생략하면 proptected이다.//같은 패키지 안에서 모든 클래스가 사용할 수 있다.
	//변수는 무조건 private로 만들어 준다.
	//ScoreVO의 부모는 오브젝트다.
	
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	//getter,setter//private로 선언된 변수의 값을 입력하고 출력할 때 사용하는 메소드.
	//프로그램의 약속 꼭 무조건 사용해야 한다.
	//이 개념은 MFC에서 나오는 개념이다.
    //우클릭 소스 ... 이미 만들어져 있다면 getter와 setter는 나오지 않는다.
	
	//초기화를 SET으로 하고 
	//출력을 GET으로 한다.
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
	
	public int getTot() {
		return kor + eng + mat;
	}
	
	
	@Override
	
	
		public String toString() {//부모가 toString을 가지고 있기 때문에 toString을 써준다.
			
		
	
	
	/*public String print(){//  "==:을 쓰면 이해를 할때도 못할 때도 있다. 
*/		
		if(hak==null || name==null)
			 return null;//문자열 초기화
		
		String str = String.format("%5s %6s %4d %4d %4d %4d %4.1f" ,
				hak,name,kor,eng,mat,getTot(),getTot()/3.0);
		//내가 원하는 반환값을 찾을 수 있다.
		return str;
	}
		
		
	
	
	
}
