package com.day2;

import java.io.*;

class Test2 {





	public static void main(String[] args)  throws IOException{


		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));


			int num1,num2;

			System.out.print("ù��° ��?");
			num1 = Integer.parseInt(br.readLine());

			System.out.print("�ι�° ��?");
			num2 = Integer.parseInt(br.readLine());

				//�׻� �鿩���� ����⸦ ���� �־�� �Ѵ�.

		    
	System.out.printf("%d + %d = %d\t", num1, num2,(num1+num2));
	System.out.printf("%d - %d = %d\n", num1, num2,(num1-num2));
	System.out.printf("%d * %d = %d\n", num1, num2,(num1*num2));
	System.out.printf("%d / %d = %d\t", num1, num2,(num1/num2));
	System.out.printf("%d %% %d = %d\n", num1, num2,(num1%num2));
	//���� ���ϱ� ������ �������� ����.
	//�������� ���ϴ� ���� %�̴�.
	//������ ���� ����ϱ� ���ؼ��� %%�� ��ȣ�� ����Ѵ�. �ѹ� ���� ȥ���� ���� ���� �ֱ⶧����
	// %% �� ���� ��߸� %d�� �����ɼ� �ִ�.
	

    //���ڸ� ��ȣ�� �ε�ȣ�� ���ϸ� true�� false�� �����ȴ�.
	//������ true�� false��� ���ڰ� �����Ǵ� ���̴�.
	System.out.println("num1>num2 : "+(num1>num2));
	System.out.println("num1<num2 : "+(num1<num2));
	//true, false�� ���´�.

	//String str = "������";
	//str ���ڸ� ���� �� �� �ִ� ����, �ȿ��� ������ ���� �� �ִ�.
	
	String str;

	//���׿�����

	str = num1%2==0?"¦��" : "Ȧ��";  // ���� ��ȣ�� �ι����� ������ ��Ÿ����.//==�� ���� ��¶�

	// ������ �����Ѵ� : ���ڸ� ��ȣ�� �ε�ȣ�� ���Ѵ�. -> true�̸� ¦�� false�̸� Ȧ�� ��� ������ ����� ����Ѵ�.

	str = num1>0?"���":(num1<0?"����":"��");

	str = num1%4==0 && num1%100!=0 || num1%400==0? "����":"���";

	//a &&(and) b a�� b�� �����ؾ� ��ü������ true�� �ȴ�. ��ü ������ true�� ���� �ʴ´ٸ� false�� �ȴ�. and�� �ΰ��� ������ true���� �Ѵ�.
	//a||(or) b ���߿� �ϳ��� true���� �ȴ�. �Ϲ������� or�� �����Ͱ� �� ���� ���´�.
    

	//������ 4�⸶�� �ѹ��� ���� 100���� �������� �������� �ȵȴ�.

	System.out.println(str);




		
	}
}
