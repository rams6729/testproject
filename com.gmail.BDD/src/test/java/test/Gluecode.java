package test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.w3c.dom.CDATASection;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gluecode {
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Loginpage lp;
	public Composepage cp;
	public Scenario s;
	public Properties p;
	@Before
	public void method1(Scenario s)throws Exception
	{
		//define scenario class object
		this.s=s;
		//loading property file
		File f= new File("C:\\Users\\lakshmi7885\\eclipse-workspace\\com.gmail.BDD\\src\\test\\resources\\gmailresources\\gmailproperties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
	}
	@Given("^launch site$")
	public void method2()
	
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cdpath"));
		driver=new ChromeDriver();
		driver.get(p.getProperty("url"));
		//create page class objects
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		cp=new Composepage(driver);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.uid));
		driver.manage().window().maximize();
				
	}
	@Then("^title should be \"(.*)\"$")
	public void method3(String et)
	{
		String st=driver.getTitle();
		if(st.equals(et))
		{
			s.write("gmail tittle  test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,"gmail tittle test failed");
			Assert.fail();
		}
	}
	@When("^close site$")
	public void method4()
	{
		driver.close();
	}
	@When("^enter uid as \"(.*)\"$")
	public void method5(String x)
	{
		hp.filluid(x);
	}
	@And("^click uid next button$")
	public void method6()
	{
		hp.clickuidnext();
	}
	@Then("^check uid outcome with \"(.*)\" criteria$")
	public void method7(String y)
	{
		try
		{ 
			if(y.equalsIgnoreCase("uid-blank")&&hp.blankuiderr.isDisplayed())
			{
				s.write("blank uid test passed");
			}
			else if(y.equalsIgnoreCase("uid-invalid")&&hp.invaliduiderr.isDisplayed())
			{
				s.write("invalid uid test passed");
			}
			else if(y.equalsIgnoreCase("uid-valid")&&lp.pwd.isDisplayed())
			{
				s.write("valid uid test passed");
			}
			else
			{
				byte[] b1=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b1,"uid test failed");
				Assert.fail();

			}
			
		}
		catch(Exception ae)
		{
			s.write(ae.getMessage());
			Assert.fail();
		}
	}


}
