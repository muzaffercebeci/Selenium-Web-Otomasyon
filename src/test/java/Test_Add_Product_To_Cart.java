import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {



    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    //@Disabled("")
    public void search_a_product()
    {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        homePage.searchBox().search("pantolon");

        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Böyle bir sayfa yok!");
    }

    @Test
    @Order(2)
    public void select_a_product()
    {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
      //  Assertions.assertTrue(ProductDetailPage.isOnProductDetailPage(), "Product count did not increase");

    }


    @Test
    @Order(3)
    public void add_product_to_cart()
    {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count did not increase");

    }

    @Test
    @Order(4)
    public void go_to_cart()
    {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was not added to cart");

    }

}
