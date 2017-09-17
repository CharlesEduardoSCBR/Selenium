package br.alura.selenium.test.leilao;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.alura.selenium.test.UsuarioPage;

public class LeiloesSystemTest {

	private WebDriver driver;
	private static ChromeDriverService service;
	private LeiloesPage leiloes;
	private UsuarioPage usuario;
	
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
		
		this.usuario = new UsuarioPage(driver);
		this.usuario.visita();
		this.usuario.novo()
			   		.cadastra("P", "p@com.br");
		
		leiloes = new LeiloesPage(driver);
	}

	@After
	public void endDriver() {
		driver.quit();
	}

	@Test
	public void deveCadastrarUmLeilao() {
		leiloes.visita();
		
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123.00, "P", true);
		
		assertTrue(leiloes.existe("Geladeira", 123.00, "P", true));
		
	}

}
