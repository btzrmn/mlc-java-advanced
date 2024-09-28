package Exercise.Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database database;

    private static final Integer[] INIT_VALUE = {1, 2, 3};

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(INIT_VALUE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tooManyElementThrowException() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeEmptyDatabaseThrowException() throws OperationNotSupportedException {
        database = new Database(1);
        database.remove();
        database.remove();
    }

    @Test
    public void constructorCheck() throws OperationNotSupportedException {
        Assert.assertNotNull(database);
        Assert.assertEquals(3, database.getElements().length);
    }

    @Test
    public void getElementsCheck(){
        Assert.assertEquals(INIT_VALUE, database.getElements());
    }
}
