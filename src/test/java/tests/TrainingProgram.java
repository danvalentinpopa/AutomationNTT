package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;

    private Register register;
    private String email = "";
    private String parola = "";


    @BeforeTest
    public void setup() {


    }

    @Test
    public void openTrainingTab() {

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        Training training = new Training(driver);
        register = new Register(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/dateUserPopDan.properties");

        email = configLoader.getProperty("email");
        parola = configLoader.getProperty("parola");


        login();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();


        training.dragAndDropTrainingProgram(configLoader.getProperty("weekDay"),
                configLoader.getProperty("trainingProgram"));


        Assert.assertTrue(training.trainingProgramOnWeekday(configLoader.getProperty("weekDay"),"legs").
                equalsIgnoreCase("legs"));



    }

    private void login() {

        loginActions(email, parola);

        if (login.errorForbiddenAccessText()) {
            login.clickRegisterButton();
            register.registerUser(true, null, null, null);

            loginActions(email, parola);
        }
        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase(email));

    }

    private void loginActions(String email, String parola) {
        login.enterUserName(email);
        login.enterPassword(parola);
        login.clickSubmitButton();
    }
}
