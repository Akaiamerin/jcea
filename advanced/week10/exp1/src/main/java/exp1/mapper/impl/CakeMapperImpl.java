package exp1.mapper.impl;
import exp1.mapper.CakeMapper;
import exp1.model.Cake;
import exp1.utils.MyBatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
public class CakeMapperImpl implements CakeMapper {
    @Override
    public boolean updateNumberById(Cake cake) {
        SqlSession session = MyBatisUtils.getSqlSession();
        CakeMapper cakeMapper = session.getMapper(CakeMapper.class);
        boolean ret = cakeMapper.updateNumberById(cake);
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return ret;
    }
    @Override
    public List<Cake> selectAllCake() {
        SqlSession session = MyBatisUtils.getSqlSession();
        CakeMapper cakeMapper = session.getMapper(CakeMapper.class);
        List<Cake> cakeList = cakeMapper.selectAllCake();
        MyBatisUtils.commitSqlSession(session);
        MyBatisUtils.closeSqlSession(session);
        return cakeList;
    }
}