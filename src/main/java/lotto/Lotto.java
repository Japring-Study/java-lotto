package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     */
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    /**
     *
     */
    public int matchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count(); //numbers에 있는 int를 loop 돌려서 winningNumbers에 포함되어있다면 개수를 셈
    }
}
