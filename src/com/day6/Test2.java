package com.day6;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args){
		
	//�ֹι�ȣ �˻�
	//index : 01234567890123
    //jumin : 941231-2053128
    //check : 234567 892345(üũ��)
		
	//�� = (9*2)+(4*3)+...+(2*5)
	//�� = 11-��%11
	//�� = ��%10
    //�� ==8
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i,tot,su;
		
		System.out.print("�ֹι�ȣ[xxxxxx-xxxxxxx]?:");
		str = sc.next();
		
		if(str.length()!=14){//�迭�� �������� ��ȣ�� ����
			
			System.out.println("�Է¿���!!");
		    return;//main�޼ҵ带 ��������(stop)//��������� �ϰ� ������ ������! ��� ��
		    
		    
		}
		
		tot = 0;
		for(i=0;i<12;i++){//tot��� �׸��� �ϳ���.
			
			if(i>=6){//���ڸ��� ���ϴ� ��
				tot+=chk[i]*
				Integer.parseInt(str.substring(i+1 , i+2));//string���� ���� ���� ������ ���ڴ�.
				
			}else{//�������
				tot+=chk[i]*
				Integer.parseInt(str.substring(i , i+1));//0�������� 0����/ ���꽺Ʈ���� �ݵ�� -1�� ���־�� �ϱ� ������ +1�� ���ش�.
			}
		}
		
	    su = 11 - tot %11;
	    su = su%10;
	    
	    if(su==Integer.parseInt(str.substring(13))){
	    	System.out.println("��Ȯ�� �ֹι�ȣ!!");
	    }else{
	    	System.out.println("Ʋ�� �ֹι�ȣ!!");
	    }
	}
	
	

}



/*//�ֹι�ȣ �˻�

		String str = "seoul korea";//string�� ���ڸ� �����ϴ� �ڷ��������� Ŭ������.
		//            01234567890
		
		System.out.println(str.substring(0,3));//seo
		System.out.println(str.substring(6,8));
		System.out.println(str.substring(6));//���꽺Ʈ���� ���ڿ��� �����ϴ� ��//���� ���ϴ� ������ �����س���....*/