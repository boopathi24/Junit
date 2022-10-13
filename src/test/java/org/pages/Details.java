package org.pages;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details extends BaseClass{
public Details() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="location")
private WebElement location;
@FindBy(id="hotels")
private WebElement hotels;
@FindBy(id="room_type")
private WebElement roomtype;
@FindBy(id="room_nos")
private WebElement noofrooms;
@FindBy(id="datepick_in")
private WebElement checkin;
@FindBy(id="datepick_out")
private WebElement checkout;
@FindBy(id="adult_room")
private WebElement adult;
@FindBy(id="child_room")
private WebElement child;
@FindBy(id="Submit")
private WebElement search;
public WebElement getLocation() {
	return location;
}
public WebElement getHotels() {
	return hotels;
}
public WebElement getRoomtype() {
	return roomtype;
}
public WebElement getNoofrooms() {
	return noofrooms;
}
public WebElement getCheckin() {
	return checkin;
}
public WebElement getCheckout() {
	return checkout;
}
public WebElement getAdult() {
	return adult;
}
public WebElement getChild() {
	return child;
}
public WebElement getSearch() {
	return search;
}

public void detail(int location,int Hotel,int roomtype,int noofroom,int adult,int child) throws IOException, InterruptedException {
	select(getLocation(), location);
	select(getHotels(), Hotel);
	select(getRoomtype(), roomtype);
	select(getNoofrooms(), noofroom);
	clear(getCheckin());
	sendKeys(getCheckin(), dataInput("Details", "Sheet2", 1, 5));
	clear(getCheckout());
	sendKeys(getCheckout(), dataInput("Details", "Sheet2", 1, 6));
	select(getAdult(), adult);
	select(getChild(), child);
	

}
}
