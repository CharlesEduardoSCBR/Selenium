package br.alura.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {

	WebDriver driver;
	
	public NovoUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário"));
		return new NovoUsuarioPage(driver);
	}

	public void cadastra(String nomeUsuario, String emailUsuario) {
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));

		txtNome.sendKeys(nomeUsuario);
		txtEmail.sendKeys(emailUsuario);

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
	}

	public boolean existenaListagem(String nomeUsuario, String emailUsuario) {
		return driver.getPageSource().contains(nomeUsuario) &&
				driver.getPageSource().contains(emailUsuario);
	}
}
