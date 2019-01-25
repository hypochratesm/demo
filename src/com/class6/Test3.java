package com.class6;

//Interface
//1.�߻�Ŭ������ ���� ���� �ְ� ����(����)�� ����.
//2.final������ ���� �� �� �ִ�.
//3.�������̽��� �����ϱ� ���ؼ��� implements�� ����Ѵ�.
//4.�ϳ� �̻��� �������̽��� implements�� Ŭ������
//�������̽��� ��� �޼ҵ带 override�ؾ� �Ѵ�.//���������־�� �Ѵ�.
//5.�������̽��� �������̽��� ��ӹ��� �� ������ �̶� extends
//Ű���带 ����Ѵ�.
//6.�������̽��� ���� ����� �����ϴ�
//7.�������̽��� ������̴�//�ڹٿ����� �Ϲ�Ŭ�������� �������̽��� ����Ҹ� �� ���� ����.
//8.���������� �����ϴ�.
interface Fruit{
	
	 String Won = "��";//public static final�� ���� �Ǿ��ִ�.
	 
	 int getPrice();//public abstract����
	
	 public String getName();//���� ���ǰ� ���� ������ �̷��� ����.(abstract�� �����Ǿ� �ִ�)
	 
}

class FruitImpl implements Fruit{//FruitImpl ȸ�翡�� �������̽��� �����ߴٰ� �˷��ִ� Ŭ���� ����

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "���";
	}
	
	public String getItems(){
		
		return "����";
	}
}


public class Test3 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		//Fruit ob1 = new FruitImpl();//�θ�� ��ü�� �����Ǿ���.//�������̽��� �޼ҵ�� Ŭ������ �޼ҵ��� ������ ��������
		//�̷��� ����� �ص� ����� ����.
		
		//�׷������� Ķ������ ��� ����� ��� �ֱ� ������ ������ �߻����� �ʴ´�.
		
		System.out.println(ob1.getItems() + ":" + ob1.getName() + 
				":" + ob1.getPrice()+Fruit.Won);
        //won�� Ŭ���� �����̱� ������ ��ġ�� �˷��־�� �Ѵ�.
		
		
		Fruit ob2 = ob1;//upcast
		
		System.out.println(ob2.getName());//�θ� ������ �ְ� ���� ������ �ִٸ� �� ���� ����Ѵ�.
		
		//System.out.println(ob2.getItems());//�θ� ������ ���� �ʱ� ������ �������� �����.
		
		
		
		
	}

}
