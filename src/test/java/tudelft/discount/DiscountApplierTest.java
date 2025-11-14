package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest {
    @Test
    public void noChange(){
        ProductDao productDao = Mockito.mock(ProductDao.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 100, "Other1"));
        products.add(new Product("Product2", 200, "Other2"));
        products.add(new Product("Product3", 300, "Other3"));
        Mockito.when(productDao.all()).thenReturn(products);
        DiscountApplier discountApplier = new DiscountApplier(productDao);

        discountApplier.setNewPrices();
        Assertions.assertEquals(100, productDao.all().get(0).getPrice());
        Assertions.assertEquals(200, productDao.all().get(1).getPrice());
        Assertions.assertEquals(300, productDao.all().get(2).getPrice());
    }
    @Test
    public void onlyHome(){
        ProductDao productDao = Mockito.mock(ProductDao.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 100, "HOME"));
        products.add(new Product("Product2", 200, "Other1"));
        products.add(new Product("Product3", 300, "Other"));
        products.add(new Product("Product3", 900, "HOME"));
        Mockito.when(productDao.all()).thenReturn(products);
        DiscountApplier discountApplier = new DiscountApplier(productDao);

        discountApplier.setNewPrices();
        Assertions.assertEquals(90, productDao.all().get(0).getPrice());
        Assertions.assertEquals(200, productDao.all().get(1).getPrice());
        Assertions.assertEquals(300, productDao.all().get(2).getPrice());
        Assertions.assertEquals(810, productDao.all().get(3).getPrice());
    }
    @Test
    public void onlyBusiness(){
        ProductDao productDao = Mockito.mock(ProductDao.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 100, "BUSINESS"));
        products.add(new Product("Product2", 200, "Other1"));
        products.add(new Product("Product3", 300, "BUSINESS"));
        products.add(new Product("Product3", 900, "Other2"));
        Mockito.when(productDao.all()).thenReturn(products);
        DiscountApplier discountApplier = new DiscountApplier(productDao);

        discountApplier.setNewPrices();
        Assertions.assertEquals(110, productDao.all().get(0).getPrice());
        Assertions.assertEquals(200, productDao.all().get(1).getPrice());
        Assertions.assertEquals(330, productDao.all().get(2).getPrice());
        Assertions.assertEquals(900, productDao.all().get(3).getPrice());
    }
    @Test
    public void allCatergories(){
        ProductDao productDao = Mockito.mock(ProductDao.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 1, "HOME"));
        products.add(new Product("Product2", 1, "BUSINESS"));
        products.add(new Product("Product3", 1, "Other"));
        Mockito.when(productDao.all()).thenReturn(products);
        DiscountApplier discountApplier = new DiscountApplier(productDao);

        discountApplier.setNewPrices();
        Assertions.assertEquals(0.9, productDao.all().get(0).getPrice());
        Assertions.assertEquals(1.1, productDao.all().get(1).getPrice());
        Assertions.assertEquals(1, productDao.all().get(2).getPrice());
    }
}
