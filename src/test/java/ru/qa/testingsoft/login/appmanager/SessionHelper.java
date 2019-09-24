package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SessionHelper extends HelperBase {
  Actions builder = new Actions(wd);

  public SessionHelper (WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(By.id("ap_email"), username);
    type(By.id("ap_password"), password);
    click(By.id("signInSubmit"));
  }

  public void checkLogin () {
      if(isElementPresent(By.id("nav-link-accountList"))
              && wd.findElement(By.cssSelector("#nav-link-accountList > span:nth-child(1)")).getText().equals("Hello, gojeckdemo")) {
        return;
      }
    click(By.id("signInSubmit"));
    }

  public void logout()   {
      isElementPresent(By.id("nav-cart"));
      builder.moveToElement(wd.findElement(By.id("nav-link-accountList")))
              .click(wd.findElement(By.id("nav-item-signout")));
      Action mouseoverAndClick = builder.build();
      mouseoverAndClick.perform();
  }

  public void checkLogOut () {
    isElementPresent(By.id("ap_email"));
  }
}

