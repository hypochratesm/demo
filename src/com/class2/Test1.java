package com.class2;

//private
//this : circle �ڱ��ڽ� (class)ME//this�� Ŭ���� �̸��� ����, �ڱ� �ڽ�.


class Circle{
	
	private int r;//instance������ ������ private�� ������ش�.// ������ ����(ĸ��ȭ)//������ �޼ҵ常�� �� �� �ִ�.
	//private�� �Էµ� ������ ���ο��� �����ؾ߸� �Ѵ�.
	
	//���� �ʱ�ȭ �޼ҵ� - this�� �ʱ�ȭ�� �ϱ� ���� ���ȴ�.
	
	public void setData(int r){//setData(int r, Circle);//�����͸� �ʱ�ȭ ��Ű�� ������ set�� ���� ����.
		this.r = r;
	}
	//�����ڸ� ��߸� ���� �� �� �ִ�.//this�� ������.//this�� ���������� ����ϴ� ��.
	//ȥ���� �κ��� ���� �κп����� �����ڸ� ���� �ʾƵ� �ȴ�.
	
	public double area(){//area(Circle)
		
		return r*r*3.14;	
	}
	
	public void write(double a){//write(double a, circle this)
		
		System.out.println("������:" + r);
		System.out.println("����:" + a);
	}
	
}




public class Test1 {
	
	public static void main(String[] args){
		
		Circle ob1 = new Circle();
		
		ob1.setData(10);//setData(10.ob1);(1)
		
		//ob.r =100;
		
		double a = ob1.area();//ob1.area();
		ob1.write(a);//write(a,ob1)
		
		ob1.setData(200);
		a = ob1.area();
		ob1.write(a);
		
	}

}
