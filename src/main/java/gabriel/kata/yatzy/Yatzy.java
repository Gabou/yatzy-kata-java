package gabriel.kata.yatzy;

import gabriel.kata.yatzy.categories.Category;

public class Yatzy {
    public int scores(Category category, Roll roll) {
        return category.sum(roll);
    }
}
