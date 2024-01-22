package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdicionarProduto {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testAdicionarProduto() throws InterruptedException {

        driver.get("https://www.giulianaflores.com.br/");


        // Acessa a categoria Buque de Rosas
        driver.findElement(By.xpath("//h3[@class='title-item' and text()='Buquê de 6 Rosas Vermelhas']")).click();

        // Clica no produto Buque de 6 Rosas Vermelhas
        driver.findElement(By.xpath("//span[@id='ContentSite_lblProductDsName' and @class='jq-product-name'][text()='Buquê de 6 Rosas Vermelhas']")).click();

        // Valida o nome do produto
        assertEquals("BUQUÊ DE 6 ROSAS VERMELHAS", driver.findElement(By.id("ContentSite_lblProductDsName")).getText());

        // Valida o preço do produto
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_prod")).getText(), "R$ 109,90");

        // Clica em add ao carrinho
        driver.findElement(By.id("ContentSite_divBtBuy")).click();

        // Preenche o campo com o cep para entrega
        driver.findElement(By.id("ContentSite_uwcCalendar_txtZip")).sendKeys("14807204");

        // Clica no botão Ok para buscar o cep
        driver.findElement(By.xpath("//span[@class='btn_okcep jSelectZip']")).click();

        // Seleciona o periodo para entrega
        driver.findElement(By.id("btConfirmShippingData")).click();

        // Clica em add ao carrinho após preencher as informações para entrega
        driver.findElement(By.cssSelector("div.bt_comprar")).click();

        // Valida o título da página Meu Carrinho
        assertEquals(driver.findElement(By.cssSelector("h1.titulo-dept.title-defaut-interna")).getText(), "MEU CARRINHO");

        // Valida o texto do nome do produto
        assertEquals(driver.findElement(By.cssSelector("span.prodBasket_nome")).getText(), "Buquê de 6 Rosas Vermelhas");

        // Valida o preço do produto
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_basket")).getText(), "R$ 109,90");

    }
}
