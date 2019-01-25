package com.seriz;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;



public class Test2 {

	public static void main(String[] args)throws Exception {
		
		
	FileInputStream fis = new FileInputStream("d:\\doc\\a1.txt");
	
	ObjectInputStream ois = new ObjectInputStream(fis);
	
	Hashtable<String, String> hMap = (Hashtable<String, String>)ois.readObject();//downcast
	
	Iterator<String> it = hMap.keySet().iterator();
	while(it.hasNext()){
		
		String key = it.next();
		String value = hMap.get(key);
		System.out.println(key+" " + value);
		
		
	}
		
		
		

	}

}
