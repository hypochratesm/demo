package com.class3;

public class Test3 {//static�� �������߿� �޸𸮿� �� ���� �ö󰡴� ���� static�̴�.
	
	int a=5;
	
	{//�ʱ�ȭ ��
		System.out.println("�ʱ�ȭ ��:a" + a);
		a=10;
		System.out.println("�ʱ�ȭ ��:a" + a);
	}
    static int b;
    static{//static �ʱ�ȭ��//static���� �޸𸮻����� �̵��ϰ� �ȴ�.//
    	   //���⼭ ���������͸� Ÿ�� 15������ �̵��ϰ� �ȴ�.
    	b=10;
    	System.out.println("static��b:" + b);
    }
	
    final int C;//���//�ѹ� �ʱ�ȭ�� �ϸ� ���� ���� �ٲ��� �ʴ´�.
                //�׻� ������ �ʴ� ��.
                //�Ϲ������� ����� �빮�ڷ� ���ش�.(�������)	
	            //������ �����ϴ� �ʱⰪ�� �Է����־�� �Ѵ�.
                //Instance������ ���������� ������ �����Ҷ� �޸� �� �ö󰣴�.
    
    public Test3(){
    	System.out.println("������...");
    	C=100;
    	System.out.println("���C :" + C);
    	
    	
    }
    
    
    
	public static void main(String[] args) {
		
		
		Test3 ob1 = new Test3();
		
		System.out.println("--------------");
		
		Test3 ob2 = new Test3();
		

	}

}
