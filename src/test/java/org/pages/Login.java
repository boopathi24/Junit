package org.pages;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {
public Login() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="username")
private WebElement uesrname;
@FindBy(id="password")
private WebElement password;
@FindBy(id="login")
private WebElement button;

public WebElement getUesrname() {
	return uesrname;
}
public WebElement getPassword() {
	return password;
}
public WebElement getButton() {
	return button;
}

public  void login() throws IOException {
	js(getUesrname(), dataInput("Details", "Sheet2", 1, 1));
	js(getPassword(), dataInput("Details", "Sheet2", 1, 2));
	

}
}
