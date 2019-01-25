package com.class6;

class SuperTest{
	
	 public int a=10 , b=10;
	 
	 public void write(){
		 
		 System.out.println("슈퍼클래스 write()메소드");
		 
	 }
	 
	 public int hap(){
		 
		 return a+b;
	 }
}
class SubTest extends SuperTest{
	
	public int b=100,c=200;
	
	public void print(){
		System.out.println("서브클래스 print()메소드");
	}
	

	@Override
	public int hap() {
		return a+b+c;
	}
	
}
   public class Test2 {
	public static void main(String[] args) {
		
		SubTest ob1 = new SubTest();
		
		System.out.println("ob1.b:" +ob1.b);//100
		
		SuperTest ob2 = ob1;//upcast
		System.out.println("ob2.b:" + ob2.b);//10
		System.out.println("합:" + ob2.hap());//합은 내 것을 쓴다.
		ob2.write();//자식이 가지고 있기 않기 때문에 쓸 수 있다.//같은 객체를 가지면 내것을 쓴다.***********************************
		//ob2.print();//이미 부모의 세대로 올라갔기 때문에 내것을 쓸 수 는 없다.
		
		((SubTest)ob2).print();//downcast

	}

}
