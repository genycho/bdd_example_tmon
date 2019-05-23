package sic.gui.tmon;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TMonTourTest {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeEach
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testTMONHomeTour() throws Exception {
	    driver.get("http://www.tmon.co.kr/home");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='환불문의'])[1]/following::img[1]")).click();
	    driver.findElement(By.linkText("여행")).click();
	    try {
	      assertEquals("티몬 - 매주 월요일은 티몬데이", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='결제혜택'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='항공권'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='해외호텔/숙박'])[1]/following::span[1]")).click();
	    try {
	      assertEquals("티몬 - 매주 월요일은 티몬데이", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::div[1]")).click();
	    try {
	      assertEquals("해외패키지 / 자유", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='해외호텔/숙박'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='해외패키지/자유'])[1]/following::span[1]")).click();
	    try {
	      assertEquals("티몬 - 매주 월요일은 티몬데이", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::div[1]")).click();
	    try {
	      assertEquals("펜션 / 캠핑", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='펜션/캠핑'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::div[1]")).click();
	    try {
	      assertEquals("국내여행 / 레저", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='국내호텔/리조트'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).click();
	    try {
	      assertEquals("해외 현지투어 / 교통패스 / 입장권", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='현지투어/입장권'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::div[1]")).click();
	    try {
	      assertEquals("제주여행", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='대명리조트'])[1]/following::h1[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='제주여행'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='결제혜택'])[1]/following::div[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='>'])[3]/following::h2[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='>'])[3]/following::h2[1]")).click();
	  }

}
