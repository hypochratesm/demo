package com.stream;
//�������
import java.io.IOException;

//����� ��Ʈ��
//������ ����½� ��� �����͸� ���¿� �������
//�Ϸõ� �帧���� �����ϴ� ��.

//1.����Ʈ ��Ʈ��. - 1BYTE������ ������ �о��.
//System.in



public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("���ڿ� �Է�:");//abcd
		while((data = System.in.read())!=-1){//�Է��� ���ڿ��� 1����Ʈ�� �о�´�.������ ���� ���������� �ٲ��.
			//�����ڵ�� �Էµǰ� �ƽ�Ű������ �о�����
			
			// ���⼭ -1�� return�ϰ� ������� �� ����̴�.
			
			char ch = (char)data;
			System.out.println(ch);
			
	//1����Ʈ�� �о �� �����͸� ĳ���ͷ� �ٲ㼭 ����Ѵ� x5(1���� �о�� ������.)		
		}

	}

}
