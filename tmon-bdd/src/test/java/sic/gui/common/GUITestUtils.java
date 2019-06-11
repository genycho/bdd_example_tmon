package sic.gui.common;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;

public class GUITestUtils {

	public static String getProjectPath(){
		return new File("").getAbsolutePath();
	}
	
	public static String getUniqueString() {
		long millis = System.currentTimeMillis();
		return String.valueOf(millis);
	}
	
	public static String getCurrentDateTime(String format) {
		SimpleDateFormat format1 = new SimpleDateFormat (format);
		return format1.format (System.currentTimeMillis());
	}
	
	public static String getCurrentDateTime() {
		return getCurrentDateTime("yyyyMMddHHmmss");
	}
	
	public static void waitFor(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Deprecated	//하이라이트 가는 걸로 쓰세요
	public static void errorScreenShot(WebDriver driver, String imgAbsPath) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(imgAbsPath));
	}
	
	public static void errorScreenShotWithHighlight(WebDriver driver, WebElement webElement, String imgAbsPath) throws IOException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='2px solid red'", webElement);
		waitFor(1000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(imgAbsPath));
	}
	
	public static WebElement getIDElement(WebDriver driver, String findKeyword) {
		WebElement webElement = driver.findElement(By.id(findKeyword));
		return webElement;
	}
	
	public  static WebElement getXPathElement(WebDriver driver, String findKeyword) {
		WebElement webElement = driver.findElement(By.xpath(findKeyword));
		return webElement;
	}
	
	public  static WebElement getLinkTextElement(WebDriver driver, String findKeyword) {
		WebElement webElement = driver.findElement(By.linkText(findKeyword));
		return webElement;
	}
	
	public  static WebElement getNgButtonTxt(WebDriver driver, String buttonText) {
		return driver.findElement(ByAngular.buttonText(buttonText));
	}
	
	public static void waitForElementPresent(WebDriver driver,WebElement webElement) throws InterruptedException {
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (webElement != null)
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	public static void waitForElementPresent(WebDriver driver, String xpathKeyword) throws InterruptedException {
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (getXPathElement(driver, xpathKeyword) != null)
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	public static void scrollDownToBottom(WebDriver webDriver) {
		((JavascriptExecutor)webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollUpToTop(WebDriver webDriver) {
		((JavascriptExecutor)webDriver).executeScript("window.scrollTo(0, 0);");
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
}