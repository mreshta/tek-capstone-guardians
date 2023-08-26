package tek.capstone.guardians.pages;

import org.openqa.selenium.support.PageFactory;
import tek.capstone.guardians.base.BaseSetup;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetailHomePage extends BaseSetup{

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="hamburgerBtn")
	public WebElement hambugerBttn;
	
	@FindBy(className="//div[@class='sidebar_content-item']")
	public List<WebElement> allOptions;
	
	@FindBy(xpath="//div[@class='sidebar_content-item']//span")
	public List<WebElement> sideBarOptions;
	
}