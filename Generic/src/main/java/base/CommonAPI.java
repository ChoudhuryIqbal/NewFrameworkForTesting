/*
 * 
 */
package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * The Class CommonAPI.
 */
public class CommonAPI {

	/** The driver. */
	public WebDriver driver;

	/**
	 * Sets the up.
	 *
	 * @param url
	 *            the new up
	 * @throws Exception
	 *             the exception
	 */
	@Parameters({ "url" })
	@BeforeMethod
	public void setUp(String url) throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\a\\FrameWorkFeb2017\\framework-march\\Generic\\driver\\geckodriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	/**
	 * Click by css.
	 *
	 * @param locator
	 *            the locator
	 */
	public void clickByCss(String locator) {
		driver.findElement(By.cssSelector(locator)).click();
	}

	/**
	 * Click by xpath.
	 *
	 * @param locator
	 *            the locator
	 */
	public void clickByXpath(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	/**
	 * Type by css.
	 *
	 * @param locator
	 *            the locator
	 * @param value
	 *            the value
	 */
	public void typeByCss(String locator, String value) {
		driver.findElement(By.cssSelector(locator)).sendKeys(value);
	}

	/**
	 * Type by css enter.
	 *
	 * @param locator
	 *            the locator
	 * @param value
	 *            the value
	 */
	public void typeByCssEnter(String locator, String value) {
		driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);

	}

	/**
	 * Type by xpath.
	 *
	 * @param locator
	 *            the locator
	 * @param value
	 *            the value
	 */
	public void typeByXpath(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);

	}

	/**
	 * Take enter keys.
	 *
	 * @param locator
	 *            the locator
	 */
	public void takeEnterKeys(String locator) {
		driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
	}

	/**
	 * Clear input field.
	 *
	 * @param locator
	 *            the locator
	 */
	public void clearInputField(String locator) {
		driver.findElement(By.cssSelector(locator)).clear();
	}

	/**
	 * Gets the list of web elements by id.
	 *
	 * @param locator
	 *            the locator
	 * @return the list of web elements by id
	 */
	public List<WebElement> getListOfWebElementsById(String locator) {
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.id(locator));

		return list;
	}

	/**
	 * Gets the text from web elements.
	 *
	 * @param locator
	 *            the locator
	 * @return the text from web elements
	 */
	public List<String> getTextFromWebElements(String locator) {
		List<WebElement> element = new ArrayList<WebElement>();
		List<String> text = new ArrayList<String>();
		element = driver.findElements(By.cssSelector(locator));
		for (WebElement web : element) {
			text.add(web.getText());
		}
		return text;
	}

	/**
	 * Gets the list of web elements by css.
	 *
	 * @param locator
	 *            the locator
	 * @return the list of web elements by css
	 */
	public List<WebElement> getListOfWebElementsByCss(String locator) {
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.cssSelector(locator));
		return list;
	}

	/**
	 * Gets the list of web elements by xpath.
	 *
	 * @param locator
	 *            the locator
	 * @return the list of web elements by xpath
	 */
	public List<WebElement> getListOfWebElementsByXpath(String locator) {
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.xpath(locator));
		return list;
	}

	/**
	 * Gets the current page url.
	 *
	 * @return the current page url
	 */
	public String getCurrentPageUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	/**
	 * Navigate back.
	 */
	public void navigateBack() {
		driver.navigate().back();

	}

	/**
	 * Navigate forward.
	 */
	public void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * Gets the text by css.
	 *
	 * @param locator
	 *            the locator
	 * @return the text by css
	 */
	public String getTextByCss(String locator) {
		String st = driver.findElement(By.cssSelector(locator)).getText();
		return st;
	}

	/**
	 * Gets the text by xpath.
	 *
	 * @param locator
	 *            the locator
	 * @return the text by xpath
	 */
	public String getTextByXpath(String locator) {

		String st = driver.findElement(By.xpath(locator)).getText();
		return st;
	}

	/**
	 * Gets the text by id.
	 *
	 * @param locator
	 *            the locator
	 * @return the text by id
	 */
	public String getTextById(String locator) {
		return driver.findElement(By.name(locator)).getText();
	}

	/**
	 * Gets the text by name.
	 *
	 * @param locator
	 *            the locator
	 * @return the text by name
	 */
	public String getTextByName(String locator) {
		String st = driver.findElement(By.name(locator)).getText();
		return st;
	}

	/**
	 * Gets the list of string.
	 *
	 * @param list
	 *            the list
	 * @return the list of string
	 */
	public List<String> getListOfString(List<WebElement> list) {
		List<String> items = new ArrayList<String>();
		for (WebElement element : list) {
			items.add(element.getText());
		}

		return items;

	}

	/**
	 * Select option by visible text.
	 *
	 * @param element
	 *            the element
	 * @param value
	 *            the value
	 */
	public void selectOptionByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	/**
	 * Sleep for.
	 *
	 * @param seconds
	 *            the seconds
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void sleepFor(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	/**
	 * Mouse hover by CSS.
	 *
	 * @param locator
	 *            the locator
	 */
	public void mouseHoverByCSS(String locator) {

		try {
			WebElement element = driver.findElement(By.cssSelector(locator));
			Actions action = new Actions(driver);
			Actions hover = action.moveToElement(element);
			action.moveToElement(element).perform();
		} catch (Exception ex) {
			System.out.println("First attemt has been done, This is second try");
			WebElement element = driver.findElement(By.cssSelector(locator));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
	}

	/**
	 * Mouse hover by xpath.
	 *
	 * @param locator
	 *            the locator
	 */
	public void mouseHoverByXpath(String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			Actions action = new Actions(driver);
			Actions hover = action.moveToElement(element);
		} catch (Exception ex) {
			System.out.println("First attempt has been done, this is secnd try");
			WebElement element = driver.findElement(By.cssSelector(locator));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
	}

	/**
	 * Ok alert.
	 */
	public void okAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	/**
	 * Cancel alert.
	 */
	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	/**
	 * Iframe handle.
	 *
	 * @param element
	 *            the element
	 */
	public void iframeHandle(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Go back to home window.
	 */
	public void goBackToHomeWindow() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Gets the links.
	 *
	 * @param locator
	 *            the locator
	 * @return the links
	 */
	public void getLinks(String locator) {
		driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
	}

	/**
	 * Take screen shot.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// taking Screen shot
	public void takeScreenShot() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("ScreenShot.png"));

	}

	/**
	 * Wait until click able.
	 *
	 * @param locator
	 *            the locator
	 */
	public void waitUntilClickAble(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Wait until visible.
	 *
	 * @param locator
	 *            the locator
	 */
	public void waitUntilVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Wait until selectable.
	 *
	 * @param locator
	 *            the locator
	 */
	public void waitUntilSelectable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	/**
	 * Up load fiel.
	 *
	 * @param locator
	 *            the locator
	 * @param path
	 *            the path
	 */
	public void upLoadFile(String locator, String path) {
		driver.findElement(By.cssSelector(locator)).sendKeys(path);

	}

	/**
	 * Clear input.
	 *
	 * @param locator
	 *            the locator
	 */
	public void clearInput(String locator) {
		driver.findElement(By.cssSelector(locator)).clear();
	}

	/**
	 * Keys input.
	 *
	 * @param locator
	 *            the locator
	 */
	public void keysInput(String locator) {
		driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
	}

}
