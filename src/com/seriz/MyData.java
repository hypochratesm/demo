package com.seriz;

import java.io.Serializable;

public class MyData implements Serializable{
	
	private static final long serialVersionUID = 1L;//�׳� �߰����൵ �ǰ� �����൵ �ȴ�.
	//�����Ϳ� ����ȭ�� ���ش�.
	private String name;
	private transient int score;//�������� ������ ������ �ȵǾ����� �ϴ� ����...
	//transient�� ����ϸ� ������ ���� ���� �ʴ´�.
	
	public MyData(String name, int score){
		this.name = name;
		this.score = score;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + ":" + score;
	}

}
