import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class InstockTests {
    private final String DEFAULT_PRODUCT_LABEL = "label";
    private final int DEFAULT_PRODUCT_QUANTITY = 200;
    private final double DEFAULT_PRODUCT_PRICE = 3.5;

    private Product product;
    private Instock stock;

    @Before
    public void init() {
        this.product = new Product(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        this.stock = new Instock();
    }

    @Test
    public void shouldAddProduct() {
        stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldHaveNonZeroCountAfterAdd() {
        stock.add(product);
        Assert.assertNotEquals(0, this.stock.getCount());
    }

    @Test
    public void shouldHaveCountEqualsToProductAdd() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        Product thirdProduct = new Product("thirdLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(product);
        stock.add(secondProduct);
        stock.add(thirdProduct);
        Assert.assertEquals(3, this.stock.getCount());
    }

    @Test
    public void shouldReturnFalseIfStockIsEmpty() {
        Assert.assertFalse(this.stock.contains(product));
    }

    @Test
    public void shouldReturnFalseIfProductNotContained() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(secondProduct);
        Assert.assertFalse(this.stock.contains(product));
    }

    @Test
    public void shouldReturnTrueIfProductContained() {
        stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldReturnTrueIfProductContainedOnlyNameEqual() {
        stock.add(product);
        Product secondProduct = new Product(DEFAULT_PRODUCT_LABEL, 2.5, 100);
        Assert.assertTrue(this.stock.contains(secondProduct));
    }

    @Test
    public void shouldReturnZeroIfNotProduct() {
        Assert.assertEquals(0, this.stock.getCount());
    }

    @Test
    public void shouldCountEqualsToProductAdd() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(product);
        stock.add(secondProduct);
        Assert.assertEquals(2, this.stock.getCount());
    }

    @Test
    public void shouldReturnCorrectOrderByInsertionOrderWithOneProduct() {
        stock.add(product);
        Product actual = stock.find(1);
        Assert.assertEquals(product, actual);
    }

    @Test
    public void shouldReturnCorrectOrderByInsertionOrderWithMultipleProduct() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        Product thirdProduct = new Product("thirdLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(product);
        stock.add(secondProduct);
        stock.add(thirdProduct);
        Product actual = stock.find(3);
        Assert.assertEquals(thirdProduct, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenFindInvalidIndex() {
        this.stock.find(1);
    }

    @Test
    public void shouldAddQuantityToExistingOneProduct() {
        stock.add(product);
        stock.changeQuantity(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_QUANTITY);
        Product actual = stock.findByLabel(DEFAULT_PRODUCT_LABEL);
        Assert.assertEquals(DEFAULT_PRODUCT_QUANTITY * 2, actual.getQuantity());
    }

    @Test
    public void shouldAddQuantityToExistingMultipleProduct() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        Product thirdProduct = new Product("thirdLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(product);
        stock.add(secondProduct);
        stock.add(thirdProduct);
        stock.changeQuantity(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_QUANTITY);
        Product actual = stock.findByLabel(DEFAULT_PRODUCT_LABEL);
        Assert.assertEquals(DEFAULT_PRODUCT_QUANTITY * 2, actual.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddQuantityThrowExceptionWhenProductNameNotExist() {
        stock.changeQuantity(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_QUANTITY);
    }

    @Test
    public void shouldFindLabelToExistingOneProduct() {
        stock.add(product);
        Product actual = stock.findByLabel(DEFAULT_PRODUCT_LABEL);
        Assert.assertEquals(actual, product);
    }

    @Test
    public void shouldFindLabelToExistingMultipleProduct() {
        Product secondProduct = new Product("secondLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        Product thirdProduct = new Product("thirdLabel", DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        stock.add(product);
        stock.add(secondProduct);
        stock.add(thirdProduct);
        Product actual = stock.findByLabel("thirdLabel");
        Assert.assertEquals(actual, thirdProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFindLabelThrowExceptionWhenProductNameNotExist() {
        stock.findByLabel(DEFAULT_PRODUCT_LABEL);
    }

    @Test
    public void shouldReturnFirstNProductsSortedByLabel() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultOrEmptyStockInFindFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultOrNegativeCountStockInFindFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(-1);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForGreaterCountStockInFindFirstByAlphabeticalOrder() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(5);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForInStockInFindFirstByAlphabeticalOrder() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Product[] sorted = {product, second, third};

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(3);

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForEmptyStock() {

        Iterable<Product> actual = this.stock.findAllInRange(5, 15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableIfNonMatchesThePrice() {

        this.stock.add(product);

        Iterable<Product> actual = this.stock.findAllInRange(5, 15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForNegativePrices() {

        this.stock.add(product);

        Iterable<Product> actual = this.stock.findAllInRange(-5, -15);

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResult() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE - 1, DEFAULT_PRODUCT_PRICE + 1);

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResultForHigherBoundEdge() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange(DEFAULT_PRODUCT_PRICE - 1, DEFAULT_PRODUCT_PRICE);

        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldSortCorrectly() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2", 10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3", 20, 10);

        this.stock.add(product);
        this.stock.add(second);
        this.stock.add(third);

        Iterable<Product> actual = this.stock.findAllInRange(0, 30);

        Product[] sorted = {third, second, product};
        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }
}
