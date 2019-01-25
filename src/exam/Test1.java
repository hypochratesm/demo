package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Test1 extends Thread{
	@Override
	public void run() {
		int k =0;
		
		System.out.print("종결.");
		while(k<10) {
			
			System.out.print(".");
			try {
				sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			k++;
		}
		
		//스레드 종료
	}
	
	public void confirm() {
		Scanner sc = new Scanner(System.in);

		//string
		String math = null;
		String korean = null;
		String english = null;
		
		//integer
		int i =0;
		int j =0;
		
		String array [] = {math,korean,english};
		
		System.out.println(array.length);
		System.out.println("출력할 과목을 입력하시요");
			for ( i = 0; i < array.length; i++) {
				i = sc.nextInt();
			
				if (i==0) {
					System.out.println("math");
					break;
				}else if (i==1) {
					System.out.println("korean");
					break;
				}else if (i==2) {
					System.out.println("english");
					break;
				}
			}
		
		
		
		System.out.println();
		System.out.println(array.length);
		System.out.println();
		
		List<String> list = new ArrayList<>();
		
		list.add(math);
		list.add(korean);
		list.add(english);
		
		System.out.println();
		System.out.println(list.size());
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
		t1.confirm();
		t1.start();
		
	}
	
}
