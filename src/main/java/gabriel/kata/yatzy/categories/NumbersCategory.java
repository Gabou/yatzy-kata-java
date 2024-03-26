package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public sealed interface NumbersCategory extends Category {

    record Ones(int valueOfScoringDice) implements NumbersCategory {
        public Ones() {
            this(1);
        }
    }

    record Twos(int valueOfScoringDice) implements NumbersCategory {
        public Twos() {
            this(2);
        }
    }

    record Threes(int valueOfScoringDice) implements NumbersCategory {
        public Threes() {
            this(3);
        }
    }

    record Fours(int valueOfScoringDice) implements NumbersCategory {
        public Fours() {
            this(4);
        }
    }

    record Fives(int valueOfScoringDice) implements NumbersCategory {
        public Fives() {
            this(5);
        }
    }

    record Sixes(int valueOfScoringDice) implements NumbersCategory {
        public Sixes() {
            this(6);
        }
    }

    int valueOfScoringDice();

    @Override
    default int sum(Roll roll) {
        return roll.sumDiceWithSameValue(valueOfScoringDice());
    }

}
