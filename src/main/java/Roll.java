import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Roll {

    private final List<Integer> dice;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int scores(Category category) {
        return category.sum(this);
    }

    public int sum() {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> retrieveDiceWithSameValue(int numberOfDice) {
        return dice.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= numberOfDice)
                .map(Map.Entry::getKey)
                .distinct()
                .toList();
    }

    public int sumDiceWithSameValue(int value) {
        return dice.stream().mapToInt(Integer::intValue).filter(die -> die == value).sum();
    }

    public boolean allSameDie() {
        return dice.stream().allMatch(die -> die.equals(dice.getFirst()));
    }

    public boolean allDifferentDie() {
        return dice.stream().distinct().count() == 5;
    }
}



