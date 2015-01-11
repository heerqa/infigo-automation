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
import org.openqa.selenium.support.ui.Select;

public class CatFishFunctionality {
	
	 @Rule
	    public ErrorCollector collector = new ErrorCollector();

	    public CatFishFunctionality(WebDriver e) {
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
		
		
		public void waitForElementToLoadandClick(By by, int counter) throws InterruptedException, Throwable {
			int timeCounter = 1;
			boolean timeout = true;
			do {
			    Thread.sleep(2000);
			    timeCounter++;
			   System.out.println("Page is still loading. The couner is = "+timeCounter);
			    if (ifElementPresent(by)|| timeCounter > counter) {
			    	 driver.findElement(by).click();
			        timeout = false;
			    }
			}
			while (timeout);
		}

		
		
		public void getScreenShot(String screenshotname) throws Throwable{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path=FileUtils.getUserDir();
			System.out.println(path);
		    org.apache.commons.io.FileUtils.copyFile(scrFile, new File(path+"/target/ScreensonError/"+screenshotname+".png"));
		 
					
		}
		
		public void browserClose() {
			System.out.println("going to close the browser");
			driver.quit();
			
			
		}

		public void testvalidLogintoCatFish() throws Throwable {
	        if (BrowserUtils.getInstance().isShouldLogin()) {
	        	testLogintoCatFish();
	        }
	    }
		
		public void clickonHomeLink() throws Throwable{
			
			waitForElementToLoadandClick(By.cssSelector(".dir"), 5);
		}
	
	  public void testLogintoCatFish() throws Throwable{
		 
		  String baseurl =EnvSetUP.getInstance().getproperties("catfishurl") ;
		  String username =EnvSetUP.getInstance().getproperties("username") ;
		  String password=EnvSetUP.getInstance().getproperties("password") ;
		  driver.get(baseurl);
		 
		  driver.findElement(By.linkText("Log in")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.cssSelector("form > table.table-container > tbody > tr > td.item-value > #Email")).sendKeys(username);
		  driver.findElement(By.xpath("(//input[@id='Password'])[2]")).sendKeys(password);
		  driver.findElement(By.cssSelector("button.loginbutton")).click();
		  waitForElementToLoadandClick(By.cssSelector(".dir"), 5);
		  
		  Thread.sleep(2000);
			  
	  }

	  
	  public void addMemberShipLetter_with_csvupload() throws Throwable{
		  
		
					Thread.sleep(2000);
				   driver.findElement(By.id("small-searchterms")).clear();
				   Thread.sleep(2000);
				    driver.findElement(By.id("small-searchterms")).sendKeys("membership letter");
				    Thread.sleep(2000);
				    driver.findElement(By.id("btn-small-search")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.id("productVariantAddToCart")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.id("btn_batch")).click();
				    Thread.sleep(2000);
				    //driver.findElement(By.id("batch-file-upload-thing")).clear();
				    //Thread.sleep(2000);
				    driver.findElement(By.id("batch-file-upload-thing")).sendKeys("C:\\Users\\HEER\\Desktop\\Tanveer\\Test Fitness Plus 10 Records.csv");
				    Thread.sleep(2000);
				    driver.findElement(By.id("btBatchNext")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.id("batchAddToBaset")).click();
				 
			
			
			
			
	  }

	  
	  public void addBusiness_Card_Fitness_Plus() throws Throwable{
		  
			
			Thread.sleep(2000);
			 driver.findElement(By.id("small-searchterms")).clear();
			 Thread.sleep(2000);
			 // driver.findElement(By.id("small-searchterms")).sendKeys("Business Card - Fitness Plus");
			 driver.findElement(By.id("small-searchterms")).sendKeys("ZXXXXXXXX");
			    Thread.sleep(2000);
			  driver.findElement(By.id("btn-small-search")).click();
			    Thread.sleep(2000);
			  driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
			    Thread.sleep(2000);
			    new Select(driver.findElement(By.id("quantityBasedPricingSelector"))).selectByVisibleText("500 @ £198.00");
			    Thread.sleep(2000);
			    driver.findElement(By.id("productVariantAddToCart")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("btn_addtobasket")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//button[@type='button']")).click();;
		 
	
	  }



	  public void addBusiness_FitnessFlyer() throws Throwable{
		  
			
			Thread.sleep(2000);
			 driver.findElement(By.id("small-searchterms")).clear();
			 Thread.sleep(2000);
			 driver.findElement(By.id("small-searchterms")).sendKeys("Fitness Flyer");
			 Thread.sleep(2000);
			 driver.findElement(By.id("btn-small-search")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("productVariantAddToCart")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("btn_addtobasket")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//button[@type='button']")).click();
		 
	
	  }



}
