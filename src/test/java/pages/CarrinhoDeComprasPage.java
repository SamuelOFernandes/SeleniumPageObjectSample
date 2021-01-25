package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoDeComprasPage extends BasePage {
    public CarrinhoDeComprasPage(WebDriver driver) {
        super(driver);
    }

    WebElement descricaoProdutoCarrinhoDeCompras =
            driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
    WebElement precoCarrinhoDeCompras =
            driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));


    public String capturarTextoDescricaoVoltagemCarrinhoDeCompras(){

       String descricao = descricaoProdutoCarrinhoDeCompras.getText();

       return descricao;
    }

    public String capturaPrecoCarrinhoDeCompras(){
        String preco = precoCarrinhoDeCompras.getText();

        return preco;

    }
}
