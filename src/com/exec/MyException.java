package com.exec;

public class MyException extends Exception{//java.lang

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//�����´�.
	// Exception�� ũ�Ⱑ ��û���� ũ��. �� ������ eclipse�� ������ �䱸�Ѵ�. 
	
	
	public MyException(String msg){
		
		super(msg);//Exception�� overloading�� �����ڸ� ȣ���Ѵ�.
		
		
	}

}
