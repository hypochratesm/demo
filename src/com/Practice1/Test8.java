package com.Practice1;


//������ �μ�(��������) -�μ��� ������ ������ ���� ������ ����Ѵ�.

public class Test8 {
	
	int sum(int...args){//�μ��� ������ �������� ������.//���� �����ͼ� ������Ű�� ����.
		               
	


		
		int s= 0;
		for(int i=0;i<args.length; i++){
			s+=args[i];
			
		}
		 return s;
		 
		 
	}
	
	public static void main(String[] args){
		
		Test8 ob =new Test8();
		
		int result;
		
		result = ob.sum(2,4,6,8,10);
		
		System.out.println(result);
		
		result = ob.sum(1,3,5,7,9,11,13,15,17,19);
		System.out.println(result);
		
		
	}

}
