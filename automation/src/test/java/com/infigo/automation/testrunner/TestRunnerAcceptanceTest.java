package com.infigo.automation.testrunner;


import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
	    	beforeThisWholeTestStartsSingleUserTest("Acceptance Test",112);
	    
	    }


	    @AfterClass
	    public static void afterThisWholeTestEnds() throws Throwable {
	    	afterThisWholeTestEnds();
	     }
	    
	    @Before
	    public void setUpPrecondition() throws Throwable{
	    	super.setUpPrecondition();
	      }


  
	   @Test
    public void testExpandCollapseCard() throws Throwable {

       
        logger.info("-----> RUNNING " + getMethodName());
        dashboard.setRunning_method_name(getMethodName());updateDBCurrent();
        
        try {
        	getTestrun().testExpandCollapseCard();
            
            logger.info(i++ +"test is running out of 114");logger.info("++++++ PASS");
            updateDBPass();
       
        }
        catch (Throwable e) {
        	logger.info(i++ +"test is running out of 114");
        	logger.error("xxxxxx FAIL " + e.getMessage());
            
            getTestrun().getScreenShot("abtestExpandCollapseCard");
            error.addError(e);
            updateDBFail();
        }
        getTestrun().browserClose();
    }
    
     
}
