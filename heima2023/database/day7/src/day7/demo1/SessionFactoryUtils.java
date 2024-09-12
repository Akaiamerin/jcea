package day7.demo1;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class SessionFactoryUtils {
    private static SqlSessionFactory factory;
    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("day7/demo1/mybatis-config.xml");
            factory = builder.build(is);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    public static SqlSessionFactory getSessionFactory() {
        return factory;
    }
    public static SqlSession getSession() {
        return factory.openSession();
    }
}