package exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
	
	public void fileExecption() {
		try {
			BufferedReader br  = new BufferedReader(new FileReader("나 없는 파일"));
			br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 없자나");
			
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 찾아보자");
			
			e.printStackTrace();
		}
	}
	
	public void numberExecption() {
		try {
			int k =4/0;
		} catch (ArithmeticException e) {
			System.out.println();
			System.out.println("실행불가");
			System.out.println();
		}finally {
			System.out.println("fillay는 어쨋든 실행!");
		}
	}
	public static void main(String[] args) {
	
			Test3 t3 = new Test3();
			
			t3.fileExecption();
			t3.numberExecption();
			
		
	}
	

}
