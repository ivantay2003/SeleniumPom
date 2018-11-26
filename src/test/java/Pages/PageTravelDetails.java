package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTravelDetails {

	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	
	public PageTravelDetails(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	
	public void selectApplicant(){
		
		common.IsPresence(By.xpath(locelement.DETAILS_APP_CHECKBOX_XPATH));
		common.ClickElement(By.xpath(locelement.DETAILS_APP_CHECKBOX_XPATH));
		
		
	}
	
	public void addNric(String nric){
		
		common.IsPresence(By.xpath(locelement.DETAILS_NRIC_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_NRIC_INPUT_XPATH), nric);
	}
	
	public void addFullName (String fullname){
		
		common.IsPresence(By.xpath(locelement.DETAILS_FULLNAME_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_FULLNAME_INPUT_XPATH), fullname);
	}
	
	public void addDOB (String DOB){
		
		common.IsPresence(By.xpath(locelement.DETAILS_DOB_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_DOB_XPATH), DOB);
	}
	
	public void addNationality (String country){
		
		//span[@class='mat-option-text'][contains(text(),'Albania')]
		
		common.IsPresence(By.xpath(locelement.DETAILS_COUNTRY_XPATH));
		common.ClickElement(By.xpath(locelement.DETAILS_COUNTRY_XPATH));
		
		String country_XPATH="//span[@class='mat-option-text'][contains(text(),'" + country + "')]";
		
		common.ClickElement(By.xpath(country_XPATH));		
		
		
	}
	
	public void addMobile(String phone) {
		
		
		common.IsPresence(By.xpath(locelement.DETAILS_PHONE_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_PHONE_XPATH), phone);
	}
	
	public void addEmail(String email) {
		
		common.IsPresence(By.xpath(locelement.DETAILS_EMAIL_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_EMAIL_INPUT_XPATH), email);
	}
	
	
	public void addFullName2(String fullname){
		
		
		common.IsPresence(By.xpath(locelement.DETAILS_TRAVELLOR2_FULLNAME_INPUT_XPATH));
		//common.ClickElement(By.xpath(locelement.DETAILS_TRAVELLOR2_FULLNAME_INPUT_XPATH));	
		common.SendKeys(By.xpath(locelement.DETAILS_TRAVELLOR2_FULLNAME_INPUT_XPATH), fullname);
		
	}
	
	public void addNric2(String nric){
		
		common.IsPresence(By.xpath(locelement.DETAILS_TRAVELLOR2_NRIC_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_TRAVELLOR2_NRIC_INPUT_XPATH), nric);
	}
	
	public void addDOB2 (String DOB){
		
		common.IsPresence(By.xpath(locelement.DETAILS_TRAVELLOR2_DOB_INPUT_XPATH));
		common.SendKeys(By.xpath(locelement.DETAILS_TRAVELLOR2_DOB_INPUT_XPATH), DOB);
	}
	
	public void addNationality2 (String country){
		
		//span[@class='mat-option-text'][contains(text(),'Albania')]
		
		common.IsPresence(By.xpath(locelement.DETAILS_COUNTRY_XPATH));
		common.ClickElement(By.xpath(locelement.DETAILS_TRAVELLOR2_COUNTRY_INPUT_XPATH));
		
		String country_XPATH="//span[@class='mat-option-text'][contains(text(),'" + country + "')]";
		
		common.ClickElement(By.xpath(country_XPATH));		
		
		
	}
	
	public void next(){
		
		common.IsPresence(By.xpath(locelement.DETAILS_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.DETAILS_BUTTON_XPATH));
	}
	
	
}
