package com.infigo.automation.testrunner;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;

public class TestRunnerCatFishTest extends TestRunnerCommon {
static int i=1;
	
	@Rule
    public ErrorCollector error = new ErrorCollector();
	static final Logger logger = Logger.getLogger(TestRunnerAcceptanceTest.class);
	
	 @BeforeClass    
	 public static void beforeThisWholeTest() throws Throwable{
	   beforeThisWholeTestStartsSingleUserTest_CatFish("CatFish Test",3);
	    
	  }

	 	
	   @AfterClass
	    public static void afterAllTest() throws Throwable {
		   afterThisWholeTestEnds();
		   
	   }
	   
	
	   @Before
	    public void setUpPrecondition() throws Throwable{
		  
		   super.setUpPrecondition_catFish();
	      }
	   
	   @Test
	    public void addMemberShipLetter_with_csvupload() throws Throwable {

	       
	        logger.info("-----> RUNNING " + "addMemberShipLetter_with_csvupload");
	        dashboard.setRunning_method_name("addMemberShipLetter_with_csvupload");
	        updateDBCurrent();
	        
	        try {
	        	getTestrun().addMemberShipLetter_with_csvupload();
	            
	            logger.info(i++ +"test is running out of 4");logger.info("++++++ PASS");
	            updateDBPass();
	       
	        }
	        catch (Throwable e) {
	        	logger.info(i++ +"test is running out of 4");
	        	logger.error("xxxxxx FAIL " + e.getMessage());
	            
	            getTestrun().getScreenShot("addMemberShipLetter_with_csvupload");
	            error.addError(e);
	            updateDBFail();
	        }
	        
	    }

	   
	   @Test
	    public void addBusiness_Card_Fitness_Plus() throws Throwable {

	       
	        logger.info("-----> RUNNING " + "addBusiness_Card_Fitness_Plus");
	        dashboard.setRunning_method_name("addBusiness_Card_Fitness_Plus");
	        updateDBCurrent();
	        
	        try {
	        	getTestrun().addBusiness_Card_Fitness_Plus();
	            
	            logger.info(i++ +"test is running out of 4");
	            logger.info("++++++ PASS");
	            updateDBPass();
	       
	        }
	        catch (Throwable e) {
	        	logger.info(i++ +"test is running out of 4");
	        	logger.error("xxxxxx FAIL " + e.getMessage());
	            
	            getTestrun().getScreenShot("addBusiness_Card_Fitness_Plus");
	            error.addError(e);
	            updateDBFail();
	        }
	        
	    }

	   
	   
	   @Test
	    public void addBusiness_FitnessFlyer() throws Throwable {

	       
	        logger.info("-----> RUNNING " + "addBusiness_FitnessFlyer");
	        dashboard.setRunning_method_name("addBusiness_FitnessFlyer");
	        updateDBCurrent();
	        
	        try {
	        	getTestrun().addBusiness_FitnessFlyer();
	            
	            logger.info(i++ +"test is running out of 4");
	            logger.info("++++++ PASS");
	            updateDBPass();
	       
	        }
	        catch (Throwable e) {
	        	logger.info(i++ +"test is running out of 4");
	        	logger.error("xxxxxx FAIL " + e.getMessage());
	            
	            getTestrun().getScreenShot("addBusiness_FitnessFlyer");
	            error.addError(e);
	            updateDBFail();
	        }
	        
	    }

}
