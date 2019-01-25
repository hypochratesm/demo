package com.collect;

import java.util.Hashtable;
import java.util.Iterator;



//Collection
//Map<Ű(Set - �ߺ����� ���� �� ����.),��>//arraylist���� ������.
//Hashtable : ����ȭ�� ����(Vector)
//HashMap : ����ȭ�� ��������(ArrayList) - > ������� ��µȴ�.

//Ű�� �ߺ����� ���� ���� �� ����.(Ű�� Set)
//Ű�� �ߺ����� ���̸� ������ ���� ����ȴ�.(����)
//Map�� Iterator�� ����.//ģô�� Iterator�� �����ٰ� ����.//ģô keyset�� �����͸� ������ ����.
//put: �߰�
//get: ��������



public class Test3 {


	public static final String name[] = 
		{"�����","õ����","������","����ȿ","�ڽ���"};

	public static final String tel[] = 
		{"111-111","222-222","333-333","111-111","444-444"};



	public static void main(String[] args) {

		Hashtable<String, String> h = //MAP�� �����͸� �ִ´�
				new Hashtable<String, String>();

		for(int i =0;i<name.length;i++){


			h.put(tel[i], name[i]);//Ű�� �ߺ��Ǹ� �����ȴ�.//Ű�� �����
               // key    , value
		}
		System.out.println(h);
		//map�� ����� �����̴�.

		String str;

		str = h.get("111-111"); // key�� �ָ� ���� ������
		if(str==null) //���� ������ ������ �ȵɶ��� �־ �񱳸� �ι� ���ش�.
			System.out.println("�ڷ����");
		else
			System.out.println(str);
		/* || str.equals("")*/


		//Ű�� �����ϴ��� �˻�

		if(h.containsKey("222-222"))
			System.out.println("222�ִ�");
		else
			System.out.println("222����");

		//�����Ͱ� �����ϴ��� �˻�

		if(h.containsValue("õ����")){

			System.out.println("���� �ִ�");
		}else{
			System.out.println("���� ����");
		}
		//����
		h.remove("222-222");

		if(h.containsKey("222-222"))
			System.out.println("222�ִ�");
		else
			System.out.println("222����");


		//��ü���
		Iterator<String> it = h.keySet().iterator();
		//Ű�� �ڷ����� ��ȣ�ȿ� �־� �ش�
		while(it.hasNext()){

			String key = it.next();//key�� ��ȯ
			String value = h.get(key);//value�� ��ȯ

			System.out.println(key + ":" + value);
	

	}

}

	}
