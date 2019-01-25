package com.score3; //Record�� �Ȱ��� ����//�Է�

public class ScoreVO {//Value Object(****�������****) -> ���� �����ϴ� ����� -> DTO(DATA TRANSFER OBJECT)
	//DAO...
	
	//���������ڸ� �����ϸ� proptected�̴�.//���� ��Ű�� �ȿ��� ��� Ŭ������ ����� �� �ִ�.
	//������ ������ private�� ����� �ش�.
	//ScoreVO�� �θ�� ������Ʈ��.
	
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	//getter,setter//private�� ����� ������ ���� �Է��ϰ� ����� �� ����ϴ� �޼ҵ�.
	//���α׷��� ��� �� ������ ����ؾ� �Ѵ�.
	//�� ������ MFC���� ������ �����̴�.
    //��Ŭ�� �ҽ� ... �̹� ������� �ִٸ� getter�� setter�� ������ �ʴ´�.
	
	//�ʱ�ȭ�� SET���� �ϰ� 
	//����� GET���� �Ѵ�.
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
	
	
		public String toString() {//�θ� toString�� ������ �ֱ� ������ toString�� ���ش�.
			
		
	
	
	/*public String print(){//  "==:�� ���� ���ظ� �Ҷ��� ���� ���� �ִ�. 
*/		
		if(hak==null || name==null)
			 return null;//���ڿ� �ʱ�ȭ
		
		String str = String.format("%5s %6s %4d %4d %4d %4d %4.1f" ,
				hak,name,kor,eng,mat,getTot(),getTot()/3.0);
		//���� ���ϴ� ��ȯ���� ã�� �� �ִ�.
		return str;
	}
		
		
	
	
	
}
