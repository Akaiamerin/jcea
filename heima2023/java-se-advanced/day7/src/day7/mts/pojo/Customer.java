package day7.mts.pojo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
public class Customer extends User {
    private Map<String, List<LocalDateTime>> purchaseRecord; //购买记录
    public Customer() {

    }
    public Customer(String username, String passWord, String nickname, Character gender, String phone, Double money, Map<String, List<LocalDateTime>> purchaseRecord) {
        super(username, passWord, nickname, gender, phone, money);
        this.purchaseRecord = purchaseRecord;
    }
    public Map<String, List<LocalDateTime>> getPurchaseRecord() {
        return purchaseRecord;
    }
    public void setPurchaseRecord(Map<String, List<LocalDateTime>> purchaseRecord) {
        this.purchaseRecord = purchaseRecord;
    }
}