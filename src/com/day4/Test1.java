package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) throws IOException{
	
		Scanner sc = new Scanner(System.in);
	
		int num1,num2;
		char oper;
	
		System.out.print("ù��° ��?");
		num1 = sc.nextInt();
		
		System.out.print("�ι�° ��?");
		num2 = sc.nextInt();
	
		System.out.print("������[+,-,*,/]?");//+
		oper = (char)System.in.read();
		
		int result=0;
		switch(oper){
		
		/*case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println(num1/num2);
			break;
		default:
			System.out.println("�߸��� ������!");*/
		case '+':
			result = num1 + num2;
			//System.out.printf("%d+%d=%d\n",num1,num2,(num1+num2));
			break;
		case '-':
			result = num1 - num2;
			//System.out.printf("%d-%d=%d\n",num1,num2,(num1-num2));
			break;
		case '*':
			result = num1 * num2;
//			System.out.printf("%d*%d=%d\n",num1,num2,(num1*num2));
			break;
		case '/':
			result = num1 / num2;
//			System.out.printf("%d/%d=%d\n",num1,num2,(num1/num2));
			break;
		default:
			System.out.println("�߸��� ������!");
		
		}
		
		System.out.printf("%d%c%d=%d\n",num1,oper,num2,result);
		
		
		

	}
}

/*

[�ڷ���]
boolean : true/false

[����]
byte -128~127
short : 32768~32767
int : 4byte
long : 8byte

10����:10, 8����:016, 16����:0x17

[�Ǽ�]
float : 4byte
double : 8byte
�������Ǽ�(float):3.14f
�������Ǽ�(double):3.14

[����]
char : 2byte(UTF-16):'a'

[������]
+,-,*,/,%,++,--

[������������]
>,>=,<,<= : ���: true,false

[�������]
==,!=

[��������]
&&(and), ||(or), !(not)

[��Ʈ����]
&, |, ~, >>, <<, >>>

[���׿�����]
����?���϶���:�����϶���

[���Կ�����]
=,+=(���ڴ� ������ ����, ���ڴ� �̾���),-=,*=

---------------------------------------------------
int a=10;
float b;

b=a; 		//�Ͻ�������ȯ
b=(float)a; //���������ȯ

a=b;		X
a=(int)b;	O //���������ȯ

---------------------------------------------------
[���]

if(����){
�۾�1;
}


if(����){
�۾�1;
}else{
�۾�2;
}


if(����1){
�۾�1;
}else if(����2){
�۾�2;
}else{  //������ else ��������
�۾�3;
}


for(���۰�;�ִ밪;������)

while(����){// =(equal)�߾������� ���� �ε�ȣ�� ǥ��
�۾�;
}


do{
�۾�;
}while(����);


<���ѷ���>
while(true){
�۾�;
}

break;




*/		




















