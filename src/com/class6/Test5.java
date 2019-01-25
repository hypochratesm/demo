package com.class6;


//packing

import java.util.Scanner;

interface FruitA{
	
	String Won="원";
	
	public int getPrice();
	public String getName();//부모
	
	
}


interface ItemFruit extends FruitA{
	
	public String getItems();//자식
	
}

class Orange implements ItemFruit{

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "오렌지";
	}

	@Override
	public String getItems() {
		return "과일";
	}
	
	
    	
    }
    
 class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "사과";
	}

	@Override
	public String getItems() {
		return "과일";
	}
    	
    	
	
 } 

	


public class Test5 {
	
	public void packing(ItemFruit ob){//packing으로 아래에서 진행 되는 메소드 들을 압축시켜 실행시키기 편하게 만들어 주었다.
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
		
	}

	public static void main(String[] args) {
		
		/*ItemFruit ob;*/
		
		Scanner sc = new Scanner(System.in);
		
		Test5 t = new Test5();
		
		System.out.println("1.오렌지 2.사과?");
		int n =sc.nextInt();
		
		if(n==1){
			t.packing(new Orange());
			
		}else if(n==2){
			t.packing(new Apple());
		}
		
		
		/*ob =new Orange();
		
		 packing();
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
		
		
		ob = new Apple();
		
		 packing();
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
		
		int a;
		
		a = 10;
		System.out.println(a);
		
		a = 20;
		System.out.println(a);*/
		
	}

}
