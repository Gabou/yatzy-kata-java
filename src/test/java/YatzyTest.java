import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(2,3,4,5,1).chance());
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, new Yatzy(4,4,4,4,4).yatzy());
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void ones_scores_sum_of_all_one() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void twos_scores_sum_of_all_two() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void threes_scores_sum_of_all_three() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void fours_scores_sum_of_all_four()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives_scores_sum_of_all_five() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_scores_sum_of_all_six() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void pair_scores_sum_of_two_highest_identical_dice() {
        assertEquals(6, new Yatzy(3,4,3,5,6).pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).pair());
    }

    @Test
    public void two_pair_scores_sum_of_two_different_pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPairs());
        assertEquals(0, new Yatzy(3,5,5,5,5).twoPairs());
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_identical_dice()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKind());
    }

    @Test
    public void four_of_a_kind_scores_sum_of_four_identical_dice() {
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKind());
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
    }

    @Test
    public void small_straight_scores_sum_of_one_two_three_four_five() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void large_straight_scores_sum_of_two_three_four_five_six() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void full_house_scores_sum_of_a_pair_and_a_three_of_a_kind() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
    }
}
