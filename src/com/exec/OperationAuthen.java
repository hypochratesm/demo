package com.exec;

public class OperationAuthen {
	
	public void inputForm(String str) throws MyException{
		
		String temp[] = str.split(",");//10,20
		
		
		if(temp.length!=2){
			
			throw new MyException("���� �Է� ���� ����!:" + str);//�޼ҵ� ����
			
			
		}
		
	}
	
	@SuppressWarnings("unused")//������� �ʴ� �޼ҵ忡 ���ؼ� �����޽����� ������ ���ƶ�.
	
	//������̼� - ����Ǿ� �ִ� ���α׷�
	public void number(String str) throws MyException{
		
		
		try {
			
			if(str.indexOf(".")!=-1){//�Ǽ�
				
				double num = Double.parseDouble(str);
			}else{ 
				int num = Integer.parseInt(str);
				
			}
			
			
			
		} catch (Exception e) {
		   
			
			throw new MyException("���ں�ȯ �Ұ�!:" + str);
		}
		
	}
	public void operator(char ch) throws MyException{
		
		switch(ch){//���ٷε� ���� �ִ�.
		/*case '+':case '-':case '*':case '/':*/
		case '+':
		case '-':
		case '*':
		case '/':
			return;
			default:
				
				throw new MyException("������ ����!:" + ch);
			
		}
	}

	public void operator(String str) {
	}

}
