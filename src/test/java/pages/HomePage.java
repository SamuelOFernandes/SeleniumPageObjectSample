package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement barraDePesquisa = driver.findElement(By.id("twotabsearchtextbox"));

    WebElement carrinhoDeCompras = driver.findElement(By.id("nav-cart-count"));

//    WebElement textoProdutoAdicionadoAoCarrinho = driver.findElement(By.linkText("Adicionado ao carrinho"));

    public HomePage buscarRefrigerador() {

        barraDePesquisa.click();
        barraDePesquisa.sendKeys("Refrigerador Electrolux");
        barraDePesquisa.sendKeys(Keys.ENTER);

        return this;
    }

    public HomePage buscarProdutos(String produtos) {

        barraDePesquisa.click();
        barraDePesquisa.sendKeys(produtos);
        barraDePesquisa.sendKeys(Keys.ENTER);

        return this;
    }


    public RefrigeradorPage acessarDetalhesDoRefrigerador() {

        driver.findElement(By.linkText("Refrigerador Electrolux IB53X Frost Free Bottom Freezer Inverter Inox 454 Litros - 220V"))
                .click();

        return new RefrigeradorPage(driver);

    }

    public CarrinhoDeComprasPage acessarCarrinhoDeCompras() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver, 3);

        espera.until(ExpectedConditions.elementToBeClickable(carrinhoDeCompras));
        carrinhoDeCompras.click();

        return new CarrinhoDeComprasPage(driver);
    }

    public String validarBuscaDeProduto() {

        String mensagemSucessoDeBusca =
                driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]"))
                        .getText();

        String produtoNoResultadoDeBusca = mensagemSucessoDeBusca.replaceAll("^\"+|\"+$", "");

        return produtoNoResultadoDeBusca;
    }

}
