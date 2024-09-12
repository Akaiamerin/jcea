package day7.mts;
import day7.mts.pojo.Business;
import day7.mts.pojo.Customer;
import day7.mts.pojo.Movie;
import day7.mts.pojo.User;
import day7.mts.view.IndexView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class MovieTicketingSystem {
    public static final Map<String, User> ALL_USER = new HashMap<>();
    public static final Map<Business, List<Movie>> ALL_MOVIE = new HashMap<>();
    public static final Scanner SC = new Scanner(System.in);
    static {
        //商家数据
        Business business1 = new Business("b1", "b1", "b1", '男', "114514", 100.0, "b1电影院", "b1地址");
        ALL_USER.put(business1.getUsername(), business1);
        List<Movie> moveList1 = new ArrayList<>(
                Arrays.asList(
                        new Movie("x", "a", 1.0, 99.9, 999, LocalDateTime.now()),
                        new Movie("xx", "a", 1.0, 99.9, 999, LocalDateTime.now()),
                        new Movie("xxx", "a", 1.0, 99.9, 999, LocalDateTime.now())
                )
        );
        ALL_MOVIE.put(business1, moveList1);
        Business business2 = new Business("b2", "b2", "b2", '男', "114514", 100.0, "b2电影院", "b2地址");
        ALL_USER.put(business1.getUsername(), business1);
        List<Movie> moveList2 = new ArrayList<>(
                Arrays.asList(
                        new Movie("y", "y", 1.0, 99.9, 999, LocalDateTime.now()),
                        new Movie("yy", "y", 1.0, 99.9, 999, LocalDateTime.now()),
                        new Movie("yyy", "y", 1.0, 99.9, 999, LocalDateTime.now())
                )
        );
        ALL_MOVIE.put(business2, moveList2);
        //客户数据
        Customer customer = new Customer("a", "a", "a", '男', "114514", 9999.99, new HashMap<>());
        ALL_USER.put(customer.getUsername(), customer);
    }
    public static void main(String[] args) {
        IndexView.view();
    }
}