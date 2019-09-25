package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage {
 public WebDriver driver;
 @FindBy(xpath="//*[text()='Compose']")
 public WebElement comp;
 @FindBy(name="to")
 public WebElement to;
 @FindBy(name="subjectbox")
 public WebElement subj;
 @FindBy(xpath="(//*[@aria-label='Message Body'])[2]")
 public WebElement body;
 @FindBy(xpath="//*[contains(@data-tooltip,'Send')]")
 public WebElement send;
 @FindBy(xpath="//*[text()='Message send']")
 public WebElement sendmsgconfirm;
 
 @FindBy(xpath="//*[contains(@aria-label,'Google Account')]/span")
 public WebElement profilepic;
 @FindBy(linkText="Sign out")
 public WebElement signout;
 public Composepage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 public void clickcomp()
 {
	 comp.click();
 }
 public void fillto(String x)
 {
	 to.sendKeys(x);
 }
 public void fillsub(String x)
 {
	 subj.sendKeys(x);
 }
 public void fillbody(String x)
 {
	 body.sendKeys(x);
 }
 public void clicksend()
 {
	 send.click();
 }
 public void clickprofilepic()
 {
	 profilepic.click();
 }
 public void clicksignout()
 {
	 signout.click();
 }
}
