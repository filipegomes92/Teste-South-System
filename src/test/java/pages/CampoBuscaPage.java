package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

import java.util.concurrent.TimeUnit;

public class CampoBuscaPage extends Utils {


    WebDriver driver;
    String lupa = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[3]/div[2]/div/div/a/span[2]";
    String inputbusca = "search-field";
    public CampoBuscaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessaraplicacao(){
        driver.get("https://blogdoagi.com.br/");

    }

    public void buscarexpressao(String expressao){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[3]/div[2]/div/div/a/span[2]")).click();
        esperarElementoEstarPresente(By.id("search-field"),30);
        driver.findElement(By.id(inputbusca)).clear();
        driver.findElement(By.id(inputbusca)).sendKeys(expressao);
        driver.findElement(By.id(inputbusca)).submit();
    }

    public void validabuscacomsucesso(){
        esperarElementoEstarPresente(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/article/div/div[2]"),30);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/article/div/div[2]")).isEnabled();
    }

    public void validabuscasemresultado(String mensagem){
        esperarElementoEstarPresente(By.xpath("//*[@id=\"main\"]/section/div/p"),300);
        String mensagemsemresultado = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/p")).getText();
        Assert.assertEquals(mensagemsemresultado,mensagem);
    }
}
