package com.class5;

//�߻�Ŭ����//�߻� Ŭ���� �ȿ��� �ݵ�� 1�� �̻��� �߻� �޼ҵ尡 �־�� �Ѵ�.
// 1���� �߻�޼ҵ� + �Ϲ� �޼ҵ�
//�޸��� ���� ���� Ŭ������ �̸� ����//���赵
//�޼ҵ带 ������ �ؼ� ����Ѵ�.

   abstract class ShapeClass{
	
	abstract void drow();
	
  }

   class Cir extends ShapeClass{//���⼭ ������ ������.. CIR�� ������ '������' ���־�� �Ѵ�.

	@Override
	public void drow() {
		
	System.out.println("���� �׸���...");
	}
	
   }
   class Rect extends ShapeClass{
	   
	@Override
	public void drow() {
		   System.out.println("�簢���� �׸���...");
	}
   }
   
   class Tri extends ShapeClass{

	@Override
	public void drow() {
		System.out.println("�ﰢ���� �׸���...");
		
	}
	 
	   	   
   }


public class Test7 {
	
	public static void main(String[] args){
		
	  Cir c = new Cir();
	  Rect r = new Rect();
	  Tri t = new Tri();
	  
	  c.drow();//���𰡸� �׸����� draw��� �޼ҵ带 ������ش�.
	  r.drow();
	  t.drow();
	  //Ŭ������ �̸��� Ʋ���� ���� �޼ҵ带 ����� �� �ִ�.
		
	}

}
