package org.pages;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.baseclass.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.BrowserType;


public class Mainpage extends BaseClass{
@BeforeClass
public static void launch() {
	browserLaunch("chrome");
	
}

@Before
public void manage() {
	maximize();
	wait(10, TimeUnit.SECONDS);
}

@Test
public void test1() {
	urlLaunch("https://adactinhotelapp.com/");
	String curl = currentUrl();
	Assert.assertTrue("verifyurl",curl.contains("adactinhotelapp") );
	
}

@Test
public void test2() throws IOException {
	Login l=new Login();
	l.login();
	String user = jsAttribute(l.getUesrname());
	Assert.assertEquals("verify username", dataInput("Details", "Sheet2", 1, 1) ,user);
	String pass = jsAttribute(l.getPassword());
	Assert.assertEquals("verify password", dataInput("Details", "Sheet2", 1, 2) ,pass);
	jsClick(l.getButton());
}

@Test
public void test3() throws IOException, InterruptedException {
	Details d=new Details();
	d.detail(1, 1, 1, 1, 1, 1);
	String t1 = getAttributeValue(d.getLocation());
	Assert.assertEquals("location", "Sydney", t1);
	String t2 = getAttributeValue(d.getHotels());
	Assert.assertEquals("hotel name", "Hotel Creek", t2);
	String t3 = getAttributeValue(d.getRoomtype());
	Assert.assertEquals("roomtype", "Standard", t3);
	String t4 = getAttributeValue(d.getNoofrooms());
	Assert.assertEquals("noofrooms", "1", t4);
	String t5 = getAttributeValue(d.getCheckin());
	Assert.assertEquals("checkin", dataInput("Details", "Sheet2", 1, 5), t5);
	String t6 = getAttributeValue(d.getCheckout());
	Assert.assertEquals("checkout", dataInput("Details", "Sheet2", 1, 6), t6);
	String t7 = getAttributeValue(d.getAdult());
	Assert.assertEquals("adult", "1", t7);
	String t8 = getAttributeValue(d.getChild());
	Assert.assertEquals("children", "1", t8);
	jsClick(d.getSearch());
	
}

@Test
public void test4() {
	Confirm c=new Confirm();
	c.confirm();
	boolean selected = c.getRadiobutton().isSelected();
	Assert.assertTrue(selected);
	jsClick(c.getButton());
}

@Test
public void test5() throws IOException {
	CardDetails cd=new CardDetails();
	cd.card();
	String t1 = getAttributeValue(cd.getFirstname());
	Assert.assertEquals("firstname", dataInput("Details", "Sheet1", 1, 0), t1);
	String t2 = getAttributeValue(cd.getLastname());
	Assert.assertEquals("lastname", dataInput("Details", "Sheet1", 1, 1), t2);
	String t3 = getAttributeValue(cd.getAddress());
	Assert.assertEquals("address", dataInput("Details", "Sheet1", 1, 2), t3);
	String t4 = getAttributeValue(cd.getCardno());
	Assert.assertEquals("cardno", dataInput("Details", "Sheet2", 1, 3), t4);
	String t5 = getAttributeValue(cd.getCardtype());
	Assert.assertEquals("cardtype", "AMEX", t5);
	String t6 = getAttributeValue(cd.getExpmonth());
	Assert.assertEquals("expmonth", "1", t6);
	String t7 = getAttributeValue(cd.getExpyear());
	Assert.assertEquals("expyear", "2022", t7);
	String t8 = getAttributeValue(cd.getCvv());
	Assert.assertEquals("cvv", dataInput("Details", "Sheet2", 1, 4), t8);
	click(cd.getBook());
	
}

@Test
public void test6() {
	Orderid id=new Orderid();
	id.id();
	

}
@After
public void time() {
	Date d=new Date();
	System.out.println(d);

}
}
