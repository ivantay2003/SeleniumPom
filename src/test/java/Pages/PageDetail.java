package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageDetail {

	WebDriver driver;
	CommonUI common;
	LOCELEMENT locelement = new LOCELEMENT ();
	
	private boolean bTripType ;
	
	public PageDetail(WebDriver inputdriver){
		
		driver=inputdriver;
		common=new CommonUI(driver);
		
		
	}
	public void getHello(){
		
		System.out.println("hello pages");
	}
	
	
	public void selectTripType(boolean Single){
		
		common.IsPresence(By.xpath(locelement.MAINPAGE_MULTIDEST_XPATH));
		
		if (!Single){ //single
			
			common.ClickElement(By.xpath(locelement.MAINPAGE_MULTIDEST_XPATH));
			bTripType=false;
			
		}else { //multiple
			
			common.ClickElement(By.xpath(locelement.MAINPAGE_SINGLEDEST_XPATH));
			bTripType=true;
		}
	}
	
	public void selectDestination (int type, String country){
		
		common.ClickElement(By.xpath(locelement.MAINPAGE_DEST_INPUTFIELD_XPATH));
		
		if (!bTripType){
			
			if (type==3){
				common.IsPresence(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION3_XPATH));
				common.ClickElement(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION3_XPATH));
				
			}else if (type==2){
				common.IsPresence(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION2_XPATH));
				common.ClickElement(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION2_XPATH));
			}else {
				common.IsPresence(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION1_XPATH));
				common.ClickElement(By.xpath(locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_REGION1_XPATH));
				
			}
				
			
		}else { 
			
			String countryname_XPATH = locelement.MAINPAGE_DROPDOWN_DESTCOUNTRY_COUNTRY_XPATH + country +"')]";
			common.ClickElement(By.xpath(countryname_XPATH));
			
		}
		
	}
	
	public void selectPickerCalender(int x , int y){
		
		//tbody/tr[x]/td[y]
		String calendar_XPATH="//tbody/tr[" + x + "]/td[" + y + "]";
		
		common.ClickElement(By.xpath(locelement.MAINPAGE_PICKDATE_FROM_XPATH));
		common.ClickElement(By.xpath(calendar_XPATH));
	
		
	}
	
	public void selectCoverType(int type){
		/*
		 * 0= Individual
		 * 1=Couple
		 * 2=Family
		 */
		common.IsPresence(By.xpath(locelement.MAINPAGE_INPUT_COVERTYPE_XPATH));
		common.ClickElement(By.xpath(locelement.MAINPAGE_INPUT_COVERTYPE_XPATH));
		
		if (type==0){
			
			common.ClickElement(By.xpath(locelement.MAINPAGE_INPUT_COVERTYPE_INDIVIDUAL_XPATH));
		}else if (type==1){
			
			common.ClickElement(By.xpath(locelement.MAINPAGE_INPUT_COVERTYPE_COUPLE_XPATH));
			
		}else {
			common.ClickElement(By.xpath(locelement.MAINPAGE_INPUT_COVERTYPE_FAMILY_XPATH));
			
		}
	}
	
	public void addAge(String age){
		
		
		common.SendKeys(By.xpath(locelement.MAINPAGE_AGE_XPATH), age);
	}
	
	public void addPromoCode(String promocode){
		
		common.IsPresence(By.xpath(locelement.MAINPAGE_INPUT_PROMO_XPATH));
		common.SendKeys(By.xpath(locelement.MAINPAGE_INPUT_PROMO_XPATH), promocode);
	}
	
	public void submit(){
		
		common.IsPresence(By.xpath(locelement.MAINPAGE_BUTTON_XPATH));
		common.ClickElement(By.xpath(locelement.MAINPAGE_BUTTON_XPATH));
		
	}
	
}
