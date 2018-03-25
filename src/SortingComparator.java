import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    public String name;
    public int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;
        Player p1 = (Player) o1;
        Player p2 = (Player) o2;
        if (p1.score < p2.score) {
            result = 1;
        } else if (p1.score > p2.score) {
            result = -1;
        } else if (p1.name.compareTo(p2.name) == 0) {
            result = 0;
        } else {
            result = p1.name.compareTo(p2.name) < 0 ? -1 : 1;
        }

        return result;
    }
}

class SortingComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}