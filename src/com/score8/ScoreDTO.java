package com.score8;

public class ScoreDTO {//DATA transfer object
	
	//전달자의 역할, 저장소는 아니다. 그렇기 때문에 transfer가 들어간다.
	
//이전에는 리스트에 있는 파일들을 뺴오고 저장했었지만 이제는 DTO가 DB로 가서 데이터를 부어준다. DTO는 전달자이다.
	
	private String hak;
	private String name;
    private int kor;
    private int eng;
    private int mat;
    //여기까지는 db에 저장
    private int tot;
    private int ave;
    private int rank;
    //여기까지는 파생 칼럼들.
    
    
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
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAve() {
		return ave;
	}
	public void setAve(int ave) {
		this.ave = ave;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
    
    //출력
	@Override
		public String toString() {
		
		String str;
		str = String.format("%5s %6s %4d %4d %4d %4d %4d %4d ,hak,name,kor,eng,mat,tot,ave,rank");//총 8개.
				
	    return str;
			
		}
    
    
    
}
