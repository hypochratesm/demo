package exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
	
	public void fileExecption() {
		try {
			BufferedReader br  = new BufferedReader(new FileReader("�� ���� ����"));
			br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("���� ���ڳ�");
			
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ ã�ƺ���");
			
			e.printStackTrace();
		}
	}
	
	public void numberExecption() {
		try {
			int k =4/0;
		} catch (ArithmeticException e) {
			System.out.println();
			System.out.println("����Ұ�");
			System.out.println();
		}finally {
			System.out.println("fillay�� ��¶�� ����!");
		}
	}
	public static void main(String[] args) {
	
			Test3 t3 = new Test3();
			
			t3.fileExecption();
			t3.numberExecption();
			
		
	}
	

}
