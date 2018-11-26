package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagePaymentMethod {

	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PagePaymentMethod(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void selectPayLah(){
		
		common.IsPresence(By.xpath(locelement.PAYMENTMETHOD_PAYLAH_CHECBOX_XPATH));
		common.ClickElement(By.xpath(locelement.PAYMENTMETHOD_PAYLAH_CHECBOX_XPATH));
	}
	
	public void selectDBS(){
		
		
		common.IsPresence(By.xpath(locelement.PAYMENTMETHOD_CREDIT_CHECKBOX_XPATH));
		common.ClickElement(By.xpath(locelement.PAYMENTMETHOD_CREDIT_CHECKBOX_XPATH));
	}
	
	public void next(){
		
		common.IsPresence(By.xpath(locelement.PAYMENTMETHOD_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.PAYMENTMETHOD_BUTTON_XPATH));
	}
}
