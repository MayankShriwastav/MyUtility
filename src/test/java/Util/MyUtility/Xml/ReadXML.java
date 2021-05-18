package Util.MyUtility.Xml;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	public static void main(String[] args) throws Exception {
		
		File xmlFile = new File("D:\\My_Projects\\MyUtility\\Data.xml");
				
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();		
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();		
		Document document = documentBuilder.parse(xmlFile);		
		NodeList list = document.getElementsByTagName("Spufys");
		
		for(int i=0; i < list.getLength() ; i++){
			Node node = list.item(i);			
				if(node.getNodeType() == Node.ELEMENT_NODE){				
					Element element = (Element) node;				
					System.out.println(element.getNodeName());			
					System.out.println("ID:	"+element.getAttribute("reagion").toString());				
					System.out.println("Name: "+element.getElementsByTagName("Name").item(0).getTextContent());								
					System.out.println("LatName: "+element.getElementsByTagName("LastName").item(0).getTextContent());
					System.out.println("BRID: "+element.getElementsByTagName("BRID").item(0).getTextContent());
					System.out.println("Company: "+element.getElementsByTagName("Company").item(0).getTextContent());
					System.out.println("Mobile: "+element.getElementsByTagName("Mobile").item(0).getTextContent());
				}			
		}
	}
}
