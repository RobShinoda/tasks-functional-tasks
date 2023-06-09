package br.ce.shinoda.tasks.functional;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	//@Test
	//public void testAmbiente() {
		//WebDriver driver = new ChromeDriver();
		//driver.navigate().to("http://www.google.com");
	//}
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
		public void deveSalvarTarefaComSucesso() {
		   WebDriver driver = acessarAplicacao();
		   try {
		   
			// clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			// escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			// escrever a data
			driver.findElement(By.id("duedate")).sendKeys("23/03/2030");
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			//String message = driver.findElement(By.id("message")).getText();
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		   } finally {
			
			// fechar o browser
			 driver.quit();
	
		     }
		}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
	   WebDriver driver = acessarAplicacao();
	   try {
	   
		// clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		// escrever descrição
		//driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// escrever a data
		driver.findElement(By.id("duedate")).sendKeys("23/03/2030");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		//String message = driver.findElement(By.id("message")).getText();
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
	   } finally {
		
		// fechar o browser
		 driver.quit();

	     }
	   
	}
	
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
	   WebDriver driver = acessarAplicacao();
	   try {
	   
		// clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		// escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// escrever a data
		//driver.findElement(By.id("duedate")).sendKeys("23/03/2030");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		//String message = driver.findElement(By.id("message")).getText();
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
	   } finally {
		
		// fechar o browser
		 driver.quit();

	     }
	   
	}
	
	
	@Test
	public void naoDeveSalvarTarefacomDataPassada() {
	   WebDriver driver = acessarAplicacao();
	   try {
	   
		// clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		// escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// escrever a data
		driver.findElement(By.id("duedate")).sendKeys("23/03/2000");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		//String message = driver.findElement(By.id("message")).getText();
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
	   } finally {
		
		// fechar o browser
		 driver.quit();

	     }
	   
	}
	
}

