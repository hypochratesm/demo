package com.stream1;
//�����常 ��� �Ѿ����~
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

//RandomAcceSSFile\
//�Ϲ����� ������ ���������� data�� �о��(ī��Ʈ ����)
//RandomAccessFile�� ���ϴ� ������ �̵��ؼ� �бⰡ ����(CD)


public class Test1 {

	public static void main(String[] args) throws IOException {


		File f = File.createTempFile("imsi", "tmp");

		//tmp�� imsi������ ����� ����.

		f.deleteOnExit();

		FileOutputStream fos = new FileOutputStream(f);

		for(int i = 1;i<100; i++){
			fos.write(i);
			//�ӽ� ���Ͽ� 1���� 100���� ����Ǿ� �ִ�.
		}
		fos.close();

		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		//rw�� �а� �� �� �ִ�.

		raf.seek(30);
		//0���� ã�� ������ ���� 30�� 31�̴�.
		System.out.println("seek(30):" + raf.readByte());
		System.out.println("seek(1):" + raf.readByte());

		for(int i = 0; i <100; i++){
			raf.seek(i);
			System.out.println(raf.readByte());
          

		}
		raf.close();

	}

}
