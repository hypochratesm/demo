package com.class5;


//Singleton - Ŭ�������� �� �ϳ��� ��ü���� �����ϰ� �ϴ� ���.//�ϳ��� Ŭ���� ��ü�� �޸𸮻� �÷����� ����ϴ� ���
//Calendar now = Calendar.getInstance();//��ǥ���� �̱����� ����

class Sing{
	
	private static Sing ob;//Ŭ������ �ʱⰪ�� ������ null��������
    
	public static Sing getInstance(){
		
		if(ob==null)
			ob = new Sing();
		
		//�ڵ�
		
		return ob;
		
	}
	
	
}


public class Test5 {

	public static void main(String[] args){
		
		Sing ob1 = Sing.getInstance();
		Sing ob2 = Sing.getInstance();
		
		if(ob1==ob2){//==�� �ּҸ� ���Ѵ�.
			System.out.println("���ϰ�ü...");
		}else{
			System.out.println("�ȵ��ϰ�ü...");
		}
		
	}
}
