package com.infigo.automation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUserFunctionality extends CatFishFunctionality {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public GeneralUserFunctionality(WebDriver e) {
    	super(e);
        driver = e;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private WebDriver driver;
	TestData testData=new TestData();

	public boolean ifElementPresent(By by)throws Throwable{
        try {
            driver.findElement(by);
            return true;
        }
        catch (Throwable t) {
            return false;
        
        }
    }
	
	
	
     
    
public void clickMYShoppingBasket()throws Throwable {
	String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
	driver.get(baseurl);
	
	driver.findElement(By.linkText("My Shopping Basket")).click();
	Thread.sleep(2000);
	
}



	 public void testvalidLogin() throws Throwable {
	        if (BrowserUtils.getInstance().isShouldLogin()) {
	            testValidLoginToInfigo();
	        }
	    }
	
	  public void testValidLoginToInfigo() throws Throwable{
		 
		  String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
		  String username =EnvSetUP.getInstance().getproperties("username") ;
		  String password=EnvSetUP.getInstance().getproperties("password") ;
		  driver.get(baseurl);
		 
		  driver.findElement(By.linkText("Log in")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.cssSelector("form > table.table-container > tbody > tr > td.item-value > #Email")).sendKeys(username);
		  driver.findElement(By.xpath("(//input[@id='Password'])[2]")).sendKeys(password);
		  driver.findElement(By.cssSelector("button.loginbutton")).click();
		  waitForElementToLoadandClick(By.linkText("My Shopping Basket"), 2);
		  
		  Thread.sleep(2000);
			  
	  }






public void searchProduct() throws Throwable{
	
	boolean hasnextrow=true;
	int rownum=1;
	while (hasnextrow) {
		System.out.println("The row val is :"+testData.productName(rownum));
	if (!testData.productName(rownum).isEmpty()) {
		String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
		driver.get(baseurl);
		driver.findElement(By.linkText("My Shopping Basket")).click();
		Thread.sleep(2000);
	    driver.findElement(By.id("small-searchterms")).clear();
	    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
	    driver.findElement(By.id("btn-small-search")).click();
	    Thread.sleep(2000);
		Assert.assertEquals(testData.productName(rownum), driver.findElement(By.cssSelector(".product-title>a")).getText()); 
		rownum++;
	} else {
		hasnextrow=false;
	}
		
	}
	
	
}


public void addtoBasket() throws Throwable{
	
	boolean hasnextrow=true;
	int rownum=1;
	while (hasnextrow) {
		System.out.println("The row val is :"+testData.productName(rownum));
	if (!testData.productName(rownum).isEmpty()) {
		String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
		driver.get(baseurl);
		driver.findElement(By.linkText("My Shopping Basket")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector(".cf_headerlinks_shoppngcart")).getText());
	    driver.findElement(By.id("small-searchterms")).clear();
	    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
	    driver.findElement(By.id("btn-small-search")).click();
	    Thread.sleep(2000);
	    
	    waitForElementToLoadandClick(By.cssSelector("input.productlistproductdetailbutton"), 20);
	    	    
	    waitForElementToLoadandClick(By.cssSelector(".productvariantaddtocartbutton"), 5);	   
	    
	    waitForElementToLoadandClick(By.cssSelector(".tt.nextStepButton.btn.btn-success.btn-lg"), 5);
	  
	    waitForElementToLoadandClick(By.xpath("html/body/div[7]/div[3]/div/button[1]"), 5);
	    Thread.sleep(10000);
	    System.out.println(driver.findElement(By.cssSelector(".cf_headerlinks_shoppngcart")).getText());
		rownum++;
	} else {
		hasnextrow=false;
	}
		
	}
}


	public void emailtoFriend() throws Throwable{
		
		boolean hasnextrow=true;
		int rownum=1;
		while (hasnextrow) {
			System.out.println("poduct name  :"+testData.productName(rownum));
		if (!testData.productName(rownum).isEmpty()) {
			String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
			driver.get(baseurl);
			driver.findElement(By.linkText("My Shopping Basket")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("small-searchterms")).clear();
		    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
		    driver.findElement(By.id("btn-small-search")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
		    driver.findElement(By.cssSelector("input.productemailafriendbutton")).click();
		    driver.findElement(By.id("FriendEmail")).clear();
		    driver.findElement(By.id("FriendEmail")).sendKeys("test@yopmail.com");
		    driver.findElement(By.id("PersonalMessage")).clear();
		    driver.findElement(By.id("PersonalMessage")).sendKeys("test");
		    driver.findElement(By.id("send-email")).click();
		    Thread.sleep(2000);
		    Assert.assertTrue(driver.findElement(By.cssSelector("div.emailafriend-box")).getText().contains("Your message has been sent"));
			rownum++;
		} else {
			hasnextrow=false;
		}
			
		}
	
	}

public void catfish_addMembeshipLetter() throws Throwable{
		
		boolean hasnextrow=true;
		int rownum=1;
		while (hasnextrow) {
			System.out.println("poduct name  :"+testData.productName(rownum));
		if (!testData.productName(rownum).isEmpty()) {
			String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
			driver.get(baseurl);
			driver.findElement(By.linkText("My Shopping Basket")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("small-searchterms")).clear();
		    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
		    driver.findElement(By.id("btn-small-search")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
		    driver.findElement(By.cssSelector("input.productemailafriendbutton")).click();
		    driver.findElement(By.id("FriendEmail")).clear();
		    driver.findElement(By.id("FriendEmail")).sendKeys("test@yopmail.com");
		    driver.findElement(By.id("PersonalMessage")).clear();
		    driver.findElement(By.id("PersonalMessage")).sendKeys("test");
		    driver.findElement(By.id("send-email")).click();
		    Thread.sleep(2000);
		    Assert.assertTrue(driver.findElement(By.cssSelector("div.emailafriend-box")).getText().contains("Your message has been sent"));
			rownum++;
		} else {
			hasnextrow=false;
		}
			
		}
	
	}




}


