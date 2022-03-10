package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import com.vytrack.utilities.WebTableUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US67_VehicleModels_Table extends TestBase {

    US69_Locators locators;

    @Test(dataProvider = "salesManagers")
    public void verify_columns_as_sales_manager(String usernames) {
        // login as sales manager
        VytrackUtils.loginAsSalesManager(usernames);
        navigateToVehicleModelSubMenu();
        checkingEachHeaderOfaTable();
//

    }

    private void navigateToVehicleModelSubMenu() {
        // Action class added
        Actions actions = new Actions(Driver.getDriver());
        VytrackUtils.waitTillLoaderMaskDisappear();
        locators = new US69_Locators();
        // hover over to Fleet Button and click Vehicles
        actions.moveToElement(locators.fleetButton).perform();
        locators.vehiclesModel.click();
        VytrackUtils.waitTillLoaderMaskDisappear();
    }

    private void checkingEachHeaderOfaTable() {
        List<String> actualHeadersFromVehicleModuleTable = WebTableUtils.getHeadersFromVehicleModelTable();
        ArrayList<String> expectedHeadersFromVehicleModuleTable = new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));
        Assert.assertEquals(actualHeadersFromVehicleModuleTable, expectedHeadersFromVehicleModuleTable);


    }

}
