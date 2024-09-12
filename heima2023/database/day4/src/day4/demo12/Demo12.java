package day4.demo12;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Demo12 {
    public static void createTable() {
        String sql1 = """
                CREATE TABLE dept (
                    id INT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(20) NOT NULL,
                    PRIMARY KEY (id),
                    UNIQUE KEY (name)
                );
                """;
        String sql2 = """
                CREATE TABLE employee (
                    id INT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(20) NOT NULL,
                    gender CHAR(1),
                    post VARCHAR(20),
                    salary DOUBLE,
                    entry_date DATE,
                    dept_id INT,
                    PRIMARY KEY (id),
                    UNIQUE KEY (name),
                    FOREIGN KEY (dept_id) REFERENCES dept(id)
                );
                """;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.executeBatch();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, stmt, null);
        }
    }
    public static void insertDept() {
        String sql = "INSERT INTO dept (id, name) values (NULL, '研发部'), (NULL, '销售部'), (NULL, '产品部')";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void insertEmployee() {
        String sql = "INSERT INTO employee (id, name, gender, post, salary, entry_date, dept_id) values (NULL, '张三', '男', 'Java研发工程师', 9000, '2016-10-10', 1), (NULL, '林青霞', '女', '销售经理', 15000, '2015-06-15', 2), (NULL, '李四', '男', '产品经理', 10000, '2014-12-11', 3), (NULL, '张三丰', '男', 'Android研发工程师', 8000, '2017-05-26', 1)";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void updateSalaryById(Integer id, Double salary) {
        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setDouble(1, salary);
            prepStmt.setInt(2, id);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static List<Employee> selectAllEmployee() {
        String sql = "SELECT * FROM employee";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                Employee employee = new Employee();
                employee.setId(retSet.getInt(1));
                employee.setName(retSet.getString(2));
                employee.setGender(retSet.getString(3));
                employee.setPost(retSet.getString(4));
                employee.setSalary(retSet.getDouble(5));
                employee.setEntryDate(retSet.getDate(6).toLocalDate());
                employee.setDeptId(retSet.getInt(7));
                employeeList.add(employee);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
        return employeeList;
    }
    public static Employee selectEmployeeByName(String name) {
        String sql = "SELECT * FROM employee WHERE name = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        Employee employee = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, name);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                employee = new Employee();
                employee.setId(retSet.getInt(1));
                employee.setName(retSet.getString(2));
                employee.setGender(retSet.getString(3));
                employee.setPost(retSet.getString(4));
                employee.setSalary(retSet.getDouble(5));
                employee.setEntryDate(retSet.getDate(6).toLocalDate());
                employee.setDeptId(retSet.getInt(7));
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
        return employee;
    }
    public static void deleteEmployeeByName(String name) {
        String sql = "DELETE FROM employee WHERE name = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, name);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void selectNameAndSalaryByNameLike() {
        String sql = "SELECT name, salary FROM employee WHERE name LIKE '%张%'";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                System.out.println(retSet.getString(1) + " " + retSet.getDouble(2));
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static List<Employee> selectEmployeeByGreaterSalary(Double salary) {
        String sql = "SELECT * FROM employee WHERE salary >= ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setDouble(1, salary);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                Employee employee = new Employee();
                employee.setId(retSet.getInt(1));
                employee.setName(retSet.getString(2));
                employee.setGender(retSet.getString(3));
                employee.setPost(retSet.getString(4));
                employee.setSalary(retSet.getDouble(5));
                employee.setEntryDate(retSet.getDate(6).toLocalDate());
                employee.setDeptId(retSet.getInt(7));
                employeeList.add(employee);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
        return employeeList;
    }
    public static List<Employee> selectEmployeeByDeptName(String deptName) {
        String sql = "SELECT * FROM employee WHERE dept_id IN (SELECT id FROM dept WHERE name = ?)";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, deptName);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                Employee employee = new Employee();
                employee.setId(retSet.getInt(1));
                employee.setName(retSet.getString(2));
                employee.setGender(retSet.getString(3));
                employee.setPost(retSet.getString(4));
                employee.setSalary(retSet.getDouble(5));
                employee.setEntryDate(retSet.getDate(6).toLocalDate());
                employee.setDeptId(retSet.getInt(7));
                employeeList.add(employee);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
        return employeeList;
    }
    public static void main(String[] args) {
        createTable();
        insertDept();
        insertEmployee();
        updateSalaryById(1, 10000.0);
        selectAllEmployee();
        selectEmployeeByName("张三");
        deleteEmployeeByName("张三");
        selectNameAndSalaryByNameLike();
        selectEmployeeByGreaterSalary(10000.0);
        selectEmployeeByDeptName("研发部");
    }
}