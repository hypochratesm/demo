package com.class4;

//String
//int, double..(�ڷ���)
//String�� class�̴�(�ڷ����� �ƴϴ�.)

public class Test3 {
	
	public static void main(String[] args){
		
		String ob1 = "Seoul";
	    String ob2 = "Seoul";
	    String ob3 = new String("Seoul");//Ŭ�����̱� ������ �̷��� �ᵵ �ȴ�.
		
	    
	    System.out.println("ob1==ob2:" + (ob1==ob2));//true
	    System.out.println("ob1==ob3:" + (ob1==ob3));//false
	    System.out.println("ob1.equals(ob3):" + (ob1.equals(ob3)));//true//������Ʈ ���� equals�� �������̵� �ߴ�.
	    //string�� ������Ʈ�� equals�� �������̵� �ؼ� ������ equals�� �ּҸ� �������� 
	    // string�� equals�� ���ڿ��� ���Ѵ�
	    
	    //������ ���� ������ heap�� ���� �ϰ� ���� �� �� �ֵ��� stack������ �ڷ������� �����Ѵ�.
	    
	    ob2 = "korea";
	    
	    System.out.println("ob1==ob2:" + (ob1==ob2));//false//��Ʈ���� �ڱ� �ڽ��� ���� ������ �ʰ� ����� ���Ҵ�.
	    
	    
	    //string�� �Һ��� ��Ģ - String�� �ѹ� heap������ �����͸� �����ϸ� ���� �ٲ��� �ʴ´�.
	    ob2 = "japan";
	    System.out.println("ob1==ob2:" + (ob1==ob2));//false
	    
	    ob2 = "Seoul";
	    System.out.println("ob1==ob2:" + (ob1==ob2));//true
	    System.out.println(ob2);//Seoul
	    System.out.println(ob2.toString());//�������� ����Ǿ� �ִ� ���ڸ� �츮���� �����ش�.
	    
	    
	
	    //ó���ϴ� �����ʹ� ����ϰ�  //��Ʈ���� �������� ����
	    //���� heap������ �����ϰ� 
	    //����ϴ� ����� �ڷ���ó�� ����Ѵ�.
	    
	    //garbage collector�� Ŭ������ ������ �޼ҵ�� ����.
	    // ���� �� �༮�� ��Ʈ���� ��ɾ ����.  AI - �ڱⰡ �˾Ƽ� �Ѵ�. 
	    //������ ������ ���� HEAP������ ��� �����ص��� ���⶧����
	    //�����ʹ¼� �޸𸮸� ��Ƹ԰� �ȴ�.
	    
	    
		
		
	}

}
