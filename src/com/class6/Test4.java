package com.class6;

interface Test{
	
	public int total();
	public void write();
	
}


class TestImpl implements Test{
	
	private String hak,name;
	
	private int kor,eng;
	
	public TestImpl(){//�⺻������
	}
	
	public TestImpl(String hak, String name,int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		
	}
	
	public void set(String hak,String name, int kor , int eng ){
	this.hak = hak;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	}
	
	@Override
	public int total(){
	
		return kor+eng;
		
	}
	
	


	@Override
	public void write() {
		System.out.println(hak+":" + name + ":" + total());
	}
	
	//ob1.equals(ob2)-TestImpl -> object(upcast)
	public boolean equals(Object ob) {//upcast�� �߻��ߴ�.
		
		boolean flag = false;
		
		if(ob instanceof TestImpl){//true
			
			TestImpl t =(TestImpl)ob;//downcast �θ� �ڽ����� �ٲ�� �Ǹ鼭 downcast�� �Ͼ�� �ȴ�.
			
			if(this.hak.equals(t.hak)&&//equals�� String
					this.name.equals(t.name)){
				flag = true;
			}
			
		}
		return flag	;	
	}
	
	
	
	
}


public class Test4 {

	public static void main(String[] args) {
		
		/*TestImpl ob = new TestImpl();//1�� ���
		ob.set("1111", "�����", "60", "70");*/
		
		/*TestImpl ob1 = new TestImpl("1111", "�����", 60, 70);
		TestImpl ob2 = new TestImpl("1111", "�����", 100,100 );//2�� ���
*/		
		
		TestImpl ob1 = new TestImpl("1111", "�����", 60, 70);
		TestImpl ob2 = new TestImpl("1111", "������", 100,100 );//2�� ���
		
		/*Test ob =new TestImpl();
		ob.set("1111", "�����", 60, 70));*/
		
		if(ob1.equals(ob2))
			System.out.println("ob1�� ob2�� ���� �ι�...");
		else
			System.out.println("ob1�� ob2�� ���� �ι� �ƴ�");
		
		ob1.write();
		ob2.write();
      
	}

}
