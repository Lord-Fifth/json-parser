package jsonParserMvn.jsonParserMvn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
