package exp1.mapper;
import exp1.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface UserMapper {
    @Insert("INSERT INTO user (id, username, password) VALUES (null, #{username}, #{password})")
    boolean insertUser(User user);
    @Delete("DELETE FROM user WHERE username = #{username}")
    boolean deleteUserByUsername(User user);
    @Update("UPDATE user SET username = #{username}, password = #{password} WHERE username = #{username}")
    boolean updateUserByUsername(User user);
    @Select("SELECT * FROM user")
    List<User> selectAllUser();
    @Select("SELECT password FROM user WHERE username = #{username}")
    String selectPasswordByUsername(User user);
}