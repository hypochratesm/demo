package com.score1;

import java.util.Scanner;

public class Score {

	Scanner sc = new Scanner(System.in);

	int inwon;//�ʱⰪ�� STRING�� null�� ����.//�ڷ����� int ������ �ϳ��� ���� �� �ִ�.//�迭
	Record[] rec;//class�� �ʱⰪ�� ������ 0�� ����.
	/*Record rec;//�ڷ����� record, �� 7���� �����͸� ���� �� �ִ�.//record[] �Ȱ��� �迭 3���� �����ȴ�. record���� ���� �ȴ�.(����������
	//7���� �����͸� ���� �� �ִ�.)
	//�迭�ȿ� Ŭ������ ��������� ���� ������ ���� ���� ������ �����ų �� �ִ�.
	 */	

	public void set(){

		
		do{
			System.out.print("�ο���?:");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		


		rec = new Record[inwon];//�迭�� ��ü�� ����
	}

	public void  input(){

		String[] title = {"����?","����?","����?"};

		for(int i=0;i<inwon;i++){

			rec[i] = new Record();////�迭�� ��ü�� ����//for���� �ȿ��� ���־�� ��.

			System.out.print((i+1)+ "��° �̸�?");
			rec[i].name = sc.next();

			for(int j=0;j<3;j++){
				System.out.print(title[j]);
				rec[i].score[j] = sc.nextInt();//������

				rec[i].tot += rec[i].score[j];//for���� 3�� ���� ���� tot�� ������ �� ���� ���̴�.

			} 

			rec[i].ave = rec[i].tot/3;//���

		}	
	}

	private void ranking(){//��������//�޼ҵ忡�� �޼ҵ带 ȣ���� �� �ִ�.

		int i,j;
		for(i=0;i<inwon;i++){
			rec[i].rank = 1;
		}
		
		for(i=0;i<inwon-1;i++){
			for(j=i+1;j<inwon;j++){

				if(rec[i].tot > rec[j].tot ){
					rec[j].rank++;
					
				}else if(rec[i].tot<rec[j].tot){
					rec[i].rank++;
				}
			}
		}




	}
	public void print(){
		
		ranking();

		for(int i=0; i<inwon;i++){
			System.out.printf("%6s",rec[i].name);

			for(int j=0;j<3;j++){
				System.out.printf("%4d",rec[i].score[j]);	
			}

			System.out.printf("%4d",rec[i].tot);
			System.out.printf("%4d",rec[i].ave);
			System.out.printf("%4d\n",rec[i].rank);

		}
	}









}	

