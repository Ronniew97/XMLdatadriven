package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.CustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class CustomerTest {

	WebDriver driver;

	@Test
	@Parameters({"username","password","fullname","company","email","number","address","city","state","country","group","pass","cpass"})
	public void validCustomerShouldBeAbleToAddHisContact(String username, String password, String fullname,
			String company, String email, String number, String address, String city, String state, String country,
			String group, String pass, String cpass) {
		
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSignInButton();
		CustomerPage customer = PageFactory.initElements(driver, CustomerPage.class);
		customer.clickCustomerButton();
		customer.clickAddCustomerButton();
		customer.enterFullName(fullname);
		customer.selectCompany(company);
		customer.enterEmail(email);
		customer.enterPhoneNumber(number);
		customer.enterAddress(address);
		customer.enterCity(city);
		customer.enterState(state);
		customer.selectCountry(country);
		customer.selectGroup(group);
		customer.createPassword(pass);
		customer.confirmPassword(cpass);
		customer.clickSaveButton();
	}
}
