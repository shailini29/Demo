package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	/*WebElement emailid = driver.findElement(By.id("identifierId"));
	WebElement emailNext = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
	WebElement enterpassword = driver.findElement(By.name("password"));
	WebElement passwordNext = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
	WebElement actualerror = driver.findElement(By.xpath("//div[@class='GQ8Pzc']"));*/
	
	// We cannot declare webelement as variables like these; because in loginTest, when lp object is called; 
	// all the variables of that class will be called.
	
	// Here WebDriver is declared as driver but it does not have any value in it; it is null. 
	// So WebElements cannot be found from null.
	
	// So basically we need to declare these WebElements with annotations so that 
	// they are not called immediately after the class is called.
	
	@FindBy(id = "identifierId")
	public static WebElement emailid;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public static WebElement emailNext;
	
	@FindBy(name = "password")
	public static WebElement enterpassword;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public static WebElement passwordNext;
	
	@FindBy(xpath = "//div[@class='GQ8Pzc']")
	public static WebElement actualerror;
	
	public void openBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\testing\\prop.properties"); // Here we are reading from Properties File
		Properties prop = new Properties();
		prop.load(fs);
		
		String browser = prop.getProperty("browser");
				
		//String browser = "chrome"; // we read this from xl file or some external data source. // Chrome, IE etc
		//WebDriver driver;
		
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Jars\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else if (browser.equals("chrome")) { // change chrome driver to 74.
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
			driver = new ChromeDriver(); // assume that this is the option for IE.
		}
		
		PageFactory.initElements(driver, this);
		// If we dont write the above line then again the webelement variables that are declared will be called  
		// after the class is called and will give error.
		
		/*System.setProperty("webdriver.gecko.driver", "C:\\Selenium Jars\\geckodriver.exe");
		driver = new FirefoxDriver();*/
	}
	
	public void openGmail() {
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String email) throws InterruptedException {
		emailid.sendKeys(email);
		emailNext.click();
		Thread.sleep(5000);
	}
	
	public void enterPassword(String password) throws InterruptedException {
		enterpassword.sendKeys(password);
		passwordNext.click();
		Thread.sleep(5000);
	}
	
	public String readPasswordError() {
		String actualErrMsg = actualerror.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}
	
	public String readEmailError() {
		String actualErrMsg = actualerror.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}
	
}
