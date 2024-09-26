import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class TaskThree {

    public static void main(String[] args) {

        ArrayList<FileInputStream> iss = new ArrayList<>();

        try {

            for (int i = 1; i <= 5; i++) {

                iss.add(new FileInputStream("taskthree_" + i + ".txt"));

            }

        } catch (FileNotFoundException e) {

            e.getStackTrace();

        }

        try (SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(iss));
             FileOutputStream    out = new FileOutputStream("taskthree_out.txt")) {

            int x;
            while ((x = seq.read()) != -1) {
                out.write(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
