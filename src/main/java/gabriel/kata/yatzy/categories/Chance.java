package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public final class Chance implements Category{
    @Override
    public int sum(Roll roll) {
        return roll.sum();
    }
}
