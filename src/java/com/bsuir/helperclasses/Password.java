/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.helperclasses;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Katya Omelyashchik
 */
public class Password {

    private String password;
    private final File fXml = new File("C:\\data.xml");

    public Password() throws ParserConfigurationException, IOException, SAXException{       
            passwordread();
       
    }

    public boolean passwordCheck(String password) {
        return this.password.equals(password);
    }

    public final void passwordread() throws ParserConfigurationException, SAXException, IOException{
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder = f.newDocumentBuilder();
            Document doc = builder.parse(fXml);
            NodeList nodeLst = doc.getElementsByTagName("note");
            Node fstNode = nodeLst.item(0);
            if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elj = (Element) fstNode;
                NodeList nljx = elj.getElementsByTagName("password");
                Element eljx = (Element) nljx.item(0);
                NodeList nljxc = eljx.getChildNodes();
                password = ((Node) nljxc.item(0)).getNodeValue();
            }
        } catch (ParserConfigurationException exception) {
            String message = "ParserConfigurationException: XML parsing error";
            throw new ParserConfigurationException(message);
        } catch (SAXException exception) {            
            throw  exception;
        } catch (IOException exception) {
            String message = "IOException:Failed or interrupted I/O operations in/from xml file";
            throw new IOException(message);
        } catch (DOMException exception) {            
            throw exception;
        }
    }
}
