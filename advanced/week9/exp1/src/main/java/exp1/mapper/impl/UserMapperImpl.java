package exp1.mapper.impl;
import exp1.mapper.UserMapper;
import exp1.model.User;
import exp1.utils.MyBatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
public class UserMapperImpl implements UserMapper {
    @Override
    public boolean insertUser(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        boolean ret = userMapper.insertUser(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return ret;
    }
    @Override
    public boolean deleteUserByUsername(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        boolean ret = userMapper.deleteUserByUsername(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return ret;
    }
    @Override
    public boolean updateUserByUsername(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        boolean ret = userMapper.updateUserByUsername(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return ret;
    }
    @Override
    public List<User> selectAllUser() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUser();
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return userList;
    }
    @Override
    public String selectPasswordByUsername(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        String password = userMapper.selectPasswordByUsername(user);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return password;
    }
}