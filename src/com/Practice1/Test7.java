package com.Practice1;

//�Ǻθ� �Լ�
//������ �ҽ��� ��������
//������ ó�� �ӵ��� ������.(stack ������ �����͸� �����޴ٰ� ����ϱ� ������,,,,,)




public class Test7 {
	
	public void print(int n){
		
		if(n!=1){//�ڱ� �ȿ��� �ڱ� �ڽ��� ȣ���ϰ� �ȴ�.
			print(n-1);//�Ǻθ� �Լ�
		}
		
		System.out.printf("%2d",n);//1�� ���
	}

	
	public int sum(int n){
		
		 return n>1?n+sum(n-1):n;
		 
		 //10+sum(9)
		 //  9+sum(8)
		 //      8+sum(7)
	}
	
	public int pow(int a, int b){//������ ����� �Ϳ� �ڱ� �ڽ��� ����ؼ� ���� ������.
		 
		 return b>=1?a*pow(a,b-1):1;//pow(���� ���� �޼���)	
	}
	public static void main(String[] args){
		
		Test7 ob =new Test7();
		ob.print(5);
		
		System.out.println();
		
		int s = ob.sum(10);//(10+9+8+7+6+5+4+3+2+1)
		
		System.out.println(s);
		
		System.out.println();
		System.out.println("pow(2,10):" + ob.pow(2, 10));
		
	}
}