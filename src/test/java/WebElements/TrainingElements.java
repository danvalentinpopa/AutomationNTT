package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TrainingElements {

    private WebDriver driver = null;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public TrainingElements(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement generatedProgram(){
        return driver.findElement(By.cssSelector(".generate-program"));
    }

    public WebElement weekDay(String dayNumber){
        return driver.findElement(By.cssSelector("#cdk-drop-list-" + dayNumber));
    }

    public List<WebElement> trainingPrograms(){
        return driver.findElements(By.cssSelector(".cdk-drag"));
    }

    public List<WebElement> trainingProgramsOnWeekday(String dayNumber){
        return driver.findElements(By.cssSelector("#cdk-drop-list-" + dayNumber + " .cdk-drag"));
    }
}
