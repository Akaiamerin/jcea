package exp1.mapper.impl;
import exp1.mapper.UserMapper;
import exp1.model.User;
import exp1.utils.MyBatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
public class UserMapperImpl implements UserMapper {
    @Override
    public int insertUser(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int result = userMapper.insertUser(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
    @Override
    public int deleteUserByUsername(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int result = userMapper.deleteUserByUsername(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
    @Override
    public int updateUserByUsername(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int result = userMapper.updateUserByUsername(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User result = userMapper.selectUserByUsernameAndPassword(username, password);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
    @Override
    public List<User> selectAllUser() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> result = userMapper.selectAllUser();
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
}