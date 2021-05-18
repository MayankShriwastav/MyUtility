package Util.MyUtility.JSON;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class jsonReadWrite {

	public static void main(String[] args) {
		
		//Encode JSON object in java.
		JSONObject obj = new JSONObject();		
		obj.put("Name", "Mayank");
		obj.put("Age", new Integer(25));
		obj.put("Salary", new Double(80000));
		System.out.println("Json object	:	"+obj);
		
		//Encode JSON object using map in java.
		Map obj1 = new HashMap();
		obj1.put("Name", "Sunny");
		obj1.put("Age", new Integer(26));
		obj1.put("Salary", new Double(55000));
		System.out.println("map object	:	"+obj1);
		String abc = JSONValue.toJSONString(obj1);
		System.out.println("Map object in json format	:	"+abc);
		
		//Encode JSON array in java.
		JSONArray arr = new JSONArray();
		arr.add("Sushil");
		arr.add(new Integer(27)); 
		arr.add(new Double(40000));
		System.out.println("json array	:	"+arr);
		
		
		//decode JSON string in java.
		String jsonValue = " {\"name\":\"Mayank\",\"salary\":600000.0,\"age\":27}  "; 
		
		Object obj2 = JSONValue.parse(jsonValue);
		JSONObject jsonobj = (JSONObject) obj2;
		String name = (String) jsonobj.get("name");
		String salary= jsonobj.get("salary").toString();
		String age =  jsonobj.get("age").toString();
		
		//double salary = (double) jsonobj.get("salary");
		//long age = (long) jsonobj.get("age");
		System.out.println("Name : "+name+","+"Salary : "+salary+","+"Age : "+age);
	}

}
