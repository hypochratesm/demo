package com.class7;

//내부클래스
//annonymouse,익명의,무명의,클래스



public class Test4 {
	
	
	public Object getTitle(){
		
		//코딩
		//object ob = new Object(); 
		
		return new Object(){//스택 영역의 주소의 이름이 없다.

			@Override
			public String toString() {
				return ("무명의 클래스");
			}
			
			
		};//이 세미콜론은 반드시 있어야 한다.
		
		/*public String toString(){
			
			return"무명의 클래스";*/
			
		}//대부분이 인터페이스가 이곳에 구현된다.
		
		

	

	public static void main(String[] args) {
		
		Test4 ob =new Test4();
		
		System.out.println(ob.getTitle());

	}

}
