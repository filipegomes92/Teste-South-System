package steps;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.JavascriptExecutor;
import pages.CampoBuscaPage;
import runner.RunCucumberTest;

public class CampoBuscaStep  extends RunCucumberTest {

    CampoBuscaPage campobuscapage = new CampoBuscaPage(driver);

    @Dado("^que estou na home do AGI$")
    public void que_estou_na_home_do_AGI() {
        campobuscapage.acessaraplicacao();

    }

    @Quando("^eu busco por uma expressao valida$")
    public void eu_busco_por_uma_expressao_valida()  {
        campobuscapage.buscarexpressao("Bitcoin");
    }

    @Entao("^vejo os resultados da minha busca$")
    public void vejo_os_resultados_da_minha_busca()  {
        campobuscapage.validabuscacomsucesso();
    }
    @Quando("^eu busco por uma expressao invalida$")
    public void eu_busco_por_uma_expressao_invalida()  {
       campobuscapage.buscarexpressao("Betcoin");
    }

    @Entao("^vejo mensagem que nada foi encontrado$")
    public void vejo_mensagem_que_nada_foi_encontrado()  {
        campobuscapage.validabuscasemresultado("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.");
    }

}
