package br.alura.selenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	static String nomeUsuario = "Adriano Xavier";
	static String emailUsuario = "axavier@emresa.com.br";
	private WebDriver driver;
	private WebDriver driverChrome;
	private UsuarioPage usuario;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		this.driverChrome = new ChromeDriver();
		this.usuario = new UsuarioPage(driverChrome);
	}

	@Before
	public void endTest() {
		this.driverChrome.close();
	}

	@Test
	public void deveAdicionarUmUsuario() {
		usuario.visita();
		usuario.novo()
			   .cadastra(nomeUsuario, emailUsuario);
		
		assertTrue(usuario.existenaListagem(nomeUsuario, emailUsuario));
	}
	/*
	@Test
	public void deveAdicionarUmUsuarioSemNome() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		String userEmpty = "";
		driver.get("http://localhost:8080/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys(userEmpty);
		email.sendKeys(emailUsuario);

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		boolean achouErro = driver.getPageSource().contains("Nome obrigatorio!");

		assertTrue(achouErro);
		
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuarioSemNomeEEmail() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		String empty = "";
		driver.get("http://localhost:8080/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys(empty);
		email.sendKeys(empty);

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		boolean achouErroNome = driver.getPageSource().contains("Nome obrigatorio!");
		boolean achouErroEmail = driver.getPageSource().contains("Nome obrigatorio!");

		assertTrue(achouErroNome && achouErroEmail);
		
		driver.close();
	}
	
	@Test
	public void verificalinkNovoUsuario() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://localhost:8080/usuarios");

		WebElement novoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		novoUsuario.click();

		boolean achouNameNome = driver.getPageSource().contains("novo.usuario");

		assertTrue(achouNameNome);
		
		driver.close();
	}
	*/
}
