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
    public String selectPasswordByUsername(User user) {
        String ret = null;
        StringBuilder sql = new StringBuilder("SELECT password FROM user WHERE username = ?");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setString(1, user.getUsername());
            retSet = prepStmt.executeQuery();
            if (retSet.next() == true) {
                ret = retSet.getString(1);
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
        return ret;
    }
    @Override
    public boolean insertUser(User user) {
        boolean ret = false;
        StringBuilder sql = new StringBuilder("INSERT INTO user (id, username, password) VALUES (null, ?, ?)");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            if (prepStmt.executeUpdate() > 0) {
                ret = true;
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.closePrepStmt(prepStmt);
            JDBCUtils.closeConn(conn);
        }
        return ret;
    }
}