package CardGame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.xml.sax.*;
import org.w3c.dom.*;


/**
 * nothing here yet. just need to make sure it's all working
 * @author Bernard Serbinowski
 * @author Seth Zebrack
 */
public class Card {
	
	protected int[] cost=new int[4];//0 is black, 1 is grey, 2 is white, 3 is neutral
	protected boolean resourceConvertable;//can this be converted to a resource
	protected String name;//the name of the card
	protected int castTime;//how long it takes to cast this card

	public enum Type{
		SUMMON, DIRECT, TERRAIN, BUFF;//place holder but like will probably be changed later or something
	}
	
	protected Type type;
	
	public Card(String nameOf){
		name=nameOf;
		try{
		initializeFromFile();
		}catch(CardNotFoundException e){System.out.println("whoops");};
	}
	public Type getType(){
		return type;
	}
	private void setType(String s) throws CardNotFoundException{
		switch(s){
		case "SUMMON":
			type=Type.SUMMON;
			break;
		case "BUFF":
			type=Type.BUFF;
			break;
		case "DIRECT":
			type=Type.DIRECT;
			break;
		case "TERRAIN":
			type=Type.TERRAIN;
			break;
		default:
			throw new CardNotFoundException("attempted to set type as: "+s);
		}
	}
	public int[] getCost(){
		return cost;
	}
	public boolean getResourceConvertable(){
		return resourceConvertable;
	}
	public String getName(){
		return name;
	}
	public int getCastTime(){
		return castTime;
	}
	public boolean equals(Object c){
		if(c==null){
			return false;
		}
		Card o;
		try{
			o=(Card)c;
		}catch(ClassCastException e){ return false;}
		if(o.name.equals(this.name)){
			return true;
		}
		return false;
	}
	public void getRules(){
		
	}
	private String role1 = null;
	private String role2 = null;
	private String role3 = null;
	private String role4 = null;
	private ArrayList<String> rolev;
	private void initializeFromFile1(){
	        rolev = new ArrayList<String>();
			String xml="D:/repositories/GameMain/CardGame/src/CardGame/cardData.xml";
	        Document dom;
	        // Make an  instance of the DocumentBuilderFactory
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        try {
	            // use the factory to take an instance of the document builder
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            // parse using the builder to get the DOM mapping of the    
	            // XML file
	            dom = db.parse(xml);

	            Element doc = dom.getDocumentElement();
	            //dom.
	            role1 = getTextValue(role1, doc, "role1");
	            if (role1 != null) {
	                if (!role1.isEmpty())
	                    rolev.add(role1);
	            }
	            role2 = getTextValue(role2, doc, "role2");
	            if (role2 != null) {
	                if (!role2.isEmpty())
	                    rolev.add(role2);
	            }
	            role3 = getTextValue(role3, doc, "role3");
	            if (role3 != null) {
	                if (!role3.isEmpty())
	                    rolev.add(role3);
	            }
	            role4 = getTextValue(role4, doc, "role4");
	            if ( role4 != null) {
	                if (!role4.isEmpty())
	                    rolev.add(role4);
	            }
	            //return true;

	        } catch (ParserConfigurationException pce) {
	            System.out.println(pce.getMessage());
	        } catch (SAXException se) {
	            System.out.println(se.getMessage());
	        } catch (IOException ioe) {
	            System.err.println(ioe.getMessage());
	        }

	       // return false;
	}
	private void initializeFromFile() throws CardNotFoundException{
        rolev = new ArrayList<String>();
		String xml="D:/repositories/GameMain/CardGame/src/CardGame/cardData.xml";
		//String xml="D:/repositories/GameMain/CardGame/src/CardGame/roles.xml";
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();
           
            NodeList listN=doc.getChildNodes();
            Node n;
            boolean found=false;
            for(int count=0; count <listN.getLength(); count++){
            	if(listN.item(count).getNodeType()== Node.ELEMENT_NODE){
            		if(listN.item(count).getAttributes().item(0).toString().equals("id="+"\""+name+"\"")){
            			//System.out.print("+++++");
            			n=listN.item(count);
                        listN=n.getChildNodes();
            			found=true;
            			break;
            		}
            		//System.out.print(listN.item(count).getAttributes().item(0).toString());
            		//System.out.print("-------------");
            		//System.out.println("id="+name);
            	}
            }
            if(!found){
            	throw new CardNotFoundException("this card: "+name+" could not be found");
            }
            for(int count=0; count <listN.getLength(); count++){
            	n=listN.item(count);
            	if(n.getNodeType()== Node.ELEMENT_NODE){
            		String temp=n.getNodeName();
            		switch(temp){
	            		case "cardType":
	            		{
	            			setType(n.getFirstChild().getNodeName());
	            			break;
	            		}
	            		case "castTime":
	            		{
	            			try{
	            				castTime=(int)Integer.parseInt(n.getFirstChild().getNodeName());
	            			}catch(ClassCastException e){throw new CardNotFoundException("Failed cast time: "+n.getFirstChild().getNodeName());}
	            			catch(NumberFormatException e){throw new CardNotFoundException("Failed cast time: "+n.getFirstChild().getNodeName());}
	            			break;
	            		}
	            		case "resource":
	            		{
	            			
	            			break;
	            		}
	            		case "costB":
	            		{
	            			break;
	            		}
	            		case "costW":
	            		{
	            			break;
	            		}
	            		case "costG":
	            		{
	            			break;
	            		}
	            		case "costN":
	            		{
	            			break;
	            		}
	            		default:
	            			throw new CardNotFoundException("this card: "+name+" had weird things in the XML file");
	            			
            		}
            		//System.out.print(listN.item(count).getAttributes().item(0).toString());
            		//System.out.print("-------------");
            		//System.out.println("id="+name);
            	}
            }
            /*
            NodeList n1=doc.getChildNodes();
            NodeList n2=n1.item(0).getChildNodes();
            NodeList n3=n1.item(1).getChildNodes();
            for(int a=0;a<n1.getLength(); a++){
            	if(n1.item(a).getNodeType()== Node.ELEMENT_NODE){
                	System.out.print(n1.item(a).getNodeName()+";;;;;");
                	System.out.println(n1.item(a).getAttributes().item(0).toString());
            		
            	}
            }
            System.out.println("_++++++++++++++++++++++++");
            for(int a=0;a<n3.getLength(); a++){
            	if(n3.item(a).getNodeType()== Node.ELEMENT_NODE){
                	System.out.print(n3.item(a).getNodeName()+";;;;;");
                	System.out.println(n3.item(a).getChildNodes().item(0));
            		
            	}
            }
            System.out.println("_++++++++++++++++++++++++");
            */

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

       // return false;
}
	private String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
}
