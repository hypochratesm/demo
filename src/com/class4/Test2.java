package com.class4;

class Test{ //extends Object{//��� ��κ� �����Ǿ� �ִ� �κ�.
	//������
	
	private int a=10;
	
	public void write(){
		
		System.out.println("a:" + a);
		
	}
	
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Test ob1 = new Test();
		Test ob2 = new Test();
		
		System.out.println("ob1==ob2" + (ob1==ob2));//false//==�� �ּҸ� ���ϴ� ���̴�.
		
		System.out.println("ob1.equals(ob2):" + ob1.equals(ob2));//equals�� ����??? -> object�� ��
		//object�� equals�� �ּҸ� ���Ѵ�.
		//������Ʈ�� ������ �ִ� �޼ҵ�� ���� �׻� ��� �� �� �ִ�.
		
		
		
		
		
        //hashcode
		System.out.println("ob1:" + ob1);//com.class4.Test@5
		System.out.println(ob1.toString());//�� ������ �������..�ּҰ� �μ��//com.class4.Test@1
		System.out.println(ob2.toString());//�� ������ �������..�ּҰ� �μ��//com.class4.Test@6
		//toString�� �θ�(object)�� ���̱� ������ ������ ����� �� �մ�
		
		//tostring�� �ּ� ������ ��� ����..
	}

}
