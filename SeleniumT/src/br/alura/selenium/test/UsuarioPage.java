package br.alura.selenium.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsuarioPage {
	
	WebDriver driver;
	
	public UsuarioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita(){
		driver.get("localhost:8080/usuarios");
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}
	
	public void deletaUsuarioNaPosicao(int posicao){
		driver.findElements(By.tagName("button")).get(posicao -1).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean existenaListagem(String nomeUsuario, String emailUsuario) {
		return driver.getPageSource().contains(nomeUsuario) &&
				driver.getPageSource().contains(emailUsuario);
	}

	public boolean existenaListagem(String texto) {
		return driver.getPageSource().contains(texto);
	}

	public void editarNome(String nome) {
		int posicao = 1;
		
		driver.findElements(By.linkText("editar")).get(posicao - 1).click();
		
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		
		txtNome.clear();
		txtNome.sendKeys(nome);
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
	}

}
