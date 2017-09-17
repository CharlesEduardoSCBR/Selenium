package br.alura.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.alura.selenium.test.UsuarioPage;

public class AlteraUsuarioPage {

	WebDriver driver;
	
	public AlteraUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public UsuarioPage para(String nome, String email) {
        WebElement txtNome = driver.findElement(By.name("usuario.nome"));
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

            txtNome.clear();
            txtEmail.clear();

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);

        txtNome.submit();
        return new UsuarioPage(driver);
    }
}
