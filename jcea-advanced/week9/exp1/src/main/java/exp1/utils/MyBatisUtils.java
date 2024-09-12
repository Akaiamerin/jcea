package exp1.utils;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MyBatisUtils {
    private static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    private MyBatisUtils() {

    }
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
    public static void commitSqlSession(SqlSession session) {
        if (session != null) {
            session.commit();
        }
    }
    public static void closeSqlSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}