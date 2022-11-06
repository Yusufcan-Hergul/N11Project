package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Giriş Yap']")
    private WebElement signInBtn;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"loginButton\"]")
    private WebElement loginBtn;

    @FindBy (css = "a[title='Hesabım']")
    private WebElement dashboard;

    WebElement myElement;
    public void findAndSend(String strElement, String value){
        switch (strElement)
        {
            case "email" : myElement = email;break;
            case "password" : myElement = password;break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement){
        switch (strElement)
        {
            case "signInBtn" : myElement = signInBtn; break;
            case "loginBtn" : myElement = loginBtn; break;

        }

        clickFunction(myElement);
    }

    public void assertElementVisible(String strElement){
        switch (strElement)
        {
            case "dashboard" : myElement = dashboard;break;

        }

        verifyElementVisible(myElement);
    }


    public void SearchAndDelete(String searchText){

        findAndSend("searchInput", searchText);
        findAndClick("searchButton");



        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));


        findAndClick("deleteButton");
        findAndClick("deleteDialogBtn");
    }













}
