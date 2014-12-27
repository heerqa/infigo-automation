package com.infigo.dao.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.infigo.dao.DashboardDaoImpl;
import com.infigo.entity.Dashboard;


public class TestDashboardDaoImpl {
	 
	
	Dashboard dashboard =new Dashboard();
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	DashboardDaoImpl dashboardDaoImpl=ctx.getBean("dashboardDaoImpl", DashboardDaoImpl.class);	
	
	@Test
	public void testgetDahboardItemCount() {
		//dashboardDaoImpl.insertDashbaord(dashboard);
		System.out.println("TEST: Total rows in the Dashboard table are :" +dashboardDaoImpl.getDahboardList().size());
	}
	
	@Ignore
	@Test
	public void testUpdateDashboard() {
		dashboardDaoImpl.updateDashbaord(dashboard);
		//System.out.println("TEST: Total rows in the Dashboard table are :" +dashboardDaoImpl.getDahboardList().size());
	}

}
	