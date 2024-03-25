import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int... dice) {
        boolean yatzy = Arrays.stream(dice).allMatch(value -> value == dice[0]);
        return yatzy ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return sumSameDice(1, dice);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return sumSameDice(2, dice);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        return sumSameDice(3, dice);
    }

    public int fours() {
        return sumSameDice(4, dice);
    }

    public int fives() {
        return sumSameDice(5, dice);
    }

    public int sixes() {
        return sumSameDice(6, dice);
    }

    private static int sumSameDice(int category, int[] dice) {
        return IntStream.of(dice).filter(die -> die == category).sum();
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        return computeNumberOfAKind(2, d1, d2, d3, d4, d5);
    }

    private static boolean hasPair(int die, int[] dice) {
        return Arrays.stream(dice).filter(value -> value == die).count() >= 2;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = {d1, d2, d3, d4, d5};
        int[] pairs = retrievePairs(dice);

        if (pairs.length != 2) {
            return 0;
        } else {
            return Arrays.stream(pairs).sum() * 2;
        }
    }

    private static int[] retrievePairs(int[] dice) {
        return Arrays.stream(dice)
                .filter(die -> hasPair(die, dice))
                .distinct()
                .toArray();
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {

        return computeNumberOfAKind(4, d1, d2, d3, d4, d5);
    }

    private static int computeNumberOfAKind(int numberOfDie, int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dice = Arrays.asList(d1, d2, d3, d4, d5);
        return dice.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= numberOfDie)
                .map(Map.Entry::getKey)
                .distinct()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) * numberOfDie;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return computeNumberOfAKind(3, d1, d2, d3, d4, d5);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dice = Arrays.asList(d1, d2, d3, d4, d5);
        return computeStraight(dice);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        List<Integer> dice = Arrays.asList(d1, d2, d3, d4, d5);
        return computeStraight(dice);
    }

    private static int computeStraight(List<Integer> dice) {
        if (dice.stream().distinct().count() == 5) {
            return dice.stream().mapToInt(Integer::intValue).sum();
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {

        int[] dice = {d1, d2, d3, d4, d5};
        int[] pairs = retrievePairs(dice);
        int threeOfAKind = computeNumberOfAKind(3, d1, d2, d3, d4, d5);

        if (pairs.length < 2) {
            return 0;
        }

        return Arrays.stream(pairs).filter(die -> die != threeOfAKind/3).findFirst().orElse(0) * 2 + threeOfAKind;
    }
}



