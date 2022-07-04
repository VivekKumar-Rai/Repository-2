package Mindtree_May_C1.Milestone_Assessment_3;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoneyControl {
    
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.get("https://www.moneycontrol.com/");
        Actions ac=new Actions(driver);
        
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='market_listmenu']//a[@href='https://www.moneycontrol.com/news/business/personal-finance/']")));
        
        WebElement a=driver.findElement(By.xpath("//ul[@class='market_listmenu']//a[@href='https://www.moneycontrol.com/news/business/personal-finance/']"));
         ac.moveToElement(a);
        
        WebElement b=driver.findElement(By.xpath("//a[@href='https://www.moneycontrol.com/personal-finance/tools/income-tax-calculator']"));
        ac.moveToElement(b);
        ac.click().build().perform();
        
        driver.findElement(By.xpath("//span[@class='styspri icradio_mid']")).click();
        driver.findElement(By.xpath("//span[@class='styspri icradio_mid']")).click();
        
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("22");
        
        driver.findElement(By.xpath("//select[@class='custselect']")).click();
        driver.findElement(By.xpath("//input[@value='metro']")).click();
        
        Select s=new Select(driver.findElement(By.xpath("//select[@class='custselect']")));
        s.selectByVisibleText("Stay in Non Metro city"); 
        
        driver.findElement(By.xpath("//a[@title='Next']")).click();
        
        driver.findElement(By.xpath("//input[@id='annual_salary']")).sendKeys("15000");
        driver.findElement(By.xpath("//input[@id='other_income']")).sendKeys("15000");
        
        driver.findElement(By.xpath("//a[@id='income_tab_next']")).click();
        
        driver.findElement(By.xpath("//input[@id='tax_saving_investment']")).sendKeys("2000");
        
        driver.findElement(By.xpath("//a[@class='btn_common nextfrm MR10 calculateTax']")).click();
        
        String tax=driver.findElement(By.xpath("//span[@id='display_tax']")).getText();
        System.out.println("Tax = "+tax);
        
        WebElement c=driver.findElement(By.xpath("//li[@class='menu_l1  sub_nav']//a[@href='https://www.moneycontrol.com/mutualfundindia/'][1]"));
        ac.moveToElement(c);
       
       WebElement d=driver.findElement(By.xpath("//li[@class='menu_l1  sub_nav']//a[@href='https://www.moneycontrol.com/mutual-funds/best-funds/equity.html']"));
       ac.moveToElement(d);
       ac.click().build().perform();
       
       driver.findElement(By.xpath("//a[@href='https://www.moneycontrol.com/mutual-funds/nav/bank-of-india-tax-advantage-fund-direct-plan-growth/MBA083']")).click();
       
       Set <String> ids=driver.getWindowHandles();
       Iterator <String> it=ids.iterator();
	   String parentid=it.next();
       String childid=it.next();
       driver.switchTo().window(childid);
       
       String Price=driver.findElement(By.xpath("//div[@class='right_section']//span[@class='amt'][1]")).getText();
       System.out.println("Price = "+Price);
       
       driver.quit();
       
        
	}

}
