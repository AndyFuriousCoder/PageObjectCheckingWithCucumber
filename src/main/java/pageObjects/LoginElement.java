package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

//this page object is used for login
public class LoginElement {
    private WebElement userName;
    private WebElement password;
    private WebDriver driver;

    //constructor
    public LoginElement(WebDriver driver)
    {
        //go to <epam> site
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        //open dropdown menu
        driver.findElement(By.cssSelector("li.dropdown.uui-profile-menu > a.dropdown-toggle")).click();
        //authorizing using page object LoginElement
        this.userName = driver.findElement(By.id("Login"));
        this.password = driver.findElement(By.id("Password"));
        this.driver = driver;

    }

    //authorize to account
    public void authorize(String login, String psw)
    {
        userName.clear();
        userName.sendKeys(login);
        password.clear();
        password.sendKeys(psw);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void checkAuthorizing(boolean statement)
    {
        if (statement) {
            WebElement logoutElement = driver.findElement(By.cssSelector(".logout"));
            assertTrue((logoutElement).isEnabled());
            logoutElement.click();
        }
        else {
            assertTrue((driver.findElement(By.xpath("//button[@type='submit']"))).isEnabled());
        }
    }

    public static void toIndex8Page(WebDriver driver)
    {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.findElement(By.cssSelector("li.dropdown.uui-profile-menu > a.dropdown-toggle")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.navigate().to("https://jdi-framework.github.io/tests/page8.htm");
    }

}
