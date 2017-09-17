package br.alura.selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(BlockJUnit4ClassRunner.class)
public class UsuariosSystemTest {

	static String nomeUsuario = "Adriano Xavier";
	static String emailUsuario = "axavier@emresa.com.br";
	private WebDriver driver;
	private static ChromeDriverService service;
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
	public void initDriver(){
		this.driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		this.usuario = new UsuarioPage(driver);
	}
	
	@After
	public void endDriver(){
		driver.quit();
	}
	/*
	@Test
	public void deveAdicionarUmUsuario() {
		usuario.visita();
		usuario.novo()
			   .cadastra(nomeUsuario, emailUsuario);
		
		assertTrue(usuario.existenaListagem(nomeUsuario, emailUsuario));
		
		usuario.deletaUsuarioNaPosicao(1);
	}
	
	@Test
	public void deveAdicionarUmUsuarioSemNome() {		
		String userEmpty = "";

		usuario.visita();
		usuario.novo()
			   .cadastra(userEmpty, emailUsuario);
		
		assertTrue(usuario.existenaListagem(userEmpty));
	}

	@Test
	public void deveAdicionarUmUsuarioSemNomeEEmail() {
		String empty = "";
		
		usuario.visita();
		usuario.novo()
			   .cadastra(empty, empty);
		
		boolean erroNome = usuario.existenaListagem("Nome obrigatorio!");
		boolean erroEmail =  usuario.existenaListagem("E-mail obrigatorio!");
		
		assertTrue(erroNome && erroEmail);
	}

	@Test
	public void verificalinkNovoUsuario() {
		usuario.visita();
		boolean isLinkNovoUsuario  = usuario.existenaListagem("Novo Usuário");
		
		assertTrue(isLinkNovoUsuario);
	}

	@Test
	public void deveDeletarUmUsuario(){
		usuario.visita();
		usuario.novo()
			   .cadastra(nomeUsuario, emailUsuario);
		
		usuario.deletaUsuarioNaPosicao(1);
		
		assertFalse(usuario.existenaListagem(nomeUsuario, emailUsuario));
	}
*/
	@Test
	public void deveEditarUsuario(){
		usuario.visita();
		usuario.novo().cadastra("Pedro", "p@p");
		usuario.editarNome("Regina");
		
		boolean existeUsuarioAlterado = usuario.existenaListagem("Regina", "p@p");
		
		assertTrue(existeUsuarioAlterado);
		
	}
}
