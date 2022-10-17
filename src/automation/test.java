package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class test {
public static void main(String[] args) throws InterruptedException {

//Setting system properties of ChromeDriver
System.setProperty("webdriver.chrome.driver", "E:\\automation\\chromedriver_win32//chromedriver.exe");

//Creating an object of ChromeDriver
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

//launching the specified URL
driver.get("https://www.globalsqa.com/samplepagetest/");

System.out.println(driver.getTitle());
String expected= "Sample Page Testing Site Online - Global SQA Testing Sites";
String actual =driver.getTitle();
if(expected.equals(actual)) {
	System.out.println("Title Match");
}
else
	System.out.println("Title not Match");
//Locating the elements using name locator for the text box
driver.findElement(By.name("g2599-name")).sendKeys("YouTube");
driver.findElement(By.id("g2599-email")).sendKeys("patoliya@gmail.com");

Select drpCountry = new Select(driver.findElement(By.id("g2599-experienceinyears")));
drpCountry.selectByVisibleText("5-7");
//drpCountry.selectByIndex(2);



driver.findElement(By.xpath("//input[@value=\"Functional Testing\"]")).click();
driver.findElement(By.xpath("//input[@value=\"Post Graduate\"]")).click();
driver.findElement(By.xpath("//button[text()=\"Alert Box : Click Here\"]")).click();
String alertText=driver.switchTo().alert().getText();
System.out.println(alertText);
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(2000);
driver.switchTo().alert().accept();
driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("abcdefghijklm");
driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
System.out.println(driver.getTitle());
////name locator for google search button
//WebElement searchIcon = driver.findElement(By.name("btnK"));
//searchIcon.click();
Thread.sleep(2000);
driver.navigate().back();
Thread.sleep(2000);
driver.navigate().refresh();

driver.close();

}
}