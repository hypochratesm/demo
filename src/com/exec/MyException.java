package com.exec;

public class MyException extends Exception{//java.lang

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//롱형태다.
	// Exception의 크기가 엄청나게 크다. 이 공간을 eclipse가 나에게 요구한다. 
	
	
	public MyException(String msg){
		
		super(msg);//Exception에 overloading된 생성자를 호출한다.
		
		
	}

}
