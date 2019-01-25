package com.class5;

abstract class SortInt {

	/*
	 * private int value;//인트값 하나를 받겠다. private int[] value;//배열값을 받겠다
	 * 
	 * compare , swap
	 * 
	 * //결과적으로 오버라이딩 된 메소드는 내 것을 사용한다. - 부모도 가지고 있고 나도 가지고 있다면 내 것을 사용한다.
	 */

	private int[] value;

	protected abstract void sorting();// 추상메소드

	public void sort(int[] value) {

		this.value = value;

		sorting();

	}

	public int length() {

		if (value == null)
			return 0;

		return value.length;

	}

	protected final int compare(int i, int j) {

		if (value[i] == value[j])
			return 0;
		else if (value[i] > value[j])
			return 1;
		else
			return -1;

	}

	protected final void swap(int i, int j) {

		int temp;

		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}

	public void print() {
		if (value == null)
			return;// 리턴 아래쪽의 코딩을 스탑한다.

		for (int n : value) {
			System.out.printf("%4d", n);
		}
		System.out.println();
	}

}

class SortTest extends SortInt {// 추상클래스를 상속 받았다.

	@Override
	protected void sorting() {

		// Selection sort
		for (int i = 0; i < length() - 1; i++) {
			for (int j = i + 1; j < length(); j++) {

				if (compare(i, j) > 0) {

					swap(i, j);

				}

			}
		}

	}

}

public class Test8 {

	public static void main(String[] args) {

		int[] value = { 56, 23, 87, 99, 12 };

		SortTest ob = new SortTest();

		ob.sort(value);

		ob.print();

	}

}
