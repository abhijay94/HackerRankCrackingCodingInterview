import java.util.*;

public class Anagrams {


    public static int numberNeeded(String first, String second) {
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
            if(!letterCountMap.containsKey(i)) {
                count++;
            } else if (letterCountMap.containsKey(i) && letterCountMap.get(i) > 0) {
                letterCountMap.put(i,letterCountMap.get(i)-1);
            } else if (letterCountMap.containsKey(i) && letterCountMap.get(i) == 0) {
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
