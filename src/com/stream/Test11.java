package com.stream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//File Ŭ���� 
//������ ������� �Ұ���.- ������ ������� ���Ͼƿ�ǲ��Ʈ�� ��ǲƮ��Ʈ���ۿ� ����

//���� �� ������ ���� �� �� �ֵ��� ����� �������ִ� Ŭ����
//������ ���� �Ǵ� �̸����� ���� ������ �� ��쿡 ���� �� 
//������ ������ ����� �ϱ� ���� �޼ҵ�� �������� �ʴ´�.


//���� �ּҰ� uri(https://www.naver.com)
public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:\\doc\\test.txt");
		
		System.out.println("���� ����........");
		System.out.println("���ϸ�:" + f.getName());
		System.out.println("���ϱ���:" + f.length());
		System.out.println("���ϰ��:" + f.getAbsolutePath());
		System.out.println("ǥ�ذ��:" + f.getCanonicalPath());
		System.out.println("���� �� " + new Date(f.lastModified()));//date�� calendar���� �ξ� �۾� ���� ��¥�� �����ش�.
		System.out.println("���ϻ����������:" + f.getParent());
		System.out.println("�б� �Ӽ�:" + f.canRead());
		System.out.println("����Ӽ�:" + f.canWrite());
		
		
		
		//���� ���//�������//���� ���ϴ� Ư�������� ����Ѵٸ� ���� �ʾƵ� �ȴ�.
		String path = System.getProperty("user.dir");
		System.out.println("������:" + path);
		

	}

}
