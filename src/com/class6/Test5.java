package com.class6;


//packing

import java.util.Scanner;

interface FruitA{
	
	String Won="��";
	
	public int getPrice();
	public String getName();//�θ�
	
	
}


interface ItemFruit extends FruitA{
	
	public String getItems();//�ڽ�
	
}

class Orange implements ItemFruit{

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "������";
	}

	@Override
	public String getItems() {
		return "����";
	}
	
	
    	
    }
    
 class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "���";
	}

	@Override
	public String getItems() {
		return "����";
	}
    	
    	
	
 } 

	


public class Test5 {
	
	public void packing(ItemFruit ob){//packing���� �Ʒ����� ���� �Ǵ� �޼ҵ� ���� ������� �����Ű�� ���ϰ� ����� �־���.
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
		
	}

	public static void main(String[] args) {
		
		/*ItemFruit ob;*/
		
		Scanner sc = new Scanner(System.in);
		
		Test5 t = new Test5();
		
		System.out.println("1.������ 2.���?");
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
