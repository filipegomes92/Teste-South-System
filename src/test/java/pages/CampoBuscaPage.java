package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class CampoBuscaPage extends Utils {


    WebDriver driver;
    String lupa = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[3]/div[2]/div/div/a/span[2]";
    String inputbusca = "search-field";
    public CampoBuscaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessaraplicacao(){
        driver.get("https://blogdoagi.com.br/");
        esperarElementoEstarPresente(By.xpath(lupa),30);

    }

    public void buscarexpressao(String expressao){
        driver.findElement(By.xpath(lupa)).click();
        driver.findElement(By.id(inputbusca)).clear();
        driver.findElement(By.id(inputbusca)).sendKeys(expressao);
        driver.findElement(By.id(inputbusca)).submit();
    }

    public void validabuscacomsucesso(){
        esperarElementoEstarPresente(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/article/div/div[2]"),10);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/article/div/div[2]")).isEnabled();
    }

    public void validabuscasemresultado(String mensagem){
        String mensagemsemresultado = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/p")).getText();
        Assert.assertEquals(mensagemsemresultado,mensagem);
    }
}
