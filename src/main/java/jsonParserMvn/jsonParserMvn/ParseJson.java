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
    		
            JSONObject businessOp = (JSONObject) jsonObject.get("businessOutput");
            
    		//Loop array
    		JSONArray smsArray = (JSONArray) businessOp.get("smsPlans");
    		JSONArray dataArray = (JSONArray) businessOp.get("dataPlans");
    		Iterator<String> it1 = smsArray.iterator();
    		Iterator<String> it2 = dataArray.iterator();	
    		
    		String pid,pname,price,pdesc,pstat;
    		int length = smsArray.size();
    		
    		int i=0;
    		System.out.println("smsPlans : ");
    		while(it1.hasNext() && i < length) {
        		//String jsonStr =  it1.next();
    			JSONObject jsonobject = (JSONObject) smsArray.get(i++);
        		pid = (String) jsonobject.get("planId");
        		pname = (String) jsonobject.get("planName");
        		price = (String) jsonobject.get("planPrice");
        		pdesc = (String) jsonobject.get("planDesc");
        		pstat = (String) jsonobject.get("planStatus");	
    			System.out.println("planId : " + pid + "\nplanName : " + pname + "\nplanPrice : " + price + "\nplanDesc : " + pdesc + "\nplanStatus : " + pstat + "\n");
    		}
    		
    		length = dataArray.size();
    		i = 0;
			System.out.println("dataPlans : ");
    		while(it2.hasNext() && i < length) {
    			JSONObject jsonobject = (JSONObject) dataArray.get(i++);
        		pid = (String) jsonobject.get("planId");
        		pname = (String) jsonobject.get("planName");
        		price = (String) jsonobject.get("planPrice");
        		pdesc = (String) jsonobject.get("planDesc");
        		pstat = (String) jsonobject.get("planStatus");	
    			System.out.println("planId : " + pid + "\nplanName : " + pname + "\nplanPrice : " + price + "\nplanDesc : " + pdesc + "\nplanStatus : " + pstat + "\n");
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
