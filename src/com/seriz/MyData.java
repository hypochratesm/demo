package com.seriz;

import java.io.Serializable;

public class MyData implements Serializable{
	
	private static final long serialVersionUID = 1L;//그냥 추가해줘도 되고 안해줘도 된다.
	//데이터에 직렬화를 해준다.
	private String name;
	private transient int score;//여러가지 정보중 저장이 안되었으면 하는 정보...
	//transient를 사용하면 정보가 저장 되지 않는다.
	
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
