package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdd2Produtos {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }


    @AfterEach
    public void tearDown(){
      driver.quit();
   }


    @Test
    public void TestAdd2Produtos() throws InterruptedException {

        driver.get("https://www.giulianaflores.com.br/");

        String selecionaCategoria = "a[href*=\"buque-de-rosas\"] > img[alt*=\"Buquê de Rosa\"]";


         // Acessa a categoria Buque de Rosas
        //driver.findElement(By.cssSelector("a[href*=\"buque-de-rosas\"] > img[alt*=\"Buquê de Rosa\"]\n")).click();
        driver.findElement(By.cssSelector(selecionaCategoria)).click();

        Thread.sleep(10000);
        // Clica no produto Buque de 6 Rosas Vermelhas
        driver.findElement(By.xpath("//h3[@class='title-item' and text()='Buquê de 6 Rosas Vermelhas']")).click();

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

        Thread.sleep(3000);
        // Seleciona o periodo para entrega
        driver.findElement(By.id("btConfirmShippingData")).click();

        // Clica em add ao carrinho após preencher as informações para entrega
        driver.findElement(By.id("ContentSite_lbtBuy")).click();

        Thread.sleep(3000);
        // Valida o título da página Meu Carrinho
        assertEquals(driver.findElement(By.cssSelector("h1.titulo-dept.title-defaut-interna")).getText(), "MEU CARRINHO");

        // Clica comprar mais para este destinatario
        driver.findElement(By.className("jThisBasket")).click();

        // CLica em Mesma Data
        driver.findElement(By.cssSelector("a#ContentSite_Basketcontrol1_rptBasket_ibtBuy_0")).click();
        Thread.sleep(2000);

        // Clica no menu Aniversario
        driver.findElement(By.linkText("Aniversário")).click();
        //Thread.sleep(2000);

        // Clica no presente Cesta Sonhos dos Chocolatras
        driver.findElement(By.xpath("//img[@alt='Cesta Sonho dos Chocólatras']")).click();

        // Valida nome do Produto
        assertEquals("CESTA SONHO DOS CHOCÓLATRAS", driver.findElement(By.id("ContentSite_lblProductDsName")).getText());

        // Valida preço do Produto
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_prod")).getText(), "R$ 149,90");

        // Clica Add no carrinho
        driver.findElement(By.id("ContentSite_lbtBuy")).click();

        Thread.sleep(3000);
        // Seleciona o prazo para entrega
        driver.findElement(By.id("btConfirmShippingData")).click();

        Thread.sleep(5000);
        // Clica em Add o carrinho
        driver.findElement(By.id("ContentSite_divBtBuy")).click();

        // Valida o do nome do produto Buque
        assertEquals(driver.findElement(By.cssSelector("span.prodBasket_nome")).getText(), "Buquê de 6 Rosas Vermelhas");

        // Valida o preço do produto Buque
        assertEquals(driver.findElement(By.cssSelector("span.precoPor_basket")).getText(), "R$ 109,90");

        Thread.sleep(3000);
        // Valida o nome do produto cesta de chocolate
        assertEquals("Cesta Sonho dos Chocólatras", driver.findElement(By.xpath("//a[contains(text(), 'Cesta Sonho dos Chocólatras')]")).getText());

        Thread.sleep(3000);
        // Valida o preço do produto cesta
        assertEquals(driver.findElement(By.xpath("//span[@class='precoPor_basket' and contains(text(), 'R$ 149,90')]")).getText(), "R$ 149,90");
    }
}
