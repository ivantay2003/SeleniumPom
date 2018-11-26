package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageMultipleTravellorConfirm {

	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PageMultipleTravellorConfirm(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void proceed(){
		
		common.IsPresence(By.xpath(locelement.MULTIPLETRAVELLOR_CONFIRMATION_PROCEED_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.MULTIPLETRAVELLOR_CONFIRMATION_PROCEED_BUTTON_XPATH));
	}

	public void back(){
		
		common.IsPresence(By.xpath(locelement.MULTIPLETRAVELLOR_CONFIRMATION_BACK_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.MULTIPLETRAVELLOR_CONFIRMATION_BACK_BUTTON_XPATH));
	}


}
