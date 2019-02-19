import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTailTest {

    private Main main;

    @Before
    public void startTest() {
        main = new Main();
    }


    @Test(expected = RuntimeException.class)
    public void testGetTailException() {

        int[] seq = {};
        int[] result = {1};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test(expected = RuntimeException.class)
    public void testGetTailException2() {

        int[] seq = {1,2,3,5,6,7,8};
        int[] result = {1,2};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test
    public void testGetTailDataSet1() {

        int[] seq = {1,2,3,4,5,6,7,8,10};
        int[] result = {5,6,7,8,10};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test
    public void testGetTailDataSet2() {

        int[] seq = {1,2,3,5,4,6,7,8,10};
        int[] result = {6,7,8,10};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test
    public void testGetTailDataSet3() {

        int[] seq = {4,1,2,3,5,6,7,8,10};
        int[] result = {1,2,3,5,6,7,8,10};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test
    public void testGetTailDataSet4() {

        int[] seq = {1,2,3,4,5,6,4,8,10};
        int[] result = {8,10};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }

    @Test
    public void testGetTailDataSet5() {

        int[] seq = {1,2,3,4,5,6,7,8,4};
        int[] result = {};

        Assert.assertArrayEquals(result, main.getTail(seq));

    }
}