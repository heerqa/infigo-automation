package com.infigo.automation.testrunner;

import java.sql.Driver;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infigo.automation.Browser;
import com.infigo.automation.BrowserUtils;
import com.infigo.automation.EnvSetUP;
import com.infigo.automation.GeneralUserFunctionality;
import com.infigo.automation.GeneralUserFunctionality;
import com.infigo.dao.DashboardDaoImpl;
import com.infigo.entity.Dashboard;

public abstract class TestRunnerCommon {
	
	private static int current;
	private static int passed;
	private static int failed;
	
	private static GeneralUserFunctionality testrun;
	
	static Dashboard dashboard =new Dashboard();
    static ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	static DashboardDaoImpl dashboardDaoImpl=ctx.getBean("dashboardDaoImpl", DashboardDaoImpl.class);	

		
	public static GeneralUserFunctionality getTestrun() {
		return testrun;
	}

	public static void setTestrun(GeneralUserFunctionality testrun) {
		TestRunnerCommon.testrun = testrun;
	}

	public static int getCurrent() {
		TestRunnerCommon.current++;
		return current;
	}

	public static void setCurrent(int current) {
		TestRunnerCommon.current = current;
		
	}

	public static int getPassed() {
		TestRunnerCommon.passed ++;
		return passed;
	}

	public static void setPassed(int passed) {
		TestRunnerCommon.passed = passed;
		
	}

	public static int getFailed() {
		TestRunnerCommon.failed++;
		return failed;
	}

	public static void setFailed(int failed) {
		TestRunnerCommon.failed = failed;
		
	}

   
	
	public void updateDBFail() {
		dashboard.setTest_failed(getFailed());
		dashboardDaoImpl.updateDashbaord(dashboard);
	}

	public void updateDBPass() {
		
		dashboard.setTest_passed(getPassed());
		dashboardDaoImpl.updateDashbaord(dashboard);
	}
	
	public void updateDBCurrent() {
		dashboard.setCurrenttest(getCurrent());
		dashboardDaoImpl.updateDashbaord(dashboard);
	}


	public static void setupDriver(){
	   	
    	String browser =EnvSetUP.getInstance().getproperties("browser") ;
    	
    	if (browser.equals("firefox")) {
    		BrowserUtils.getInstance().setDriver(Browser.Browsers.FIREFOX.browser());
			
		}
    	

    	if (browser.equals("chrome")) {
    		BrowserUtils.getInstance().setDriver(Browser.Browsers.CHROME.browser());
			
		}
        
    	if (browser.equals("ie")) {
    		BrowserUtils.getInstance().setDriver(Browser.Browsers.IE.browser());
			
		}
    	
    	if (browser.equals("phantomjs")) {
    		BrowserUtils.getInstance().setDriver(Browser.Browsers.PHANTOMJS.browser());
			
		}
        
	}

    //private static GeneralUserFunctionality testrun;

    public static String getMethodName() {
    	
         return
        		
                 BrowserUtils.getInstance().getMethodName(33) + " " +
                 BrowserUtils.getInstance().getMethodName(34) + " " +
                 BrowserUtils.getInstance().getMethodName(35);
    }

    
    public static void beforeThisWholeTestStartsSingleUserTest(String testsuitename, int totaltest) throws Throwable {
        setupDriver();
        dashboard.setTestclassname(testsuitename);
        dashboard.setTotaltests(totaltest);
        dashboardDaoImpl.insertDashbaord(dashboard);
        System.out.println("-----> LOGGING IN BEFORE TESTS START");
        BrowserUtils.getInstance().setShouldLogin(true);
        BrowserUtils.getInstance().setShouldBrowserBeClosed(false);
        setTestrun(new GeneralUserFunctionality(BrowserUtils.getInstance().getDriver())) ;
    
        getTestrun().testvalidLogin();
        BrowserUtils.getInstance().setShouldLogin(false);
        System.out.println("-----> DONE ");
        TestRunnerCommon.setCurrent(0);
        TestRunnerCommon.setPassed(0);
        TestRunnerCommon.setFailed(0);
    }
    
    
    public static void beforeThisWholeTestStartsSingleUserTest_CatFish(String testsuitename, int totaltest) throws Throwable {
        setupDriver();
        dashboard.setTestclassname(testsuitename);
        dashboard.setTotaltests(totaltest);
        dashboardDaoImpl.insertDashbaord(dashboard);
        System.out.println("-----> LOGGING IN BEFORE TESTS START");
        BrowserUtils.getInstance().setShouldLogin(true);
        BrowserUtils.getInstance().setShouldBrowserBeClosed(false);
        setTestrun(new GeneralUserFunctionality(BrowserUtils.getInstance().getDriver())) ;
    
        getTestrun().testvalidLogintoCatFish();
        BrowserUtils.getInstance().setShouldLogin(false);
        System.out.println("-----> DONE ");
        TestRunnerCommon.setCurrent(0);
        TestRunnerCommon.setPassed(0);
        TestRunnerCommon.setFailed(0);
    }
    
    
    public static void beforeThisWholeTestStartsMultiUserTest(String testsuitename, int totaltest) throws Throwable {
        setupDriver();
        dashboard.setTestclassname(testsuitename);
        dashboard.setTotaltests(totaltest);
        dashboardDaoImpl.insertDashbaord(dashboard);
        System.out.println("-----> LOGGING IN BEFORE TESTS START");
        BrowserUtils.getInstance().setShouldLogin(true);
        BrowserUtils.getInstance().setShouldBrowserBeClosed(false);
       setTestrun(new GeneralUserFunctionality(BrowserUtils.getInstance().getDriver())) ;
    
       //getTestrun().testvalidLogin();
       //BrowserUtils.getInstance().setShouldLogin(true);
        System.out.println("-----> DONE ");
        TestRunnerCommon.setCurrent(0);
        TestRunnerCommon.setPassed(0);
        TestRunnerCommon.setFailed(0);
    }

    
    public static void afterThisWholeTestEnds() throws Throwable {
        BrowserUtils.getInstance().setShouldBrowserBeClosed(true);
        getTestrun().browserClose();
    }
    
    public void afterTestRun() throws Throwable {
    	BrowserUtils.getInstance().setShouldBrowserBeClosed(true);
    	getTestrun().browserClose();
    }
    
    public void setUpPrecondition() throws Throwable {
        System.out.println("-----> RUNNING  setUpPrecondition()");

        try {
        	
        	getTestrun().clickMYShoppingBasket();
            System.out.println("++++++ PASS");
            
        }
        catch (Throwable e) {
            System.out.println("xxxxxx FAIL " + e.getMessage());
            getTestrun().getScreenShot("setUpPrecondition");
            //error.addError(e);
        }

     }
    
    public void setUpPrecondition_catFish() throws Throwable {
        System.out.println("-----> RUNNING  setUpPrecondition()");

        try {
        	
        	getTestrun().clickonHomeLink();
            System.out.println("++++++ PASS");
            
        }
        catch (Throwable e) {
            System.out.println("xxxxxx FAIL " + e.getMessage());
            getTestrun().getScreenShot("setUpPrecondition");
            //error.addError(e);
        }

     }

	

}
