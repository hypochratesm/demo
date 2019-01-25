package com.seriz;

import java.io.Serializable;

public class HomeVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int score;
	private String birth;
	
	public HomeVO(String name , int score,String birth ){
		
		this.name = name;
		this.score= score;
		
		
		
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
  @Override
public String toString() {
	  
			  return name +":"+score + birth;
}


}
