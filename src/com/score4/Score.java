package com.score4;

public interface Score {
	
	public void input();//데이터 입력
	public boolean searchHak(String hak);
    public void print();
    public void delete();//삭제
    public void update();//수정(이름은 제외)
    public void findHak();//학번검색
    public void findName();//이름검색
     
}
