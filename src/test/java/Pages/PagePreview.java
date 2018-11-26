package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagePreview {
	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PagePreview(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void clickCheckbox(){
		
		common.IsPresence(By.xpath(locelement.PREVIEW_CHECKBOX_XPATH));
		common.ClickElement(By.xpath(locelement.PREVIEW_CHECKBOX_XPATH));
	}
	
	public void button(){
		
		common.IsPresence(By.xpath(locelement.PREVIEW_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.PREVIEW_BUTTON_XPATH));
	}
}
