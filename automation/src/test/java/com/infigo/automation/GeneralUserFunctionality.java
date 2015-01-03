package com.infigo.automation;

import org.apache.bcel.generic.DREM;
import org.apache.bcel.generic.IFLE;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.infigo.automation.Browser;
import com.infigo.automation.BrowserUtils;
import com.infigo.automation.Email;
import com.infigo.automation.EnvSetUP;
import com.infigo.automation.FileUtils;
import com.infigo.automation.TestData;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class GeneralUserFunctionality {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public GeneralUserFunctionality(WebDriver e) {
        driver = e;
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    private WebDriver driver;


     
    
public void clickMYShoppingBasket()throws Throwable {
	
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

public void searchProduct() throws Throwable{
	TestData testData=new TestData();
	
	boolean hasnextrow=true;
	int rownum=1;
	while (hasnextrow) {
		System.out.println("The row val is :"+testData.productName(rownum));
	if (!testData.productName(rownum).isEmpty()) {
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
	TestData testData=new TestData();
	
	boolean hasnextrow=true;
	int rownum=1;
	while (hasnextrow) {
		System.out.println("The row val is :"+testData.productName(rownum));
	if (!testData.productName(rownum).isEmpty()) {
		driver.findElement(By.linkText("My Shopping Basket")).click();
		Thread.sleep(2000);
	    driver.findElement(By.id("small-searchterms")).clear();
	    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
	    driver.findElement(By.id("btn-small-search")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
	    driver.findElement(By.name("createDynamic-1724")).click();
	    driver.findElement(By.xpath("//div[@id='parentContainer']/div[4]/div/div/div[2]/div/button")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
 
		rownum++;
	} else {
		hasnextrow=false;
	}
		
	}
}
	public void emailtoBasket() throws Throwable{
		TestData testData=new TestData();
		
		boolean hasnextrow=true;
		int rownum=1;
		while (hasnextrow) {
			System.out.println("The row val is :"+testData.productName(rownum));
		if (!testData.productName(rownum).isEmpty()) {
			driver.findElement(By.linkText("My Shopping Basket")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("small-searchterms")).clear();
		    driver.findElement(By.id("small-searchterms")).sendKeys(testData.productName(rownum));
		    driver.findElement(By.id("btn-small-search")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("input.productlistproductdetailbutton")).click();
		    driver.findElement(By.cssSelector("input.productemailafriendbutton")).click();
		    driver.findElement(By.id("FriendEmail")).clear();
		    driver.findElement(By.id("FriendEmail")).sendKeys("heer.qa@gmail.com");
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


