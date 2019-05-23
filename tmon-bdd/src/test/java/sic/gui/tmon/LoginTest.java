package sic.gui.tmon;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sic.gui.common.MySeleniumTestCase;

public class LoginTest extends MySeleniumTestCase{
	String testId = TMonCommonTestData.TEST_ID;
	String testPw = TMonCommonTestData.TEST_PW;
	
	public LoginTest() {
		super();
		baseUrl="http://www.tmon.co.kr/home";
		setNewlyOpenBrowser(true);
		setCloseBrowser(true);
	}
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testLogin_기본() throws Exception {
		waitForElementPresent(getElement("여행"));
		getElement("여행").click();

		
		//1. 네비 메뉴 표시 확인
		////By tourBanner = By.xpath("//*[@id=\"tourHome\"]/div[1]/header/section[2]/div");
//        List<WebElement> tourBannerElement = driver.findElements(tourBanner);
//
//        if(tourBannerElement.size()>0) {
		//배너 표시 확인
		//By tourBanner = By.xpath("//*[@id=\"tourHome\"]/div[1]/header/section[2]/div");
//        List<WebElement> tourBannerElement = driver.findElements(tourBanner);
//
//        for(int i=1;i<=tourBannerElement.size();i++) {
//            By tourBannerLink = By.xpath("//*[@id=\"tourHome\"]/div[1]/header/section[2]/div["+i+"]/a");
//            String tourBannerLinkUrl = driver.findElement(tourBannerLink).getAttribute("href");
//
//            tourBannerMenuList.add(tourBannerLinkUrl);
//        }
		
		
		//네비 메뉴 갯수만큼 이동 확인?
		//네비 배너 갯수만큼 이동 확인??
		
		//투어 섹센 확인
		
//		getXPathElement(LonginPageElementPath.xpathId).clear();
//		getXPathElement(LonginPageElementPath.xpathId).sendKeys(this.testId);
//		getXPathElement(LonginPageElementPath.xpathPw).clear();
//		getXPathElement(LonginPageElementPath.xpathPw).sendKeys(this.testPw);
//		getNgButtonTxt("Login").click();
//		waitForElementPresent(LonginPageElementPath.xpathEoETitle);
//		
//		getXPathElement(LonginPageElementPath.xpathLogout).click();
//		waitForElementPresent(LonginPageElementPath.xpathLoginArea);
	}
	
	private WebElement getElement(String hint) {
		WebElement webElement = null;
		switch(hint) {
		case "여행":
			webElement = driver.findElement(By.linkText("여행"));
			break;
		default:
			webElement = driver.findElement(By.xpath(hint));
		}
		return webElement;
	}
	
	@Test
	public void testLogin_존재하지않는아이디() throws Exception {
	}
	
	@Test
	public void testLogin_맞지않는비밀번호() throws Exception {
	}
}
