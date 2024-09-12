题目

设计一个数学工具类 `MyMath`，要求：

该工具类不能有子类，不接受扩展。

该工具类不能被外界创建对象，构造方法需要私有化。

静态常量 `PI` 保存圆周率 `3.14`。

静态方法 `getMin` 获取两个整数的较小值。

静态方法 `getMax` 获取两个整数的较大值。

答案

[MyMath.java](./src/day2/demo1/MyMath.java)

<br>

题目

设计“员工类”：

属性（全部私有）：姓名、性别、年龄。

方法：无参构造方法、全参构造方法、`Getter` 方法、`Setter` 方法、工作（抽象）。

设计“绘画接口”：

抽象方法：绘画。

设计“Java 讲师类”继承“员工类”。

设计“UI 讲师类”继承“员工类”并实现“绘画接口”。

根据上面的要求设计出类结构，实现相关的方法。

答案

[Demo2.java](./src/day2/demo2/Demo2.java)

<br>

题目

设计一个接口 `Shape`，要求：

该接口中的方法：

```Java
double getArea() //获取图形的面积
double getCircumference() //获取图形的周长
```

设计一个圆类 `Circle`，要求：

圆类 `Circle` 实现接口 `Shape`。

该类含有一个静态常量：

```Java
PI //值为 3.14
```

该类包含的成员变量：

```Java
radius //public 修饰的 double 类型 radius，表示圆的半径。
x //private 修饰的 double 型变量 x，表示圆心的横坐标。
y //private 修饰的 double 型变量 y，表示圆心的纵坐标。
```

该类包含的方法：

```Java
Circle(double radius) //有参构造方法，以形参列表中的参数初始化半径，圆心为坐标原点（x = 0，y = 0） 
    
double getRadius() //获取半径

void setRadius(double  radius) //设置半径
    
void setCenter(double x, double  y) //设置类圆心坐标
```

根据上面的要求实现相关类和接口，创建一个圆对象，半径为 `10`，求面积和周长。

答案

[Demo3.java](./src/day2/demo3/Demo3.java)

<br>

题目

设计接口 `Charge`，有一个抽象方法 `charge`；设计接口 `Play`，有一个抽象方法 `play`。

设计类 `Bus` 实现接口 `Charge`，对于 `Bus` 中的 `charge`，实现为输出“公共汽车：1 元/张，不计公里数。”

设计类 `Taxi` 实现接口 `Charge`，对于 `Taxi` 中的 `charge`，实现为输出“出租车：1.6 元/公里，起价 3 公里。”

设计类 `Cinema` 实现接口 `Charge`、`Play`，对于 `Cinema` 中的 `charge`，实现为输出“电影院：30 元/张，凭学生证享受半价。”；对于 `Cinema` 中的 `play`，实现输出为 “正在放映电影。”

答案

[Demo4.java](./src/day2/demo4/Demo4.java)

<br>

题目

为方向，季度，星期，月份设计枚举类型表示。

方向：上、下、左、右。

季节：春、夏、秋、冬。

星期：星期日、······、星期六。

月份：一月、······、十二月。

答案

[Demo5.java](./src/day2/demo5/Demo5.java)

<br>

题目

设计一个学生类，属性有姓名、性别、年龄。要求性别使用枚举类型且只能是男（`BOY`）或女（`Girl`）。

答案

[Demo6.java](./src/day2/demo6/Demo6.java)