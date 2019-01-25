package com.class5;




	
class SuperClass{
	

	protected int a=10, b=10;
	
	public void write(){
		System.out.println("Super class write()...");
		System.out.println("a: " + a + "b: " +b);
	
		
	}
}		
	


class SubClass extends SuperClass{
	
	protected int b=30,c=40;
	
	 public void write() {
		
		System.out.println("Super class write()...");
		System.out.println("a: " + a + "b: " + b + "c: " + c);
	    System.out.println("super.b : " + super.b);//super ��ӹ��� ����� �����ϰ� �ȴ�.
	}
	
	public void print1(){
		System.out.println("Sub class print1()...");
		write();
		
	}
	
	public void print2(){
		System.out.println("Sub class print2()...");
		super.write();//�θ𿡰Լ� ��ӹ��� ����� �����ϰ� �ִٰ� write�� ����ϰ� �ȴ�.
    }
  }






public class Test4 {
	
	
	

	public static void main(String[] args) {
		
		SubClass ob =new SubClass();
		ob.write();
		//System.out.println(); - �ܺο����� ���� ����.
		ob.print1();
		ob.print2();
		
		
		System.out.println("--------------------------");
		
		System.out.println("ob.b:" + ob.b);//30
		System.out.println("((SuperClass)ob).b : " + ((SuperClass)ob).b);//upcast
        
		
		//�޼ҵ�� �ν��Ͻ� ������ �ٸ��� �ڽ��� �޼ҵ带 ȣ���Ѵ�.
		//�޼ҵ�� heap������ �ƴ� �޼ҵ� ������ ����Ǿ� �ֱ� ������
		//������ �Ұ� �ϴ�.
		//�޼ҵ�� upcast�� �ص� ������ �ڽ� ���� ����Ѵ�.
		((SubClass)ob).write();//�ڽ��� write�� ��������.
		//���⼭ super�� ���� ����.
		

	}
}

