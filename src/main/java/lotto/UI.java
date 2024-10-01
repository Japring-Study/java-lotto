package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UI {

    private static final Map<Integer, String> resultOutputByRank = Map.of(
            1, "6개 일치 (2,000,000,000원)",
            2, "5개 일치, 보너스 볼 일치 (30,000,000원)",
            3, "5개 일치 (1,500,000원)",
            4, "4개 일치 (50,000원)",
            5, "3개 일치 (5,000원)"
    );

    public static String receivePurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printBoughtLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static List<Integer> receiveAnswers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] split = Console.readLine().split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int receiveBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printResult(List<Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (int index = 4; index >= 0; index--) {
            System.out.println(resultOutputByRank.get(index + 1) + " - " + result.get(index) + "개");
        }
    }

    public static void printRate(BigDecimal rate) {
        System.out.println("총 수익률은 " + rate.toPlainString() + "%입니다.");
    }

    public static void handlingIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
