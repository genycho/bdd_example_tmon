package sic.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sic.gui.common.GUITestRunimeException;
import sic.gui.common.MySeleniumTestCase;

public class TourSteps extends MySeleniumTestCase {
	TourUIInfo tourUIInfo;
	String tourHomeUrl = "http://tour.tmon.co.kr/";
	
	public TourSteps() {
		super();
		baseUrl = "http://www.tmon.co.kr/home";
		setNewlyOpenBrowser(false);
		setCloseBrowser(false);
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
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
		driver.get(tourHomeUrl);
		waitForElementPresent(getElement("여행"));
		Thread.sleep(2000);
	}

	@When("^\"([^\"]*)\"탭으로이동하면$")
	public void 탭으로이동하면(String arg1) throws Throwable {
		switch(arg1) {
			case "여행":{
				getElement("여행").click();
				break;
			}
			default : {
				throw new GUITestRunimeException(arg1+" 은 아직 지원하지않는 탭 메뉴입니다");
			}
		}		
		Thread.sleep(2000);
	}

	@Then("^페이지타이틀은 \"(.*?)\"이다$")
	public void 페이지타이틀은_이다(String arg1) throws Throwable {
		String thisPageTitle = getPageTitle();
		if(!arg1.equals(thisPageTitle)) {
			takeErrorScreenshot(this.getClass().getName(), "페이지타이틀은_이다_"+arg1);
		}
		assertEquals("페이지타이틀이기대한값과다릅니다.에러스크린샷을참조해주세요-"+this.errorScreenShotFullPath,arg1, getPageTitle());
	}

	private WebElement getElement(String hint) {
		WebElement webElement = null;
		switch (hint) {
		case "여행":
			webElement = driver.findElement(By.linkText("여행"));//XPATH값은 TourUIElementsInfo.XPATH_TOP_TOUR_Menu 
			break;
		default:
			webElement = driver.findElement(By.xpath(hint));
		}
		return webElement;
	}
	
	private String getValue(WebElement webElement) {
		return webElement.getText();
	}
	private String getAttrValue(WebElement webElement, String attrName) {
		return webElement.getAttribute(attrName);
	}

	@Then("^좌측메뉴영역에\"([^\"]*)\"이/가 표시된다$")
	public void 좌측메뉴영역에_이_가_표시된다(String arg1) throws Throwable {
		WebElement webElement = null;
		switch (arg1) {
			case "항공권":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_Flight_Menu);
				break;
			case "해외호텔/숙박":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_OverSeaHotles_Menu);
				break;
			case "해외패키지/자유":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_OverSeaPackage_Menu);
				break;
			case "펜션/캠핑":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_PensionAndCamping_Menu);
				break;
			case "국내여행/레저":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_DomesticTravel_Menu);
				break;
			case "국내호텔/리조트":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_DomesticHotels_Menu);
				break;
			case "현지투어/입장권":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_LocalTourTicket_Menu);
				break;
			case "제주여행":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_JejuTour_Menu);
				break;
			case "대명리조트":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_DaeMyung_Menu);
				arg1 = "일부러실패";//FIXME	데모용으로 일부러 실패하도록 설정
				break;
			default:
				throw new GUITestRunimeException("사전에 파악되지 않은 메뉴명입니다" + arg1);
		}
		String actualMenuName =getValue(webElement);
		if(webElement == null ) {
			takeErrorScreenshot(this.getClass().getName(),"좌측메뉴영역에_이_가_표시된다_"+arg1);
		}else if(!arg1.contentEquals(actualMenuName)) {
			takeErrorScreenshot(this.getClass().getName(),"좌측메뉴영역에_이_가_표시된다_"+arg1, webElement);
		}
		assertNotNull(arg1 + " UI 요소를 찾지 못하였습니다. 에러스크린샷을참고해주세요 - "+errorScreenShotFullPath, webElement);
		assertEquals("기대한 메뉴명이 서로 다릅니다. 에러스크린샷을참고해주세요 - "+errorScreenShotFullPath,arg1, actualMenuName);
	}
	
	@Then("^하단에다음섹션들\"([^\"]*)\"이표시된다$")
	public void 하단에다음섹션들_이표시된다(String arg1) throws Throwable {
		WebElement webElement = null;
		switch (arg1) {
			case "여행특가":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_SPECIALPRICE_TXTIMG);
				//getAttrValue(webElement, "src") = http://img1.tmon.co.kr/multibiz/common/PC_tour_img_main_superprice_title_2_0e2b0.png
				break;
			case "마감 임박! 전세계 항공권":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_FLIGHTTICKET_H);
				break;
			case "믿고 가는 대세 여행 스팟":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_POPULARSPOT_H);
				break;
			case "기획전":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_TOURPLAN_H);
				break;
			case "베스트":
				webElement = getXPathElement(TourUIElementsInfo.XPATH_TOURBEST_H);
				break;
			default:
				throw new GUITestRunimeException("사전에 파악되지 않은 섹션명입니다" + arg1);
		}
		if(webElement == null) {
			takeErrorScreenshot(this.getClass().getName(),"하단에다음섹션들_이표시된다");
		}
		assertNotNull(arg1 + " UI 요소를 찾지 못하였습니다. 에러스크린샷을참고해주세요 - "+errorScreenShotFullPath, webElement);
		
	}
	
	public enum TourUIInfo{
		FLIGHT(TourUIElementsInfo.XPATH_Flight_Menu,TourUIElementsInfo.LINKVALUE_SUB_FLIGHT),
		OVERSEAHOTEL(TourUIElementsInfo.XPATH_OverSeaHotles_Menu,TourUIElementsInfo.LINKVALUE_SUB_OverSeaHotles),
		OVERSEAPACKAGE(TourUIElementsInfo.XPATH_OverSeaPackage_Menu,TourUIElementsInfo.LINKVALUE_SUB_OverSeaPackage),
		PENSIONANDCAMPING(TourUIElementsInfo.XPATH_PensionAndCamping_Menu,TourUIElementsInfo.LINKVALUE_SUB_PensionAndCamping),
		DOMESTICTRAVEL(TourUIElementsInfo.XPATH_DomesticTravel_Menu,TourUIElementsInfo.LINKVALUE_SUB_DomesticTravel),
		DOMESTICHOTEL(TourUIElementsInfo.XPATH_DomesticHotels_Menu,TourUIElementsInfo.LINKVALUE_SUB_DomesticHotels),
		LOCALTOURTICKET(TourUIElementsInfo.XPATH_LocalTourTicket_Menu,TourUIElementsInfo.LINKVALUE_SUB_LocalTourTicket),
		JEJUTOUR(TourUIElementsInfo.XPATH_JejuTour_Menu,TourUIElementsInfo.LINKVALUE_SUB_JejuTour),
		DAEMYUNG(TourUIElementsInfo.XPATH_DaeMyung_Menu,TourUIElementsInfo.LINKVALUE_SUB_DaeMyung);
		
		String xpath;
		String linkValue;
		
		TourUIInfo(String xpath, String linkValue){
			this.xpath = xpath;
			this.linkValue = linkValue;
		}

		public String getXpath() {
			return xpath;
		}

		public void setXpath(String xpath) {
			this.xpath = xpath;
		}

		public String getLinkValue() {
			return linkValue;
		}

		public void setLinkValue(String linkValue) {
			this.linkValue = linkValue;
		}
	}
	
	
}

