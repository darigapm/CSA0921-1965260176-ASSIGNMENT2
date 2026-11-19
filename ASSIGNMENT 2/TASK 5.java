import java.util.*;

public class Leaderboard<T> {
    private final List<T> items = new ArrayList<>();
    private final Comparator<? super T> comparator;

    public Leaderboard(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> ranking() {
        List<T> sortedList = new ArrayList<>(items);
        sortedList.sort(comparator);
        return sortedList;
    }

    public static class Team {
        String name;
        int points;
        int goalDiff;

        public Team(String name, int points, int goalDiff) {
            this.name = name;
            this.points = points;
            this.goalDiff = goalDiff;
        }

        @Override
        public String toString() {
            return name + "(" + points + "," + goalDiff + ")";
        }
    }

    public static void main(String[] args) {
        Comparator<Team> byRank = Comparator
            .comparingInt((Team t) -> t.points).reversed()
            .thenComparing(Comparator.comparingInt((Team t) -> t.goalDiff).reversed())
            .thenComparing(t -> t.name);

        Leaderboard<Team> board = new Leaderboard<>(byRank);
        board.add(new Team("Panthers", 9, 4));
        board.add(new Team("Eagles", 9, 6));
        board.add(new Team("Cobras", 6, 1));
        board.add(new Team("Bisons", 9, 4));

        System.out.println("Leaderboard Ranking:");
        System.out.println(board.ranking());
    }
}
