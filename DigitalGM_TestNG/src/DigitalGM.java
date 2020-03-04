import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigitalGM {
	@Test
	public void DigitalGM_Test() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver_80.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://honeywellprod.sharepoint.com/");
		driver.manage().window().maximize();

		Robot rb = new Robot();
		StringSelection username = new StringSelection("tarun.bhatia@honeywell.com");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);

		StringSelection pwd = new StringSelection("H0neyw3llepm4");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.switchTo().defaultContent();
		
		driver.get("https://honeywellprod.sharepoint.com/teams/DGM-Dev/SitePages/Home.aspx");
		Assert.assertEquals(driver.getTitle(), "Honeywell :: Digital GM");
		System.out.println("Successfully opened the application with title : " + driver.getTitle());
		
		WebElement sel = driver.findElement(By.id("Poles"));
		Select s = new Select(sel);
		s.selectByIndex(2);

		WebElement sel1 = driver.findElement(By.id("YearID"));
		Select s1 = new Select(sel1);
		s1.selectByIndex(2);

		WebElement sel2 = driver.findElement(By.id("PeriodID"));
		Select s2 = new Select(sel2);
		s2.selectByIndex(1);
		
		driver.quit();
	}
}
