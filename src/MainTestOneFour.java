import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainTestOneFour {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, new int[]{1,4}},
                {true, new int[]{1,1,4,4,1}},
                {true, new int[]{1,1,1,1,1,1,1,4}},
                {true, new int[]{4,4,1,4,4,4,1,1}},
                {false, new int[]{}},
                {false, new int[]{1}},
                {false, new int[]{1,3,4,1,4,1,1}},
                {false, new int[]{3}},
                {false, new int[]{4,4,4}},
                {false, new int[]{1,1,1,1}}
        });
    }

    private int[] seq;
    private boolean result;

    public MainTestOneFour(boolean result, int[] seq) {
        this.seq = seq;
        this.result = result;
    }

    private Main main;

    @Before
    public void startTest() {
        main = new Main();
    }


    @Test
    public void testOneFour() {

        Assert.assertEquals(result, main.checkOneFour(seq));

    }
}