package com.class5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test1 {
	

	
	public static void main(String[] args){
		
		 
		 //���� �ý����� ��¥ �� �ð��� ����
		
		Calendar now =Calendar.getInstance();
		//Calendar now1 = new GregorianCalendar();
		//�ڽ��� ���ؼ� �θ��� ��ü�� �������� �� �ִ�..
		
		int y = now.get(Calendar.YEAR);//year�� static�� �ö� �ִ�.
		int m = now.get(Calendar.MONTH)+1;//�������� +1, �������� -1�� ���ش�.//0���� 11���� ����Ǿ� �ִ�.
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);//1-7
		
		System.out.println(y + "-" + m + "-" + d);
        System.out.println(w);
		 
		String[] week = {"��","��","ȭ","��","��","��","��"};
		
	System.out.println(y+"-" + m + "-" + d + "-" + week[w-1]);//�迭�� ������ 0�����̱� ������ -1�� ���ش�.
	
	int startDAY = now.getActualMinimum(Calendar.DATE);
	int endDAY = now.getActualMaximum(Calendar.DATE);
	
	System.out.println("ù��:" + startDAY);
	System.out.println("����:" + endDAY);
	
    System.out.printf("%tF\n",now);
    System.out.printf("%tT\n",now);
    
    System.out.printf("%1$tF %1$tT\n",now);//%�ڿ� 1$�� ���ְ� �Ǹ� �й��Ģ�� ����ȴ�.
    
    now.set(2019, 10-1, 10);//��¥�� ����־� �ִ� ��.
    
    
    //*****cal.add*****

	y = now.get(Calendar.YEAR);
    m = now.get(Calendar.MONTH)+1;
	d = now.get(Calendar.DATE);
	w = now.get(Calendar.DAY_OF_WEEK);//1-7
	
	System.out.println(y+"-" + m + "-" + d + "-" + week[w-1]);
	
	}
}

	/*
	 
	int a;
	double b;
	
	a=10;
	
	b=a;           -O(�Ͻ��� ����ȯ)
	b = (double)a; -O(����� ����ȯ) 
	
	a = b;         -X
	a = (int)b;    -O(����� ����ȯ) 
	--------------------------------
	�θ�(b) - �ڽ�(a)
	
	�θ� = �ڽ�;       -O(UPCAST)
	�θ� =(�θ�)�ڽ�;  -O
	
	�ڽ� = �θ�;       -X
	�ڽ� = (�ڽ�)�θ�; -O(DOWNCAST)
	//�θ� �ڽ����� ����ȯ �ؼ� �ڽĿ� ���� �� �ִ�.*/
	 
	 