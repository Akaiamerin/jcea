package exp3;
interface Eatable {
    void eat();
}
public class Exp3 {
    public static void main(String[] args) {
        Eatable dog = (()->{
            System.out.println("小狗爱吃骨头");
        });
        dog.eat();
        Eatable cat = (()->{
            System.out.println("小猫爱吃鱼");
        });
        cat.eat();
        Eatable cock = (()->{
            System.out.println("小鸡爱吃毛毛虫");
        });
        cock.eat();
    }
}