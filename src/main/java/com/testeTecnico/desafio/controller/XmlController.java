package com.testeTecnico.desafio.controller;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.testeTecnico.desafio.service.XmlService;

@RestController
@RequestMapping("/xml")
public class XmlController {

	@Autowired
	private XmlService xmlService;
	
	@PostMapping
	public ResponseEntity<String> validateXml(@RequestParam("file") MultipartFile xml) throws ParserConfigurationException, SAXException{
		xmlService.validateXml(xml);
		return ResponseEntity.ok("");
	}
}
