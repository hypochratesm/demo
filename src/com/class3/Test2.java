package com.class3;

class Rect{//�簢���� ������ ���ϴ� Ŭ����
  
	
	 private int w,h;
	 
	 public Rect(){//�⺻������
		 
	 }
     public Rect(int w, int h){//�����ε��� ������
    	 this.w = w;
    	 this.h = h;
     }
	
    public void set(int w, int h ){//�ʱ�ȭ �޼ҵ�//�޼ҵ�� �ʱ�ȭ �ϴ� �۾�.
    	
    	 this.w = w;
    	 this.h = h;
    }
    
    public int area(){
    	 return w*h;
    }
    
    public int length(){
    	return(w+h)*2;
    }
	public void pront(int a){
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("����:"  + a);
	}
	
	
	public void print(int a, int l){//�޼ҵ� �����ε�//���� Ŭ���� �ȿ��� ���� ������ �ϴ� ����� Ŭ������ �̸��� ���Ͻ�Ű�°�.
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("����"  + a);
		System.out.println("�ѷ�"  + l);	
	}
}


public class Test2 {

	public static void main(String[] args) {
      
		
		Rect ob1 = new Rect();
		ob1.set(10, 20);
		
		int a = ob1.area();
		int l = ob1.length();
	    ob1.pront(a);
   		ob1.print(a, l);
   		
   		Rect ob2 = new Rect(100 , 200);
   		a= ob2.area();
   		l= ob2.length();
   		ob2.pront(a);
   		ob2.print(a, l);
   		
   		ob2.set(11, 22);
   		
   		
   		
	}
	

}
