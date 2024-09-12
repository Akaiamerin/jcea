package exp1.dao;
import exp1.model.User;
public interface UserDAO {
    int insertUser(User user);
    User selectUserByUsernameAndPassword(String username, String password);
}