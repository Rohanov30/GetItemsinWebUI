package food_del;

import java.io.File;
import org.testng.Assert;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {

	 WebDriver driver;
	 
	
	public void evokeBrowser() {
driver= new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
	}
	
	public void openURL(String url) {
		driver.get(url);
	}
	
	public void ClickMenu()  {
		WebElement Menu=driver.findElement(By.xpath("//a[text()='Menu']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Menu']")));
		Menu.click();
		
	}
	public void getItems() throws IOException {
		FileWriter wf = new FileWriter("items.txt");
	
		List<WebElement> elements = driver.findElements(By.className("styles_label__3Sj9r"));

        // Print the number of elements found
        System.out.println("Number of elements found: " + elements.size());

        // Iterate through the list of elements and print their text
        for (WebElement element : elements) {
        	try {
        		wf.write(element.getText()+"\n");
        		
        	} catch (IOException e) {
        		//e.printStackTrace();
        	}
            System.out.println("Element text: " + element.getText());
          
        	
        }
        wf.close();
	}
	public void checkpageTitle() {
		String title=driver.findElement(By.xpath("//*[text()=\"Taco Bell® Menu\"]")).getText();
		Assert.assertEquals(title,"TACO BELL® MENU");
	}
	public void checkDisplay() {
		WebElement AgreeBtn=driver.findElement(By.xpath("//*[text()='AGREE']"));
		boolean btnTxt=AgreeBtn.isDisplayed();
		Assert.assertTrue(btnTxt);
		AgreeBtn.click();
		
	}
	
	@SuppressWarnings("deprecation")
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	}
	
}
