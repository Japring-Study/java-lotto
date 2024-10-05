package lotto.util;

import java.util.List;

public class LottoValidator {

    private LottoValidator() {
        // 객체 생성 방지
    }

    /**
     * 구입 금액 검증
     */
    public static void validateMoneyInput(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) { //숫자가 아닐 경우
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력하세요.");
        }
    }

    /**
     * 로또 번호 리스트 검증
     */
    public static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 보너스 번호 검증
     */
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningList) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningList.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }
}
