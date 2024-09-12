题目

多态访问特点是什么？

答案

成员变量：编译看左边，运行看左边。

成员方法：编译看左边，运行看右边。

<br>

题目

分析下面的代码的运行结果。

```Java
class Outer {
    public int number = 10;
    class Inner {
        public int number = 20;
        public void show() {
            int number = 30;
            System.out.println(number);
            System.out.println(this.number);
            System.out.println(Outer.this.number);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.show();
    }
}
```

答案：

```Java
30
20
10
```

<br>

题目

动物类：

属性：名称。

行为：吃。

猫类继承动物类：

行为：吃（重写）、抓老鼠。

狗类继承动物类：

行为：吃（重写）、看门。

根据上面的要求设计类。

答案

[Demo1.java](./src/day3/demo1/Demo1.java)

<br>

题目

设计一个学生类，它有三个属性：姓名、性别、年龄。

创建学生对象，输出对象时，不再是地址，而是能够将对象的属性内容输出出来。

答案

[Demo2.java](./src/day3/demo2/Demo2.java)

<br>

题目

编写程序，从控制台输入一个“生日”（格式：`yyyy-MM-dd`），程序要能够计算并输出他来到世界多少天。

注意：“生日”必须早于当前日期。

答案

[Demo3.java](./src/day3/demo3/Demo3.java)

<br>

题目

获取当前系统的时间，以“xxxx年xx月xx日 xx时xx分xx秒”的格式输出。

答案

[Demo4.java](./src/day3/demo4/Demo4.java)

<br>

题目

键盘输入一个年份，输出该年份的二月有多少天。

答案

[Demo5.java](./src/day3/demo5/Demo5.java)

<br>

题目

计算 `2` 的 `10` 次幂。

计算 `1.2` 向上取整的结果。

计算 `2.8` 向下取整的结果。

计算 `3.6` 四舍五入取整的结果。

答案

[Demo6.java](./src/day3/demo6/Demo6.java)