import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TaskTwo {

    public static void main(String[] args) {

        try {

            // Open file
            File file = new File("tasktwo.txt");
            FileInputStream in = new FileInputStream(file);

            // Read
            byte[] arr = new byte[(int)file.length()];
            in.read(arr);

            // Output 1
            ByteArrayInputStream arrStream = new ByteArrayInputStream(arr);
            int x;
            while ((x = arrStream.read()) != -1) {
                System.out.print(x + " ");
            }
            System.out.println();

            // Output 2
            String str = new String(arr);
            System.out.println("File: " + str);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
