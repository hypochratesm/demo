package com.stream;
//�ݵ�� �������
import java.io.FileInputStream;

//���ϳ��� �����
//FileInputStream
//FileOutputStream
//������ ������ �о���� ����̴�.

public class Test5 {

	public static void main(String[] args) {
		
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test2.txt");//��ü������ �ɶ� ������ �о�;߸� �Ѵ�.
			
			//���Ͽ� �ִ� ������ ������ �ͼ� ����� �Ѵ�.
			
			//ms�� �ѱ��� �о�� �� ����. �̵��� �׵��� ������ ������� �����͸� ���� �ϱ� ������ ȣȯ ���� �ʴ´�.
			
			int data;
		
			while((data=fis.read())!=-1){
				
				
				
				//System.out.print((char)data);
				
				System.out.write(data);
				
				
				//������ ��Ŷ�� ���� ���� �ʴ´�.
				
			    System.out.flush();
			    //������ ��Ŷ�� ���Ϸ� �о�´�.
				
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
		

	}

}
