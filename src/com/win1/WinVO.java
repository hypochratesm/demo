package com.win1;// ->Record�� �Ȱ��� ����

//��Ʈ
//�⺻ - 3������ 4���� Ŭ������ ���α׷��� ����� ���� �⺻�̴�.

public class WinVO {//Value Object -> ���� �����ϴ� ����� -> DTO
	//Dao
	//���������ڸ� �����ϸ� protected��.// ���� ��Ű�� �ȿ��� ��� Ŭ������ ��� �� �� �ִ�.
	//������ ������ private�� ������ش�.
	//ScoreVO�� �θ�� ������Ʈ��.
	
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
    		this.grd="1���";
    		
    	}else if(tot>30){
    		
    		this.grd="2���";
    		
    	}else if(tot>20){
    		
    		this.grd="3���";
    			
        }else{
        	
    		this.grd="4���";
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
