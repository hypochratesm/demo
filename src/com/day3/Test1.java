package com.day3;

import java.util.*;

class Test1  {
	
	
	
	
	public static void main(String[] args)  {

		//�ݸ�(for, while,do while)

		  Scanner sc = new Scanner(System.in);

		  int dan;


		  System.out.print("���ϴ� ��?");//
		  
		  dan= sc.nextInt();

		  //for(�ʱⰪ;�ִ밪;������;)

		  for(int i=1; i<=9;i++){//i=i+1//true�� ������ ����//���۰� ���� ��Ȯ�ϰ� �˰� ������
		  
		    //System.out.println(dan +"*"+i+ "="+(dan*i));
			System.out.printf("%d*%d=%d\n",dan,i,(dan*i));



		  
		  }
		
            System.out.println("--------------");

			//while(�ִ밪)

			int j = 0;
			
			
			//1�� �ʱ�ȭ ��Ų��//�Ϲ������� 0�� ���//��ǻ�� �ε����� ���ۺκ��� 0���� �����ϴ� ��찡 ���� ������
			//�Ϲ������� �ʱⰪ�� 0�̰� while������ �Ϲ������� =�� ���� �ʴ´�.
			//�ʱⰪ�� ���� ���α׷��� �޶��� �� �ֱ⶧���� �ʱⰪ ������ ������ �߿��ϴ�.
			//��� ������ ���� �𸦋� ����Ѵ�

			while(j<9){//j<=0 ������ ������ �ȴ�

				j++;

				System.out.printf("%d*%d=%d\n",dan,j,(dan*j));//���ѷ��� 

				//do~while(�������� �� �ִ�.);(�ݵ�� �ڿ� ���� �ݷ��� ��� ��� �Ѵ�.)
				//������ ������ ���� ����.
				//����ڰ� ������ ���𰡸� �ְų� � ���� �����ϰ� ���ؼ� �����ų���� �ƴҰ����� �Ǵ��Ҷ� do while���� �����Ѵ�.

				int k = 0;
				do{
					k++;//�̷��� �ؾ� ���⼭ �ʱⰪ�� �����ϰ� �ȴ�.//�ѹ� �����ϰ� ���۾��� �Ѵ�
					
					System.out.printf("%d*%d=%d\n",dan,k,(dan*k));


				}while(k<9);

				


			
			
			
			}
			



	}
}
