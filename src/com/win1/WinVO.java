package com.win1;// ->Record와 똑같은 역할

//다트
//기본 - 3개에서 4개의 클래스로 프로그램을 만드는 것이 기본이다.

public class WinVO {//Value Object -> 값을 저장하는 저장소 -> DTO
	//Dao
	//접근지정자를 생략하면 protected다.// 같은 패키지 안에서 모든 클래스가 사용 할 수 있다.
	//변수는 무조건 private로 만들어준다.
	//ScoreVO의 부모는 오브젝트다.
	
	private String name;
	
    private String grd;
	private int ring;
	private int bull;
	private int eye;
	private int tripe;
	
	
	 
	
	
	
	    
	 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRing() {
		return ring;
	}
	public void setRing(int ring) {
		this.ring = ring;
	}
	public int getBull() {
		return bull;
	}
	public void setBull(int bull) {
		this.bull = bull;
	}
	public int getEye() {
		return eye;
	}
	public void setEye(int eye) {
		this.eye = eye;
	}
	public int getTripe() {
		return tripe;
	}
	public void setTripe(int tripe) {
		this.tripe = tripe;
	}
   
	public int getTot() {
		return (ring*1)+(bull*2)+(eye*3)+(tripe*4);
	}
	public int getGrd(){
	    return tripe;
	}   
    public void setGrd(String grd) {
    	
    	if(tot>40){
    		this.grd="1등급";
    		
    	}else if(tot>30){
    		
    		this.grd="2등급";
    		
    	}else if(tot>20){
    		
    		this.grd="3등급";
    			
        }else{
        	
    		this.grd="4등급";
    	}
    	
    }

	 int tot = (getRing()*1)+(getBull()*2)+(getEye()*3)+(getTripe()*4);
	 int hap = ring+bull+eye+tripe;
    
		 
	


	@Override
	public String toString() {
		    
		if(name==null)
			 return null;
	
			
		
	
		
		 String str = String.format(" %6s %3d %3d %3d %3d %3d %3s " ,
				name,ring,bull,eye,tripe,getTot(),grd);
	
		return str;
		
		
	}
	
	
	
	
	

}
