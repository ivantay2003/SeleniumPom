package cucumberJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import DemoInsurance.Configuration;
import Pages.CommonUI;
import Pages.LOCELEMENT;
import Pages.PageCreditCardDetails;
import Pages.PageDetail;
import Pages.PageMultipleTravellorConfirm;
import Pages.PagePaymentMethod;
import Pages.PagePreview;
import Pages.PageSelection;
import Pages.PageTravelDetails;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenario1 {
	
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
	
	@After
	public void afterTest(){
		
		try {
			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Before
	public void beforeTest() {
		  
		  locelement = new LOCELEMENT() ;
		  
		  
		  driver=config.getChromeDriver();
		  common= new CommonUI(driver);
		  
		  page_detail = new PageDetail(driver);
		  page_selection = new PageSelection(driver);
		  page_multipletravellor=new PageMultipleTravellorConfirm(driver);
		  page_traveldetails = new PageTravelDetails(driver);
		  page_paymentmethod = new PagePaymentMethod (driver);
		  page_preview = new PagePreview (driver);
		  page_creditcarddetails = new PageCreditCardDetails (driver);
		  
		
	  }
	
	
	 @And("^User want to buy travel insurance$")
	 public void mainStartTest() throws Throwable{
		 
	
		  String URL = config.getURL();
		  driver.get(URL);
		  
	 }
	 
	 @When("^User want buy a \"([^\"]*)\" trip type$")
	 public void mainSelectTripType(String triptype) throws Throwable{
		 
		
		 if (triptype.equals("single")){
			 page_detail.selectTripType(true);
		 }else if (triptype.equals("multiple")) {
			
			 page_detail.selectTripType(false); //Select Trip type
		 }
	 }
	 
	 @And("^User want select date \"([^\"]*)\" \"([^\"]*)\" for destination$")
	 public void mainSelectCalendar (String i, String j) throws Throwable{
		 
		 int a= Integer.parseInt(i);
		 int b= Integer.parseInt(j);
		 page_detail.selectPickerCalender(a,b); //Pick a calendar 
	 }
	 
	 @And("^User want select \"([^\"]*)\" cover type$")
	 public void mainSelectCoverType(String coverType) throws Throwable {
		 
		 System.out.println(coverType);
		 
		 if (coverType.equals("single")){
			 page_detail.selectCoverType(0); //Individual 
		 }else if (coverType.equals("couple")) {
			 
			 page_detail.selectCoverType(1); //Family
		 } else if (coverType.equals("family")){
			 
			 page_detail.selectCoverType(2); //Family
		 }
	 }
	 

	 
	 @And("^User is \"([^\"]*)\" years old$")
	 public void mainAddAge (String age) throws Throwable {
		 
		 page_detail.addAge(age); //add age
	 }
	 
	 
	 @Then("^Go to quote page$")
	 public void mainSubmit () throws Throwable {
		 
		 page_detail.submit();//Submit details
	 }
	 
	 
	 @When("^User  select \"([^\"]*)\" quote$")
	 public void quoteSelect (String strQuoteSelect) throws Throwable {
		 
		 if (strQuoteSelect.equals("first")){
			 
			 page_selection.selectQuote(0); //Select Quote 1
			 
		 }else if (strQuoteSelect.equals("second")){
			 
			 page_selection.selectQuote(1); //Select Quote 2
			 
		 }else if (strQuoteSelect.equals("third")){
			 
			 page_selection.selectQuote(2); //Select Quote 3
		 }
	 }
	 
	 
	 @Then("^Proceed to fill in Applicant's detail$")
	 public void previewProceed () throws Throwable {
		 
		 page_multipletravellor.proceed(); //Proceed
		 common.WebScroll(0, 700);//Scroll page down 
		 
	 }
	 
	 @When("^User add NRIC \"([^\"]*)\"$")
	 public void traveldetailsAddNRIC(String nric)  throws Throwable {
		 
		 page_traveldetails.addNric(nric); //add NRIC
	 }
	 
	 @And("^User add name \"([^\"]*)\"$")
	 public void traveldetailsAddName(String fullname)  throws Throwable {
		 
		 page_traveldetails.addFullName(fullname); //add full name
	 }
	 
	 @And("^User add DOB \"([^\"]*)\"$")
	 public void traveldetailsAddDOB(String dob)  throws Throwable {
		 
		 page_traveldetails.addDOB(dob); //add date of birth
	 }
	 
	 @And("^User add nationality \"([^\"]*)\"$")
	 public void traveldetailsAddCountry(String country)  throws Throwable {
		 
		 page_traveldetails.addNationality(country); //add nationality
	 }
	 
	 @And("^User add email \"([^\"]*)\"$")
	 public void traveldetailsAddEmail(String email)  throws Throwable {
		 
		 page_traveldetails.addEmail(email); //add email
	 }
	 
	 @And("^User add mobile \"([^\"]*)\"$")
	 public void traveldetailsAdMobile(String phone)  throws Throwable {
		 
		 page_traveldetails.addMobile(phone); //add mobile number 
	 }
	 
	 
	 @Then("^Proceed to Preview Page$")
	 public void traveldetailsProceed () throws Throwable {
		 
		  common.WebScroll(0, 700);//Scroll page down 
		  page_traveldetails.next(); //Next to go to preview page
		 
	 }
	 
	 @Then("^Proceed to Payment Method$")
	 public void previewNext () throws Throwable {
		 
		  common.WebScroll(0, 700);//Scroll page down 
		  page_preview.clickCheckbox(); //Check on checkbox so that we can click buy now button next
		  page_preview.button();
		 
	 }
	 
	 @When("^User select \"([^\"]*)\" as payment method$")
	 public void paymentMethodSelect (String method) throws Throwable {
		 
		 if (method.equals("PayLah!")){
			 
			  page_paymentmethod.selectPayLah(); //Select PayLah! payment method
			  page_paymentmethod.next(); //Click next button to go next page
			  
		 }else if (method.equals("credit card")){
			 
			  page_paymentmethod.selectDBS(); //Select DBS payment method
			  page_paymentmethod.next(); //Click next button to go next page
		 }
		 
	 }
	 
	 
	 @And("^User add credit card number details \"([^\"]*)\"$")
	 public void creditcardAddNumber(String number)  throws Throwable {
		 
		 page_creditcarddetails.addCreditCardNumber(number); //Add credit card number
	 }
	 
	 
	 @And("^User add name details \"([^\"]*)\"$")
	 public void creditcardAddName(String name)  throws Throwable {
		 
		 page_creditcarddetails.addName(name); //Add Name
	 }
	 
	 
	 @And("^User add CVV details \"([^\"]*)\"$")
	 public void creditcardAddCVV(String cvv)  throws Throwable {
		 
		 page_creditcarddetails.addCVV(cvv); // Add CVV
	 }
	 
	 
	 @And("^User add credit expiry number details \"([^\"]*)\"$")
	 public void creditcardAddExpiryDate(String date)  throws Throwable {
		 
		 page_creditcarddetails.addExpiryDate(date); // Add credit card cvv
	 }
	 
	 @Then("^Proceed to make payment$")
	 public void creditcardBuy () throws Throwable {
		 
		  
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  @Given("^When I am in bed \"([^\"]*)\"$")
	  public void given(String str) throws Throwable {
		  
		  System.out.println("Just in bed " + str);
	  }

	  @When("^The sun is high up$")
	  public void when() throws Throwable {
		  System.out.println("blardy sun in the sky");
	  }

	  @Then("^I decide to get up$")
	  public void then() throws Throwable {
		  
		  System.out.println("get up old boy");
	  }

	  @And("^And move my body$")
	  public void andfuck() throws Throwable {
		  
		  System.out.println("Move it move it ....");
	  }
}
