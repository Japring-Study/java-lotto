package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCounts(numbers);
        validateDuplication(numbers);
    }

    private void validateCounts(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되어선 안됩니다.");
        }
    }

    public int calculateRank(List<Integer> answers, int bonus) {

        Set<Integer> set = new HashSet<>(numbers);

        int correct = (int) answers.stream()
                .filter(set::contains)
                .count();

        int bonusCorrect = set.contains(bonus) && correct == 5 ? 1 : 0;

        return rankByCondition(correct, bonusCorrect);
    }

    private int rankByCondition(int correct, int bonusCorrect) {
        if (correct == 6) {
            return 1;
        }

        if (correct + bonusCorrect <= 2) {
            return 6;
        }

        return 8 - (correct + bonusCorrect);
    }

}
