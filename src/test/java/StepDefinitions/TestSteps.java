package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestSteps {
    
    private static WebDriver driver = new ChromeDriver();
    
    @Given("Enter URL")
    public final void GivenEnterURL() {
        try {
            String homeURL = "http://sampleapp.tricentis.com/101/app.php";
            driver.navigate().to(homeURL);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }       
    }
    
    @When("Enter Vehicle Data as {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public final void WhenEnterVehicleData(String make, String model, String ccm, String kW, String date, String number, String rightHand, String number2, String fuel, String kg, String price, String mi) {
		Select dpdMake = new Select(driver.findElement(By.id("make")));
        dpdMake.selectByVisibleText(make);
        Select dpdModel = new Select(driver.findElement(By.id("model")));
        dpdModel.selectByVisibleText(model);
        WebElement cylinderCapacity = driver.findElement(By.id("cylindercapacity"));
        cylinderCapacity.click();
        cylinderCapacity.sendKeys(ccm);
        WebElement enginePerformance = driver.findElement(By.id("engineperformance"));
        enginePerformance.click();
        enginePerformance.sendKeys(kW);
        WebElement dateOfManufacture = driver.findElement(By.id("dateofmanufacture"));
        dateOfManufacture.click();
        dateOfManufacture.clear();
        dateOfManufacture.sendKeys(date);
        Select dpdNumberOfSeats = new Select(driver.findElement(By.id("numberofseats")));
        dpdNumberOfSeats.selectByVisibleText(number);
        if ((rightHand == "Yes")) {
            WebElement radioButton1 = driver.findElement(By.xpath("//input[@id=\'righthanddriveyes\']/following-sibling::span"));
            radioButton1.click();
        }
        else {
            WebElement radioButton2 = driver.findElement(By.xpath("//input[@id=\'righthanddriveno\']/following-sibling::span"));
            radioButton2.click();
        }      
        Select dpdNumberOfSeats2 = new Select(driver.findElement(By.id("numberofseatsmotorcycle")));
        dpdNumberOfSeats2.selectByVisibleText(number2);
        Select dpdFuel = new Select(driver.findElement(By.id("fuel")));
        dpdFuel.selectByVisibleText(fuel);
        WebElement payload = driver.findElement(By.id("payload"));
        payload.click();
        payload.sendKeys(kg);
        WebElement totalWeight = driver.findElement(By.id("totalweight"));
        totalWeight.click();
        totalWeight.sendKeys(kg);
        WebElement listPrice = driver.findElement(By.id("listprice"));
        listPrice.click();
        listPrice.sendKeys(price);
        WebElement annualMileage = driver.findElement(By.id("annualmileage"));
        annualMileage.click();
        annualMileage.sendKeys(mi);
    }
    
    @When("Enter Insurant Data as {string} {string} {string} {string} {string} {string} {string} {string}")
    public final void WhenEnterInsurantData(String name, String surname, String date, String gender, String country, String zip, String occupation, String hobbie) {
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.click();
        firstName.sendKeys(name);
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.click();
        lastName.sendKeys(surname);
        WebElement dateOfBirth = driver.findElement(By.id("birthdate"));
        dateOfBirth.click();
        dateOfBirth.clear();
        dateOfBirth.sendKeys(date);
        if ((gender == "Female")) {
            WebElement radioButton1 = driver.findElement(By.xpath("//input[@id=\'genderfemale\']/following-sibling::span"));
            radioButton1.click();
        }
        else {
            WebElement radioButton2 = driver.findElement(By.xpath("//input[@id=\'gendermale\']/following-sibling::span"));
            radioButton2.click();
        }      
        Select dpdCountry = new Select(driver.findElement(By.id("country")));
        dpdCountry.selectByVisibleText(country);
        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.click();
        zipCode.sendKeys(zip);
        Select dpdOccupation = new Select(driver.findElement(By.id("occupation")));
        dpdOccupation.selectByVisibleText(occupation);
        WebElement hobbies = driver.findElement(By.xpath(("//p/label/input[@value=\'" 
                            + (hobbie + "\']/following-sibling::span"))));
        hobbies.click();
    }
    
    @When("Enter Product Data as {string} {string} {string} {string} {string}")
    public final void WhenEnterProductData(String sum, String bonus, String damageIns, String opt, String courtesy) {
        WebElement startDate = driver.findElement(By.id("startdate"));
        startDate.click();
        startDate.clear();
        LocalDate date = LocalDate.now().plusMonths(1).plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        startDate.sendKeys(date.format(formatter).toString());
        Select dpdInsuranceSum = new Select(driver.findElement(By.id("insurancesum")));
        dpdInsuranceSum.selectByVisibleText(sum);
        Select dpdMeritRating = new Select(driver.findElement(By.id("meritrating")));
        dpdMeritRating.selectByVisibleText(bonus);
        Select dpdDamageInsurance = new Select(driver.findElement(By.id("damageinsurance")));
        dpdDamageInsurance.selectByVisibleText((damageIns + " Coverage"));
        String optionalProduct = opt.replace("\s", "");
        WebElement optionals = driver.findElement(By.xpath(("//p/label/input[@id=\'" 
                            + (optionalProduct + "\']/following-sibling::span"))));
        optionals.click();
        Select dpdCourtesyCar = new Select(driver.findElement(By.id("courtesycar")));
        dpdCourtesyCar.selectByVisibleText(courtesy);
    }
    
    @When("Select Price Option as {string}")
    public final void WhenSelectPriceOption(String opt) {
        WebElement option = driver.findElement(By.xpath(("//input[@name=\'Select Option\' and @value=\'" 
                            + (opt + "\']/following-sibling::span"))));
        option.click();
    }
    
    @When("Enter Send Quote Data as {string} {string} {string}")
    public final void WhenEnterSendQuoteData(String mail, String user, String pw) {
        WebElement email = driver.findElement(By.id("email"));
        email.click();
        email.sendKeys(mail);
        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys(pw);
        WebElement confirmPassword = driver.findElement(By.id("confirmpassword"));
        confirmPassword.click();
        confirmPassword.sendKeys(pw);
    }
    
    @When("Click Next From {string} Tab")
    public final void WhenClickNextButton(String tabpage) {
        String tab = tabpage.replace("\s", "").toLowerCase();
        WebElement nextButton = driver.findElement(By.id(("next" + tab)));
    	try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        nextButton.click();
    }
    
    @When("Click Send")
    public final void WhenClickSendButton() {
        WebElement sendButton = driver.findElement(By.id("sendemail"));
        sendButton.click();
    }
    
    @Then("Verify Email Successful Message To Be {string}")
    public final void ThenVerifyEmailSuccessfulMessageToBe(String expectedText) {
        
    	try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        WebElement dialogWindow = driver.findElement(By.xpath("//div[@class=\'sweet-alert showSweetAlert visible\']"));
        WebElement dialogText = dialogWindow.findElement(By.tagName("h2"));
        String actualMessage = TestSteps.CleanSpecialChars(dialogText.getText());
        expectedText = TestSteps.CleanSpecialChars(expectedText);
        
        if (dialogWindow.isDisplayed()) {
            assertEquals(expectedText, actualMessage);
            WebElement okButton = dialogWindow.findElement(By.xpath("//button[@class=\'confirm\']"));
            okButton.click();
        }
        else {
            fail("Test Failed.");
        }      
    }
    
    public static String CleanSpecialChars(String TextToBeCleaned) {
        String textToBeCleaned = TextToBeCleaned.replaceAll("[^a-zA-Z0-9]", "").trim();
        return textToBeCleaned;
    }
    
}
