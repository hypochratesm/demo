package com.class6;

interface Test{
	
	public int total();
	public void write();
	
}


class TestImpl implements Test{
	
	private String hak,name;
	
	private int kor,eng;
	
	public TestImpl(){//기본생성자
	}
	
	public TestImpl(String hak, String name,int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		
	}
	
	public void set(String hak,String name, int kor , int eng ){
	this.hak = hak;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	}
	
	@Override
	public int total(){
	
		return kor+eng;
		
	}
	
	


	@Override
	public void write() {
		System.out.println(hak+":" + name + ":" + total());
	}
	
	//ob1.equals(ob2)-TestImpl -> object(upcast)
	public boolean equals(Object ob) {//upcast가 발생했다.
		
		boolean flag = false;
		
		if(ob instanceof TestImpl){//true
			
			TestImpl t =(TestImpl)ob;//downcast 부모가 자식으로 바뀌게 되면서 downcast가 일어나게 된다.
			
			if(this.hak.equals(t.hak)&&//equals는 String
					this.name.equals(t.name)){
				flag = true;
			}
			
		}
		return flag	;	
	}
	
	
	
	
}


public class Test4 {

	public static void main(String[] args) {
		
		/*TestImpl ob = new TestImpl();//1번 방법
		ob.set("1111", "배수지", "60", "70");*/
		
		/*TestImpl ob1 = new TestImpl("1111", "배수지", 60, 70);
		TestImpl ob2 = new TestImpl("1111", "배수지", 100,100 );//2번 방법
*/		
		
		TestImpl ob1 = new TestImpl("1111", "배수지", 60, 70);
		TestImpl ob2 = new TestImpl("1111", "강수지", 100,100 );//2번 방법
		
		/*Test ob =new TestImpl();
		ob.set("1111", "배수지", 60, 70));*/
		
		if(ob1.equals(ob2))
			System.out.println("ob1과 ob2는 동일 인물...");
		else
			System.out.println("ob1과 ob2는 동일 인물 아님");
		
		ob1.write();
		ob2.write();
      
	}

}
