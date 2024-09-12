package exp1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Exp1 {
    public static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }
    public static Set<String> intersection(Set<String> set1, Set<String> set2) {
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.retainAll(set2);
        return set;
    }
    public static Set<String> difference(Set<String> set1, Set<String> set2) {
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.removeAll(set2);
        return set;
    }
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new HashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
        System.out.println(union(set1, set2));
        System.out.println(intersection(set1, set2));
        System.out.println(difference(set1, set2));
    }
}