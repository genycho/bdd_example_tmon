package sic.gui.common;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;

public class MySeleniumTestCase extends AbstractSeleniumTestCase{
	protected String errorScreenShotFullPath = null;
	static {
//		System.setProperty("SELENIUM_TESTENV", "DEV");
		System.setProperty("TARGET_BROWSER", "chrome");
//		System.setProperty("TARGET_BROWSER", "firefox");
//		System.setProperty("TARGET_BROWSER", "ie");
		// Local로 세팅하고 테스트하는 방법
		// 1) 테스트 실행 시 Java arguments에 -DSELENIUM_TESTENV = LOCAL 설정
		// 2) 위의 static 내 변수 주석 해제 후 직접 작성
		// 3) 상위 EoEAPITestCase의 디폴트 값을 현재 DEV 에서 LOCAL로 변경
	}

	public MySeleniumTestCase() {
		super.readTestEnvValues();
		setBasicEnv();
	}
	
	@Before
	public void setUp() throws Exception {
//		if(isNewlyOpenBrowser() || ! baseUrl.equals(driver.getCurrentUrl())) {
//			driver.manage().window().maximize() ;
//			driver.get(baseUrl);
//			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
//			ngDriver.waitForAngularRequestsToFinish();
//		}
	}

	@After
	public void tearDown() throws Exception {
		if(isCloseBrowser()) {
			driver.quit();
		}
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	public String takeErrorScreenshot(String testName, String stepName, WebElement webElement) {
		errorScreenShotFullPath = null;
		//REFACTORME	해당 폴더를 강제로 생성하도록.... 
		File baseFolder = new File("d:/screenshots");
		if(!baseFolder.exists()) {
//			System.out.println("스샷 기본폴더 d:/screenshots 가 존재하지 않아 스샷을 남기지 않습니다");
			return null;
		}
		String filePath = "d:/screenshots/FAIL_"+GUITestUtils.getCurrentDateTime()+"_"+testName+"_"+stepName+".png";
		try {
			if(webElement == null) {
				GUITestUtils.errorScreenShot(driver, filePath);
			}else {
				GUITestUtils.errorScreenShotWithHighlight(driver, webElement, filePath);
			}
		} catch (IOException e) {
//			log.... 로그가 없넹;;
			filePath = null;
			filePath = "FailedToGenerateScreenShot(path_exception)_"+filePath +"_"+e.getMessage();
//			System.out.println("테스트실패 스크린샷 생성과정에서 에러가 발생하였습니다(시도경로, 에러명)"+filePath +", "+e.getMessage());
		}
		errorScreenShotFullPath = filePath;
		return filePath;
	}
	
	public String takeErrorScreenshot(String testName, String stepName) {
		return takeErrorScreenshot(testName, stepName, null);
	}
	
}

