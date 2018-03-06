import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        HashMap<String, Integer> ransomMap = new HashMap<>();
        HashMap<String, Integer> magMap = new HashMap<>();

        fillMap(ransomMap, ransom);
        fillMap(magMap, magazine);

        boolean isRansomPossible = true;
        for (String key : ransomMap.keySet()) {
            if (!magMap.containsKey(key)) isRansomPossible = false;
            Integer magazineCount = magMap.get(key);
            Integer ranCount = ransomMap.get(key);
            if (magazineCount < ranCount) isRansomPossible = false;
        }

        String response = isRansomPossible ? "Yes" : "No";
        System.out.println(response);
    }

    private static void fillMap(HashMap<String, Integer> strMap, String[] str) {
        for (String k : str) {
            if (strMap.containsKey(k)) {
                strMap.put(k, strMap.get(k) + 1);
            } else {
                strMap.put(k, 1);
            }
        }
    }


}
