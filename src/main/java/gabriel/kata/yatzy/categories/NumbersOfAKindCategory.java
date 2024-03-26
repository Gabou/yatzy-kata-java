package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public sealed interface NumbersOfAKindCategory extends Category {

    record Pair(int numberOfDice) implements NumbersOfAKindCategory {
        public Pair() {
            this(2);
        }
    }

    record ThreeOfAKind(int numberOfDice) implements NumbersOfAKindCategory {
        public ThreeOfAKind() {
            this(3);
        }
    }

    record FourOfAKind(int numberOfDice) implements NumbersOfAKindCategory {
        public FourOfAKind() {
            this(4);
        }
    }

    int numberOfDice();

    @Override
    default int sum(Roll roll) {
        return roll.retrieveDiceWithSameValue(numberOfDice())
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) * numberOfDice();
    }
}
