package com.class7;

//����Ŭ����
//annonymouse,�͸���,������,Ŭ����



public class Test4 {
	
	
	public Object getTitle(){
		
		//�ڵ�
		//object ob = new Object(); 
		
		return new Object(){//���� ������ �ּ��� �̸��� ����.

			@Override
			public String toString() {
				return ("������ Ŭ����");
			}
			
			
		};//�� �����ݷ��� �ݵ�� �־�� �Ѵ�.
		
		/*public String toString(){
			
			return"������ Ŭ����";*/
			
		}//��κ��� �������̽��� �̰��� �����ȴ�.
		
		

	

	public static void main(String[] args) {
		
		Test4 ob =new Test4();
		
		System.out.println(ob.getTitle());

	}

}
