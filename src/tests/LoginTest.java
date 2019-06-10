package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	DataFile df = new DataFile();
	LoginPage lp = new LoginPage();
	WebDriver driver;
	
  @Test
  public void loginWithWrongPasswordTest() throws InterruptedException{
	  
	  lp.enterEmail(df.correctEmail);
	  lp.enterPassword(df.wrongPassword);
	  Assert.assertEquals(lp.readPasswordError(), df.expPasswordError);
  }
  
  @Test
  public void loginWithWrongEmailTest() throws InterruptedException{
	  
	  lp.enterEmail(df.wrongEmail); 
	  lp.readEmailError();
	  Assert.assertEquals(lp.readEmailError(), df.expEmailError);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openGmail();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }

}
