package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test8 {
	
	public boolean fileCopy(String str1,String str2){
		
		File f = new File(str1);
		
		if(!f.exists()){//�ڵ��� ��� ������ ����ǥ�� �־���.//������ ���ٸ�...
			return false;//��ž!
			
		}
		
		try {
			
			FileInputStream fis = new FileInputStream(f);
			//f�� str1 �� �ᵵ �������.
			FileOutputStream fos = new FileOutputStream(str2);
			
		
			int data;
			byte[] buffer = new byte[1024];//buffer�� ���� �� �ִ� �������� �뷮�� �þ��.
			//�ѹ��� 1����Ʈ�� ������ ���� 1024�� ������.
			
			while((data = fis.read(buffer,0,1024))!=-1){
				//0������ ������ �ڸ����� ���ۿ��� ������ data�� �ִ� �縸ŭ �д´�.
				fos.write(buffer,0,data);
				
			}
			
			fos.close();
			fis.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
		
		
		
		
		
	}

	
	public static void main(String[] args){
		
		Test8 ob = new Test8();
		
		if(ob.fileCopy("d:\\doc\\test.text","d:\\doc\\out3.txt")){
		System.out.println("���Ϻ��� ����");
		
		}else{
			System.out.println("���� ���� ����");
			
		}
	

			
		
		
		
		
	}
}
