package com.class6;

class SuperTest{
	
	 public int a=10 , b=10;
	 
	 public void write(){
		 
		 System.out.println("����Ŭ���� write()�޼ҵ�");
		 
	 }
	 
	 public int hap(){
		 
		 return a+b;
	 }
}
class SubTest extends SuperTest{
	
	public int b=100,c=200;
	
	public void print(){
		System.out.println("����Ŭ���� print()�޼ҵ�");
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
		System.out.println("��:" + ob2.hap());//���� �� ���� ����.
		ob2.write();//�ڽ��� ������ �ֱ� �ʱ� ������ �� �� �ִ�.//���� ��ü�� ������ ������ ����.***********************************
		//ob2.print();//�̹� �θ��� ����� �ö󰬱� ������ ������ �� �� �� ����.
		
		((SubTest)ob2).print();//downcast

	}

}
