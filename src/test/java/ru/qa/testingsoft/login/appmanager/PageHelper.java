package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class PageHelper extends HelperBase {

  public PageHelper(WebDriver wd) {
    super(wd);
  }

  public void inputSearchRequest(String product) {
    type(By.name("field-keywords"), product); //type Macbook pro
  }

  public void clickSearchButton () {
    click(By.xpath("//input[@value='Go']")); //click search
  }

  public void selectSecondProduct () {
    click(By.xpath("//div[5]/div/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span")); //select second product
  }

  public void selectQuantity ()   {
    click(By.className("a-dropdown-container")); //select quantity dropdown
    try {
      sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    click(By.id("quantity_1")); //select quantity 2
  }

  public void reduceQuantity() {
    click(By.className("a-dropdown-container")); //select quantity dropdown
    click(By.id("dropdown2_0")); //select quantity 2
  }

  public void addToCart() {
    click(By.id("add-to-cart-button")); //add to cart
    if (isElementPresent(By.id("a-autoid-13"))) {
      click(By.id("a-autoid-13")); //click continue
    }
  }

  public void checkAddToCartOne () {
    assertEquals("Cart subtotal (1 item):", wd.findElement(By.cssSelector("#hlb-subcart > div:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).getText());
  }

  public void checkAddToCartTwo () {
    assertEquals("Cart subtotal (2 items):", wd.findElement(By.cssSelector("#hlb-subcart > div:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).getText());
  }

  public void SelectOptions(String value)
  {
    click(By.xpath("//input[@value='"+value+"']"));
  }

  public void checkRemoveProduct() {
    assertEquals("Subtotal (1 item):", wd.findElement(By.id("sc-subtotal-label-activecart")).getText());
  }

  public void removeProductFromCart() {
    click(By.xpath("//descendant::input[@value='Delete'][2]")); //click delete second product
  }

  public void proceedCheckout () {
    if (isElementPresent(By.className("a-spacing-base"))
            && wd.findElement(By.tagName("h1")).getText().equals("Select a shipping address")
            && isElementPresent(By.name("shipToThisAddress"))) {
      return;
    }
    click(By.id("sc-buy-box-ptc-button"));
  }
}
