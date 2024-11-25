package cartProducts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class removeCartProduct {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public void launchHomepage() {
        //Section: Launches Homepage & verifies it loaded correctly
        driver.get("https://automationexercise.com/");
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Consent']")));
            consentButton.click();
        } catch (Exception e) {
            System.out.println("consent button not displayed");
        }

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");
    }

    @Test(priority = 1)
    public void addToCart() {
        //clicks on a product
        driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[27]/div[1]/div[1]/div[1]/a[1]")).click();
        // clicks on continue shopping
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"))).click();
        //clicks on another product
        driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[28]/div/div[1]/div[1]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"))).click();
        // verifies current Url
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart");


    }

    @Test(priority = 2)
    public void removeFromCart() {
        // Fetch initial cart quantity
        List<WebElement> cartItems = driver.findElements(By.className("cart_description"));
        int initialCartSize = cartItems.size();
        System.out.println("the initial cart size is " + initialCartSize);

        // removes first product
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[@id='product-33']/td[6]/a[1]"))).click();
        //waits for the removed product to disappear
        wait.until(ExpectedConditions.stalenessOf(cartItems.get(0)));
        // fetch updated cart quantity
        List<WebElement> updatedCrtItems = driver.findElements(By.className("cart_description"));
        int updatedCartSize = updatedCrtItems.size();
        System.out.println("the updated cart size is " + updatedCartSize);

        // verifies the cart size decreased by 1
        Assert.assertEquals(updatedCartSize, initialCartSize - 1);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
