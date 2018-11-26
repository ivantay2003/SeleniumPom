package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSelection {

	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PageSelection(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void selectQuote (int selection){
		
		
		common.IsPresence(By.xpath(locelement.SELECTQUOTE_BUTTON_1QUOTE_XPATH));
		if (selection==0){
			
			common.ClickElement(By.xpath(locelement.SELECTQUOTE_BUTTON_1QUOTE_XPATH));
		}else if (selection==1){
			
			common.ClickElement(By.xpath(locelement.SELECTQUOTE_BUTTON_2QUOTE_XPATH));
		}else
			common.ClickElement(By.xpath(locelement.SELECTQUOTE_BUTTON_3QUOTE_XPATH));
	}

	
}
