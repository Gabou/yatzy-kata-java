package gabriel.kata.yatzy;

import gabriel.kata.yatzy.categories.Chance;
import gabriel.kata.yatzy.categories.FullHouse;
import gabriel.kata.yatzy.categories.TwoPairs;
import gabriel.kata.yatzy.categories.YatzyCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static gabriel.kata.yatzy.categories.NumbersCategory.Fives;
import static gabriel.kata.yatzy.categories.NumbersCategory.Fours;
import static gabriel.kata.yatzy.categories.NumbersCategory.Ones;
import static gabriel.kata.yatzy.categories.NumbersCategory.Sixes;
import static gabriel.kata.yatzy.categories.NumbersCategory.Threes;
import static gabriel.kata.yatzy.categories.NumbersCategory.Twos;
import static gabriel.kata.yatzy.categories.NumbersOfAKindCategory.FourOfAKind;
import static gabriel.kata.yatzy.categories.NumbersOfAKindCategory.Pair;
import static gabriel.kata.yatzy.categories.NumbersOfAKindCategory.ThreeOfAKind;
import static gabriel.kata.yatzy.categories.StraightCategory.LargeStraight;
import static gabriel.kata.yatzy.categories.StraightCategory.SmallStraight;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RollTest {

    private Yatzy yatzy;

    @BeforeEach
    void setUp() {
        yatzy = new Yatzy();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 3, 3, 6, 14",
            "4, 5, 5, 6, 1, 21",
            "2, 3, 4, 5, 1, 15",
            "3, 3, 4, 5, 1, 16"
    })
    void chance_scores_sum_of_all_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Chance(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 1, 1, 50",
            "6, 6, 6, 6, 6, 50",
            "1, 1, 1, 2, 1, 0"
    })
    void yatzy_scores_50_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new YatzyCategory(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 1",
            "1, 2, 1, 4, 5, 2",
            "1, 2, 1, 1, 1, 4",
            "3, 3, 3, 4, 5, 0"
    })
    void ones_scores_sum_of_all_one_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Ones(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2, 5, 1, 4",
            "2, 2, 2, 2, 2, 10",
            "6, 6, 6, 6, 3, 0"
    })
    void twos_scores_sum_of_all_two_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Twos(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 2, 3, 6",
            "2, 3, 3, 3, 3, 12",
            "6, 6, 6, 6, 4, 0"
    })
    void threes_scores_sum_of_all_three_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Threes(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 12",
            "4, 4, 5, 5, 5, 8",
            "4, 5, 5, 5, 5, 4",
            "1, 1, 2, 4, 4, 8"
    })
    void fours_scores_sum_of_all_four(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Fours(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 10",
            "4, 4, 5, 5, 5, 15",
            "4, 5, 5, 5, 5, 20"
    })
    void fives_scores_sum_of_all_five_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Fives(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 0",
            "4, 4, 6, 5, 5, 6",
            "6, 5, 6, 6, 5, 18"
    })
    void sixes_scores_sum_of_all_six_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Sixes(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 3, 5, 6, 6",
            "5, 3, 3, 3, 5, 10",
            "5, 3, 6, 6, 5, 12",
            "1, 2, 3, 4, 5, 0",
            "3, 3, 3, 4, 4, 8",
            "1, 1, 6, 2, 6, 12",
            "3, 3, 3, 4, 1, 6",
            "3, 3, 3, 3, 1, 6"
    })
    void pair_scores_sum_of_two_highest_identical_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new Pair(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 5, 4, 5, 16",
            "3, 3, 5, 5, 5, 16",
            "3, 5, 5, 5, 5, 0",
            "1, 1, 2, 3, 3, 8",
            "1, 1, 2, 3, 4, 0",
            "1, 1, 2, 2, 2, 6",
            "3, 3, 3, 3, 1, 0"
    })
    void two_pair_scores_sum_of_two_different_pair_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new TwoPairs(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 3, 4, 5, 9",
            "5, 3, 5, 4, 5, 15",
            "3, 3, 3, 3, 5, 9",
            "3, 3, 4, 5, 6, 0",
            "3, 3, 3, 3, 1, 9"
    })
    void three_of_a_kind_scores_sum_of_three_identical_dice(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new ThreeOfAKind(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 5, 4, 5, 20",
            "3, 3, 3, 3, 5, 12",
            "2, 2, 2, 2, 5, 8",
            "2, 2, 2, 5, 5, 0",
            "2, 2, 2, 2, 2, 8"
    })
    void four_of_a_kind_scores_sum_of_four_identical_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new FourOfAKind(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 15",
            "2, 3, 4, 5, 1, 15",
            "1, 2, 2, 4, 5, 0"
    })
    void small_straight_scores_sum_of_one_two_three_four_five_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new SmallStraight(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3, 4, 5, 20",
            "2, 3, 4, 5, 6, 20",
            "1, 2, 2, 4, 5, 0"
    })
    void large_straight_scores_sum_of_two_three_four_five_six_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new LargeStraight(), roll);
        assertEquals(expectedResult, scores);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 2, 2, 6, 18",
            "2, 3, 4, 5, 6, 0",
            "6, 3, 2, 2, 6, 0",
            "1, 1, 2, 2, 2, 8",
            "2, 2, 3, 3, 4, 0",
            "4, 4, 4, 4, 4, 0"
    })
    void full_house_scores_sum_of_a_pair_and_a_three_of_a_kind_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        var roll = new Roll(dice1, dice2, dice3, dice4, dice5);
        var scores = yatzy.scores(new FullHouse(), roll);
        assertEquals(expectedResult, scores);
    }
}
