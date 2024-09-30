package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {

    /**
     * 로또 구입 금액 입력 받기
     */
    public int receiveUserMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateMoneyInput(input);
        return Integer.parseInt(input);
    }

    private void validateMoneyInput(String input) {
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
     * 당첨 번호 입력 받기
     */
    public List<Integer> receiveWinningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        validateNumbers(numbers);
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
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
     * 입력 정수 리스트로 변환
     */
    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) //스페이스 제거
                .map(Integer::parseInt) //정수 변환
                .collect(Collectors.toList());
    }


    public int receiveBonusNumberInput(List<Integer> winningList) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int result = Integer.parseInt(input);
        validateBonusNumber(result, winningList);
        return result;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningList) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningList.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }
}
