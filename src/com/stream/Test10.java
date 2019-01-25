package com.stream;

import java.io.FileOutputStream;
import java.io.PrintStream;


public class Test10 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos;
			PrintStream ps;
			
			fos = new FileOutputStream("d:\\doc\\out5.txt");
			ps =  new PrintStream(fos);
			
			ps.println("배수지");
			ps.println("한지혜");
			ps.println("천송이");
			ps.println("티파니");
			
			ps.close();
			fos.close();
			
			
			//true//append(추가 누적)
			fos = new FileOutputStream("d:\\doc\\out5.txt",true);
			ps = new PrintStream(fos);
			//웹에서는 PrintWriter도 많이 씀
			
			ps.println("김수지");
			ps.println("최지혜");
			ps.println("만송이");
			ps.println("땅파니");
			
			ps.close();
			fos.close();
			
			
		} catch (Exception e) {
			
		}

	}

}
