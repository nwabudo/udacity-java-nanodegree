package com.udacity.jwdnd.c1.review.pageObject;

import com.udacity.jwdnd.c1.review.dtos.entity.ChatMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChatPage {

    protected WebDriver driver;

    @FindBy(id = "messageText")
    private WebElement messageTextInput;

    @FindBy(id = "messageType")
    private WebElement messageTypeInput;

    @FindBy(css = ".message-input .wrap button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "log-out")
    private WebElement logOutInput;

    private By firstMessageUsername = By.className("chatMessageUsername");

    private By firstMessageText = By.className("chatMessageText");

    public ChatPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("WakaChhat")) {
            throw new IllegalStateException("Log In failed, This is not Chat Home Page, " +
                    " current page is: " + driver.getCurrentUrl());
        }
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String message, int option){
        Select messageType = new Select(this.messageTypeInput);
        messageType.selectByIndex(option);
        this.messageTextInput.sendKeys(message);
        this.submitButton.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessageText(this.driver.findElements(firstMessageText).get(0).getText());
        result.setUsername(this.driver.findElements(firstMessageUsername).get(0).getText());
        return result;
    }

    public SignInPage logOut(){
        this.logOutInput.click();
        return new SignInPage(driver);
    }

}
