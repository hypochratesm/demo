package com.stream;

import java.io.File;
import java.io.FileFilter;

//FileFilter �������̽�//Ư�� ����̺��� ���� ��ü�� ���� �༮.
//FileŬ������ listFile �޼ҵ�� ���Ϲ��� ����� 
//���� �� �� �ִ� ���� ���� ���̽��� �����accept�� �����Ѵ�.
//Ž���ⰰ�� ���α׷��� ���鶧 ����Ѵ�.

class MyFileList implements FileFilter {
	
	private File f;
	
	public MyFileList(String filePath) {//��θ� ����
		//�����ε��� ������	
		f = new File(filePath);//�����ڸ� ���� ��ü ���� -�߿�!!!
		
		//�ѹ��� �ΰ��� ��ü�� �����ߴ�.
		//������ ����(DI)
		
	}
	
	public void result(){
		
		try {
			
			
			if(!f.exists()){
				System.out.println("������ �������� �ʽ��ϴ�.");
				return;//stop
				
			}
			
			System.out.println("������:" + f.getAbsolutePath());
			System.out.println("����ũ��:" + f.length());
			
			
			//������ ���
			if(f.isDirectory()){
				
				//accept�޼ҵ忡�� FileFileter�������̽���
				//������ ����� ����
				
				File[] lists = f.listFiles(this);//������ ������ �����̶� �迭�� ��´�.
				
				System.out.println("\n������ ����...");
				for(int i = 0; i<lists.length;i++){
					
					System.out.print(lists[i].getName());
					System.out.println("\t"+lists[i].length());
				}
				
			}
			System.out.println("\n���丮 ����...");
			File[] root = File.listRoots();
			for(int i = 0; i <root.length; i++){
				
				System.out.println(root[i].getPath());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	
	
	

	@Override
	public boolean accept(File pathname) {//���ϰ� ���丮�� ���� ������ this�� �־��ִ� ������ �Ѵ�.
		return pathname.isFile()||pathname.isDirectory();//���⿡ �ִ� ���� File[]�� �ִ´�.
	}
	
	
	
}




public class Test13 {

	public static void main(String[] args) {
		
		MyFileList mf = new MyFileList("d:\\");
		mf.result();

	}

}
