package com.stream;
//�������
import java.io.IOException;
import java.io.OutputStream;

//�⺻ ����� ��Ʈ��.
//System.out
//

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;//1 ����Ʈ�� �����͸� �о���� ��ǲ �ƿ�ǲ ������
		//��¿� ������//�⺻���� �ܺ� ��¿� ��Ʈ��
		//����ͷ� ����� �ϴ� �����̱� ������ system.out�̴�.
		
		byte[] b =new byte[3];
		
		b[0] = 65;//�ƽ�Ű��
		b[1] = 97;
		b[2] = 122;
		
		
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
				
		
		os.write(b);//��Ʈ���� ����� �ϴ� �۾�//��ϵ� ������ �ƽ�Ű ������ ��µǰ� �ȴ�.
		
		os.close();//system.out�� �ݾ� ���ȴ�.
		
		System.out.println("�� ���̳�?");
				
		
	}

}
