package ebaconline;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chart {
	
	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new FirefoxDriver();
	
	@Test
	public void main() {
		driver.get("http://lojaebac.ebaconline.art.br/produtos/");
		driver.manage().window().maximize();
		
		AddClothesToCart("Atlas Fitness Tank", ".button-variable-item-L", ".button-variable-item-Blue");
		//Go back to Eco Friendly Clothes
		driver.findElement(By.linkText("Eco Friendly|Clothing")).click();
		AddClothesToCart("Argus All-Weather Tank", ".button-variable-item-L", ".button-variable-item-Gray");
		driver.findElement(By.linkText("Ver carrinho")).click();
		CheckCartItems();
		//
	}
	
	//Add clothes to cart by name, size and color
	public void AddClothesToCart(String itemName, String size, String color) {
		driver.findElement(By.linkText(itemName)).click();
		driver.findElement(By.cssSelector(size)).click();
		driver.findElement(By.cssSelector(color)).click();
		driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
	}
	
	//check cart items
	private void CheckCartItems() {
		//Item 1: .cart_item:nth-child(1) > .product-name
		//Item 2: .cart_item:nth-child(2) > .product-name;
		assertTrue("Atlas Fitness Tank - L, Blue", driver.findElement(By.linkText("Atlas Fitness Tank - L, Blue")).isDisplayed());
		assertTrue("Argus All-Weather Tank - L, Gray", driver.findElement(By.linkText("Atlas Fitness Tank - L, Blue")).isDisplayed());
	}
}
