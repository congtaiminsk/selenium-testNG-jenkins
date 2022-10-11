package helpers;

import org.openqa.selenium.By;

public class LocatorHelpers {

    public static By judgeLocatorBy(String locatorType, String locatorValue){
        By locatorBy = null;
        switch (locatorType) {
            case "xPath":
                locatorBy = By.xpath(locatorValue);
                break;
            case "id":
                locatorBy = By.id(locatorValue);
                break;
            default:
                break;
        }
        return locatorBy;
    }
}
