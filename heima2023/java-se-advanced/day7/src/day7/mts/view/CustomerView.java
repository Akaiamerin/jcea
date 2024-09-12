package day7.mts.view;
import day7.mts.MovieTicketingSystem;
import day7.mts.pojo.Business;
import day7.mts.pojo.Customer;
import day7.mts.pojo.Movie;
import day7.mts.pojo.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public class CustomerView {
    private CustomerView() {

    }
    public static void registerView() {
        while (true) {
            System.out.println("---客户注册界面---");
            System.out.print("请输入用户名：");
            String username = MovieTicketingSystem.SC.nextLine();
            if (MovieTicketingSystem.ALL_USER.containsKey(username) == true) {
                System.out.println("用户名已存在");
            }
            else {
                System.out.print("请输入密码：");
                String password = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入昵称：");
                String nickname = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入性别：");
                String gender = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入手机号码：");
                String phone = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入账户金额：");
                String money = MovieTicketingSystem.SC.nextLine();
                Customer customer = new Customer();
                customer.setUsername(username);
                customer.setPassWord(password);
                customer.setNickname(nickname);
                customer.setGender(gender.charAt(0));
                customer.setPhone(phone);
                customer.setMoney(Double.parseDouble(money));
                MovieTicketingSystem.ALL_USER.put(username, customer);
            }
        }
    }
    public static void indexView(User user) {
        Customer customer = (Customer) user;
        while (true) {
            System.out.println("---客户界面---");
            System.out.println("1、查看全部电影信息");
            System.out.println("2、根据电影名称查询电影信息");
            System.out.println("3、评分功能");
            System.out.println("4、购票功能");
            System.out.println("5、退出");
            System.out.print("请输入操作命令：");
            String option = MovieTicketingSystem.SC.nextLine();
            if (Objects.equals(option, "1") == true) {
                for (Map.Entry<Business, List<Movie>> entry : MovieTicketingSystem.ALL_MOVIE.entrySet()) {
                    Business business = entry.getKey();
                    List<Movie> movieList = entry.getValue();
                    System.out.println("店铺名称：" + business.getShopName() + " | 店铺地址：" + business.getAddress());
                    if (movieList.isEmpty() == true) {
                        System.out.println("无");
                        System.out.println();
                    }
                    else {
                        for (int i = 0; i < movieList.size(); i++) {
                            Movie movie = movieList.get(i);
                            System.out.println("电影名称：" + movie.getName());
                            System.out.println("导演：" + movie.getDirector());
                            System.out.println("时长：" + movie.getTime());
                            System.out.println("票价：" + movie.getPrice());
                            System.out.println("余票：" + movie.getNumber());
                            System.out.println("放映时间：" + movie.getStartTime());
                            System.out.println();
                        }
                    }
                }
            }
            else if (Objects.equals(option, "2") == true) {
                System.out.print("请输入电影名称：");
                String name = MovieTicketingSystem.SC.nextLine();
                boolean flag = false;
                for (Map.Entry<Business, List<Movie>> entry : MovieTicketingSystem.ALL_MOVIE.entrySet()) {
                    Business business = entry.getKey();
                    List<Movie> movieList = MovieTicketingSystem.ALL_MOVIE.get(business);
                    int index = -1;
                    for (int i = 0; i < movieList.size(); i++) {
                        Movie movie = movieList.get(i);
                        if (Objects.equals(movie.getName(), name) == true) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        continue;
                    }
                    flag = true;
                    Movie movie = MovieTicketingSystem.ALL_MOVIE.get(business).get(index);
                    System.out.println("电影名称：" + movie.getName());
                    System.out.println("导演：" + movie.getDirector());
                    System.out.println("时长：" + movie.getTime());
                    System.out.println("票价：" + movie.getPrice());
                    System.out.println("余票：" + movie.getNumber());
                    System.out.println("放映时间：" + movie.getStartTime());
                    System.out.println();
                }
                if (flag == false) {
                    System.out.println("电影不存在");
                }
            }
            else if (Objects.equals(option, "3") == true) {
                //评分功能（选做）
            }
            else if (Objects.equals(option, "4") == true) {
                System.out.print("请输入电影名称：");
                String name = MovieTicketingSystem.SC.nextLine();
                boolean flag = false;
                for (Map.Entry<Business, List<Movie>> entry : MovieTicketingSystem.ALL_MOVIE.entrySet()) {
                    Business business = entry.getKey();
                    List<Movie> movieList = MovieTicketingSystem.ALL_MOVIE.get(business);
                    int index = -1;
                    for (int i = 0; i < movieList.size(); i++) {
                        Movie movie = movieList.get(i);
                        if (Objects.equals(movie.getName(), name) == true) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        continue;
                    }
                    Movie movie = MovieTicketingSystem.ALL_MOVIE.get(business).get(index);
                    if (movie.getNumber() <= 0 || customer.getMoney() - movie.getPrice() < 0) {
                        System.out.println("购票失败");
                    }
                    else {
                        flag = true;
                        movie.setNumber(movie.getNumber() - 1);
                        customer.setMoney(customer.getMoney() - movie.getPrice());
                        Map<String, List<LocalDateTime>> purchaseRecord = customer.getPurchaseRecord();
                        List<LocalDateTime> list = purchaseRecord.getOrDefault(name, new ArrayList<>());
                        list.add(LocalDateTime.now());
                        purchaseRecord.put(name, list);
                        for (Map.Entry<String, List<LocalDateTime>> record : purchaseRecord.entrySet()) {
                            String key = record.getKey();
                            System.out.println("---电影" + key + "购票记录---");
                            List<LocalDateTime> value = record.getValue();
                            for (int i = 0; i < value.size(); i++) {
                                String time = value.get(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                System.out.println("第 " + (i + 1) + " 次购票时间：" + time);
                            }
                        }
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("电影不存在");
                }
            }
            else if (Objects.equals(option, "5") == true) {
                return;
            }
            else {
                System.out.println("命令错误");
            }
        }
    }
}