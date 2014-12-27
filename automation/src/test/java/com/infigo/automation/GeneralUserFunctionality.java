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
import com.infigo.automation.User;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private WebDriver driver;


     
    public void testSignInButton() throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));


        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.signinbutton)).click();
        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


    }

    public void resetPassword() throws Throwable{
    	 	resetPasswordTrue(EnvSetUP.getInstance().getproperties("resetpassword"));
    	 	//driver.get(EnvSetUP.getInstance().getproperties("baseurl"));	
    	 	resetPasswordTrue(EnvSetUP.getInstance().getproperties("password"));
    	
	}

	public void resetPasswordTrue(String password) throws Throwable, InterruptedException {
		//testinvlaidlogin();
		 driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
    	
		 try {
	            Assert.assertEquals("Lost your password?", driver.findElement(By.id("link-lost-password")).getText());
	            driver.findElement(By.id("link-lost-password")).click();
	        }
	        catch (Throwable t) {
	            collector.addError(t);
	            throw t;
	        }
	 
   	 
   
		driver.findElement(By.id(Browser.resetpasswordusername)).clear();
		driver.findElement(By.id(Browser.resetpasswordusername)).sendKeys("heerqa");
		driver.findElement(By.id(Browser.resetpasswordemail)).clear();
		driver.findElement(By.id(Browser.resetpasswordemail)).sendKeys("heer.qa@gmail.com");
		driver.findElement(By.id(Browser.resetpasswordfirstname)).clear();
		driver.findElement(By.id(Browser.resetpasswordfirstname)).sendKeys("heer");
		driver.findElement(By.id(Browser.resetpasswordlastname)).clear();
		driver.findElement(By.id(Browser.resetpasswordlastname)).sendKeys("naz");
		if (EnvSetUP.getInstance().getproperties("baseurl").contains("iqabinet-web")) {
			attach(Browser.secretkey_dev);	
		} else {
			attach(Browser.secretkey_alpha);
		}
		
		driver.findElement(By.id(Browser.validatebutton)).click();
		pageLoadMessage();
		
		driver.findElement(By.id(Browser.securityanswertext)).clear();
		driver.findElement(By.id(Browser.securityanswertext)).sendKeys("test");
		driver.findElement(By.id(Browser.answersecurityquestionbutton)).click();
		
		pageLoadMessage();
		
		
		driver.findElement(By.id(Browser.newpasswordfield)).clear();
		driver.findElement(By.id(Browser.newpasswordfield)).sendKeys(password);
		driver.findElement(By.id(Browser.confrimnewpassword)).clear();
		driver.findElement(By.id(Browser.confrimnewpassword)).sendKeys(password);
		driver.findElement(By.id(Browser.savebutton)).click();

		confirmPopupYes();
	}
	
     
    public void testRequestInvite() throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));


        try {
            Assert.assertTrue("Verify the Request Invite button is present", isElementPresent(By.linkText(Browser.requestinvitebutton)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        driver.findElement(By.linkText(Browser.requestinvitebutton)).click();
        try {
            Assert.assertTrue("Verify that username text field is present", isElementPresent(By.id(Browser.usernametxtfield)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        driver.findElement(By.id(Browser.usernametxtfield)).clear();
        driver.findElement(By.id(Browser.usernametxtfield)).sendKeys("test");
    }

     
    public void testWatchDemo() throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));


        try {
            Assert.assertTrue("Verify the Request Invite button is present", isElementPresent(By.linkText(Browser.watchdemobutton)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        try {
            driver.findElement(By.linkText(Browser.watchdemobutton)).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        try {
            Assert.assertFalse("Verify the Watch Demo button should not be present", isElementPresent(By.linkText(Browser.watchdemobutton)));

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


    }

     
    public void testHomeProductFeatureLink() throws Throwable {

        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));

        try {
            Assert.assertTrue("Verify that Product link is displayed", isElementPresent(By.linkText(Browser.homelink)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        try {
            Assert.assertTrue("Verify that Product link is displayed", isElementPresent(By.linkText(Browser.productlink)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        try {
            Assert.assertTrue("Verify that Company link is displayed", isElementPresent(By.linkText(Browser.companylink)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.linkText(Browser.productlink)).click();

        String pagetitle = driver.getTitle();
        try {
            Assert.assertEquals("Features", pagetitle);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.linkText(Browser.homelink)).click();
        String pagetitle1 = driver.getTitle();

        //try {
        //Assert.assertEquals("iQabinet", pagetitle1);
        //} catch (Throwable t) {
        //collector.addError(t);
        //throw t;
        //}

        driver.findElement(By.linkText(Browser.companylink)).click();
        String pagetitle2 = driver.getTitle();

        try {
            Assert.assertEquals("Company", pagetitle2);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
    }

     
    public void testSignUpbuttononProduct() throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));


        String pagetitle = driver.getTitle();
        try {
            Assert.assertEquals("iQabinet", pagetitle);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.linkText(Browser.productlink)).click();
        // selenium.waitForPageToLoad(Browser.pageloadwaittimer);

        try {
            Assert.assertTrue("Verify that Sign Up button are displayed", isElementPresent(By.linkText(Browser.signuplink)));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


        driver.findElement(By.linkText("Sign up")).click();
        // String pagetitle1= driver.getTitle();

        String webelement = driver.findElement(By.cssSelector(Browser.iqabinetlogo)).getText();

        try {
            // Assert.assertTrue("Verify that error page is not displayed", selenium.isElementPresent("css=div.inside > p"));
            Assert.assertEquals("iQabinet", webelement);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


    }

     
    public void testcrossLoginButton() throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));


        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.signinbutton)).click();
        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id("close")).click();

        String signinbuttonagain = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbuttonagain);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


    }


    /**
     * Old method name that we had before which is called from 1831032 places
     * Here we check if we should login and if so we do
     *
     * @throws Throwable
     */
     
    public void testvalidLogin() throws Throwable {
        if (BrowserUtils.getInstance().isShouldLogin()) {
            testValidLoginToIQAB();
        }
    }

     
    public void testValidLoginToIQAB() throws Throwable {
    	String usern, pass;
    	
    	String baseurl =EnvSetUP.getInstance().getproperties("baseurl") ;
    	
        driver.get(baseurl);
        
        
        usern = EnvSetUP.getInstance().getproperties("username") ;
        pass = EnvSetUP.getInstance().getproperties("password") ;

        /*String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

       // driver.findElement(By.id(Browser.signinbutton)).click();

        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
            driver.findElement(By.id(Browser.loginbutton)).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
*/
        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys(usern);
        driver.findElement(By.id(Browser.loginpassword)).clear();
        driver.findElement(By.id(Browser.loginpassword)).sendKeys(pass);
        driver.findElement(By.id(Browser.loginbutton_2)).click();
        driver.manage().window().maximize() ;
       
/*(
        try {
            Assert.assertTrue("The Pop up should be displayed if user is logged in", isElementPresent(By.linkText("Personal Documents")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
*/
        //pageLoadMessage();
        /*pageLoginMessage();
        try {
            Assert.assertTrue("The Pop Up should be displayed if user is logged in", isElementPresent(By.cssSelector(".modal-body")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
  */      //pageLoginMessageAgain();
/*
        String expectedURL = Browser.baseUrl + "user-home.html#/page/personal-documents";
        String currenturl;

        int timeCount = 1;
        boolean timeout = true;

        do {
            Thread.sleep(2000);
            currenturl = driver.getCurrentUrl();
            timeCount++;
            System.out.println(timeCount);
            if (expectedURL.equals(currenturl) || timeCount > 800) {
                timeout = false;
            }
        }
        while (timeout);
        */
        //pageLoadMessage(400);
    }


    public void testValidLoginAgain(String password, String username) throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
        String usern, pass;
       // User user = new User();
        usern = username;
        pass = password;
        
        /*String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

       // driver.findElement(By.id(Browser.signinbutton)).click();

        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
            driver.findElement(By.id(Browser.loginbutton)).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
*/
/*
        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.signinbutton)).click();

        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
*/
        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys(usern);
        driver.findElement(By.id(Browser.loginpassword)).clear();
        driver.findElement(By.id(Browser.loginpassword)).sendKeys(pass);
        driver.findElement(By.id(Browser.loginbutton_2)).click();


        pageLoadMessage();
      
        driverSleep();
    	pageLoginMessageAgain();
  /*      
        try {
            Assert.assertTrue("The Pop Up should be displayed if user is logged in", isElementPresent(By.cssSelector(".modal-body")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }*/

        pageLoadMessage(400);
     
    }
    
    
    public void testValidLoginAgain(String password, String username, int waitcounter) throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
        String usern, pass;
       // User user = new User();
        usern = username;
        pass = password;
        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys(usern);
        driver.findElement(By.id(Browser.loginpassword)).clear();
        driver.findElement(By.id(Browser.loginpassword)).sendKeys(pass);
        driver.findElement(By.id(Browser.loginbutton_2)).click();

        driverSleep();
    	
    	waitforpageLoadMessage(100);
    	
    	pageLoginMessageAgain(100);
    	driverSleep();

        
     
    }
    

    
    public void testinvlaidlogin() throws Throwable {

        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
        String usern, pass;
        User user = new User();

        usern = user.username(1);

        pass = "invalid";

        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

       // driver.findElement(By.id(Browser.signinbutton)).click();

        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
            driver.findElement(By.id(Browser.loginbutton)).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys(usern);
        driver.findElement(By.id(Browser.loginpassword)).clear();
        driver.findElement(By.id(Browser.loginpassword)).sendKeys(pass);
        driver.findElement(By.id(Browser.loginbutton_2)).click();
 pageLoadMessage();
        try {
            Assert.assertEquals("Login", driver.findElement(By.id(Browser.loginbutton)).getText());
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        pageLoadMessage();

        try {
            //TODO Need to imeplement later for error message
            String erromessage = driver.findElement(By.id("error")).getText();
            Assert.assertEquals("Invalid Username or Password", erromessage);
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }

   // @Ignore
    @Test
    public void testCreateUser() throws Throwable {
    	//Create shagufta@ironabinet if not already created
    	 driver.get(Browser.baseUrl + "/signup.html#/signup.html");
         pageLoadMessage();
       
       try {
           Assert.assertTrue("The user name txt field should be displayed", driver.findElement(By.id("txt-username")).isDisplayed());
           driver.findElement(By.id("txt-username")).clear();
           driver.findElement(By.id("txt-username")).sendKeys("Shagufta");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
      
       try {
           Assert.assertTrue("The email txt field should be displayed", driver.findElement(By.id("txt-email")).isDisplayed());
           driver.findElement(By.id("txt-email")).clear();
           driver.findElement(By.id("txt-email")).sendKeys("shagufta@ironqabinet.com");
           System.out.println("shagufta@ironqabinet.com");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       

       try {
           Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
           driver.findElement(By.id("txt-password")).clear();
           driver.findElement(By.id("txt-password")).sendKeys("At12345678");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       try {
           Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
           driver.findElement(By.id("txt-password")).clear();
           driver.findElement(By.id("txt-password")).sendKeys("At12345678");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       driver.findElement(By.id("txt-confirm-password")).clear();
       driver.findElement(By.id("txt-confirm-password")).sendKeys("At12345678");
       driver.findElement(By.id("txt-pin")).clear();
       driver.findElement(By.id("txt-pin")).sendKeys("1111");
       driver.findElement(By.id("txt-firstname")).clear();
       driver.findElement(By.id("txt-firstname")).sendKeys("Shagufta");
       driver.findElement(By.id("txt-lastname")).clear();
       driver.findElement(By.id("txt-lastname")).sendKeys("Naz");
       
       new Select(driver.findElement(By.xpath("/html/body/section/section[2]/form/div/div[2]/div/span[2]/select"))).selectByVisibleText("What was your childhood nickname?");
       driver.findElement(By.id("txt-answer-1")).clear();
       driver.findElement(By.id("txt-answer-1")).sendKeys("asdsada");
       new Select(driver.findElement(By.xpath("//div[3]/span[2]/select"))).selectByVisibleText("What was the last name of your third grade teacher?");
       driver.findElement(By.id("txt-answer-2")).clear();
       driver.findElement(By.id("txt-answer-2")).sendKeys("asdsad");
      
       new Select(driver.findElement(By.xpath("//div[5]/span[2]/select"))).selectByVisibleText("What is the country of your ultimate dream vacation?");
       driver.findElement(By.id("txt-answer-3")).clear();
       driver.findElement(By.id("txt-answer-3")).sendKeys("asdasd");
       
       Thread.sleep(2000);
       try {
       	Assert.assertTrue("The checkbox should be displayed", driver.findElement(By.xpath("html/body/section/section[2]/form/div[2]/div/div[1]/label")).isDisplayed());
       	driver.findElement(By.xpath("html/body/section/section[2]/form/div[2]/div/div[1]/label")).click();
       	//driver.findElement(By.id("checkbox-1-1")).click();
           //driver.findElement(By.cssSelector("label")).click();
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       
       try {
       	Assert.assertTrue("The Register should be displayed", driver.findElement(By.id("btn-signup")).isDisplayed());
       	driver.findElement(By.id("btn-signup")).click();
       	pageLoadMessage();
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }

    	
    	//Create qatestid112@gmail.com if not already created
    	
    	
    	//create random used to execute all test except email
       driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
       pageLoadMessage();
       
       Thread.sleep(2000);
    	 String currenttime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
         //int currentyear=Calendar.getInstance().get(Calendar.YEAR);
         String nname = "qa" + currenttime;

          driver.get(Browser.baseUrl + "/signup.html#/signup.html");
          pageLoadMessage();
        
        try {
            Assert.assertTrue("The user name txt field should be displayed", driver.findElement(By.id("txt-username")).isDisplayed());
            driver.findElement(By.id("txt-username")).clear();
            driver.findElement(By.id("txt-username")).sendKeys(nname);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
       
        try {
            Assert.assertTrue("The email txt field should be displayed", driver.findElement(By.id("txt-email")).isDisplayed());
            driver.findElement(By.id("txt-email")).clear();
            driver.findElement(By.id("txt-email")).sendKeys(nname+"@gmail.com");
            System.out.println(nname+"@gmail.com");
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        

        try {
            Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
            driver.findElement(By.id("txt-password")).clear();
            driver.findElement(By.id("txt-password")).sendKeys("At12345678");
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        
        try {
            Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
            driver.findElement(By.id("txt-password")).clear();
            driver.findElement(By.id("txt-password")).sendKeys("At12345678");
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        
        driver.findElement(By.id("txt-confirm-password")).clear();
        driver.findElement(By.id("txt-confirm-password")).sendKeys("At12345678");
        driver.findElement(By.id("txt-pin")).clear();
        driver.findElement(By.id("txt-pin")).sendKeys("1111");
        driver.findElement(By.id("txt-firstname")).clear();
        driver.findElement(By.id("txt-firstname")).sendKeys("qa4321_432");
        driver.findElement(By.id("txt-lastname")).clear();
        driver.findElement(By.id("txt-lastname")).sendKeys("qa4321-432");       
        new Select(driver.findElement(By.xpath("/html/body/section/section[2]/form/div/div[2]/div/span[2]/select"))).selectByVisibleText("What was your childhood nickname?");
        driver.findElement(By.id("txt-answer-1")).clear();
        driver.findElement(By.id("txt-answer-1")).sendKeys("asdsada");
        new Select(driver.findElement(By.xpath("//div[3]/span[2]/select"))).selectByVisibleText("What was the last name of your third grade teacher?");
        driver.findElement(By.id("txt-answer-2")).clear();
        driver.findElement(By.id("txt-answer-2")).sendKeys("asdsad");
        new Select(driver.findElement(By.xpath("//div[5]/span[2]/select"))).selectByVisibleText("What is the country of your ultimate dream vacation?");
        driver.findElement(By.id("txt-answer-3")).clear();
        driver.findElement(By.id("txt-answer-3")).sendKeys("asdasd");
        
        try {
        	Assert.assertTrue("The checkbox should be displayed", driver.findElement(By.xpath("html/body/section/section[2]/form/div[2]/div/div[1]/label")).isDisplayed());
        	driver.findElement(By.xpath("html/body/section/section[2]/form/div[2]/div/div[1]/label")).click();
        	//driver.findElement(By.id("checkbox-1-1")).click();
            //driver.findElement(By.cssSelector("label")).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        
        
        try {
        	Assert.assertTrue("The Register should be displayed", driver.findElement(By.id("btn-signup")).isDisplayed());
        	driver.findElement(By.id("btn-signup")).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        pageLoadMessage(15);
        try {
            Assert.assertTrue("The personal Document button should be displayed if user is logged in", isElementPresent(By.cssSelector(".modal-body")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
/*
        String expectedURL = Browser.baseUrl + "/user-home.html?new#/card-setup/card-definition";
        String currenturl;

        int timeCount = 1;
        boolean timeout = true;

        do {
            Thread.sleep(2000);
            currenturl = driver.getCurrentUrl();
            timeCount++;
            System.out.println(timeCount);
            if (expectedURL.equals(currenturl) || timeCount > 800) {
                timeout = false;
            }
        }
        while (timeout);
        
       */
        pageLoadMessage(300);
        try {
            Assert.assertTrue("The Cancel Buttton should be displayed", driver.findElement(By.id(Browser.canceldocument)).isDisplayed());
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.canceldocument)).click();
        
       InputStream datasheet = FileUtils.getTestContentInputStream(this.getClass(), "TestData.xlsx");
        //File url = FileUtils.getResourceFile(this.getClass(), "TestData.xlsx");
        java.net.URL resource = GeneralUserFunctionality.class.getResource("/TestData.xlsx");
        String path= new File(resource.toURI()).getAbsolutePath();

        //@SuppressWarnings("deprecation")
        
		XSSFWorkbook workbook = new XSSFWorkbook(datasheet);
       
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFCell cell =sheet.getRow(1).getCell(0);
        cell.setCellValue(nname);
        
        
        
    	FileOutputStream fileOut = new FileOutputStream(path);
    	System.out.println(path);
    	 
    	//write this workbook to an Outputstream.
    	workbook.write(fileOut);
    	fileOut.flush();
    	fileOut.close();
        
        
        
        //driver.findElement(By.cssSelector(".check>label")).click();
        
    }
    
    @Test
    public void testSignupSecurityQuestionsVadidations() throws Throwable {
    	//Create shagufta@ironabinet if not already created
    	
    	 String currenttime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
         //int currentyear=Calendar.getInstance().get(Calendar.YEAR);
         String nname = "qa" + currenttime;

    	 driver.get(Browser.baseUrl + "/signup.html#/signup.html");
         pageLoadMessage();
       
       try {
           Assert.assertTrue("The user name txt field should be displayed", driver.findElement(By.id("txt-username")).isDisplayed());
           driver.findElement(By.id("txt-username")).clear();
           driver.findElement(By.id("txt-username")).sendKeys(nname);
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
      
       try {
           Assert.assertTrue("The email txt field should be displayed", driver.findElement(By.id("txt-email")).isDisplayed());
           driver.findElement(By.id("txt-email")).clear();
           driver.findElement(By.id("txt-email")).sendKeys(nname+"@ironqabinet.com");
          
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       

       try {
           Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
           driver.findElement(By.id("txt-password")).clear();
           driver.findElement(By.id("txt-password")).sendKeys("At12345678");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       try {
           Assert.assertTrue("The password txt field should be displayed", driver.findElement(By.id("txt-password")).isDisplayed());
           driver.findElement(By.id("txt-password")).clear();
           driver.findElement(By.id("txt-password")).sendKeys("At12345678");
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       driver.findElement(By.id("txt-confirm-password")).clear();
       driver.findElement(By.id("txt-confirm-password")).sendKeys("At12345678");
       driver.findElement(By.id("txt-pin")).clear();
       driver.findElement(By.id("txt-pin")).sendKeys("1111");
       driver.findElement(By.id("txt-firstname")).clear();
       driver.findElement(By.id("txt-firstname")).sendKeys("Shagufta");
       driver.findElement(By.id("txt-lastname")).clear();
       driver.findElement(By.id("txt-lastname")).sendKeys("Naz");
       
              
       
       //1. Do not select any questions
       driver.findElement(By.xpath(Browser.signupcheckbox)).click();
       driver.findElement(By.id("btn-signup")).click();
       driverSleep();
       
       List<WebElement> errortext=driver.findElements(By.cssSelector(Browser.signuperrortext));
       int count=errortext.size();
       int counter=0;
       for (int i = 0; i < count; i++) {
    	   
    	   if ( errortext.get(i).isDisplayed()) {
    		   
    		   counter=counter+1;
		}
    	 	  
       }
       try {
          	Assert.assertEquals("Total 6 error messaes should be displayed", 6, counter);
          
          }
          catch (Throwable t) {
              collector.addError(t);
              throw t;
          }
       
       
       //fill one leave two fields
       
       new Select(driver.findElement(By.xpath("/html/body/section/section[2]/form/div/div[2]/div/span[2]/select"))).selectByVisibleText("What was your childhood nickname?");
       driver.findElement(By.id("txt-answer-1")).clear();
       driver.findElement(By.id("txt-answer-1")).sendKeys("asdsada");
       
       try {
          	Assert.assertTrue("The Register should be displayed", driver.findElement(By.id("btn-signup")).isDisplayed());
          	driver.findElement(By.id("btn-signup")).click();
          	pageLoadMessage();
          }
          catch (Throwable t) {
              collector.addError(t);
              throw t;
          }
          
          
          driver.findElement(By.id("btn-signup")).click();
          
          List<WebElement> errortext2=driver.findElements(By.cssSelector(Browser.signuperrortext));
          int count2=errortext2.size();
          counter=0;
          for (int i = 0; i < count2; i++) {
       	   
       	   if ( errortext.get(i).isDisplayed()) {
       		   
       		   counter=counter+1;
       	   }
       	  
          }  
          try {
             	Assert.assertEquals("Total 4 error messaes should be displayed", 4, counter);
             
             }
             catch (Throwable t) {
                 collector.addError(t);
                 throw t;
             }
       
        //fill 2 leave 1 fields
       
          new Select(driver.findElement(By.xpath("//div[3]/span[2]/select"))).selectByVisibleText("What was the last name of your third grade teacher?");
          driver.findElement(By.id("txt-answer-2")).clear();
          driver.findElement(By.id("txt-answer-2")).sendKeys("asdsad");
          
          try {
             	Assert.assertTrue("The Register should be displayed", driver.findElement(By.id("btn-signup")).isDisplayed());
             	driver.findElement(By.id("btn-signup")).click();
             	pageLoadMessage();
             }
             catch (Throwable t) {
                 collector.addError(t);
                 throw t;
             }
             
             
             driver.findElement(By.id("btn-signup")).click();
             
             List<WebElement> errortext3=driver.findElements(By.cssSelector(Browser.signuperrortext));
             int count3=errortext3.size();
             
             counter=0;
             for (int i = 0; i < count3; i++) {
          	   
          	   if ( errortext.get(i).isDisplayed()) {
          		   
          		   counter=counter+1;
          	   }
             }  
             
             try {
                	Assert.assertEquals("Total 2 error messaes should be displayed", 2, counter);
                
                }
                catch (Throwable t) {
                    collector.addError(t);
                    throw t;
                }
          
          
              
       
       
       

    }
   public void testregisterTermnCondition() throws Throwable{
	   driver.get(Browser.baseUrl + "/signup.html#/signup.html");
       pageLoadMessage();
       boolean iswindow=false;
       String parentHandle = driver.getWindowHandle(); // get the current window handle
       System.out.println(parentHandle);
       try {
    	  
    	   
           Assert.assertTrue("The Term and Condition link should be displayed", driver.findElement(By.cssSelector(Browser.termandcondition)).isDisplayed());
           driver.findElement(By.cssSelector(Browser.termandcondition)).click();
           driverSleep();
           for (String winHandle : driver.getWindowHandles()) {
        	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        	    String windotitle=driver.getTitle();
        	    System.out.println(windotitle);
        	    if (windotitle.equals("IQABINET TERMS OF SERVICE")) {
        	    	 iswindow=true;
					
				}
        	    
        	    
        	}
        
           
       }
       catch (Throwable t) {
           collector.addError(t);
           throw t;
       }
       
       try {
    	   
    	   Assert.assertTrue("Term and Condition page is displayed", iswindow);
		
	}catch (Throwable t) {
        collector.addError(t);
        throw t;
    }
       
       driver.close(); // close newly opened window when done with it
	   driver.switchTo().window(parentHandle); // switch back to the original window
	   
    }


    //---- UTILITY CLASSES, need to identify others.

public boolean openAttachmentorWindow(String linktext) throws Throwable {
	boolean iswindow=false;
       String parentHandle = driver.getWindowHandle(); // get the current window handle
       System.out.println(parentHandle);
       
    	  
    	   String str= new String(linktext);
    	   String[] attachment= str.split("/");
    	   String attchmentname=attachment[1];
    	   System.out.println(attchmentname);
    	   
    	   if (ifElementPresent(By.linkText(attchmentname))) {
    		   driver.findElement(By.linkText(attchmentname)).click();
    		   iswindow=true;
    	   
		} else {
			iswindow=false;
			

		}
    	   
    	   
    	   
    
    	   
    	   if (iswindow) {
               driverSleep();
               for (String winHandle : driver.getWindowHandles()) {
            	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            	    String windotitle=driver.getTitle();
            	    System.out.println(windotitle);
            	    
            	    if (windotitle.contains(attchmentname)) {
            	    	 iswindow=true;
    					
    				}
            	                 
               }
           
            driver.close(); // close newly opened window when done with it
            driver.switchTo().window(parentHandle); // switch back to the original window
           
    	   try {
        	   
        	   			Assert.assertTrue("The attached document is opened in new window", iswindow);
    		
    	   		}catch (Throwable t) {
    		   collector.addError(t);
            	throw t;
    	   	}

   }
			

           
return iswindow;
}


   public void openEditCard(String documentname) throws Throwable {
	try {
      	 Assert.assertTrue(driver.findElement(By.linkText(documentname)).isDisplayed());
           driver.findElement(By.linkText(documentname)).click();
          
          pageLoadMessage();
      }
      catch (Throwable t) {
          collector.addError(t);
          throw t;
      }
}

   

    public void browserClose() {			
        if (BrowserUtils.getInstance().isShouldBrowserBeClosed()) {
            //driver.close();
            driver.quit();
        }
    }


    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean ifElementPresent(By by)throws Throwable{
        try {
            driver.findElement(by);
            return true;
        }
        catch (Throwable t) {
            return false;
        
        }
    }
    
    public void verifyErroronLogin() throws Throwable{
    	driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
    	//Verify error message when username and password fields are blanks
    	
    	driver.findElement(By.id(Browser.loginbutton_2)).click();
    	driverSleep();
    	
    	 try {
             Assert.assertEquals("Username/Email should not be empty. Password should not be empty.", driver.findElement(By.id("error")).getText());

         }
         catch (Throwable t) {
             collector.addError(t);
             throw t;
         }

    	//Verify error message when password field is empty
    	 
    	 driver.findElement(By.id(Browser.loginemail)).clear();
         driver.findElement(By.id(Browser.loginemail)).sendKeys("someuser");
         driver.findElement(By.id(Browser.loginbutton_2)).click();
     	driverSleep();	
     	 try {
              Assert.assertEquals("Password should not be empty.", driver.findElement(By.xpath("//div[@id='error']/span[2]")).getText());

          }
          catch (Throwable t) {
              collector.addError(t);
              throw t;
          }
     	 
     	 //Verify error message when username field is empty
     	driver.findElement(By.id(Browser.loginemail)).clear();
     	 driver.findElement(By.id(Browser.loginpassword)).clear();
         driver.findElement(By.id(Browser.loginpassword)).sendKeys("somepassword");
         driver.findElement(By.id(Browser.loginbutton_2)).click();
     	driverSleep();
     	
     	 try {
              Assert.assertEquals("Username/Email should not be empty.", driver.findElement(By.cssSelector("span.ng-binding")).getText());

          }
          catch (Throwable t) {
              collector.addError(t);
              throw t;
          }
     	 
     	 //Verify error message when invlaid username or password
     	 
     	 driver.findElement(By.id(Browser.loginemail)).clear();
         driver.findElement(By.id(Browser.loginemail)).sendKeys("heer.qa@gmail.com");
         driver.findElement(By.id(Browser.loginpassword)).clear();
         driver.findElement(By.id(Browser.loginpassword)).sendKeys("somepassword");
         driver.findElement(By.id(Browser.loginbutton_2)).click();
     	driverSleep();
     	
     	 try {
              Assert.assertEquals("Invalid Username or Password", driver.findElement(By.xpath("//div[@id='error']/span[3]")).getText());

          }
          catch (Throwable t) {
              collector.addError(t);
              throw t;
          }

     	 try {
             Assert.assertEquals("Lost your password?", driver.findElement(By.id("link-lost-password")).getText());

         }
         catch (Throwable t) {
             collector.addError(t);
             throw t;
         }


     	 try {
             Assert.assertEquals("Need to create an account?", driver.findElement(By.id("link-create-account")).getText());

         }
         catch (Throwable t) {
             collector.addError(t);
             throw t;
         }


     	 try {
             Assert.assertEquals("Back to iQabinet", driver.findElement(By.id("link-back-to-iqab")).getText());

         }
         catch (Throwable t) {
             collector.addError(t);
             throw t;
         }

     	 
     	driver.findElement(By.id("link-back-to-iqab")).click();
     	driverSleep(6000);
     	
     	
     	try {
            Assert.assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

     	
     	


    }
    
    public void verifyErroronSignup() throws Throwable{
    	driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
    	//System.out.println();
    	Assert.assertEquals("Need to create an account?",driver.findElement(By.id("link-create-account")).getText());
    	driver.findElement(By.id("link-create-account")).click();
    	driverSleep(8000);
    	
    	driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys("heer.qa@wqeqwe123.com");
        driver.findElement(By.id(Browser.singupbutton)).click();
        driverSleep();
    	
        try {
            Assert.assertEquals("Please enter valid email", driver.findElement(By.cssSelector("span.ng-binding")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        
        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys("heer.qa");
        driver.findElement(By.id(Browser.singupbutton)).click();
        driverSleep();
    	
        try {
            Assert.assertEquals("Error, invalid email address.", driver.findElement(By.cssSelector("span.ng-binding")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        
        
        driver.findElement(By.id(Browser.loginemail)).clear();
        //driver.findElement(By.id(Browser.loginemail)).sendKeys("heer.qa");
        driver.findElement(By.id(Browser.singupbutton)).click();
        driverSleep();
    	
        try {
            Assert.assertEquals("Please enter email address.", driver.findElement(By.cssSelector("span.ng-binding")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        
        try {
            Assert.assertEquals("Need to login?", driver.findElement(By.id("link-lost-password")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        
        try {
            Assert.assertEquals("Back to iQabinet", driver.findElement(By.id("link-back-to-iqab")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id("link-back-to-iqab")).click();
     	driverSleep(6000);
     	
     	
     	try {
            Assert.assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }


    }

    public void verifyErroronResetPassword() throws Throwable{
    	boolean emailvalidate=false;
		String baseUrl=EnvSetUP.getInstance().getproperties("baseurl");
		driver.get(baseUrl + "/reset.html");
		
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(EnvSetUP.getInstance().getproperties("goodemailid"));
	    driver.findElement(By.id("btn-register")).click();
	    confirmPopupYes();
	    
	    driverSleep(90000);
		//System.out.println(resetKey());
		if (!resetKey().equals("EmailNotReceived")) {
			emailvalidate=true;
			driver.get(" https://iqabinet-web.herokuapp.com/password-reset.html#/?request=" +resetKey());
			driverSleep();
			pageLoadMessage();
			driver.findElement(By.id(Browser.securityanswertext)).clear();
			driver.findElement(By.id(Browser.securityanswertext)).sendKeys("test");
			driver.findElement(By.id(Browser.answersecurityquestionbutton)).click();
			driverSleep(4000);
			pageLoadMessage();
			
			
			driver.findElement(By.id(Browser.newpasswordfield)).clear();
		driver.findElement(By.id(Browser.newpasswordfield)).sendKeys("Xq Sf_-a9D");
		driver.findElement(By.id(Browser.confrimnewpassword)).clear();
		driver.findElement(By.id(Browser.confrimnewpassword)).sendKeys("Xq Sf_-a9D");
		driver.findElement(By.id(Browser.savebutton)).click();
		
		driverSleep();
		
		try {
            Assert.assertEquals("Password should not contains white space.", driver.findElement(By.cssSelector("div.formitem > span.errortext.ng-binding")).getText());
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
		
		driver.findElement(By.id(Browser.newpasswordfield)).clear();
		driver.findElement(By.id(Browser.newpasswordfield)).sendKeys("UBbnbewaEHM5g3LPadUxPwyw2n8WqRTn");
		driver.findElement(By.id(Browser.confrimnewpassword)).clear();
		driver.findElement(By.id(Browser.confrimnewpassword)).sendKeys("UBbnbewaEHM5g3LPadUxPwyw2n8WqRTn");
		driver.findElement(By.id(Browser.savebutton)).click();
		
		driverSleep();
		
		try {
            Assert.assertEquals("Password must in the format of maximum 16 characters contains the combination of upper case, lower case and number.", driver.findElement(By.cssSelector("div.formitem > span.errortext.ng-binding")).getText());
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

}
		

    }
    
    public void userLogin(String usern, String pass) throws Throwable {
        driver.get(EnvSetUP.getInstance().getproperties("baseurl"));
        

        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.signinbutton)).click();

        String loginbutton = driver.findElement(By.id(Browser.loginbutton)).getText();


        try {
            Assert.assertEquals("Login", loginbutton);
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.loginemail)).clear();
        driver.findElement(By.id(Browser.loginemail)).sendKeys(usern);
        driver.findElement(By.id(Browser.loginpassword)).clear();
        driver.findElement(By.id(Browser.loginpassword)).sendKeys(pass);
        driver.findElement(By.id(Browser.loginbutton)).click();

pageLoadMessage();
        try {
            Assert.assertTrue("The Pop up should be displayed if user is logged in", isElementPresent(By.linkText("Personal Documents")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        try {
            Assert.assertTrue("The personal Document button should be displayed if user is logged in", isElementPresent(By.cssSelector(".modal-body")));
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        String expectedURL = Browser.baseUrl + "user-home.html#/page/personal-documents";
        String currenturl;

        int timeCount = 1;
        boolean timeout = true;

        do {
            Thread.sleep(2000);
            currenturl = driver.getCurrentUrl();

            //Thread.sleep(2000);
            timeCount++;
            System.out.println(timeCount);
            if (expectedURL.equals(currenturl) || timeCount > 200) {
                timeout = false;


            }
        }
        while (timeout);
        Thread.sleep(2000);


    }
    
	public void pageLoadMessage() throws InterruptedException {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(500);
            timeCounter++;
          // System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (!driver.findElement(By.className("modal-body")).isDisplayed()|| timeCounter > 80) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public void pageLoginMessage() throws Throwable {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(2000);
            timeCounter++;
           System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (!ifElementPresent(By.id("dialog-body-text"))|| timeCounter > 100 ||ifElementPresent(By.id(Browser.backbuttonyes))) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public void pageLoginMessageAgain() throws Throwable {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(2000);
            timeCounter++;
           System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (!ifElementPresent(By.id("dialog-body-text"))|| timeCounter > 100 ) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public void pageLoginMessageAgain(int waitcounter) throws Throwable {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(2000);
            timeCounter++;
           System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (!ifElementPresent(By.id("dialog-body-text"))|| timeCounter > waitcounter) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	public void cardDeletePopup() throws Throwable {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(2000);
            timeCounter++;
           if (!ifElementPresent(By.id("progress-dialog-progress-msg"))|| timeCounter > 400) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public void pageLoadMessage(int count) throws InterruptedException {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(500);
            timeCounter++;
           //System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (!driver.findElement(By.className("modal-body")).isDisplayed()|| timeCounter > 100) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public void waitforpageLoadMessage(int count) throws Throwable {
		int timeCounter = 1;
        boolean timeout = true;
        do {
            Thread.sleep(500);
            timeCounter++;
           //System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (ifElementPresent(By.className("modal-body"))|| timeCounter > 100) {
            //	System.out.println("Maximum counter is 101");
                timeout = false;
            }
        }
        while (timeout);
       
	}
	
	public String cardID(String cardname) throws Throwable {
		try {
            Assert.assertTrue("The Card name should be displayed", driver.findElement(By.linkText(cardname)).isDisplayed());
       
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        String cardid=driver.findElement(By.linkText(cardname)).getAttribute("id");
        System.out.println(cardid);
        String[] parts = cardid.split("-");
        String elementid=parts[2];
        System.out.println(elementid);
		return elementid;
	}
	
	public void driverSleep() throws Throwable{
		try {
			Thread.sleep(4000);       
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
		
	}

public void ifconfirmPopupYes() throws Throwable, InterruptedException {
		
		try {
			if (ifElementPresent(By.id(Browser.backbuttonyes))) {
				
	            driver.findElement(By.id(Browser.backbuttonyes)).click();
	            System.out.println("Yes button is displayed");
	            pageLoadMessage();
			}
             
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        //pageLoadMessage(15);
	}
	
	public void confirmPopupYes() throws Throwable, InterruptedException {
		
		try {
            Assert.assertTrue(driver.findElement(By.id(Browser.backbuttonyes)).isDisplayed());
            driver.findElement(By.id(Browser.backbuttonyes)).click();
            System.out.println("Yes button is displayed");
           // pageLoadMessage();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
        //pageLoadMessage(15);
	}
	
public void confirmPopupNo() throws Throwable, InterruptedException {
	WebElement ele=driver.findElement(By.id(Browser.backbuttonno));
	if (ifElementPresent(By.id(Browser.backbuttonno))) {
		System.out.println("Close button is displayed");
		
		ele.click();
		
        System.out.println("Close button is clicked");
	}
		
}

	
	public void driverSleep(long time) throws Throwable{
		try {
			Thread.sleep(time);       
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
		
	}
	


	public boolean isDocumentInTimeline(String cardname, String documentname) throws Throwable {
		boolean documentintimeline=false;
		
		String str= new String(documentname);
  	   	String[] attachment= str.split("/");
  	   	String attchmentname=attachment[1];
  	   	
  	     	
    	for (int i = 0; i <= 99; i++) {
    		
    		    		
    		if (ifElementPresent(By.id("timeline_document_"+String.format("%02d", i)))) {
    			
    			if (driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText().contains(cardname) && driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getAttribute("title").contains(attchmentname)) {
    				
    				
    					documentintimeline=true;	
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getAttribute("title"));
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText());	
    				
				}
    			
    			
    			
			} else {
				System.out.println("Docoument not present is timeline_document_"+String.format("%02d", i));
				break;

			}
    		
    		
    		
    	}
		return documentintimeline;
	}
	
	public boolean isSharedDocumentInTimeline(String cardname,String documentname) throws Throwable {
		boolean documentintimeline=false;
		String str= new String(documentname);
  	   	String[] attachment= str.split("/");
  	   	String attchmentname=attachment[1];
  	   	
  	   	
  	   	for (int i = 0; i < 5; i++) {
  	   		
  	   		driverSleep();
  	   		
  	   		System.out.println("------------vaidate the documents in timeline------------------");
  	   		System.out.println(driver.findElement(By.id("timeline_document_00")).getText());
  	   	    System.out.println(cardname);
  	   		System.out.println("-----------------ends------------------------");
  	   		
  	   		
  	  	if (driver.findElement(By.id("timeline_document_00")).getText().contains(cardname)) {
			
			
			documentintimeline=true;	
					
			break;
			
			
			
		} else
		{
			System.out.println("Docoument not present is timeline_document");
			

		}
			
		}
      		    		
    	
    		
    		
    		System.out.println(documentintimeline);
    	
		return documentintimeline;
	}

	
	public boolean isSharedWithCardInTimeline(String cardname, String usersharedwith) throws Throwable {
		boolean documentintimeline=false;
		  	     	
    	for (int i = 0; i <= 99; i++) {
    		
    		    		
    		if (ifElementPresent(By.id("timeline_document_"+String.format("%02d", i)))) {
    			
    			if (driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText().contains(cardname)) {
    				
    					//Assert.assertEquals("Shared (with "+usersharedwith+"): "+cardname+" ", driver.findElement(By.id("timeline_document_00")).getAttribute("title"));
    					documentintimeline=true;	
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getAttribute("title"));
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText());	
    					break;
    				
				}
    			
    			
    			
			} else {
				System.out.println("Card not present is timeline_document_"+String.format("%02d", i));
				break;

			}
    		
    		
    		
    	}
		return documentintimeline;
	}
	
	public boolean isSharedFromCardInTimeline(String cardname, String sharingusername) throws Throwable {
		boolean documentintimeline=false;
		  	     	
    	for (int i = 0; i <= 99; i++) {
    		
    		    		
    		if (ifElementPresent(By.id("timeline_document_"+String.format("%02d", i)))) {
    			
    			if (driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText().contains("Shared")) {
    					System.out.println(driver.findElement(By.id("timeline_document_00")).getAttribute("title"));
    					Assert.assertEquals("Shared (from "+sharingusername+"): "+cardname+" ", driver.findElement(By.id("timeline_document_00")).getAttribute("title"));
    					documentintimeline=true;	
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getAttribute("title"));
    					System.out.println(driver.findElement(By.id("timeline_document_"+String.format("%02d", i))).getText());	
    					break;
    				
				}
    			
    			
    			
			} else {
				System.out.println("Card not present is timeline_document_"+String.format("%02d", i));
				break;

			}
    		
    		
    		
    	}
		return documentintimeline;
	}


	public boolean isIntitutionIconPresent(String institutionname, String cardicon) throws Throwable {
		boolean indicator=false;
		int timeCounter = 1;
        boolean timeout = true;
        System.out.println("Click on edit instution");
		typeAheadFieldInput(Browser.editinstitution, institutionname);
		System.out.println("click on pop up");
		retriveDocumentPopup();
		System.out.println("Clicked on pop up");
        /*
		try {
		    Assert.assertTrue(driver.findElement(By.xpath(Browser.taxreturnlocationinput)).isDisplayed());
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(institutionname);
		    Thread.sleep(100);
		    driver.findElement(By.xpath(Browser.taxretuenlocationselect)).click();
		   
		    
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
		*/
		
        do {
            Thread.sleep(500);
            timeCounter++;
           //System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (driver.findElement(By.id(Browser.cardid)).getAttribute("src").contains(cardicon)|| timeCounter > 100) {
            //	System.out.println("Maximum counter is 101");
            	indicator=true;
            	driverSleep(1000);
                
                if (timeCounter > 100) {
                	indicator=false;					
				}
                timeout = false;
            }
        }while(timeout);
          
		return indicator;
     }
	
	public boolean isIntitutionIconPresentATandT( String cardicon) throws Throwable {
		boolean indicator=false;
		int timeCounter = 1;
        boolean timeout = true;
        

		typeAheadFieldInput(Browser.editinstitution, "AT"+"&amp;"+"T");
		retriveDocumentPopup();
		/*try {
		    Assert.assertTrue(driver.findElement(By.xpath(Browser.taxreturnlocationinput)).isDisplayed());
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys("AT"+"&amp;"+"T");
		    Thread.sleep(100);
		    driver.findElement(By.xpath(Browser.taxretuenlocationselect)).click();
		   
		    
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
		*/
		
        do {
            Thread.sleep(500);
            timeCounter++;
           //System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (driver.findElement(By.id(Browser.cardid)).getAttribute("src").contains(cardicon)|| timeCounter > 100) {
            //	System.out.println("Maximum counter is 101");
            	indicator=true;
            	driverSleep(1000);
                
                if (timeCounter > 100) {
                	indicator=false;					
				}
                timeout = false;
            }
        }while(timeout);
          
		return indicator;
     }
	
	public boolean isIntitutionIconPresentBBandT( String cardicon) throws Throwable {
		boolean indicator=false;
		int timeCounter = 1;
        boolean timeout = true;
        

		typeAheadFieldInput(Browser.editinstitution, "BB&T");
		retriveDocumentPopup();
		/*try {
		    Assert.assertTrue(driver.findElement(By.xpath(Browser.taxreturnlocationinput)).isDisplayed());
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(Browser.taxreturnlocationinput)).sendKeys("BB&T");
		    Thread.sleep(100);
		    driver.findElement(By.xpath(Browser.taxretuenlocationselect)).click();
		   
		    
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
		*/
		
        do {
            Thread.sleep(500);
            timeCounter++;
           //System.out.println("Page is still loading. The couner is = "+timeCounter);
            if (driver.findElement(By.id(Browser.cardid)).getAttribute("src").contains(cardicon)|| timeCounter > 100) {
            //	System.out.println("Maximum counter is 101");
            	indicator=true;
            	driverSleep(1000);
                
                if (timeCounter > 100) {
                	indicator=false;					
				}
                timeout = false;
            }
        }while(timeout);
          
		return indicator;
     }
	
	
	public void verifyIconforAllInstituion() throws Throwable {
		System.out.println("assert wells forgo");
		try {
	        Assert.assertTrue("The card image should be that of Wells Fargo on Create Card page", isIntitutionIconPresent("Wells Fargo", "wells"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
		
		//driverSleep(5000);
		System.out.println("assert Bank of America");
    	try {
	        Assert.assertTrue("The card image should be that of Bank of America on Create Card page", isIntitutionIconPresent("Bank of America", "boa"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Charles Schwab on Create Card page", isIntitutionIconPresent("Charles Schwab", "schwab"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of American Express on Create Card page", isIntitutionIconPresent("American Express", "amex"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Geico on Create Card page", isIntitutionIconPresent("Geico", "geico"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Liberty Mutual on Create Card page", isIntitutionIconPresent("Liberty Mutual", "liberty-mutual"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Apple on Create Card page", isIntitutionIconPresent("Apple", "apple"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	
    	try {
	        Assert.assertTrue("The card image should be that of Google on Create Card page", isIntitutionIconPresent("Google", "google"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Pepco on Create Card page", isIntitutionIconPresent("Pepco", "pepco"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Verizon on Create Card page", isIntitutionIconPresent("Verizon", "verizon"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of ADP on Create Card page", isIntitutionIconPresent("ADP", "adp"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of ADP iPayStatements on Create Card page", isIntitutionIconPresent("ADP iPayStatements", "adp"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Chase on Create Card page", isIntitutionIconPresent("Chase", "chase"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	try {
	        Assert.assertTrue("The card image should be that of T. Rowe Price Retirement on Create Card page", isIntitutionIconPresent("T. Rowe Price Retirement", "troweprice"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of USAA on Create Card page", isIntitutionIconPresent("USAA", "usaa"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Verizon Residential on Create Card page", isIntitutionIconPresent("Verizon Residential", "verizon"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }	
	    
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Amazon on Create Card page", isIntitutionIconPresent("Amazon", "amazon"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	/*
    	try {
	        Assert.assertTrue("The card image should be that of AT&T on Create Card page", isIntitutionIconPresentATandT("att"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        
	        throw t;
	    }
		*/
    	//driverSleep(5000);
    	
    	try {
	        Assert.assertTrue("The card image should be that of Capital One on Create Card page", isIntitutionIconPresent("Capitalone Bank", "capitalone"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of PayPal on Create Card page", isIntitutionIconPresent("PayPal", "paypal"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	driverSleep(5000);
    	/*
    	try {
	        Assert.assertTrue("The card image should be that of BB&T on Create Card page", isIntitutionIconPresentBBandT("bbt"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	
    	driverSleep(5000);
    	*/
    	try {
	        Assert.assertTrue("The card image should be that of Toyota on Create Card page", isIntitutionIconPresent("Toyota", "toyota"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
    	//driverSleep(5000);
    	try {
	        Assert.assertTrue("The card image should be that of Aetna on Create Card page", isIntitutionIconPresent("Aetna", "aetna"));
	        
	    }
	    catch (Throwable t) {
	        collector.addError(t);
	        throw t;
	    }
	}
	
	
	public void userSetttingPages(String pagename) throws Throwable{

        try {
            Assert.assertTrue("The username should be displayed", driver.findElement(By.id(Browser.username)).isDisplayed());
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }

        driver.findElement(By.id(Browser.username)).click();
        Thread.sleep(2000);
        
        WebDriverWait wait= new WebDriverWait(driver, 3);
        Actions builder =new Actions(driver);
        WebElement menu1=wait.until(visibilityOfElecmentLocated(By.id(Browser.username)));
        builder.moveToElement(menu1).build().perform();
        driverSleep();
        
        driver.findElement(By.id(pagename)).click();
        pageLoadMessage();
       driverSleep();
	}

	public void userSettingPages(String submenu, String menu) throws Throwable{
		driver.findElement(By.id(Browser.username)).click();
		driverSleep(2000);
		driver.findElement(By.id(submenu)).click();
		driverSleep(2000);
		driver.findElement(By.id(menu)).click();
	    driverSleep(2000);
		pageLoadMessage();
/*		WebDriverWait wait= new WebDriverWait(driver, 5);
        Actions builder =new Actions(driver);


       driver.findElement(By.id(Browser.username)).click();
       driverSleep(2000);
       WebElement menu1=wait.until(visibilityOfElecmentLocated(By.id(Browser.username)));
       builder.moveToElement(menu1).build().perform();
       System.out.println("mouserover to username");
       if (!driver.findElement(By.id(submenu)).isDisplayed()) {
    	   driver.findElement(By.id(Browser.username)).click();
       }
       
      

        driverSleep(2000);
        WebElement menu2=wait.until(visibilityOfElecmentLocated(By.id(submenu)));
        builder.moveToElement(menu2);
        
        System.out.println("Mouser over to sub menu");
        if (!driver.findElement(By.id(menu)).isDisplayed()) {
        	 WebElement menu4=wait.until(visibilityOfElecmentLocated(By.id(submenu)));
        	builder.moveToElement(menu4);
        	driver.findElement(By.id(submenu)).click();
        	System.out.println("clicked submenu");
     }

        
        //driver.findElement(By.id(Browser.documentretrival)).click();
        System.out.println("clicked on document retrival");
        driverSleep(2000);
       WebElement menu3=wait.until(visibilityOfElecmentLocated(By.id(menu)));
       builder.moveToElement(menu3).build().perform();
       driver.findElement(By.id(menu)).click();
       System.out.println("Clicked on menu link");
*/
	}
	
	
	public ExpectedCondition<WebElement> visibilityOfElecmentLocated(final By locator){
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver){
				WebElement toReturn =driver.findElement(locator);
				if(toReturn.isDisplayed()){
					return toReturn;
				}
				return null;
			}
		};
		
	}
	
	
	public boolean isAttachmentPresentinCard(String linktext) throws Throwable{
		boolean iswindow=false;
 	   String str= new String(linktext);
 	   String[] attachment= str.split("/");
 	   String attchmentname=attachment[1];
 	   System.out.println(attchmentname);
 	   
 	   if (ifElementPresent(By.linkText(attchmentname))) {
 		   driver.findElement(By.linkText(attchmentname)).click();
 		   iswindow=true;
 	   
		} else {
			iswindow=false;
			

		}
	return iswindow;
	}
	
	public void typeAheadFieldInput(String inputId, String value) throws Throwable {
		
		
		List<WebElement> typeahead=driver.findElements(By.className("select2-input"));
		int size=typeahead.size();
		System.out.println("number of type ahead field on the card :"+size);
		if (inputId.equals(Browser.belongstoinput)) {
			

			WebElement clearelement=driver.findElements(By.cssSelector(".select2-search-choice-close")).get(0);
			System.out.println("Number of prepopulated fields :"+driver.findElements(By.cssSelector(".select2-search-choice-close")).size());
			clearelement.click();
						
			typeahead.get(0).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
			
		}
		
		if (inputId.equals(Browser.editinstitution)) {
			
			System.out.println("Number of prepopulated fields :"+driver.findElements(By.cssSelector(".select2-search-choice-close")).size());
			WebElement clearelement=driver.findElements(By.cssSelector(".select2-search-choice-close")).get(1);
			
			clearelement.click();
						
			typeahead.get(1).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
			
		}

		
		if (inputId.equals(Browser.residenceinput)) {
			
			WebElement clearelement=driver.findElements(By.cssSelector(".select2-search-choice-close")).get(1);
			/*
			try {
				Assert.assertEquals("The default value in the residence field should be Home", "Home",driver.findElements(By.cssSelector(".select2-search-choice-close")).get(1).getAttribute("value"));
				
			} catch (Throwable t) {
	            collector.addError(t);
	            throw t;
			}
			*/
			System.out.println("Number of prepopulated fields :"+driver.findElements(By.cssSelector(".select2-search-choice-close")).size());
			clearelement.click();
						
			typeahead.get(1).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
			
		}
		
		if (inputId.equals(Browser.typeahed2)) {

			
			typeahead.get(1).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
		
		}
		
		if (inputId.equals(Browser.typeahedpeopleoshare)) {
			System.err.println("People to share field is displaed");

			
			typeahead.get(0).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
		
		}
		
		
		if (inputId.equals(Browser.typeahed3)) {

					
			typeahead.get(2).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
		
		}
		
		if (inputId.equals(Browser.bithcirtificatestoragelocation)) {

			
			typeahead.get(1).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
		
		}
		
		if (inputId.equals(Browser.Marriagecirtificatestoragelocation)) {

			
			typeahead.get(2).sendKeys(value);
			driverSleep();
			
			if (ifElementPresent(By.cssSelector(".select2-created-search-choice"))) {
				driver.findElement(By.cssSelector(".select2-created-search-choice")).click();	
			}
			
			if (ifElementPresent(By.cssSelector(".select2-match"))) {
				driver.findElement(By.cssSelector(".select2-match")).click();
			}
		
		}
		
		
	}
	public String documentName(String document) throws Throwable{
		String str= new String(document);
	   	String[] attachment= str.split("/");
	   	String attchmentname=attachment[1];
		return attchmentname;
	}
	
	public void dateFieldInput(String inputId, String value) throws Throwable {		
		try {
			Assert.assertTrue("The "+inputId+"Field should be displayed", driver.findElement(By.id(inputId)).isDisplayed());
			driver.findElement(By.id(inputId)).sendKeys(value);
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
		
	}
	
	public void numericFieldInput(String inputId, String value) throws Throwable {	
		
		try {
			Assert.assertTrue("The "+inputId+"Field should be displayed", driver.findElement(By.id(inputId)).isDisplayed());
			driver.findElement(By.id(inputId)).sendKeys(value);
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
		
	}
	
	public void alphanumericFieldInput(String inputId, String value) throws Throwable {		
		try {
			Assert.assertTrue("The "+inputId+"Field should be displayed", driver.findElement(By.id(inputId)).isDisplayed());
			driver.findElement(By.id(inputId)).sendKeys(value);
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
		
	}
	
	public void selectFieldInput(String inputId, String value) throws Throwable {		
		 try {
	            Assert.assertTrue(driver.findElement(By.id(inputId)).isDisplayed());
	            new Select(driver.findElement(By.id(inputId))).selectByVisibleText(value);
	        }
	        catch (Throwable t) {
	            collector.addError(t);
	            throw t;
	        }
		
		
	}
	
	public void selectCheckBox(String cardcheckbox) throws Throwable{
		String elementid=null;
		String getid=null;
		List<WebElement> checkbox = driver.findElements(By.cssSelector(Browser.checkboxlabel));
		int numberofchebox=checkbox.size();
		System.out.println(numberofchebox);

		for (int i = 0; i < numberofchebox; i++) 
		{
			elementid= ((WebElement) checkbox.get(i)).getAttribute("id");
			
			if (elementid.equals(cardcheckbox)) {
				getid=elementid;
				((WebElement) checkbox.get(i)).click();
				System.out.println(getid);
				
			}
				
			}
		
	}
	
	public void selectCheckBox(String cardcheckbox, Integer cheboxnumber) throws Throwable{
		String elementid=null;
		String getid=null;
		List<WebElement> checkbox = driver.findElements(By.cssSelector(Browser.checkboxlabel));
		int numberofchebox=checkbox.size();
		System.out.println(numberofchebox);

		for (int i = 0; i < numberofchebox; i++) 
		{
			elementid= ((WebElement) checkbox.get(i)).getAttribute("id");
			
			if (elementid.equals(cardcheckbox)) {
				getid=elementid;
				((WebElement) checkbox.get(cheboxnumber)).click();
				System.out.println(getid);
				
			}
				
			}
		
	}
	
	public void clickElementUsingJavaScriptID(String elementid)throws Throwable{
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("document.getElementById('"+elementid+"').click();");
	}
	

	public String currentTime() throws Throwable{
		String currenttime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return currenttime;
	}
	
	public void clickCreateButton() throws Throwable{
		
		try {
			Assert.assertTrue("The create button on card should be displayed", driver.findElement(By.linkText(Browser.create)).isDisplayed());
			driver.findElement(By.linkText(Browser.create)).click();
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
	}
	
public void clickFinishLaterButton() throws Throwable{
		
		try {
			Assert.assertTrue("The Finish Later  button on card should be displayed", driver.findElement(By.id(Browser.finishlater)).isDisplayed());
			driver.findElement(By.id(Browser.finishlater)).click();
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
	}
	
	public void clickUpdateButton() throws Throwable{
		
		try {
			Assert.assertTrue("The create button on card should be displayed", driver.findElement(By.linkText(Browser.editupdatebutton)).isDisplayed());
			driver.findElement(By.linkText(Browser.editupdatebutton)).click();
			
		} catch (Throwable t) {
            collector.addError(t);
            throw t;
		}
		
	}
	
	public void clickArrowButton() throws Throwable{
		try {
            Assert.assertTrue("The Arrow icon should be displayed", driver.findElement(By.className(Browser.summaryarrowicon2)).isDisplayed());
            driver.findElement(By.className(Browser.summaryarrowicon2)).click();
        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
	}
	
	public void getScreenShot(String screenshotname) throws Throwable{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=FileUtils.getUserDir();
		System.out.println(path);
	    org.apache.commons.io.FileUtils.copyFile(scrFile, new File(path+"/target/ScreensonError/"+screenshotname+".png"));
     
	}
	
	public void removeAttachment(String attahchment) throws Throwable,
	InterruptedException {
		try {
	
    Assert.assertTrue(driver.findElement(By.id(attahchment)).isDisplayed());
    System.out.println("Attachmnet is displayed on edit card page");
    driver.findElement(By.id(attahchment)).click();
    System.out.println("Attachment is removed from edit card page");

		}
		catch (Throwable t) {
    collector.addError(t);
    throw t;
		}


		confirmPopupYes();
		pageLoadMessage();
		
	}

	public void actionSingleCard(String actionname) throws Throwable {
		driverSleep();
		clickSignleCheckox(Browser.summarycardchecbox);

		try {
			Assert.assertTrue(driver.findElement(By.id(Browser.actionlistbox)).isDisplayed());
			driver.findElement(By.id(Browser.actionlistbox)).click();
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
		
		try {
			Assert.assertTrue(driver.findElement(By.linkText(actionname)).isDisplayed());
			driver.findElement(By.linkText(actionname)).click();
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}



	public void clickSignleCheckox(String checkbox) {
		List<WebElement> cardcheckbox = driver.findElements(By.cssSelector(checkbox));
		int numberofcards=cardcheckbox.size();
		System.out.println(numberofcards);

		for (int i = 0; i < numberofcards; i++) 
		{
			 ((WebElement) cardcheckbox.get(i)).click();
			 
		
		}
	}
	
	public void sharingEmailPopUPFieldsandCancel(String username) throws Throwable {
		try {
			Assert.assertEquals("Share", driver.findElement(By.cssSelector(Browser.sharingpopup2header)).getText());
			Assert.assertEquals(username, driver.findElement(By.cssSelector(Browser.sharingpopup3body)).getText());
			Assert.assertTrue("The email field is displayed",driver.findElement(By.name(Browser.sharingpopup3email)).isDisplayed());
			Assert.assertEquals("Email Address", driver.findElement(By.name(Browser.sharingpopup3email)).getAttribute("placeholder"));
			Assert.assertEquals("View", driver.findElement(By.id(Browser.sharingpermissionview)).getText());
			Assert.assertEquals("Manage", driver.findElement(By.id(Browser.sharingpermissionmanage)).getText());
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
			}
			
			Assert.assertEquals("Cancel", driver.findElement(By.id(Browser.sharecancel)).getText());
			driver.findElement(By.id(Browser.sharecancel)).click();
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	public void sharingRegisteredUserPopUPFieldsandCancel(String username) throws Throwable {
		try {
			Assert.assertEquals("Share", driver.findElement(By.cssSelector(Browser.sharingpopup2header)).getText());
			Assert.assertEquals(username, driver.findElement(By.cssSelector(Browser.sharingpopup2body)).getText());
			Assert.assertEquals("View", driver.findElement(By.id(Browser.sharingpermissionview)).getText());
			Assert.assertEquals("Manage", driver.findElement(By.id(Browser.sharingpermissionmanage)).getText());
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
			}
			
			Assert.assertEquals("Cancel", driver.findElement(By.id(Browser.sharecancel)).getText());
			driver.findElement(By.id(Browser.sharecancel)).click();
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	public void sharingEmailPopUPFieldsandNext(String username) throws Throwable {
		try {
			
			pageLoadMessage();
			driverSleep();
			//selectCheckBox(".chbb.ng-scope>label", 1);
			driver.findElement(By.id(Browser.sharingpopup3email)).sendKeys("ewerwer");
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
				driver.findElement(By.id(Browser.sharebutton)).click();
			}
			
			Assert.assertEquals("Please provide valid email address", driver.findElement(By.id(Browser.shareemailvalidationmsg)).getText());
			clickElementUsingJavaScriptID(Browser.sharingmanagepermissioncheckbox);
			driver.findElement(By.id(Browser.sharingpopup3email)).clear();
			driver.findElement(By.id(Browser.sharingpopup3email)).sendKeys(username+"@gmail.com");
			
			
			driver.findElement(By.id(Browser.sharebutton)).click();
			
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	public void sharingRegisteredUserPopUPFieldsandNext(String username) throws Throwable {
		try {
			
			pageLoadMessage();
			driverSleep();
			//selectCheckBox(".chbb.ng-scope>label", 1);
			
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
				driver.findElement(By.id(Browser.sharebutton)).click();
			}
			
			
			clickElementUsingJavaScriptID(Browser.sharingmanagepermissioncheckbox);
			
			
			driver.findElement(By.id(Browser.sharebutton)).click();
			
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	public void sharingEmailPopUPFieldsandShare(String username) throws Throwable {
		try {
			
			
			//selectCheckBox(".chbb.ng-scope>label", 1);
			pageLoadMessage();
			driverSleep();
			driver.findElement(By.id(Browser.sharingpopup3email)).sendKeys("ewerwer");
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
				driver.findElement(By.id(Browser.sharebutton)).click();
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
				
			}
			
			Assert.assertEquals("Please provide valid email address", driver.findElement(By.id(Browser.shareemailvalidationmsg)).getText());
			clickElementUsingJavaScriptID(Browser.sharingmanagepermissioncheckbox);
			driver.findElement(By.id(Browser.sharingpopup3email)).clear();
			driver.findElement(By.id(Browser.sharingpopup3email)).sendKeys(username+"@gmail.com");
			
			
			driver.findElement(By.id(Browser.sharebutton)).click();
			
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	public void sharingRegisteredUserPopUPFieldsandShare(String username) throws Throwable {
		try {
			
			
			//selectCheckBox(".chbb.ng-scope>label", 1);
			pageLoadMessage();
			driverSleep();
			
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
				driver.findElement(By.id(Browser.sharebutton)).click();
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
				
			}
			
			
			clickElementUsingJavaScriptID(Browser.sharingmanagepermissioncheckbox);
			
			
			driver.findElement(By.id(Browser.sharebutton)).click();
			
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	
	public void sharingCardWithUser(String email, String permission) throws Throwable {
		try {
			
			
			//selectCheckBox(".chbb.ng-scope>label", 1);
			pageLoadMessage();
			driverSleep();
			
		
			
			if (permission.contains("Manage")) {
				clickElementUsingJavaScriptID(Browser.sharingmanagepermissioncheckbox);	
			}
			
			if (permission.contains("View")) {
				clickElementUsingJavaScriptID(Browser.sharingviewpermissioncheckbox);	
			}
			
			
			if (driver.findElement(By.name(Browser.sharingpopup3email)).isDisplayed()) {
				
				System.out.println(driver.findElement(By.name(Browser.sharingpopup3email)).getAttribute("placeholder"));
				
				driver.findElement(By.id(Browser.sharingpopup3email)).clear();
				driver.findElement(By.id(Browser.sharingpopup3email)).sendKeys(email);
			}
			
			if (driver.findElement(By.id(Browser.sharebutton)).getText().contains("Share")) {
				Assert.assertEquals("Share", driver.findElement(By.id(Browser.sharebutton)).getText());
				Thread.sleep(1000);
				driver.findElement(By.id(Browser.sharebutton)).click();
			} else {
				Assert.assertEquals("Next", driver.findElement(By.id(Browser.sharebutton)).getText());
				driver.findElement(By.id(Browser.sharebutton)).click();
			}
			
			//driver.findElement(By.id("share-card-button-share")).click();
			
		}
		catch (Throwable t) {
		    collector.addError(t);
		    throw t;
		}
	}
	
	public void resetPasswordwithIqabManageKey() throws Throwable{
		//testValidLoginAgain(EnvSetUP.getInstance().getproperties("password"), EnvSetUP.getInstance().getproperties("goodemailid"));
		
		//user manage the key
		//testValidLoginAgain(EnvSetUP.getInstance().getproperties("password"), EnvSetUP.getInstance().getproperties("goodemailid"));
		testValidLoginAgain(EnvSetUP.getInstance().getproperties("password"), EnvSetUP.getInstance().getproperties("goodemailid"), 50);
		userSettingPages(Browser.settings, Browser.passcodekeyoption);
		pageLoadMessage();
		driverSleep();
		driver.findElement(By.id(Browser.iqabibnetmanageedkey)).click();
		driver.findElement(By.id(Browser.passcode_continuebutton)).click();
		if (ifElementPresent(By.cssSelector("span.ng-scope > span.ng-binding"))) {
			
			if (driver.findElement(By.cssSelector("span.ng-scope > span.ng-binding")).getText().equals("Please select one of the passcode management option.")) {
				driver.findElement(By.id(Browser.iqabibnetmanageedkey)).click();
			}
			
		}
		
		ifconfirmPopupYes();
		resetpasswordiqabmanagedkey(EnvSetUP.getInstance().getproperties("resetpassword"));
		driverSleep(90000);
		Assert.assertTrue("The reset password successfull email  should be received", resetPasswordSuccessfull());
		
		resetpasswordiqabmanagedkey(EnvSetUP.getInstance().getproperties("password"));
		driverSleep(90000);
		Assert.assertTrue("The reset password successfull email  should be received", resetPasswordSuccessfull());
				

	}
	
	public void resetPasswordwithUserManageKey() throws Throwable{
		
		testValidLoginAgain(EnvSetUP.getInstance().getproperties("password"), EnvSetUP.getInstance().getproperties("goodemailid"), 50);
		userSettingPages(Browser.settings, Browser.passcodekeyoption);
		pageLoadMessage();
		driverSleep();
		driver.findElement(By.id(Browser.iqabibnetmanageedkey)).click();
		driver.findElement(By.id(Browser.passcode_continuebutton)).click();
		if (ifElementPresent(By.cssSelector("span.ng-scope > span.ng-binding"))) {
			
			if (driver.findElement(By.cssSelector("span.ng-scope > span.ng-binding")).getText().equals("Please select one of the passcode management option.")) {
				driver.findElement(By.id(Browser.iqabibnetmanageedkey)).clear();
			}
			
		}
		confirmPopupNo();
		ifconfirmPopupYes();
		
		
		//When iqab manage the key
		resetpasswordusermanagedkey(EnvSetUP.getInstance().getproperties("resetpassword"));
		driverSleep(90000);
		Assert.assertTrue("The reset password successfull email  should be received", resetPasswordSuccessfull());
		
		resetpasswordusermanagedkey(EnvSetUP.getInstance().getproperties("password"));
		driverSleep(90000);
		Assert.assertTrue("The reset password successfull email  should be received", resetPasswordSuccessfull());
		
	}
	

	public void resetpasswordiqabmanagedkey(String password)
			throws InterruptedException, Throwable {
		boolean emailvalidate=false;
		String baseUrl=EnvSetUP.getInstance().getproperties("baseurl");
		driver.get(baseUrl + "/reset.html");
		
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(EnvSetUP.getInstance().getproperties("goodemailid"));
	    driver.findElement(By.id("btn-register")).click();
	    confirmPopupYes();
	    
	    driverSleep(90000);
		//System.out.println(resetKey());
		if (!resetKey().equals("EmailNotReceived")) {
			emailvalidate=true;
			driver.get(" https://iqabinet-web.herokuapp.com/password-reset.html#/?request=" +resetKey());
			driverSleep(15000);
			pageLoadMessage();
			driver.findElement(By.id(Browser.securityanswertext)).clear();
			driver.findElement(By.id(Browser.securityanswertext)).sendKeys("test");
			driver.findElement(By.id(Browser.answersecurityquestionbutton)).click();
			driverSleep(4000);
			pageLoadMessage();
			
			
			driver.findElement(By.id(Browser.newpasswordfield)).clear();
			
			driver.findElement(By.id(Browser.newpasswordfield)).sendKeys(password);
			driver.findElement(By.id(Browser.confrimnewpassword)).clear();
			driver.findElement(By.id(Browser.confrimnewpassword)).sendKeys(password);
			driver.findElement(By.id(Browser.savebutton)).click();

			confirmPopupYes();
	
			}
		
		Assert.assertTrue("The email should be received", emailvalidate);
		
	}
	
	public void resetpasswordusermanagedkey(String password)
			throws InterruptedException, Throwable {
		boolean emailvalidate=false;
		String baseUrl=EnvSetUP.getInstance().getproperties("baseurl");
		driver.get(baseUrl + "/reset.html");
		
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(EnvSetUP.getInstance().getproperties("goodemailid"));
	    driver.findElement(By.id("btn-register")).click();
	    confirmPopupYes();
	    
	    driverSleep(90000);
		//System.out.println(resetKey());
		if (!resetKey().equals("EmailNotReceived")) {
			emailvalidate=true;
			driver.get(" https://iqabinet-web.herokuapp.com/password-reset.html#/?request=" +resetKey());
			driverSleep(15000);
			pageLoadMessage();
			if (driver.getCurrentUrl().contains("iqabinet-web.herokuapp.com")) {
				attach(Browser.secretkey_dev);
			} else {
				attach(Browser.secretkey_alpha);
			}
			
			driver.findElement(By.id("btn-signup")).click();
			driverSleep(4000);
			pageLoadMessage();
			
			
			driver.findElement(By.id(Browser.newpasswordfield)).clear();
			
			driver.findElement(By.id(Browser.newpasswordfield)).sendKeys(password);
			driver.findElement(By.id(Browser.confrimnewpassword)).clear();
			driver.findElement(By.id(Browser.confrimnewpassword)).sendKeys(password);
			driver.findElement(By.id(Browser.savebutton)).click();

			confirmPopupYes();
	
			}
		
		Assert.assertTrue("The email should be received", emailvalidate);
		
	}

	
	public String resetKey() throws Throwable{
		 String email=EnvSetUP.getInstance().getproperties("goodemailid");
         String emailpassword=EnvSetUP.getInstance().getproperties("goodemailpassword");
         String msgbody=null;
         String key="EmailNotReceived";
        
         Email emailnotification = new Email();
         // System.out.println(emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Request"));
         if (!emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Request").equals("NotFound")) {
        	   int msglenhth=emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Request").length();
               String[] split1=emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Request").split("=");
               //System.out.println(split1[1]);
               String[] split2= split1[1].split(" ");
               key=split2[0];
              System.out.println("The Key is  :"+key);	
		}
        
                          
       
           return key;

	}
	
	public boolean resetPasswordSuccessfull() throws Throwable{
		 String email=EnvSetUP.getInstance().getproperties("goodemailid");
         String emailpassword=EnvSetUP.getInstance().getproperties("goodemailpassword");
         String msgbody=null;
         boolean resetPasswordSuccessfull=false;
        
         Email emailnotification = new Email();
         // System.out.println(emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Request"));
         if (!emailnotification.getEmailMessageBody(email, emailpassword, "Password Reset Successful").equals("NotFound")) {
        	  
               resetPasswordSuccessfull=true;
              
		}
        
                          
       
           return resetPasswordSuccessfull;

		
	}
	
	
	
    public void testLogout() throws Throwable {
        //testvalidLogin();
        driver.findElement(By.id(Browser.username)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(Browser.logout)).click();

        String signinbutton = driver.findElement(By.id(Browser.signinbutton)).getText();
        try {
            Assert.assertEquals("Sign-up", signinbutton);

        }
        catch (Throwable t) {
            collector.addError(t);
            throw t;
        }
    }
    
    public void retriveDocumentPopup() throws Throwable {
    	driverSleep();
    	if (ifElementPresent(By.id("dialog-button-close"))) {
    		driver.findElement(By.id("dialog-button-close")).click();
			pageLoadMessage();
			
		}
    	/*try {
    			
    			Assert.assertEquals("Manual Setup", driver.findElement(By.id("dialog-button-close")).getText());
    			driver.findElement(By.id("dialog-button-close")).click();
    			pageLoadMessage();
    		} catch (Throwable t) {
    			collector.addError(t);
    			throw t;
    		}
    		*/
    }
    
    public String attach(String path) throws Throwable {

        String fullPath = FileUtils.getResourceFile(this.getClass(), path).getPath();
      
       StringSelection ss = new StringSelection(fullPath);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
       Thread.sleep(2000);
       List<WebElement> inputs = driver.findElements(By.id("attach-button-1"));

       for (WebElement input : inputs) {
           ((JavascriptExecutor) driver).executeScript(
                       "arguments[0].removeAttribute('multiple','readonly')",input);
       }
       
      driver.findElement(By.id("attach-button-1")).sendKeys(fullPath);
     

      for (WebElement input : inputs) {
          ((JavascriptExecutor) driver).executeScript(
                      "arguments[0].setAttribute('multiple','readonly')",input);
      }
    
       
       Thread.sleep(2000);
       return fullPath;
   }
    
    
public void srs_institutename(String value) throws Throwable {
		
		
		List<WebElement> typeahead=driver.findElements(By.className("select2-choices"));
		int size=typeahead.size();
		System.out.println("number of type ahead field on the card :"+size);
		
			

			WebElement clearelement=driver.findElements(By.cssSelector(".select2-search-choice-close")).get(0);
			System.out.println("Number of prepopulated fields :"+driver.findElements(By.cssSelector(".select2-search-choice-close")).size());
			clearelement.click();
						
			typeahead.get(0).sendKeys(value);
			driverSleep();
			
		
				driver.findElement(By.cssSelector("span.select2-match")).click();	
			
			
			
			
		
}

public void clickPersonalDocument() {
	// TODO Auto-generated method stub
	
}

public void testExpandCollapseCard() {
	// TODO Auto-generated method stub
	
}



}


