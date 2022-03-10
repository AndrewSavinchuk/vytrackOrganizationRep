package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US69_Locators {

    public US69_Locators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Fleet')]")
    public WebElement fleetButton;

    @FindBy(xpath = "//span[.='Vehicles']/../..")
    public WebElement vehiclesLink;

    @FindBy(xpath = "//span[.='Vehicles Model']/../..")
    public WebElement vehiclesModel;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']/input")
    public WebElement mainCheckBox;

    @FindBy (xpath = "//td//input[@type='checkbox']")
    public List<WebElement> allCheckBoxes;

//    @FindBy(xpath = "//tr[3]//input[@type='checkbox']")
//    public WebElement randomCheckBox1;
//
//    @FindBy(xpath = "//tr[10]//input[@type='checkbox']")
//    public WebElement randomCheckBox2;
//
//    @FindBy(xpath = "//tr[24]//input[@type='checkbox']")
//    public WebElement randomCheckBox3;



}
