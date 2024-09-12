package day5;
public class User {
    private String id;
    private String username;
    private String name;
    private String tel;
    private String address;
    public User() {

    }
    public User(String id, String username, String name, String tel, String address) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void output() {
        System.out.println("编号：" + id);
        System.out.println("用户名：" + username);
        System.out.println("姓名：" + name);
        System.out.println("手机号：" + tel);
        System.out.println("地址：" + address);
    }
}