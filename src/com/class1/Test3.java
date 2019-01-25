package com.class1;

import java.util.Scanner;

class Hap{
	
	class Abc{}
	
	int su,sum;//�ν��Ͻ� ����(��������,instance ����)//�ʱ�ȭ ���� ������ ������ �ʱⰪ 0�� �� �ִ�.
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이런...");//100
		su=sc.nextInt();
			}
	
	
	public int cnt(){//int�� ��ȯ��//���� �Ǵ��ؼ� ��ȯ���� �ʿ��ϸ� ��ȯ���� �־��ش�.
		
		for(int i=1;i<=su;i++){
			sum+=i;
		}
		
		return sum;
	}
	//���
	public void print(int sum){
		
		System.out.println("�հ�:"+ sum);
	}
}

public class Test3 {

	public static void main(String[] args){
		
	Hap ob = new Hap();
	
	ob.input();
	int sum = ob.cnt();
	ob.print(sum);
	
	//Ŭ������ �ڷ���,���뼺,���强
	//�Ϲ������� Ŭ������ ���鶧 �������� �մ°Ͱ� ���� ���� ������ �Ѵ�.
	//ob�� ������Ʈ�� ����
	//���ϸ��� ������ �������� �ִ� ������ ������ �Ѵ�.
    //�ϳ��� ���Ͽ� ���� Ŭ������ ���� �� �ְ�, �޼ҵ� �ȿ����� ����� �ִ�.
	//���� ���� ���� ������ �Ǵ� ���� �ΰ��� �������� �ȴ�. 
	//������ javaȮ�� ���� ���� ���� �ȴ�.
	//Ŭ������ �����͸� �ִ� ����Ҷ�� �θ���.
	}

}
