package tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.UserLogin;

public class LoginTest extends TestBase{

	UserLogin loginPage;
	
	@Test(dataProvider="TestData", dataProviderClass = ExcelReader.class)
	public void InvalidUserNameIsValidated(String user, String pass, String flag)
	{
		UserLogin loginPage = new UserLogin(driver);
		loginPage.Enter_Credentials("nessma", "test");
		if (flag.equalsIgnoreCase("u"))
			assertEquals(loginPage.RetrieveInvalidMessage().contains("Your username is invalid!"), true);


	}
	
	@Test(dataProvider="TestData", dataProviderClass = ExcelReader.class)
	public void InvalidPasswordIsValidated(String user, String pass, String flag)
	{
		UserLogin loginPage = new UserLogin(driver);
		loginPage.Enter_Credentials("tomsmith", "test");
		if (flag.equalsIgnoreCase("p"))
			assertEquals(loginPage.RetrieveInvalidMessage().contains("Your password is invalid!"), true);


	}
}
