package com.infigo.automation.testrunner;


import org.apache.log4j.Logger;
import org.hibernate.metamodel.domain.Superclass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.infigo.automation.Browser;
import com.infigo.automation.BrowserUtils;
import com.infigo.automation.EnvSetUP;
import com.infigo.automation.GeneralUserFunctionality;

public class TestRunnerAcceptanceTest extends TestRunnerCommon {
	static int i=0;
	
	@Rule
    public ErrorCollector error = new ErrorCollector();
	static final Logger logger = Logger.getLogger(TestRunnerAcceptanceTest.class);
	
	 @BeforeClass    
	    public static void beforeThisWholeTest() throws Throwable{
	    	beforeThisWholeTestStartsSingleUserTest("Acceptance Test",4);
	    
	    }

	 	
	   @AfterClass
	    public static void afterAllTest() throws Throwable {
		   afterThisWholeTestEnds();
		   
	   }
	    
	   @Before
	    public void setUpPrecondition() throws Throwable{
		   super.setUpPrecondition();
	      }


  
	@Test
    public void searchProduct() throws Throwable {

       
        logger.info("-----> RUNNING " + "searchProduct");
        dashboard.setRunning_method_name("searchProduct");
        updateDBCurrent();
        
        try {
        	getTestrun().searchProduct();
            
            logger.info(i++ +"test is running out of 4");logger.info("++++++ PASS");
            updateDBPass();
       
        }
        catch (Throwable e) {
        	logger.info(i++ +"test is running out of 114");
        	logger.error("xxxxxx FAIL " + e.getMessage());
            
            getTestrun().getScreenShot("searchProduct");
            error.addError(e);
            updateDBFail();
        }
        
    }
    
	
	@Test
    public void emailtoBasket() throws Throwable {

       
        logger.info("-----> RUNNING " + "emailtoBasket");
        dashboard.setRunning_method_name("emailtoBasket");
        updateDBCurrent();
        
        try {
        	getTestrun().emailtoBasket();
            
            logger.info(i++ +"test is running out of 4");logger.info("++++++ PASS");
            updateDBPass();
       
        }
        catch (Throwable e) {
        	logger.info(i++ +"test is running out of 114");
        	logger.error("xxxxxx FAIL " + e.getMessage());
            
            getTestrun().getScreenShot("emailtoBasket");
            error.addError(e);
            updateDBFail();
        }
        
    }
    
	 
	      
}
