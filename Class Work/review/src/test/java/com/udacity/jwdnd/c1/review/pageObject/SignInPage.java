package com.udacity.jwdnd.c1.review.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    protected WebDriver driver;

    @FindBy(name = "username")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("Login")) {
            throw new IllegalStateException("Log In Redirect failed, This is not Login Page, " +
                    " current page is: " + driver.getCurrentUrl());
        }
        PageFactory.initElements(driver, this);
    }

    public ChatPage isLoginValid(String userName, String password){
        this.userNameInput.sendKeys(userName);
        this.passwordInput.sendKeys(password);
        this.submitButton.submit();

        System.out.println("Current Url is " + this.driver.getCurrentUrl());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = driver.getCurrentUrl();
        url = url.split("/(?!.*/)")[0] + "/chat";
        driver.get(url);
        return new ChatPage(driver);
    }
}
