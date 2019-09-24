package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class RemoveProductFromCartTest extends TestBase {

  @Test()
  public void testRemoveProductFromCart () {
    app.goTo().cart();
    app.pageHelper().removeProductFromCart();
    app.pageHelper().checkRemoveProduct();
  }
}
