package selenium_practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com");
		
		WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		financeBtn.click();
		
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		for (String handle: windowHandles) {
			if(handle.equals("네이버 증권")) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		searchInput.click();
		searchInput.sendKeys("삼성전자");
		searchInput.sendKeys(Keys.ENTER);
		

		
		
	}

}
