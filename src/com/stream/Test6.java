package com.stream;


import java.io.FileOutputStream;

//���ϳ��� ���
////FileOutputStream

public class Test6 {

	public static void main(String[] args) {
		
		try {
			
			
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out.txt");
			
			//����ڰ� �Է��Ѱ��� ���Ϸ� ��������.
			
			int data;
			
			
			System.out.println("���ڿ� �Է�");
			
		    while((data=System.in.read())!=-1){
		    	
		    	
		    	fos.write(data);
		    	fos.flush();
		    }
		    
		    fos.close();//����� ���� �׻� �ݾ���� �������� ������ �߻����� �ʴ´�.
			
			
		} catch (Exception e) {
			
		}

	}

}
