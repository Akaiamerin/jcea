package exp1.mapper;
import exp1.model.Cake;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface CakeMapper {
    @Update("UPDATE cake SET number = number - 1 WHERE id = #{id}")
    int updateNumberById(Cake cake);
    @Select("SELECT * FROM cake")
    List<Cake> selectAllCake();
}