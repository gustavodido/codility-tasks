import java.util.HashSet;

public class MIssingInteger {
    public int solution(int[] A) {
        HashSet<Integer> numbers = new HashSet<>();

        for (int aA : A) numbers.add(aA);

        int min = 1;
        while (numbers.contains(min)) min++;

        return min;
    }
}
