package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBBranchUpdation {
WebDriver driver;
public PBBranchUpdation(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "(//img)[10]")
WebElement clickEdit;
@FindBy(xpath = "//input[@id='txtbnameU']")
WebElement EnterBranch;
@FindBy(xpath = "(//input[@id='txtadd1u'])[1]")
WebElement EnterAddress;
@FindBy(xpath = "//input[@id='txtareaU']")
WebElement EnterArea;
@FindBy(xpath = "//input[@id='txtzipu']")
WebElement EnterZip;
@FindBy(xpath = "//input[@id='btnupdate']")
WebElement ClickUpdate;
public boolean verify_UpdateBranch(String Branch,String Address,String Area,String Zipcode) throws Throwable
{
	this.clickEdit.click();
	this.EnterBranch.clear();
	this.EnterBranch.sendKeys(Branch);
	this.EnterAddress.clear();
	this.EnterAddress.sendKeys(Address);
	this.EnterArea.clear();
	this.EnterArea.sendKeys(Area);
	this.EnterZip.clear();
	this.EnterZip.sendKeys(Zipcode);
	this.ClickUpdate.click();
	String ExpectedAlert = driver.switchTo().alert().getText();
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	String ActualAlert ="Branch updated";
	if(ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase()))
	{
		Reporter.log(ExpectedAlert,true);
		return true;
	}
	else
	{
		Reporter.log("Unable To Update Branch",true);
		return false;
	}
	
}

}











