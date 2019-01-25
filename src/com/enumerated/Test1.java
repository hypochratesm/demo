package com.enumerated;

//enum은 열거형이라고 부른다.
//열거형은 서로 연관된 상수들의 집합이라고 볼 수 있다
//enum은 class interface와 동급의 형식을 가지는 단위다. 하지만 enum은 사실상 class이다. 편의를 위해서 enum만을 위한 문법적 형식을 
//가지고 있기 때문에 구분하기 위해서 enum이라는 키워드를 사용하는 것이다.

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
	
	
	
	//Call Constructor가 출력된 것은 생성자가 Fruit가 호출되었음을 의미한다. 이것이 3번 호출되었다는 것은 필드의
	//숫자만큼 호출되었다는 뜻이다. 즉 enum은 생성자를 가질 수 있다.
/*	public Fruit(){
		System.out.println("call constructor " + this);
	}
*/}

	//enum은 생성자가 접근제한자를 private만을 허용한다. 덕분에 fruit를 직접 생성할 수 없다.

enum Company {
	GOOGLE, APPLE, ORACLE;
}

public class Test1 {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		if (Fruit.APPLE.equals(Company.APPLE)) {
			System.out.println("과일 애플과 회사애플은 같다");
		}else {
			System.out.println();
			System.out.println("not");
			System.out.println();
			System.out.println();
			
		}
		/*
		 * if (Fruit.APPLE == Company.APPLE) { System.out.println("과일 애플과 회사애플은 같다"); }
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
	//열거형의 특성을 정리해보자.
	//열거형은 연관된 값들을 저장한다. 또 그 값들이 변경되지 않도록 보장한다. 
	//뿐만 아니라 열거형 자체가 클래스이기 때문에 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할을 할 수 있다.

}
