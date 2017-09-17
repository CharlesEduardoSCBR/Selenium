package br.alura.selenium.test.lance;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.alura.selenium.test.UsuarioPage;
import br.alura.selenium.test.leilao.LeiloesPage;

public class LanceSystemTest {

	private WebDriver driver;
	private static ChromeDriverService service;
	private LeiloesPage leiloes;
	
	@BeforeClass
	public static void init() throws Exception {
		service = new ChromeDriverService
						.Builder()
						.usingDriverExecutable(new File("C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe"))
						.usingAnyFreePort()
						.build();
		service.start();
	}

	@AfterClass
	public static void endTest() throws InterruptedException {
		service.stop();
	}

	@Before
	public void initDriver() {
		this.driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		this.driver.get("http://localhost:8080/apenas-teste/limpa");
		
		UsuarioPage usuarios = new UsuarioPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
        usuarios.novo().cadastra("José Alberto", "jose@alberto.com");

        leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
	}
	
	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances = leiloes.detalhe(1);
		lances.lance("José Alberto", 150.00);
		
		assertTrue(lances.existeLance("José Alberto", 150.00));
		
	}
}
