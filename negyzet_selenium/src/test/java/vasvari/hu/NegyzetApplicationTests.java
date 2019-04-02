package vasvari.hu;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NegyzetApplicationTests {

	
	private WebDriver driver;
	
	// minden egyes teszt indítása előtt:
	// WebDriver inicializáció: elindítja a Firefox-ot:
	@Before
	public void initWebDriver() {
	    driver = new FirefoxDriver();
	    // minden elemre vár max 2 mp-et:
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	// minden teszt lefutása után:
	@After
	public void quitWebDriver() {
	    // bezárja a böngészőablakot 
	    driver.quit();
	}

	@Test
	public void negyzetTeruletSzamitasTesztCimoldal() throws InterruptedException {
		// Lépés:
	    driver.get("http://localhost:8080/index.html");
	    // Ellenőrzés:
	    assertThat(driver.getTitle()).isEqualTo("Négyzet területszámító weboldal");		 
	}
	
	@Test
	public void negyzetTeruletSzamitasTesztSzamVanSzamolGomb() throws InterruptedException {
		//https://www.guru99.com/accessing-forms-in-webdriver.html
	    driver.get("http://localhost:8080/index.html");
	    WebElement szamolGomb=driver.findElement(By.name("szamol")); 
	    assertThat(szamolGomb.getAttribute("value")).isEqualTo("Számol");	    		 
	}
	
	@Test
	public void negyzetTeruletSzamitasTesztSzamVanOldalTextField() throws InterruptedException {
	    driver.get("http://localhost:8080/index.html");
	    WebElement negyzetOldalTextField=driver.findElement(By.name("oldal")); 	    
	    assertThat(negyzetOldalTextField.getAttribute("name")).isEqualTo("oldal");
	    
	}
	
	@Test
	public void negyzetTeruletSzamitasTesztJoSzamBeirasTextFildEsJoOldalraMegy() throws InterruptedException {
	    driver.get("http://localhost:8080/index.html");
	    WebElement negyzetOldalTextField=driver.findElement(By.name("oldal")); 	    
	    negyzetOldalTextField.sendKeys("4");
	    Thread.sleep(1000);
	    WebElement szamolGomb=driver.findElement(By.name("szamol")); 
	    szamolGomb.click();
	    Thread.sleep(1000);
	    assertThat(driver.getTitle()).isEqualTo("Eredmény");		 	    	    
	}
	
	@Test
	public void negyzetTeruletSzamitasTesztRosszSzamBeirasTextFildEsHibaoldalraMegy() throws InterruptedException {
	    driver.get("http://localhost:8080/index.html");
	    WebElement negyzetOldalTextField=driver.findElement(By.name("oldal")); 	    
	    negyzetOldalTextField.sendKeys("-4");
	    Thread.sleep(1000);
	    WebElement szamolGomb=driver.findElement(By.name("szamol")); 
	    szamolGomb.click();
	    Thread.sleep(1000);
	    assertThat(driver.getTitle()).isEqualTo("Hibaüzenet!");		 	    	    
	}

	@Test
	public void negyzetTeruletSzamitasTesztEredmenyTeszteles() throws InterruptedException {
	    driver.get("http://localhost:8080/index.html");
	    WebElement negyzetOldalTextField=driver.findElement(By.name("oldal")); 	    
	    negyzetOldalTextField.sendKeys("4");
	    Thread.sleep(1000);
	    WebElement szamolGomb=driver.findElement(By.name("szamol")); 
	    szamolGomb.click();
	    Thread.sleep(1000);
	    WebElement eredmeny=driver.findElement(By.id("eredmeny"));
	    System.out.println(eredmeny.getText());
	    assertThat(eredmeny.getText()).isEqualTo("A négyzet területe: 16");
	}

}

