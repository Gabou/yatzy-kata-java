package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public sealed interface StraightCategory extends Category {

    record SmallStraight() implements StraightCategory {
    }

    record LargeStraight() implements StraightCategory {
    }

    @Override
    default int sum(Roll roll) {
        if (roll.allDifferentDie()) {
            return roll.sum();
        }
        return 0;
    }
}
