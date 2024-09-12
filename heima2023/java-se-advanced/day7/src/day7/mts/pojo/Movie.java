package day7.mts.pojo;
import java.time.LocalDateTime;
public class Movie {
    private String name; //电影名称
    private String director; //导演
    private Double time; //时长
    private Double price; //票价
    private Integer number; //余票
    private LocalDateTime startTime; //放映时间
    public Movie() {

    }
    public Movie(String name, String director, Double time, Double price, Integer number, LocalDateTime startTime) {
        this.name = name;
        this.director = director;
        this.time = time;
        this.price = price;
        this.number = number;
        this.startTime = startTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public Double getTime() {
        return time;
    }
    public void setTime(Double time) {
        this.time = time;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}