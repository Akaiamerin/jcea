package exp1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
class Emp {
    private Integer id;
    private String name;
    private String gender;
    private String birth;
    private String dept;
    public Emp() {

    }
    public Emp(Integer id, String name, String gender, String birth, String dept) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.dept = dept;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        return id +
                name + " " +
                gender + " " +
                birth + " " +
                dept;
    }
}
class JDBCUtils {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/emp";
    private static final String ACCT = "root";
    private static final String PWD = "111111";
    static {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
    private JDBCUtils() {

    }
    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, ACCT, PWD);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }
    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
    public static void closePrepStmt(PreparedStatement prepStmt) {
        try {
            if (prepStmt != null) {
                prepStmt.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
    public static void closeRetSet(ResultSet retSet) {
        try {
            if (retSet != null) {
                retSet.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
class EmpDAO {
    private EmpDAO() {

    }
    public static int insertEmp(Emp emp) {
        int result = 0;
        String sql = "INSERT INTO emp (id, name, gender, birth, dept) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, emp.getId());
            prepStmt.setString(2, emp.getName());
            prepStmt.setString(3, emp.getGender());
            prepStmt.setString(4, emp.getBirth());
            prepStmt.setString(5, emp.getDept());
            result = prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.closePrepStmt(prepStmt);
            JDBCUtils.closeConn(conn);
        }
        return result;
    }
    public static int deleteEmpById(Integer id) {
        int result = 0;
        String sql = "DELETE FROM emp WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            result = prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.closePrepStmt(prepStmt);
            JDBCUtils.closeConn(conn);
        }
        return result;
    }
    public static int updateEmpById(Emp emp) {
        int result = 0;
        String sql = "UPDATE emp SET id = ?, name = ?, gender = ?, brith = ?, dept = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, emp.getId());
            prepStmt.setString(2, emp.getName());
            prepStmt.setString(3, emp.getGender());
            prepStmt.setString(4, emp.getBirth());
            prepStmt.setString(5, emp.getDept());
            prepStmt.setInt(6, emp.getId());
            result = prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.closePrepStmt(prepStmt);
            JDBCUtils.closeConn(conn);
        }
        return result;
    }
    public static List<Emp> selectAllEmp() {
        List<Emp> result = new ArrayList<>();
        String sql = "SELECT * FROM emp";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                Emp emp = new Emp();
                emp.setId(retSet.getInt(1));
                emp.setName(retSet.getString(2));
                emp.setGender(retSet.getString(3));
                emp.setBirth(retSet.getString(4));
                emp.setDept(retSet.getString(5));
                result.add(emp);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.closeRetSet(retSet);
            JDBCUtils.closePrepStmt(prepStmt);
            JDBCUtils.closeConn(conn);
        }
        return result;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        EmpDAO.insertEmp(new Emp(1, "张三", "男", "1997/11/02", "开发部"));
        EmpDAO.insertEmp(new Emp(2, "大强", "男", "1989/06/11", "营销部"));
        EmpDAO.insertEmp(new Emp(3, "小王", "男", "1993/05/30", "财务部"));
        EmpDAO.insertEmp(new Emp(4, "小胖", "女", "1998/07/10", "开发部"));
        EmpDAO.insertEmp(new Emp(5, "李怡", "女", "2000/05/18", "人事部"));
        List<Emp> empList = EmpDAO.selectAllEmp();
        for (int i = 0; i < empList.size(); i++) {
            Emp emp = empList.get(i);
            System.out.println(emp);
        }
    }
}