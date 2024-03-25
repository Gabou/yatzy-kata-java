import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {

    private final int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        boolean yatzy = Arrays.stream(dice).allMatch(value -> value == dice[0]);
        return yatzy ? 50 : 0;
    }

    public int ones() {
        return sumSameDice(1, dice);
    }

    public int twos() {
        return sumSameDice(2, dice);
    }

    public int threes() {
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

    public int pair() {
        return computeNumberOfAKind(2);
    }

    public int twoPairs() {
        int[] pairs = retrievePairs(dice);

        if (pairs.length != 2) {
            return 0;
        } else {
            return Arrays.stream(pairs).sum() * 2;
        }
    }

    public int threeOfAKind() {
        return computeNumberOfAKind(3);
    }

    public int fourOfAKind() {
        return computeNumberOfAKind(4);
    }

    public int smallStraight() {
        return computeStraight(dice);
    }

    public int largeStraight() {
        return computeStraight(dice);
    }

    public int fullHouse() {
        int[] pairs = retrievePairs(dice);
        int threeOfAKind = computeNumberOfAKind(3);

        if (pairs.length < 2) {
            return 0;
        }

        return Arrays.stream(pairs).filter(die -> die != threeOfAKind / 3).findFirst().orElse(0) * 2 + threeOfAKind;
    }

    private int sumSameDice(int category, int[] dice) {
        return IntStream.of(dice).filter(die -> die == category).sum();
    }

    private boolean hasPair(int die, int[] dice) {
        return Arrays.stream(dice).filter(value -> value == die).count() >= 2;
    }

    private int[] retrievePairs(int[] dice) {
        return Arrays.stream(dice)
                .filter(die -> hasPair(die, dice))
                .distinct()
                .toArray();
    }

    private int computeNumberOfAKind(int numberOfDie) {
        return Arrays.stream(dice)
                .boxed()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= numberOfDie)
                .map(Map.Entry::getKey)
                .distinct()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) * numberOfDie;
    }

    private int computeStraight(int[] dice) {
        if (Arrays.stream(dice).distinct().count() == 5) {
            return Arrays.stream(dice).sum();
        }
        return 0;
    }
}



