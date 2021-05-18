package Util.MyUtility.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DbConnectionTest2 {
	String name,email,pwd,confPwd;
	
	@BeforeMethod
	public void connectMysqlDB(){
String host ="localhost";
String port ="3306";
String dbName = "udemyLearning";

		try {
			Connection con=DriverManager.getConnection(  "jdbc:mysql://"+host+":"+port+"/"+dbName ,"root","root");
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from registerEmp  where name = 'Mohit'");
			while(rs.next()){
				name= rs.getString("name");
				email =rs.getString("email");
				pwd=rs.getString("password");		
				confPwd=rs.getString("ConfirmPassword");			
			}			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void SeleniumTest(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/9521/users/sign_up?reset_purchase_session=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.findElement(By.id("user_name")).sendKeys(name);
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("user_password_confirmation")).sendKeys(confPwd);
	}
	
}
