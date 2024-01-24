package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class selectProduct {
    WebDriver driver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
    }


    @AfterAll
    public void tearDown(){
        driver.quit();
    }


    @Given("I access the giuliana store")
    public void i_access_the_giuliana_store() {
        driver.get("https://www.giulianaflores.com.br/");
    }
    @When("I click on the product category")
    public void i_click_on_the_product_category() {
        driver.findElement(By.xpath("//h3[@class='title-item' and text()='Buquê de 6 Rosas Vermelhas']")).click();
    }
    @Then("I select the product")
    public void i_select_the_product() {
        driver.findElement(By.xpath("//span[@id='ContentSite_lblProductDsName' and @class='jq-product-name'][text()='Buquê de 6 Rosas Vermelhas']")).click();
    }
    @Then("I check the product name {string}")
    public void i_check_the_product_name(String productTitle) {
        assertEquals(productTitle, driver.findElement(By.id("ContentSite_lblProductDsName")).getText());
    }
    @Then("I check the product price {string}")
    public void i_check_the_product_price(String productPrice) {
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_prod")).getText(), productPrice);
    }
    @Then("I click on add to cart")
    public void i_click_on_add_to_cart() {
        driver.findElement(By.id("ContentSite_divBtBuy")).click();
    }
    @Then("I fill in the field with the postcode for delivery")
    public void i_fill_in_the_field_with_the_postcode_for_delivery() {
        driver.findElement(By.id("ContentSite_uwcCalendar_txtZip")).sendKeys("14807204");
    }
    @When("I click on the ok button to select the postcode")
    public void i_click_on_the_ok_button_to_select_the_postcode() {
        driver.findElement(By.xpath("//span[@class='btn_okcep jSelectZip']")).click();
    }
    @Then("I select the delivery period")
    public void i_select_the_delivery_period() {
        driver.findElement(By.id("btConfirmShippingData")).click();
    }
    @Then("I click on add to cart after to select the postcode")
    public void i_click_on_add_to_cart_after_to_select_the_postcode() {
        driver.findElement(By.cssSelector("div.bt_comprar")).click();
    }
    @Then("I validate the page title in cart")
    public void i_validate_the_page_title_in_cart(String pageTitle) {
        assertEquals(driver.findElement(By.cssSelector("h1.titulo-dept.title-defaut-interna")).getText(), pageTitle);
    }
    @Then("I validate the product title {string} in cart")
    public void i_validate_the_product_title_in_cart(String productTitleCart) {
        assertEquals(driver.findElement(By.cssSelector("span.prodBasket_nome")).getText(), productTitleCart);
    }
    @Then("I validate the price of the product {string} in cart")
    public void i_validate_the_price_of_the_product_in_cart(String productPriceCart) {
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_basket")).getText(), productPriceCart);
    }



}
