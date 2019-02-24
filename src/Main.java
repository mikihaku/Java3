public class Main {

    public static void main(String[] args) {

        try {

            //Class cls = Class.forName("TestSuit");
            String cls = "TestSuite";
            new RunTest<>(cls);

        } catch (Exception e) {
            System.out.println("Не удалось найти указанный пакет тестов");
        }

    }

}
