package br.ce.wcaquinho.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void teste() {
//---não precisa desses dois porque foi colocado no path a pasta onde eles estão ai o PC passa a reconhecer
	//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Raissa Cardoso\\eclipse\\drivers\\geckodriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raissa Cardoso\\eclipse\\drivers\\chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
	//	WebDriver driver = new ChromeDriver();
	//	WebDriver driver = new InternetExplorerDriver(); // no internet expllorer tem que ir em ferramentas -> opções de internet -> segurança -> e debabilitar a opção de "Habilitar modo protegido"
		
//---mudar o local de abrir a tela
	//  driver.manage().window().setPosition(new Point(100, 100));// definir o posicionamento
	//	driver.manage().window().setSize(new Dimension(1200, 1700));// definir o tamanho
		driver.manage().window().maximize(); // maximizado
		
		driver.get("http://www.google.com"); 
	//	System.out.println(driver.getTitle());//titulo da página
		Assert.assertEquals("Google", driver.getTitle()); //faz a comparação 
		
		driver.quit(); //ele fecha todas as abas e mata a instancia. o close só fecha aquela aba
	}

}

