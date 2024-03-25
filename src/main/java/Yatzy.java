import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Yatzy {

    private final List<Integer> dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int chance() {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public int yatzy() {
        boolean yatzy = dice.stream().allMatch(die -> die.equals(dice.getFirst()));
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
        List<Integer> pairs = retrievePairs(dice);

        if (pairs.size() != 2) {
            return 0;
        } else {
            return pairs.stream().mapToInt(Integer::intValue).sum() * 2;
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
        List<Integer> pairs = retrievePairs(dice);
        int threeOfAKind = computeNumberOfAKind(3);

        if (pairs.size() < 2) {
            return 0;
        }

        return pairs.stream().filter(die -> die != threeOfAKind / 3).findFirst().orElse(0) * 2 + threeOfAKind;
    }

    private int sumSameDice(int category, List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).filter(die -> die == category).sum();
    }

    private List<Integer> retrievePairs(List<Integer> dice) {
        return dice.stream()
                .filter(die -> hasPair(die, dice))
                .distinct()
                .toList();
    }

    private boolean hasPair(int die, List<Integer> dice) {
        return dice.stream().filter(value -> value == die).count() >= 2;
    }

    private int computeNumberOfAKind(int numberOfDie) {
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

    private int computeStraight(List<Integer> dice) {
        if (dice.stream().distinct().count() == 5) {
            return dice.stream().mapToInt(Integer::intValue).sum();
        }
        return 0;
    }
}



