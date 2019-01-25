package com.stream;

import java.io.File;
import java.io.FileFilter;

//FileFilter 인터페이스//특정 드라이브의 내용 전체를 보는 녀석.
//File클래스의 listFile 메소드로 리턴받을 대상을 
//지정 할 수 있는 필터 인터 페이스로 대상은accept로 지정한다.
//탐색기같은 프로그램을 만들때 사용한다.

class MyFileList implements FileFilter {
	
	private File f;
	
	public MyFileList(String filePath) {//경로를 생성
		//오버로딩된 생성자	
		f = new File(filePath);//생성자를 통해 객체 생성 -중요!!!
		
		//한번에 두개의 객체를 생성했다.
		//의존성 주입(DI)
		
	}
	
	public void result(){
		
		try {
			
			
			if(!f.exists()){
				System.out.println("파일이 존재하지 않습니다.");
				return;//stop
				
			}
			
			System.out.println("절대경로:" + f.getAbsolutePath());
			System.out.println("파일크기:" + f.length());
			
			
			//폴더인 경우
			if(f.isDirectory()){
				
				//accept메소드에서 FileFileter인터페이스로
				//리턴할 대상을 지정
				
				File[] lists = f.listFiles(this);//폴더의 내용을 파일이란 배열에 담는다.
				
				System.out.println("\n폴더의 내용...");
				for(int i = 0; i<lists.length;i++){
					
					System.out.print(lists[i].getName());
					System.out.println("\t"+lists[i].length());
				}
				
			}
			System.out.println("\n디렉토리 구조...");
			File[] root = File.listRoots();
			for(int i = 0; i <root.length; i++){
				
				System.out.println(root[i].getPath());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	
	
	

	@Override
	public boolean accept(File pathname) {//파일과 디렉토리에 대한 정보를 this로 넣어주는 역할을 한다.
		return pathname.isFile()||pathname.isDirectory();//여기에 있는 값을 File[]에 넣는다.
	}
	
	
	
}




public class Test13 {

	public static void main(String[] args) {
		
		MyFileList mf = new MyFileList("d:\\");
		mf.result();

	}

}
