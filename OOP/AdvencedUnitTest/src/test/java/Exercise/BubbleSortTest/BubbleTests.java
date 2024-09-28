package Exercise.BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTests {

    private static final int[] VALID_RESULT = {1,2,3,4,5,6};

    private static final int[] RANDOM_LIST = {2,5,3,1,6,4};
    private static final int[] VALID_LIST = {1,2,3,4,5,6};
    private static final int[] REVERSE_LIST = {6,5,4,3,2,1};
    private static final int[] EMPTY_LIST = {};

    @Test
    public void randomList() {
        int[] list  = RANDOM_LIST;
        Bubble.sort(list);
        Assert.assertArrayEquals(VALID_RESULT , list);
    }

    @Test
    public void validList() {
        int[] list  = VALID_LIST;
        Bubble.sort(list);
        Assert.assertArrayEquals(VALID_RESULT , list);
    }

    @Test
    public void reverseList() {
        int[] list  = REVERSE_LIST;
        Bubble.sort(list);
        Assert.assertArrayEquals(VALID_RESULT , list);
    }

    @Test
    public void emptyList() {
        int[] list  = EMPTY_LIST;
        Bubble.sort(list);
        Assert.assertArrayEquals(new int[0] , list);
    }
}
