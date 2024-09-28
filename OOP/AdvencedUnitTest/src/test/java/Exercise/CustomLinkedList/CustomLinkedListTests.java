package Exercise.CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTests {
    private CustomLinkedList<Integer> list;

    @Before
    public void init() {
        list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInvalidIndex() {
        list.get(4);
    }

    @Test
    public void getValid() {
        Assert.assertEquals(1, (int) list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setValidIndex() {
        list.set(4, 1);
    }

    @Test
    public void setValid() {
        list.set(1, 6);
        Assert.assertEquals(6, (int) list.get(1));
    }

    @Test
    public void addValid() {
        list = new CustomLinkedList<>();
        list.add(1);
        Assert.assertEquals(1, (int) list.get(0));
        list.add(2);
        Assert.assertEquals(2, (int) list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtInvalidIndex() {
        list.removeAt(4);
    }

    @Test
    public void removeAtValid() {
        list.removeAt(0);
        Assert.assertNotEquals(1,(int) list.get(0));
    }

    @Test
    public void removeValidNotFound() {
        Assert.assertEquals(-1,list.remove(5));
    }

    @Test
    public void removeValidFound() {
        Assert.assertEquals(1,list.remove(2));
    }

    @Test
    public void indexOfValidNotFound() {
        Assert.assertEquals(-1,list.indexOf(5));
    }

    @Test
    public void indexOfValidFound() {
        Assert.assertEquals(2,list.indexOf(3));
    }

    @Test
    public void containsTrue() {
        Assert.assertTrue(list.contains(2));
    }

    @Test
    public void containsFalse() {
        Assert.assertFalse(list.contains(5));
    }
}
