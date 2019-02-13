import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskFour {

    private String filename = "access.log";
    private Scanner scanner = new Scanner(System.in);
    private int pageSize = 1800;
    private int pageReadTimeout = 5000;
    private int executionTimeout = 10000;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    private TaskFour() {

        try {
            RandomAccessFile file = new RandomAccessFile("access.log", "r");

            System.out.println("Введите номер страницы и -1 для выхода:...");

            while (true) {

                final int pageNum = scanner.nextInt() - 1;

                if(pageNum < 0) {
                    break;
                }

                final long startExecTime = System.currentTimeMillis();

                Future future = executorService.submit(() -> {

                    try {

                        byte[] page = new byte[pageSize];

                        file.seek(pageNum * pageSize);
                        file.read(page,0, pageSize);

                        String str = new String(page);
                        System.out.println("Страница: " + str);
                        System.out.println("Введите номер страницы и -1 для выхода:...");


                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                });

                try {

                    Object result = future.get(pageReadTimeout, TimeUnit.MILLISECONDS);

                } catch (TimeoutException e) {

                    future.cancel(true);
                    System.out.println("Страница читается слишком долго");

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

            try {
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(executionTimeout, TimeUnit.MILLISECONDS)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                }
                file.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {

        new TaskFour();

    }

    private String readPage(int page) {

        return null;

    }

}
