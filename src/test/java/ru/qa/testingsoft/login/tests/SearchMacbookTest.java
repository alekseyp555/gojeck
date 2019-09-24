package ru.qa.testingsoft.login.tests;

import org.testng.annotations.Test;

public class SearchMacbookTest extends TestBase {

  @Test ()
  public void testSearchMacbook ()   {
    app.pageHelper().inputSearchRequest("Macbook pro");
    app.pageHelper().clickSearchButton();
    app.pageHelper().selectSecondProduct();
    app.pageHelper().selectQuantity();
    app.pageHelper().addToCart();
    app.pageHelper().checkAddToCartTwo();
  }
}
