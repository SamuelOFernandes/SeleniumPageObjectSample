package tests;

import common.Driver;
import common.Generator;
import common.Screenshot;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoDeComprasPage;
import pages.HomePage;
import pages.RefrigeradorPage;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "listaDeProdutos.csv")


public class AdicionarProdutosAoCarrinhoDeComprasTest {

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setup() {

        driver = Driver.createChrome();
        driver.get("https://www.amazon.com.br/");
        driver.manage().window().maximize();

    }

    @Test
    public void testAdicionarProdutoAoCarrinhoDeComprasSimples() throws InterruptedException {

        //Realizar Busca de Refrigerador Electrolux

        new HomePage(driver).buscarRefrigerador()
                .acessarDetalhesDoRefrigerador();
        String descricaoComVoltagem =
                new RefrigeradorPage(driver).capturaDeTextoDescricaoVoltagem();
        String precoProduto =
                new RefrigeradorPage(driver).capturaDeTextoPreco();
        assertEquals("Refrigerador Electrolux IB53X Frost Free Bottom Freezer Inverter Inox 454 Litros - 220V", descricaoComVoltagem);
        assertEquals("R$3.949,00", precoProduto);
        new RefrigeradorPage(driver).adicionarProdutoNoCarrinhoDeCompras();
        new HomePage(driver).acessarCarrinhoDeCompras();
        String descricaoComVoltagemCarrinhoDeCompras =
                new CarrinhoDeComprasPage(driver).capturarTextoDescricaoVoltagemCarrinhoDeCompras();
        String precoProdutoCarrinhoDeCompras =
                new CarrinhoDeComprasPage(driver).capturaPrecoCarrinhoDeCompras();
        assertEquals(descricaoComVoltagem, descricaoComVoltagemCarrinhoDeCompras);
        assertEquals(precoProduto, precoProdutoCarrinhoDeCompras);


    }


    @Test
    public void testBuscarProdutosDoArquivo(
            @Param(name = "produto") String produto,
            @Param(name = "mensagemEsperada") String mensagemEsperada
    ) {

        String msgSucessoNaBuscaDoProduto = new HomePage(driver).buscarProdutos(produto)
                .validarBuscaDeProduto();

        assertEquals(mensagemEsperada, msgSucessoNaBuscaDoProduto);

        Screenshot.take(driver, "C:\\qa\\TestReport\\" + Generator.dateTimeToFile() + test.getMethodName() + ".doc");


    }

    @After
    public void quitBrowser() {
        driver.quit();

    }


}
