package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderid extends BaseClass{
public Orderid() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="order_no")
private WebElement orderid;

public WebElement getOrderid() {
	return orderid;
}
public void id() {
	String txt = jsAttribute(getOrderid());
	System.out.println("Your order id is "+txt);

}

}

