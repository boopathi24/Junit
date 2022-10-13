package org.pages;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetails extends BaseClass{
public CardDetails() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="first_name")
private WebElement firstname;
@FindBy(id="last_name")
private WebElement lastname;
@FindBy(id="address")
private WebElement address;
@FindBy(id="cc_num")
private WebElement cardno;
@FindBy(id="cc_type")
private WebElement cardtype;
@FindBy(id="cc_exp_month")
private WebElement expmonth;
@FindBy(id="cc_exp_year")
private WebElement expyear;
@FindBy(id="cc_cvv")
private WebElement cvv;
@FindBy(id="book_now")
private WebElement book;

public WebElement getFirstname() {
	return firstname;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getAddress() {
	return address;
}

public WebElement getCardno() {
	return cardno;
}

public WebElement getCardtype() {
	return cardtype;
}

public WebElement getExpmonth() {
	return expmonth;
}

public WebElement getExpyear() {
	return expyear;
}

public WebElement getCvv() {
	return cvv;
}

public WebElement getBook() {
	return book;
}

public void card() throws IOException {
js(getFirstname(), dataInput("Details", "Sheet1", 1, 0));
js(getLastname(), dataInput("Details", "Sheet1", 1, 1));
sendKeys(getAddress(), dataInput("Details", "Sheet1", 1, 2));
js(getCardno(), dataInput("Details", "Sheet2", 1, 3));
select(getCardtype(), 1);
select(getExpmonth(), 1);
select(getExpyear(), 12);
js(getCvv(), dataInput("Details", "Sheet2", 1, 4));

}
}
