package com.seriz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) {
	
	
	   try {
		   
		 //����ȭ
			FileOutputStream fos =new FileOutputStream("d:\\doc\\a2.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new MyData("ȫ�浿", 90));
			oos.writeObject(new MyData("�̱浿", 10));
			oos.writeObject(new MyData("�ֱ浿", 60));
			oos.writeObject(new MyData("��浿", 70));
			oos.writeObject(new MyData("�ڱ浿", 80));
			
			oos.close();
			fos.close();
			
			System.out.println("���强��!!");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
		
		
		try {
			
			//������ȭ(������ ����ȭ�� ������ �������� �۾�)
			
			FileInputStream fis = new FileInputStream("d:\\doc\\a2.txt");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			MyData ob = null;//Ŭ������ �ʱ�ȭ ��ų������ ������ null�� ��Ų��.
			
			while(true){
				
				ob=(MyData)ois.readObject();
				
				if(ob==null)
					break;
				
				System.out.println(ob.toString());
				
			}
			
			
			
			ois.close();
			fis.close();
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}

}
