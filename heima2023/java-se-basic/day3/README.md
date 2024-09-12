题目

如果 `switch` 语句省略了 `break`，那么会出现什么现象？简单描述一下这个现象。

答案

`case` 穿透现象。当执行完某一个 `case` 中的语句体后，如果没有遇到 `break`，那么将会开启 `case` 穿透。这种穿透会进行到下一个 `case` 中，继续执行语句体直到遇到 `break`，或者执行到了 `switch` 的末尾才会停止。

<br>

题目

下面的代码能否执行？

```Java
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println(i);
    }
}
```

答案

代码编译出错。在 `for` 循环执行完毕后，变量 `i` 会从内存中释放掉，无法在使用。

<br>

题目

下面的代码统计 `1`-`20` 之间 `5` 的倍数有几个，但是代码存在错误，请说明错误原因并修改代码。

```Java
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            int count = 0;
            if (i % 5 == 0) {
                count++;
            }
            System.out.println(count);
        }
    }
}
```

答案

`int count = 0;` 计数器变量应该定义在循环外部，不然每一次进入循环，都重新置为 `0`。

`System.out.println(count);` 这行代码是输出 `5` 的倍数有多少个，应该写在循环结束，只有循环结束了，才算是统计完毕。

```Java
public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 5 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

<br>

题目

下面的代码输出所有的水仙花数，但是代码存在错误，请说明错误原因并修改代码。

```Java
public class Main {
    public static void main(String[] args) {
        int n = 100;
        while (n <= 999) {
            int onesDigit = n % 10;
            int tensDigit = n / 10 % 10;
            int hundredsDigit = n / 10 / 10 % 10;
            if (onesDigit * onesDigit * onesDigit + tensDigit * tensDigit * tensDigit + hundredsDigit * hundredsDigit * hundredsDigit == n) {
                System.out.println(n);
            }
        }
    }
}
```

答案

`while` 循环中忘记了 `n++`。

```Java
public class Main {
    public static void main(String[] args) {
        int n = 100;
        while (n <= 999) {
            int onesDigit = n % 10;
            int tensDigit = n / 10 % 10;
            int hundredsDigit = n / 10 / 10 % 10;
            if (onesDigit * onesDigit * onesDigit + tensDigit * tensDigit * tensDigit + hundredsDigit * hundredsDigit * hundredsDigit == n) {
                System.out.println(n);
            }
            n++;
        }
    }
}
```

<br>

题目

求 `1`-`10` 之间不能被 `3` 整除的数之和。（分别使用 `for` 循环和 `while` 循环实现）

答案

[Demo1.java](./src/day3/Demo1.java)

<br>

题目

求 `1`-`100` 之间所有奇数之和，输出一共有多少个奇数。（分别使用 `for` 循环和 `while` 循环实现）

答案

[Demo2.java](./src/day3/Demo2.java)

<br>

题目

输出 `1`-`100` 之间能同时被 `2`、`3`、`5` 整除的数有多少个。

答案

[Demo3.java](./src/day3/Demo3.java)

<br>

题目

中国有闰年的说法。闰年的规则是四年一闰，百年不闰，四百年再闰，即​年份能够被 `4` 整除但不能被 `100` 整除是闰年，年份能被 `400` 整除也是闰年。

​输出 `1970` 年到 `2020` 年之间的所有闰年年份。

答案

[Demo4.java](./src/day3/Demo4.java)