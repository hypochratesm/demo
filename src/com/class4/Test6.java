package com.class4;

public class Test6 {
	
	public static void main(String[] args){
		
		
		String s1 ="����,�λ�,�뱸";
		String[] ss = s1.split(",");//spilt�ؼ� �迭�� ������..//ĭ�� �����
		//����,�λ�,�뱸�� �迭�Ѵ�.
		
		for(String s : ss){
			System.out.println(s);		
		}
		String s2 = "seoul";
		String s3 = "SEOUL";
		
		System.out.println(s2.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3));//��ҹ��� ������� ���϶�.//true
		
		String s4 = "abc.def.hij";
		//           01234567890
		System.out.println(s4.indexOf("."));//3 //index�� �Ϸù�ȣ//��� �ε����� 0���� �����Ѵ�.
	    System.out.println(s4.lastIndexOf("."));//7
	    System.out.println(s4.indexOf("def"));//4
	    System.out.println(s4.indexOf("x"));//-1
	    System.out.println(s4.indexOf("x")!=-1);
	    //���۰��� 0�����̱� ������ �������� ���ڸ� ǥ���ؾ߸� �Ѵ�. ���� ����� ������
	    //-1�� ǥ�����ش�.
	    
	    String s5 = "�츮���� ���ѹα� �������� ���ѹα�";
	    String s6 = s5.replaceAll("����", "����"); 
	    System.out.println(s6);
	    
	    String s7 = "  a  b  c  ";//������ ���� enter���� �ִ�.
	    System.out.println(s7);
	    System.out.println(s7.trim());//trim�� �յڿ� ������ �����ش�.
	    System.out.println(s7.replaceAll(" ", ""));
	    System.out.println(s7.replaceAll("\\s",""));//����ȭ ǥ����
	    
	    char ch = "abcdefg".charAt(2);//c
	    System.out.println(ch);//c
	    
	    System.out.println("abcdefg".startsWith("abc"));//true
	    
	    System.out.println("abcdefg".length());//�迭�� length�� ��ȣ�� ����.
	    
	    String s8 = "abcedfg";//101
	    String s9 = "abcddfg";//100
	    
	    //������ �迭
	    
	    System.out.println(s8.compareTo(s9));//1
	    System.out.println(s9.compareTo(s8));//-1
	}

}
