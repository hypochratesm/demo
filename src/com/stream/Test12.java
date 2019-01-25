package com.stream;
//기억하자
import java.io.File;
import java.io.FileOutputStream;

public class Test12 {

	public static void main(String[] args) {


		String str = "d:\\doc\\temp\\java\\test.txt";
		//            0123456789//일련번호가 붙게 된다.

		String path = str.substring(0, str.lastIndexOf("\\"));

		//System.out.println(path);


		//방법1

		File f = new File(path);

		if(!f.exists()){
			f.mkdirs();//temp\\java//많이쓰는 것//s붙는게 중요
		}   //파일이 없으니 파일을 만들어라.


		/*	방법2
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdirs();


		}
		 */



		try {

			FileOutputStream fos = new FileOutputStream(str);
			System.out.println("문자열 입력:");

			int data;
			while((data=System.in.read())!=-1){

				fos.write(data);
				fos.flush();

			}

			fos.close();

		} catch (Exception e) {

		}




	}

}
