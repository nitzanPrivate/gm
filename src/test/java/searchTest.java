
import org.testng.annotations.Test;
import utilities.commonOps;



public class searchTest extends commonOps {


    @Test(priority = 1, testName = "End 2 End testing" ,groups = {"sanity"})
    public static void e2eTest() throws InterruptedException {

        googleMap.searchField.sendKeys("Rome");
        googleMap.searchIcon.click();
        Thread.sleep(3000);
        CaptureScreen();
        googleMap.zoomIn.click();
        Thread.sleep(1000);
        CaptureScreen();
        googleMap.zoomIn.click();
        Thread.sleep(1000);
        CaptureScreen();
        googleMap.zoomIn.click();
        Thread.sleep(1000);
        CaptureScreen();

    }
}
