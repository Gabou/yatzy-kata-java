public enum NumbersOfAKindCategory implements Category{
    PAIR(2),
    THREE_OF_A_KIND(3),
    FOUR_OF_A_KIND(4);

    private final int numberOfDice;

    NumbersOfAKindCategory(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    @Override
    public int sum(Roll roll) {
        return roll.retrieveDiceWithSameValue(numberOfDice)
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) * numberOfDice;
    }
}
