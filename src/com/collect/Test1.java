package com.collect;

import java.util.Vector;

class Test{
	
	String name;
	int age;
}

public class Test1 {

	public static void main(String[] args) {
		
		//object �ȿ��� �� ���� �ִ�.(int,double,scanner....Ŭ������ ���� ���� �� �ִ�.)
		//��Ӱ��迡�� object�� ���� ������ �ֱ� ������
		
		
		
		Vector<Test> v = new Vector<Test>();//-> ���Ϳ��� ��Ʈ���� ���� �� ����. 
		
		Test ob;//��ü����
		ob = new Test();
		ob.name = "�����";
		ob.age = 25;
		
		v.add(ob);

	/*	//�߸� �ۼ��ϴ� ���
		��ü�� ����� �ҷ��� �� ����.// ������ ���������� ��(heap)������ ������ ������ ���� �� �� ���� ������ ��ü�� ���� �� �� ����.
		ob.name = "�ڽ���";
		ob.age = 28;
		//ob�� �����ϴ°��� �ƴ϶� ���ͷ� �����ؾ� �Ѵ�.
		v.add(ob);*/
		
		ob = new Test();
		ob.name ="�ڽ���";
		ob.age = 28;
		v.add(ob);
	
		
		
		
		for(Test t : v){
			System.out.println(t.name + ":" + t.age);
		}
		
		
	}

}
