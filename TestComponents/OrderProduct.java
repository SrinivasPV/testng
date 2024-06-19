package TestComponents;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
import PageObjects.ProductPage;

public class OrderProduct extends BaseClass {

	@Test
	public void TestCase001() throws InterruptedException
	{
		ProductPage p = l.enterCredentials("8248607808","Santyvas@1203");
		p.searchProduct();
		p.scrollWindow(0, 2000);
		CheckOutPage c = p.addProductToCart();
		//Thread.sleep(3000);
		p.scrollWindow(0, -2000);
		c.checkOut();
		c.productCheck("Saiga Parts TankTie for Jawa 42 (Matte Black)");
		c.quantityCheck("1");
	}
}
