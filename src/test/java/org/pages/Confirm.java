package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirm extends BaseClass{
public Confirm() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="radiobutton_0")
private WebElement radiobutton;
@FindBy(id="continue")
private WebElement button;
public WebElement getRadiobutton() {
	return radiobutton;
}
public WebElement getButton() {
	return button;
}

public void confirm() {
	click(getRadiobutton());
	

}
}
