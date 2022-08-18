package com.web.taglib;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConstantXMLTag {
	public ConstantXMLTag() {
	}

	public NamedNodeMap checkConstantXML(String TagName) throws DataAccessException, Exception {
		ClassPathResource cpr = new ClassPathResource("com/web/resource/constant-data.xml");

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(cpr.getFile());

		doc.getDocumentElement().normalize();

		Element e = doc.getElementById("iconst");
		NodeList nl = e.getElementsByTagName(TagName);

		Node n = nl.item(0);
		NamedNodeMap columnAttributes = n.getAttributes();
		return columnAttributes;
	}
}
