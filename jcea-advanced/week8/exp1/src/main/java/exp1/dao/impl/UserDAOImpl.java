package exp1.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exp1.dao.UserDAO;
import exp1.model.User;
import exp1.utils.JDBCUtils;
public class UserDAOImpl implements UserDAO {
    @Override
    public int insertUser(User user) {
        int result = 0;
        String sql = "INSERT INTO user (id, username, password) VALUES (null, ?, ?)";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
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
    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        User result = null;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConn();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);
            retSet = prepStmt.executeQuery();
            if (retSet.next() == true) {
                result = new User();
                result.setId(retSet.getInt(1));
                result.setUsername(retSet.getString(2));
                result.setPassword(retSet.getString(3));
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