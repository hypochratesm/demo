package com.stream;
//�������
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStramReader//�� ¦�� �ִ�.//���������� ���ϼ� ����.
//1byte�� Stream�� 2byte Stream���� ��ȯ���ִ� Stream
//�긴�� ��Ʈ�� //�������� �����°��� ��ȯ�ؼ� �Ѱ��ִ� ������ �ϱ� ������.
public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("���ڿ� �Է�:");
		
	    Reader rd = new InputStreamReader(System.in);//�о�� �����͸� �츮�� �����ϴ� ���ڷ� �ٲ㼭 rd�� �־��ش�.
	    //�о �����͸� ��� ����,������ ��� ����
	    //READER�� ���� ������ �����ϴ� �������� ����.
	    
	    
	    while((data = rd.read())!=-1){
	    	
	    	char ch = (char)data;
	    	System.out.print(ch);
	    	
	    	//�����ϰ� ���� ��� ����Ǿ� �ִ�.
	    	
	    	
	    }

	}

}
