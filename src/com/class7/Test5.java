package com.class7;

import java.util.Vector;

//collection framework//�ڹٿ����� ������ ��ũ�� ����̴�!

//List(I) - ArrayList(C),Vector(C)//�̹� �������̽��� ������ ����.//���ʹ� ����ȭ�� �����Ѵ�.-> ������.
  // ArrayList�� ������ ���� �ʱ� ������ ������. ����Ʈ�� ���������� ����ϰ� �ȴ�.
//Map(I) - Hashtable(C),HashMap(C)
   //�����߰����� ����ϰ� �ȴ�. ����Ʈ ���� ���� �� ������ ������ ����Ѵ�.





public class Test5 {
	
	

	public static void main(String[] args) {
		
		
		//�⺻������ Ÿ���� Object�̴�.
		
		Vector v = new Vector();//������Ʈ
        //���ʸ��� ����� �Ǹ� ������Ÿ���� �˼��� �������� ������ ������Ʈ�� ��ü�� ������ش�.
		
		v.add("����");//upĳ��Ʈ//��Ʈ���� �����Ͱ� ������Ʈ�� �� -- upcast
		v.add("30");//upcast
		v.add('a');//upcast
		
		String str = (String)v.get(0);//downcast
		System.out.println(str);
		
		int i = (int)v.get(1);
		System.out.println(i);
		
		char c = (char)v.get(2);
		System.out.println(c);
		
	}

}
