package com.swing;

//Class Ŭ����
//Ư�� Ŭ������ �������̽��� ������ �˻��� �� �ִ� �޼ҵ带 �����Ѵ�.


class Test{
	
	public void write(){
		
		System.out.println("�׽�Ʈ.....");
		
	}
	
	
}

public class Test3 {   //jdbc���� ���

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName("com.swing.Test");//�ٸ� Ŭ������ ��ġ����
		
		
		//��ü���� �ɷµ� ������ �ִ�
		/*Test ob = new Test();*/
		Object ob = c.newInstance();//��ü����//�ڵ����� ��ü�� �����ϴ� ���.
		//ob�� �޸� ������ �÷��ش�.
		Test t = (Test)ob;//downcast
		
		t.write();

	}

}
