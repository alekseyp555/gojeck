package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class NavigationHelper extends  HelperBase{
  Actions builder = new Actions(wd);

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void RegisterPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.cssSelector(".maintitle")).getText().equals("Готовы зарегистрироваться?")
            && isElementPresent(By.id("display_name"))) {
      return;
    }
    click(By.cssSelector("#register_link"));
  }

  public void categoryHeaphone() {
    builder.moveToElement(wd.findElement(By.id("nav-link-shopall")))
            .click(wd.findElement(By.cssSelector("#nav-flyout-shopAll > div:nth-child(2) > a:nth-child(11) > span:nth-child(1)")));
    Action mouseoverAndClick = builder.build();
    mouseoverAndClick.perform();
    //assertEquals("Electronics", wd.findElement(By.cssSelector(".fst-h1-st > h1:nth-child(1) > b:nth-child(1)")).getText());
    click(By.xpath("//li[7]/span/a/span")); //select Heaphone category
    click(By.xpath("//h2/a/span")); //select first headphone in the category
    isElementPresent(By.id("submit.add-to-cart"));
  }

  public void cart() {
    if (isElementPresent(By.id("sc-active-cart"))
    && isElementPresent(By.tagName("h2"))
    && wd.findElement(By.cssSelector(".sc-cart-header > div:nth-child(1) > h2:nth-child(1)")).getText().equals("Shopping Cart")) {
      return;
    }
    click(By.id("nav-cart")); // go to the cart
  }
}
