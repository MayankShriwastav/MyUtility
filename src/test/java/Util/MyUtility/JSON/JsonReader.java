package Util.MyUtility.JSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	private  final static String ENV_FILE_PATH = "D:/My_Projects/MyUtility/src/main/java/Properties/envParams.json";
	private  final static String DB_Query = "D:/My_Projects/MyUtility/src/main/java/Properties/dbQuery.json";
	
	
	private String getEnvValue(String parameter, String tagName) throws IOException, ParseException{		
		JSONParser jsonParser = new JSONParser();		
		JSONObject jsonObj = (JSONObject)jsonParser.parse(new FileReader(ENV_FILE_PATH));
		JSONArray jsonArr  = (JSONArray)jsonObj.get("envs");
		
		for(int i= 0 ; i<jsonArr.size() ; i++){
			JSONObject env = (JSONObject)jsonArr.get(i);
			String envTag = (String)env.get("tag");
			if(envTag.equals(tagName)){
				return (String)env.get(parameter);
			}			
		}	
		return null;	
	}
	
	public String getQuery() throws IOException, ParseException{
		return getSqlQuery("register","select");
	}
	
	private String getSqlQuery(String query, String queryType) throws IOException, ParseException{		
		JSONParser jsonParser = new JSONParser();		
		JSONObject jsonObj = (JSONObject)jsonParser.parse(new FileReader(DB_Query));
		JSONArray jsonArr  = (JSONArray)jsonObj.get("query");
		
		for(int i= 0 ; i<jsonArr.size() ; i++){
			JSONObject qryType = (JSONObject)jsonArr.get(i);
			String qryTag = (String)qryType.get("tag");
			if(qryTag.equals(queryType)){
				return (String)qryType.get(query);
			}			
		}	
		return null;	
	}
	
	
	
	
	public static void main(String[] args) throws IOException, ParseException {
			
		JsonReader jr = new JsonReader();		
		String url =jr.getEnvValue("url","uat");	
		String user = jr.getEnvValue("userName","uat");		
		String pwd =jr.getEnvValue("password","uat");
		
		String query = jr.getSqlQuery("register","select");
		
		System.out.println("Url  : "+url);
		System.out.println("UserName  : "+user);
		System.out.println("Password : "+pwd);
		System.out.println("query : "+query);
		
	}

}
