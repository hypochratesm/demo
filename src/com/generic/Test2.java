package com.generic;//���ʸ��� ��︸ �ص���...

class Box2<T>{
	
	
    private T t;

    public void set (T t){
	
	 this.t = t;
    }
	
    public T get(){
	  
	  return t;
     }
	public<U> void print(U u){//�޼ҵ忡���� ���
		
	 System.out.println(u);//upcast?
	 System.out.println("tŬ����:" + t.getClass().getName());
	 System.out.println("uŬ����:" + t.getClass().getName());
		
	}
}
		
	
	





public class Test2 {

	public static void main(String[] args) {
		
		Box2<Integer> b = new Box2<Integer>();
		
		b.set(new Integer(30));
		b.print("test");
		b.print(50);

	}

}
