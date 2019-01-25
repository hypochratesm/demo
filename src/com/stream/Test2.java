package com.stream;
//기억하자
import java.io.IOException;
import java.io.OutputStream;

//기본 입출력 스트림.
//System.out
//

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;//1 바이트씩 데이터를 읽어오는 인풋 아웃풋 데이터
		//출력용 파이프//기본적인 외부 출력용 스트림
		//모니터로 출력을 하는 행위이기 때문에 system.out이다.
		
		byte[] b =new byte[3];
		
		b[0] = 65;//아스키값
		b[1] = 97;
		b[2] = 122;
		
		
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
				
		
		os.write(b);//스트림에 기록을 하는 작업//기록된 정수가 아스키 값으로 출력되게 된다.
		
		os.close();//system.out을 닫아 버렸다.
		
		System.out.println("나 보이냐?");
				
		
	}

}
