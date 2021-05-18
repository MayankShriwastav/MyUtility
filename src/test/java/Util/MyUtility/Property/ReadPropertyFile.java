package Util.MyUtility.Property;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	private  final static String FILE_PATH = "D:\\My_Projects\\MyUtility\\src\\main\\java\\Properties\\Data.properties";
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(FILE_PATH);
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		// to write in properties file -->
		prop.setProperty("browser", "firefox");
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		prop.store(fos, "writing file..");
		
		//After Editing
		System.out.println("******After Editing*****");
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));

	}

}
