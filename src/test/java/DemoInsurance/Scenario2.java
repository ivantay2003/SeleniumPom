package DemoInsurance;

import Pages.CommonUI;
import Pages.LOCELEMENT;
import Pages.PageDetail;
import Pages.PageSelection;
import Pages.PageMultipleTravellorConfirm;
import Pages.PageTravelDetails;
import Pages.PagePaymentMethod;
import Pages.PagePreview;
import Pages.PageCreditCardDetails;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Scenario2 {
	PageDetail page_detail ;
	PageSelection page_selection;
	PageMultipleTravellorConfirm page_multipletravellor;
	PageTravelDetails page_traveldetails;
	PagePaymentMethod page_paymentmethod;
	PagePreview page_preview;
	PageCreditCardDetails page_creditcarddetails;
	
	
	
	Configuration config=new Configuration();
	
	
	Actions action;
	WebDriver driver;
	int WaitTime=5;
	LOCELEMENT locelement ;
	String resultpath="";
	CommonUI common;
	
	@BeforeTest
	public void beforeTest() {
		  
		  locelement = new LOCELEMENT() ;
		  
		  
		  driver=config.getChromeDriver();
		  //driver=config.getFireFoxDriver();
		  common= new CommonUI(driver);
		  
		  page_detail = new PageDetail(driver);
		  page_selection = new PageSelection(driver);
		  page_multipletravellor=new PageMultipleTravellorConfirm(driver);
		  page_traveldetails = new PageTravelDetails(driver);
		  page_paymentmethod = new PagePaymentMethod (driver);
		  page_preview = new PagePreview (driver);
		  page_creditcarddetails = new PageCreditCardDetails (driver);
		  
	  }
	  
	  @AfterTest 
	  public void quit(){
		  
		  //driver.quit();
	  }	
	

	  public void IsPresence(By by){
			
		new WebDriverWait (driver,WaitTime).until(ExpectedConditions.presenceOfElementLocated(by));
	}
		
		
	public void WebScroll ( int endx , int endy){
			
		String strjavascript="window.scrollBy("+ endx + "," + endy + ")";
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript(strjavascript, "");
			
	}	  
  @Test
  // Single destination
  /*
   * Single destination
   * Country to travel - United Kingdom
   * Cover Type - Couple
   * 
   */
  public void Scenario2(){
	  
	  String URL = config.getURL();
	  driver.get(URL);
	  
	  /*
	   *  Customer Details Page
	   *  =====================
	   */
	  page_detail.selectTripType(true); //Multiple (false) or Single trip (true) ?
	  page_detail.selectDestination(1,"United Kingdom"); //Select a country - United Kingdom
	  page_detail.selectPickerCalender(4, 6); //Select calendar date
	  page_detail.selectCoverType(1); //Select cover type 0- indivudal  / 1 - Couple / 2 - Family
	  page_detail.addAge("25,30");//add age
	  //page_detail.addPromoCode(locelement.PROMO_CODE); //add promo code
	  page_detail.submit();//Submit details
	
	  
	  /*
	   *  Select Quote Page
	   *  =================
	   */
	  page_selection.selectQuote(1); //Select Quote 2
	  
	  
	  /*
	   *  Multiple Travel Page
	   *  ======================
	   */
	  page_multipletravellor.proceed(); //Proceed
	  
	  
	  
	  /*
	   *  Applicant's details Page
	   *  =========================
	   */
	  common.WebScroll(0, 700);//Scroll page down 
	  //pagetraveldetails.selectApplicant();
	  page_traveldetails.addNric(locelement.NRIC); //add NRIC
	  page_traveldetails.addFullName(locelement.FULLNAME); //add full name
	  page_traveldetails.addDOB(locelement.DOB); //add date of birth
	  page_traveldetails.addNationality(locelement.COUNTRY); //add nationality
	  page_traveldetails.addEmail(locelement.EMAIL); //add email
	  page_traveldetails.addMobile(locelement.PHONE); //add mobile number
	  
	  WebElement elem = driver.findElement(By.xpath(locelement.DETAILS_TRAVELLOR_DOB_INPUT_XPATH));
	  common.WebScrollElement(elem); //Scroll to Element. This is important!

	  page_traveldetails.addFullName2(locelement.FULLNAME2);//add full name for travellor 2
	  page_traveldetails.addNric2(locelement.NRIC2); //add nric for travellor 2
	  page_traveldetails.addDOB2(locelement.DOB2);// add date of birth for travellor 2
	  page_traveldetails.addNationality2(locelement.COUNTRY1);//add country for travellor 2
	  page_traveldetails.next(); //next page

	
	  /*
	   *  Preview Page
	   *  ===========+
	   */
	  common.WebScroll(0, 1700);//Scroll page down 
	  page_preview.clickCheckbox(); //Check on checkbox so that we can click buy now button next
	  page_preview.button(); //Go to Payment Method Page
	  
	  /*
	   *  Payment Method Page
	   *  ===================
	   */
	  page_paymentmethod.selectDBS(); //Select DBS payment method
	  //page_paymentmethod.next(); //Click next button to go next page
	  
	  
	  

	  
	  
  }
  

}
