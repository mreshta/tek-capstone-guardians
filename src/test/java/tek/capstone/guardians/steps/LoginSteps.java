package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class LoginSteps extends CommonUtility{

	POMFactory pomFactory=new POMFactory();
	private String randomEmail;
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
	Assert.assertTrue(pomFactory.homePage().tekschoolLogo.isDisplayed());
	logger.info("The user is on tek retail website");
	}
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
	click(pomFactory.loginPage().signInLink);
	logger.info("The User clicked on signIn button successfully");
	}
	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
	sendText(pomFactory.loginPage().emailField, email);
	sendText(pomFactory.loginPage().passwordField, password);
	logger.info("The user successfully entred the email and password");
	}
	@When("User click on login button")
	public void userClickOnLoginButton() {
	click(pomFactory.loginPage().loginBttn);
	logger.info("the user clicked on the login button successfully");
	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(pomFactory.loginPage().logoutBttn.isDisplayed());
	logger.info("The user is signed in successfully");
	
	}	    
//	create new account steps
	
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.loginPage().newAccountBttn);
		logger.info("Create new account bttn clicked successfully");    
	}
	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		
		
		randomEmail = DataGenerator.getEmail();
        List<Map<String, String>> signUpDetails = dataTable.asMaps(String.class, String.class);

       
        Map<String, String> data = signUpDetails.get(0);

        String name = data.get("name");
        String email = randomEmail;
        String password = data.get("password");
        String confirmPassword = data.get("confirmPassword");
        
        //sendText(pomFactory.retailAccountPage().cardNumberField, paymentInfo.get(0).get("cardNumber"));
        
        sendText(pomFactory.loginPage().nameInputField, name);
        sendText(pomFactory.loginPage().emailInputField, email);
        sendText(pomFactory.loginPage().passwordInputField, password);
        sendText(pomFactory.loginPage().confirmPassInputField, confirmPassword);
        
        
	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(pomFactory.loginPage().signupBttn);
        logger.info("Signup button was clicked sucessfully");
	}
	@Then("Verify user account is created")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(pomFactory.loginPage().logoutBttn.isDisplayed());
        logger.info("User account is created successfully");
}
	
}	
	
