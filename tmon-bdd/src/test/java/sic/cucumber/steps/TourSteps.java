package sic.cucumber.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sic.gui.common.GUITestRunimeException;
import sic.gui.common.MySeleniumTestCase;

public class TourSteps extends MySeleniumTestCase {
	private final String idFlightMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[1]/span[1]";
	private final String idOverSeaHotlesMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[2]/span[1]";
	private final String idOverSeaPackageMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[3]/span[1]";
	private final String idPensionAndCampingMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[4]/span[1]";
	private final String idDomesticTravelMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[5]";// CHECKME
																													// -
																													// a
																													// 링크
	private final String idDomesticHotelsMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[6]";// CHECKME
																													// -
																													// a
																													// 링크
	private final String idLocalTourTicketMenu = "";
	private final String idJejuTourMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[8]/span[1]";
	private final String idDaeMyungMenu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[9]/span[1]";

	public TourSteps() {
		super();
		baseUrl = "http://www.tmon.co.kr/home";
		setNewlyOpenBrowser(false);
		setCloseBrowser(false);
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
	}

	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Given("^PC티몬홈에서$")
	public void pc티몬홈에서() throws Throwable {
		driver.get(baseUrl);
		waitForElementPresent(getElement("여행"));

	}

	@Given("^PC투어홈에서$")
	public void pc투어홈에서() throws Throwable {
		driver.get(baseUrl);
		waitForElementPresent(getElement("여행"));
		getElement("여행").click();
		Thread.sleep(2000);
	}

	@When("^여행탭으로이동하면$")
	public void 여행탭으로이동하면() throws Throwable {
		getElement("여행").click();
		Thread.sleep(2000);
	}

	@Then("^페이지타이틀은 \"(.*?)\"이다$")
	public void 페이지타이틀은_이다(String arg1) throws Throwable {
		assertEquals(arg1, getPageTitle());
	}

	private WebElement getElement(String hint) {
		WebElement webElement = null;
		switch (hint) {
		case "여행":
			webElement = driver.findElement(By.linkText("여행"));
			break;
		default:
			webElement = driver.findElement(By.xpath(hint));
		}
		return webElement;
	}

	public void 좌측메뉴영역에_이표시된다(String arg1) throws Throwable {
		WebElement webElement = this.getIDElement("//span[(text() = '" + arg1 + "' or . = '" + arg1 + "')]");
		assertNotNull(webElement);
	}

	@Then("^좌측메뉴영역에\"([^\"]*)\"이/가 표시된다$")
	public void 좌측메뉴영역에_이_가_표시된다(String arg1) throws Throwable {
		WebElement webElement = null;

		switch (arg1) {
		case "항공권":
			webElement = getXPathElement(this.idFlightMenu);
			break;
		case "해외호텔/숙박":
			webElement = getXPathElement(this.idOverSeaHotlesMenu);
			break;
		case "해외패키지/자유":
			webElement = getXPathElement(this.idOverSeaPackageMenu);
			break;
		case "펜션/캠핑":
			webElement = getXPathElement(this.idPensionAndCampingMenu);
			break;
		case "국내여행/레저":
			webElement = getXPathElement(this.idDomesticTravelMenu);
			break;
		case "국내호텔/리조트":
			webElement = getXPathElement(this.idDomesticHotelsMenu);
			break;
		case "현지투어/입장권":
			webElement = getXPathElement(this.idLocalTourTicketMenu);
			break;
		case "제주여행":
			webElement = getXPathElement(this.idJejuTourMenu);
			break;
		case "대명리조트":
			webElement = getXPathElement(this.idDaeMyungMenu);
			break;
		default:
			throw new GUITestRunimeException("사전에 파악되지 않은 메뉴명입니다" + arg1);
		}
//		if(webElement == null) {
//			this.verificationErrors.append(b);
//		}
		assertNotNull(webElement);
	}
}
