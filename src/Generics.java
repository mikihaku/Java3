import java.util.ArrayList;
import java.util.Arrays;

public class Generics {

    public Generics() {

        testSwap();
        testConvert();
    }

    private <T> void swap (T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private <T> ArrayList<T> arrayToArrayList (T[] array) {

        return new ArrayList<>(Arrays.asList(array));

    }

    private void testSwap() {

        String [] strings = {"One", "Two", "Three", "Four"};
        Integer [] numbers = {1, 2, 3, 4};

        swap(strings, 2, 0);
        swap(numbers, 3, 1);

        System.out.println("strings:"+ Arrays.toString(strings));
        System.out.println("numbers:"+Arrays.toString(numbers));

    }

    private void testConvert() {

        String[] strings = {"One", "Two", "Three", "Four"};

        ArrayList arrayList = arrayToArrayList(strings);

        System.out.println("type of strings: "+ strings.getClass());
        System.out.println("type of arrayList: "+ arrayList.getClass());
        System.out.println("----");
    }

}
