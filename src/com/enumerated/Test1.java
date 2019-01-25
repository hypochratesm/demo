package com.enumerated;

//enum�� �������̶�� �θ���.
//�������� ���� ������ ������� �����̶�� �� �� �ִ�
//enum�� class interface�� ������ ������ ������ ������. ������ enum�� ��ǻ� class�̴�. ���Ǹ� ���ؼ� enum���� ���� ������ ������ 
//������ �ֱ� ������ �����ϱ� ���ؼ� enum�̶�� Ű���带 ����ϴ� ���̴�.

enum Fruit {
	APPLE("red"), PEACH("pink"), BANANA("yellow");
	private String color;
	
	
	Fruit(String color){
		System.out.println("call constructor " + this);
		this.color = color;
	}
	String getColor() {
		return this.color;
	}
	
	
	
	//Call Constructor�� ��µ� ���� �����ڰ� Fruit�� ȣ��Ǿ����� �ǹ��Ѵ�. �̰��� 3�� ȣ��Ǿ��ٴ� ���� �ʵ���
	//���ڸ�ŭ ȣ��Ǿ��ٴ� ���̴�. �� enum�� �����ڸ� ���� �� �ִ�.
/*	public Fruit(){
		System.out.println("call constructor " + this);
	}
*/}

	//enum�� �����ڰ� ���������ڸ� private���� ����Ѵ�. ���п� fruit�� ���� ������ �� ����.

enum Company {
	GOOGLE, APPLE, ORACLE;
}

public class Test1 {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		if (Fruit.APPLE.equals(Company.APPLE)) {
			System.out.println("���� ���ð� ȸ������� ����");
		}else {
			System.out.println();
			System.out.println("not");
			System.out.println();
			System.out.println();
			
		}
		/*
		 * if (Fruit.APPLE == Company.APPLE) { System.out.println("���� ���ð� ȸ������� ����"); }
		 */

		Fruit type = Fruit.PEACH;
		switch (type) {
		case APPLE:
			System.out.println(57 + "Kcal" + ","+Fruit.APPLE.getColor());
			break;
		case PEACH:
			System.out.println(34 + "Kcal" + "," + Fruit.PEACH.getColor());
			break;
		case BANANA:
			System.out.println(93 + "Kcal" + "," + Fruit.BANANA.getColor());
			break;
		}
		
		for (Fruit f :Fruit.values() ) {
			System.out.println(f+","+f.getColor());
		}
	}
	//�������� Ư���� �����غ���.
	//�������� ������ ������ �����Ѵ�. �� �� ������ ������� �ʵ��� �����Ѵ�. 
	//�Ӹ� �ƴ϶� ������ ��ü�� Ŭ�����̱� ������ ������ ���ο� ������, �ʵ�, �޼ҵ带 ���� �� �־ �ܼ��� ����� �ƴ϶� �� ���� ������ �� �� �ִ�.

}
