package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class CalendarTest extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;

    private Register register;
    private String email = "";
    private String parola = "";


    @Test
    public void openDashboard() {

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        Training training = new Training(driver);
        register = new Register(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/propietati/dateUserPopDan.properties");
        ConfigLoader configLoaderDate = new ConfigLoader("src/test/resources/propietati/dateData.properties");

        email = configLoader.getProperty("email");
        parola = configLoader.getProperty("parola");
        login();

        dashboard.clickSpecificDay(configLoaderDate.getProperty("date"));



        dashboard.sendEventText(configLoaderDate.getProperty("eventText"));
        dashboard.clickCreateEventButton();

        Assert.assertTrue(dashboard.isEventPresent(configLoaderDate.getProperty("eventText")));

    }

    private void login() {

        loginActions(email, parola);

        if (login.errorForbiddenAccessText()) {
            login.clickRegisterButton();
//            register.registerUser(true);

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
