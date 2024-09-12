package exp1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classNo;
    private String course;
    private Integer score;
    public Student() {

    }
    public Student(Integer id, String name, String gender, Integer age, String classNo, String course, Integer score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classNo = classNo;
        this.course = course;
        this.score = score;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public Integer getAge() {
        return age;
    }
    public String getClassNo() {
        return classNo;
    }
    public String getCourse() {
        return course;
    }
    public Integer getScore() {
        return score;
    }
    @Override
    public String toString() {
        return id + " " +
                name + " " +
                gender + " " +
                age + " " +
                classNo + " " +
                course + " " +
                score;
    }
}
public class Exp1 {
    public static List<Student> initStuList() {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student(20210001, "张三", "男", 19, "1班", "Java程序设计基础", 98));
        stuList.add(new Student(20210002, "李四", "男", 20, "2班", "Java程序设计基础", 90));
        stuList.add(new Student(20210003, "王五", "男", 21, "3班", "Java程序设计基础", 95));
        stuList.add(new Student(20210004, "李翠", "女", 18, "4班", "Java程序设计基础", 53));
        stuList.add(new Student(20210005, "王丽华", "女", 19, "2班", "Java程序设计基础", 85));
        stuList.add(new Student(20210006, "胡小明", "男", 22, "4班", "Java程序设计基础", 88));
        stuList.add(new Student(20210007, "程东", "男", 19, "2班", "Java程序设计基础", 75));
        stuList.add(new Student(20210008, "陈红", "女", 17, "1班", "Java程序设计基础", 68));
        stuList.add(new Student(20210009, "肖文艺", "女", 20, "3班", "Java程序设计基础", 55));
        return stuList;
    }
    public static void que1_1(List<Student> stuList) {
        System.out.println("查找年龄小于 20 的女学生");
        stuList
                .stream()
                .filter((Student stu)->{
                    return stu.getAge() < 20;
                })
                .filter((Student stu)->{
                    return Objects.equals(stu.getGender(), "女");
                })
                .forEach((Student stu)->{
                    System.out.println(stu);
                });
    }
    public static void que1_2(List<Student> stuList) {
        System.out.println("获取所有男学生并忽略前两位男学生");
        stuList
                .stream()
                .filter((Student stu)->{
                    return stu.getGender().equals("男");
                })
                .skip(2)
                .forEach((Student stu)->{
                    System.out.println(stu);
                });
    }
    public static void que1_3(List<Student> stuList) {
        System.out.println("获取 2 班所有学生名单，计算 2 班学生的平均分数");
        stuList
                .stream()
                .filter((Student stu)->{
                    return Objects.equals(stu.getClassNo(), "2班");
                })
                .forEach((Student stu)->{
                    System.out.println(stu);
                });
        double avg = stuList
                .stream()
                .filter((Student stu)->{
                    return Objects.equals(stu.getClassNo(), "2班");
                })
                .collect(Collectors.averagingDouble(((Student stu)->{
                    return stu.getScore();
                })));
        System.out.println(avg);
    }
    public static void que1_4(List<Student> stuList) {
        System.out.println("查找第一个年龄等于 19 岁的学生");
        Optional<Student> stuOptional = stuList.stream().filter((Student stu)->{
            return stu.getAge() == 19;
        }).findFirst();
        System.out.println(stuOptional);
    }
    public static void que1_5(List<Student> stuList) {
        System.out.println("查找成绩不及格学生");
        stuList
                .stream()
                .filter((Student stu)->{
                    return stu.getScore() < 60;
                })
                .forEach((Student stu)->{
                    System.out.println(stu);
                });
    }
    public static void que2(List<Student> stuList) {
        System.out.println("统计该科目各项数据，打印成报表。总人数、年龄最大学生、年龄最小学生、总平均成绩、各班平均成绩、学生名单。");
        long cnt = stuList.stream().count();
        System.out.println("总人数：" + cnt);
        Optional<Student> maxAge = stuList.stream().max(Comparator.comparing(((Student stu)->{
            return stu.getAge();
        })));
        System.out.println("年龄最大学生：" + maxAge);
        Optional<Student> minAge = stuList.stream().min(Comparator.comparing(((Student stu)->{
            return stu.getAge();
        })));
        System.out.println("年龄最小学生：" + minAge);
        double totalAvg = stuList.stream().collect(Collectors.averagingDouble(((Student stu)->{
            return stu.getScore();
        })));
        System.out.println("总平均成绩：" + totalAvg);
        Set<Student> classNoSet = new TreeSet<>(Comparator.comparing(((Student stu)->{
            return stu.getClassNo();
        })));
        classNoSet.addAll(stuList);
        List<Double> classAvgList = new ArrayList<>();
        for (int i = 0; i < classNoSet.size(); i++) {
            String classNo = i + 1 + "班";
            classAvgList.add(
                    stuList
                            .stream()
                            .filter((Student stu)->{
                                return Objects.equals(stu.getClassNo(), classNo);
                            })
                            .collect(Collectors.averagingDouble((Student stu)->{
                                return stu.getScore();
                            }))
            );
            System.out.println(classNo + "平均成绩：" + classAvgList.get(i));
        }
        String stuName = stuList
                .stream()
                .map((Student stu)->{
                    return stu.getName();
                })
                .collect(Collectors.joining(" "));
        System.out.println("学生名单：" + stuName);
    }
    public static void que3(List<Student> stuList) {
        System.out.println("打印出所有学生分组信息（先按班级分组，再按性别分组）。");
        Map<String, Map<String, List<Student>>> classNoMap = stuList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                (Student stu)->{
                                    return stu.getClassNo();
                                },
                                Collectors.groupingBy((Student stu)->{
                                    return stu.getGender();
                                })
                        )
                );
        for (Map.Entry<String, Map<String, List<Student>>> entry1 : classNoMap.entrySet()) {
            Map<String, List<Student>> genderMap = entry1.getValue();
            for (Map.Entry<String, List<Student>> entry2 : genderMap.entrySet()) {
                List<Student> list = entry2.getValue();
                for (Student stu : list) {
                    System.out.println(stu);
                }
            }
        }
    }
    public static void main(String[] args) {
        List<Student> stuList = initStuList();
        que1_1(stuList);
        que1_2(stuList);
        que1_3(stuList);
        que1_4(stuList);
        que1_5(stuList);
        que2(stuList);
        que3(stuList);
    }
}