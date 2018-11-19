package wsm.teamChoDien.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.SwitchChildWindown;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.ChangePasswordPageObject;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.ForgotPasswordPageObjects;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.YopMailPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class ForgotPasswordTest extends CommonTest {
	// // F001 ~ F004
	// @Test
	// public void checkComponent() throws Exception {
	//
	// // Go to login page
	// TransitionPageAction.gotoLoginPage(driver);
	//
	// WebDriverWait wait = new WebDriverWait(driver, 20);
	// wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));
	//
	// // Go to reset password page by click on Forgot password link
	// LoginPageObjects.link_ForgotPass(driver).click();
	//
	// wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));
	//
	// // FOR_PASS 001
	// // FOR_PASS 002~004
	// // Check component
	//
	// // Title
	// String title = ForgotPasswordPageObjects.txt_Title(driver).getText();
	// Assert.assertEquals(ConstantVariable.FORGOTPASSWORD_TITLE, title);
	//
	// // Mail textbox
	// Assert.assertTrue(ForgotPasswordPageObjects.txt_UserEmail(driver).isEnabled(),
	// "Mail textbox failed");
	//
	// // OK button
	// Assert.assertTrue(ForgotPasswordPageObjects.btn_OK(driver).isDisplayed(),
	// "OK button failed");
	//
	// // Cancel button
	// Assert.assertTrue(ForgotPasswordPageObjects.btn_Cancel(driver).isDisplayed(),
	// "Cancel button failed");
	//
	// // Back to login link
	// Assert.assertTrue(ForgotPasswordPageObjects.link_BackToLogin(driver).isDisplayed(),
	// "Back to login link Failed");
	//
	// ForgotPasswordPageObjects.link_BackToLogin(driver).click();
	// wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.btn_Login(driver)));
	//
	// Assert.assertTrue(LoginPageObjects.btn_Login(driver).isDisplayed(),
	// "Click back to login link Failed");
	// }

	// F005
	// @Test
//	public void requestSuccessfull() throws Exception {
//
//		// Go to login page
//		TransitionPageAction.gotoLoginPage(driver);
//
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));
//
//		// Go to reset password page by click on Forgot password link
//		LoginPageObjects.link_ForgotPass(driver).click();
//
//		// FOR_PASS 005
//		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);
//		ForgotPasswordPageObjects.btn_OK(driver).click();
//		Assert.assertEquals(ForgotPasswordPageObjects.msg_MessageSendSuccessfull(driver).getText(),
//				ConstantVariable.SEND_SUCCESSFULL_MESSAGE, "FOR_PASS 005 Failed");
//	}
//
//	// F009 ~ F011
//	// @Test
//	public void requestUnsuccessfull() throws Exception {
//
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//
//		// Go to login page
//		TransitionPageAction.gotoLoginPage(driver);
//		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));
//
//		// Go to reset password page by click on Forgot password link
//		LoginPageObjects.link_ForgotPass(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));
//
//		// FOR_PASS 009
//		ForgotPasswordPageObjects.btn_OK(driver).click();
//		String actual_009 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
//		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, actual_009, "009_Click OK, mess appear Failed");
//
//		// FOR_PASS 010
//		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_INVALID);
//		ForgotPasswordPageObjects.btn_OK(driver).click();
//		String mess_010 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
//		Assert.assertEquals(ConstantVariable.USERNAME_INVALID_MESSAGE, mess_010, "010_Click OK, mess appear Failed");
//		ForgotPasswordPageObjects.txt_UserEmail(driver).clear();
//
//		// FOR_PASS 011
//		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_NOT_EXIT);
//		ForgotPasswordPageObjects.btn_OK(driver).click();
//		String mess_011 = ForgotPasswordPageObjects.msg_emailNotFound(driver).getText();
//		Assert.assertEquals(ConstantVariable.USERNAME_NOT_EXIST_MESSAGE, mess_011, "011_Click OK, mess appear Failed");
//	}

	// FOR_PASS_005
	// @Test
	public void checkMessageSendMailSuccessfully() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_UserEmail(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.msg_MessageSendSuccessfull(driver)));

		String actual_message = ForgotPasswordPageObjects.msg_MessageSendSuccessfull(driver).getText();

		String expected_message = ConstantVariable.SEND_SUCCESSFULL_MESSAGE;

		// Verify message
		Assert.assertEquals(actual_message, expected_message);
	}

	// FOR_PASS_006
	// @Test
	public void checkMailSent() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Get Mail Title
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		String actual_title = YopMailPageObject.title_mail(driver).getText();

		String expected_title = ConstantVariable.MAIL_TITLE;

		// Verify mail title
		Assert.assertEquals(actual_title, expected_title);

	}

	// FOR_PASS_007
	// @Test
	public void gotoChangePasswordScreen() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Click on Change password link
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		YopMailPageObject.lnk_ChangePassword(driver).click();

		// Verify that Change password screen is displayed
		SwitchChildWindown.switchChildWindown(driver);

		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		String actual_title = ChangePasswordPageObject.lb_ChangePassword(driver).getText();

		String expected_title = ConstantVariable.CHANGE_PASSWORD_SCREEN_TITLE;

		Assert.assertEquals(actual_title, expected_title);

	}

	// FOR_PASS_008
	@Test
	public void loginWithCurrentPassword() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				"//p[contains(text(),'You will receive an email with instructions on how to reset your password in a few minutes')]")));

		// Back to Login form
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ForgotPasswordPageObjects.link_BackToLogin(driver));

		// Doing Login action with valid User name and password
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.btn_Login(driver)));

		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Get message
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.mess_loginSuccess(driver)));

		String[] message = DashboardPageObject.mess_loginSuccess(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(message[message.length - 1], ConstantVariable.LOGIN_SUCCESSFULY_MESSAGE);

	}

	// FOR_PASS_017
	@Test
	public void unsuccessfuly_ConfirmPasswordBlank() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Click on Change password link
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		YopMailPageObject.lnk_ChangePassword(driver).click();

		// Verify that Change password screen is displayed
		SwitchChildWindown.switchChildWindown(driver);

		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		// Input new password
		ForgotPasswordPageObjects.txt_NewPassword(driver).sendKeys(ConstantVariable.PASSWORD);

		// Click OK button
		ForgotPasswordPageObjects.btn_submitPassword(driver);

		// Verify mess is displayed
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.mess_PasswordError(driver)));
		String mess = ForgotPasswordPageObjects.mess_PasswordError(driver).getText();
		Assert.assertEquals(mess, ConstantVariable.MESSAGE_PASSWORD_REQUIRED);
	}

	// FOR_PASS_018
	@Test
	public void unsuccessfuly_ConfirmPasswordLess6() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Click on Change password link
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		YopMailPageObject.lnk_ChangePassword(driver).click();

		// Verify that Change password screen is displayed
		SwitchChildWindown.switchChildWindown(driver);

		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		// Input new password
		ForgotPasswordPageObjects.txt_NewPassword(driver).sendKeys(ConstantVariable.PASSWORD);

		// Input new password
		ForgotPasswordPageObjects.txt_ConfirmPassword(driver).sendKeys("1");

		// Click OK button
		ForgotPasswordPageObjects.btn_submitPassword(driver);

		// Verify mess is displayed
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.mess_PasswordError(driver)));
		String mess = ForgotPasswordPageObjects.mess_PasswordError(driver).getText();
		Assert.assertEquals(mess, ConstantVariable.MESSAGE_PASSWORD_INVALID_LESS_6);
	}

	// FOR_PASS_019
	@Test
	public void unsuccessfuly_ConfirmPasswordOver128() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Click on Change password link
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		YopMailPageObject.lnk_ChangePassword(driver).click();

		// Verify that Change password screen is displayed
		SwitchChildWindown.switchChildWindown(driver);

		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		// Input new password
		ForgotPasswordPageObjects.txt_NewPassword(driver).sendKeys(ConstantVariable.PASSWORD);

		// Input new password
		ForgotPasswordPageObjects.txt_ConfirmPassword(driver).sendKeys(ConstantVariable.PASSWORD_129);

		// Click OK button
		ForgotPasswordPageObjects.btn_submitPassword(driver);

		// Verify mess is displayed
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.mess_PasswordError(driver)));
		String mess = ForgotPasswordPageObjects.mess_PasswordError(driver).getText();
		Assert.assertEquals(mess, ConstantVariable.MESSAGE_PASSWORD_INVALID_OVER_129);
	}

	// FOR_PASS_020
	@Test
	public void unsuccessfuly_ConfirmPasswordNotMap() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Input email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);

		// Click OK button
		ForgotPasswordPageObjects.btn_submitPassword(driver);

		// Go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);

		// Click on Change password link
		driver.switchTo().frame("ifmail");

		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		YopMailPageObject.lnk_ChangePassword(driver).click();

		// Verify that Change password screen is displayed
		SwitchChildWindown.switchChildWindown(driver);

		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		// Input new password
		ForgotPasswordPageObjects.txt_NewPassword(driver).sendKeys(ConstantVariable.PASSWORD);

		// Input new password
		ForgotPasswordPageObjects.txt_ConfirmPassword(driver).sendKeys(ConstantVariable.PASSWORD + "1");

		// Click OK button
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// Verify mess is displayed
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.mess_PasswordError(driver)));
		String mess = ForgotPasswordPageObjects.mess_PasswordError(driver).getText();
		Assert.assertEquals(mess, ConstantVariable.MESSAGE_CONFIRMPASSWORD_NOT_MAP);
	}
	
	// FOR_PASS_013
			@Test
			public void successfuly_ChangePassword() throws Exception {

				// Go to login page
				TransitionPageAction.gotoLoginPage(driver);
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

				// Go to reset password page by click on Forgot password link
				LoginPageObjects.link_ForgotPass(driver).click();
				wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

				// Input email
				ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.FORGOT_USERNAME);

				// Click OK button
				ForgotPasswordPageObjects.btn_OK(driver).click();

				// Go to yopmail
				driver.get(ConstantVariable.YOP_MAIL_URL);

				// Click on Change password link
				driver.switchTo().frame("ifmail");
				wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));
				YopMailPageObject.lnk_ChangePassword(driver).click();

				// Verify that Change password screen is displayed
				SwitchChildWindown.switchChildWindown(driver);
				wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

				// Input new password
				ForgotPasswordPageObjects.txt_NewPassword(driver).sendKeys(ConstantVariable.NEW_PASSWORD);
				ForgotPasswordPageObjects.txt_ConfirmPassword(driver).sendKeys(ConstantVariable.NEW_PASSWORD);

				// Click OK button
				ForgotPasswordPageObjects.btn_submitPassword(driver);
				
				// Close popup Day off
				ClosePopupDayOffAction.closePopup(driver);

				// Verify mess is displayed
				wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.mess_PasswordError(driver)));
				String mess = ForgotPasswordPageObjects.mess_ChangePassSuccess(driver).getText();
				Assert.assertEquals(mess, ConstantVariable.MESSAGE_CHANGEPASS_SUCCESS);
				
				//FOR_PASS_014 - Check Working Calendar screen displays
				Assert.assertEquals(driver.getTitle(), ConstantVariable.TAB_TITLE);
			}
			
		//FOR_PASS_015
		@Test
		public void loginSuccessWithNewPass() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.NEW_PASSWORD);

			// Close pop-up Day off
			ClosePopupDayOffAction.closePopup(driver);

			// Get message
			String[] message = DashboardPageObject.mess_loginSuccess(driver).getText().split("\n");

			// Verify Result message successfully
			Assert.assertEquals(message[message.length - 1], ConstantVariable.LOGIN_SUCCESSFULY_MESSAGE);
		}
		
		//FOR_PASS_016
			@Test
			public void loginFailedWithOldPass() throws Exception {

				// Go to Login Page
				TransitionPageAction.gotoLoginPage(driver);

				// Doing Login action with valid User name and password
				LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.OLD_PASSWORD);

				// Verify Result
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.msg_ErrorLoginMessage(driver)));

				String expectedResult = LoginPageObjects.msg_ErrorLoginMessage(driver).getText();
				System.out.println(expectedResult);
				Assert.assertEquals(expectedResult, ConstantVariable.LOGIN_FAILED_MESSAGE);
			}

	// FOR_PASS_001
	@Test
	public void checkForgotPasswordLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Check Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));

		Assert.assertEquals(ForgotPasswordPageObjects.txt_Title(driver).getText(),
				ConstantVariable.FORGOTPASSWORD_TITLE);
	}

	// FOR_PASS_002
	// Title
	@Test
	public void checkForgotPasswordTitle() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));

		// Check title
		Assert.assertEquals(ForgotPasswordPageObjects.txt_Title(driver).getText(),
				ConstantVariable.FORGOTPASSWORD_TITLE);
	}

	// Mail textbox
	@Test
	public void checkMailTextbox() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_UserEmail(driver)));

		// Check User mail textbox
		Assert.assertTrue(ForgotPasswordPageObjects.txt_UserEmail(driver).isEnabled());
	}

	// OK button
	@Test
	public void checkOKButtonOfForgotPassScr() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Check OK button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_OK(driver).isEnabled());
	}

	// Cancel Button
	@Test
	public void checkCancelButton() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_Cancel(driver)));

		// Check Cancel Button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_Cancel(driver).isEnabled());
	}

	// Back to login link
	@Test
	public void checkBackToLoginLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.link_BackToLogin(driver)));

		// Check Back to login link
		Assert.assertTrue(ForgotPasswordPageObjects.link_BackToLogin(driver).isDisplayed());
	}

	// FOR_PASS_004
	@Test
	public void checkClickBackToLoginLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.link_BackToLogin(driver)));

		// Check Click Back to login link
		ForgotPasswordPageObjects.link_BackToLogin(driver).click();
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.btn_Login(driver)));

		// Check Login screen open successfully
		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isEnabled());
	}

	// FOR_PASS 009
	@Test
	public void requestUnsuccessfullBlankEmail() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with blank
		// Email
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String actual_009 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, actual_009);

	}

	// FOR_PASS 010
	@Test
	public void requestUnsuccessfullValidEmail() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with invaid
		// Email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_INVALID);
		ForgotPasswordPageObjects.btn_OK(driver).click();

		String mess_010 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_INVALID_MESSAGE, mess_010);
	}

	// FOR_PASS 011
	@Test
	public void requestUnsuccessfullEmailNotExist() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with valid
		// Email but not existing
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_NOT_EXIT);
		ForgotPasswordPageObjects.btn_OK(driver).click();

		String mess_011 = ForgotPasswordPageObjects.msg_emailNotFound(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_NOT_EXIST_MESSAGE, mess_011);
	}

	// FOR_PASS_012 - Check Component Change Password Screen
	// Check Title
	@Test
	public void checkTitleChangePassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ChangePassword(driver)));

		// check Title
		Assert.assertEquals(ChangePasswordPageObject.lb_ChangePassword(driver).getText(),
				ConstantVariable.CHANGE_PASSWORD_SCREEN_TITLE);
	}

	// Check Label New Password
	@Test
	public void checkLabelNewPassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_NewPassword(driver)));

		// check New password label
		Assert.assertEquals(ChangePasswordPageObject.lb_NewPassword(driver).getText(),
				ConstantVariable.NEW_PASSWORD_LABEL);
	}

	// Check New password textbox
	@Test
	public void checkNewPasswordTextbox() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.txb_NewPassword(driver)));

		// check New password textbox
		Assert.assertTrue((ChangePasswordPageObject.txb_NewPassword(driver).isDisplayed()));
	}

	// Check Confirm new password label
	@Test
	public void checkLabelConfirmNewPassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.lb_ComfirmNewPassword(driver)));

		// check label Confirm NewPassword
		Assert.assertEquals(ChangePasswordPageObject.lb_ComfirmNewPassword(driver).getText(),
				ConstantVariable.CONFIRM_NEW_PASSWORD_LABEL);
	}

	// check Confirm New password textbox
	@Test
	public void checkConfirmNewPasswordTextbox() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.txb_ConfirmNewPassword(driver)));

		// check Confirm New password textbox
		Assert.assertTrue((ChangePasswordPageObject.txb_ConfirmNewPassword(driver).isDisplayed()));
	}

	@Test
	public void checkOKButtonOfChangePassScr() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObject.btn_OK(driver)));

		// check OK button
		Assert.assertTrue((ChangePasswordPageObject.btn_OK(driver).isDisplayed()));
	}

}
