package referance;

class A{
	public int id;
	A(int id){
		this.id=id;
	}
	
}

public class Test1 {
	
	static void _value(int b) {
		b=2;
	}
	public static void runValue() {
		int a = 1;
		/*int b = a;
		b = 2;*/
	    _value(a);
		System.out.println("runValue."+ a);
		//int�� �����Ͱ� �����Ǿ� ���޵ǹǷ� ȣ��� �޼ҵ��� �۾��� ȣ���� �޼ҵ忡 ������ ��ġ�� �ʰ� �ִ�.
		//�̹� a��� ������ �ƴ� 1�̶� ����� �ٲ� ��
	}
	public static void runReference() {
		A a = new A(1);
		A b = a;
		b.id =2;
		System.out.println("runReference."+a.id);
	}
/*	class A{
		public int id;
		A(int id){
			this.id=id;
		}
		
	}*/
	
	static void _reference1(A b) {
		b = new A(2);
		System.out.println("_refference1." + b.id);
	}
	public static void runReference1() {
		A a = new A(1);
		_reference1(a);
		System.out.println("runReference1."+a.id);
	}
	static void _reference2(A b) {
		b.id =2;
	}
	
	public static void runReference2() {
		A a = new A(1);
		_reference2(a);
		System.out.println("runReference2."+a.id);
	}
	
	
	
	
	public static void main(String[] args) {
		runValue();
		runReference();
		runReference1();
		runReference2();
	}
}