class TourUIElementsInfo{
	/**		*/
	protected static final String XPATH_TOP_TOUR_Menu = "id(\"gnb2\")/div[@class=\"inner\"]/ul[@class=\"menu\"]/li[9]/a[1]";
	
	/**	각 서브 메뉴 	*/
	protected static final String XPATH_Flight_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[1]/span[1]";
	protected static final String XPATH_OverSeaHotles_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[2]/span[1]";
	protected static final String XPATH_OverSeaPackage_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[3]/span[1]";
	protected static final String XPATH_PensionAndCamping_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[4]/span[1]";
	protected static final String XPATH_DomesticTravel_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[5]";// CHECKME
	protected static final String XPATH_DomesticHotels_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[6]";// CHECKME
	protected static final String XPATH_LocalTourTicket_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[7]/span[1]";
	protected static final String XPATH_JejuTour_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[8]/span[1]";
	protected static final String XPATH_DaeMyung_Menu = "id(\"tourHome\")/div[1]/header[1]/section[1]/div[1]/nav[1]/a[9]/span[1]";
	
	/**	각 서브 메뉴 링크	*/
	protected static final String LINKVALUE_SUB_FLIGHT = "http://tour.tmon.co.kr/flight";
	protected static final String LINKVALUE_SUB_OverSeaHotles = "http://tour.tmon.co.kr/hotels";
	protected static final String LINKVALUE_SUB_OverSeaPackage = "http://tour.tmon.co.kr/packages";
	protected static final String LINKVALUE_SUB_PensionAndCamping = "http://tour.tmon.co.kr/pensions";
	protected static final String LINKVALUE_SUB_DomesticTravel = "http://tour.tmon.co.kr/domestic";
	protected static final String LINKVALUE_SUB_DomesticHotels = "http://tour.tmon.co.kr/hotels-domestic";
	protected static final String LINKVALUE_SUB_LocalTourTicket = "http://tour.tmon.co.kr/activities";
	protected static final String LINKVALUE_SUB_JejuTour = "http://tour.tmon.co.kr/jeju";
	protected static final String LINKVALUE_SUB_DaeMyung = "http://www.tmon.co.kr/planning/PLAN_dGz0FfjDNG";
	
	/**	각 섹션 타이틀	*/
	protected static final String XPATH_SPECIALPRICE_TXTIMG = "id(\"tourHome\")/div[2]/section[1]/div[1]/header[1]/h2[1]/img[1]";//
	protected static final String XPATH_FLIGHTTICKET_H = "id(\"tourHome\")/div[2]/section[2]/div[1]/header[1]/h1[1]";
	protected static final String XPATH_POPULARSPOT_H = "id(\"tourHome\")/div[2]/div[1]/div[1]/header[1]/h1[1]";
	protected static final String XPATH_TOURPLAN_H = "id(\"tourHome\")/div[2]/section[3]/div[1]/header[1]/h1[1]";
	protected static final String XPATH_TOURBEST_H = "id(\"tourHome\")/div[2]/section[4]/header[1]/h1[1]";
	
	
}
