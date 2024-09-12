package day4.demo5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Demo5 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "111111";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM stu";
        ResultSet retSet = stmt.executeQuery(sql);
        while (retSet.next() == true) {
            int id = retSet.getInt(1);
            String name = retSet.getString(2);
            String gender = retSet.getString(3);
            System.out.println("id：" + id + " 姓名：" + name + " 性别：" + gender);
            id = retSet.getInt("id");
            name = retSet.getString("name");
            gender = retSet.getString("gender");
            System.out.println("id：" + id + " 姓名：" + name + " 性别：" + gender);
        }
        retSet.close();
        stmt.close();
        conn.close();
    }
}