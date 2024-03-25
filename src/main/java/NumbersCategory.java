import java.util.List;

public enum NumbersCategory implements Category {
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6);

    private final int valueOfScoringDice;

    NumbersCategory(int valueOfScoringDice) {
        this.valueOfScoringDice = valueOfScoringDice;
    }

    @Override
    public int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).filter(die -> die == valueOfScoringDice).sum();
    }
}
