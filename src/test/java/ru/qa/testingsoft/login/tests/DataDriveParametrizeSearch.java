package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class DataDriveParametrizeSearch extends TestBase {

  @Test()
  public void testDataDriveParametrizeSearch () {
    app.pageHelper().inputSearchRequest("iphone"); //inpunt any product name
    app.pageHelper().clickSearchButton();
  }
}
