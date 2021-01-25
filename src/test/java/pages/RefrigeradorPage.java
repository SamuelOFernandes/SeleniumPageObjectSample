package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RefrigeradorPage extends BasePage {


    public RefrigeradorPage(WebDriver driver) {
        super(driver);
    }

    WebElement descricaoProduto = driver.findElement(By.id("productTitle"));

    WebElement preco = driver.findElement(By.id("priceblock_ourprice"));



    public String capturaDeTextoDescricaoVoltagem() {
        String descricaoComVoltagem = descricaoProduto.getText();


        return descricaoComVoltagem;
    }

    public String capturaDeTextoPreco() {

        String precoProduto = preco.getText();

        return precoProduto;
    }

    public HomePage adicionarProdutoNoCarrinhoDeCompras() {

        driver.findElement(By.id("add-to-cart-button")).click();

        return new HomePage(driver);
    }


}
