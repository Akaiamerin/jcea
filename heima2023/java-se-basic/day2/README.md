题目

下面的代码是否存在问题？若存在，则请说明原因并改正。

```Java
byte b1 = 3; //第一行
byte b2 = 4; //第二行
byte b3 = b1 + b2; //第三行
byte b4 = 3 + 4; //第四行
```

答案

第三行存在问题，`b1` 和 `b2` 两个 `byte` 类型在相加的时候，会提升为 `int` 类型进行运算，提升之后两个 `int` 类型相加的结果还是 `int` 类型，将 `int` 类型变量赋值给 `byte` 类型变量需要强转。

```Java
byte b3 = (byte) (b1 + b2);
```

<br>

题目

下面的代码的输出是什么？描述中间的运算过程。

答案

```Java
int num = 10;
char ch = 'a';
int result = num + ch;
System.out.println(result);
```

```Java
107
```

`char` 类型和 `int` 类型相加的时候，会提升为 `int` 类型，字符 `a` 的 ASCII 码表数值为 `97`，`97 + 10 = 107`。

<br>

题目

说一下算数运算符 `/`、`%` 的特点。

答案

`/`：Java 当中整数相除，结果只能得到整数，如果想要带有小数的结果，那么需要有小数参与运算。

`%`：取模，结果是除法之后剩下的余数。

<br>

题目

下面的代码想要运算结果是 2.5，怎么修改？

```Java
int a = 5;
int b = 2;
double c = a / b;
```

答案

```Java
//方式一
double c = (a * 1.0) / b;
//方式二
double c = a / (b * 1.0);
//方式三
double a = 5;
int b = 2;
double c = a / b;
//方式四
int a = 5;
double b = 2;
double c = a / b;
//方式五
double a = 5;
double b = 2;
double c = a / b;
```

<br>

题目

下面的代码的输出是什么？描述中间的运算过程。

```Java
int a = 10;
double b = 12.3;
a += b;
System.out.println(a);
```

```Java
22
```

`a += b`，就是 `10 + 12.3 = 22.3`。

`+=` 自带强转效果，`a` 又是 `int` 类型，因此 `22.3` 给 `int` 类型的 `a` 赋值有一个强转，类似于 `int a = (int) 22.3`。

<br>

题目

请结合下面的代码，描述 `if` 语句的执行流程。

```Java
if (判断条件 1) {
    语句体 1;
}
else if (判断条件 2) {
    语句体 2;
}
else {
    语句体 3;
}
```

答案

执行判断条件 1，若结果为 `true`，则执行语句体 1，执行完毕后，结束掉整个的 `if` 语句；若结果为 `false`，则进入第二步。

执行判断条件 2, 若结果为 `true`，则执行语句体 2，执行完毕后，结束掉整个的 `if` 语句；若结果为 `false`，则进入第三步。

若所有的判断条件的结果都为 `false`，则执行最后的 `else`，语句体 3。

<br>

题目

给定一个四位数，输出每位数字之和。

答案

[Demo1.java](./src/day2/Demo1.java)

<br>

题目

交换两个整数变量的值。

答案

[Demo2.java](./src/day2/Demo2.java)

<br>

题目

给定三个整数，求出最大值。（分别使用三元运算符和 `if` 选择结构实现）

答案

[Demo3.java](./src/day2/Demo3.java)

<br>

题目

给定一个月份，输出它是哪个季节。其中 3、4、5 月为春季，6、7、8 月为夏季，9、10、11 月为秋季，12、1、2 月为冬季。（使用 `switch` 选择结构实现）

答案

[Demo4.java](./src/day2/Demo4.java)