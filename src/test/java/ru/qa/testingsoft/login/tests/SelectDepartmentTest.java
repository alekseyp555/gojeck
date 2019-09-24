package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class SelectDepartmentTest extends TestBase {

  @Test ()
  public void testSelectDepartment () {
    app.goTo().categoryHeaphone();
    app.pageHelper().addToCart();
    app.pageHelper().checkAddToCartOne();
  }
}
