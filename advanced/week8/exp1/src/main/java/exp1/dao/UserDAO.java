package exp1.dao;
import exp1.model.User;
public interface UserDAO {
    String selectPasswordByUsername(User user);
    boolean insertUser(User user);
}