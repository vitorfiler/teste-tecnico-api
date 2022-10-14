package com.testeTecnico.desafio.service;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class XmlService {

	public void validateXml( MultipartFile xml) throws ParserConfigurationException, SAXException {
		 try {
		        InputStream is = xml.getInputStream();
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document document = db.parse(is);
	            document.getDocumentElement().normalize();

	            NodeList agentList = document.getElementsByTagName("agente");
	            for (int i = 0; i < agentList.getLength(); i++) {
	            	Node cod = agentList.item(i);
	            	Element codigoAgente = (Element) cod;
	            	System.out.println("----------------------------");
	            	System.out.println("Código do agente: " + codigoAgente.getElementsByTagName("codigo").item(0).getTextContent());
	            }
	        }
	        catch(IOException e) {
	            System.out.println(e);
	        } 
	}
}
