package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObject.googleMapsPage;


public class managePages extends commonOps {

    /**
     *enable use of the page-object in tests
     */
    public static void init(){
        googleMap = PageFactory.initElements(driver, googleMapsPage.class);

}


}



