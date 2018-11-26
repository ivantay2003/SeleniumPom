package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCreditCardDetails {
	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PageCreditCardDetails(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void addCreditCardNumber(String number){
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tokenExIframeDiv"));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tokenExIframeDiv");
		common.IsPresence(By.xpath(locelement.PAYDBS_CREDIT_NUMBER_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.PAYDBS_CREDIT_NUMBER_INPUT_XPATH), number);
	}
	
	public void addName(String name){
		
		driver.switchTo().defaultContent();
		common.IsPresence(By.xpath(locelement.PAYDBS_CREDIT_NAME_INPUT_XPATH));
		common.ClickElement(By.xpath(locelement.PAYDBS_CREDIT_NAME_INPUT_XPATH));
		/*common.IsPresence(By.xpath(locelement.PAYDBS_CREDIT_NAME_INPUT_XPATH));
		common.ClickElement(By.xpath(locelement.PAYDBS_CREDIT_NAME_INPUT_XPATH));*/
		common.SendKeys(By.xpath(locelement.PAYDBS_CREDIT_NAME_INPUT_XPATH),name);
	}
	
	public void addExpiryDate(String date){
		
		driver.switchTo().defaultContent();
		common.IsPresence(By.xpath(locelement.PAYDBS_CREDIT_EXPIRY_XPATH));
		common.SendKeys(By.xpath(locelement.PAYDBS_CREDIT_EXPIRY_XPATH), date);
	}
	
	
	public void addCVV(String cvv){
		
		driver.switchTo().defaultContent();
		common.IsPresence(By.xpath(locelement.PAYDBS_CREDIT_CV_XPATH));
		common.SendKeys(By.xpath(locelement.PAYDBS_CREDIT_CV_XPATH), cvv);
	}
	
}
