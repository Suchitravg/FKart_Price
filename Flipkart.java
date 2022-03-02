package login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		Workbook data = new Workbook();
		ArrayList<String> exceldata = data.getData("Flipkart");
		System.setProperty("webdriver.chrome.driver", "F:\\Suchitra\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).click();
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(exceldata.get(0));
		driver.findElement(By.cssSelector("input[type='password']")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(exceldata.get(1));
		driver.findElement(By.cssSelector("button[class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("lenovo");
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
				.sendKeys(Keys.ENTER);
		driver.navigate().to("https://www.flipkart.com/lenovo-k10-plus-black-64-gb/p/itm1c7ad0d673ca4?pid=MOBFJYBEY2D7QFGF&lid=LSTMOBFJYBEY2D7QFGF925UNV&marketplace=FLIPKART&q=lenovo&store=search.flipkart.com&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=4cd641dd-6641-4804-a119-45fc96341aa1.MOBFJYBEY2D7QFGF.SEARCH&ppt=sp&ppn=sp&ssid=6xts7xtg000000001646194118827&qH=e389a212c2b3beb2");
		List<WebElement> selections = driver.findElements(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
		for (WebElement selection : selections) {
			if (selection.getText().equalsIgnoreCase("₹13,999")) {
				String price = selection.getText();
				System.out.println("Actualamount" + price);
				String a = null;
				for (String cash : price.split("₹")) {
					a = cash.replace(",", ""); 
				}
				String b = new String(a);
				int val = Integer.parseInt(b);
				System.out.println("Amount integer array " + val);
				int add = val + 1000;
				System.out.println("Addded price" + add);
			}

		}driver.close();

	}

}
