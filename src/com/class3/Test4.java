package com.class3;

//�Ǻθ� �Լ�
//������ �ҽ��� ��������
//������ ó���ӵ��� ����(stack ������ �����͸� �����ߴٰ� ����ϱ� ������)

/*public void print(int n) {
if(n>1)
 print(n-1); // �Ǻθ�
System.out.print(n+"  ");
*/

public class Test4 {
	
	public void print(int n){
		
		
		if(n!=1){//�ڱ� �ȿ��� �ڱ� �ڽ��� ȣ���ϰ� �ȴ�.
			print(n-1);//�Ǻθ� �Լ�
		}
		
		System.out.printf("%5d",n);
	}
	
	public int sum(int n){
		
		return n>1?n+sum(n-1):n;
		
		//10+sum(9)
		//  9+sum(8)
		//       8+sum(7)
	}
	
	public int pow(int a,int b){//������ ����� �Ϳ� �ڱ��ڽ��� �θ���.
		
		return b>=1?a*pow(a, b-1):1;//pow(���� ���� �޼���)
	}
	
	public static void main(String[] args) {
		
		Test4 ob =new Test4();
		ob.print(5);
		
		System.out.println();
		
		int s = ob.sum(10);
		
		System.out.println(s);
         
		System.out.println();
		System.out.println("pow(2,10):" + ob.pow(2,10));//�ڹٿ��� �������� ���ϴ�
		
		
	}

}
