package br.alura.selenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {
	
	static String nomeUsuario = "Ronaldo Luiz de Albuquerque";
	static String emailUsuario = "ronaldo2009@terra.com.br";

	@Test
	public void deveAdicionarUmUsuario() {
		System.setProperty("webdriver.chrome.driver","C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		nome.sendKeys(nomeUsuario);
		email.sendKeys(emailUsuario);
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean achouNome = driver.getPageSource().contains(nomeUsuario);
		boolean achouEmail = driver.getPageSource().contains(emailUsuario);
		
		assertTrue(achouNome);
		assertTrue(achouEmail);
		
		driver.close();
		
	}
	

}
