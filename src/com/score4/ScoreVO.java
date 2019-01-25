package com.score4;

public class ScoreVO {//Value Object
	
	private String name;//학번은 별도의 공간에 저장되기 때문에 같이 저장 할 수 없다.
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	
	
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
		tot = kor + eng + mat;
		return tot;
	}
	
	
	
	@Override
	public String toString() {
		
		String str;
		double ave = getTot()/3.0;
		
		str =String.format("%6s %4d %4d %4d %4d %5.1f",name,kor,eng,mat,getTot(),ave);
		
		return str;
		}
}

