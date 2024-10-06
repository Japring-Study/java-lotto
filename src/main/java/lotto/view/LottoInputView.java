package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.util.LottoParser.parseNumbers;
import static lotto.util.LottoValidator.*;

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

    /**
     * 보너스 번호 입력 받기
     */
    public int receiveBonusNumberInput(List<Integer> winningList) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int result = Integer.parseInt(input);
        validateBonusNumber(result, winningList);
        return result;
    }


}
