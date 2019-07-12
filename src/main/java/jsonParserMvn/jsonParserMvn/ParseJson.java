package jsonParserMvn.jsonParserMvn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJson 
{
    public static void main( String[] args )
    {
    	JSONParser parser = new JSONParser();
    		
    	try
    	{
    		Object obj = parser.parse(new FileReader("plans.json"));
    		JSONObject jsonObject = (JSONObject) obj;
    		
    		String pid = (String) jsonObject.get("planId");
    		String pname = (String) jsonObject.get("planName");
    		String price = (String) jsonObject.get("planPrice");
    		String pdesc = (String) jsonObject.get("planDesc");
    		String pstat = (String) jsonObject.get("planStatus");
    		
    		//Loop array
    		JSONArray smsArray = (JSONArray) jsonObject.get("smsPlans");
    		JSONArray dataArray = (JSONArray) jsonObject.get("dataPlans");
    		Iterator<String> it1 = smsArray.iterator();
    		Iterator<String> it2 = dataArray.iterator();
    		
    		while(it1.hasNext()) {
    			System.out.println("smsPlans : " + it1.next());
    			System.out.println("planId : " + pid + "\nplanName : " + pname + "\nplanPrice : " + price + "\nplanDesc : " + pdesc + "\nplanStatus : " + pstat);
    		}
    		
    		while(it2.hasNext()) {
    			System.out.println("dataPlans : " + it2.next());
    			System.out.println("planId : " + pid + "\nplanName : " + pname + "\nplanPrice : " + price + "\nplanDesc : " + pdesc + "\nplanStatus : " + pstat);
    		}
    	}	
    	
    	catch(FileNotFoundException e) {
    		e.printStackTrace();	
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	catch(ParseException e) {
    		e.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
}
