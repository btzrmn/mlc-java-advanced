package Exercise.ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database database;
    private static final Person VALID_PERSON = new Person(1,"John");
    private static final Person INVALID_PERSON = new Person(-1,"Bob");

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(VALID_PERSON, new Person(2, "Alice"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorThrowException() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNegativeIdThrowException() throws OperationNotSupportedException {
        database.add(INVALID_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeEmptyDatabaseThrowException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameNullThrowException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMultipleThrowException() throws OperationNotSupportedException {
        database = new Database(VALID_PERSON, VALID_PERSON);
        database.findByUsername(VALID_PERSON.getUsername());
    }

    @Test
    public void findByUsername() throws OperationNotSupportedException {
        Assert.assertEquals(VALID_PERSON, database.findByUsername(VALID_PERSON.getUsername()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdIdsNotExistThrowException() throws OperationNotSupportedException {
        database.findById(3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdIdsDuplicatedIdThrowException() throws OperationNotSupportedException {
        database = new Database(VALID_PERSON, VALID_PERSON);
        database.findById(VALID_PERSON.getId());
    }

}
