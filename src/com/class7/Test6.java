package com.class7;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {
	
	private static final String city[]= {"����","�λ�","�뱸","��õ","����","����","���"};
	
	public static void main(String[] args){
		
		Vector<String> v = new Vector<String>();
		
		//� �����͸� ������ �� �ִ�!//String ������ �÷���
		
		
		for(String c: city){//Ȯ�� for��
			v.add(c);
		}
		
		//������ ��ü v�� city ��ҵ��� �־��־���.
		
		//v.add(10);
		String str;
		
		str = v.firstElement();//ù������ ������ �Ͷ�~
		System.out.println("ù��°���:" + str);
		
		str = v.lastElement();
		System.out.println("���������:" + str);
		
		str = v.get(2);//0.1.2
		System.out.println("����°���:" + str);
		
		System.out.println();
		
		str = v.get(3);
		System.out.println("�׹�°���:\r" + str);
		
		System.out.println();
		
		
		for(int i = 0;i<v.size();i++){
			System.out.println(v.get(i));
		}
		System.out.println();
		
		for(String s:v){
			
			System.out.print(s + " ");
			
		}
		System.out.println();
		//�ڹٿ����� Ȯ������ �迭�� �ݷ���
		
		//Iterator:�ݺ���(��±�)
        
	    Iterator<String> it = v. iterator();
	    
	    while(it.hasNext()){ //���Ϳ� �󸶸�ŭ�� �����Ͱ� ������ �� �� ���� ������ while�� ����/	
	    	str = it.next(); // �� �� ���� �� ����. // it �ȿ� �����ʹ� �ѹ� ������ ������� ������.
	    	System.out.print(str + " ");
	    	
	    	//while���� �ϱ�����!!!!!
	    	
	    }
		
	
		
		
		
		
		
		
		
	}    
	

}
