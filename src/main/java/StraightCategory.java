public enum StraightCategory implements Category{
    SMALL,
    LARGE;

    @Override
    public int sum(Roll roll) {
        if (roll.allDifferentDie()) {
            return roll.sum();
        }
        return 0;
    }
}
