package lotto.model;

import java.util.List;

import static lotto.util.LottoValidator.validateNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    /**
     * 특정 번호가 로또 번호 리스트에 포함되어 있는지 확인
     */
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    /**
     * 당첨 번호 리스트와 로또 번호 리스트의 일치 개수를 반환
     */
    public int matchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count(); //numbers에 있는 int를 loop 돌려서 winningNumbers에 포함되어있다면 개수를 셈
    }

    /**
     * 로또 번호 리스트 반환
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}
