package Util.MyUtility.JSON;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class writeJson {

	public static void main(String[] args) throws IOException {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		
		array.add("A-104,Astra-Nanadan Society");
		array.add("bhumkar chowk");
		array.add("pune");
		jsonObject.put("Address",array);
		
		
		jsonObject.put("Name", "Mayank");
		jsonObject.put("Brid", "G04657381");
		jsonObject.put("MobileNo", "8007656342");
		
	/*	JSONArray array = new JSONArray();
				array.add("A-104,Astra-Nanadan Society");
				array.add("bhumkar chowk");
				array.add("pune");
				jsonObject.put("Address",array);*/
		
		 FileWriter fileWriter = new FileWriter("D:\\My_Projects\\MyUtility\\test.json");
		 fileWriter.write(jsonObject.toString());
		 fileWriter.close();
		

	}

}
