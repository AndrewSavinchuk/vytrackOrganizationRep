package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebTableUtils {

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.

    public static String returnOrderDate(String customerName){
       String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";
       WebElement customerDateCell = Driver.getDriver().findElement(By.xpath(locator));
       return customerDateCell.getText();
    }

//    public static String returnOrderDate2(WebDriver driver, String customerName){
//        return driver.findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();
//    }

    //Method #2 info:
    //• Name: orderVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String customerName
    //• Arg3: String expectedOrderDate
    //This method should accept above-mentioned arguments and internally assert
    //expectedOrderDate matching actualOrderDate.

    public static void orderVerify( String customerName, String expectedOrderDate){

        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = Driver.getDriver().findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

    /**
     * this method is using for finding vehicle model table headers
     *
     * @return List<String> titles
     */

    public static List<String> getHeadersFromVehicleModelTable() {
        List<WebElement> headerElements = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> headerTitles = new ArrayList<>();
        headerElements.forEach(k -> headerTitles.add(k.getText()));
        return headerTitles;
    }
}







