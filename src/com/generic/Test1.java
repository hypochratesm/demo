package com.generic;

//���ʸ�//Ŭ������ �޼ҵ��� �ڷ����� ���� �������ִ°�.

class Box<T>{
	
	private T t;//�ڷ����� ����
	
	
	
	public void set(T t){//�̸� �ʱ�ȭ ��Ű�� setter
		this.t=t;
		
		
	}
	public T get(){//getter
		return t;
		
	}
	
	
}

public class Test1 {
	
	public static void main(String[] args){
		
		Box<Integer> b1 = new Box<Integer>();
		/*b1.set(10);*/
		b1.set(new Integer(10));//��Ƽ���� �־��� ������ �ݵ�� new�� �־�� �Ѵ�
		/*String i = b1.get()*/;//����ȭ �۾��� �ؾ��Ѵ�.
		int i = b1.get();
		System.out.println(Integer.toString(i));
		System.out.println(i);
		
		Box<String> b2  = new Box<String>();
		b2.set("����");
		String s = b2.get();
		System.out.println(s);
		
		
		Box b3 = new Box();//������Ʈ
		b3.set(30);//upcast//������Ʈ�� 30�� ���鼭 ��ĳ��Ʈ�� �߻���
		
		Integer ii = (Integer)b3.get();//�ٿ�ĳ��Ʈ
		System.out.println(ii);
		//double 
		//integer
		//float
		//character
		//wraper class
		//auto boxing
		//auto unboxing
		
		
		
		
		
	}

}
