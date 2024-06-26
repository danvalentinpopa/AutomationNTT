package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {
    private LoginElements element;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }
}
