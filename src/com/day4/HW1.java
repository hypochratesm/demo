package com.day4;


public class HW1 {

	public static void main(String[] args) {

		//문제1 (1)+(1+2)+(1+2+3)+...+(1+2+3+...+10)
		 
		 


/*		//문제2 1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합

		int tot=0;
		int tott=0;
		int tottt=0;
		for(int i=0;i<101;i+=2){
			tot += i;
		}

		System.out.println("짝수합 : "+tot);
		
		for(int j=1;j<100;j+=2){
			tott +=j;
		}
		
		System.out.println("홀수합 : "+tott);
		
		for(int k=0;k<101;k++){
			tottt +=k;
		}

		System.out.println("총합 : "+tottt);*/
		
		
		
/*		//문제3 1-2+3-4+5-6+7-8+9-10
		
		int tot=0;
		
		for(int i=1;i<11;i++){
			if(i%2!=0){
				tot=tot+i;
			}
			else if(i%2==0){
				tot=tot-i;
			}
		}
		System.out.println("결과 : "+(tot));*/
	
		
		
/*		//문제4 1에서 100까지의 수중 3의 배수의 갯수
		
		int tot=0;
		for(int i=1;i<100;i++){
			if(i%3==0){
				tot=tot+1;
			}
		}
		System.out.println("3배수의 갯수 : "+tot);*/
		
		
		//문제5 두수를 입력받아 적은 수에서 큰수까지의 합
		
/*		Scanner sc = new Scanner(System.in);
		
		int n1,n2,temp,i;
		int tot=0;
		
		System.out.print("숫자는?");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		if(n1>n2){
			temp=n1;
			n1=n2;
			n2=temp;
		}
		
		for(i=n1;i<=n2;i++){
			tot += i;
		}
		
		
		System.out.printf("작은수 : %d, 큰수 : %d, 총합 : %d",n1,n2,tot);*/
		
	}

}
