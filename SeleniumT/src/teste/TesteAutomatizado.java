package teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/charl_000/Documents/Cursos/Alura/Trilhas/00 - Java All/00 - Selenium/00-selenium/chromedriver_win32/chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		
		//System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox");
		//WebDriver drive = new FirefoxDriver();
		
		drive.get("http://www.google.com.br");
		
		WebElement campoDeTexto = drive.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		campoDeTexto.submit();
		drive.close();
	}
	
}
