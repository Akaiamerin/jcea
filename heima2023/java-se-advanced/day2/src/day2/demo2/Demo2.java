package day2.demo2;
public class Demo2 {
    public static void main(String[] args) {
        JavaTeacher javaTeacher = new JavaTeacher("张三");
        javaTeacher.work();
        UITeacher uiTeacher = new UITeacher("李四");
        uiTeacher.work();
        uiTeacher.paint();
    }
}