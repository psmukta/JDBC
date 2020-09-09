package EmployeePack;

import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class JDBCDataTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
		
		DataFromJDBC newdata=new DataFromJDBC();
		Map<String,String>data=newdata.dataretrivefromemployeetable();
		for(Entry <String,String> user1:data.entrySet()) {
			String Username=user1.getKey();
			String Password=user1.getKey();
			driver.get("www.facebook.com");
			driver.findElement(By.name("firstname")).sendKeys(Username);
			
			driver.findElement(By.name("reg_passwd__")).sendKeys(Password);
			
		}
		Thread.sleep(3000);
		driver.close();
	}

}
