package day7.mts.pojo;
public class Business extends User {
    private String shopName; //店铺名称
    private String address; //店铺地址
    public Business() {

    }
    public Business(String username, String passWord, String nickname, Character gender, String phone, Double money, String shopName, String address) {
        super(username, passWord, nickname, gender, phone, money);
        this.shopName = shopName;
        this.address = address;
    }
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}