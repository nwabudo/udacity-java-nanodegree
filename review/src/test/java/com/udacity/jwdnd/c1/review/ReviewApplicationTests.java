package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.dtos.entity.ChatMessage;
import com.udacity.jwdnd.c1.review.pageObject.ChatPage;
import com.udacity.jwdnd.c1.review.pageObject.SignInPage;
import com.udacity.jwdnd.c1.review.pageObject.SignUpDetails;
import com.udacity.jwdnd.c1.review.pageObject.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;

	public String baseURL;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		baseURL = "http://localhost:" + port;
	}

	@Test
	void testFirstUserSignUpLoginAndChatProcess() throws InterruptedException {
		SignUpDetails signupObject = new SignUpDetails();
		String username = "pazastoupa";
		String password = "whatabadpassword";
		String messageText = "Hello!";
		signupObject.setFirstName("Emmanuel");
		signupObject.setLastName("Onyekachi");
		signupObject.setUsername(username);
		signupObject.setPassword(password);

		driver.get(baseURL + "/auth/signup");
		SignInPage signInPage = new SignUpPage(driver).initiateSignUp(signupObject);

		ChatPage homePage = signInPage.isLoginValid(username, password);
		homePage.sendMessage(messageText, 1);

		ChatMessage sentMessage = homePage.getFirstMessage();
		assertEquals(username, sentMessage.getUsername());
		assertEquals(messageText.toUpperCase(), sentMessage.getMessageText());

		homePage.logOut();
	}

}
