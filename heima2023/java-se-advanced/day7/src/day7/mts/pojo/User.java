package day7.mts.pojo;
public class User {
    private String username; //用户名（不能重复）
    private String passWord; //密码
    private String nickname; //昵称
    private Character gender; //性别
    private String phone; //手机号码
    private Double money; //账户金额
    public User() {

    }
    public User(String username, String passWord, String nickname, Character gender, String phone, Double money) {
        this.username = username;
        this.passWord = passWord;
        this.nickname = nickname;
        this.gender = gender;
        this.phone = phone;
        this.money = money;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Character getGender() {
        return gender;
    }
    public void setGender(Character gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
}