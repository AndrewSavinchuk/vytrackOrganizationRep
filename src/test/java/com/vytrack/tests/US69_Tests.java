package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class US69_Tests extends TestBase {

    US69_Locators locators;

    @Test(dataProvider = "salesManagers")
    public void loginAsSalesManagers(String usernames) {
// Enter login page
        VytrackUtils.loginAsSalesManager(usernames);
        VytrackUtils.waitTillLoaderMaskDisappear();
        navigateToVehicleSubMenu();
        verifyAllCheckBoxesUnchecked();
        verifyAllCheckBoxesChecked();
//using method to select and check random checkboxes
        selectRandomCheckBoxes(locators.allCheckBoxes);
        BrowserUtils.sleep(3);
        //VytrackUtils.logOut();
    }

    @Test(dataProvider = "storeManagers")
    public void loginAsStoreManagers(String usernames) {
// Enter login page
        VytrackUtils.loginAsSalesManager(usernames);
        VytrackUtils.waitTillLoaderMaskDisappear();
        navigateToVehicleSubMenu();
        verifyAllCheckBoxesUnchecked();
        verifyAllCheckBoxesChecked();
//using method to select and check random checkboxes
        selectRandomCheckBoxes(locators.allCheckBoxes);
        BrowserUtils.sleep(3);
        //VytrackUtils.logOut();
    }

    @Test(dataProvider = "drivers")
    public void loginAsDrivers(String usernames) {
// Enter login page
        VytrackUtils.loginAsSalesManager(usernames);
        VytrackUtils.waitTillLoaderMaskDisappear();
        navigateToVehicleSubMenu();
        BrowserUtils.sleep(3);
        //VytrackUtils.logOut();

    }

    private void navigateToVehicleSubMenu() {
        // Action class added
        Actions actions = new Actions(Driver.getDriver());
        locators = new US69_Locators();
        // hover over to Fleet Button and click Vehicles
        actions.moveToElement(locators.fleetButton).perform();
        locators.vehiclesLink.click();
    }

    private void verifyAllCheckBoxesUnchecked() {
        for (WebElement eachCheckBox : locators.allCheckBoxes) {
            Assert.assertFalse(eachCheckBox.isSelected());
        }
    }

    private void verifyAllCheckBoxesChecked() {
        //selecting main checkbox
        locators.mainCheckBox.click();
        // check is ALL checkboxes are selected
        for (WebElement eachCheckBoxAfterClick : locators.allCheckBoxes) {
            Assert.assertTrue(eachCheckBoxAfterClick.isSelected());
        }
    }
    private void selectRandomCheckBoxes(List allBoxes) {
        locators.mainCheckBox.click();
        int checkBoxesSize = allBoxes.size();
        int randomIndex = new Random().nextInt(checkBoxesSize);
        WebElement randomCheckBox = (WebElement)allBoxes.get(randomIndex);
        randomCheckBox.click();
        Assert.assertTrue(randomCheckBox.isSelected());
    }

}
