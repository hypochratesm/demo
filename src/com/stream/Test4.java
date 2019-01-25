package com.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//OutputStreamReader

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("문자열 입력:");
		Reader rd = new InputStreamReader(System.in);
		
		Writer wr = new OutputStreamWriter(System.out);//출력기를 하나 만든것.
		
		
		while((data=rd.read())!=-1){//rd.read
			//wr.write
			
			wr.write(data);
		    wr.flush();//화장실에 변기물이 쏟아진다는 뜻
		    //writer는 반드시 flush를 써주어야 나간다.

		}
		
		

	}

}
