package ru.qa.testingsoft.login.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.qa.testingsoft.login.appmanager.ApplicationManager;
import java.io.IOException;
import java.lang.reflect.Method;

@Listeners(MyTestListener.class)
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME)); //launch browser

  @BeforeSuite
  public void setUp(ITestContext context) throws IOException {
    app.init();
    context.setAttribute("app", app); //for allure test listener
  }

  @AfterSuite
  public void tearDown()   {
    app.stop();
  }

  @BeforeMethod (alwaysRun = true)
  public void logTestStart (Method m) {
    logger.info ("Start test " + m.getName());
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop (Method m) {
    logger.info ("Stop test " + m.getName());;
  }
}
