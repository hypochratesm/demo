package com.class7;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String city[]= {"����","�λ�","�뱸","��õ","����","����","���"};
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		Vector<String> v = new Vector<String>();
		String str;
		
		System.out.println("������ �ʱ�뷮" + v.capacity());
		
		for(String c : city){
			v.add(c);
		}
		System.out.println("[Iterator�� ����� ��ü ���...]");
		//iterator�� �ݺ������� �ϳ��� �о��
		Iterator<String> it = v.iterator();//�����
		while(it.hasNext()){
			
			str = it.next();
			System.out.println(str + " ");
			
		}
		System.out.println();
		System.out.println("������(���) ����:" +v.size());
		
		
		//�����ϱ�. -> ������ ����//override
		v.set(0,"Seoul");
		v.set(1,"Pusan");
		
		System.out.println("[��ü���...]");
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		System.out.println();
		
		//�����ֱ�
		v.insertElementAt("���ѹα�", 0);//set�� �ٸ��� ��ȣ�ȿ� �Էº����� ������ �ٸ���.

		for(String c : city){
			v.add(c);
		}
		
		System.out.println();
		System.out.println();
		
		
		//�˻�
		int index = v.indexOf("�뱸");
		if(index!=-1){//�ε����� ã������ ������ ������ ���� -1
			System.out.println("�˻�����:" + index);//3
			
		}else{
			
			System.out.println("�˻�����:" + index);// -1
		}
		
		//��������(1~10,a~z,��~��)
		Collections.sort(v);
		for(String s: v){
			System.out.println(s + " ");
		}
		
		System.out.println();
		
		
		//��������(10~1,z~a,��~��)
		Collections.sort(v,Collections.reverseOrder());
		
		for(String s: v){
			System.out.println(s + " ");
		}
		
		System.out.println();
		
		//����
		
		v.remove("Pusan");// v.remove(7);
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		
		//�뷮����
		for(int i =0;i<20;i++){//�⺻�迭�� 10���̱� ������ 20���� �뷮�� ����������
			v.add(Integer.toString(i));
		}
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		System.out.println("������ �뷮" + v.capacity());
		System.out.println("������ ����:" +v.size());
		
		//��������
		
		//v.removeRange(5,20);-X
		for(int i=1;i<10;i++){
			v.remove(5);//10���� ����...
		}
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		
		
		System.out.println("������ �뷮" + v.capacity());
		System.out.println("������ ����:" +v.size());
		
		//����� ����
		v.trimToSize();
		System.out.println("������ �뷮" + v.capacity());
		System.out.println("������ ����:" +v.size());
		
		//��ü����
		v.clear();		
		System.out.println("������ �뷮" + v.capacity());
		System.out.println("������ ����:" +v.size());
		
      	v.trimToSize();
		System.out.println("������ �뷮" + v.capacity());
		System.out.println("������ ����:" +v.size());
		
		
	}
	   
}
