package br.alura.selenium.test;

import org.openqa.selenium.WebDriver;

import br.alura.selenium.test.leilao.LeiloesPage;

public class CriadorDeCenarios {

	WebDriver driver;
	
	public CriadorDeCenarios(WebDriver driver) {
		this.driver = driver;
	}
	
	public CriadorDeCenarios umUsuario(String usuario, String email) {
		UsuarioPage usuarios = new UsuarioPage(this.driver);
        usuarios.visita();
        usuarios.novo().cadastra(usuario, email);
        
        return this;
	}

	public CriadorDeCenarios umLeilao(String produto, double valor, String usuario, boolean usado) {
		LeiloesPage leiloes = new LeiloesPage(this.driver);
		leiloes.visita();
		leiloes.novo().preenche(produto, valor, usuario, usado);

		return this;
	}
}
