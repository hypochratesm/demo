package com.class2;

//static
//�ڱⰡ �˾Ƽ� �޸𸮷� �ö�
//1000���� ���� �޸� ������ �Ѱ��� ���
//static�� ���� ���� ���� class ����





public class Test2 {
	
	
	public static int a=10;//class����
    //Ŭ���� ������ Ŭ�����޼ҵ�� �ε��Ǵ� ����
    //�޸� �Ҵ��� �̷������ [Ŭ�����̸�.��ü�̸�] ���� ����
    //��, new�� ������� �ʰ� �ٷ� ����� �� �ִ�.	
	
	
	private int b = 20;//instance����
	//�ν��Ͻ� ����//������ Ŭ������ instance �޼ҵ� �ȿ��� �ٷ� ������ ����������
	//Ŭ�����޼ҵ忡���� ���� �� �� ����.
	//Ŭ���� �޼ҵ忡�� �����ϱ� ���ؼ��� new�� ����
	//��ü�� �����ϰ� ��ü�̸����θ� ������ �����ϴ�.
	
	public void write(){
		System.out.println("class����:" + a);
		System.out.println("instance����:" + b);
		
	}
	
	public static void print(){
		
		System.out.println("class����:" + a);
		/*System.out.println("instance����:" + b);*///b�� ������
		
		
		
	}
	
    
    //class����
	public static void main(String[] args) {
		
		System.out.println("class���� a:" +a);
		System.out.println("class���� Test2.a" + Test2.a);
		/*System.out.println("instance���� b:" + ob1.b);*/
		
		/*write();//1���� �ֱ� ������ ȣ�� �� �� ���� ������
		 
*/		
		print();//15���� �̹� �� �ֱ� ������ ����� ����
		
		Test2.print();
		
		Test2 ob1 = new Test2();//��ü ���� write�� b�� ���������͸� Ÿ�� ���� �ö󰡰� �ȴ�.
		
		System.out.println("instance���� b:" + ob1.b);
		
		ob1.write();//instance�޼ҵ�� �̸��� �ٿ������
        ob1.print();		
		
        System.out.println("class���� a:" +ob1.a);
        
        
    	Test2 ob2 = new Test2();
		
    	ob2.a = 100;
    	ob2.b = 200;
    	
    	System.out.println("ob2-----------");
    	ob2.write();
    	
    	
    	Test2 ob3 = new Test2();
    	System.out.println("ob3-----------");
    	ob3.write();
    	
    	
		
		
		
		//�ε��Ǵ� ������ ��ü�� �����ϴ� ���� ������ �ٸ���.
		//Test2 ob1 =new Test2();//��ü
    	
    	//static���� Ŭ������ �޸� �� �ö󰡰� �Ǹ� �۾��� ���ڸ�ü�� �ٲ�� �ȴ�.
		

	}

}
