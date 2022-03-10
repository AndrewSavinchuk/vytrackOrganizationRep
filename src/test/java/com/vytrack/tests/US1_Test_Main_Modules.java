package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US1_Test_Main_Modules extends TestBase {
    // testing modules for sales manager


    @Test(dataProvider = "salesManagers")
    public void verifying_modules_as_sales_manager(String usernames) {
        VytrackUtils.loginAsSalesManager(usernames);
        BrowserUtils.sleep(2);

        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualModuleTexts = new ArrayList<>();
/*
        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualModuleTexts.add(moduleElementText);
        }
     */

        moduleElements.forEach(p -> actualModuleTexts.add(p.getText()));
        System.out.println("actualModuleTexts = " + actualModuleTexts);

        List<String> expectedModuleTexts = new ArrayList<>(Arrays.asList(

                "Dashboards",
                "Fleet",
                "Customers",
                "Sales",
                "Activities",
                "Marketing",
                "Reports & Segments",
                "System"

        ));

        Assert.assertEquals(actualModuleTexts, expectedModuleTexts);
        BrowserUtils.sleep(1);
        VytrackUtils.logOut();
    }

    // testing modules for store manager
    @Test(dataProvider = "storeManagers")
    public void verifying_modules_as_store_manager(String usernames) {

        VytrackUtils.loginAsStoreManager(usernames);
        BrowserUtils.sleep(2);

        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualModuleTexts = new ArrayList<>();
/*
        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualModuleTexts.add(moduleElementText);
        }
     */

        moduleElements.forEach(p -> actualModuleTexts.add(p.getText()));
        System.out.println("actualModuleTexts = " + actualModuleTexts);

        List<String> expectedModuleTexts = new ArrayList<>(Arrays.asList(

                "Dashboards",
                "Fleet",
                "Customers",
                "Sales",
                "Activities",
                "Marketing",
                "Reports & Segments",
                "System"

        ));

        Assert.assertEquals(actualModuleTexts, expectedModuleTexts);
        BrowserUtils.sleep(1);
        VytrackUtils.logOut();
    }

    // testing modules for driver
    @Test(dataProvider = "drivers")
    public void verifying_modules_as_driver(String usernames) {

        VytrackUtils.loginAsDriver(usernames);
        BrowserUtils.sleep(2);

        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualModuleTexts = new ArrayList<>();
/*
        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualModuleTexts.add(moduleElementText);
        }
     */

        moduleElements.forEach(p -> actualModuleTexts.add(p.getText()));
        System.out.println("actualModuleTexts = " + actualModuleTexts);

        List<String> expectedModuleTexts = new ArrayList<>(Arrays.asList(

                "Fleet",
                "Customers",
                "Activities",
                "System"

        ));

        Assert.assertEquals(expectedModuleTexts, actualModuleTexts);
        BrowserUtils.sleep(1);
        VytrackUtils.logOut();

    }


}






