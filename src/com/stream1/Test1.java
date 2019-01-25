package com.stream1;
//눈도장만 찍고 넘어가세요~
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

//RandomAcceSSFile\
//일반적인 파일은 순차적으로 data를 읽어옴(카세트 테입)
//RandomAccessFile은 원하는 곳으로 이동해서 읽기가 가능(CD)


public class Test1 {

	public static void main(String[] args) throws IOException {


		File f = File.createTempFile("imsi", "tmp");

		//tmp란 imsi파일이 만들어 졌다.

		f.deleteOnExit();

		FileOutputStream fos = new FileOutputStream(f);

		for(int i = 1;i<100; i++){
			fos.write(i);
			//임시 파일에 1부터 100까지 저장되어 있다.
		}
		fos.close();

		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		//rw는 읽고 쓸 수 있다.

		raf.seek(30);
		//0부터 찾기 때문에 실제 30은 31이다.
		System.out.println("seek(30):" + raf.readByte());
		System.out.println("seek(1):" + raf.readByte());

		for(int i = 0; i <100; i++){
			raf.seek(i);
			System.out.println(raf.readByte());
          

		}
		raf.close();

	}

}
