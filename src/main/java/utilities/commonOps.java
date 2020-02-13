package utilities;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class commonOps extends base{
	public static WebDriver driver;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());


	@BeforeClass(alwaysRun=true)
	public static void openBrowser() throws ParserConfigurationException, IOException, SAXException {
		initBrowser("chrome");  //later can use to get from csv file
        managePages.init();
		driver.get(googleMapURL);
		assertEquals(driver.getCurrentUrl(),googleMapURL);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("10"), TimeUnit.SECONDS);
	}

	@AfterSuite  (alwaysRun=true)
	public static void closeBrowser() throws InterruptedException
	{
		driver.quit();
	}


	/**
	 * This Function Initiate the Browser Type, It get the Value from Configuration File and Initiate the driver Accordingly
	 * @param browserType
	 * returns Initialized driver
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */

	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException {
		//
		switch (browserType.toLowerCase()) {

			case "chrome":
				driver = initChromeDriver();
				break;

			default:
				driver = initChromeDriver();
				break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("10"), TimeUnit.SECONDS);
	}



	/**
	 * This Function Initiate Chrome driver  - for this test i only add chromedriver but can be added here more drivers
	 * @return Webdriver
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */

	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.chrome.driver","./webDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

    /**
     * This Function Capture Screen Shot
     * @return Value: Image Path (as String)
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */

    public static String CaptureScreen()
    {
        String imgPath = "./screenShots/"  + timeStamp + "/" + UUID.randomUUID().toString() + ".png";
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(imgPath);
        try
        {
            FileUtils.copyFile(oScnShot, oDest);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return imgPath;
    }


}



