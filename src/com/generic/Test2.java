package com.generic;//제너릭은 기억만 해두자...

class Box2<T>{
	
	
    private T t;

    public void set (T t){
	
	 this.t = t;
    }
	
    public T get(){
	  
	  return t;
     }
	public<U> void print(U u){//메소드에서만 사용
		
	 System.out.println(u);//upcast?
	 System.out.println("t클래스:" + t.getClass().getName());
	 System.out.println("u클래스:" + t.getClass().getName());
		
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
