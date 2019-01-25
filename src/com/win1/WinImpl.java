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
		int result = 0;//�ʱ�ȭ
      	
      
			
			WinVO vo = new WinVO();
			
			
			System.out.println("�̸�?");	
			vo.setName(sc.next());
		
			System.out.println("1��?");	
			vo.setRing(sc.nextInt());
			
			System.out.println("2��?");	
			vo.setBull(sc.nextInt());
			
			System.out.println("3��?");	
			vo.setEye(sc.nextInt());
			

			System.out.println("4��?");	
		    vo.setTripe(sc.nextInt());
		    
		    
		    
		    int tot = (vo.getRing()*1)+(vo.getBull()*2)+(vo.getEye()*3)+(vo.getTripe()*4);
		    
		    System.out.printf("����:"+"%2d\n",tot);
		   
		    
		
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
		
	        System.out.printf("���:"+"%2d\n",grd);
			
		    lists.add(vo);
		  
		    return 0;
			
	}


	@Override
	public void print() {
		
		Iterator<WinVO> it = lists.iterator();
		System.out.printf(" %5s %2s %2s %2s %2s %2s %2s\n" , "�̸�","1��","2��","3��","4��","����","���");
		System.out.println("---------------------------------------");
		
		
		while(it.hasNext()){
			
			WinVO vo = it.next();
			System.out.println(vo.toString());
		
			
			
		}
		
	}
		
	


	
	@Override
	public void searchName() {//�˻��� �̸��� �������� ��������Ѵ�.
		
		System.out.println("�̸�");
		 String name = sc.next();
		 
		 Iterator<WinVO> it = lists.iterator();
			
			while(it.hasNext()){
				
		      WinVO vo = it.next();
				  
			   if(vo.getName().equals(name)){
				   
			     System.out.println(vo.toString());
			           //������ ���ƾ� �Ѵ�. �̸��� ��ĥ���� �ֱ� ������
		        }
		  }
	}


	@Override
	public void descSortTot() {//�������� ����
		
		Comparator<WinVO> comp = new Comparator<WinVO>() {

			@Override
			public int compare(WinVO vo1, WinVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1;
			}//<��������     >��������  ->�����̱� ������ �ε�ȣ�� ��ȯ�Ѵ�.
			
		};
		
		Collections.sort(lists, comp);
		
		print();//�״�� ȣ�����ش�.
		
	  }


	@Override
	public void ascSortank() {//�ø����� ����
		Comparator<WinVO> comp = new Comparator<WinVO>() {

			@Override
			public int compare(WinVO vo1, WinVO vo2) {
				return  vo1.getGrd()>vo2.getGrd()?1:-1;
			}//<��������     >��������  ->�����̱� ������ �ε�ȣ�� ��ȯ�Ѵ�.
			
	};
	   Collections.sort(lists, comp);//�ݷ��� ���
	
	   print();
		
	}		
 }
