package Exercise.IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;

    private static final String[] VALUES = {"one", "two", "three"};
    private static final String PRINT_CORRECT = "one";

    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator(VALUES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorNullThrowException() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void moveReturnTrue() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void moveReturnFalse() throws OperationNotSupportedException {
        listIterator = new ListIterator("one");
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextReturnTrue() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void printValid() {
        Assert.assertEquals(listIterator.print(), PRINT_CORRECT);
    }

    @Test(expected = IllegalStateException.class)
    public void printThrowException() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
}
