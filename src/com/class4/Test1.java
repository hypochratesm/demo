package com.class4;

class A{
	
	public int x;
	
	public A(){
		
	}//������ �ִ� �⺻ ������.//�����ڸ� ����� ���� �޸𸮸� �Ҵ��ϴ°�.
    public A(int x){
		
    	this.x = x;//������ �����ε�
	}
   
	public void print(){
		System.out.println("x:" + x);
		
	}
	
}


class B extends A{
	
	public int y = 20;
	
	public B(){
		super();//��Ӱ��迡���� �θ� ��������� �ڽ��� ���������.
	//������ �ִ� �⺻ ������
	//������ �ȿ� ������ �ִ�.
		
	}
	
	public B(int x){
	   super(x);	
	   }
	
	public void write(){
		System.out.println("y:"+ y);
		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		//B ob = new B();
		B ob = new B(100);
		
		
		
		ob.print();
		ob.write();//����

	}

}
