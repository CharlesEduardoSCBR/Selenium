package br.alura.selenium.test.leilao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.alura.selenium.test.lance.DetalhesDoLeilaoPage;

public class LeiloesPage {

	private WebDriver driver;
	
	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		this.driver.get("http://localhost:8080/leiloes");
	}

	public NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String nome, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(nome) &&
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usuario) &&
				driver.getPageSource().contains(usado ? "Sim" : "Não");
	}

	public boolean existe(String texto) {
		return driver.getPageSource().contains(texto);
	}

	public DetalhesDoLeilaoPage detalhe(int posicao) {
		List<WebElement> elementos = driver.findElements(By.linkText("exibir"));
		elementos.get(posicao -1).click();
		
		return new DetalhesDoLeilaoPage(driver);
	}
	
	
}
