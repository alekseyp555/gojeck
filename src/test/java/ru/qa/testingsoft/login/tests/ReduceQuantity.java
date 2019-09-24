package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class ReduceQuantity extends TestBase {

  @Test()
  public void testReduceQuantity () {
    app.goTo().cart();
    app.pageHelper().reduceQuantity();
    app.pageHelper().proceedCheckout();
  }
}
