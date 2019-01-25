package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	
	
	public static String replaceAll(String str,String oldStr,String newStr){
		
		
		if(str==null)
			return null;
		
		Pattern p = Pattern.compile(oldStr);//대한
	    Matcher m = p.matcher(str);
	    
	    
	    StringBuffer sb = new StringBuffer();
	    
	    
	    while(m.find()){
	    	
	    	m.appendReplacement(sb, newStr);//大韓
	   	
	    }
	    
	    m.appendTail(sb);//꼬리부분을 붙여라 //대한 뒤의 글자까지 붙이게 해주는 역할.
	    
	    return sb.toString();

	}
	
	public static void main(String[] args) {
		
		String str = "우리나라 대한 민국 대한독립 대한의 건아...";
		
		System.out.println(str);
		
		String s = Test2.replaceAll(str, "대한", "大韓");
		
		System.out.println(s);

	}

}
