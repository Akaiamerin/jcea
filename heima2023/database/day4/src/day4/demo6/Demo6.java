package day4.demo6;
import java.sql.Connection;
public class Demo6 {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.close(conn, null, null);
    }
}