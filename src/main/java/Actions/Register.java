package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;

public class Register {


    private RegisterElements elements = null;

    public Register(WebDriver driver){
        elements = new RegisterElements(driver);
    }

    public String getSingUpText(){
        return elements.singUpText().getText();
    }

    public void setFirstname(String firstname){
        elements.firstname().sendKeys(firstname);
    }

    public void setPhoneNumber(String phoneNumber){
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void setLastname(String lastname){
        elements.lastname().sendKeys(lastname);
    }

    public void setEmail(String email){
        elements.email().sendKeys(email);
    }

    public void password(String password){
        elements.password().sendKeys(password);
    }

    public void city(String city){
        elements.city().sendKeys(city);
    }

    public void customer(){
        elements.customer().click();
    }

    public void trainer(){
        elements.trainer().click();
    }

    public void clickSubmitButton(){
        elements.submit().click();
    }
}
