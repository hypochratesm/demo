package com.win1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import com.score3.ScoreVO;
import com.win.Board;
import com.win.Win;

public class WinImpl implements Win1{

	private ArrayList<WinVO> lists = new ArrayList<WinVO>();
	
	Scanner sc = new Scanner(System.in);
    
	@Override
	public int input() {
	    int setRing=0;
	    int setBull=0;
	    int setEye=0;
	    int setTripe=0;
		int result = 0;//초기화
      	
      
			
			WinVO vo = new WinVO();
			
			
			System.out.println("이름?");	
			vo.setName(sc.next());
		
			System.out.println("1점?");	
			vo.setRing(sc.nextInt());
			
			System.out.println("2점?");	
			vo.setBull(sc.nextInt());
			
			System.out.println("3점?");	
			vo.setEye(sc.nextInt());
			

			System.out.println("4점?");	
		    vo.setTripe(sc.nextInt());
		    
		    
		    
		    int tot = (vo.getRing()*1)+(vo.getBull()*2)+(vo.getEye()*3)+(vo.getTripe()*4);
		    
		    System.out.printf("총점:"+"%2d\n",tot);
		   
		    
		
		   int grd =0;
		   
	        if(tot>40){
	    		grd=1;
	    		
	    	}else if(tot>30){
	    		
	    		grd=2;
	    		
	    	}else if(tot>20){
	    		
	    		grd=3;
	    			
	        }else{
	        	
	    		grd=4;
	    	}
		
	        System.out.printf("등급:"+"%2d\n",grd);
			
		    lists.add(vo);
		  
		    return 0;
			
	}


	@Override
	public void print() {
		
		Iterator<WinVO> it = lists.iterator();
		System.out.printf(" %5s %2s %2s %2s %2s %2s %2s\n" , "이름","1점","2점","3점","4점","총점","등급");
		System.out.println("---------------------------------------");
		
		
		while(it.hasNext()){
			
			WinVO vo = it.next();
			System.out.println(vo.toString());
		
			
			
		}
		
	}
		
	


	
	@Override
	public void searchName() {//검색할 이름이 무엇인지 물어봐야한다.
		
		System.out.println("이름");
		 String name = sc.next();
		 
		 Iterator<WinVO> it = lists.iterator();
			
			while(it.hasNext()){
				
		      WinVO vo = it.next();
				  
			   if(vo.getName().equals(name)){
				   
			     System.out.println(vo.toString());
			           //끝까지 돌아야 한다. 이름이 겹칠수도 있기 때문에
		        }
		  }
	}


	@Override
	public void descSortTot() {//내림차순 정렬
		
		Comparator<WinVO> comp = new Comparator<WinVO>() {

			@Override
			public int compare(WinVO vo1, WinVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1;
			}//<내림차순     >오름차순  ->숫자이기 때문에 부등호로 변환한다.
			
		};
		
		Collections.sort(lists, comp);
		
		print();//그대로 호출해준다.
		
	  }


	@Override
	public void ascSortank() {//올림차순 정렬
		Comparator<WinVO> comp = new Comparator<WinVO>() {

			@Override
			public int compare(WinVO vo1, WinVO vo2) {
				return  vo1.getGrd()>vo2.getGrd()?1:-1;
			}//<내림차순     >오름차순  ->숫자이기 때문에 부등호로 변환한다.
			
	};
	   Collections.sort(lists, comp);//콜렉션 출력
	
	   print();
		
	}		
 }
