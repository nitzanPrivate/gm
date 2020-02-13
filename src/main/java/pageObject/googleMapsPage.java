package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class googleMapsPage {
    @FindBy(how = How.ID, using = "searchboxinput")
    public WebElement searchField;

    @FindBy(how = How.ID, using = "searchbox-searchbutton")
    public WebElement searchIcon;

    @FindBy(how = How.ID, using = "widget-zoom-in")
    public WebElement zoomIn;
}
