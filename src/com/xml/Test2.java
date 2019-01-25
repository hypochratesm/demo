package com.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test2 {

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
			NodeList books = root.getElementsByTagName("book");
			
			
			String out = "";
			String str = "";
			
			for(int i =0;i<books.getLength();i++){
				
				Node book = books.item(i);
				str = book.getNodeName();
				
				out +="노드명:" + str;
				
				NamedNodeMap bookMap = book.getAttributes();
				
				str = bookMap.getNamedItem("kind").getNodeValue();
				
				out+=",kind:" +str;
				
				NodeList elementList = book.getChildNodes();
				
				for(int j = 0; j<elementList.getLength(); j++){
					
					
					Node e = elementList.item(j);
					
					str = "";
					
					if(e.getNodeType()==Node.ELEMENT_NODE){
						
						str = ", " + e.getNodeName();
						out +=str + ":";
						
						out += e.getChildNodes().item(0).getNodeValue();
						
					}
					
					
				}
				
				
				
				
			out+="\n";	
				
				
				
				
				
			}
			System.out.println(out);
			
			
			
			
		} catch (Exception e) {
		
		}

	}

	
}
