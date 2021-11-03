import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    SearchBox searchBox;
    By cartCountLocator = By.id("item-quantity-input");
    By cartContainerLocator = By.id("header-cart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }


    public boolean isProductCountUp()
    {
     return getCartCount() > 1 ;
    }

    public void goToCart()
    {
        click(cartCountLocator);
    }



    private int getCartCount()
    {
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

}