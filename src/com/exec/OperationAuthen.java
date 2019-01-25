package com.exec;

public class OperationAuthen {
	
	public void inputForm(String str) throws MyException{
		
		String temp[] = str.split(",");//10,20
		
		
		if(temp.length!=2){
			
			throw new MyException("숫자 입력 형식 오류!:" + str);//메소드 생성
			
			
		}
		
	}
	
	@SuppressWarnings("unused")//사용하지 않는 메소드에 한해서 에러메시지를 보이지 말아라.
	
	//어노테이션 - 내장되어 있는 프로그램
	public void number(String str) throws MyException{
		
		
		try {
			
			if(str.indexOf(".")!=-1){//실수
				
				double num = Double.parseDouble(str);
			}else{ 
				int num = Integer.parseInt(str);
				
			}
			
			
			
		} catch (Exception e) {
		   
			
			throw new MyException("숫자변환 불가!:" + str);
		}
		
	}
	public void operator(char ch) throws MyException{
		
		switch(ch){//한줄로도 쓸수 있다.
		/*case '+':case '-':case '*':case '/':*/
		case '+':
		case '-':
		case '*':
		case '/':
			return;
			default:
				
				throw new MyException("연산자 오류!:" + ch);
			
		}
	}

	public void operator(String str) {
	}

}
