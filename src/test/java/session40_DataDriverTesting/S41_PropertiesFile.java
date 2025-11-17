package session40_DataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class S41_PropertiesFile {

	public static void main(String[] args) throws IOException {
	
//Properties file - Some common required data which is required for our all automation test cases can be stored in properties file
		//Eg: App URL, Login creds, customer ids, order information, etc..
		// --> No syntax are applicable. Simple write using Key and Value (email=abc@gmail.com)..
		// --> Suppose we have to specify same url,login creds for all 10 Test cases, that need to be hardcoded in code. Instead of doing that we mention those in properties file
		
		
	//Read data from Properties file
		
		//Create properties class object
		Properties prop_obj = new Properties();
		
		//Specify the location
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\config.properties");
		
		//Load the properties file
		prop_obj.load(file);
		
		String url = prop_obj.getProperty("appurl");
		String email = prop_obj.getProperty("email");
		String password = prop_obj.getProperty("password");
		String orderid = prop_obj.getProperty("orderid");
		String custid = prop_obj.getProperty("customerid");
		
		System.out.println("Prop file: " + url + "\t" + email + "\t" + password + "\t" + orderid + "\t" + custid);
		
		//Reading all the keys from properties file using this method. This method collect all the keys and return a set collection. Because properties file should not have duplicate
		Set<String> keys = prop_obj.stringPropertyNames();
		System.out.println("Keys: " + keys);
		
		Set<Object> keys1 = prop_obj.keySet();
		System.out.println("Keys1: " + keys1);
		
		//Reading all the values
		Collection<Object> values = prop_obj.values(); 
		System.out.println("Values: " + values);
		
		file.close();
		
		
//Assignment
		//1 --> URL: https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator
		//2 --> clear the existing data
		//3 --> Read the data from excel and pass here
		//4 --> Click ok
		//5 --> Validate 'Your CD is worth $8765..'
		
		
	}

}
