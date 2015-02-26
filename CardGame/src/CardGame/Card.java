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
	
	private int[] cost=new int[4];//0 is black, 1 is grey, 2 is white, 3 is neutral
	private boolean resourceConvertable;//can this be converted to a resource
	private String name;//the name of the card
	private int castTime;//how long it takes to cast this card

	public enum Type{
		SUMMON, DIRECT, TERRAIN, BUFF;//place holder but like will probably be changed later or something
	}
	
	private Type type;
	
	public Card(String nameOf){
		name=nameOf;//initialize
		try{
		initializeFromFile();
		}catch(CardCreationException e){System.out.println("whoops");};//should make that better
	}
	/**
	 * 
	 * @return the enum
	 */
	public Type getType(){
		return type;
	}
	/**
	 * a helper method which just sets the type based off of a string
	 * @param s
	 * @throws CardCreationException
	 */
	private void setType(String s) throws CardCreationException{
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
			throw new CardCreationException("attempted to set type as: "+s);
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
	/**
	 * NOT YET IMPLEMENTED. NOT SURE HOW THIS WILL WORK YET
	 * probably a series of keywords?
	 */
	public void getRules(){
		
	}
	/**
	 * aight this method works
	 * not really sure how though atm
	 * @throws CardCreationException
	 */
	private void initializeFromFile() throws CardCreationException{
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
            	throw new CardCreationException("this card: "+name+" could not be found");
            }
            for(int count=0; count <listN.getLength(); count++){
            	n=listN.item(count);
            	if(n.getNodeType()== Node.ELEMENT_NODE){
            		String temp=n.getNodeName();
            		switch(temp){
	            		case "cardType":
	            		{
	            			setType(n.getChildNodes().item(0).getNodeValue());
	            			break;
	            		}
	            		case "castTime":
	            		{
	            			try{
	            				castTime=(int)Integer.parseInt(n.getFirstChild().getNodeValue());
	            			}catch(ClassCastException e){throw new CardCreationException("Failed castTime: "+n.getFirstChild().getNodeValue());}
	            			catch(NumberFormatException e){throw new CardCreationException("Failed castTime: "+n.getFirstChild().getNodeValue());}
	            			break;
	            		}
	            		case "resource":
	            		{
	            			if(n.getChildNodes().item(0).getNodeValue().equals("true")){
	            				resourceConvertable=true;
	            			}
	            			else if(n.getChildNodes().item(0).getNodeValue().equals("false")){
	            				resourceConvertable=false;
	            			}
	            			else{
	            				throw new CardCreationException("Failed resouce: "+n.getFirstChild().getNodeValue());
	            			}
	            			break;
	            		}
	            		case "costB":
	            		{
	            			try{
	            				cost[0]=(int)Integer.parseInt(n.getFirstChild().getNodeValue());
	            			}catch(ClassCastException e){throw new CardCreationException("Failed costB: "+n.getFirstChild().getNodeValue());}
	            			catch(NumberFormatException e){throw new CardCreationException("Failed costB: "+n.getFirstChild().getNodeValue());}
	            			break;
	            		}
	            		case "costG":
	            		{
	            			try{
	            				cost[1]=(int)Integer.parseInt(n.getFirstChild().getNodeValue());
	            			}catch(ClassCastException e){throw new CardCreationException("Failed costG: "+n.getFirstChild().getNodeValue());}
	            			catch(NumberFormatException e){throw new CardCreationException("Failed costG: "+n.getFirstChild().getNodeValue());}
	            			break;
	            		}
	            		case "costW":
	            		{
	            			try{
	            				cost[2]=(int)Integer.parseInt(n.getFirstChild().getNodeValue());
	            			}catch(ClassCastException e){throw new CardCreationException("Failed costW: "+n.getFirstChild().getNodeValue());}
	            			catch(NumberFormatException e){throw new CardCreationException("Failed costW: "+n.getFirstChild().getNodeValue());}
	            			break;
	            		}
	            		case "costN":
	            		{
	            			try{
	            				cost[3]=(int)Integer.parseInt(n.getFirstChild().getNodeValue());
	            			}catch(ClassCastException e){throw new CardCreationException("Failed costN: "+n.getFirstChild().getNodeValue());}
	            			catch(NumberFormatException e){throw new CardCreationException("Failed costN: "+n.getFirstChild().getNodeValue());}
	            			break;
	            		}
	            		default:
	            			throw new CardCreationException("this card: "+name+" had weird things in the XML file");
	            			
            		}
            	}
            }

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

	}
}
