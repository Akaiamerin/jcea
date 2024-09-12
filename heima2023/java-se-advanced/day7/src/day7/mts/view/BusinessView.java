package day7.mts.view;
import day7.mts.MovieTicketingSystem;
import day7.mts.pojo.Business;
import day7.mts.pojo.Movie;
import day7.mts.pojo.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class BusinessView {
    private BusinessView() {

    }
    public static void registerView() {
        while (true) {
            System.out.println("---商家注册界面---");
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
                System.out.print("请输入店铺名称：");
                String shopName = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入店铺地址：");
                String address = MovieTicketingSystem.SC.nextLine();
                Business business = new Business();
                business.setUsername(username);
                business.setPassWord(password);
                business.setNickname(nickname);
                business.setGender(gender.charAt(0));
                business.setPhone(phone);
                business.setMoney(Double.parseDouble(money));
                business.setShopName(shopName);
                business.setAddress(address);
                MovieTicketingSystem.ALL_USER.put(username, business);
                MovieTicketingSystem.ALL_MOVIE.put(business, new ArrayList<>());
            }
        }
    }
    public static void indexView(User user) {
        Business business = (Business) user;
        while (true) {
            System.out.println("---商家界面---");
            System.out.println("1、查看排片信息");
            System.out.println("2、上架电影");
            System.out.println("3、下架电影");
            System.out.println("4、修改电影");
            System.out.println("5、退出");
            System.out.print("请输入操作命令：");
            String option = MovieTicketingSystem.SC.nextLine();
            if (Objects.equals(option, "1") == true) {
                List<Movie> movieList = MovieTicketingSystem.ALL_MOVIE.get(business);
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
            else if (Objects.equals(option, "2") == true) {
                System.out.print("请输入电影名称：");
                String name = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入导演：");
                String director = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入时长：");
                String time = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入票价：");
                String price = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入余票：");
                String number = MovieTicketingSystem.SC.nextLine();
                System.out.print("请输入放映时间：");
                String startTime = MovieTicketingSystem.SC.nextLine();
                Movie movie = new Movie();
                movie.setName(name);
                movie.setDirector(director);
                movie.setTime(Double.valueOf(time));
                movie.setPrice(Double.valueOf(price));
                movie.setNumber(Integer.valueOf(number));
                movie.setStartTime(LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                MovieTicketingSystem.ALL_MOVIE.get(business).add(movie);
            }
            else if (Objects.equals(option, "3") == true) {
                System.out.print("请输入电影名称：");
                String name = MovieTicketingSystem.SC.nextLine();
                List<Movie> movieList = MovieTicketingSystem.ALL_MOVIE.get(business);
                boolean removeFlag = false;
                for (int i = 0; i < movieList.size(); i++) {
                    Movie movie = movieList.get(i);
                    if (Objects.equals(movie.getName(), name) == true) {
                        System.out.println("下架电影成功");
                        movieList.remove(i);
                        removeFlag = true;
                        break;
                    }
                }
                if (removeFlag == false) {
                    System.out.println("下架电影失败");
                }
            }
            else if (Objects.equals(option, "4") == true) {
                System.out.print("请输入电影名称：");
                String name = MovieTicketingSystem.SC.nextLine();
                int index = -1;
                List<Movie> movieList = MovieTicketingSystem.ALL_MOVIE.get(business);
                for (int i = 0; i < movieList.size(); i++) {
                    Movie movie = movieList.get(i);
                    if (Objects.equals(movie.getName(), name) == true) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("电影不存在");
                }
                else {
                    System.out.print("请输入新电影名称：");
                    String newName = MovieTicketingSystem.SC.nextLine();
                    System.out.print("请输入新导演：");
                    String newDirector = MovieTicketingSystem.SC.nextLine();
                    System.out.print("请输入新时长：");
                    String newTime = MovieTicketingSystem.SC.nextLine();
                    System.out.print("请输入新票价：");
                    String newPrice = MovieTicketingSystem.SC.nextLine();
                    System.out.print("请输入新余票：");
                    String newNumber = MovieTicketingSystem.SC.nextLine();
                    System.out.print("请输入新放映时间：");
                    String newStartTime = MovieTicketingSystem.SC.nextLine();
                    Movie movie = movieList.get(index);
                    movie.setName(newName);
                    movie.setDirector(newDirector);
                    movie.setTime(Double.valueOf(newTime));
                    movie.setPrice(Double.valueOf(newPrice));
                    movie.setNumber(Integer.valueOf(newNumber));
                    movie.setStartTime(LocalDateTime.parse(newStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
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