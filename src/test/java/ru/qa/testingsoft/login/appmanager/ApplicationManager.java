package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;
  private NavigationHelper navigationHelper;
  private RegistrationHelper registrationHelper;
  private SessionHelper sessionHelper;
  private PageHelper pageHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseURL"));
    navigationHelper = new NavigationHelper(wd);
    registrationHelper = new RegistrationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    pageHelper = new PageHelper(wd);
    sessionHelper().login(properties.getProperty("web.userLogin"), properties.getProperty("web.userPassword"));
  }

  public void stop() {
    wd.quit();
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public RegistrationHelper registrationHelper() {
    return registrationHelper;
  }

  public SessionHelper sessionHelper() { return  sessionHelper; }

  public PageHelper pageHelper() { return pageHelper; }

  public byte[] takeScreenshot () {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }

}
