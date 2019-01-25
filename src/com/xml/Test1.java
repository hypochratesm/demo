package com.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Test1 {

	public static void main(String[] args) {
		
		try {
			
			//Dom Document 객체를 생성하기 위해 팩토리 생성
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();//객체생성
			
			DocumentBuilder parser = f.newDocumentBuilder();//파서가 xml을 읽어들일 준비를 한다.
			
			//w3c는 돔객체를 관리하는 국제 기구
			
			Document xmlDOC = null;
			
			String url = "book.xml";
			
			//String url = "http://www.naver.com"
			
			if(url.indexOf("http://")!=-1){
				
				URL u = new URL(url);
				
				InputStream is = u.openStream();
				
				xmlDOC = parser.parse(is);
				
				
			}else{
				
				xmlDOC = parser.parse(url);
				
			}
					
			//root
			//Element : xml문서의 요소를 표현하기 위해 사용
			Element root = xmlDOC.getDocumentElement();
			
			System.out.println(root.getTagName());
			
			//첫번째book
			
			//Node : 각 요소를 읽고 쓰기 위해 사용
			
			Node book1 = root.getElementsByTagName("book").item(0);
			
			System.out.println(((Element)book1).getAttribute("kind"));
			
			Node title = book1.getFirstChild();
			Node title1 = title.getNextSibling();
			System.out.println(title1.getNodeName());
			
			Node title11  = title1.getFirstChild();
			
			System.out.println(title11.getNodeValue());
			
			
			
			
			
			
			
		} catch (Exception e) {
		
		}

	}

}
