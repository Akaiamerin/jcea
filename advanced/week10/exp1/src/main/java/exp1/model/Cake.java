package exp1.model;
public class Cake {
    private Integer id;
    private String name;
    private Double price;
    private Integer number;
    public Cake() {

    }
    public Cake(Integer id, String name, Double price, Integer number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
}