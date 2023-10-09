
// Compile
// javac -cp [Drive File Path.jar ] [Java File Path.java]
//Eg: javac -cp C:\Users\Admin\Downloads\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0.jar C:\Users\Admin\Desktop\JDBCEx.java
// Run
// javac -cp [Drive File Path.jar ] [Java File Path]
//Eg: java -cp C:\Users\Admin\Downloads\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0.jar;C:\Users\Admin\Desktop JDBCEx
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCEx {

    public static void main(String args[]) {
        Connection con = null;
        Statement st = null;

        try {
            // Load driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //MySQL Driver download link
            //https://dev.mysql.com/downloads/connector/j/
            System.out.println("Driver Loaded");

            // Obtain a connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true",
                    "root", "root");
            System.out.println("Database Connected Successfully!");

            // Create Query
            String sql = "INSERT INTO Student(sname, scity) values('Mayur Khot','Pune')";

            // Obtain a statement
            st = con.createStatement();

            // Execute the query
            int check = st.executeUpdate(sql);

            if (check > 0) {
                System.out.println("Insert Done");
            }
            // Close Connection
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }

    }
}