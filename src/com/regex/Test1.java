package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



//java.util.regex
//����ȭ ǥ����
//�ܾ�ٲٱ�,�����ּ� �˻�,���� ����� ����

/*c[a~z]* : c�� �����ϴ� ���ܾ�(c,ca,cbvf)

 * 
c[a-z] : c�� �����ϴ� �δܾ�(ca,cg)


c[a-zA-Z0-9] : ca,cA,c4


c. :c�� �����ϴ� �� ���� (ca,cB,c&)


c.* : c�� �����ϴ� ��繮��


c.*t : ct,chh7hhht,c775458777t


[b|c].* �Ǵ�[bc].* �Ǵ�[b-c].* : b,c,bbb,cad


[^b|c] �Ǵ� [^bc].* �Ǵ�[^b-c].*:b�Ǵ� c�� �������� �ʴ� ����.


.*c.*: c�� ���Ե� ���ڿ�(s45c78g)


[\\d]+�Ǵ� [0-9]+ : �ϳ��̻��� ���ڰ� ���;� �Ѵ�.









 */



public class Test1 {

	public static void main(String[] args){


		String[] str = {"bat", "baby", "bonus", "c","cA","ca","c","c0","car","combat","count","date","disc"};

		Pattern p;

		p= Pattern.compile("c[a-z]*");//�������� - c�� �����ϴ� ���ܾ�,�ڿ� �빮�ڳ� ���ڰ� �ԷµǸ� �ܾ�� �ν����� ���Ѵ�.
		for(String s : str){

			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);

			}


		}
		System.out.println("-------------------------------");

		p =Pattern.compile("c[a-z]+");//c�� �����ؼ� ���ĺ��� �� �� �̻����� �̷���� �ܾ��....
		for(String s:str){


			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);



			}

		}
		System.out.println("-------------------------------");

		p =Pattern.compile("c.");//c�� �����ϴ� �� ���� ���ڳ� �ܾ�� �̿� ������ �ʴ´�.
		for(String s:str){


			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);
		
			}
		}
		
		System.out.println("-----------");
        //����Ȯ��
		
		String[] mail = {"aaa@aaa.com","@aaa.co.kr","@bbb.com","aaa@vvv.co.kr","sss.co.kr","abc@bbb"};
		
		/*[\\w]+ : �ѱ��� �̻��� ��,����
		@
		(\\.[\\w]+) : ��ȣ�ȿ� �ִ°��� �ݵ�� �ѹ��� ����ض�
		 \\. : dot�ݵ�� ����ؾ��Ѵ�.
*/		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mail){
			
			if(Pattern.matches(pat, s))
				System.out.println(s);
			
		}
		
		
		}
	}