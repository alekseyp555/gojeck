package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

  @Test
  public void testLogIn() {
    app.sessionHelper().checkLogin();
  }

  @Test
  public void testLogOut()   {
    app.sessionHelper().logout();
    app.sessionHelper().checkLogOut();
  }
}
