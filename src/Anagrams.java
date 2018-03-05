import java.util.*;

public class Anagrams {

    private static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        char[] arrFirst = first.toCharArray();
        char[] arrSecond = second.toCharArray();

        int count = 0;
        for (char i : arrFirst) {
            if (letterCountMap.containsKey(i)) {
                letterCountMap.put(i, letterCountMap.get(i) + 1);
            } else {
                letterCountMap.put(i, 1);
            }
        }

        for (char i : arrSecond) {
            int letterCount = letterCountMap.get(i);
            if (!letterCountMap.containsKey(i)) {
                count++;
            } else if (letterCountMap.containsKey(i) && letterCount > 0) {
                letterCountMap.put(i, letterCount - 1);
            } else if (letterCountMap.containsKey(i) && letterCount == 0) {
                count++;
            }
        }

        for (Integer value : letterCountMap.values()) {
            count = count + value;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }


}
