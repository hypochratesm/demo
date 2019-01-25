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

public class Test3 {

	public static void main(String[] args) {
		
		
		try {
			//Dom Document 객체를 생성하기 위해 팩토리 생성
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();//객체생성
			
			DocumentBuilder parser = f.newDocumentBuilder();//파서가 xml을 읽어들일 준비를 한다.
			
			//w3c는 돔객체를 관리하는 국제 기구
			
			Document xmlDoc = null;
			
			String url = "connent.xml";
			
			//String url = "http://www.naver.com"
			
			if(url.indexOf("http://")!=-1){
				
				URL u = new URL(url);
				
				InputStream is = u.openStream();
				
				xmlDoc = parser.parse(is);
				
				
			}else{
				
				xmlDoc = parser.parse(url);
				
			}
					
			String str = "";
			String out = "";
			
			Element root = xmlDoc.getDocumentElement();
			
			//코멘트 갯수
			Node total = root.getElementsByTagName("total").item(0);
			
			str = total.getFirstChild().getNodeValue();
			System.out.println("코멘트 갯수:" + str);
			
		
			
			NodeList items = root.getElementsByTagName("connent");
			
			for(int i=0;i<items.getLength();i++){
				
				Node node = items.item(i);
				
				NodeList nodeList = node.getChildNodes();
				
				NamedNodeMap map = node.getAttributes();
				
				out = map.getNamedItem("num").getNodeValue();
				
				for(int j =0; j<nodeList.getLength();j++){
					
					Node e = nodeList.item(j);
					
					if(e.getNodeType()==Node.ELEMENT_NODE){
						
						str = e.getChildNodes().item(0).getNodeValue();
						
						out +=" " + str;
					}
					
					
					
					
				}
				
				System.out.println(out);
			}
			
			
			
			
		} catch (Exception e) {
			
		}

	}

}
