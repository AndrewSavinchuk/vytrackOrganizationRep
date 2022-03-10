package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US67_VehicleModels_Table extends TestBase {

    US69_Locators locators;

    @Test(dataProvider = "salesManagers")
    public void verify_columns_as_sales_manager(String usernames) {
        // login as sales manager
        VytrackUtils.loginAsSalesManager(usernames);
        navigateToVehicleModelSubMenu();

    }

    private void navigateToVehicleModelSubMenu() {
        // Action class added
        Actions actions = new Actions(Driver.getDriver());
        VytrackUtils.waitTillLoaderMaskDisappear();
        locators = new US69_Locators();
        // hover over to Fleet Button and click Vehicles
        actions.moveToElement(locators.fleetButton).perform();
        locators.vehiclesModel.click();
    }


}
