import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> ads = new ArrayList<>();
        for (Integer i : grades) {
            if (i > 37) {
                Integer a = i % 10;
                if (a == 3 || a == 8) {
                    ads.add(i + 2);
                } else if (a == 4 || a ==9) {
                    ads.add(i + 1);
                }
            }else {
                ads.add(i);
            }

        }
        for (Integer n : ads){
            System.out.println(n);
        }
        return ads;
    }
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(38);
        integerList.add(43);
        integerList.add(74);
       gradingStudents(integerList);
    }
}