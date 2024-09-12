package exp1.mapper.impl;
import exp1.mapper.CakeMapper;
import exp1.model.Cake;
import exp1.utils.MyBatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
public class CakeMapperImpl implements CakeMapper {
    @Override
    public int updateNumberById(Cake cake) {
        SqlSession session = MyBatisUtils.getSqlSession();
        CakeMapper cakeMapper = session.getMapper(CakeMapper.class);
        int result = cakeMapper.updateNumberById(cake);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
    @Override
    public List<Cake> selectAllCake() {
        SqlSession session = MyBatisUtils.getSqlSession();
        CakeMapper cakeMapper = session.getMapper(CakeMapper.class);
        List<Cake> result = cakeMapper.selectAllCake();
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return result;
    }
}