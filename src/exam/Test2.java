package exam;

import java.util.Scanner;


public class Test2 {
	
	String cf1="a";
	String cf2="b";
	
	public boolean equilize(String flag) {
		
		
		if (flag.equals(cf1)) {
			System.out.println("����");
			return false;
		}else if (flag.equals(cf2)) {
			System.out.println("����");
			return true;
		}else {
			System.out.println("����");
		return false;
		
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("���ĺ��� �Է��ϼ���");
		String flag = sc.next();
		
		Test2 t2 = new Test2();
		t2.equilize(flag);
	
		
	
	}
}
