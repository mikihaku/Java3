import java.sql.*;

public class Main {

    private Connection conn = null;


    public static void main(String[] args) {

        new Main();

    }

    Main() {

        connect();
        createTable();
        fillTable();


        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void createTable()  {

        try {

            Statement stmt = conn.createStatement();
                        stmt.execute("CREATE TABLE IF NOT EXISTS goods (\n" +
                                         "    ID     INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                                         "                   NOT NULL,\n" +
                                         "    prodid INT     UNIQUE\n" +
                                         "                   NOT NULL,\n" +
                                         "    title  VARCHAR NOT NULL,\n" +
                                         "    cost   DOUBLE  NOT NULL\n" +
                                         ");\n");
            System.out.println("Таблица создана");
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private void fillTable() {

        try {

            conn.setAutoCommit(false);

            Statement st = conn.createStatement();
                      st.execute("DELETE FROM goods");

            PreparedStatement ps = conn.prepareStatement("INSERT INTO goods VALUES (NULL, ?, ?, ?)");

            for (int i = 1; i <= 10000; i++ ) {

                ps.setInt(1, i );
                ps.setString(2, "товар" + i);
                ps.setDouble(3, i*10d);
                ps.addBatch();

            }

            ps.executeBatch();

            conn.commit();

            System.out.println("Данные добавлены");

        } catch (SQLException e) {

            try {
                conn.rollback();

            } catch (SQLException q) {

                System.out.println(e.getMessage());

            }
        }
    }
    private void connect() {

        try {

            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:testDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Подлючение к базе установлено");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

}
