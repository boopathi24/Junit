package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static Actions a;
public static JavascriptExecutor js;

//browserlaunch
public static WebDriver browserLaunch(String browsername) {
	
	if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
	else if(browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("edge")) {
		WebDriverManager.chromedriver().setup();
		driver=new EdgeDriver();
	}
		return driver;
}
//url launch
public static void urlLaunch(String url) {
	driver.get(url);
}

//currenturl
public static String currentUrl() {
	String curl = driver.getCurrentUrl();
	return curl;
}

//maximize
public static void maximize() {
	driver.manage().window().maximize();
}

//wait
public static void wait(int time,TimeUnit unit) {
	driver.manage().timeouts().implicitlyWait(time, unit);
}

//sendkeys
public static void sendKeys(WebElement e,String value) {
	e.sendKeys(value);
}

//click
public static void click(WebElement e) {
	e.click();
}

//clear
public static void clear(WebElement e) {
	e.clear();
}

//gettext
public static String getText(WebElement e) {
	String text = e.getText();
	return text;
}

//getattributevalue
public static String getAttributeValue(WebElement e) {
	String text = e.getAttribute("value");
	return text;
}

//getattributetext
public static String getAttributeText(WebElement e) {
	String text = e.getAttribute("innerText");
	return text;
}

//action
public static void moveToElement(WebElement e) {
	a.moveToElement(e).perform();;
}

public static void actionClick(WebElement e) {
	a.click(e).perform();
}

public static void dragAndDrop(WebElement source,WebElement target) {
	a.dragAndDrop(source, target).perform();;
}

public static void contextClick(WebElement e) {
	a.contextClick(e).perform();
}

public void doubleClick(WebElement e) {
	a.doubleClick(e).perform();
}

public void cliclAndHold(WebElement e) {
	a.clickAndHold(e).perform();
}

public void release(WebElement e) {
	a.release(e).perform();
}


// Alert
public static void confirmAlert(String key,String value) {
	Alert a=driver.switchTo().alert();
	if(key.equalsIgnoreCase("sendkey")) {
		a.accept();
		a.sendKeys(value);
	}
	else if(key.equalsIgnoreCase("accept")) {
		a.accept();
	}
	else if(key.equalsIgnoreCase("dismiss")){
		a.dismiss();
	}
}

//Select
public static void select(WebElement e,int index) {
	Select s=new Select(e);
	s.selectByIndex(index);
}

//screenshot
public static void screenShot(String name) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File f=new File("C:\\Users\\Dell\\eclipse-workspace\\JUnit\\Screenshot\\"+name+".png");
	FileUtils.copyFile(src, f);
}

//JavaScript
public static void js(WebElement e,String key) {
	js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','"+key+"')", e);
}

public static void jsClick(WebElement e) {
	js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", e);
}

public static String jsAttribute(WebElement e) {
	Object es = js.executeScript("return arguments[0].getAttribute('value')", e);
	String text=(String)es;
	return text;
}

public static void scroll(WebElement e,boolean value) {
	js.executeScript("arguments[0].scrollIntoView("+value+")", e);
}

//data read
public static String dataInput(String file,String sheet,int row,int cell) throws IOException {
	String value;
	File f=new File("C:\\Users\\Dell\\eclipse-workspace\\JUnit\\src\\test\\resources\\"+file+".xlsx");
	FileInputStream fi=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fi);
	Sheet s = w.getSheet(sheet);
	Row r = s.getRow(row);
	Cell c = r.getCell(cell);
	int type = c.getCellType();
	if(type==1) {
		value = c.getStringCellValue();
	}
	else if(DateUtil.isCellDateFormatted(c)) {
		Date dc = c.getDateCellValue();
		SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy");
		value = sd.format(dc);
	}
	else {
		double ncv = c.getNumericCellValue();
		long v=(long)ncv;
		value = String.valueOf(v);
	}
	return value;
}




}
