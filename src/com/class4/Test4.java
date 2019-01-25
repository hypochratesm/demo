package com.class4;


//String�� �������ִ� Ŭ����
//StringBUFFER : ����, ����ȭ�� ����
//StringBuilder:�ӵ��� ����,����ȭ�� ������
//�츮�� �����ϴ� �Ϲ����� Ŭ������ �����ϴ�. 


//**����ȭ**: �ڷ��� �����͸� ���� ���ߴ°�.

public class Test4 {
        public void stringTime(){
		
		System.out.println("StringTime...");
		
		//long start = System.currentTimeMillis();//�и�����
       long start = System.nanoTime();//10^-9 10�� ���̳ʽ� 9��
       
       String str = new String("a");
       
       for(int i=0;i<=50000;i++){
    	      str += "a";
			
       }
       
       long end = System.nanoTime();
       
       System.out.println("����ð�:" + (end-start));
	}
	
	
	
	public void stringBufferTime(){
		
		System.out.println("StringBufferTime...");
		
		//long start = System.currentTimeMillis();//�и�����
       long start = System.nanoTime();//10^-9 10�� ���̳ʽ� 9��
       
       StringBuffer str = new StringBuffer("a");
       
       for(int i=0;i<=50000;i++){
    	   str.append("a");
       }
       
       long end = System.nanoTime();
       
       System.out.println("����ð�:" + (end-start));
	}
	
public void stringBuilderTime(){
		
		System.out.println("StringBuilderTime...");
		
		//long start = System.currentTimeMillis();//�и�����
       long start = System.nanoTime();//10^-9 10�� ���̳ʽ� 9��
       
       StringBuilder str = new StringBuilder("a");
       
       for(int i=0;i<=50000;i++){
    	   str.append("a");
       }
       
       long end = System.nanoTime();
       
       System.out.println("����ð�:" + (end-start));
	}

	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		
		
	    ob. stringTime();
		ob. stringBufferTime();
		ob. stringBuilderTime();

	}

}
