package com.stream1;
//�������

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test2 {
	
	
	public final static int BUFFER_SIZE = 512;//final�� ������� ������ �빮�ڷ� ����.

	public static void main(String[] args) {
		
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out6.txt");
			
			//************Buffer�� �ѹ� �� �����ش�.//������ ũ�Ⱑ�� �ʹ� ũ�⶧���� fis�� ��� �����͸� ��Ⱑ �δ㽺����********.//�߿�
		    BufferedInputStream bis = 
		    		new BufferedInputStream(fis);
		    BufferedOutputStream bos = 
		    		new BufferedOutputStream(fos,BUFFER_SIZE);
		    //buffer size�� ������ �����ϴ� // �� ������� ������ ���̴�
		    
		    int n,len = 0;
		    while((n = bis.read(buffer))!=-1){
		    	
		    	System.out.println("���� ���� ����:" + n );
		    	len+=n;
		    	
		    	bos.write(buffer,0,n);
		    	bos.flush();
		    	
		    }
		    
		    System.out.println("�о���� ��ü ����:" + len);
		    
		    fis.close();
		    fos.close();
		    bis.close();
		    bos.close();
		    
		   
		} catch (Exception e) {
			
		}
		

	}

}